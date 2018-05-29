package com.java.threads.custom.locks;

public class CustomReentarntLock implements CustomLock {
	private int lockHeldCount;
	private long IdOfCurrentlyHoldingLocks;
	
	@Override
	public void lock() {
		if(this.lockHeldCount == 0) {
			this.lockHeldCount++;
			this.IdOfCurrentlyHoldingLocks = Thread.currentThread().getId();
		} else if(this.lockHeldCount > 0 && 
				this.IdOfCurrentlyHoldingLocks == Thread.currentThread().getId()){
			this.lockHeldCount++;
		}else {
			// If the lock is held by another thread then the current 
			// thread waits for another thread to release the lock.
			try {
				this.wait();
				this.lockHeldCount++;
				this.IdOfCurrentlyHoldingLocks = Thread.currentThread().getId();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void unlock() {
		if(this.lockHeldCount == 0) {
			throw new IllegalMonitorStateException();
		}
		
		this.lockHeldCount--;
		
		if(this.lockHeldCount == 0) {
			this.notify();
		}
		
	}

	@Override
	public boolean tryLock() {
		//Acquires the lock if it is not held by another thread
		if(this.lockHeldCount == 0) {
			this.lock();
			return true;
		}
		//If lock is held by another thread then method return false
		return false;
	}

}
