package battleship;

public class battleShip {
	
	int battleShip = 4; //size 4
	int frigate1; // size 3
	int frigate2; //size 3
	int airCraftCarrier; // size 5
	int submarine; // size 2
	static String battleShipLocation = "D4";
	
	
	public static void main(String[] args) {
		String[][] board = new String[10][10];
		
		System.out.println(battleShipLocation.length());
		for(int i =0; i<10; i++) {
			if(i == 0) {
				System.out.print("  ");
			}
			System.out.print(i+1 + " ");
		}
		System.out.println();
		for(int i =0; i < board.length; i++) {
			System.out.print(i+1 +" ");
			for(int j=0; j < board[i].length; j++) {

				board[i][j] = "~";
				System.out.print(board[i][j]+ " ");
			}
			System.out.println();
		}
	}
}
