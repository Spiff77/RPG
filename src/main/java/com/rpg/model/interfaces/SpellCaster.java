package com.rpg.model.interfaces;

import java.util.List;

import com.rpg.model.creatures.Being;

public interface SpellCaster {
	public void spellCast(Being beings);
	public void spellCast(List<Being> beings);
}
