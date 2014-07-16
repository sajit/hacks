package data.structures.graphs;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

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

}
