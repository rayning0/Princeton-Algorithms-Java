/*************************************************************************
 *  Compilation:  javac Potential.java
 *  Execution:    java Potential < input.txt
 *  Dependencies: Charge.java Picture.java StdIn.java
 *                http://www.cs.princeton.edu/introcs/31datatype/charges.txt
 *
 *  Potential value visualization for a set of charges.
 *
 *  % java Potential < charges.txt
 *
 *
 *************************************************************************/

import java.awt.Color;

public class Potential {

    public static void main(String[] args) {

        // read in N point charges
        int N = StdIn.readInt();
        Charge[] a = new Charge[N];
        for (int k = 0; k < N; k++) {
            double x0 = StdIn.readDouble();
            double y0 = StdIn.readDouble();
            double q0 = StdIn.readDouble();
            a[k] = new Charge(x0, y0, q0);
        }

        // compute the potential at each point and plot
        int SIZE = 800;
        Picture pic = new Picture(SIZE, SIZE);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                double V = 0.0;
                for (int k = 0; k < N; k++) {
                    double x = 1.0 * i / SIZE;
                    double y = 1.0 * j / SIZE;
                    V += a[k].potentialAt(x, y);
                }
                V = 128 + V / 2.0e10;
                int t = 0;
                if      (V <   0) t = 0;
                else if (V > 255) t = 255;
                else              t = (int) V;
                // Color c = new Color(t, t, t);
                Color c = Color.getHSBColor(t / 255.0f, .9f, .9f);
                // Color c = Color.getHSBColor(.75f*t/40, .8f, .8f);
                //int gray = (t * 37) % 255;
                //Color c = new Color(gray, gray, gray);
                pic.set(i, SIZE-1-j, c);
            }
        }
        pic.show();
    }
}
