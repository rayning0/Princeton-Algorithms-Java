/*************************************************************************
 *  Compilation:  javac Visualize.java
 *  Execution:    java Visualize N p trials
 *  Dependencies: Percolation.java StdDraw.java
 * 
 *  Repeatedly generated N-by-N boolean matrices, where each site
 *  is true with probability p. Plot the results using standard
 *  graphics.
 *
 *  % java Visualize 20 .35 10
 * 
 *  % java Visualize 20 .45 10
 *
 *************************************************************************/

 
public class Visualize {
    public static void main(String[] args) {
        int N    = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        int M    = Integer.parseInt(args[2]);

        // repeatedly created N-by-N matrices and display them using standard draw
        for (int i = 0; i < M; i++) {
            boolean[][] open = Percolation.random(N, p);
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            Percolation.show(open, false);
            StdDraw.setPenColor(StdDraw.GRAY);
            boolean[][] full = Percolation.flow(open);
            Percolation.show(full, true);
            StdDraw.show(1000);
        }
    }
}
