package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadSymptomDataFromFile implements ISymptomReader {

    private String filepath;

    /**
     * @param filepath chemin vers un fichier contenant des string de symptômes, une par ligne
     */
    public ReadSymptomDataFromFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Lit les symptômes à partir du fichier et les retourne sous forme de liste.
     *
     * @return Une liste de tous les symptômes lus dans le fichier
     */
    @Override
    public List<String> GetSymptoms() {
        ArrayList<String> result = new ArrayList<String>();

        if (filepath != null) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filepath));
                String line = reader.readLine();

                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

}
