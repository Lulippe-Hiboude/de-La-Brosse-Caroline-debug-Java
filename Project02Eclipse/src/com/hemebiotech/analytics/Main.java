package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * The Main class serves as the entry point for the application.
 */
public class Main {
    /**
     * The main method initializes necessary components and executes the workflow for processing symptoms data.
     *
     * @param args command-line arguments (not used in this implementation)
     */
    public static void main(String[] args) {
        // Initialization of necessary components
        String symptomFilePath="symptoms.txt";
        String resultFilePath="result.out";
        ISymptomReader symptomReader = new ReadSymptomDataFromFile(symptomFilePath);
        ISymptomWriter symptomWriter = new WriteSymptomDataToFile(resultFilePath);
        AnalyticsCounter symptomCounter = new AnalyticsCounter(symptomReader, symptomWriter);

        // Symptom recovery and processing
        List<String> symptoms = symptomCounter.getSymptoms();
        Map<String,Integer> symptomsCountMap=symptomCounter.countSymptom(symptoms);
        Map<String,Integer>sortedSymptomsMap=symptomCounter.sortSymptom(symptomsCountMap);

        // writing results
        symptomCounter.writeSymptoms(sortedSymptomsMap);
    }
}
