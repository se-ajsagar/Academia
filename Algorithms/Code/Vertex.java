/**
 * Created by Ajay Sagar on 11/12/2017.
 */

public class Vertex {

  String label;
  Vertex edge;
  double weight;
  String predecessor;
  double distance;

  public Vertex() {
    this.label = "";
    weight = 0;
    edge = null;
    predecessor = "";
    distance = Double.POSITIVE_INFINITY;
  }

  public Vertex(String label) {
    this.label = label;
    weight = 0;
    edge = null;
    predecessor = "";
    distance = Double.POSITIVE_INFINITY;
  }

  public Vertex(String label, int weight) {
    this(label);
    this.weight = weight;
    edge = null;
    predecessor = "";
    distance = Double.POSITIVE_INFINITY;
  }

  //Copy Constructor
  public Vertex(Vertex v) {
    this.label = v.label;
    this.weight = v.weight;
    this.edge = new Vertex(v.edge);
    predecessor = "";
    distance = Double.POSITIVE_INFINITY;
  }

}
