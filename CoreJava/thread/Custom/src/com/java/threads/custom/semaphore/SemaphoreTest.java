package com.java.threads.custom.semaphore;

import com.java.threads.semaphore.CustomSemaphore;

public class SemaphoreTest {
	public static int count = 0;
	
	public static void main(String[] args) {
		CustomSemaphore sem = new CustomSemaphore(1);
		//Semaphore sem = new Semaphore(1);
		for(int t = 0;t < 5; t++) {
			Worker worker = new Worker(sem);
			Thread thread = new Thread(worker, "T"+t);
			thread.start();
		}

	}

}
