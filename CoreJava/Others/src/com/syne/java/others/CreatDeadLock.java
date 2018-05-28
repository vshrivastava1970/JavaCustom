package com.syne.java.others;

public class CreatDeadLock implements Runnable {
	Integer a = 5;
	Integer b = 6;
	
	boolean flag = true;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
				if(flag) {
					flag = false;
					add();
				} else {
					flag = true;
					substract();
				}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int add() throws InterruptedException {
		int s = 0;
		synchronized(a) {
			System.out.println(Thread.currentThread().getName() + " called add");
			Thread.sleep(2000);
			s = a+b;
			System.out.println(Thread.currentThread().getName() + " WAITING to ENTER substract()");
			substract();
		}
		
		return s;
	}
	
	public int substract() throws InterruptedException {
		int s = 0;
		synchronized(b) {
			System.out.println(Thread.currentThread().getName() + " called substract");
			Thread.sleep(2000);
			s = a-b;
			System.out.println(Thread.currentThread().getName() + " WAITING to ENTER add()");
			add();
		}
		
		return s;
	}
	public static void main(String[] args) {
		CreatDeadLock creatDeadLock1 = new CreatDeadLock();
		Thread thread1 = new Thread(creatDeadLock1, "Thread1");
		Thread thread2 = new Thread(creatDeadLock1, "Thread2");
		
		thread1.start();
		thread2.start();
		
	}

}
