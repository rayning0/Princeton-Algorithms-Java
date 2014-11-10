/*************************************************************************
 *  Compilation:  javac Stopwatch.java
 *
 *
 *************************************************************************/

public class Stopwatch { 

    private final long start;

    public Stopwatch() {
        start = System.currentTimeMillis();
    } 

    // return time (in seconds) since this object was created
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    } 


/*************************************************************************
 *  The test client compares the method for computing square roots in
 *  Java's Math library with our implementation from Program 2.1.1 th
 *  uses Newton's method for the task of computing the sum of t
 *  e square roots of the numbers from 0 to N-1. For this quick test,
 *  the Java implementation Math.sqrt() is about 20 times faster than 
 *  our Newton.sqrt() (as it should be!). 
 *************************************************************************/
    public static void main(String[] args) { 
        int N = Integer.parseInt(args[0]); 

        // time Math library implementation
        double totalMath = 0.0; 
        Stopwatch swMath = new Stopwatch(); 
        for (int i = 0; i < N; i++) {
            totalMath += Math.sqrt(i); 
        }
        double timeMath = swMath.elapsedTime(); 
  
        // time Newton's method implementation
        double totalNewton = 0.0; 
        Stopwatch swNewton = new Stopwatch(); 
        for (int i = 0; i < N; i++) {
            totalNewton += Newton.sqrt(i);
        }


        // print results
        double timeNewton = swNewton.elapsedTime(); 
        StdOut.println(totalNewton/totalMath); 
        StdOut.println(timeNewton/timeMath); 
    }
} 
