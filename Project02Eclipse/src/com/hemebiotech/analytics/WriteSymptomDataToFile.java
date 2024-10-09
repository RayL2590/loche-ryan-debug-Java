package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class WriteSymptomDataToFile implements ISymptomWriter {

    private static final Logger logger = Logger.getLogger(WriteSymptomDataToFile.class.getName());
    private final String filePath;

    /**
     * @param filePath un chemin vers le fichier contenant les données de comptage des symptômes
     */
    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Écrit les données des symptômes dans un fichier.
     * Chaque symptôme et son décompte sont inscrits sur une nouvelle ligne au format « symptôme : décompte ».
     *
     * @param symptoms une map contenant les noms des symptômes comme clés et leur nombre comme valeurs
     * @throws RuntimeException si une erreur se produit pendant l'écriture du fichier
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            logger.info("Les symptômes ont été enregistrés avec succès dans le fichier : " + filePath);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Une erreur s'est produite lors de l'écriture des symptômes dans le fichier : " + filePath, e);
        }
    }
}

