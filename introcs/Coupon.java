
/*************************************************************************
 *  Compilation:  javac Coupon.java
 *  Execution:    java Coupon N
 *
 *
 *  % java Coupon 1000 
 *  6522 
 *
 *  % java Coupon 1000 
 *  6481 
 *
 *  % java Coupon 1000000 
 *  12783771
 *  
 *************************************************************************/

public class Coupon {

    // return a random coupon between 0 and N-1
    public static int getCoupon(int N) {
        return (int) (Math.random() * N);
    }

    // return number of cards you collect before obtaining one of each of the N types
    public static int collect(int N) {
        boolean[] found = new boolean[N];     // fount[i] = true if card type i already collected
        int cardcnt = 0;                      // number of cards collected
        int valcnt  = 0;                      // number of distinct card types collected

        // repeat until you've collected all N card types
        while (valcnt < N) {
            int val = getCoupon(N);           // pick a random card 
            cardcnt++;                        // one more card
            if (!found[val]) valcnt++;        // discovered a new card type
            found[val] = true;                // mark card type as having been collected
        }
        return cardcnt;
    }

    // test client
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int count = collect(N);
        StdOut.println(count);
    } 
} 
