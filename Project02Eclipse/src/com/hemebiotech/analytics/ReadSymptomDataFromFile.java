package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * optimize implementation for reading symptom data from a file.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
	private static final String BASE_PATH ="src/resources/";
	private final String filePath;
	
	/**
	 * Constructor to initialize the file path.
	 *
	 * @param fileName the name of the file and his extension containing symptom strings, one per line
	 */
	public ReadSymptomDataFromFile (final String fileName) {
		this.filePath = BASE_PATH + fileName;
	}

	/**
	 * Reads all symptoms from the file specified by filePath.
	 * If no data is available, return an empty list.
	 *
	 * @return a raw listing of all symptoms, duplicates possible.
	 */
	@Override
	public List<String> getSymptoms() {
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
			return reader.lines().collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return List.of();
	}
}
