package battleship;

public class StartingPosition {
	int battleShip = 4; // size 4
	int frigate1; // size 3
	int frigate2; // size 3
	int aircraftcarrier; // size 5
	int submarine; // size 2
	String battleShipLocation = "D4";
	String frigate1Location = null;
	String frigate2Location = null;
	String aircraftcarrierLocation = null;
	String submarineLocation = null;

	int[][] pickLocation = new int[1][1];

	int substringToInt() {
		int checkInput = 1;
		String userInput = "D4";
		if (userInput.length() == 2) {

		} else {
			System.out.println("정확한 좌표값을 입력하세요");
			checkInput = -1;
		}
		
		return checkInput;
	}

	int alphabetToIndex(String str) {
		int returnIndex = -1;
		String checkUpper = str.toUpperCase();
		if (checkUpper.equals("A")) {
			returnIndex = 0;
		} else if (checkUpper.equals("B")) {
			returnIndex = 1;
		}else if (checkUpper.equals("C")) {
			returnIndex = 2;
		}else if (checkUpper.equals("D")) {
			returnIndex = 3;
		}else if (checkUpper.equals("E")) {
			returnIndex = 4;
		}else if (checkUpper.equals("F")) {
			returnIndex = 5;
		}else if (checkUpper.equals("G")) {
			returnIndex = 6;
		}else if (checkUpper.equals("H")) {
			returnIndex = 7;
		}else if (checkUpper.equals("I")) {
			returnIndex = 8;
		}else if (checkUpper.equals("J")) {
			returnIndex = 9;
		}
		
		return returnIndex;
	}

}
