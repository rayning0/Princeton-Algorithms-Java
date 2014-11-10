/*************************************************************************
 *  Compilation:  javac Document.java
 *  Execution:    java Document < docs.txt
 *
 *  % java Document genomeA.txt 2 16
 *
 *
 *************************************************************************/

public class Document {
    private final String id;        // file name or URL
    private Vector profile;         // unit vector

    public Document(String name, int k, int d) {
        id = name;
        String doc = (new In(name)).readAll();
        int N = doc.length();
        double[] freq = new double[d];
        for (int i = 0; i < N-k; i++) {
            int h = doc.substring(i, i+k).hashCode();
            freq[Math.abs(h % d)] += 1;
        }
        profile = (new Vector(freq)).direction();
    }

    public double simTo(Document other) {
        return profile.dot(other.profile);
    }

    public String name() {
        return id;
    }

    public static void main(String[] args) {
        String name = args[0];
        int k = Integer.parseInt(args[1]);
        int d = Integer.parseInt(args[2]);
        Document doc = new Document(name, k, d);
        System.out.println(doc.profile);
    }
}
