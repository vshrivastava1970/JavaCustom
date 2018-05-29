package com.java.threads.custom.atomic;

public class CustomAtomicInteger {

	private int currentValue;
	
	public CustomAtomicInteger(){
		this.currentValue = 0;
	}
	
	public CustomAtomicInteger(int initial){
		this.currentValue = initial;
	}
	
	public synchronized int get() {
		return this.currentValue;
	}
	
	public synchronized void set(int value) {
		this.currentValue = value;
	}
	
	
	public synchronized int increamentAndGet() {
		return ++this.currentValue;
	}
	
	public synchronized int getAndSet(int value) {
		int prevValue = this.currentValue;
		this.currentValue = value;
		return prevValue;
	}
	
	public synchronized boolean compareAndUpdate(int compareValue, int updateValue) {
		if(this.currentValue == compareValue) {
			this.currentValue = updateValue;
			return true;
		}
		
		return false;
	}
	
	public synchronized int getAndIncrement(){
      	return this.currentValue++;
	}
	
	public synchronized int decrementAndGet(){
      	return --this.currentValue;
	}
	
	/**
	 * Method return current value. And decrements current value by 1.
	 */
	public synchronized int getAndDecrement(){
      	return this.currentValue--; 	
	}

	
	@Override
	public String toString() {
      	return "CustomAtomicInteger = " + this.currentValue ;
	}  	
}
