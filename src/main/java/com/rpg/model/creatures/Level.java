package com.rpg.model.creatures;

public enum Level {
	WEAK(.3f), LOW(.6f), MEDIUM(1f),CHALLENGING(1.5f), STRONG(2f), GODLIKE(5f);
	
	private float multiplicator;
	
	private Level(float multiplicator) {
		this.multiplicator = multiplicator;
	}
}
