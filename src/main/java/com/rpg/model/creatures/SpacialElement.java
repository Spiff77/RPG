package com.rpg.model.creatures;

import com.rpg.model.world.Node;

public abstract class SpacialElement {

	protected String name;
	protected Node node;
	protected boolean inAir = false;
	protected char charRepresentation;
	
	public String getName() {
		return name;
	}
	public String setName(String name) {
		return this.name = name;
	}
	public boolean isInAir() {
		return inAir;
	}

	public Node getPosition() {
		return node;
	}
	public void setPosition(Node node) {
		this.node = node;
	}
	public char getCharRepresentation() {
		return charRepresentation;
	}
	@Override
	public String toString() {
		return "SpacialElement [name=" + name + ", node=" + node + ", inAir=" + inAir + ", charRepresentation="
				+ charRepresentation + "]";
	}

}
