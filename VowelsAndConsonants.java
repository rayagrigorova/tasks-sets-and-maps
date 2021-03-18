package SetsAndMaps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;


public class VowelsAndConsonants {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Character[] vowels = {'A', 'E', 'I', 'O',  'U'};
		Set <Character> vowelsSet = new HashSet <Character>(Arrays.asList(vowels));
		
		int vowelsCount = 0, consonantsCount = 0;
		
		Scanner sc = new Scanner( VowelsAndConsonants.class.getResourceAsStream("lessLetters.txt"));
		while (sc.hasNextLine()) {
				String data = sc.next();
				for(int i = 0; i < data.length(); i++) {
					//if the vowelsSet contains the current character to upper case, then it is a vowel
					//toUpperCase() on symbols like .," doesn't do anything
					if(vowelsSet.contains(Character.toUpperCase(data.charAt(i)))) {
						vowelsCount++;
					}
					//else if it is a letter, it must be a consonant
					else if(Character.isLetter(data.charAt(i))) {
						consonantsCount++;
					}
					//else, it is neither a consonant nor a vowel
				}

		}
		System.out.println("Vowels: " + vowelsCount + " Consonants: " + consonantsCount);
		sc.close();
	}
	
}
