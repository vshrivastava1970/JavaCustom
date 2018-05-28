package com.syne.java.custom;
interface CustomList<T> {

	void add(T element);
	
	void delete(T element);
	
	T get(int index);
	
	int size();
	
}

public class CustomArrayList<T> implements CustomList <T>{
	private static final int default_capacity = 5;
	private static final int multiplyingFactor = 2;
	
	private int size, index;
	
	private Object[] elementObj;
	
	public CustomArrayList() {
		this(default_capacity);
	}
	
	public CustomArrayList(int capacity){
		this.size = capacity;
		elementObj = new Object[this.size];
	}
	
	@Override
	public void add(T element) {
		if(index >= size ) {
			size = size*multiplyingFactor;
			elementObj = reSizeArray(size);
		}
		this.elementObj[index++] = element;
	}

	
	private Object[] reSizeArray(int newSize) {
		// TODO Auto-generated method stub
		Object[] tempElementObj = new Object[newSize];
		int count = 0;
		
		for(Object el : this.elementObj) {
			tempElementObj[count++] = el;
		}
		return tempElementObj;
	}

	@Override
	public void delete(T element) {
		int indexCount = 0;
		System.out.println("Delete - element=" + element+ " Element Type="+element.getClass());
		for(Object el : this.elementObj) {
			if(element == el) {
				delete(indexCount);
			}
			indexCount++;
		}

	}

	public void delete(int indexCount) {
		for (int idx = indexCount; idx+1 < this.index; idx++) {
				elementObj[idx] = elementObj[idx+1];
		}
		elementObj[index-1] = null;
		index--;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		if(index > this.index) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return (T)elementObj[index];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return index;
	}

}

