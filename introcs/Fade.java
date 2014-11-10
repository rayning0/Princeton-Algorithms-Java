/*************************************************************************
 *  Compilation:  javac Fade.java
 *  Execution:    java Fade N image1.jpg image2.jpg
 *  Data files:   http://introcs.cs.princeton.edu/31datatype/Darwin.jpg
 *                http://introcs.cs.princeton.edu/31datatype/mandrill.jpg
 *
 *  Produce animated effect, fading from image1.jpg to image2.jpg,
 *  using N-1 intermediate frames.
 *  
 *
 *************************************************************************/

import java.awt.Color;

public class Fade {

    public static Color combine(Color c1, Color c2, double alpha) {
        int r = (int) (alpha * c1.getRed()   + (1 - alpha) * c2.getRed());
        int g = (int) (alpha * c1.getGreen() + (1 - alpha) * c2.getGreen());
        int b = (int) (alpha * c1.getBlue()  + (1 - alpha) * c2.getBlue());
        return new Color(r, g, b);
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);     // # of frames
        Picture pic1 = new Picture(args[1]);   // begin picture
        Picture pic2 = new Picture(args[2]);   // end picture
        int width  = pic1.width();
        int height = pic1.height();
        Picture pic = new Picture(width, height);
        for (int n = 0; n <= N; n++) {
            double alpha = 1.0 * n / N;
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    Color c1 = pic1.get(i, j);
                    Color c2 = pic2.get(i, j);
                    pic.set(i, j, combine(c2, c1, alpha));
                }
            }
            pic.show();
        }
    }
}
