
/*************************************************************************
 *  Compilation:  javac Newton.java
 *  Execution:    java Newton x0 x1 x2 x3
 *
 *  Compute the square root using Newton's method. Package it
 *  in a static method.
 *
 *  % java Newton 1 2 3 1000000.1 -2 0 -0 NaN Infinity -Infinity
 *  1.0
 *  1.414213562373095
 *  1.7320508075688772
 *  1000.0000499999987
 *  NaN
 *  0.0
 *  -0.0
 *  NaN
 *  Infinity
 *  NaN
 *
 *************************************************************************/

public class Newton {

    // return the square root of c, computed using Newton's method
    public static double sqrt(double c) {
        if (c < 0) return Double.NaN;
        double EPS = 1E-15;
        double t = c;
        while (Math.abs(t - c/t) > EPS*t)
            t = (c/t + t) / 2.0;
        return t;
    }

    // overloaded version in which user specifies the error tolerance EPS
    public static double sqrt(double c, double EPS) {
        if (c < 0) return Double.NaN;
        double t = c;
        while (Math.abs(t - c/t) > EPS*t)
            t = (c/t + t) / 2.0;
        return t;
    }


    // test client
    public static void main(String[] args) {

        // parse command-line parameters
        double[] a = new double[args.length];
        for (int i = 0; i < args.length; i++) {
            a[i] = Double.parseDouble(args[i]);
        }

        // compute square root for each command line parameter
        for (int i = 0; i < a.length; i++) {
            double x = sqrt(a[i]);
            StdOut.println(x);
        }
    }
}
