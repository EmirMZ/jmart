package EmirMuhamadZaidJmartAK;



public class Recognizable implements Comparable<Recognizable>{
    protected Recognizable (){
        this.id = 1;
    }
    public final int id;

    public static <T> int setClosingId(Class<T>clazz){
        if(clazz.isAssignableFrom(Recognizable.class)){
            return 0;
        }else{
            return 1;
        }

    }

    public static <T> int getClosingId(Class<T>clazz,int id){
        if(clazz.isAssignableFrom(Recognizable.class)){
            return 0;
        }else{
            return 1;
        }
    }

    /*public boolean equals(Object recognizable)
    {
         return (recognizable instanceof Recognizable)  && ((Recognizable) recognizable).id == id;
    }*/
    public boolean equals(Recognizable recognizable){
        return recognizable.id == id;
    }

    //@Override
    public int compareTo(Recognizable other) {
        return other.id/this.id;
    }


}
