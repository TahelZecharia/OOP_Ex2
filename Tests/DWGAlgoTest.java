import api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DWGAlgoTest {

    public static DWGraph startGraph() {
        //creat a DWGraph:
        DWGraph graph = new DWGraph();
        //creat NodeData:
        NodeData node0 = new Node(0, "1.0,2.0,0.0");
        NodeData node1 = new Node(1, "2.0,3.0,0.0");
        NodeData node2 = new Node(2, "3.0,4.0,0.0");
        NodeData node3 = new Node(3, "4.0,5.0,0.0");
        //add the nodes to graph:
        graph.addNode(node0);
        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        //connect between the nodes:
        graph.connect(0,1,1);
        graph.connect(1,2,2);
        graph.connect(2,3,3);
        graph.connect(3,0,4);

        return graph;
    }

    public static DWGAlgo startAlgo(){
        DWGraph g = startGraph();
        DWGAlgo graph = new DWGAlgo();
        graph.init(g);
        return graph;
    }

    @Test
    void init() {
    }

    @Test
    void getGraph() {
    }

    @Test
    void copy() {
    }

    @Test
    void isConnected() {
        DWGAlgo graph = startAlgo();
        System.out.println(graph);
        assertTrue(graph.isConnected());
//        NodeData node4 = new Node(4, "1.0,2.0,0.0");
//        graph.getGraph().addNode(node4);
        graph.getGraph().removeEdge(2,3);
        assertFalse(graph.isConnected());
    }

    @Test
    void shortestPathDist() {
    }

    @Test
    void shortestPath() {
    }

    @Test
    void center() {
    }

    @Test
    void tsp() {
    }

    @Test
    void save() {
    }

    @Test
    void load() {
    }

    @Test
    void BFS() {
        DWGAlgo graph = startAlgo();
        NodeData node4 = new Node(4, "1.0,2.0,0.0");
        graph.getGraph().addNode(node4);
        for (int i = 0; i < 5; i++){
            assertEquals(0, graph.getGraph().getNode(i).getTag());
        }
        graph.BFS(graph.getGraph().getNode(0), graph.getGraph());
        for (int i = 0; i < 4; i++){
            assertEquals(1, graph.getGraph().getNode(i).getTag());
        }
        //test that the new node not connect to any node
        assertEquals(0, graph.getGraph().getNode(4).getTag());
        graph.getGraph().removeEdge(2,3);
        graph.resetTag();
        graph.BFS(graph.getGraph().getNode(0), graph.getGraph());
        assertEquals(0, graph.getGraph().getNode(3).getTag());

    }

    @Test
    void transpose(){
        DWGAlgo g = startAlgo();
        DirectedWeightedGraph graph = startGraph();
        DirectedWeightedGraph transposeGraph = g.transpose(graph);
        assertEquals(graph.getEdge(0,1).getWeight(), transposeGraph.getEdge(1,0).getWeight());
        for (int i = 0; i < 4; i++){
            assertEquals(graph.getNode(i).getKey(), transposeGraph.getNode(i).getKey());
        }
        assertEquals(graph.getEdge(0,1).getWeight(), transposeGraph.getEdge(1,0).getWeight());
    }

    @Test
    void resetTag(){
        DWGAlgo graph = startAlgo();
        graph.isConnected();
        graph.resetTag();
        for (int i = 0; i < 4; i++) {
            assertEquals(0, graph.getGraph().getNode(i).getTag());
        }
    }

//    private static DirectedWeightedGraphAlgorithms ga;
//    private static DWGraph g;
//
//    @BeforeEach
//    void setUp() {
//        g = new DWGraph();
//        ga = new DWGAlgo();
//        ga.init(g);
//        for (int i = 1; i < 7; i++) {
//            g.addNode(new Node(i, "0,0,0"));
//        }
//        g.connect(1, 2, 7);
//        g.connect(1, 6, 14);
//        g.connect(1, 3, 9);
//        g.connect(2, 3, 10);
//        g.connect(2, 4, 15);
//        g.connect(3, 6, 2);
//        g.connect(3, 4, 11);
//        g.connect(4, 5, 6);
//        g.connect(5, 6, 9);
//    }
//    @Test
//    void isConnected() {
//        DirectedWeightedGraph graph = new DWGraph();
//            for (int i = 1; i < 9; i++) {
//                graph.addNode(new Node(i, "0,0,0"));
//    }
//    //https://upload.wikimedia.org/wikipedia/commons/5/5c/Scc.png
//        graph.connect(1, 2, 0.5);
//        graph.connect(2, 5, 0.7);
//        graph.connect(2, 6, 10.5);
//        graph.connect(2, 3, 0);
//        graph.connect(3, 4, 0.5);
//        graph.connect(3, 7, 3);
//        graph.connect(4, 3, 0);
//        graph.connect(4, 8, 0.5);
//        graph.connect(5, 1, 7);
//        graph.connect(5, 6, 5.5);
//        graph.connect(6, 7, 5);
//        graph.connect(7, 6, 6.3);
//        graph.connect(8, 7, 10);
//        graph.connect(8, 4, 4);
//
//        ga.init(graph);
//    assertFalse(ga.isConnected(), "is connected not working properly");
//
//        graph.connect(6, 2, 10);
//        graph.connect(7, 4, 4);
//
//    assertTrue(ga.isConnected(), "is connected not working properly");
//}
}