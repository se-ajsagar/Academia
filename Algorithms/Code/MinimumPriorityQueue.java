import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Ajay Sagar on 13/12/2017.
 */

public class MinimumPriorityQueue {

  private PriorityQueue<Vertex> queue;


  public  MinimumPriorityQueue() {
    this.queue = new PriorityQueue<>(10, new Comparator<Vertex>() {
      @Override
      public int compare(Vertex vertexOne, Vertex vertexTwo) {
        return vertexOne.weight > vertexTwo.weight ? 1 : -1;
      }
    });
  }

  public void enqueueVertex(Vertex v) {
    queue.add(v);
  }

  public Vertex dequeueMin() {
    Vertex v = null;
    if (queue.size() > 0)
      v = queue.remove();
    return v;
  }

  /*public boolean isEmpty() {
    return queue.isEmpty();
  }*/

  public int getSize() {
    return queue.size();
  }

}
