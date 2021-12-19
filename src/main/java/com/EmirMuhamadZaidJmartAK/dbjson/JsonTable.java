package com.EmirMuhamadZaidJmartAK.dbjson;
import java.io.*;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Vector;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

/**
 * JsonTableClass for managing .json files
 * @param <T>
 */

public class JsonTable<T> extends Vector<T>
{
    private static final Gson gson = new Gson();
    public final String filepath;

    /**
     * read the .json file with the provided filepath
     * @param clazz
     * @param filepath
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public JsonTable(Class<T> clazz, String filepath) throws IOException
    {
        this.filepath = filepath;
        try
        {
            Class<T[]> arrayType = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
            T[] loaded = readJson(arrayType, filepath);
            if (loaded != null)
                Collections.addAll(this, loaded);
        }
        catch (FileNotFoundException e) {}
    }

    /**
     * write JSON to the .json file with filepath as the path
     * @throws IOException
     */
    public void writeJson() throws IOException
    {
        writeJson(this, this.filepath);
    }

    /**
     * if the program doesn't detect the file that is specified
     * at filepath, it will try to create it with the requested subdirectory
     * @param object
     * @param filepath
     * @throws IOException
     */
    public static void writeJson(Object object, String filepath) throws IOException
    {
        File file = new File(filepath);
        if (!file.exists())
        {
            File parent = file.getParentFile();
            if (parent != null)
                parent.mkdirs();
            file.createNewFile();
        }
        final FileWriter writer = new FileWriter(filepath);
        writer.write(gson.toJson(object));
        writer.close();
    }

    /**
     * different methods of reading the JSON to a new class
     * @param clazz
     * @param filepath
     * @param <T>
     * @return
     * @throws FileNotFoundException
     */
    public static <T> T readJson(Class<T> clazz, String filepath) throws FileNotFoundException
    {
        final JsonReader reader = new JsonReader(new FileReader(filepath));
        return gson.fromJson(reader, clazz);
    }
}