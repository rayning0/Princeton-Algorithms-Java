/*************************************************************************
 *  Compilation:  javac CompareAll.java
 *  Execution:    java CompareAll 5 10000 < docs.txt
 *
 *************************************************************************/

public class CompareAll {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int N = StdIn.readInt();
        Document[] a = new Document[N];

        // read in documents
        for (int i = 0; i < N; i++) {
            a[i] = new Document(StdIn.readString(), k, d);
        }

        // print header
        System.out.print("    ");
        for (int j = 0; j < N; j++) {
            System.out.printf("    %.4s", a[j].name());
        }
        System.out.println();

        // print N-by-N table
        for (int i = 0; i < N; i++) {
            System.out.printf("%.4s", a[i].name());
            for (int j = 0; j < N; j++) {
                System.out.printf("%8.2f", a[i].simTo(a[j]));
            }
            System.out.println();
        }
    }
}
