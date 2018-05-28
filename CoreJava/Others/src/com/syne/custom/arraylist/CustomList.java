package com.syne.custom.arraylist;


public interface CustomList {

	public void add(Object obj);
	
	public boolean remove(Object obj);
	
	public boolean remove(int index);

	public Object get(int index);
	
	public int size();
	
	public boolean isEmpty();
	
	public boolean contain(Object obj);

}
