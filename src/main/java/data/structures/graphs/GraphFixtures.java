package data.structures.graphs;

public class GraphFixtures {

    public static DirectedGraph createGraph(){
        DirectedGraph graph = new DirectedGraph();
        for(int i=0;i<9;i++){
            graph.addVertex(String.valueOf(i));
        }
        graph.addEdge("0",4,"1");
        graph.addEdge("0",8,"7");

        graph.addEdge("1",8,"2");
        graph.addEdge("1",11,"7");

        graph.addEdge("2",7,"3");
        graph.addEdge("2",4,"5");

        graph.addEdge("3",14,"5");
        graph.addEdge("3",9,"4");

        graph.addEdge("5",10,"4");

        graph.addEdge("6",2,"5");
        graph.addEdge("6",6,"8");

        graph.addEdge("7",7,"8");
        graph.addEdge("7",1,"6");

        graph.addEdge("8",2,"2");
        printGraph(graph);
        return  graph;
    }

    private static void printGraph(DirectedGraph graph) {
        for(Vertex v : graph.vertexList) {
            for(Edge e : v.edgeList) {
                System.out.println(e);
            }
        }
    }
}
