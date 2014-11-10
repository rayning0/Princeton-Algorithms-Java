/*************************************************************************
 *  Compilation:  javac LRS.java
 *  Execution:    java LRS < file.txt
 *  Dependencies: StdIn.java
 *  
 *  Reads a text corpus from stdin, replaces all consecutive blocks of
 *  whitespace with a single space, and then computes the longest
 *  repeated substring in that corpus. Suffix sorts the corpus using
 *  the system sort, then finds the longest repeated substring among 
 *  consecutive suffixes in the sorted order.
 * 
 *  % java LRS < mobydick.txt
 *  ',- Such a funny, sporty, gamy, jesty, joky, hoky-poky lad, is the Ocean, oh! Th'
 * 
 *  % java LRS 
 *  aaaaaaaaa
 *  'aaaaaaaa'
 *
 *  % java LRS
 *  abcdefg
 *  ''
 *
 *************************************************************************/


import java.util.Arrays;

public class LRS {

    // return the longest common prefix of s and t
    public static String lcp(String s, String t) {
        int n = Math.min(s.length(), t.length());
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i))
                return s.substring(0, i);
        }
        return s.substring(0, n);
    }


    // return the longest repeated string in s
    public static String lrs(String s) {

        // form the N suffixes
        int N  = s.length();
        String[] suffixes = new String[N];
        for (int i = 0; i < N; i++) {
            suffixes[i] = s.substring(i, N);
        }

        // sort them
        Arrays.sort(suffixes);

        // find longest repeated substring by comparing adjacent sorted suffixes
        String lrs = "";
        for (int i = 0; i < N - 1; i++) {
            String x = lcp(suffixes[i], suffixes[i+1]);
            if (x.length() > lrs.length())
                lrs = x;
        }
        return lrs;
    }



    // read in text, replacing all consecutive whitespace with a single space
    // then compute longest repeated substring
    public static void main(String[] args) {
        String s = StdIn.readAll();
        s = s.replaceAll("\\s+", " ");
        StdOut.println("'" + lrs(s) + "'");
    }
}
