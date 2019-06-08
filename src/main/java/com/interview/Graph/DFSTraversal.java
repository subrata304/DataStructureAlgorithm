package com.interview.Graph;

import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;

public class DFSTraversal {

	public static void DFSUtil(int s, Vector<Boolean> visited, Graph g) {
		Stack<Integer> stack = new Stack<>();

		// Push the current source node
		stack.push(s);

		while (stack.empty() == false) {
			// Pop a vertex from stack and print it
			s = stack.peek();
			stack.pop();

			// Stack may contain same vertex twice. So
			// we need to print the popped item only
			// if it is not visited.
			if (visited.get(s) == false) {
				System.out.print(s + " ");
				visited.set(s, true);
			}

			// Get all adjacent vertices of the popped vertex s
			// If a adjacent has not been visited, then puah it
			// to the stack.
			Iterator<Integer> itr = g.getAdjacent()[s].iterator();

			while (itr.hasNext()) {
				int v = itr.next();
				if (!visited.get(v))
					stack.push(v);
			}

		}
	}

	public static void DFS(Graph g) {
		Vector<Boolean> visited = new Vector<Boolean>(g.getVertices());
		for (int i = 0; i < g.getVertices(); i++)
			visited.add(false);

		for (int i = 0; i < g.getVertices(); i++)
			if (!visited.get(i))
				DFSUtil(i, visited, g);
	}

	public static void main(String args[]) {
		Graph g = new Graph(4);

		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 

		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

		DFSTraversal.DFS(g);
	}
}

