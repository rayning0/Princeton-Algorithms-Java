
/*************************************************************************
 *  Compilation:  javac Transition.java
 *  Execution:    java Transition < input.txt
 *  Data files:   http://introcs.cs.princeton.edu/16pagerank/tiny.txt
 *                http://introcs.cs.princeton.edu/16pagerank/medium.txt
 *
 *  This program is a filter that reads links from standard input and
 *  produces the corresponding transition matrix on standard output.
 *  First, it processes the input to count the outlinks from each page.
 *  Then it applies the 90-10 rule to compute the transition matrix.
 *  It assumes that there are no pages that have no outlinks in the
 *  input (see Exercise 1.6.3).
 *
 *  % more tiny.txt
 *  5 
 *  0 1 
 *  1 2  1 2 
 *  1 3  1 3  1 4 
 *  2 3 
 *  3 0 
 *  4 0  4 2 
 *
 *  % java Transition < tiny.txt
 *  5 5
 *   0.02 0.92 0.02 0.02 0.02
 *   0.02 0.02 0.38 0.38 0.20
 *   0.02 0.02 0.02 0.92 0.02
 *   0.92 0.02 0.02 0.02 0.02
 *   0.47 0.02 0.47 0.02 0.02
 *
 *************************************************************************/


public class Transition {


    public static void main(String[] args) {

        int N = StdIn.readInt();           // number of pages
        int[][] counts = new int[N][N];    // counts[i][j] = # links from page i to page j
        int[] outDegree = new int[N];      // outDegree[i] = # links from page i to anywhere

        // Accumulate link counts.  
        while (!StdIn.isEmpty())  {
            int i = StdIn.readInt(); 
            int j = StdIn.readInt(); 
            outDegree[i]++; 
            counts[i][j]++; 
        } 
        StdOut.println(N + " " + N); 


        // Print probability distribution for row i. 
        for (int i = 0; i < N; i++)  {

            // Print probability for column j. 
            for (int j = 0; j < N; j++) {
                double p = .90*counts[i][j]/outDegree[i] + .10/N; 
                StdOut.printf("%7.5f ", p); 
            } 
            StdOut.println(); 
        } 
    } 
} 

