package com.hemebiotech.analytics;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Analyzes and processes symptom data.
 * Provides methods for reading, counting,sorting and writing symptom data.
 */
public class AnalyticsCounter {
	private static ISymptomWriter writer;
	private static ISymptomReader reader;

	/**
	 *Constructor to initialize reader and writer.
	 *
	 * @param reader the reader to read symptom data
	 * @param writer the writer to write symptom data
	 */
	public AnalyticsCounter(final ISymptomReader reader, final ISymptomWriter writer){
		AnalyticsCounter.reader = reader;
		AnalyticsCounter.writer = writer;
	}

	/**
	 * retrieves a list of symptoms using the specified reader.
	 *
	 * @return a list of symptoms
	 */
	public  List <String> getSymptoms() {    // renommer la méthode dans le main mais aussi dans l'interface et la class
		return reader.getSymptoms();
	}

	/**
	 * Counts the occurrences of each symptom in the given list.
	 *
	 * @param symptomsList a list of symptoms
	 * @return a map of symptoms and their corresponding occurrences
	 */
	public  Map<String,Integer> countSymptom(final List<String> symptomsList){

        return symptomsList.stream()
                .collect(Collectors.toMap(
                        k->k,
                        v->1,
                        Integer::sum,
                        HashMap::new
                ));
	}


	/**
	 * Sorts the given map of symptoms by their keys in alphabetical order.
	 *
	 * @param symptomsMap a map of symptoms and their occurrences
	 * @return a sorted map of symptoms and their corresponding occurrences
	 */
	public  Map<String,Integer> sortSymptom(final Map<String, Integer> symptomsMap){

        return new TreeMap<>(symptomsMap);
	}

	/**
	 * Writes the given map of symptoms to the specified destination using the writer.
	 *
	 * @param symptomsMap a map of symptoms and their occurrences
	 */
	public void writeSymptoms(final Map<String,Integer>symptomsMap){
		writer.writeSymptoms(symptomsMap);
	}
}
