package it.unibo.generics.graph.impl;

import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

import it.unibo.generics.graph.api.Graph;


public class GraphImpl<N> implements Graph<N> {

    private Map<N,Set<N>> graph = new HashMap<>();

    public void addNode(N node){
        if(graph.isEmpty() || graph.get(node) == null && node != null){
            graph.put(node,new HashSet<N>());

        }

    }

    public void addEdge(N source, N target){
        if(source != null 
        && target != null 
        && graph.get(source) != null){

            graph.get(source).add(target);

        }
    }

    public Set<N> nodeSet(){
        Set<N> allnodes = new HashSet<>();

        for(N node : graph.keySet()){
            allnodes.add(node);
        }
         return allnodes;

    }

    public Set<N> linkedNodes(N node){

        Set<N> adjacentNodes = new HashSet<>();

        if(graph.get(node) != null){
          for(N nodes : graph.get(node)){
            adjacentNodes.add(nodes);
          }
        }
         return adjacentNodes;
    }


    public List<N> getPath(N source, N target){

        List<N> currentpath = new ArrayList<>();
        Queue<List<N>> queue = new LinkedList<>();
        List<N> visited = new ArrayList<>();
        N tempNode;

        if(graph.containsKey(source) && graph.containsKey(target)){

            
            currentpath.add(source);
            queue.add(currentpath);
            visited.add(source);

       
            while(!queue.isEmpty()){
            
            List<N> temp = new ArrayList<>(queue.poll());
            currentpath = temp;
            tempNode = temp.get(temp.size()-1);
            
            if(tempNode.equals(target) ){
                return currentpath;
            }

            
            
            for (N node : linkedNodes(tempNode)) {
                if(!visited.contains(node)){
                visited.add(node);
                List<N> tempPath = new ArrayList<>(currentpath);
                tempPath.add(node);
                queue.add(tempPath);
                }              
            }
        }
        return Collections.emptyList();

        }
       return Collections.emptyList();
    }
}