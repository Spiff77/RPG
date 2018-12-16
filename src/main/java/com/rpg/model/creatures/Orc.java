package com.rpg.model.creatures;

import com.rpg.model.interfaces.DistantAttacker;

public class Orc extends Humanoid implements DistantAttacker{

	public Orc(String name, int health, int mana,  int strength, int intelligence) {
		super(name, health, mana, strength, intelligence);
		this.charRepresentation = 'O';
	}

	@Override
	public void distantAttack(Humanoid d) {
		d.damage(this.strength);
	}
	
}
