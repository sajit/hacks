package data.structures.graphs;

import java.util.*;

public class MST {

    public static DirectedGraph mst(DirectedGraph graph){
        Set<Vertex> vertexSet = new HashSet(graph.vertexList);
        Set<Vertex> addedVertices = new HashSet<>();
        Queue<Edge> edges = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        vertexSet.forEach(vertex -> {
            edges.addAll(vertex.edgeList);
        });
        DirectedGraph mstGraph = new DirectedGraph();
        while(!addedVertices.equals(vertexSet)){
            Edge edge = edges.poll();
            if(!contains(addedVertices,edge.from) || !contains(addedVertices,edge.to)){
                mstGraph.addVertex(edge.from);
                mstGraph.addVertex(edge.to);
                mstGraph.addEdge(edge.from,edge.weight,edge.to);
                addedVertices.add(graph.getByName(edge.from));
                addedVertices.add(graph.getByName(edge.to));
            }

        }
        return mstGraph;
    }

    private static boolean contains(Set<Vertex> vertices, String vertexName) {
        for(Vertex v : vertices){
            if(v.name.equals(vertexName)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        DirectedGraph graph = GraphFixtures.createGraph();
        DirectedGraph spanningTree = MST.mst(graph);
        System.out.println("# of edges" + spanningTree.getEdgeCount());
        System.out.println("Is connected graph? " + spanningTree.isConnectedGraph());
    }
}
