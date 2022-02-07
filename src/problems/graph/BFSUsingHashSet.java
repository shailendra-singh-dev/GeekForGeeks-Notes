package problems.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import data_structures.graph.Graph_AdjacencyList;
import data_structures.graph.Graph_AdjacencyList.Graph;

/**
 * https://www.baeldung.com/java-breadth-first-search
 * https://leetcode.com/discuss/interview-question/1408203/2-bfs-for-graphs
 * 
 * @author ShSingh
 *
 */
public class BFSUsingHashSet {

	private HashSet<Integer> visited = new HashSet<>();
	private static final int V = 5;
	private Graph graph= new Graph_AdjacencyList().new Graph(V, false);
	
	public boolean hasPath(int source, int destination) {
		Queue<Integer> nextToVisit = new LinkedList<>();
		nextToVisit.add(source);
		
		while(!nextToVisit.isEmpty()) {
			int node = nextToVisit.poll();
			if(node == destination) {
				return true;
			}
			if(visited.contains(node)) {
				continue;
			}
			visited.add(node);
			for(int child: graph.getNeighbours(node)) {
				nextToVisit.add(child);
			}
		}
		return false;
	}
	
	
	public void bfsTraversal(int source) {
		Queue<Integer> nextToVisit = new LinkedList<>();
		nextToVisit.add(source);
		visited.add(source);

		while (!nextToVisit.isEmpty()) {
			int node = nextToVisit.poll();
			System.out.print(" " + node);
			
			for (int child : graph.getNeighbours(node)) {
				if (!visited.contains(child)) {
					visited.add(child);
					nextToVisit.add(child);
				}									
			}
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
		System.out.println(hasPath(sourceNode, destinationNode));
		
		visited.clear();
		
		bfsTraversal(0);
	}
	
}
