package data.structures.graphs;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by skunnumkal on 7/16/14.
 */
public class DirectedGraphTest {

    DirectedGraph dg = new DirectedGraph();
    String a = "sorrow", b = "tomorrow", c = "goes", d = "down", e = "found";

    @Before
    public  void setup(){
        dg.addVertex(a);
        dg.addVertex(b);
        dg.addVertex(c);
        dg.addVertex(d);
        dg.addVertex(e);
        dg.addEdge(a,10,c);
        dg.addEdge(b,3,c);
        dg.addEdge(c,1,b);
        dg.addEdge(e,8,a);

    }
    @Test
    public void vertexCount(){


        assertThat(dg.vertexList.size()).isEqualTo(5);

    }

    @Test
    public void edgeCount(){
        int count = 0;
        for(Vertex vertex : dg.vertexList){
            count += vertex.edgeList.size();
        }
        assertThat(count).isEqualTo(4);
    }

    @Test
    public void getConnected(){
        assertThat(dg.getConnected(a)).isEqualTo(ImmutableList.of(Vertex.of(c)));
    }

    @Test
    public void unConnectedGraphIsNotConnected(){

        assertThat(dg.isConnectedGraph()).isFalse();
        dg.addEdge(d,10,d);
        assertThat(dg.isConnectedGraph()).isFalse();
        dg.addEdge(d,10,e);
        assertThat(dg.isConnectedGraph()).isTrue();
    }

//    @Test
//    public void testDisjoint(){
//        Set<Set<String>> disjointSets = dg.getDisjointSets();
//        for(Set<String> aDisjointSet : disjointSets){
//            System.out.println(aDisjointSet);
//        }
//        assertThat(disjointSets.size()).isEqualTo(2);
//        for(Set<String> aSet : disjointSets){
//            if(aSet.size()==4){
//                assertThat(aSet).isEqualTo(ImmutableSet.of(a, b, c, e));
//            }
//            if(aSet.size()==1){
//                assertThat(aSet).isEqualTo(ImmutableSet.of(d));
//            }
//        }
//    }

    @Test
    public void testDfs(){
        Vertex aVertex = dg.getByName(a);
        Set<String> vertices = dg.dfs(aVertex,new HashSet<>());
        assertThat(vertices).isEqualTo(ImmutableSet.of(a,b,c));
    }

}
