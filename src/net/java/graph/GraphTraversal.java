package net.java.graph;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class GraphTraversal {
	
	public GraphTraversal() {
		System.out.println("Creating a graph");
		
		Graph gObj = new Graph();
		Graph g = gObj.createGraph();
		System.out.println(g.toString());
		System.out.println("---------------------------");
		System.out.println("Depth first traversal from Bob");
		Set<String> set = depthFirstTraversal(g, "Bob");
		for(String s : set) {
			System.out.println(s);
		}
		System.out.println("---------------------------");
		System.out.println("Breadth first traversal from Bob");
		Set<String> set2 = breadthFirstTraversal(g, "Bob");
		for(String s : set2) {
			System.out.println(s);
		}
	}
	
	public static Set<String> depthFirstTraversal(Graph graph, String root) {
	    Set<String> visited = new LinkedHashSet<String>();
	    Stack<String> stack = new Stack<String>();
	    stack.push(root);
	    while (!stack.isEmpty()) {
	        String vertex = stack.pop();
	        if (!visited.contains(vertex)) {
	            visited.add(vertex);
	            System.out.print("visited "+vertex.toString()+" ");
	            for (Vertex v : graph.getAdjVertices(vertex)) {              
	                stack.push(v.label);
	                System.out.print("pushing "+v.label + " \t ");
	            }
	            System.out.println("");
	        }
	    }
	    return visited;
	}
	
	
	public static Set<String> breadthFirstTraversal(Graph graph, String root) {
	    Set<String> visited = new LinkedHashSet<String>();
	    Queue<String> queue = new LinkedList<String>();
	    queue.add(root);
	    visited.add(root);
	    while (!queue.isEmpty()) {
	        String vertex = queue.poll();
	        System.out.println("visited "+vertex.toString()+" ");
	        for (Vertex v : graph.getAdjVertices(vertex)) {
	            if (!visited.contains(v.label)) {
	                visited.add(v.label);
	                queue.add(v.label);
	                System.out.print("adding to queue "+v.label + " \t ");
	            }
	        }
	        System.out.println("");
	    }
	    return visited;
	}

}
