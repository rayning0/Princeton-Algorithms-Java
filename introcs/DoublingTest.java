/*************************************************************************
 *  Compilation:  javac DoublingTest.java
 *  Execution:    java DoublingTest
 *
 *  % java DoublingTest 
 *      512 6.48
 *     1024 8.30
 *     2048 7.75
 *     4096 8.00
 *     8192 8.05
 *   ... 
 *
 *************************************************************************/

public class DoublingTest {

    public static double timeTrial(int N) {
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(2000000) - 1000000;
        }
        Stopwatch s = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return s.elapsedTime();
    }


    public static void main(String[] args) { 
        StdOut.printf("%7s %7s %4s\n", "size", "time", "ratio");
        double prev = timeTrial(256);
        for (int N = 512; true; N += N) {
            double curr = timeTrial(N);
            StdOut.printf("%7d %7.2f %4.2f\n", N, curr, curr / prev);
            prev = curr;
        } 
    } 
} 

