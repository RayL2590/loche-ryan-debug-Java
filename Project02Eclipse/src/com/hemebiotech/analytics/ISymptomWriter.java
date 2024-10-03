package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {

    /**
     * Write a list of symptoms with their respective counts to a data destination
     *
     * @param symptoms a map of symptom names and their respective counts
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}