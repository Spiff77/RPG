package com.rpg.entry;

import java.util.ArrayList;
import java.util.List;

import com.rpg.model.creatures.Orc;
import com.rpg.model.creatures.SpacialElement;
import com.rpg.model.creatures.Wizard;
import com.rpg.model.world.Map;
import com.rpg.model.world.Node;
import com.rpg.model.world.PathFinder;

public class Application {
	
	Map map = new Map();
	List<SpacialElement> elements= new ArrayList<SpacialElement>(); 
	
	
	public Application() {
		makeBirth();
		map.printNode();
		map.printSpacialElementsNode(this.elements);
		
		PathFinder pf = new PathFinder(map, this.elements.get(0).getPosition(), this.elements.get(5).getPosition());
		Node node = pf.searchPath();
		PathFinder.printPath(node);
	}
	
	
	
	public void makeBirth() {
		Orc o1 = new Orc("Baldruck", 100, 10, 20, 2);
		Orc o2 = new Orc("Grutz", 100, 10, 20, 2);
		Orc o3 = new Orc("Artzluch", 100, 10, 20, 2);
		
		Wizard w1 = new Wizard("Oz", 60, 60, 2, 30);
		Wizard w2 = new Wizard("Gandalf", 60, 60, 2, 30);
		Wizard w3 = new Wizard("Jean-Jacques Goldman",60, 60, 2, 30);
	
		o1.setPosition(new Node(2, 5));
		o2.setPosition(new Node(2, 15));
		o3.setPosition(new Node(2, 30));
		
		w1.setPosition(new Node(29, 4));
		w2.setPosition(new Node(29, 14));
		w3.setPosition(new Node(29, 29));
				
		elements.add(o1);
		elements.add(o2);
		elements.add(o3);
		elements.add(w1);
		elements.add(w2);
		elements.add(w3);
		
		
	}
}
