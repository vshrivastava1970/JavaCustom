package com.syne.java.linkedlist;

public class ReverseSinglyLinkedList<T> {
	Node<T> headNode;
	Node<T> lastNode;
	
	public void add(T element) {
		Node<T> node = new Node<T>();
		node.setValue(element);
		
		if(headNode == null) {
			headNode = node;
			headNode.setNextNode(null);
			lastNode = headNode;
		} else {
			lastNode.setNextNode(node);
			lastNode = node;
		}
	}
	
	public void traverse(Node<T> startNode) {
		while(true) {
			
			if(startNode == null) break;
			
			if(startNode.getNextNode() == null)
				System.out.println(startNode.getValue());
			else
				System.out.print(startNode.getValue() + ", ");
			
			startNode = startNode.getNextNode();
			
			
		}
	}
	
	public void reverse() {
		
		System.out.println("reverse....");
		Node<T> previousNode = null;
		Node<T> nextNode = null;
		Node<T> currentNode = this.headNode;
		
		while(currentNode != null) {
			
			nextNode = currentNode.getNextNode();
			currentNode.setNextNode(previousNode);
			previousNode = currentNode;
			currentNode = nextNode;
			
		}			
		
		traverse(previousNode);
	}
	
	public static void main(String[] args) {
		ReverseSinglyLinkedList<Integer> reverseList = new ReverseSinglyLinkedList<Integer>();
		reverseList.add(11);
		reverseList.add(12);
		reverseList.add(13);
		reverseList.add(14);
		reverseList.add(15);
		reverseList.add(16);
		
		reverseList.traverse(reverseList.headNode);
	reverseList.reverse();
	}
}

class Node<T> implements Comparable<T>{
	private T value;
	private Node<T> nextNode;
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public void setNextNode(Node<T> node) {
		this.nextNode = node;
	}
	
	public T getValue() {
		return value;
	}
	
	public Node<T> getNextNode(){
		return nextNode;
	}
	
	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}