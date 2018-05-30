package com.java.collection.custom.linkedlist;

public class CustomDoubleLinkedList <T> {

	private Node<T> first;
	private int size;
	
	//append at end of list
	public boolean add(T data) {
		Node<T> newNode = new Node<>(data);
		
		if (first == null) {
			this.first  = newNode;
		} else {
			Node<T> lastNode = this.getNodeAt(size); 
			newNode.setPrvNode(lastNode);
			lastNode.setNxtNode(newNode);
		}
		this.size++;
		
		return true;
	}
	
	public void addLast(T data) {
		this.add(data);
	}
	public void addFirst(T data) {
		Node<T> newNode = new Node<>(data);
		if(this.first == null) {
			this.first = newNode;
		} else {
			newNode.setNxtNode(first);
			this.first.setPrvNode(newNode);
			this.first = newNode;
		}
		this.size++;
	}
	
	
	public boolean add(int index, T data) {
		Node<T> newNode = new Node<>(data);
		Node<T> node = this.getNodeAt(index);
		
		newNode.setNxtNode(node);
		newNode.setPrvNode(node.getPrvNode());
		
		node.getPrvNode().setNxtNode(newNode);
		node.setPrvNode(newNode);
		this.size++;
		
		return true;
	}
	
	//It returns true if the element is present in the list.
	public boolean contains(T data) {
		Node<T> temp = first;
		
		boolean flag = false;
		
		while(temp != null) {
			if(data.equals(temp.getData())) {
				flag = true;
				break;
			}
			temp = temp.getNxtNode();
		}
		
		return flag;
	}
	
	//It returns the element at the position ‘index’ in the list. 
	//It throws ‘IndexOutOfBoundsException’ if the index is out of range of the list.
	public T get(int index) throws IndexOutOfBoundsException {
		Node<T> node = this.getNodeAt(index);
		if(node != null) {
			return node.getData();
		}
		return null;
	}
	
	// If element is found, it returns the index of the first occurrence 
	// of the element. Else, it returns -1.
	public int indexOf(T data) {
		int index = 0;
		if(this.first == null) return -1;
		
		index++;
		
		if(this.first.getData() != null && 
				this.first.getData().equals(data)) {
			return index;
		}
		Node<T> temp = first;
		boolean flag = false;
		while(temp.getNxtNode() != null) {
			index++;
			temp = temp.getNxtNode();
			if(data.equals(temp.getData())) {
				flag = true;
				break;
			}
		}
		if(flag)
			return index;
		else
			return -1;
	}
	
	public T remove(int index) {
		Node<T> node = getNodeAt(index);
		System.out.println("remove@index="+index+" Data="+node.getData());
		T data = null;
		if(node != null) {
			
			if(node == first) {
				this.first = this.first.getNxtNode();
				this.first.setPrvNode(null);
			}else {
				node.getPrvNode().setNxtNode(node.getNxtNode());
				node.getNxtNode().setPrvNode(node.getPrvNode());
			}
			data =node.getData();
			this.size--;
		}
		
		return data;
	}
	
	public void remove(T data) {
		int index = indexOf(data);
		this.remove(index);
	}
	//It returns the number of elements in this list.
	public int size() {
		return this.size;
	}

	//It removes all of the elements from the list.
	void clear() {
		this.first = null;
	}
	
	private Node<T> getNodeAt(int index){
			
		if(index > size || index < 0) {
			throw new IndexOutOfBoundsException("At "+ index +" No data avialble");
		}
		Node<T> temp = first;
		
		for (int i = 1; i < index; i++) {
			temp = temp.getNxtNode();
		}
		
		return temp;
	}
	
	public String toString() {
		Node<T> temp = first;
		for (int i = 0; i < size; i++) {
			System.out.println("[ "+temp.getData()+" ]");
			if(temp.getNxtNode() != null) {
				temp = temp.getNxtNode();
			}else {
				break;
			}
		}
		return "";
	}
}
