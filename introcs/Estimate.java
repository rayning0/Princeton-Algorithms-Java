/*************************************************************************
 *  Compilation:  javac Estimate.java
 *  Execution:    java Estiamte N p trials
 *  Dependencies: Percolation.java StdOut.java
 * 
 *  Repeatedly generated N-by-N boolean matrices, where each site
 *  is true with probability p, and compute the probability that
 *  the system percolates.
 *
 *  % java Estimate 32 .4 10000
 *
 *************************************************************************/


public class Estimate {

    // do M trials and return fraction that percolate
    public static double eval(int N, double p, int M) {
        int count = 0;
        for (int k = 0; k < M; k++) {
            boolean[][] open = Percolation.random(N, p);
            if (Percolation.percolates(open))
                count++;
        }
        return (double) count / M;
    }


    public static void main(String[] args) {
        int    N = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        int    M = Integer.parseInt(args[2]);
        double q = eval(N, p, M);
        StdOut.println(q);
    }
}
