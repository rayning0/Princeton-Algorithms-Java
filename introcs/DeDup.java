/*************************************************************************
 *  Compilation:  javac DeDup.java
 *  Execution:    java DeDup < words.txt
 *  Dependencies: SET.java StdIn.java
 *
 *  Read in a list of words from standard input and print out
 *  each word, removing any duplicates.
 *
 *************************************************************************/

public class DeDup {  
    public static void main(String[] args) {
        SET<String> distinct = new SET<String>();
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (!distinct.contains(key)) {
                distinct.add(key);
                StdOut.println(key);
            }
        }
    }
}
