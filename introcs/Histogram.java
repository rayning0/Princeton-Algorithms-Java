/*************************************************************************
 *  Compilation:  javac Histogram.java
 *
 *  This data type supports simple client code to create dynamic
 *  histograms of the frequency of occurrence of values in [0, N).
 *  The frequencies are kept in an instance-variable array, and
 *  an instance variable max tracks the maximum frequency (for scaling).
 *
 *  % java Histogram 50 1000000 
 *
 *************************************************************************/

public class Histogram {
    private final double[] freq;   // freq[i] = # occurences of value i
    private double max;            // max frequency of any value

    // Create a new histogram. 
    public Histogram(int N) {
        freq = new double[N];
    }

    // Add one occurrence of the value i. 
    public void addDataPoint(int i) {
        freq[i]++; 
        if (freq[i] > max) max = freq[i]; 
    } 

    // draw (and scale) the histogram.
    public void draw() {
        StdDraw.setYscale(0, max);
        StdStats.plotBars(freq);
    }
 
    // See Program 2.2.6.
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);   // number of coins
        int T = Integer.parseInt(args[1]);   // number of trials

        // create the histogram
        Histogram histogram = new Histogram(N+1); 
        for (int t = 0; t < T; t++) {
            histogram.addDataPoint(Bernoulli.binomial(N));
        }

        // display using standard draw
        StdDraw.setCanvasSize(500, 100);
        histogram.draw();
    } 
} 
