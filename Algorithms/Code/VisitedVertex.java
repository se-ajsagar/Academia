import java.util.ArrayList;

/**
 * Created by Ajay Sagar on 13/12/2017.
 */
public class VisitedVertex {

  Vertex actualVertex;
  String predecessor;
  double distance;

  //Constructor
  public VisitedVertex() {
    actualVertex = new Vertex();
    predecessor = "";
    distance = 0;
  }

  public VisitedVertex(Vertex actualVertex, String predecessor) {
    this.actualVertex = new Vertex(actualVertex);
    this.predecessor = predecessor;
    this.distance = actualVertex.weight;
  }

  public VisitedVertex(Vertex actualVertex, String predecessor, double distance) {
    this.actualVertex = new Vertex(actualVertex);
    this.predecessor = predecessor;
    this.distance = distance;
  }

  //Copy Constructor
  /*public VisitedVertex(VisitedVertex visitedVertex) {
    this.actualVertex = visitedVertex.actualVertex;
    this.predecessor = visitedVertex.predecessor;
    this.distance = visitedVertex.distance;
  }*/

}
