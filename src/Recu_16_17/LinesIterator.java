package Recu_16_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinesIterator implements Iterator<String> {

    private final BufferedReader reader;
    private String peek;

    public LinesIterator(BufferedReader reader) {
        this.reader = reader;
        peekElement();
    }

    private void peekElement() {
        // Prec: peek == null
        try {
            peek = reader.readLine();
        } catch (IOException e) {
            peek = null;
        }
    }

    public boolean hasNext() {
        return peek != null;
    }

    public String next() {
        if (peek == null)
            throw new NoSuchElementException("no more elements");
        String next = peek;
        peek = null;
        peekElement();
        return next;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}