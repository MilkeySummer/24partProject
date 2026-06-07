package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlWriter {
    private static final Logger logger = Logger.getLogger(XmlWriter.class.getName());
    private XmlWriter() {}

    public static void writeRoot(Root root, String filePath){
        new File("xmlReqs").mkdirs();
        logger.info("Запись XML начата");
        try {
            JAXBContext context = JAXBContext.newInstance(Root.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(root, new File(filePath));
            logger.info("XML записан: " + filePath);
        }
        catch (JAXBException e){
            logger.log(Level.SEVERE, "Ошибка записи XML", e);
        }

    }
}
