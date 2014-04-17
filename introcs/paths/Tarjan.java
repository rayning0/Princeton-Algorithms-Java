import Graph.list.AdjacencyList;
import Graph.Node;
import java.util.ArrayList;
import org.jgraph.graph.DefaultEdge;

public class Tarjan {
 private int index = 0;
 private ArrayList<Node> stack = new ArrayList<Node>();
 private ArrayList<ArrayList<Node>> SCC = new ArrayList<ArrayList<Node>>();

 public ArrayList<ArrayList<Node>> tarjan(Node v, AdjacencyList list) {
  v.setIndex(index);
  v.setLowlink(index);
  index++;
  stack.add(0, v);
  for (DefaultEdge edge : list.getAdjacent(v)) {
   Node n = (Node) edge.getTarget();
   if (n.getIndex() == -1) {
    tarjan(n, list);
    v.setLowlink(Math.min(v.getLowlink(), n.getLowlink()));
   } else if (stack.contains(n)) {
    v.setLowlink(Math.min(v.getLowlink(), n.getIndex()));
   }
  }
  if (v.getLowlink() == v.getIndex()) {
   Node n;
   ArrayList<Node> component = new ArrayList<Node>();
   do {
    n = stack.remove(0);
    component.add(n);
   } while (n != v);
   SCC.add(component);
  }
  return SCC;
 }

}

