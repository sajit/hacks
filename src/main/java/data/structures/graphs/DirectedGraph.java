package data.structures.graphs;

import com.google.common.collect.ImmutableSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by skunnumkal on 7/16/14.
 */
public class DirectedGraph {

    List<Vertex> vertexList = new ArrayList<>();


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

    public boolean isConnectedGraph(){
        for(Vertex vertex : vertexList){
            if(vertex.edgeList.isEmpty() || (vertex.edgeList.size()==1 && vertex.edgeList.get(0).isSelfEdge())){
                return false;
            }

        }
        return true;
    }

    public Set<String> dfs(Vertex currentVertex,Set<String> visitedSoFar){
        //System.out.print(" " + currentVertex);
        visitedSoFar.add(currentVertex.name);

        for(Edge connectedEdge : currentVertex.edgeList){
            if(!visitedSoFar.contains(connectedEdge.to)){
                dfs(getByName(connectedEdge.to),visitedSoFar);
            }
        }
        return visitedSoFar;
    }

    public Vertex getByName(String vertexName) {

        for(Vertex vertex : vertexList){
            if(vertex.name.equals(vertexName)){
                return vertex;
            }
        }
        return null;
    }

    //TODO improve efficiency of this
    public List<Set<String>> disjointSets(){
        List<Set<String>> result = new ArrayList<>();
        Set<String> concatenatedVertexNames = new HashSet<>();

        for(Vertex vertex : vertexList){
            boolean isAlreadyVisited = concatenatedVertexNames.stream().filter(aConcatenatedVertexName -> aConcatenatedVertexName.contains(vertex.name)).count() > 0;
            if(!isAlreadyVisited){
                Set<String> connectedVertices = dfs(vertex, new HashSet<>());
                String concatNames = connectedVertices.stream().reduce("",(String s,String aVertexName) -> s + aVertexName);
                concatenatedVertexNames.add(concatNames);
                result.add(connectedVertices);
            }



        }

        return mergeSets(result);
    }

    private List<Set<String>> mergeSets(List<Set<String>> sets) {
        if(sets.size() < 2){
            return sets;
        }
        List<Set<String>> mergedResults = new ArrayList<>();
        Set<String> set1 = sets.get(0);
        Set<String> set2 = sets.get(1);
        if(hasCommon(set1, set2)){
            mergedResults.add(merge(set1,set2));

        }
        else{
            mergedResults.add(set1);
            mergedResults.add(set2);
        }
        for(int i=2;i<sets.size();i++){
            Set<String> inp = sets.get(i);
            Set<String> commonMergedSet = hasCommonWith(mergedResults,inp);
            if(commonMergedSet != null)
               commonMergedSet.addAll(inp);
            else
                mergedResults.add(inp);
        }
        return mergedResults;
    }

    private Set<String> hasCommonWith(List<Set<String>> results, Set<String> set) {
        for(Set<String> aResult : results){
            if(hasCommon(aResult,set)){
                return aResult;
            }
        }
        return null;
    }

    private Set<String> merge(Set<String> set1, Set<String> set2) {
        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);
        return union;
    }

    private boolean hasCommon(Set<String> set1, Set<String> set2) {
        Set<String> intersection  = new HashSet<>(set1);
        intersection.retainAll(set2);
        return !intersection.isEmpty();
    }


}
