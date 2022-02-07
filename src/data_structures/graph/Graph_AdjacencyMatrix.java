package data_structures.graph;

public class Graph_AdjacencyMatrix {
	
	public class Graph {
		
		private int V;
		public int[][] adjacencyMatrix ;
		private boolean isDirected;
		
		public Graph(int V, boolean isDirected){
			adjacencyMatrix = new int[V][V];
			this.V = V;
			this.isDirected = isDirected;
		}
		
		public void addEdge(int source,int destination) {
			adjacencyMatrix[source][destination]= 1;
			if(!isDirected)
				adjacencyMatrix[destination][source]= 1;	
		}
		
		
	}
	
	
	public void test() {
		
		/**    4    1
		 *       \ / 
		 *        0
		 *       / \
		 *     3    2
		 * 
		 *     0 1 2 3
		 *   0 1 1 1 1
		 *   1 1  
		 *   2
		 *   3
		 *   
		 */  
		
		
		
		int V=5;
		Graph graph = new Graph(V, false);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		
	}

}
