package com.hemebiotech.analytics;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String symptomFilePath="symptoms.txt";
        ISymptomReader symptomReader = new ReadSymptomDataFromFile(symptomFilePath);
        ISymptomWriter symptomWriter = new WriteSymptomDataToFile();
        AnalyticsCounter symptomCounter = new AnalyticsCounter(symptomReader, symptomWriter);


        List<String> symptoms = symptomCounter.getSymptoms();
        System.out.println(symptoms);
        Map<String,Integer> symptomsCountMap=symptomCounter.countSymptom(symptoms);
        Map<String,Integer>sortedSymptomMap=symptomCounter.sortSymptom(symptomsCountMap);
        symptomCounter.writeSymptoms(sortedSymptomMap);
    }
}
