package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Optimized implementation for writing symptom data to a destination
 */
public class WriteSymptomDataToFile implements ISymptomWriter{
    private final String outputFilePath;

    /**
     * Constructor to initialize the file path.
     *
     * @param outputFilePath a full or partial path to file with symptoms and their corresponding occurrences,
     *                       one per line
     */
    public WriteSymptomDataToFile(String outputFilePath){
        this.outputFilePath = outputFilePath;
    }
    /**
     *Writes all symptoms and their corresponding occurences into the file specified by filepath.
     * If the file does not already exist, it is created.
     * If the file already exist, it is overwritten.
     *
     * @param symptoms A map containing symptoms and their corresponding occurrences.
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try(BufferedWriter writer =new BufferedWriter(new FileWriter(outputFilePath))){
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
                writer.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
