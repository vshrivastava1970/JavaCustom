package com.java.threads.countdown;

import java.util.Scanner;

public class DemoCountDownLatch {

	public DemoCountDownLatch(int numberOfPassengers) {
		//Main Thread
		MainThreadSharedCab mainThread_tripCab = new MainThreadSharedCab(numberOfPassengers);
		Thread mainThread = new Thread(mainThread_tripCab);
		mainThread.start();
		
		
		//create passenger
		for(int i=0; i < numberOfPassengers; i++){
			WorkerThreadPassenger passanger = new WorkerThreadPassenger(mainThread_tripCab, "Passenger-"+i);
			Thread workerThread = new Thread(passanger);
			workerThread.start();
		}
	}

	public static void main(String[] args) {
		System.out.println("Please enter the number friends ready for trip:");
		Scanner scanner = new Scanner(System.in);
		  
		DemoCountDownLatch demoCountDownLatch = new DemoCountDownLatch(scanner.nextInt());
		
	}

}
