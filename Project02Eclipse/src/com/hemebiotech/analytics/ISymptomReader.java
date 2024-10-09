package com.hemebiotech.analytics;

import java.util.List;

/**
 * Interface pour la lecture des données de symptômes à partir d'une source.
 * Cette interface définit la méthode pour obtenir une liste de symptômes.
 * La liste retournée peut contenir des duplications et n'a pas besoin d'être ordonnée.
 */
public interface ISymptomReader {
    /**
     * Récupère une liste de tous les symptômes depuis la source de données.
     * Si aucune donnée n'est disponible, cette méthode doit retourner une liste vide.
     *
     * @return Une liste brute de tous les symptômes obtenus à partir de la source de données.
     * Des doublons sont possibles et probables dans cette liste.
     */
    List<String> GetSymptoms();
}