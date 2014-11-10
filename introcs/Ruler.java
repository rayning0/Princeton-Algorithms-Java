
/*************************************************************************
 *  Compilation:  javac Ruler.java
 *  Execution:    java Ruler
 *  
 *  Prints the relative lengths of the subdivisions on a ruler.
 * 
 *  % java Ruler
 *  1 
 *  1 2 1 
 *  1 2 1 3 1 2 1 
 *  1 2 1 3 1 2 1 4 1 2 1 3 1 2 1 
 *  1 2 1 3 1 2 1 4 1 2 1 3 1 2 1 5 1 2 1 3 1 2 1 4 1 2 1 3 1 2 1 
 *
 *************************************************************************/

public class Ruler { 
    public static void main(String[] args) { 
        String ruler1 = " 1 ";
        String ruler2 = ruler1 + "2" + ruler1;
        String ruler3 = ruler2 + "3" + ruler2;
        String ruler4 = ruler3 + "4" + ruler3;
        String ruler5 = ruler4 + "5" + ruler4;

        System.out.println(ruler1);
        System.out.println(ruler2);
        System.out.println(ruler3);
        System.out.println(ruler4);
        System.out.println(ruler5);
    }

}
