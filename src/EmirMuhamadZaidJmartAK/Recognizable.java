package EmirMuhamadZaidJmartAK;



public class Recognizable
{
 
    public final int id;

    protected Recognizable (int id){
        this.id = id;
    }

    public boolean equals(Object recognizable)
    {
         return (recognizable instanceof Recognizable)  && ((Recognizable) recognizable).id == id;
    }
    public boolean equals(Recognizable recognizable){
        return recognizable.id == id;
    }

}
