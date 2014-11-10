/*************************************************************************
 *  Compilation:  javac LoadBalance.java
 *  Execution:    java LoadBalance M N S
 *  Dependencies: Queue.java RandomQueue.java StdDraw.java StdStats.java
 *
 *  Simulate the process of assignment N items to a set of M servers.
 *  Requests are put on the shortest of a sample of S queues chosen
 *  at random.
 *
 *************************************************************************/

public class LoadBalance {
    public static void main(String[] args) {

        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);
        int S = Integer.parseInt(args[2]);

        // Create server queues.
        RandomQueue<Queue<Integer>> servers = new RandomQueue<Queue<Integer>>();

        for (int i = 0; i < M; i++) {
            servers.enqueue(new Queue<Integer>());
        }

        // Assign an item to a server
        for (int j = 0; j < N; j++) {

            // Pick a random server, update if new min.
            Queue<Integer> min = servers.sample();
            for (int k = 1; k < S; k++) {
                Queue<Integer> q = servers.sample();
                if (q.length() < min.length()) min = q;
            }

            // min is the shortest server queue
            min.enqueue(j);
        }

        int i = 0;
        double[] lengths = new double[M];
        for (Queue<Integer> q: servers) {
            lengths[i++] = q.length();
            StdDraw.setYscale(0, 2.0*N/M);
            StdStats.plotBars(lengths);
        }
    }
}
