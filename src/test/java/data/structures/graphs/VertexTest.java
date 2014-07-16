package data.structures.graphs;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by skunnumkal on 7/16/14.
 */
public class VertexTest {

    @Test
    public void verticesWithSameNameAreEqual(){

        Vertex v1 = new Vertex("sorrow");
        Vertex v2 = new Vertex("sorrow");
        assertThat(v1.equals(v2)).isTrue();
        assertThat(Vertex.of("SORROW").equals(v1)).isFalse();
    }

    @Test
    public void verticesWithSameNameButDiffEdgesAreEqual(){
        Vertex v1 = new Vertex("sorrow");
        Vertex v2 = new Vertex("sorrow");
        v1.addEdge(5,"tomorrow");
        assertThat(v1.equals(v2)).isTrue();
        v2.addEdge(5,"tomorrow");
        assertThat(v1.equals(v2)).isTrue();

    }
    @Test
    public void verticesWithDiffEdgesCountNotEqual(){
        Vertex v1 = new Vertex("sorrow");
        Vertex v2 = new Vertex("sorrow");
        v1.addEdge(5,"tomorrow");
        assertThat(v1.equals(v2)).isTrue();
        v2.addEdge(5,"tomorrow");
        assertThat(v1.equals(v2)).isTrue();
        v2.addEdge(6,"tomorrow");

        assertThat(v2.edgeList.size()).isEqualTo(2);

        assertThat(v1.equals(v2)).isTrue();

        v1.addEdge(6,"tomorrow");

        assertThat(v1.equals(v2)).isTrue();

    }
}
