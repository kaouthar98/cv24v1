package util;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Fichier {

    public String loadFileXML() {
        Resource resource = new DefaultResourceLoader().getResource("smallCV.xml");
        StringBuilder content = new StringBuilder();

        try (InputStream inputStream = resource.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "Erreur lors de la lecture du fichier : " + e.getMessage();
        }

        return content.toString();
    }
}
