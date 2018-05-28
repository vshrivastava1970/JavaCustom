package com.syne.java.lru;

public class Node{
    int key;
    int value;
    Node pre;
    Node next;
 
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
    
    public String toString() {
    	StringBuffer sb = new StringBuffer("key :");
    	sb.append(key);
    	sb.append(" Value=");
    	sb.append(value);
    	if(pre != null) {
    		sb.append(" Pre.value=");
    		sb.append(pre.value);
    	}else {
    		sb.append(" Pre=");
    		sb.append("null");
    	}
    	
    	if(next != null) {
    		sb.append(" next.value=");
    		sb.append(next.value);
    	}else {
    		sb.append(" next=");
    		sb.append("null");
    	}
    	
    	return sb.toString();
    }
}