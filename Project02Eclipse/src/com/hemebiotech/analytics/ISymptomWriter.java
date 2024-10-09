package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

/**
 * Interface pour l'écriture des données de symptômes vers une destination.
 * Cette interface définit la méthode pour écrire une liste de symptômes
 * avec leurs occurrences respectives.
 */
public interface ISymptomWriter {

    /**
     * Écrit une liste de symptômes avec leurs occurrences respectives vers une destination de données.
     * La méthode d'implémentation déterminera la destination spécifique (par exemple, un fichier).
     *
     * @param symptoms Une Map où la clé est le nom du symptôme (String) et la valeur est le nombre d'occurrences (Integer)
     * @throws IOException Si une erreur survient lors de l'écriture des données
     */
    void writeSymptoms(Map<String, Integer> symptoms) throws IOException;
}