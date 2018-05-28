package com.java.threads.custom.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;

public class CustomCyclicBarrier {

	private int initialParties;
	private int awaitedParties;
	private Runnable cyclicBarrrierEvent; 
	
	public CustomCyclicBarrier(int parties) {
		this.initialParties = parties;
		this.awaitedParties = parties;
	}
	
	public CustomCyclicBarrier(int parties, Runnable cyclicBarrrierEvent) {
		this(parties);
		this.cyclicBarrrierEvent = cyclicBarrrierEvent;
	}
	
	public synchronized void await() throws InterruptedException, BrokenBarrierException{
		this.awaitedParties--;
		
		if(this.awaitedParties > 0) {
			this.wait();
		}else {
			/* All parties have arrive, make partiesAwait equal to initialParties,
            so that CyclicBarrier could become cyclic. */
			this.awaitedParties = this.initialParties;
			
			this.notifyAll(); //notify all waiting threads
			
			//---- not in use ---- cyclicBarrrierEvent.run(); //launch event
		}
	}
	
	public void reset() {
		this.awaitedParties = this.initialParties;
		//this.notifyAll();
	}
	
	public int getParties() {
		return this.initialParties;
	}
}
