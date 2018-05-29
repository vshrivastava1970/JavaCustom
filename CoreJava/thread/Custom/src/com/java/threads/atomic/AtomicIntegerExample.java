package com.java.threads.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
	private static AtomicInteger atomicInteger = new AtomicInteger();
	
	private Runnable worker = ()->{
		
		for(int i=0; i < 5; i++) {
			System.out.println("Thread "+Thread.currentThread().getName()+ " >> "+AtomicIntegerExample.atomicInteger.incrementAndGet());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};
	
	public AtomicIntegerExample() throws InterruptedException {
		 Thread thread1=new Thread(worker,"Thread-1");
         Thread thread2=new Thread(worker,"Thread-2");
         thread1.start();
         thread2.start();
         
        // Thread.sleep(1000); //delay to ensure Thread-1 and Thread-2 finish
         thread1.join();
         thread2.join();
         System.out.println("After completion of both threads, "
                      + "AtomicInteger value = "+atomicInteger);
	}
	
	public static void main(String[] args) throws InterruptedException {
		AtomicIntegerExample atomicInt = new AtomicIntegerExample();
	}

}

