package com.EmirMuhamadZaidJmartAK;

/**
 * Pair class, return a pair of objects
 * @param <T>
 * @param <U>
 */
public class Pair<T, U> {
    public T first;
    public U second;

    public Pair() {}
    public Pair(T first,U second){
        this.first = first;
        this.second = second;
    }
}
