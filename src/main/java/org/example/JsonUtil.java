package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private JsonUtil() {}

    public static <T> String serialize(T obj) {
        return GSON.toJson(obj);
    }
    public static <T> T deserialize(String json, Class<T> type) {
        return GSON.fromJson(json, type);
    }
}