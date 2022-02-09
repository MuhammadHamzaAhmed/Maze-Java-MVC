package controller;

import controller.TimeListner.EventType;

public class LinkedList {
	Node head;
	
	public void create(EventType event) {
		if(head == null)
			head = new Node(event); 
		else {
			Node n =head;
			while(n.link!=null)
				n=n.link;
			n.link=new Node(event);
		}
	}
	
	public void removeFirst() {
		head = head.link;
	}
	
	public EventType getFirst() {
		return head.type;
	}
	
	public boolean isEmpty() {
		if(head == null)
			return true;
		return false;
	}
}
