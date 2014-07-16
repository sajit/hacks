package data.structures.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by skunnumkal on 7/16/14.
 */
public class DirectedGraph {

    Set<Vertex> vertexList = new HashSet<Vertex>();


    public void addVertex(String vertexName){
        if(vertexName == null){
            throw new IllegalArgumentException("Null vertex");
        }
        vertexList.add(new Vertex(vertexName));
    }

    public void addEdge(String fromVertex,int edgeWeight,String toVertex){
        Vertex from = Vertex.of(fromVertex);
        if(!vertexList.contains(from) || !vertexList.contains(Vertex.of(toVertex))){
            throw new IllegalArgumentException("One or more of the vertices does not exist");
        }

        from.addEdge(edgeWeight,toVertex);

        vertexList.add(from);

    }

    public List<Vertex> getConnected(String fromVertex){
        Vertex from = Vertex.of(fromVertex);
        if(vertexList.contains(from)){
            List<Vertex> result = new ArrayList<Vertex>();
            for(Edge anEdge : from.edgeList){

                result.add(Vertex.of(anEdge.to));
            }
            return result;
        }
        return null;
    }


}
