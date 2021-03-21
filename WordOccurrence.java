package SetsAndMaps;

import java.util.Map;
import java.util.Map.Entry;

public class WordOccurrence implements Comparable <WordOccurrence> {
	String word;
	int occurrences;

	public WordOccurrence(){
		word = "";
		occurrences = 0;
	}
	public WordOccurrence(String word, int occurrences){
		this.word = word;
		this.occurrences = occurrences;
	}
	
	@Override
	public int compareTo(WordOccurrence o) {
		// TODO Auto-generated method stub
		if(this.occurrences > o.occurrences)return 1;
		else if(this.occurrences == o.occurrences)return 0;
		else return -1;
	}
}
