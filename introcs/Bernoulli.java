
/*************************************************************************
 *  Compilation:  javac Bernoulli.java
 *  Execution:    java Bernoulli N T
 *  Dependencies: StdDraw.java
 *  
 *  Each experiment consists of flipping N fair coins T times.
 *  Plots a histogram of the number of times i of the N coins are heads.
 *
 *  % java Bernoulli 32 1000
 *
 *  % java Bernoulli 64 1000
 *
 *  % java Bernoulli 128 1000
 *
 *************************************************************************/



public class Bernoulli { 

    // number of heads when flipping N biased-p coins
    public static int binomial(int N, double p) {
        int heads = 0;
        for (int i = 0; i < N; i++) {
            if (StdRandom.bernoulli(p)) {
                heads++;
            }
        }
        return heads;
    } 

    // number of heads when flipping N fair coins
    // or call binomial(N, 0.5)
    public static int binomial(int N) {
        int heads = 0;
        for (int i = 0; i < N; i++) {
            if (StdRandom.bernoulli(0.5)) {
                heads++;
            }
        }
        return heads;
    } 



    public static void main(String[] args) { 
        int N = Integer.parseInt(args[0]);   // number of coins to flip per trial
        int T = Integer.parseInt(args[1]);   // number of trials

        StdDraw.setYscale(0, 0.2);

        // flip N fair coins, T times
        int[] freq = new int[N+1];
        for (int t = 0; t < T; t++) {
            freq[binomial(N)]++;
        }

        // plot normalized values
        double[] normalized = new double[N+1];
        for (int i = 0; i <= N; i++) {
            normalized[i] = (double) freq[i] / T;
        }
        StdStats.plotBars(normalized);

        // plot Gaussian approximation
        double mean = N / 2.0;
        double stddev = Math.sqrt(N) / 2.0;
        double[] phi  = new double[N+1];
        for (int i = 0; i <= N; i++) {
            phi[i] = Gaussian.phi(i, mean, stddev);
        }
        StdStats.plotLines(phi);
    } 
} 
