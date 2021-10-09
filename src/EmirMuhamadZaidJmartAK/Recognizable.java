package EmirMuhamadZaidJmartAK;



public class Recognizable implements Comparable<Recognizable>{
    protected Recognizable (int id){
        this.id = id;
    }
    public final int id;

    public static <T> int setClosingId(Class<T>clazz, int id){
        if(Class.class.isAssignableFrom(Recognizable.class)){
            return 0;
        }else{
            return 1;
        }

    }

    public static <T> int getClosingId(Class<T>clazz){
        if(Class.class.isAssignableFrom(Recognizable.class)){
            return 0;
        }else{
            return 1;
        }
    }





    public boolean equals(Object recognizable)
    {
         return (recognizable instanceof Recognizable)  && ((Recognizable) recognizable).id == id;
    }
    public boolean equals(Recognizable recognizable){
        return recognizable.id == id;
    }

    @Override
    public int compareTo(Recognizable other) {
        if (id == other.id) {
            return 1;
        } else {
            return 0;
        }
    }


}
