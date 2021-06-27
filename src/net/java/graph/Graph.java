package net.java.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	private Map<Vertex, List<Vertex>> adjVertices;
	
	public Graph() {
		adjVertices = new HashMap<Vertex, List<Vertex>>();
	}

	public Graph(Map<Vertex, List<Vertex>> adjVertices) {
		super();
		this.adjVertices = adjVertices;
	}

	public Map<Vertex, List<Vertex>> getAdjVertices() {
		return adjVertices;
	}

	public void setAdjVertices(Map<Vertex, List<Vertex>> adjVertices) {
		this.adjVertices = adjVertices;
	}
	
	void addVertex(String label) {
	    adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
	}

	void removeVertex(String label) {
	    Vertex v = new Vertex(label);
	    adjVertices.values().stream().forEach(e -> e.remove(v));
	    adjVertices.remove(new Vertex(label));
	}
	
	void addEdge(String label1, String label2) {
	    Vertex v1 = new Vertex(label1);
	    Vertex v2 = new Vertex(label2);
	    adjVertices.get(v1).add(v2);
	    adjVertices.get(v2).add(v1);
	}
	
	void removeEdge(String label1, String label2) {
	    Vertex v1 = new Vertex(label1);
	    Vertex v2 = new Vertex(label2);
	    List<Vertex> eV1 = adjVertices.get(v1);
	    List<Vertex> eV2 = adjVertices.get(v2);
	    if (eV1 != null)
	        eV1.remove(v2);
	    if (eV2 != null)
	        eV2.remove(v1);
	}
	
	Graph createGraph() {
	    Graph graph = new Graph();
	    graph.addVertex("Bob");
	    graph.addVertex("Alice");
	    graph.addVertex("Mark");
	    graph.addVertex("Rob");
	    graph.addVertex("Maria");
	    graph.addEdge("Bob", "Alice");
	    graph.addEdge("Bob", "Rob");
	    graph.addEdge("Alice", "Mark");
	    graph.addEdge("Rob", "Mark");
	    graph.addEdge("Alice", "Maria");
	    graph.addEdge("Rob", "Maria");
	    return graph;
	}
	
	List<Vertex> getAdjVertices(String label) {
	    return adjVertices.get(new Vertex(label));
	}
	

	@Override
	public String toString() {
		
		for(Vertex v : adjVertices.keySet()) {
			List<Vertex> list = adjVertices.get(v);
			for(Vertex v1 : list) {
				System.out.print(v.toString() + "---" +v1.toString() + "\t ");
			}
			System.out.println();
		}
		return "" ;
	}

}
