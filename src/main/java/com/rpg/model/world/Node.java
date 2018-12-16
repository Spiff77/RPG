package com.rpg.model.world;

public class Node {
	private int x;
	private int y;
	
	private int heuristicCost = 0;
	private int finalCost = 0;
	private Node parent = null;
	

	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "Node [x=" + x + ", y=" + y + "]";
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public int getHeuristicCost() {
		return heuristicCost;
	}

	public void setHeuristicCost(int heuristicCost) {
		this.heuristicCost = heuristicCost;
	}

	public int getFinalCost() {
		return finalCost;
	}

	public void setFinalColst(int finalCost) {
		this.finalCost = finalCost;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public void setFinalCost(int finalCost) {
		this.finalCost = finalCost;
	}	
	
	
}
