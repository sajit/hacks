package data.structures.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by skunnumkal on 7/16/14.
 */
public class DirectedGraph {

    List<Vertex> vertexList = new ArrayList<Vertex>();


    public void addVertex(String vertexName){
        if(vertexName == null){
            throw new IllegalArgumentException("Null vertex");
        }
        Vertex newVertex = Vertex.of(vertexName);
        if(!vertexList.contains(newVertex)){
            vertexList.add(newVertex);
        }

    }

    public void addEdge(String fromVertex,int edgeWeight,String toVertex){
        Vertex from = Vertex.of(fromVertex);
        if(!vertexList.contains(from) || !vertexList.contains(Vertex.of(toVertex))){
            throw new IllegalArgumentException("One or more of the vertices does not exist");
        }
        for(Vertex aVertex : vertexList){
            if(aVertex.equals(from)){
                aVertex.addEdge(edgeWeight,toVertex);
            }
        }

    }

    public List<Vertex> getConnected(String fromVertex){
        Vertex from = Vertex.of(fromVertex);
        for(Vertex aVertex : vertexList){
            if(aVertex.equals(from)){
                List<Vertex> result = new ArrayList<Vertex>();
                List<Edge> connectedEdges = aVertex.edgeList;
                for(Edge edge : connectedEdges){
                    result.add(Vertex.of(edge.to));
                }
                return result;
            }
        }

        return null;
    }


}
