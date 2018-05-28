package com.syne.java.lru;

public class LRUClient {

	public static void main(String[] args) {
		LRUCache cache =new LRUCache(5);
		
		for (int i = 1; i <= 5; i++) {
			cache.set(i, i*10);
		}
		cache.toString();
		System.out.println("cache.get(1)="+cache.get(1));
		//Node node = new Node(1,60);
		//cache.set(44, 20);
		//System.out.println("-------------------------------");
		System.out.println("-------------------------------");
		cache.toString();
		
	}
	
}
