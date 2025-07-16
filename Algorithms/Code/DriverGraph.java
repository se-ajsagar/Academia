import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ajay Sagar on 12/12/2017.
 */

public class DriverGraph {

  public static void main(String[] args) {

    Graph graph = new Graph(5, new String[]{"KHI", "JDH", "LHR", "JFK", "DXB"});

    //Neighbours of A
    /*graph.addNeighbour("B", 10, "A");

    //Neighbours of C
    graph.addNeighbour("B", 5, "C");

    //Neighbours of D
    graph.addNeighbour("C", 4, "D" );

    //Neighbours of E
    graph.addNeighbour("D", 6, "E");

    //Neighbours of B
    graph.addNeighbour("E", 1, "B");
    graph.addNeighbour("A", 2, "B");
    graph.addNeighbour("C", 5, "B");
    graph.addNeighbour("F", 1, "B");*/

    //Neighbour of A
    graph.addNeighbour("LHR", 100, "KHI");
    graph.addNeighbour("DXB", 10, "KHI");

    //Neighbour of B
    graph.addNeighbour("DXB", 50, "LHR");

    //Neighbour of C
    graph.addNeighbour("JFK", 5, "DXB");
    graph.addNeighbour("JDH", 100, "DXB");
    graph.addNeighbour("KHI", 10, "DXB");

    //Neighbour of D
    graph.addNeighbour("JFK", 20, "JDH");
    graph.addNeighbour("KHI", 1, "JDH");

    //Neighbour of JFK
    graph.addNeighbour("KHI", 2, "JFK");

//    ArrayList<Vertex> neighbours = graph.getNeighbours(new Vertex("C"));
//    for(int i=0; i<neighbours.size(); i++) {
//      System.out.print(neighbours.get(i).label + ", ");
//    }

    System.out.println();

    System.out.println("Dijakstra Algorithm");

    ShortestPath shortestPath = new ShortestPath();
    HashMap<String, Vertex> shortest = shortestPath.dijakstra(graph, new Vertex("KHI"));


//    //Another Graph
//    Graph graphTwo = new Graph(5, new String[]{"A", "B", "C", "D", "E"});
//
//    //Neighbour of A
//    graphTwo.addNeighbour("B", 2, "A");
//    graphTwo.addNeighbour("E", 3, "A");
//
//    //Neighbour of B
//    graphTwo.addNeighbour("C", 3, "B");
//
//    //Neighbour of C
//    graphTwo.addNeighbour("D", 6, "C");
//
//    //Neighbour of D
//    graphTwo.addNeighbour("B", 5, "D");
//    graphTwo.addNeighbour("A", 8, "D");
//
//    //Neighbour of E
//    graphTwo.addNeighbour("D", 7, "E");
//
//    shortest = shortestPath.dijakstra(graphTwo, new Vertex("A"));

    String[] allVerticies = graph.getAllVerticies();
    for(int i=0; i<allVerticies.length; i++) {
      Vertex vertex = shortest.get(allVerticies[i]);
      System.out.print(vertex.label + " : " + vertex.distance + " : " + vertex.predecessor + "\n");
    }


//    for(int i=0; i<dijakstraGraph.length; i++) {
//      Vertex v = dijakstraGraph[i].actualVertex;
//      System.out.print("Vertex " + v.label + " : ");
//      while(v != null) {
//        System.out.print(v.edge.label +  ", ");
//        v = v.edge;
//      }
//    }


  }

}
