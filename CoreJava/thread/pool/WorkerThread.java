package com.syne.thread.pool;

import java.util.concurrent.LinkedBlockingQueue;

public class WorkerThread extends Thread{

	private LinkedBlockingQueue<Runnable> taskQueue;
	
	public WorkerThread(String threadName, LinkedBlockingQueue<Runnable> taskQueue) {
		super(threadName);
		this.taskQueue = taskQueue;
	}
	
	public void run(){
		Runnable task;
		while(true){
		synchronized(this.taskQueue){	
			while(this.taskQueue.isEmpty()){
				try {
					this.taskQueue.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			task = this.taskQueue.poll();
		}
			try{
				task.run();
			}catch(RuntimeException rte){}
		}
	}

}
