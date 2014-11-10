
/*************************************************************************
 *  Compilation:  javac TwentyQuestions.java
 *  Execution:    java TwentyQuestions n
 *  Dependencies  StdIn.java
 *
 *  This code uses binary search to play the game of twenty questions.
 *  It takes a command-line argument n, asks you to think of a number
 *  between 0 and N-1, where N = 2^n, and always guesses the answer
 *  with n questions.
 *
 *  %  java TwentyQuestions 7
 *  Think of an integer between 0 and 127
 *  Is it less than 64?  false
 *  Is it less than 96?  true
 *  Is it less than 80?  true
 *  Is it less than 72?  false
 *  Is it less than 76?  false
 *  Is it less than 78?  true
 *  Is it less than 77?  false
 *  Your number is 77
 *
 *************************************************************************/

public class TwentyQuestions {

    // invariant: answer is in [lo, hi)
    public static int search(int lo, int hi) {
        if ((hi - lo) == 1) return lo;
        int mid = lo + (hi - lo) / 2;
        StdOut.printf("Is it less than %d?  ", mid);
        if (StdIn.readBoolean()) return search(lo, mid);
        else                     return search(mid, hi);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int N = (int) Math.pow(2, n);
        StdOut.printf("Think of an integer between %d and %d\n", 0, N-1);
        int v = search(0, N);
        System.out.printf("Your number is %d\n", v);
    }

}
