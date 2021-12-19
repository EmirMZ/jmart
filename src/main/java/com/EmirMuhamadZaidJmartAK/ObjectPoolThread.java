package com.EmirMuhamadZaidJmartAK;

import java.util.Vector;
import java.util.function.Function;

/**
 * object pool thread class, to manage Threads for objects
 * @param <T>
 */
public class ObjectPoolThread<T> extends Thread {
    private Function<T, Boolean> routine;
    private Vector<T> objectPool;
    private boolean exitSignal;

    /**
     * object Pool Thread constructor
     * @param name
     * @param routine
     */
    public ObjectPoolThread(String name , Function <T,Boolean> routine) {
        super(name);
        this.routine = routine;

    }

    /**
     * object Pool Thread constructor without name
     * @param routine
     */
    public ObjectPoolThread(Function<T, Boolean> routine){
        this.routine = routine;
    }

    /**
     * add object to pool
     * @param object
     */
    public synchronized  void add(T object){
        objectPool.add(object);
    }

    /**
     * if done, threads call this method
     */
    public synchronized void exit(){
        exitSignal = true;
    }

    /**
     * create and run a new thread
     */
    public void run ()
    {
        exitSignal = false;

        for(int i = 0; i < this.size(); i++)
        {
            T object = objectPool.get(i);
            boolean temp = routine.apply(object);
            if(!temp) this.objectPool.add(object);
            while(this.objectPool == null)
            {
                try{
                    routine.wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            if(exitSignal)
            {
                break;
            }
        }

    }

    /**
     * return objectPool.size
     * @return
     */
    public int size(){
        return objectPool.size();
    }
}
