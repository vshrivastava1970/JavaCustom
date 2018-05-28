package com.syne.java8.interface_default;

public interface Father {

	default void runner() {
		System.out.println("I am Marathon Champion");
	}
	
	default void height() {
		System.out.println("I am tall");
	}
	
}
