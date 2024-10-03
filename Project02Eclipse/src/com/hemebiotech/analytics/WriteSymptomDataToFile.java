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
     * @param filePath a full or partial path to file with symptom count data
     */
    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Writes the symptom data to a file.
     * Each symptom and its count are written on a new line in the format "symptom: count".
     *
     * @param symptoms a map containing symptom names as keys and their counts as values
     * @throws RuntimeException if an IOException occurs during file writing
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            logger.info("Symptoms successfully written to file: " + filePath);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "An error occurred while writing symptoms to file: " + filePath, e);
        }
    }
}

