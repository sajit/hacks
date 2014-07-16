package data.structures.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skunnumkal on 7/16/14.
 */
public class Vertex {

    public final String name;

    public List<Edge> edgeList = new ArrayList<Edge>();

    public Vertex(String name){
        this.name = name;
    }

    public void addEdge(int weight,String toVertexName){
        Edge anEdge = new Edge(name,weight,toVertexName);
        edgeList.add(anEdge);
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Vertex)){
            return false;
        }
        Vertex that = (Vertex)obj;
        return that.name.equals(name);
    }

    @Override
    public int hashCode(){
        return name.hashCode();
    }

    public static Vertex of(String name) {
        return new Vertex(name);
    }
}
