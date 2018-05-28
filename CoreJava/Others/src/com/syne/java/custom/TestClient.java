package com.syne.java.custom;

public class TestClient {

	
	public void testCustomArrayList() {
		CustomArrayList<Integer> cList = new CustomArrayList<>();
		System.out.println("b4 add element size="+cList.size());
		for (int i = 0; i < 11; i++) {
			cList.add(10+i);
		}
		
		printList(cList);
		cList.delete(cList.get(10));
		printList(cList);
		System.out.println(cList.get(4));
		System.out.println(cList.size());
	}
	
	private void printList(CustomArrayList<Integer> cList) {
		System.out.println("print size="+cList.size());
		for (int i = 0; i < cList.size(); i++) {
			System.out.println("Element["+i+"]="+cList.get(i));
		}
		
	}

	private void blockingQueueCustomTest() throws InterruptedException {
		CustomBlockingQueue<Integer> b=new CustomBlockingQueue<Integer>(10);
        System.out.println("put(11)");
        b.put(11);
        System.out.println("put(12)");
        b.put(12);
        System.out.println("take() > "+b.take());
        System.out.println("take() > "+b.take());
	}
	
	public static void main(String[] args) throws InterruptedException {
		TestClient testClient = new TestClient();
		testClient.testCustomArrayList();
		
		//testClient.blockingQueueCustomTest();
		

	}

}
