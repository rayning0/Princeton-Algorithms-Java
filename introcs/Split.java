
/*************************************************************************
 *  Compilation:  javac Cat.java
 *  Execution:    java Split DJIA N delimiter
 *  Dependencies: In.java Out.java
 *
 *  This program uses multiple output streams to split a CSV file
 *  into separate files, one for each comma-delimited field.
 *
 *  % more DJIA.csv
 *  ...                                                     
 *  30-Oct-29,230.98,10730000,258.47
 *  29-Oct-29,252.38,16410000,230.07
 *  28-Oct-29,295.18,9210000,260.64
 *  25-Oct-29,299.47,5920000,301.22
 *
 *
 *  % java Split DJIA 3 "," 
 *  % more DJIA2
 *  ...
 *  10730000
 *  16410000
 *  9210000
 *  5920000
 *  ...
 *  
 *************************************************************************/

public class Split {
    public static void main(String[] args) {
        String name = args[0];               // base file name
        int N = Integer.parseInt(args[1]);   // number of fields
        String delimiter = args[2];          // delimiter (comma)

        // create one output stream for each of the N fields
        Out[] out = new Out[N];
        for (int i = 0; i < N; i++) {
            out[i] = new Out(name + i);
        }

        // read in the input and divide by field
        In in = new In(name + ".csv");
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] fields = line.split(delimiter);
            for (int i = 0; i < N; i++) {
                out[i].println(fields[i]);
            }
        }
    } 
} 
