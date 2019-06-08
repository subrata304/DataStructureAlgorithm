package com.interview.Graph;

import java.util.LinkedList;
import java.util.List;

public class Graph {
	private int V; // No. of vertices

	// Array of lists for Adjacency List Representation
	protected LinkedList<Integer> adj[];

	// Constructor
	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList<>();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w); // Add w to v's list.
	}
	public List<Integer>[] getAdjacent(){
		return adj;
	}
	public int getVertices() {
		return V;
	}
}