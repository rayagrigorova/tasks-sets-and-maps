package SetsAndMaps;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class CountryCapital_2 {
	//some countries have more than one capital (for example South Africa) So all the capitals a country has must be correct answers 
	public static void main(String[] args) throws FileNotFoundException {
		Map <String, String> capitalCountry = new HashMap<String, String>();
		ArrayList <String[]> countryCapitalList = new ArrayList <>();
		//Read the names of capitals and countries from file 
		File file = new File("src/SetsAndMaps/capitalCountry");
		Scanner input = new Scanner(file);
		while(input.hasNext()) {
			String s = input.nextLine();
			String [] cc = s.split("-");
			countryCapitalList.add(cc);
			
		}
		
		int listSize = countryCapitalList.size();
		int points = 0;
		while(true) {
			capitalCountry.clear();
			for(int i = 0; i < 5; i++) {
				Random r = new Random();
				int randomInd = r.nextInt(listSize);
				String randomCountry = countryCapitalList.get(randomInd)[1];
				String randomCapital = countryCapitalList.get(randomInd)[0];
				
				capitalCountry.put(randomCapital,randomCountry);
			}
			
			input.close();
			
			Scanner sc = new Scanner(System.in);
			Set <Map.Entry<String, String>> entrySet = capitalCountry.entrySet();
			
			for(Map.Entry<String, String> entry : entrySet ) {
				System.out.println("What's the capital of " + entry.getValue().trim() + "?");
				String ans = sc.nextLine();
				if(capitalCountry.get(ans) != null) {
					if(capitalCountry.get(ans).trim().equals(entry.getValue().trim())) {
						System.out.println("Correct!");
						points++;
					}
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
			
		
		}
	}
}
