package com.hemebiotech.analytics;

import java.io.FileWriter;

public class AnalyticsCounter {
    private static int headCount = 0;
    private static int rashCount = 0;
    private static int pupilCount = 0;

    public static void main(String[] args) throws Exception {

        var allDatas = new ReadSymptomDataFromFile("symptoms.txt").GetSymptoms();
        for (String symptom : allDatas) {
            System.out.println("symptom from file: " + symptom);
            if (symptom.equals("headache")) {
                headCount++;
                System.out.println("number of headaches: " + headCount);
            } else if (symptom.equals("rash")) {
                rashCount++;
                System.out.println("number of rash: " + rashCount);
            } else if (symptom.contains("pupils")) {
                pupilCount++;
            }

        }

        FileWriter writer = new FileWriter("result.out");
        writer.write("headache: " + headCount + "\n");
        writer.write("rash: " + rashCount + "\n");
        writer.write("dilated pupils: " + pupilCount + "\n");
        writer.close();
    }
}