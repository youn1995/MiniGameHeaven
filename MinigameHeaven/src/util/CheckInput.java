package util;

import java.util.Scanner;

public class CheckInput {
	static Scanner scn = new Scanner(System.in);

	public static int checkMenuUserInput(int sumOfMenu) {
		int checkInput = 0;
		while (true) {
			try {
				checkInput = scn.nextInt();
				scn.nextLine();
				if (checkInput >= 1 && checkInput <= sumOfMenu) {
					break;
				} else {
					scn = new Scanner(System.in);
					System.out.print("Enter Correct Number > ");
				}
			} catch (Exception e) {
				scn = new Scanner(System.in);
				System.out.print("Enter Only Number > ");
			}
		}
		return checkInput;
	}
	
	public static String convertOrdinal(int i) {
	    String[] sufixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
	    switch (i % 100) {
	    case 11:
	    case 12:
	    case 13:
	        return i + "th";
	    default:
	        return i + sufixes[i % 10];
	    }
	}
	
	public static void clearScreen() {
	    for (int i = 0; i < 80; i++)
	      System.out.println("");
	  }
	
	public static void continueNext() {
		scn.nextLine();
	}

}
