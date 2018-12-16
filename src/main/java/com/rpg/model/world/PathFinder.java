package com.rpg.model.world;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathFinder {
	
	Node begin;
	Node end;
	Map map;
    public static final int DIAGONAL_COST = 14;
    public static final int V_H_COST = 10;
	
	boolean closed[][] = new boolean[Map.MAP_WIDTH][Map.MAP_HEIGHT];
	PriorityQueue<Node> open = getFCPriorityQueue();
	
	public PathFinder(Map map, Node begin, Node end) {
		super();
		this.begin = begin;
		this.end = end;
		this.map = map;
		this.createUnreachableMatrice();
		for (int i = 0; i < map.getGrid().length; i++) {
			for (int j = 0; j < map.getGrid()[i].length; j++) {
				GroundNode gn = map.getGrid()[i][j];
			    gn.setHeuristicCost(Math.abs(i-begin.getX()) + Math.abs(j-begin.getY()));
			    map.getGrid()[i][j] = gn;
			}
		}
	}
	
	
	public Node searchPath(){
		
		open.add(begin);
		
		Node current;
		
		while(true) {
			current = open.poll();
			if(current == null) break;
			closed[current.getX()][current.getY()] = true;
		
		  if(current.equals(map.getGrid()[end.getX()][end.getY()])){
	          break; // WIN
	      } 
		  
		  
		  Node t;  
          if(current.getX()-1>=0){
              t = map.getGrid()[current.getX()-1][current.getY()];
              checkAndUpdateCost(current, t, current.getFinalCost()+V_H_COST); 

              if(current.getY()-1>=0){                      
                  t = map.getGrid()[current.getX()-1][current.getY()-1];
                  checkAndUpdateCost(current, t, current.getFinalCost()+DIAGONAL_COST); 
              }

              if(current.getY()+1<map.getGrid()[0].length){
                  t = map.getGrid()[current.getX()-1][current.getY()+1];
                  checkAndUpdateCost(current, t, current.getFinalCost()+DIAGONAL_COST); 
              }
          } 

          if(current.getY()-1>=0){
              t = map.getGrid()[current.getX()][current.getY()-1];
              checkAndUpdateCost(current, t, current.getFinalCost()+V_H_COST); 
          }

          if(current.getY()+1<map.getGrid()[0].length){
              t = map.getGrid()[current.getX()][current.getY()+1];
              checkAndUpdateCost(current, t, current.getFinalCost()+V_H_COST); 
          }

          if(current.getX()+1<map.getGrid().length){
              t = map.getGrid()[current.getX()+1][current.getY()];
              checkAndUpdateCost(current, t, current.getFinalCost()+V_H_COST); 

              if(current.getY()-1>=0){
                  t = map.getGrid()[current.getX()+1][current.getY()-1];
                  checkAndUpdateCost(current, t, current.getFinalCost()+DIAGONAL_COST); 
              }
              
              if(current.getY()+1<map.getGrid()[0].length){
                 t = map.getGrid()[current.getX()+1][current.getY()+1];
                  checkAndUpdateCost(current, t, current.getFinalCost()+DIAGONAL_COST); 
              }  
          }
		  
		}
		return current;
	}
	
	private void createUnreachableMatrice() {
		for (int i = 0; i < map.getGrid().length; i++) {
			for (int j = 0; j < map.getGrid()[i].length; j++) {
				if(!map.getGrid()[i][j].getGroundType().isWalkable())
					closed[i][j]=true;
			}
			System.out.println(closed);
		}
	}


	private void checkAndUpdateCost(Node current, Node t, int cost) {
		if(t == null || closed[t.getX()][t.getY()])return;
		int t_final_cost = t.getHeuristicCost()+cost;
		
		boolean inOpen = open.contains(t);
        if(!inOpen || t_final_cost<t.getFinalCost()){
            t.setFinalCost(t_final_cost);
            t.setParent(current);
            if(!inOpen)open.add(t);
        }
	}
		
	private PriorityQueue<Node> getFCPriorityQueue() {
		return new PriorityQueue<Node>(new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				Node node1 = (Node) o1;
				Node node2 = (Node) o2;

				return (node1.getFinalCost() < node2.getFinalCost()) ? -1
						: (node1.getFinalCost() > node2.getFinalCost()) ? 1 : 0;
			}
		});
	}
	
	public static void printPath(Node node, Map map) {
		GroundNode[][] mapCopy =Arrays.copyOf(map.getGrid(), map.getGrid().length);

		char[][] charMatrice = map.getCharacterRepresentation();
		charMatrice = browseAndWritePathHistory(node, charMatrice);
		
		for (int i = charMatrice.length - 1; i >= 0; i--) {
			for (char elemy : charMatrice[i]) {
				System.out.print(elemy);
			}
			System.out.println();
		}		
	}
	private static char[][] browseAndWritePathHistory(Node n, char[][] map) {
		if(n.getParent() != null) {
			map[n.getX()][n.getY()] = 'P';
			n = n.getParent();
			browseAndWritePathHistory(n, map);
		}
		return map;

	}

	
	
}
