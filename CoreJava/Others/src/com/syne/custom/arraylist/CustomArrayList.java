package com.syne.custom.arraylist;


public class CustomArrayList implements CustomList {

	private static final int DEFAULT_CAPACITY = 10;
	
	private static final Object[] EMPTY_DATA = {};
	
	private int size;
	
	private Object[] elementData;
	
	public CustomArrayList() {
		this.elementData = EMPTY_DATA;
	}

	public CustomArrayList(int capacity) {
		if(capacity > 0){
			this.elementData = new Object[capacity];
		} else if(capacity == 0){
			this.elementData = EMPTY_DATA;
		} else {
			throw new IllegalArgumentException("Illegal capacity "+ capacity);
		}
	}
	
  private void ensureCapacityInternal(int minCapacity) {
        if (elementData == EMPTY_DATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }

        if((minCapacity - elementData.length) > 0){
        	grow(minCapacity);
        }
   }
	
  private void grow(int minCapacity){
	  
  }
	
	@Override
	public void add(Object obj) {
		//ensureCapacityInternal(size + 1);  // Increments modCount!!
		elementData[size++] = obj;
        //return true;
	}

	@Override
	public boolean remove(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contain(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
