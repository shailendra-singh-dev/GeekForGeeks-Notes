package data_structures.graph;

import java.util.LinkedList;

public class Node {
	
	private int id;
	public LinkedList<Node> adjacentNodes = new LinkedList<>();
	 
	public Node (int id) {
		this.id= id;
	}
	
	@Override
	public boolean equals(Object obj) {
		Node node = (Node) obj;
		return id == node.id;
	}
	
}
