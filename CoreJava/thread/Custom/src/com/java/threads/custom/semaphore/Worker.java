package com.java.threads.custom.semaphore;

import com.java.threads.semaphore.CustomSemaphore;

public class Worker implements Runnable {
	//private Semaphore sem;
	private CustomSemaphore sem;
	public Worker(CustomSemaphore sem) {
		this.sem = sem;
	}
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " thread is waiting for a permit.");
			sem.acquire();
			System.out.println("\n"+Thread.currentThread().getName() + " thread gets a permit.");
			Thread.sleep(1000);
			SemaphoreTest.count++;
			System.out.println("Task: Resource count="+SemaphoreTest.count+" ...updated by Thread-"+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " releases the permit.");
		System.out.println("\n+++++++++++++++++++++++++++");
		sem.release();
	}

}
