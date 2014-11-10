/*************************************************************************
 *  Compilation:  javac Flip.java
 *  Execution:    java Flip
 *  
 *  Simulate a fair coin flip and print out "Heads" or "Tails" accordingly.
 *
 *  % java Flip
 *  Heads
 *
 *  % java Flip
 *  Heads
 *
 *  % java Flip
 *  Tails
 *
 *
 *************************************************************************/

public class Flip {

    public static void main(String[] args) { 
        // Math.random() returns a value between 0.0 and 1.0
        // so it it heads or tails 50% of the time
        if (Math.random() < 0.5) System.out.println("Heads");
        else                     System.out.println("Tails");
    }
}
