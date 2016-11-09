package data.structures.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Dijkstra {

    public static int shortestPath(DirectedGraph graph,Vertex start,Vertex dest){
        Set<Vertex> unvisited = new HashSet<>();
        Map<Vertex,Integer> distances = new HashMap<>();
        Vertex current = start;
        init(graph, start, unvisited, distances);
        while(current != null && !current.equals(dest)){
            for(Vertex neighbor : graph.getConnected(current.name)){
                if(unvisited.contains(neighbor)){
                    int neighborDistViaCurrent = distances.get(current) + current.getWeightTo(neighbor.name);
                    int neighborDist = distances.get(neighbor);
                    distances.put(neighbor,Math.min(neighborDist,neighborDistViaCurrent));
                }
            }
            unvisited.remove(current);
            current = getSmallest(distances,unvisited);
        }



        return distances.get(dest);
    }

    private static Vertex getSmallest(Map<Vertex, Integer> distances, Set<Vertex> unvisited) {
        Vertex smallest = null;
        int smallestDist = Integer.MAX_VALUE;

        for(Vertex vertex : distances.keySet()){
            if(unvisited.contains(vertex)){
                int distance = distances.get(vertex);
                if(distance <smallestDist){
                    smallestDist = distance;
                    smallest = vertex;
                }
            }
        }
        return smallest;
    }

    private static void init(DirectedGraph graph, Vertex start, Set<Vertex> unvisited, Map<Vertex, Integer> distances) {
        for(Vertex v : graph.vertexList){
            if(v.equals(start)){
                distances.put(v,0);
            }
            else{
                distances.put(v,Integer.MAX_VALUE);
                unvisited.add(v);
            }
        }
    }

    public static void main(String[] args){
        DirectedGraph graph = GraphFixtures.createGraph();

        System.out.println("Shorted distance between 0 and 4 = " + shortestPath(graph,graph.getByName("0"),graph.getByName("4")));

        System.out.println("Shortest distance between 0 and 8 = " + shortestPath(graph,graph.getByName("0"),graph.getByName("8")));

    }
}
