package com.java.threads.locks;

import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {

	private final ReentrantLock lock = new ReentrantLock();
	
	private int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 final TestReentrantLock counter = new TestReentrantLock();
		 
		 Thread t1 = new Thread() {
			 @Override
	            public void run() {
	                while (counter.getCount() < 6) {
	                    try {
	                        Thread.sleep(100);
	                    } catch (InterruptedException ex) {
	                        ex.printStackTrace();                    }
	                }
	            } 
		 };
		 
		 Thread t2 = new Thread() {

	            @Override
	            public void run() {
	                while (counter.getCount() < 6) {
	                    try {
	                        Thread.sleep(100);
	                    } catch (InterruptedException ex) {
	                        ex.printStackTrace();
	                    }
	                }
	            }
	        };
	        
	        t1.start();
	        t2.start();
	}

	public int getCount() {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " gets Count: " + count);
			return this.count++;	
		}finally {
			lock.unlock();
		}
		
	}
	
	public synchronized int getSynchronizedCount() {
		return this.count++;
	}
}
