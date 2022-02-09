package controller;

import controller.TimeListner.EventType;

public class Node {
	EventType type;
	Node link;
	
	public Node(EventType event) {
		this.type=event;
	}

}
