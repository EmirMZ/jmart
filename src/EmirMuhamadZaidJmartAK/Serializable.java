package EmirMuhamadZaidJmartAK;
import java.util.HashMap;
import java.util.Map;


public class Serializable implements Comparable<Serializable>{
    public  int id;
    private static HashMap<Class<?>,Integer> mapCounter = new HashMap();

    protected Serializable(){
        Integer counter = mapCounter.get(getClass());
        counter = counter == null ? 0 : counter + 1;
        mapCounter.put(getClass(), counter);
        this.id = counter;
    }



    public static <T> int setClosingId(Class<T>clazz, int id){
        return  mapCounter.put(clazz, id);

    }

    public static <T> int getClosingId(Class<T>clazz,int id){
        return  mapCounter.get(clazz);
    }

    public boolean equals(Object Serializable)
    {
         return (Serializable instanceof Serializable)  && ((Serializable) Serializable).id == id;
    }
    /*public boolean equals(Serializable serializable){
        return serializable.id == id;
    }*/

    //@Override
    public int compareTo(Serializable other) {
        return Integer.compare(this.id,other.id);
    }


}
