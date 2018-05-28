package com.syne.thread.countdownlatch;

public class Passenger implements Runnable {
	
	private SharedCab cab;
	private String passengerName;
	
	public Passenger(SharedCab cab, String passengerName) {
		this.cab = cab;
		this.passengerName = passengerName;
	}

	@Override
	public void run() {
		int arriveTime = (int)Math.random()*20000;
		//System.out.println("arriveTime ="+arriveTime);
		try{
		Thread.sleep(arriveTime);
		cab.board(this.passengerName);
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
		
		
	}

}
