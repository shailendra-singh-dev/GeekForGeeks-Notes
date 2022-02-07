package problems.graph;

import java.util.HashMap;
import java.util.HashSet;

import data_structures.graph.Graph_AdjacencyList;
import data_structures.graph.Graph_AdjacencyList.Graph;
import data_structures.graph.Graph_AdjacencyMatrix;

/**
 * https://leetcode.com/discuss/interview-question/1408211/3-dfs-for-graphs
 * https://www.baeldung.com/java-depth-first-search
 * 
 * @author ShSingh
 *
 */
public class DFSUsingHashSet {

	// Using HashSet.
	private HashSet<Integer> visited = new HashSet<>();
	private static final int V = 5;
	private Graph graph= new Graph_AdjacencyList().new Graph(V, false);
//	private Graph graph_AdjacencyMatrix= new Graph_AdjacencyMatrix().new Graph(V, false);
	
	private boolean hasDFSPath(int  sourceNode, int destinationNode) {
		if (visited.contains(sourceNode)) {
			return false;
		}
		visited.add(sourceNode);
		if (sourceNode == destinationNode) {
			return true;
		}
		for (int child : graph.getNeighbours(sourceNode)) {
			if (hasDFSPath(child, destinationNode)) {
				return true;
			}
		}
		return false;
	}
	
	public void dfsTraversal(int sourceNode) {
		System.out.println(sourceNode);
		if(visited.contains(sourceNode)) {
			return;
		}
		visited.add(sourceNode);
		HashSet<Integer> adjacentNodes = graph.getNeighbours(sourceNode);
		for(int child:adjacentNodes) {
			if(!visited.contains(child))
				dfsTraversal(child);
		}
	}
	
	public void test() {
		 /**
	     *				4 - 3
	     * 				| \	|  \
	     *              0 - 1 - 2
	     *              
	     */
		
		graph.addEdge(0, 1);
	    graph.addEdge(0, 4);
	    graph.addEdge(1, 2);
	    graph.addEdge(1, 3);
	    graph.addEdge(1, 4);
	    graph.addEdge(2, 3);
	    graph.addEdge(3, 4);
	    
	    int sourceNode = 4;
		int destinationNode =2;
		System.out.println(hasDFSPath(sourceNode, destinationNode));
		
		visited.clear();
		
		dfsTraversal(0);
	}

}
