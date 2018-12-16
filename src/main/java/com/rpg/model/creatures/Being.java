package com.rpg.model.creatures;

public abstract class Being extends SpacialElement{

	protected int maxHealthPoint;
	protected int health;
	protected int maxManaPoint;
	protected int mana;
	protected int magicalResistance = 0;
	protected int physicalResistance = 0;

	public Being(String name, int health, int mana) {
		super();
		this.mana = mana;
		this.name = name;
		this.health = health;
		this.maxHealthPoint = health;
	}

	public Being(int health) {
		this.health = health;
		this.magicalResistance = 0;
		this.physicalResistance = 0;
	}

	public int heal(int healthPoint) {
		this.health += (this.health + healthPoint >= this.maxHealthPoint) 
				? this.maxHealthPoint
				: this.health + healthPoint;
		return this.health;
	}
	public int damage(int healthPoint) {
		this.health += (this.health - healthPoint <= 0) 
				? 0
				: this.health - healthPoint;
		return this.health;
	}

	public int getHealth() {
		return health;
	}

	public int getMagicalResistance() {
		return magicalResistance;
	}

	public void setMagicalResistance(int magicalResistance) {
		this.magicalResistance = magicalResistance;
	}

	public int getPhysicalResistance() {
		return physicalResistance;
	}

	public void setPhysicalResistance(int physicalResistance) {
		this.physicalResistance = physicalResistance;
	}

	@Override
	public String toString() {
		return "Being [health=" + health + ", magicalResistance=" + magicalResistance + ", physicalResistance="
				+ physicalResistance + "]";
	}

}
