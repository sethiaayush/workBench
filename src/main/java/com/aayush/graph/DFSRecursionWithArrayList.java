package com.aayush.graph;

import java.util.ArrayList;
import java.util.List;

public class DFSRecursionWithArrayList {

	
	public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> traversed = new ArrayList<>();
        
        performDFS(0,adj,visited,traversed);
        
        return traversed;
        
    }
    
    public void performDFS(int V, ArrayList<ArrayList<Integer>> adj , boolean[] visited , List<Integer> traversed){
        
        if(visited[V]){
            return;
        }
        visited[V] = true;
        traversed.add(V);
        for(Integer at : findNeighbour(V, adj)) {
        	performDFS(at, adj, visited, traversed);
        }
    }
    
    
    public ArrayList<Integer> findNeighbour(int neighbourOf, ArrayList<ArrayList<Integer>> adj){
        return adj.get(neighbourOf);
    }
}
