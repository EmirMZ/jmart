package EmirMuhamadZaidJmartAK;

import java.util.*;
import java.util.Iterator;

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

    public static <T> T max(T first, T second) {
        if(first.hashCode()>second.hashCode()){
            return first;
        }else {
            return second;
        }
        }

    public static <T> T max(T[] array){
        int max = 0;
        T maxT = null;
        for (T t : array) {
            if (t.hashCode() > max) {
                max = t.hashCode();
                maxT = t;
            }
        }
        return maxT;
    }
    public static <T> T max(Iterator<T>iterator , T value){
        if(iterator.next().hashCode()>value.hashCode()){
            return iterator.next();
        }else {
            return value;
        }
    }
    public static <T> T max(Iterable<T>iterable , T value){
        if(iterable.hashCode()>value.hashCode()){
            return (T) iterable;
        }else {
            return value;
        }
    }
    public static <T> T max(T first , T second, Comparator<?super T>comparator){
        int res = ((Comparable<T>) first).compareTo(second);
        return res == -1 ? second : first;
    }
    public static <T> T max(T[] array, Comparator<?super T>comparator){
        int max = 0;
        T maxT = null;
        for (T t : array) {
            if (t.hashCode() > max) {
                max = t.hashCode();
                maxT = t;
            }
        }
        int res = ((Comparable<T>) comparator).compareTo((T) array);
        return max(array, comparator);
    }
    public static <T> T max(Iterator<T>iterator , T value, Comparator<?super T>comparator){
        int res = ((Comparable<T>) iterator).compareTo(value);
        if(iterator.next().hashCode()>value.hashCode()){
            return iterator.next();
        }else {
            return value;
        }
    }

    public static <T extends Comparable<? super T>> T min(T first, T second) {
        if(first.compareTo(second)<0){
            return first;
        }else{
            return second;
        }
    }

    public static <T extends Comparable<? super T>> T min(T[] array) {
        int min = 0;
        T result = null;
        for (T i : array) {
            if (i.hashCode() < min) {
                min = i.hashCode();
                result = i;
            }
        }
        return result;
    }

    public static <T extends Comparable<? super T>> T min(Iterable<T>iterable){
        Iterator<T> iterator = iterable.iterator();
        int min = 0;
        T result = null;
        if (iterator.hashCode() > min){
            min = iterator.hashCode();
            result = (T) iterator;
        }
        return result;
    }

    public static <T extends Comparable<? super T>> T min(Iterator<T>iterator) {
        int min = 0;
        T result = null;
        while(iterator.hasNext()){
            if(iterator.next().hashCode() > min){
                min = iterator.next().hashCode();
                result = (T) iterator;
            }
        }
        return result;
    }

    public static <T extends Comparable<?super T>> T min (T first, T second, Comparator<? super T>comparator){
        int res = ((Comparable<T>) first).compareTo(second);
        return res == -1 ? second : first;
    }

    public static <T> T min(T first, T second) {
        if(first.hashCode()>second.hashCode()){
            return second;
        }else {
            return first;
        }
        }


    public static <T> List<T> collect(Iterable<T> iterable, T value)
    {
        List<T> list = new ArrayList<T>();
        for (T i : iterable)
        {
            if (i.equals(value))
            {
                list.add(i);
            }
        }

        return list;

    }

    public static <T> List<T> collect(Iterator<T> iterator, T value)
    {
        List<T> list = new ArrayList<T>();
        while (iterator.hasNext())
        {
            T i = iterator.next();
            if (i.equals(value))
            {
                list.add(i);
            }
        }

        return list;

    }

    public static <T> List<T> collect(T[] array, Predicate<T> pred)
    {
        List<T> list = new ArrayList<T>();
        for (T i : array)
        {
            if (pred.predicate(i))
            {
                list.add(i);
            }
        }

        return list;

    }

    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred)
    {
        List<T> list = new ArrayList<T>();
        for (T i : iterable)
        {
            if (pred.predicate(i))
            {
                list.add(i);
            }
        }

        return list;

    }

    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred)
    {
        List<T> list = new ArrayList<T>();
        while (iterator.hasNext())
        {
            T i = iterator.next();
            if (pred.predicate(i))
            {
                list.add(i);
            }
        }

        return list;

    }



}
