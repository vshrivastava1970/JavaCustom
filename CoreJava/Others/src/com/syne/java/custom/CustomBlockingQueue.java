package com.syne.java.custom;

import java.util.LinkedList;
import java.util.List;

interface CustomBlockingQ<E> {
	 
	public void put(E item) throws InterruptedException;
	
	public E take() throws InterruptedException;
}

public class CustomBlockingQueue<E> implements CustomBlockingQ<E> {
	private List<E> queue;
	private int maxLimit;
	
	public CustomBlockingQueue(int size) {
		this.maxLimit = size;
		this.queue = new LinkedList<E>();
	}
		
	@Override
	public void put(E item) throws InterruptedException {
		
		if(this.queue.size() == this.maxLimit) {
			this.wait();
		}
		
		this.queue.add(item);
		this.notifyAll();
	}

	@Override
	public E take() throws InterruptedException {

		if(this.queue.size() == 0) {
			this.wait();
		}
		
		E item = this.queue.remove(0);
		this.notifyAll();
		return item;
	}

}
