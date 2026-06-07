package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonWriter {
    private static final Logger logger = Logger.getLogger(JsonWriter.class.getName());
    private JsonWriter() {}

    public static void writeRoot(Root root, String filePath){
        new File("jsonReqs").mkdirs();
        logger.info("Запись JSON начата");
        try {
            String json = JsonUtil.serialize(root);
            Files.writeString(Path.of(filePath), json);
            logger.info("JSON записан: " + filePath);

        }
        catch (IOException e){
            logger.log(Level.SEVERE, "Ошибка записи JSON", e);
        }

    }
}
