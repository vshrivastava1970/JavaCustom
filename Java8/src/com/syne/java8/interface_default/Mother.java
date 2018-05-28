package com.syne.java8.interface_default;

public interface Mother {

	default void cook() {
		System.out.println("I am Cooking Expert");
	}
	
	default void height() {
		System.out.println("I am short");
	}
}
