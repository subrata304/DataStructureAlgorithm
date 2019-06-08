package com.interview.Graph;

import java.util.Iterator;
import java.util.Stack;

/*
 * https://www.geeksforgeeks.org/topological-sorting/
 * 
 * Time Complexity: The above algorithm is simply DFS with an extra stack. 
 * So time complexity is same as DFS which is O(V+E).
 * 
 */
public class TopologicalSorting {

	static Graph graph;
	
	public static void topologicalSortUtil(int v, boolean visited[], Stack stack) {
		// Mark the current node as visited.
		visited[v] = true;
		Integer i;

		// Recur for all the vertices adjacent to this
		// vertex
		Iterator<Integer> it = graph.getAdjacent()[v].iterator();
		while (it.hasNext()) {
			i = it.next();
			if (!visited[i])
				topologicalSortUtil(i, visited, stack);
		}

		// Push current vertex to stack which stores result
		stack.push(new Integer(v));
	}

	// The function to do Topological Sort. It uses
	// recursive topologicalSortUtil()
	public static void topologicalSort() {
		Stack stack = new Stack();

		// Mark all the vertices as not visited
		boolean visited[] = new boolean[graph.getVertices()];
		for (int i = 0; i < graph.getVertices(); i++)
			visited[i] = false;

		// Call the recursive helper function to store
		// Topological Sort starting from all vertices
		// one by one
		for (int i = 0; i < graph.getVertices(); i++)
			if (visited[i] == false)
				topologicalSortUtil(i, visited, stack);

		// Print contents of stack
		while (stack.empty() == false)
			System.out.print(stack.pop() + " ");
	}

	// Driver method
	public static void main(String args[]) {
		// Create a graph given in the above diagram
		Graph g = new Graph(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		
		graph = g;

		System.out.println("Following is a Topological " + "sort of the given graph");
		TopologicalSorting.topologicalSort();
	}
}
