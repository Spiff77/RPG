package com.rpg.model.creatures;

import com.rpg.model.interfaces.Moving;

public class Humanoid extends Being implements Moving{
	
	protected int strength;
	protected int intelligence;
	
	public Humanoid(String name,int health, int mana, int strength, int intelligence) {
		super(name, health, mana);
		this.strength = strength;
		this.intelligence = intelligence;
	}

	public void attack(Being b) throws Exception {
		if(b.isInAir()) {
			throw new Exception("The enemy is in air!");
		}
		b.damage(this.strength);
	}
	
	public int getStrength() {
		return strength;
	}
	public void setStrength(int Strength) {
		this.strength = Strength;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	
	@Override
	public String toString() {
		return "Humanoid [Strength=" + strength + ", health=" + health + "]";
	}

	@Override
	public int goUp(int step) {
		this.node.setY(this.node.getY() + step);
		return this.node.getY();
	}
	@Override
	public int goDown(int step) {
		this.node.setY(this.node.getY() - step);
		return this.node.getY();
	}
	@Override
	public int goRight(int step) {
		this.node.setX(this.node.getX() + step);
		return this.node.getX();
	}
	@Override
	public int goLeft(int step) {
		this.node.setX(this.node.getX() - step);
		return this.node.getX();
	}
}
