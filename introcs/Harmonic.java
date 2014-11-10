
/*************************************************************************
 *  Compilation:  javac Harmonic.java
 *  Execution:    java Harmonic N
 *  
 *  Prints the Nth harmonic number: 1/1 + 1/2 + ... + 1/N.
 * 
 *  % java Harmonic 10
 *  2.9289682539682538
 *
 *  % java Harmonic 10000
 *  9.787606036044348
 *
 *************************************************************************/

public class Harmonic { 
    public static void main(String[] args) { 

        // command-line argument
        int N = Integer.parseInt(args[0]);

        // compute 1/1 + 1/2 + 1/3 + ... + 1/N
        double sum = 0.0;
        for (int i = 1; i <= N; i++) {
            sum += 1.0 / i;
        }

        // print out Nth harmonic number
        System.out.println(sum);
    }

}
