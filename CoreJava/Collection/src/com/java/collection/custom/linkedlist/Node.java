package com.java.collection.custom.linkedlist;

public class Node<T> {

	private T data;
	Node<T> prvNode, nxtNode;
	
	public Node() {
		this.data = null;
		this.prvNode = null;
		this.nxtNode = null;
	}
	
	public Node(T data) {
		this.data = data;
		this.prvNode = null;
		this.nxtNode = null;	
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getPrvNode() {
		return prvNode;
	}

	public void setPrvNode(Node<T> prvNode) {
		this.prvNode = prvNode;
	}

	public Node<T> getNxtNode() {
		return nxtNode;
	}

	public void setNxtNode(Node<T> nxtNode) {
		this.nxtNode = nxtNode;
	}
	
	
}
