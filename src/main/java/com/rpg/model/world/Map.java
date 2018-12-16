package com.rpg.model.world;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.rpg.model.creatures.SpacialElement;

public class Map {

	public static final int MAP_WIDTH = 30;
	public static final int MAP_HEIGHT = 30;
	private GroundNode[][] grid = new GroundNode[MAP_WIDTH][MAP_HEIGHT];
	// public GroundNode[][] nodes = new GroundNode[MAP_WIDTH][MAP_HEIGHT];

	
	public Map() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				GroundNode gn = new GroundNode(i, j, GroundType.Grass);
			    gn.setHeuristicCost(Math.abs(i-MAP_WIDTH) + Math.abs(j-MAP_HEIGHT));
				grid[i][j] = gn;
			    System.out.print(gn.getHeuristicCost()+"-");
			}
			// System.out.println();
		}
	}

	public void printNode() {
		for (GroundNode[] elemsx : grid) {
			for (GroundNode elemy : elemsx) {
				System.out.print((elemy == null) ? '_' : elemy.getGroundType().getRepresentation());
			}
			System.out.println();
		}
	}
	public void printSpacialElementsNode(List<SpacialElement> elems) {
		char[][] seList = new char[MAP_WIDTH][MAP_HEIGHT];

		for (SpacialElement e : elems) {
			seList[e.getPosition().getX() - 1][e.getPosition().getY() - 1] = e.getCharRepresentation();
		}
		for (int i = seList.length - 1; i >= 0; i--) {
			for (char elemy : seList[i]) {
				System.out.print((elemy == '\u0000') ? '_' : elemy);
			}
			System.out.println();
		}
	}
	public GroundNode[][] getGrid() {
		return grid;
	}
	
	
	public void setGrid(GroundNode[][] grid) {
		this.grid = grid;
	}
	@Override
	public String toString() {
		return "Map [map=" + Arrays.toString(grid) + "]";
	}



}
