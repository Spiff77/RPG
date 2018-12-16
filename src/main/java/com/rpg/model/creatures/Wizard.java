package com.rpg.model.creatures;

import java.util.List;

import com.rpg.model.interfaces.Flying;
import com.rpg.model.interfaces.SpellCaster;

public final class Wizard extends Humanoid implements Flying, SpellCaster {
	
	protected int mana;
	
	public Wizard(String name, int health, int mana, int strength,  int intelligence) {
		super(name, health, mana, strength, intelligence  );
		this.mana = mana;
		this.charRepresentation = 'W';
	}
	
	@Override
	public void spellCast(Being beings) {
		beings.damage(this.intelligence);
		
	}

	@Override
	public void spellCast(List<Being> beings) {
			beings.forEach(h -> {
				h.damage(this.intelligence / beings.size());
			});
	}
	
	
	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}
	public void takeOff() throws Exception {
		if(inAir) throw new Exception("Already in Air");
		if(!(this instanceof Flying)) throw new Exception("Object can't fly");
		this.inAir = true;
	}
	public void land() throws Exception {
		if(!inAir) throw new Exception("Already on the floor");
		if(!(this instanceof Flying)) throw new Exception("Object can't fly");
		this.inAir = false;
	}
	@Override
	public String toString() {
		return "Wizard [intelligence=" + intelligence + ", mana=" + mana + "]";
	}
}
