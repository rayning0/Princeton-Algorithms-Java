/*************************************************************************
 *  Compilation:  javac Htree.java
 *  Execution:    java Htree N
 *  Dependencies: StdDraw.java
 *
 *  Plot an order N Htree.
 *
 *  % java Htree 5
 *
 *************************************************************************/

public class Htree {

    // plot an H, centered on (x, y) of the given side length
    public static void drawH(double x, double y, double size) {

        // compute the coordinates of the 4 tips of the H
        double x0 = x - size/2;
        double x1 = x + size/2;
        double y0 = y - size/2;
        double y1 = y + size/2;

        // draw the 3 line segments of the H
        StdDraw.line(x0, y0, x0, y1);    // left  vertical segment of the H
        StdDraw.line(x1, y0, x1, y1);    // right vertical segment of the H
        StdDraw.line(x0,  y, x1,  y);    // connect the two vertical segments of the H
    }

    // plot an order n H-tree, centered on (x, y) of the given side length
    public static void draw(int n, double x, double y, double size) {
        if (n == 0) return;
        drawH(x, y, size);

        // compute x- and y-coordinates of the 4 half-size H-trees
        double x0 = x - size/2;
        double x1 = x + size/2;
        double y0 = y - size/2;
        double y1 = y + size/2;

        // recursively draw 4 half-size H-trees of order n-1
        draw(n-1, x0, y0, size/2);    // lower left  H-tree
        draw(n-1, x0, y1, size/2);    // upper left  H-tree
        draw(n-1, x1, y0, size/2);    // lower right H-tree
        draw(n-1, x1, y1, size/2);    // upper right H-tree
    }

    // read in a command-line argument N and plot an order N H-tree
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        double x = 0.5, y = 0.5;   // center of H-tree
        double size = 0.5;         // side length of H-tree
        draw(N, x, y, size);
    }
}
