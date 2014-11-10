/*************************************************************************
*  Compilation:  javac StockQuote.java
*  Execution:    java StockQuote symbol
*  Dependencies: In.java, StdOut.java
*
*  Print the stock price of the stock with the given symbol. Screen scrapes
*  finance.yahoo.com<http://finance.yahoo.com> to get the current price and
*  associated information.
*
*  % java StockQuote goog
*  779.11
*  Google Inc.
*  Wed, Apr 17, 2013, 2:50PM EDT
*
*  % java StockQuote aapl
*  400.84
*  Apple Inc.
*  Wed, Apr 17, 2013, 2:55PM EDT
*
*  % java StockQuote ibm
*  209.85
*  International Business Machines
*  Wed, Apr 17, 2013, 2:56PM EDT
*
*  % java StockQuote msft
*  28.82
*  Microsoft Corporation
*  Wed, Apr 17, 2013, 2:57PM EDT
*
*************************************************************************/

public class StockQuote {

   // Given symbol, get current stock price.
   public static double price(String symbol) {
       In page = new In("http://finance.yahoo.com/q?s=" + symbol);
       String input = page.readAll();
       int from  = input.indexOf("yfs_l84", 0);             // "yfs_l84" index
       int to    = input.indexOf("</span></span>", from);   // "</span>" index
       String price = input.substring(from + 10 + symbol.length(), to);
       return Double.parseDouble(price);
   }

   // Given symbol, get current stock name.
   public static String name(String symbol) {
       In page = new In("http://finance.yahoo.com/q?s=" + symbol);
       String input = page.readAll();
       int p    = input.indexOf("<title>", 0);
       int from = input.indexOf("Summary for ", p);
       int to   = input.indexOf("- Yahoo! Finance", from);
       String name = input.substring(from + 12, to);
       return name;
   }

   // Given symbol, get current date.
   public static String date(String symbol) {
       In page = new In("http://finance.yahoo.com/q?s=" + symbol);
       String input = page.readAll();
       int p    = input.indexOf("<span id=\"yfs_market_time\">", 0);
       int from = input.indexOf(">", p);
       int to   = input.indexOf("-", from);        // no closing small tag
       String date = input.substring(from + 1, to);
       return date;
   }


   public static void main(String[] args) {
       String symbol = args[0];
       StdOut.println(price(symbol));
       StdOut.println(name(symbol));
       StdOut.println(date(symbol));
   }

}
