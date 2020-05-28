package battleship;

public class StartingPosition {
	int battleShip = 4; //size 4
	int frigate1; // size 3
	int frigate2; //size 3
	int aircraftcarrier; // size 5
	int submarine; // size 2
	String battleShipLocation = "D4";
	String frigate1Location = null;
	String frigate2Location = null;
	String aircraftcarrierLocation = null;
	String submarineLocation = null;
	
	int[][] pickLocation = new int[1][1];
	
	void substringToInt() {
		String userInput = "D4";
		if(userInput.length()==2) {
			
		} else {
			System.out.println("정확한 좌표값을 입력하세요");
		}
	}
	
}
