package EmirMuhamadZaidJmartAK;

import java.util.*;

public class Algorithm {
    protected Algorithm(){}

    public static <T> int count(T[]array , T value){
        return array.length;
    }

    public static <T> int count (Iterable<T> iterable, T value){
        int count = 0;
        for (Object i : iterable){
            count++;
        }
        return count;
    }

    public static <T> int count(Iterator<T> iterator, T value){
        int count = 0;
        if (iterator.hasNext()){
            count++;
        }
        return count;
    }

    public static <T> int count(T[] array, Predicate<T> pred){
        int count = 0;
        if (pred.equals(false)){
            return 0;
        }

        for(T i: array)
        {
            count++;
        }
        return count;
    }

    public static <T> int count(Iterable<T> iterable, Predicate<T> pred){
        int count = 0;
        if (pred.equals(false)){
            return 0;
        }

        for(T i: iterable)
        {
            count++;
        }
        return count;
    }

    public static <T> int count(Iterator<T> iterator, Predicate<T> pred){
        int count = 0;
        if (pred.equals(false)){
            return 0;
        }

        if (iterator.hasNext()){
            count++;
        }
        return count;
    }

    public static <T> boolean exists(T[] array, T value) {
        boolean hasilnya = false;
        for(T i: array)

        {
            if (i.equals(value)) {
                hasilnya = true;
                break;
            }
        }
        return hasilnya;
    }

    public static <T> boolean exists(Iterable<T> iterable, T value){
        boolean hasilnya = false;
        for(T i: iterable)

        {
            if (i.equals(value)) {
                hasilnya = true;
                break;
            }
        }
        return hasilnya;
    }
    public static <T> boolean exists(Iterator<T> iterator, T value){
        boolean hasilnya = false;
        while(iterator.hasNext())
        {
            if(iterator.next().equals(value)) {
                hasilnya = true;
            }
        }
        return hasilnya;
    }
    public static <T> boolean exists(T[] array, Predicate<T> pred){
        boolean hasilnya = false;
        for(T i: array)
        {
            if (i.equals(pred)) {
                hasilnya = true;
                break;
            }
        }
        return hasilnya;
    }
    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred){
        boolean hasilnya = false;
        for(T i: iterable)
        {
            if (i.equals(pred)) {
                hasilnya = true;
                break;
            }
        }
        return hasilnya;
    }

    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred){
        boolean hasilnya = false;
        while(iterator.hasNext())
        {
            if(iterator.next().equals(pred)) {
                hasilnya = true;
            }
        }
        return hasilnya;
    }

    public static <T> T find(T[] array, T value) {
        for (T i : array){
            if(i.equals(value)){
                return i;
            }
        }
        //klo g ketemu
        return null;
    }

    public static <T> T find(Iterable<T> iterable, T value) {
        for (T i : iterable){
            if(i.equals(value)){
                return i;
            }
        }
        //klo g ketemu
        return null;
    }

    public static <T> T find(Iterator<T> iterator, T value) {
        while (iterator.hasNext()){
            if(iterator.next().equals(value)){
                return iterator.next();
            }
        }
        //klo g ketemu
        return null;
    }

    public static <T> T find(T[] array, Predicate<T> pred) {
        for (T i: array){
            if(i.equals(pred)){
                return i;
            }
        }
        //klo g ketemu
        return null;
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
        for (T i: iterable){
            if(i.equals(pred)){
                return i;
            }
        }
        //klo g ketemu
        return null;
    }

    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()){
            if(iterator.next().equals(pred)){
                return iterator.next();
            }
        }
        //klo g ketemu
        return null;
    }

    public static <T> T max(T first, T second) {return null;}
    public static <T> T min(T first, T second) {return null;}
    }
