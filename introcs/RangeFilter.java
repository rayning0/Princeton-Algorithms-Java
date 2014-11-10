
/*************************************************************************
 *  Compilation:  javac RangeFilter.java
 *  Execution:    java RangeFilter lo hi < input.txt
 *  Dependencies: StdIn.java
 *
 *  Read in a sequence of integers from standard input and print
 *  out those values between lo and hi.
 *
 *************************************************************************/

public class RangeFilter {
    public static void main(String[] args) {

        // read in two command-line arguments
        int lo = Integer.parseInt(args[0]);
        int hi = Integer.parseInt(args[1]);

        // repeat as long as there's more input to read in
        while (!StdIn.isEmpty()) {

            // read in the next integer
            int t = StdIn.readInt();

            // print out the given integer if it's between lo and hi
            if (t >= lo && t <= hi) {
                StdOut.print(t + " ");
            }
        }
        StdOut.println(); 
    } 
} 
