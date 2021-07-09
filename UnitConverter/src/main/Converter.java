package main;

import java.util.InputMismatchException; //imports the InputMismatchException pack for using the exception later on
import java.util.Scanner; //imports the Scanner pack to get and use the user's input

//Using the class called "Converter"
public class Converter {

	//Using basic execution method of main(String[])
	public static void main(String[] args) { 
		
		//Calls for a scanner object to use for system inputs from user
		Scanner scan = new Scanner(System.in);
		
		//Hard coded in a value lower than 3, which will activate the first while loop automatically
		int menuSelection = 1;
		
		//While loop continues until the variable menuSelection == 3
		while (menuSelection != 3) {
			
			//Shows the user the first menu of choices for them to choose or quit the program
			System.out.println("Please choose a category: ");
			System.out.println("1. Volume Conversions");
			System.out.println("2. Distance Conversions");
			System.out.println("3. Money Conversions");
			System.out.println("4. Quit");
			
			/*Calls the menuChange() method, sends the scan object through it, 
			 * and puts it into the variable "firstChoice"
			 * 
			 * menuChange(scan) will get a value between 1 and 4
			 */
			int firstChoice = menuChange(scan);
			
			//Using a switch statement to locate which other menu to show from the first menu
			switch(firstChoice) {
			
			//Creates the first category and options to choose from
			//Will be used when user chooses 1 in first menu
			case 1: 
				//Shows text of the options to user
				System.out.println("Please select an option:");
				System.out.println("1. Cups to Pints");
				System.out.println("2. Cups to Quarts");
				System.out.println("3. Cups to Gallons");
				System.out.println("4. Back");
				
					/*Gets another value between 1 and 4 using menuChange() method 
					 * and puts it into "choice1" variable
					 */
					int choice1 = menuChange(scan);
					
				/*I attempted to create an object from "Converter" class into "cvc" variable
				 * to try and avoid using static in one of my methods
				 */
				Converter cvc = new Converter();
				
					//Allows the user to end the code short and reset to the first menu
					if(choice1 == 4) {
						//Finishes case 1
						break;
					}
					
				//While loop continues until "firstChoice" is not 1
				while(firstChoice == 1) {
					
					//Calls the convertVolumeConversions() method and puts it into the "calculation" variable
					String calculation = cvc.convertVolumeConversions(choice1, scan);
					
					//Shows the results of the previously called method
					System.out.println(calculation);
					
					/*Calls the convertAgain() method which will increase "firstChoice" 
					 * if the user does not want to go again, ending the loop
					 */
					firstChoice = convertAgain(firstChoice, scan);
				}
				//Finishes case 1
				break;
				
			/*Creates the second category and options to choose from.
			 * Will be used when user chooses 2 in first menu.
			 * Tried case 2 and 3 without the object "cvc" 
			 * Cases 2 and 3 are pretty much the same from case 1
			 */
			case 2:
				//Prints out the text for the options for the user
				System.out.println("Please select an option:");
				System.out.println("1. Inches to Feet");
				System.out.println("2. Feet to Meters");
				System.out.println("3. Miles to Yard");
				System.out.println("4. Back");
				
					/*Gets another value between 1 and 4 using menuChange() method 
				 	* and puts it into "choice2" variable
				 	*/
					int choice2 = menuChange(scan);
					
					//Allows the user to end the code short and reset to the first menu
					if(choice2 == 4) {
						//Finishes case 2
						break;
					}
				
				//While loop continues until "firstChoice" is not 2
				while(firstChoice == 2) {
					
					//Calls the convertDistanceConversions() method and puts it into the "calculation" variable
					String calculation = convertDistanceConversions(choice2, scan);
					
					//Shows the results of the previously called method
					System.out.println(calculation);
					
					/*Calls the convertAgain() method which will increase "firstChoice" 
					 * if the user does not want to go again, ending the loop
					 */
					firstChoice = convertAgain(firstChoice, scan);
				}
				//Finishes case 2
				break;
			
			//Creates the third category and options to choose from
			//Will be created when user chooses 3 in first menu
			case 3:
				//Prints out the text for the options for the user
				System.out.println("Please select an option:");
				System.out.println("1. US Dollars to Yen");
				System.out.println("2. US Dollars to Pesos");
				System.out.println("3. US Dollars to Pounds");
				System.out.println("4. Back");
				
					/*Gets another value between 1 and 4 using menuChange() method 
			 		* and puts it into "choice3" variable
			 		*/
					int choice3 = menuChange(scan);
					
					//Allows the user to end the code short and reset to the first menu
					if(choice3 == 4) {
						//Finishes case 3
						break;
					}
				//While loop continues until "firstChoice" is not 3
				while(firstChoice == 3) {
					
					//Calls the convertMoneyConversions() method and puts it into the "calculation" variable
					String calculation = convertMoneyConversions(choice3, scan);
					
					//Shows the results of the previously called method
					System.out.println(calculation);
					
					/*Calls the convertAgain() method which will increase "firstChoice" 
					 * if the user does not want to go again, ending the loop
					 */
					firstChoice = convertAgain(firstChoice, scan);
				}
				
				//Finishes case 3
				break;
				
			//Will be created when user chooses 4 in first menu	
			default:
				//Shows text to the user that the program has ended
				System.out.println("Thank you and have a nice day. Goodbye.");
				
				//Closes the Scanner object
				scan.close();
				
				//Makes the first while loop false and ends the loop
				menuSelection = 3;
			}
			}
		}
	
	//Since I used an object from "Converter" class, I did not need to use static in my method
	//Method calls the arguments of the "choice1" and Scanner object "scan"
	public String convertVolumeConversions(int input, Scanner scan) {
		
		//Using switch statement to get input, "choice1", and chooses which option from the menu chosen to use
		switch(input){
		
		//Creates first option of cups to pints and goes when input was 1
		case 1:
			
			//Asks user how many to convert
			System.out.println("Please enter how many cups to convert: ");
			
			//Calls another method to check if the numbers are a double value and puts it into "userChoice"
			double userChoice = checkNumbers(scan);
			
			//Converts the value of "userChoice" and changes it into a string
			String conversion = "Your conversion of cups to pints is: " + userChoice / 2;
			
			//Sends the conversion to where the method was called
			return conversion;
			
			//Cases 2 and 3 are pretty much the same as case 1 above
		case 2:
			System.out.println("Please enter how many cups to convert: ");
			double userChoice1 = checkNumbers(scan);
			String conversion1 = "Your conversion of cups to quarts is: " + userChoice1 / 4;
			return conversion1;
		case 3:
			System.out.println("Please enter how many cups to convert: ");
			double userChoice2 = checkNumbers(scan);
			String conversion2 = "Your conversion of cups to gallons is: " + userChoice2 / 16;
			return conversion2;
			
		//This default ensures the method will return a String type
		default:
			return "";
		}
	}
	
	/*This is the same as the method above, convertVolumeConversions, 
	 * but I assumed I needed to create objects from the "Converter" class
	 * because I am using a static class and sending it to a non-static
	 */
	public static String convertDistanceConversions(int input2, Scanner scan) {
		
		//Creates the object
		Converter dc = new Converter();
		
		//Switch statement similar to the cases on convertVolumeConversions
		switch(input2){
		case 1:
			System.out.println("Please enter how many inches to convert: ");
			double userChoice = dc.checkNumbers(scan);
			String conversion = "Your conversion of inches to feet is " + userChoice / 12;
			return conversion;
		case 2:
			System.out.println("Please enter how many feet to convert: ");
			double userChoice1 = dc.checkNumbers(scan);
			String conversion1 = "Your conversion of feet to meters is " + userChoice1 / 3.281;
			return conversion1;
		case 3:
			System.out.println("Please enter how many miles to convert: ");
			double userChoice2 = dc.checkNumbers(scan);
			String conversion2 = "Your conversion of miles to yards is " + userChoice2 / 1760;
			return conversion2;
		default:
			return "";
		}
	}
	
	//Basically the same as convertDistanceConversions, but calculating for the money
	public static String convertMoneyConversions(int input3, Scanner scan) {
		Converter mc = new Converter();
		switch(input3){
		case 1:
			System.out.println("Please enter how many US dollars to convert: ");
			double userChoice = mc.checkNumbers(scan);
			String conversion = "Your conversion of US dollars to Yen is: " + userChoice * 109.70;
			return conversion;
		case 2:
			System.out.println("Please enter how many US dollars to convert: ");
			double userChoice1 = mc.checkNumbers(scan);
			String conversion1 = "Your conversion of US dollars to Pesos is: " + userChoice1 * 19.86;
			return conversion1;
		case 3:
			System.out.println("Please enter how many US dollars to convert: ");
			double userChoice2 = mc.checkNumbers(scan);
			String conversion2 = "Your conversion of US dollars to Pound is: " + userChoice2 * 0.71;
			return conversion2;
		default:
			return "";
		}
	}
	
	public static int convertAgain(int choice, Scanner scan) {
		int inputCheck;
		do {
			System.out.println("Would you like to convert again in the same set? y/n");
			String again = scan.next();
			
			if(again.equals("y")){
				inputCheck = 0;
			}else if(again.equals("n")){
				inputCheck = 0;
				choice = choice + 1;
			}else {
				System.out.println("Please enter a lowercased y or n");
				inputCheck = 4;
			}	

		}while (inputCheck != 0);
		return choice;
	}
	
	/*This method is basically the same as menuChange(), method below,
	 * but is looking specifically for double types and positive numbers
	 */
	public double checkNumbers(Scanner scan) {
		double input;
		do {
			System.out.println("(Please avoid from entering a negative number)");
		try {
		//Lets the user input their number and puts it into a different variable for double
				input = scan.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println("That was not a number. Please try again");
			 input = -99;
		}
		scan.nextLine();
		}while (input < 0);
		return input;
	}
	
	public static int menuChange(Scanner scan) {
		/*Created the variable "choice", which will be used to 
		 * give the do while loop a value of a variable at the beginning 
		 * then will be changed later by user input
		 */
		int choice;
		
		/*Using a do while loop to ask for user's input and using a try/catch method 
		 * to make sure the user puts in a number and the number being between 1 and 4
		 */
		do {
			//System prints shows text to the user asking for specific type of number
			System.out.println("(Please enter a number between 1 and 4)");
			try {
				/*The try method is used to "try" the condition of the user inputing an integer
				 * 
				 * The user's input is read by the scan object and looking for a integer on the line
				 * then the value will be put into the variable "choice"
				 */
				choice = scan.nextInt();
				
			} catch (InputMismatchException e) {
				/*The catch method is specifically checking if the exception, "InputMismatchException", 
				 * is caught. If it is, then it will execute its own coding
				 * 
				 * The System tells the user "it was not a number" and hard codes a number greater than
				 * 4 to reset the loop
				 */
				System.out.println("That was not a number. Please try again");
				choice = 99;
			}
			/*Calls for the scan object to create/read the next line of the System to make
			 * sure the do while loop will let the user input their choice again into 
			 * the variable "choice" and will not loop over and over non-stop.
			 */
			scan.nextLine();
		} 
		/*Lets the do while loop start over back to the do coding. 
		 * Continues the loop, unless "choice" is between 1 and 4
		 */
		while (choice > 4 || choice <= 0);
		
		//returns the value of "choice" to where the method, menuChange(scan) was called
		return choice;
	}
	
}
