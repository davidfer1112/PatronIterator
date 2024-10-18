package org.example.iteratorPattern;

public interface ProfileIterator<T> {
    T getNext();
    boolean hasNext();
}
