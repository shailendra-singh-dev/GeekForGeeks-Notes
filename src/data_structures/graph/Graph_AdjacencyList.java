package data_structures.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;


/**
 * https://www.geeksforgeeks.org/graph-and-its-representations/
 * https://www.geeksforgeeks.org/graph-representations-using-set-hash/
 * 
 * @author ShSingh
 *
 */

public class Graph_AdjacencyList {

	public class Graph {
		
		public HashMap<Integer, HashSet<Integer>> mNeighbours;
		private boolean isDirected;
		private int V; //number for vertices.
		
		public Graph(int V, boolean isDirected) {
			mNeighbours = new HashMap<>();
			for(int i=0; i< V ;i++) {
				mNeighbours.put(i, new HashSet<>());
			}
			this.isDirected = isDirected;
			this.V = V;
		}
		
		public void addEdge(int source, int destination) {
			mNeighbours.get(source).add(destination);
			//If undirected add add edge from both sides.
			if(!isDirected) {
				mNeighbours.get(destination).add(source);
			}
		}
		
		public HashSet<Integer> getNeighbours(int node){
			return mNeighbours.get(node);
		}
		
		public boolean hasPath(int source, int destination) {
			HashSet<Integer> adjacentNodes =  mNeighbours.get(source);
			if(adjacentNodes.contains(destination)) {
				System.out.println("Edge exists b/w "+ source +" and " + destination);
				return true;
			}else {
				System.out.println("Edge does not b/w "+ source +" and " + destination);
				return false;
			}
		}
		
		public String getAdjancyListRepresentation(int v) {
			StringBuilder stringBuilder= new StringBuilder();
			for(int i=0;i < v;i++) {
				stringBuilder.append("Node=" + i);
				HashSet<Integer> adjacentNodes =  mNeighbours.get(i);
				stringBuilder.append(",AdjacentNodes=");
				stringBuilder.append(adjacentNodes);
				stringBuilder.append("\n");
			}
			return stringBuilder.toString();
		}	
	}
	
	public void test() {
		 /**
	     *				4 - 3
	     * 				| \	|  \
	     *              0 - 1 - 2
	     *              
	     */
		
		int v = 5;
		Graph graph = new Graph(v, false);
		graph.addEdge(0, 1);
	    graph.addEdge(0, 4);
	    graph.addEdge(1, 2);
	    graph.addEdge(1, 3);
	    graph.addEdge(1, 4);
	    graph.addEdge(2, 3);
	    graph.addEdge(3, 4);
	    
	   System.out.println(graph.getAdjancyListRepresentation(v));
	    
	   System.out.println(graph.hasPath(2, 1)); 
	   System.out.println(graph.hasPath(0, 3));
	   
	}

}
