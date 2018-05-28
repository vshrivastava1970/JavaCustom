package com.syne.java8.interface_default;

public class Son implements Mother, Father {

	public static void main(String[] args) {
		Son son = new Son();
		son.cook();
		son.runner();
		son.height();

	}

	@Override
	public void height() {
		// TODO Auto-generated method stub
		Father.super.height();
	}

}
