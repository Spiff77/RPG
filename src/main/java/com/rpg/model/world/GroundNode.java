package com.rpg.model.world;

public class GroundNode extends Node{
	
	private GroundType groundType;
	public GroundNode(int x, int y, GroundType groundType) {
		super(x,y);
		this.groundType = groundType;

	}
	public GroundType getGroundType() {
		return groundType;
	}
	
	public void setGroundType(GroundType groundType) {
		this.groundType = groundType;
	}
	
}
