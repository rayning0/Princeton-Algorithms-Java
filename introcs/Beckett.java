/*************************************************************************
 *  Compilation:  javac Beckett.java
 *  Execution:    java Beckett N
 *
 *  Prints instructions for a Beckett play with N actors.
 *
 *  % java Beckett 1
 *  enter 1
 *
 *  % java Beckett 2
 *  enter 1
 *  enter 2
 *  exit  1
 *
 *  % java Beckett 3
 *  enter 1
 *  enter 2
 *  exit  1
 *  enter 3
 *  enter 1
 *  exit  2
 *  exit  1
 *
 *************************************************************************/

public class Beckett {

    public static void moves(int n, boolean forward) {
        if (n == 0) return;
        moves(n-1, true);
        if (forward) System.out.println("enter " + n);
        else         System.out.println("exit  " + n);
        moves(n-1, false);
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        moves(N, true);
    }

}
