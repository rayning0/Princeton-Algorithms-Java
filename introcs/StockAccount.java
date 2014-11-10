/*************************************************************************
 *  Compilation:  javac StockAccount.java
 *  Execution:    java StockAccount < input.txt
 *  Dependencies: In.java StdOut.java StockQuote.java
 *
 *  % more Turing.txt 
 *  Turing, Alan 
 *  10.24 
 *  5 
 *  100 ADBE 
 *   25 GOOG 
 *  97 IBM 
 *  250 MSFT 
 *  200 YHOO 
 *
 *  % java StockAccount Turing.txt
 *  Turing, Alan 
 *                   Cash: $    10.24
 *   100  ADBE   $ 40.62   $  4062.00
 *    25  GOOG   $500.03   $ 12500.75
 *    97   IBM   $117.35   $ 11382.95
 *   250  MSFT   $ 29.71   $  7427.50
 *   200  YHOO   $ 23.80   $  4760.00
 *                  Total: $ 40143.44
 *
 *************************************************************************/

public class StockAccount { 
    private final String name;     // customer name
    private double cash;           // cash balance
    private int N;                 // number of stocks in portfolio
    private int[] shares;          // shares[i] = number of shares of stock i
    private String[] stocks;       // stocks[i] = symbol of stock i

    // build data structure from input stream
    public StockAccount(In in) {
        name = in.readLine(); 
        cash = in.readDouble(); 
        N = in.readInt(); 
        shares = new int[N]; 
        stocks = new String[N]; 
        for (int i = 0; i < N; i++) {
            shares[i] = in.readInt(); 
            stocks[i] = in.readString(); 
        } 
    } 

    // print a report to standard output
    public void printReport() { 
        StdOut.printf("%s\n", name); 
        StdOut.printf("                 Cash: $%9.2f\n", cash); 
        double total = cash; 
        for (int i = 0; i < N; i++) {
            int amount = shares[i];
            double price = StockQuote.price(stocks[i]);
            StdOut.printf("%4d  %4s ", amount, stocks[i]);
            StdOut.printf("  $%6.2f   $%9.2f\n", price, amount * price);
            total += amount * price;
        }
        StdOut.printf("                Total: $%9.2f\n", total);
    } 


    // test client
    public static void main(String[] args) { 
        In in = new In(args[0]); 
        StockAccount acct = new StockAccount(in); 
        acct.printReport(); 
    } 
} 
