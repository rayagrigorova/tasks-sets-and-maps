package SetsAndMaps;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class CountKeywordsMap {
	public static void main(String[] args) throws Exception {
		File file = new File("src/demo/TestClassMaps.java");
		countKeywords(file);

	}

	public static void countKeywords(File file) throws Exception {
// Array of all Java keywords + true, false and null
		String[] keywordString = { "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
				"const", "continue", "default", "do", "double", "else", "enum", "extends", "for", "final", "finally",
				"float", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
				"new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super",
				"switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while",
				"true", "false", "null" };
		Set<String> keywordSet = new HashSet<String>(Arrays.asList(keywordString));

		Map <String, Integer> occurancesMap = new HashMap <>();
		Scanner input = new Scanner(file);
		while (input.hasNext()) {
			String s = input.nextLine();
			s = removeSymbols(s);
			String[] words = s.split(" ");
			
			for(int i = 0; i < words.length; i++) {
				if (keywordSet.contains(words[i]) && !backslashes(words, i) && !inCommas(words, i)) {
					String key = words[i].toLowerCase();
					if (key.length() > 0) {
						if (!occurancesMap.containsKey(key)) {
							occurancesMap.put(key, 1);
						} else {
							int value = occurancesMap.get(key);
							value++;
							occurancesMap.put(key, value);
						}
					}
				}
			}

		}
		System.out.print(occurancesMap);
	}
	
	public static boolean backslashes(String [] words, int i) {
		for(int j = 0; j < i; j++) {
			if(words[j].contains("//") && !inCommas(words, j))return true;
		}
		// if we have something like //true, it will simply not be true in keywordSet.contains(words[i]), so it's not a problem
		return false;
	}
	
	public static boolean inCommas(String [] words, int i) {
		int before = 0 , after = 0;
		for(int j = 0; j < i; j++) {
			if(words[j].contains("\"")) {
				int x = words[j].length() - words[j].replaceAll("\"","").length();
				before += x;
			}
		}

		for(int j = i + 1; j < words.length; j++) {
			if(words[j].contains("\"")) {
			int x = words[j].length() - words[j].replaceAll("\"","").length();
			after += x;
			}
		}
		
		return (before % 2 != 0 && after % 2 != 0);
	}
	
	public static String removeSymbols(String line) {
		for(int j = 0; j < line.length(); j++) {
			//remove unwanted characters
			if(!Character.isLetter(line.charAt(j)) && line.charAt(j) != '\"' && line.charAt(j) != '/') {
				line = line.replace(line.charAt(j), ' ');
			}
			
		}
		return line;
	}
	
	
}