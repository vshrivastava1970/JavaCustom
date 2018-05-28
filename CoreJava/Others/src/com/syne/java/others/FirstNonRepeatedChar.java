package com.syne.java.others;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FirstNonRepeatedChar {

	public static void find(String str) {
		HashMap<Character, Integer> hMap = new HashMap<Character, Integer>();
		int length = str.length();
			while (length > 0) {
				Character ch = str.charAt(str.length() - length);
				if(hMap.containsKey(ch)) {
					hMap.put(ch, hMap.get(ch)+1);
				} else {
					hMap.put(ch, 1);
				}
				length--;
			}
			
		Set<Entry<Character, Integer>> hSet = hMap.entrySet();
		for(Map.Entry<Character, Integer> entry : hSet) {
			if(entry.getValue() == 1) {
				System.out.println("Key = " + entry.getKey());
				break;
			}
			
		}
	
	}
	
	public static void main(String[] args) {
		find("ababcdefefg");//ababcdefefg

	}

}
