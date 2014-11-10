/*************************************************************************
 *  Compilation:  javac Gambler.java
 *  Execution:    java Gambler stake goal N
 *  
 *  Simulates a gambler who start with $stake and place fair $1 bets
 *  until she goes broke or reach $goal. Keeps track of the number of
 *  times she wins and the number of bets she makes. Run the experiment N
 *  times, averages the results, and prints them out.
 *
 *  % java Gambler 50 250 1000
 *  Percent of games won = 19.0
 *  Avg # bets            = 9676.302
 *
 *  % java Gambler 50 150 1000
 *  Percent of games won = 31.9
 *  Avg # bets            = 4912.13
 *
 *  % java Gambler 50 100 1000
 *  Percent of games won = 49.6
 *  Avg # bets            = 2652.352
 *
 *************************************************************************/

public class Gambler { 

    public static void main(String[] args) {
        int stake = Integer.parseInt(args[0]);    // gambler's stating bankroll
        int goal  = Integer.parseInt(args[1]);    // gambler's desired bankroll
        int T     = Integer.parseInt(args[2]);    // number of trials to perform

        int bets = 0;        // total number of bets made
        int wins = 0;        // total number of games won

        // repeat N times
        for (int t = 0; t < T; t++) {

            // do one gambler's ruin simulation
            int cash = stake;
            while (cash > 0 && cash < goal) {
                bets++;
                if (Math.random() < 0.5) cash++;     // win $1
                else                     cash--;     // lose $1
            }
            if (cash == goal) wins++;                // did gambler go achieve desired goal?
        }

        // print results
        System.out.println(wins + " wins of " + T);
        System.out.println("Percent of games won = " + 100.0 * wins / T);
        System.out.println("Avg # bets           = " + 1.0 * bets / T);
    }

}
