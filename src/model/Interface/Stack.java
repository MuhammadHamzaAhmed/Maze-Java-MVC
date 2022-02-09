package model.Interface;

import model.Location;

public interface Stack {
	public void push(Location l);
	public Location pop();
	public boolean isEmpty();
}
