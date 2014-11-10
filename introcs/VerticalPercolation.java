/*************************************************************************
 *  Compilation:  javac VerticalPercolation.java
 *  Execution:    java VerticalPercolation < input.txt
 *  Dependencies: StdArrayIO.java StdOut.java
 *
 *  % java VerticalPercolation < testD.txt
 *  8 8
 *  0 0 0 1 1 1 0 1
 *  1 1 1 0 0 1 1 1
 *  1 0 1 0 0 1 0 0
 *  1 0 1 1 1 1 0 0
 *  1 0 0 1 0 1 0 0
 *  1 1 0 1 0 0 0 0
 *  0 1 1 0 0 0 0 0
 *  0 0 1 0 0 0 0 0
 *  false
 *
 *  % java VerticalPercolation < testV.txt
 *  8 8
 *  0 0 0 1 1 1 0 1 
 *  0 0 0 0 0 1 0 1 
 *  0 0 0 0 0 1 0 0 
 *  0 0 0 0 0 1 0 0 
 *  0 0 0 0 0 1 0 0 
 *  0 0 0 0 0 1 0 0 
 *  0 0 0 0 0 1 0 0 
 *  0 0 0 0 0 1 0 0 
 *  true
 *
 *************************************************************************/

public class VerticalPercolation {

    // given an N-by-N matrix of open sites, return an N-by-N matrix
    // of sites reachable from the top via a vertical path of open sites
    public static boolean[][] flow(boolean[][] open) {
        int N = open.length;     
        boolean[][] full = new boolean[N][N];

        // identify full sites in row 0
        for (int j = 0; j < N; j++) {
            full[0][j] = open[0][j]; 
        }      

        // update remaining rows
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                full[i][j] = open[i][j] && full[i-1][j];
            }
        }

        return full;
    } 


    // does the system percolate?
    public static boolean percolates(boolean[][] open) {
        int N = open.length;
        boolean[][] full = flow(open);
        for (int j = 0; j < N; j++) {
            if (full[N-1][j]) return true;
        }
        return false;
    }

    // draw the N-by-N boolean matrix to standard draw
    public static void show(boolean[][] a, boolean which) {
        int N = a.length;
        StdDraw.setXscale(-1, N);
        StdDraw.setYscale(-1, N);
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (a[i][j] == which)
                    StdDraw.filledSquare(j, N-i-1, .5);
    }

    // return a random N-by-N boolean matrix, where each entry is
    // true with probability p
    public static boolean[][] random(int N, double p) {
        boolean[][] a = new boolean[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                a[i][j] = StdRandom.bernoulli(p);
        return a;
    }

   // test client
    public static void main(String[] args) {
        boolean[][] open = StdArrayIO.readBoolean2D();
        StdArrayIO.print(flow(open));
        StdOut.println(percolates(open));
    }       

}
