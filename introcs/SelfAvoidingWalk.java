/*************************************************************************
 *  Compilation:  javac SelfAvoidingWalk.java
 *  Execution:    java SelfAvoidingWalk N T
 *
 *  Generate T self-avoiding walks of length N.
 *  Report the fraction of time the random walk is non self-intersecting.
 *
 *************************************************************************/

public class SelfAvoidingWalk {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);       // lattice size
        int T = Integer.parseInt(args[1]);       // number of trials
        int deadEnds = 0;                        // trials resulting in a dead end

        // simulate T self-avoiding walks
        for (int t = 0; t < T; t++) {
            boolean[][] a = new boolean[N][N];   // intersections visited 
            int x = N/2, y = N/2;                // current position

            // repeatedly take a random step, unless you've already escaped
            while (x > 0 && x < N-1 && y > 0 && y < N-1)  {

                // dead-end, so break out of loop
                if (a[x-1][y] && a[x+1][y] && a[x][y-1] && a[x][y+1]) {
                    deadEnds++;
                    break;
                } 

                // mark (x, y) as visited
                a[x][y] = true; 

                // take a random step to unvisited neighbor
                double r = Math.random(); 
                if      (r < 0.25) { if (!a[x+1][y]) x++; }
                else if (r < 0.50) { if (!a[x-1][y]) x--; }
                else if (r < 0.75) { if (!a[x][y+1]) y++; }
                else if (r < 1.00) { if (!a[x][y-1]) y--; }
            } 
        } 

        System.out.println(100*deadEnds/T + "% dead ends"); 
    } 
} 
