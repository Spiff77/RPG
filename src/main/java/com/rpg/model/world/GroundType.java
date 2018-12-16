package com.rpg.model.world;

public enum GroundType {
	
	Grass(0, true, 'g'),
	Snow(10, true, 's'),
	Sand(50, true, 'n'),
	Mountain(50, true,'m'),
	Canyon(100, false,'c'),
	Wall(100, false,'w');
	
	private int resistance;
	private boolean walkable;
	private char representation;
	
	private GroundType(int resistance, boolean walkable, char representation) {
		this.resistance = resistance;
		this.walkable = walkable;
		this.representation = representation;
	}

	public char getRepresentation() {
		return representation;
	}

	public int getResistance() {
		return resistance;
	}

	public void setResistance(int resistance) {
		this.resistance = resistance;
	}

	public boolean isWalkable() {
		return walkable;
	}

	public void setWalkable(boolean walkable) {
		this.walkable = walkable;
	}
	
	
}
