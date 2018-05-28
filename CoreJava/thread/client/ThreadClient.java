package com.syne.thread.client;

import com.syne.thread.pool.Task;
import com.syne.thread.pool.ThreadPool;

public class ThreadClient {

	public ThreadClient() {
		// TODO Auto-generated constructor stub
	}
	
	private void demoThreadPool(){
		ThreadPool threadPool = new ThreadPool(5);
		
		for (int tsk =0; tsk < 10; tsk++){
			Task task = new Task(tsk);
			threadPool.execute(task);
		}
	}

	public static void main(String [] args){
		ThreadClient threadClient = new ThreadClient();
		
		threadClient.demoThreadPool();
	}
}
