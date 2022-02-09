package model;

import model.Interface.Stack;

public class StackLinkedList implements Stack {
	private Node top;

	@Override
	public void push(Location l) {
		top = new Node(l, top);
	}

	@Override
	public Location pop() {
		if (isEmpty()) {
			return null;
		} else {
			Location loc=top.loc;
			top = top.link;
			return loc;
		}
	}

	@Override
	public boolean isEmpty() {
		if(top == null)
			return true;
		return false;
	}

}
