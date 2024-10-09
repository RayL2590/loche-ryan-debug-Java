package com.hemebiotech.analytics;

public class Main {
    /**
     * Point d'entrée de l'application.
     * Cette méthode instancie les objets nécessaires et lance l'analyse des symptômes.
     *
     * @param args Arguments de ligne de commande (non utilisés dans cette application)
     */
    public static void main(String[] args) {
        // Création des objets pour la lecture et l'écriture des symptômes
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

        // Création de l'objet AnalyticsCounter
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        // Lancement de l'analyse des symptômes
        counter.analyzeSymptoms();

        System.out.println("L'analyse des symptômes est terminée. Les résultats ont été écrits dans result.out");
    }
}
