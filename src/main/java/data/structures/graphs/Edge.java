package data.structures.graphs;

/**
 * Created by skunnumkal on 7/16/14.
 */
public class Edge {

    public String from,to;
    public int weight;

    public Edge(String from,int weight,String to){
        this.from = from;
        this.weight = weight;
        this.to = to;
    }
}
