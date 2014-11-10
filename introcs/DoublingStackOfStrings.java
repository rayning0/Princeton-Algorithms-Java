/*************************************************************************
 *  Compilation:  javac DoublingStackOfStrings.java
 *  Execution:    java DoublingStackOfStrings
 *  
 *  Stack of strings implementation with an array.
 *  Resizes by doubling and halving.
 *
 *************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublingStackOfStrings implements Iterable<String> {
    private String[] a;
    private int N;

    public DoublingStackOfStrings() {
        a = new String[2];
        N = 0;
    }

    // is the stack empty?
    public boolean isEmpty() {  return (N == 0);  }

    // resize the underlying array holding the elements
    private void resize(int capacity) {
        String[] temp = new String[capacity];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    // push a new item onto the stack
    public void push(String item) {
        if (N == a.length) resize(2*a.length);
        a[N++] = item;
    }

    // delete and return the item most recently added
    public String pop() {
        if (isEmpty()) { throw new RuntimeException("Stack underflow error"); }
        String item = a[--N];
        a[N] = null;  // to avoid loitering
        if (N > 0 && N == a.length/4) resize(a.length/2);
        return item;
    }

    public Iterator<String> iterator()  { return new ReverseArrayIterator();  }

    // an iterator, doesn't implement remove() since it's optional
    private class ReverseArrayIterator implements Iterator<String> {
        private int i = N;
        public boolean hasNext()  { return i > 0;                               }
        public void remove()      { throw new UnsupportedOperationException();  }

        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[--i];
        }
    }

    // test client
    public static void main(String[] args) {
        DoublingStackOfStrings s = new DoublingStackOfStrings();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) s.push(item);
            else if (s.isEmpty())  StdOut.println("BAD INPUT");
            else                   StdOut.print(s.pop());
        }
    }

}
