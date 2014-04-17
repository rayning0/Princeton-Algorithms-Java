import java.util.LinkedList;

public class Search {

    private static final String START = "A";
    private static final String END = "P";

    public static void main(String[] args) {
        // this graph is directional
        Graph graph = new Graph();
//        graph.addEdge("A", "B");
//        graph.addEdge("A", "C");
//        graph.addEdge("B", "A");
//        graph.addEdge("B", "D");
//        graph.addEdge("B", "E"); // this is the only one-way connection
//        graph.addEdge("B", "F");
//        graph.addEdge("C", "A");
//        graph.addEdge("C", "E");
//        graph.addEdge("C", "F");
//        graph.addEdge("D", "B");
//        graph.addEdge("E", "C");
//        graph.addEdge("E", "F");
//        graph.addEdge("F", "B");
//        graph.addEdge("F", "C");
//        graph.addEdge("F", "E");
        
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("B", "E");
        graph.addEdge("C", "F");
        graph.addEdge("C", "G");
        graph.addEdge("D", "H");
        graph.addEdge("D", "I");
        graph.addEdge("E", "J");
        graph.addEdge("E", "K");
        graph.addEdge("F", "L");
        graph.addEdge("F", "M");
        graph.addEdge("G", "N");
        graph.addEdge("G", "O");
        graph.addEdge("L", "P");
        graph.addEdge("E", "I");
        graph.addEdge("I", "P");
        
        LinkedList<String> visited = new LinkedList();
        visited.add(START);
        new Search().dfs(graph, visited);
        System.out.println("visited = " + visited);
        
    }

    private void dfs(Graph graph, LinkedList<String> visited) {
        LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());
        // examine adjacent nodes
        for (String node : nodes) {
            if (visited.contains(node)) {
                continue;
            }
            if (node.equals(END)) {
                visited.add(node);
                printPath(visited);
                visited.removeLast();
                break;
            }
        }
        // in breadth-first, recursion needs to come after visiting adjacent nodes
        for (String node : nodes) {
            if (visited.contains(node) || node.equals(END)) {
                continue;
            }
            visited.addLast(node);
            System.out.println("node: " + node);
            System.out.println("visited: " + visited);
            dfs(graph, visited);
            visited.removeLast();
        }
    }

    private void printPath(LinkedList<String> visited) {
        for (String node : visited) {
            System.out.print(node);
            System.out.print(" ");
        }
        System.out.println();
    }
}