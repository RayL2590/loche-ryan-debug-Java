package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Cette classe est responsable de l'analyse des données de symptômes.
 * Elle lit les symptômes, les compte, les trie et écrit les résultats.
 */
public class AnalyticsCounter {
    private static final Logger logger = Logger.getLogger(AnalyticsCounter.class.getName());
    // Ces objets seront utilisés pour lire les symptômes et écrire les résultats
    private final ISymptomReader reader;
    private final ISymptomWriter writer;

    /**
     * Constructeur de la classe.
     *
     * @param reader Objet qui lira les symptômes depuis une source de données
     * @param writer Objet qui écrira les résultats dans un fichier
     */
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Récupère la liste de tous les symptômes depuis la source de données.
     *
     * @return Une liste de chaînes de caractères représentant les symptômes
     */
    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

    /**
     * Compte le nombre d'occurrences de chaque symptôme.
     *
     * @param symptoms Liste de tous les symptômes
     * @return Une Map où la clé est le symptôme et la valeur est le nombre d'occurrences
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomCount = new TreeMap<>();
        for (String symptom : symptoms) {
            // Si le symptôme existe déjà, on incrémente son compteur, sinon on l'initialise à 1
            //symptomCount.put(symptom, symptomCount.getOrDefault(symptom, 0) + 1);
            symptomCount.compute(symptom, (key, value) -> (value == null) ? 1 : value + 1);
        }
        return symptomCount;
    }

    /**
     * Trie les symptômes par ordre alphabétique.
     * Note : Cette méthode n'est pas strictement nécessaire car TreeMap est déjà trié,
     * mais elle est incluse pour respecter les exigences du projet.
     *
     * @param symptoms Map des symptômes et de leurs occurrences
     * @return Une nouvelle Map triée des symptômes et de leurs occurrences
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<>(symptoms);
    }

    /**
     * Écrit les symptômes et leurs occurrences dans un fichier.
     *
     * @param symptoms Map des symptômes et de leurs occurrences à écrire
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try {
            writer.writeSymptoms(symptoms);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Une erreur est survenue lors de l'écriture des symptômes", e);
        }
    }

    /**
     * Méthode principale qui orchestre le processus d'analyse des symptômes.
     * Elle appelle les autres méthodes dans l'ordre pour effectuer l'analyse complète.
     */
    public void analyzeSymptoms() {
        List<String> symptoms = getSymptoms();
        Map<String, Integer> symptomCount = countSymptoms(symptoms);
        Map<String, Integer> sortedSymptoms = sortSymptoms(symptomCount);
        writeSymptoms(sortedSymptoms);
    }
}