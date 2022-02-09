package model;

public class Node {
	Location loc;
	Node link;

	public Node(Location loc) {
		this.loc = loc;
	}
	
	public Node(Location loc,Node n) {
		this.loc = loc;
		this.link = n;
	}
}
