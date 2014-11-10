/*************************************************************************
 *  Compilation:  javac Grayscale.java
 *  Execution:    java Grayscale filename
 *
 *  Reads in an image from a file, converts it to grayscale, and
 *  displays it on the screen.
 *
 *  % java Grayscale image.jpg
 *
 *************************************************************************/

import java.awt.Color;

public class Grayscale {

    public static void main(String[] args) {
        Picture pic = new Picture(args[0]);
        int width  = pic.width();
        int height = pic.height();

        // convert to grayscale
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color color = pic.get(x, y);
                Color gray = Luminance.toGray(color);
                pic.set(x, y, gray);
            }
        }
        pic.show();
    }

}
