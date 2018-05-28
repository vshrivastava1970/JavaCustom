package com.java.threads.custom.pool;

public class ThreadClient {

	public static void main(String[] args) {
		ThreadPool pool = new ThreadPool(5);
		
		for(int tsk =0; tsk < 20; tsk++) {
			Task task = new Task();
			pool.execute(task);
		}

	}

}
