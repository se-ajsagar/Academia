import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ajay Sagar on 13/12/2017.
 */

public class ShortestPath {

  //Dijakstra
  public HashMap<String, Vertex> dijakstra(Graph graph, Vertex source) {
    MinimumPriorityQueue queue = new MinimumPriorityQueue();
    HashMap<String, Vertex> shortestPath = initializeDistances(graph.getAllVerticies());

    //Source Vertex to Zero
    Vertex updateSource = shortestPath.get(source.label);
    if (updateSource != null) {
      updateSource.distance = 0;
    }

    //graph.addDistanceToParent(source, 0);
    queue.enqueueVertex(graph.getVertex(source.label));

    while(queue.getSize() != 0) {
      Vertex predecessorVertex = queue.dequeueMin();
      ArrayList<Vertex> neighbours = graph.getNeighbours(predecessorVertex);

      for (int i = 0; i < neighbours.size(); i++) {
        Vertex neighbour = neighbours.get(i);
        Vertex shortestNeighbour = shortestPath.get(neighbour.label);
        Vertex shortestPredecessor = shortestPath.get(predecessorVertex.label);

        if (shortestNeighbour.distance > shortestPredecessor.distance + neighbour.weight) {
          shortestNeighbour.distance = shortestPredecessor.distance + neighbour.weight;
          shortestNeighbour.predecessor = predecessorVertex.label;
          queue.enqueueVertex(neighbour);
        }
      }
    }

    return shortestPath;
  }

  //Bellman Ford
  public HashMap<String, Vertex> bellmanFord(Graph graph, Vertex source) {
    HashMap<String, Vertex> shortestPath = dijakstra(graph, source);
    return shortestPath;
  }

  //Initialize Distances
  private HashMap<String, Vertex> initializeDistances(String[] verticiesLabel) {
    HashMap<String, Vertex> distances = new HashMap<>();
    for(int i=0; i<verticiesLabel.length; i++) {
      distances.put(verticiesLabel[i], new Vertex(verticiesLabel[i]));
    }
    return distances;
  }
}
