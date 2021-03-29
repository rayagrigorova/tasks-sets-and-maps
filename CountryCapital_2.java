package SetsAndMaps;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class CountryCapital_2 {
	//some countries have more than one capital (for example South Africa) So all the capitals a country has must be correct answers 
	public static void main(String[] args) throws FileNotFoundException {
		Map <String, String> countryCapital = new HashMap<String, String>();

		//Read the names of capitals and countries from file 
		File file = new File("src/SetsAndMaps/capitalCountry");
		Scanner input = new Scanner(file);
		while(input.hasNext()) {
			String s = input.nextLine();
			String [] cc = s.split("-");
			countryCapital.put(cc[0], cc[1]);		
		}
		List<String> countryCapitalList = new ArrayList<>(countryCapital.keySet());

		int points = 0;
		Scanner sc = new Scanner(System.in);
		while(true) {		
			Collections.shuffle(countryCapitalList);
			for(int i = 0; i < 5; i++) {
				String val = countryCapital.get(countryCapitalList.get(i));
			
				System.out.println("What's the capital of " + val.trim() + "?");
				String ans = sc.nextLine();
				if(ans.equalsIgnoreCase(countryCapitalList.get(i).trim())) {
					System.out.println("Correct!");
					points++;
				}
				else {
					System.out.println("Sorry, wrong answer.");
					points--;
				}
			}
			
			System.out.println("Points: " + points);
			
			System.out.println("Do you want to play again?(Yes/No)");
			String ans = sc.next();
			boolean playAgain = true;
			switch(ans.toLowerCase()) {
			case "no": playAgain = false; break;
			case "yes": playAgain = true; break;
			default: System.out.println("Invalid input");
			}
			if(!playAgain) break;
			else sc.nextLine();
		}
	}
}
