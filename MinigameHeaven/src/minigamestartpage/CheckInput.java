package minigamestartpage;

import java.util.Scanner;

public class CheckInput {
	static Scanner scn = new Scanner(System.in);

	static int checkMenuUserInput() {
		int checkInput = 0;
		while (true) {
			try {
				checkInput = scn.nextInt();
				scn.nextLine();
				if (checkInput >= 1 && checkInput <= 4) {
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
	
	static int checkGameListUserInput() {
		int checkInput = 0;
		while (true) {
			try {
				checkInput = scn.nextInt();
				scn.nextLine();
				if (checkInput >= 1 && checkInput <= 3) {
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
}
