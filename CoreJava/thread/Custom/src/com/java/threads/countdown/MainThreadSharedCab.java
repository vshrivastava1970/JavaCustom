package com.java.threads.countdown;

import java.util.concurrent.CountDownLatch;

public class MainThreadSharedCab implements Runnable {

	private CountDownLatch countDownLatch;
	//private CustomCountDownLatch countDownLatch;
	
	public MainThreadSharedCab(int nPassangers) {
	
		this.countDownLatch = new CountDownLatch(nPassangers);
		//this.countDownLatch = new CustomCountDownLatch(nPassangers);
	}

	@Override
	public void run() {
		System.out.printf("\nNumber of friends planned for trip: %d",
                countDownLatch.getCount());
		try{
			this.countDownLatch.await();
			System.out.printf("\nAll friends has boarded the cab. Let's start the journey");
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
	}

	public void board(String passengerName) {
		System.out.printf("\n%s has boarded the cab",passengerName);
		this.countDownLatch.countDown();
		
	}

}
