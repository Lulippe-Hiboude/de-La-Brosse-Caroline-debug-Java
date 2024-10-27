package com.hemebiotech.analytics;

import java.util.List;

/**
 * Interface for reading symptom data from a source.
 * The implementation does not need to order the list
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible
	 */
	List<String> getSymptoms ();
}
