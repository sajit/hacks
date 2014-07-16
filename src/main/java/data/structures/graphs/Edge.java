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

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Edge)){
            return false;
        }
        Edge that = (Edge)obj;
        return that.from.equals(from) && that.to.equals(to) && that.weight == weight;
    }

    @Override
    public int hashCode(){
        return from.hashCode() + to.hashCode()*weight;
    }

    @Override
    public String toString(){
        return "{"+ from + " ->" + to + " :"+weight+ "}";
    }
}
