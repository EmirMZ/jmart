package EmirMuhamadZaidJmartAK;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Vector;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class JsonTable<T> extends Vector<T> {
    public final String filepath;
    private static final Gson gson = new Gson();

    public JsonTable(Class<T>clazz, String filepath) throws IOException {
        this.filepath = filepath;
        @SuppressWarnings("unchecked")
        Class<T[]> array = (Class<T[]>) Array.newInstance(clazz,0).getClass();

        T[] result = JsonTable.readJson(array,this.filepath);
        Collections.addAll(this,result);

    }

    public static <T>  T readJson(Class<T> clazz, String filepath) throws FileNotFoundException{
        JsonReader jsonReader = new JsonReader(new FileReader(filepath));
        return new Gson().fromJson(jsonReader, clazz);
    }

    public void writeJson () throws IOException {
        writeJson(this, this.filepath);
    }

    public static void writeJson(Object obj, String filepath) throws IOException {
        final FileWriter writer = new FileWriter(filepath);
        writer.write(gson.toJson(obj));
        writer.close();
    }

}
