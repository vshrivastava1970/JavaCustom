package com.java.threads.custom.locks;

public interface CustomLock {

	public void lock();
	public void unlock();
	public boolean tryLock();
}
