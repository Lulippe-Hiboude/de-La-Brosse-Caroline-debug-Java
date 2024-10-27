package com.hemebiotech.analytics;

import java.util.Map;

/**
 *Interface for writing symptom data to a destination.
 * The important part is, the input to the operation, which is a map of symptoms and their occurrences.
 * The implementation does not need to return a value.
 */
public interface ISymptomWriter {
    /**
     * Writes symptom data to a specified destination.
     * if no data is provided, the implementation may handle it as needed.
     *
     * @param symptoms A map containing symptoms and their corresponding occurrences
     */
    public void writeSymptoms (Map<String,Integer> symptoms);
}
