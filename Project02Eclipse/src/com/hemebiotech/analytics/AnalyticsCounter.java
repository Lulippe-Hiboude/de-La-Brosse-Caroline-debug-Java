package com.hemebiotech.analytics;

import java.util.*;
import java.util.stream.Collectors;

public class AnalyticsCounter {
	private static final int headacheCount = 0;
	private static final int rashCount = 0;
	private static final int pupilCount = 0;

	private static ISymptomWriter writer;
	private static ISymptomReader reader;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer){
		AnalyticsCounter.reader = reader;
		AnalyticsCounter.writer = writer;
	}

	public  List <String> getSymptoms() {    // renommer la méthode dans le main mais aussi dans l'interface et la class
		return reader.getSymptoms();
	}

	public  Map<String,Integer> countSymptom(List<String> symptomsList){
		Map<String,Integer> symptomCountMap = symptomsList.stream().collect(Collectors.toMap(k->k, v->1, Integer::sum,HashMap::new));
		System.out.println(symptomCountMap);
		return symptomCountMap;
	}

	public  Map<String,Integer> sortSymptom(Map<String, Integer> symptomsMap){
		Map<String,Integer>sortedSymptomMap = new TreeMap<>(symptomsMap);
		for(Map.Entry<String,Integer> entry: sortedSymptomMap.entrySet()){
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		return sortedSymptomMap;
	}

	public void writeSymptoms(Map<String,Integer>symptomsMap){
		writer.writeSymptoms(symptomsMap);
	}

	public static void main(String[] args) throws Exception {

		String symptomFilePath="symptoms.txt";
		ISymptomReader symptomReader = new ReadSymptomDataFromFile(symptomFilePath);
		ISymptomWriter symptomWriter = new WriteSymptomDataToFile();
		AnalyticsCounter symptomCounter = new AnalyticsCounter(symptomReader, symptomWriter);


		List<String> symptoms = symptomCounter.getSymptoms();
		System.out.println(symptoms);
		Map<String,Integer>symptomsCountMap=symptomCounter.countSymptom(symptoms);
		Map<String,Integer>sortedSymptomMap=symptomCounter.sortSymptom(symptomsCountMap);
		symptomCounter.writeSymptoms(sortedSymptomMap);

		/*BufferedReader symptomReader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = symptomReader.readLine();



		int i = 0;
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = symptomReader.readLine();
		}

		FileWriter symptomWriter = new FileWriter ("result.out");
		symptomWriter.write("headache: " + headacheCount + "\n");
		symptomWriter.write("rash: " + rashCount + "\n");
		symptomWriter.write("dialated pupils: " + pupilCount + "\n");
		symptomWriter.close();
*/





	}
}
