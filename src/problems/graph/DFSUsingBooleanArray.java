package problems.graph;

import data_structures.graph.Graph_AdjacencyList;
import data_structures.graph.Graph_AdjacencyMatrix;
import data_structures.graph.Graph_AdjacencyMatrix.Graph;

/**
 * https://leetcode.com/discuss/interview-question/1408211/3-dfs-for-graphs
 * https://www.baeldung.com/java-depth-first-search
 * @author ShSingh
 *
 */
public class DFSUsingBooleanArray {

	private static final int V = 5;
	private Graph graph= new Graph_AdjacencyMatrix().new Graph(V, false);
	
	public boolean hasDFSPath(int source, int destination) {
		boolean[] visited = new boolean[V];
		return hasDFSPath(source, destination, visited);
	}
	
	private boolean hasDFSPath(int source, int destination,boolean[] visited) {
		if(source ==destination) {
			return true;
		}
		System.out.println(source + " ");
		visited[source] = true;
		int[] adjacentMatrix = graph.adjacencyMatrix[source];
		for(int node:adjacentMatrix) {
			if(!visited[node] && hasDFSPath(node,destination,visited)) {
				return true;
			}
		}
		return false;		
	}	
	
	public void dfsTravsersal(int source) {
		boolean[] visited = new boolean[V];
		dfsTravsersal(source, visited);
	}
	
	private void dfsTravsersal(int source,boolean[] visited ) {
		System.out.println(source + " ");
		visited[source] = true;
		int[] adjacencyMatrix = graph.adjacencyMatrix[source];
		for(int i=0;i< adjacencyMatrix.length;i++) {
			if(adjacencyMatrix[i] == 1 && (!visited[i]))
				dfsTravsersal(i,visited);
		}
	}
	
	
	public void test() {
		
		/**    4    1
		 *       \ / 
		 *        0
		 *       / \
		 *     3    2
		 * 
		 */
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		
		int source =1;
		int destination =3;
		System.out.println("hasDFSPath():" + hasDFSPath(source,destination));
		
//		dfsTravsersal(0);
		
	}
}
