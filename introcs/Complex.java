/*************************************************************************
 *  Compilation:  javac Complex.java
 *  Execution:    java Complex
 *
 *  ADT for complex numbers using polar representation.
 *
 *  % java Complex
 *  a = 5.0 + 6.0i
 *  b = -2.0000000000000004 + 2.9999999999999996i
 *  c = -27.999999999999996 + 2.9999999999999876i
 *
 *************************************************************************/

public final class Complex {
    private double r;        // distance
    private double theta;    // angle

    // constructor that takes in rectangular coordinates
    public Complex(double re, double im) {
        r     = Math.sqrt(re*re + im*im);
        theta = Math.atan2(im, re);
    }

    // accessor methods
    public double re() { return r * Math.cos(theta); }
    public double im() { return r * Math.sin(theta); }

    // return a string representation of this complex number
    public String toString()  {
        return re() + " + " + im() + "i";
    }

    // return this Complex number plus b
    public Complex plus(Complex b) {
        Complex a = this;
        double re = a.r * Math.cos(a.theta) + b.r * Math.cos(b.theta);
        double im = a.r * Math.sin(a.theta) + b.r * Math.sin(b.theta);
        return new Complex(re, im);
    }

    // return this Complex number times b
    public Complex times(Complex b) {
        Complex a = this;
        Complex c = new Complex(0, 0);
        c.r = a.r * b.r;                // can't make r and theta final
        c.theta = a.theta + b.theta;    // because of these two statements
        return c;
    }

    // return the magnitude / absolute value of this complex number
    public double abs() { return r; }


    // sample client for testing - calculates roots of unity
    public static void main(String[] args) {
        Complex a = new Complex(5.0, 6.0);
        System.out.println("a = " + a);

        Complex b = new Complex(-2.0, 3.0);
        System.out.println("b = " + b);

        Complex c = b.times(a);
        System.out.println("c = " + c);
    }

}
