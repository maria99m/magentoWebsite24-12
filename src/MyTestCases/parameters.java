package MyTestCases;

import java.util.Random;

public class parameters {
	
	Random rand = new Random();
	
	//ضيفي 10 اسماء للكل 
	String[] FirstNames = {"jjjj","gggg","gggg"};
	
	String[] LastNames = {"adf","fff","fff"};
	
	String CommonPassword = "asd12345**555" ;

	int randomIndex = rand.nextInt(3);
	
	int randomEmailId = rand.nextInt(9999);
	
	String Emailid = FirstNames[randomIndex] + LastNames[randomIndex]+ randomEmailId + "@" + "gmail.com";
	
}
