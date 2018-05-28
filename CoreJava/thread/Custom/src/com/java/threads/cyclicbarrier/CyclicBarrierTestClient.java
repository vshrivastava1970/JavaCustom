package com.java.threads.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTestClient {
	
	public static void main(String[] args) {
		FinalComputation test = new FinalComputation();
        
        Thread t1 = new Thread(test);
        t1.start();

	}
}

//Thread to compute final result 
class FinalComputation implements Runnable{
	private CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
	//private CustomCyclicBarrier cyclicBarrier = new CustomCyclicBarrier(3);
	
	@Override
	public void run() {
		ComputaionOne threadOne = new ComputaionOne(cyclicBarrier);
		ComputationTwo threadTwo = new ComputationTwo(cyclicBarrier);
		
		System.out.println("Number of parties required to trip the barrier = "+
				cyclicBarrier.getParties());
		System.out.println("Sum of product and sum = " + (threadOne.getResult() + 
		        		threadTwo.getResult()));
		        
		Thread t1 = new Thread(threadOne, "Thraed-One");
		t1.start();
		
		
		Thread t2 = new Thread(threadTwo, "Thraed-Two");
		t2.start();
		
		try {
			cyclicBarrier.await();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// barrier breaks as the number of thread waiting for the barrier
        // at this point = 3
        System.out.println("Sum of product and sum = " + (threadOne.getResult() + 
        		threadTwo.getResult()));
                 
        // Resetting the cyclicBarrier
        cyclicBarrier.reset();
        System.out.println("Barrier reset successful");
	}
	
}

//Thread to compute part1 result
class ComputaionOne implements Runnable{
	private CyclicBarrier cyclicBarrier;
	//private CustomCyclicBarrier cyclicBarrier;
	
	private int result;
	
	public int getResult() {
		return result;
	}

	public ComputaionOne(CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;
	}
	
	/*public ComputaionOne(CustomCyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;
	}*/
	
	@Override
	public void run() {
		System.out.println("Thraed Name: "+Thread.currentThread().getName());
		
		try {
			result = 2 * 3;
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

//Thread to compute part2 result
class ComputationTwo implements Runnable{

	private CyclicBarrier cyclicBarrier;
	//private CustomCyclicBarrier cyclicBarrier;
	private int result;
	
	public ComputationTwo(CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;
	}
	
	/*public ComputationTwo(CustomCyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;
	}*/
	
	public int getResult() {
		return result;
	}
	@Override
	public void run() {
		System.out.println("Thraed Name: "+Thread.currentThread().getName());
				
		try {
			Thread.sleep(3000);
			result = 10 + 20;
			cyclicBarrier.await();
			/*try {
				cyclicBarrier.await(3000, TimeUnit.MILLISECONDS);
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}