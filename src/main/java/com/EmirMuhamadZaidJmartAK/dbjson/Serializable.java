package com.EmirMuhamadZaidJmartAK.dbjson;

import java.util.HashMap;

/**
 * serializable for managing id
 */
public class Serializable implements Comparable<Serializable> {
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();
    public final int id;

    /**
     * count up for every new id
     */
    protected Serializable() {
        Integer counter = mapCounter.get(getClass());
        counter = counter == null ? 0 : counter + 1;
        mapCounter.put(getClass(), counter);
        this.id = counter;
    }

    /**
     * edit the underlying ID
     * @param clazz
     * @param id
     * @param <T>
     * @return
     */
    public static <T extends Serializable> Integer setClosingId(Class<T> clazz, int id) {
        return mapCounter.put(clazz, id);
    }

    /**
     * return the underlying ID
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T extends Serializable> Integer getClosingId(Class<T> clazz) {
        return mapCounter.get(clazz);
    }


    /**
     * check if the object is a template of Serializable and verify if the id is the same
     * @param other
     * @return
     */
    public boolean equals(Object other) {
        return other instanceof Serializable && ((Serializable) other).id == id;
    }

    /**
     * if it turns out the object is actually a Serializable object, then just check the id of one and another
     * @param other
     * @return
     */
    public boolean equals(Serializable other) {
        return other.id == id;
    }

    /**
     * Serializable implementsComparable
     * @param other
     * @return
     */
    @Override
    public int compareTo(Serializable other) {
        return Integer.compare(this.id, other.id);
    }
}
