
/*************************************************************************
 *  Compilation:  javac MD1Queue.java
 *  Execution:    java MD1Queue lambda mu
 *  Dependencies: Queue.java
 *
 *  Simulate an M/D/1 queue where arrivals obey a Poisson
 *  process with arrival rate lambda, and service times
 *  are deterministic with rate mu.
 *
 *  % java MD1Queue .167 .25
 *
 *  % java MD1Queue .167 .22
 * 
 *************************************************************************/

public class MD1Queue { 

    public static void main(String[] args) { 
        double lambda = Double.parseDouble(args[0]);   // arrival rate
        double mu     = Double.parseDouble(args[1]);   // service rate

        Histogram hist = new Histogram(60 + 1);
        Queue<Double> queue = new Queue<Double>();
        StdDraw.setCanvasSize(700, 500);

        double nextArrival = StdRandom.exp(lambda);    // time of next arrival
        double nextService = nextArrival + 1/mu;       // time of next completed service

        // simulate the M/D/1 queue
        while (true) {

            // next event is an arrival
            while (nextArrival < nextService) {
                queue.enqueue(nextArrival);
                nextArrival += StdRandom.exp(lambda);
            } 

            // next event is a service completion
            double arrival = queue.dequeue();
            double wait = nextService - arrival;

            // update the histogram
            StdDraw.clear();
            hist.addDataPoint(Math.min(60,  (int) (Math.round(wait))));
            hist.draw();
            StdDraw.show(20);

            // update the queue
            if (queue.isEmpty()) nextService = nextArrival + 1/mu;
            else                 nextService = nextService + 1/mu;
        } 
    } 
} 
