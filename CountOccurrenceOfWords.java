package SetsAndMaps;

import java.util.*;

public class CountOccurrenceOfWords {
	public static void main(String[] args) {
// Set text in a string
		String text = "Good morning. Have a good class. " + "Have a good visit. Have fun!";
// Create a TreeMap to hold words as key and count as value
		Map<String, Integer> map = new TreeMap<String, Integer>();
		ArrayList <WordOccurrence> wordOccurrenceArray = new ArrayList<>();
		String[] words = text.split("[ \n\t\r.,;:!?(){}]");
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();
			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				} else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}
		
// Get all entries into a set
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		
		for (Map.Entry<String, Integer> entry : entrySet) {
			WordOccurrence x  = new WordOccurrence(entry.getKey(), entry.getValue());
			wordOccurrenceArray.add(x);
		}
		Collections.sort(wordOccurrenceArray);

		for(int i = 0; i < wordOccurrenceArray.size(); i++) {
			System.out.println("word: " + wordOccurrenceArray.get(i).word + " occurrences: " + wordOccurrenceArray.get(i).occurrences);
		}

	}
}
