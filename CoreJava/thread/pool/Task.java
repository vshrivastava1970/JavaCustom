package com.syne.thread.pool;

public class Task implements Runnable {
	private int taskId;
	
	public Task(int id) {
		this.taskId = id;
	}

	public void run() {
		System.out.println("Task with id="+this.taskId+" has completed");

	}

}
