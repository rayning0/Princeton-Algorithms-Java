import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

class Neighbor {
    public int vertexNum;
    public Neighbor next;
    public int weight;
    public Neighbor(int vnum, Neighbor nbr, int wt) {
            this.vertexNum = vnum;
            next = nbr;
            this.weight = wt;
    }
}

class Vertex {
    String name;
    Neighbor adjList;
    Vertex(String name, Neighbor neighbors) {
            this.name = name;
            this.adjList = neighbors;
    }
}

/**
 * @author Sesh Venugopal. May 31, 2013.
 */
public class Graph {

    Vertex[] adjLists;

    public Graph(String file) throws FileNotFoundException {

        Scanner sc = new Scanner(new File(file));

        String graphType = sc.next();
        boolean undirected=true;
        if (graphType.equals("directed")) {
            undirected=false;
        }

        adjLists = new Vertex[sc.nextInt()];

        // read vertices
        for (int v=0; v < adjLists.length; v++) {
            adjLists[v] = new Vertex(sc.next(), null);
        }

        // read edges
        while (sc.hasNext()) {

            // read vertex names and translate to vertex numbers
            int v1 = indexForName(sc.next());
            int v2 = indexForName(sc.next());
            int w = Integer.parseInt(sc.next());

            // add v2 to front of v1's adjacency list and
            // add v1 to front of v2's adjacency list
            adjLists[v1].adjList = new Neighbor(v2, adjLists[v1].adjList, w);
            if (undirected) {
                adjLists[v2].adjList = new Neighbor(v1, adjLists[v2].adjList, w);
            }
        }
    }

    int indexForName(String name) {
        for (int v=0; v < adjLists.length; v++) {
            if (adjLists[v].name.equals(name)) {
                return v;
            }
        }
        return -1;
    }

    public void print() {
        System.out.println();
        for (int v=0; v < adjLists.length; v++) {
            System.out.print(adjLists[v].name);
            for (Neighbor nbr=adjLists[v].adjList; nbr != null; nbr=nbr.next) {
                System.out.print(" --> " + adjLists[nbr.vertexNum].name + " (" + nbr.weight + ")");
            }
            System.out.println("\n");
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    throws IOException {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter graph input file name: ");
        String file = sc.nextLine();
        Graph graph = new Graph(file);
        graph.print();

    }

}