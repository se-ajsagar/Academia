import java.util.ArrayList;

/**
 * Created by Ajay Sagar on 11/12/2017.
 */

public class Graph {

  private Vertex[] vertices, tail;
  private String[] verticiesLabel;

  //Constructor
  public Graph(int totalVertices, String[] labels) {
    vertices = new Vertex[totalVertices];
    tail = new Vertex[totalVertices];
    this.verticiesLabel = labels;
    initializeLabels(labels);
  }

  //Get Vertex
  public Vertex getVertex(String label) {
    return vertices[getIndexOfVertex(label)];
  }

  //Add Neighbours
  public void addNeighbour(String neighbourLabel, String parentVertexLabel) {
    Vertex neighbour = new Vertex(neighbourLabel);
    addNeighbour(neighbour, parentVertexLabel);
  }

  public void addNeighbour(String neighbourLabel, int weight, String parentVertexLabel) {
    Vertex neighbour = new Vertex(neighbourLabel, weight);
    addNeighbour(neighbour, parentVertexLabel);
  }

  public void addNeighbour(Vertex neighbour, String parentVertexLabel) {
    if (isValidatedNeighbour(neighbour.label)) {
      int indexOfNeighbour = getIndexOfVertex(parentVertexLabel);
      if (vertices[indexOfNeighbour].edge == null && tail[indexOfNeighbour].edge == null) {
        vertices[indexOfNeighbour].edge = neighbour;
      }
      else {
        tail[indexOfNeighbour].edge.edge = neighbour;
      }
      tail[indexOfNeighbour].edge = neighbour;
    }
    else {
      System.out.println("Invalid Neighbour");
    }

  }

  //Get Neighbours
  public ArrayList<Vertex> getNeighbours(String vertexLabel) {
    Vertex v = new Vertex(vertexLabel);
    return getNeighbours(v);
  }

  public ArrayList<Vertex> getNeighbours(Vertex vertex) {
    ArrayList<Vertex> neighbours = new ArrayList<>();
    int index = getIndexOfVertex(vertex.label);
    Vertex v = vertices[index];
    while (v.edge != null) {
      neighbours.add(v.edge);
      v = v.edge;
    }
    return neighbours;
  }

  //Add Distance to Vertex
  public void addDistanceToParent(Vertex v, double distance) {
    int index = getIndexOfVertex(v.label);
    vertices[index].distance = distance;
  }

  /*public void addDistanceToNeighbour(Vertex parent, Vertex neighbour, double distance) {
    int index = getIndexOfVertex(parent.label);
    while(vertices[index].edge != null) {

    }
  }*/

  public String[] getAllVerticies() {
    return this.verticiesLabel;
  }

//  public VisitedVertex[] buildGraphToVisitedVertex() {
//    VisitedVertex[] graph = new VisitedVertex[vertices.length];
//    for (int i = 0; i < vertices.length; i++) {
//      graph[i] = new VisitedVertex(vertices[i], "");
//    }
//    return graph;
//  }

  //Helper Method
  private int getIndexOfVertex(String label) {
    int index = -1;
    for (int i = 0; i < vertices.length; i++) {
      if (vertices[i].label.equals(label)) {
        index = i;
         break;
      }
    }
    return index;
  }

  //Validate Neighbour
  private boolean isValidatedNeighbour(String vertexLabel) {
    boolean isValidated = false;
    for (int i = 0; i < vertices.length; i++) {
      if (vertices[i].label.equals(vertexLabel)) {
        isValidated = true;
        break;
      }
    }
    return isValidated;
  }

  private void initializeLabels(String[] labels) {
    for (int i = 0; i < labels.length; i++) {
      this.vertices[i] = new Vertex(labels[i]);
      tail[i] = new Vertex();
    }
  }

}