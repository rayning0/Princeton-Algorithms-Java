/*************************************************************************
 *  Compilation:  javac Insertion.java
 *  Execution:    java Insertion < input.txt
 *  
 *  Reads in strings from standard input and prints them in sorted order.
 *  Uses insertion sort.
 *
 *************************************************************************/

// suppress unchecked warnings in Java 1.5.0_6 and later
@SuppressWarnings("unchecked")


public class Insertion {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j-1].compareTo(a[j]) > 0) {
                    exch(a, j-1, j);
                }
                else break;
            }
        }
    }

    // exchange a[i] and a[j]
    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // read in a sequence of words from standard input and print
    // them out in sorted order
    public static void main(String[] args) {
        String[] a = StdIn.readAll().split("\\s+");
        sort(a);
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }
}


