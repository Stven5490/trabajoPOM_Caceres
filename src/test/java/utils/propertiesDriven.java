package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class propertiesDriven {
    public static String obtenerProperties(String key){
        Properties properties = new Properties();
        String rutaArchivo = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";
        try {
            InputStream inputStream = new FileInputStream(rutaArchivo);
            properties.load(inputStream);
        }catch (Exception exception){
            System.err.println("No se ha podido cargar el archivo properties");
            System.err.println("Ruta: " + rutaArchivo);
            System.err.println(exception.getMessage());
        }
        return properties.getProperty(key);
    }
}
