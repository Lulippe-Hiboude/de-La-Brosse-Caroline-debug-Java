package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Optimized implementation for writing symptom data to a destination
 */
public class WriteSymptomDataToFile implements ISymptomWriter{
    private static final String BASE_PATH ="src/resources/";
    private final String outputFilePath;

    /**
     * Constructor to initialize the file path.
     *
     * @param outputFileName the name of the file and his extension containing symptoms and their corresponding occurrences,
     *                       one per line
     */
    public WriteSymptomDataToFile(final String outputFileName){
        this.outputFilePath = BASE_PATH + outputFileName;
    }
    /**
     *Writes all symptoms and their corresponding occurences into the file specified by filepath.
     * If the file does not already exist, it is created.
     * If the file already exist, it is overwritten.
     *
     * @param symptoms A map containing symptoms and their corresponding occurrences.
     */
    @Override
    public void writeSymptoms(final Map<String, Integer> symptoms) {
        try(BufferedWriter writer =new BufferedWriter(new FileWriter(outputFilePath))){
            symptoms.entrySet().stream().forEach(entry->{
                try {
                    writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
                    writer.newLine();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
