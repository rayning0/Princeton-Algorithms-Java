
/*************************************************************************
 *  Compilation:  javac BST.java
 *  Execution:    java BST
 *
 *  A symbol table implemented with a binary search tree.
 * 
 *  % java BST
 *  size = 17
 *  128.112.136.35
 *  207.171.163.90
 *  null
 *
 *************************************************************************/


import java.util.Iterator;
import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Val> implements Iterable<Key> {
    private Node root;          // root of BST
    private int N;              // number of nodes

    private class Node {
        private Key key;              // sorted by key
        private Val val;              // associated data
        private Node left, right;     // left and right subtrees

        Node(Key key, Val val) {
            this.key = key;
            this.val = val;
            N++;
        }
    }

    public BST() {
        root = null;
        N = 0;
    }

    public int size() { return N; }

   /***********************************************************************
    *  Insert key-value pair into BST
    *  If key already exists, update with new value
    ***********************************************************************/
    public void put(Key key, Val value) {
        if (value == null) delete(key);
        root = insert(root, key, value);
    }

    private Node insert(Node x, Key key, Val value) {
        if (x == null) return new Node(key, value);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = insert(x.left,  key, value);
        else if (cmp > 0) x.right = insert(x.right, key, value);
        else x.val = value;
        return x;
    }


   /***********************************************************************
    *  Search BST for given key, and return associated value if found,
    *  return null if not found
    ***********************************************************************/
    // does there exist a key-value pair with given key?
    public boolean contains(Key key) {
        return get(key) != null;
    }

    // return value associated with the given key, or null if no such key exists
    public Val get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }


   /***********************************************************************
    *  Delete key and associated value.
    ***********************************************************************/
    public void delete(Key key) {
        throw new RuntimeException("Deletion operation not supported");
    }

   /***********************************************************************
    *  Iterate using an inorder traversal. Implement with a stack.
    *  Iterating through N elements takes O(N) time.
    ***********************************************************************/
    public Iterator<Key> iterator() { return new Inorder(); }

    // an iterator
    private class Inorder implements Iterator<Key> {
        private Stack<Node> stack = new Stack<Node>();

        Inorder() { pushLeft(root); }

        // don't implement remove() - it's optional and would mutate the BST
        public void remove()      { throw new UnsupportedOperationException();  }
        public boolean hasNext()  { return !stack.isEmpty();                    }

        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            Node x = stack.pop();
            pushLeft(x.right);
            return x.key;
        }

        public void pushLeft(Node x) {
            while (x != null) {
                stack.push(x);
                x = x.left;
            }
        }

    }



    // sample client
    public static void main(String[] args) {
        BST<String, String> st = new BST<String, String>();

        // insert some key-value pairs
        st.put("www.cs.princeton.edu",   "128.112.136.11");
        st.put("www.cs.princeton.edu",   "128.112.136.35");    // overwrite old value
        st.put("www.princeton.edu",      "128.112.130.211");
        st.put("www.math.princeton.edu", "128.112.18.11");
        st.put("www.yale.edu",           "130.132.51.8");
        st.put("www.amazon.com",         "207.171.163.90");
        st.put("www.simpsons.com",       "209.123.16.34");
        st.put("www.stanford.edu",       "171.67.16.120");
        st.put("www.google.com",         "64.233.161.99");
        st.put("www.ibm.com",            "129.42.16.99");
        st.put("www.apple.com",          "17.254.0.91");
        st.put("www.slashdot.com",       "66.35.250.150");
        st.put("www.whitehouse.gov",     "204.153.49.136");
        st.put("www.espn.com",           "199.181.132.250");
        st.put("www.snopes.com",         "66.165.133.65");
        st.put("www.movies.com",         "199.181.132.250");
        st.put("www.cnn.com",            "64.236.16.20");
        st.put("www.iitb.ac.in",         "202.68.145.210");

        // search for IP addresses given URL
        StdOut.println("size = " + st.size());
        StdOut.println(st.get("www.cs.princeton.edu"));
        StdOut.println(st.get("www.amazon.com"));
        StdOut.println(st.get("www.amazon.edu"));
        StdOut.println();

        // test out the iterator
        for (String s : st)  {
            StdOut.println(s);
        }
    }
}
