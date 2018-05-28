package com.syne.thread.countdownlatch;

import java.util.Scanner;

public class DemoCountDownLatch {

	public DemoCountDownLatch(int numberOfPassengers) {
		SharedCab tripCab = new SharedCab(numberOfPassengers);
		Thread mainThread = new Thread(tripCab);
	//	System.out.println("before main start");
		mainThread.start();
		//System.out.println("after main start");
		//create passenger
		for(int i=0; i < numberOfPassengers; i++){
			Passenger passanger = new Passenger(tripCab, "Passenger-"+i);
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
