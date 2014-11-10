/*************************************************************************
 *  Compilation:  javac IndexGraph.java
 *  Dependencies: Graph.java In.java
 *  Execution:    java IndexGraph movies.txt "/"
 *  
 *  Builds a graph, then accepts vertex names from standard input
 *  and prints its neighbors.
 *
 *************************************************************************/

public class IndexGraph {

    public static void main(String[] args) {

        // read in the graph from a file
        In in = new In(args[0]);
        String delimiter = args[1];
        Graph G = new Graph(in, delimiter);

        // read a vertex and print its neighbors
        while (!StdIn.isEmpty()) {
            String v = StdIn.readLine();
            for (String w : G.adjacentTo(v)) {
                StdOut.println("  " + w);
            }
        }
    }

}
