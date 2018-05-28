package com.syne.java8.stream.primitive;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class PrimitiveStream {

	public void demoPrimitiveStream() {
	
		IntStream intStream = IntStream.of(1,4,6,7, 8,9,10);
		intStream.forEach(System.out::println);
		intStream = null;
		System.out.println("=================================");
		
		intStream = IntStream.iterate(1, step -> step+1).limit(5);
		intStream.forEach(System.out::println);
		intStream = null;
		System.out.println("=================================");
		intStream = IntStream.range(0, 19);
		intStream.forEach(System.out::println);
		intStream = null;
		
		System.out.println("=================================");
		intStream = IntStream.rangeClosed(0, 19);
		intStream.forEach(System.out::println);
		intStream = null;
	}
	
	public void statisticsOfIntStream() {
		IntStream intStream = IntStream.rangeClosed(1, 10);
		
		double avg = intStream.average().getAsDouble();
		System.out.println("Avg:="+avg);
		
		intStream = IntStream.rangeClosed(1, 10);
		IntSummaryStatistics intSummary = intStream.summaryStatistics();
		int max = intSummary.getMax();
		int min = intSummary.getMin();
		avg = intSummary.getAverage();
		System.out.println("Min:"+min + " max:"+max + " avg:"+avg);
		
	}
	
	public static void main(String[] args) {
		PrimitiveStream primitiveStream = new PrimitiveStream();
		//primitiveStream.demoPrimitiveStream();
		primitiveStream.statisticsOfIntStream();
	}

}
