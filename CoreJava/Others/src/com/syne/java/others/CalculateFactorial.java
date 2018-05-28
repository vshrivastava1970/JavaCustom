package com.syne.java.others;

public class CalculateFactorial {

	public int cauculate(int num) {
		
		int fact = 1;
		if(num > 0) {
			fact = num * cauculate(num-1);
		}
		return fact;
	}
	
	StringBuffer bs = new StringBuffer();
	
	public String reverse(String s) {
		
		if(s.length()-1 >= 0) {
			bs.append(s.charAt(s.length()-1));
			reverse(s.substring(0, s.length()-1));
		}
		
		return bs.toString();
	}
	
	public static void main(String[] args) {
		int num = 5;
		CalculateFactorial calculateFactorial = new CalculateFactorial();
		int fact = calculateFactorial.cauculate(num);
		System.out.println("Number:" + num + " Factorial Number ="+fact);
		
		String strName = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		System.out.println("String '"+strName+"' has revese '" + calculateFactorial.reverse(strName)+"'");

	}

}
