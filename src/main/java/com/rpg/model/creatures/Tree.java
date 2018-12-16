package com.rpg.model.creatures;

public class Tree extends Being{
	
	public Tree(String name, int health, int mana) {
		super(name, health, mana);
	}

	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
}
