package com.syne.java8.concatstring;
import java.util.StringJoiner;


public class ConcatString {

	
	public ConcatString() {
		// TODO Auto-generated constructor stub
	}
	public void joinStringUsingJava8(String delemeter, String[] strs){
		
		StringJoiner sj =new StringJoiner(delemeter, "[", "]");
		for (String s : strs) {
			sj.add(s);
		}
		System.out.println(sj.toString());
	}
	
	public void joinStringUsingOldJavaVersion(String s1, String s2){
		
		//Using + operator
		System.out.println("1. Using + operator:");
		String s = s1+s2;
		System.out.println(s);
		s = s1+" "+s2;
		System.out.println(s);
		
		//Using String concat method
		System.out.println("2. Using String concat method:");
		s = s1.concat(s2);
		System.out.println(s);
		s = s1.concat(" ").concat(s2);
		System.out.println(s); 
		
		//Using String format
		System.out.println("3. Using String format:");
		String[] ss = {s1, s2}; 
		s = String.format("%s %s", ss);
		System.out.println(s);
		
		
		//Using StringBuilder
		System.out.println("4. Using StringBuilder:");
		StringBuilder builder = new StringBuilder();
		builder.append(s1);
		builder.append(" ");
		builder.append(s2);
		System.out.println(builder.toString());
		
		//Using String join method
		System.out.println("5. Using String join method:");
		s = String.join(" ", ss);
		System.out.println(s);
	}
	public static void main(String[] args) {
		ConcatString cs = new ConcatString();
		//cs.joinStringUsingOldJavaVersion("Hello", "World");
		String[] sArray = {"Hello", "World", "!", "How", "are", "you..."};
		cs.joinStringUsingJava8(" ", sArray);
	}

}
