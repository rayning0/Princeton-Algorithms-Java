/*************************************************************************
 *  Compilation:  javac Brownian.java 
 *  Execution:    java Brownian var
 *  Dependencies: StdDraw.java
 *
 *  Plots Brownian motion trajectory using the midpoint displacement
 *  method.
 *
 *  % java Brownian 1
 *
 *  % java Brownian 0.5
 *
 *************************************************************************/

public class Brownian { 

    // midpoint displacement method
    public static void curve(double x0, double y0, double x1, double y1, double var, double s) {
        // stop if interval is sufficiently small
        if (Math.abs(x1 - x0) < .01) {
            StdDraw.line(x0, y0, x1, y1);
            return;
        }

        double xm = (x0 + x1) / 2;
        double ym = (y0 + y1) / 2;
        ym = ym + StdRandom.gaussian(0, Math.sqrt(var));
        curve(x0, y0, xm, ym, var/s, s);
        curve(xm, ym, x1, y1, var/s, s);
    } 

    public static void main(String[] args) { 
        double H = Double.parseDouble(args[0]); 
        double s = Math.pow(2, 2*H); 
        curve(0.0, 0.5, 1.0, 0.5, .01, s); 
    } 
} 
