package minigamestartpage;

import thirtyonegame.ThirtyOneGameApp;
import updowngame.UpDownGameApp;

public class GameStartPage {

	public void gameList() {
		while (true) {
			System.out.println("-------------------------");
			System.out.println("1.Updown");
			System.out.println("2.Thirtyone");
			System.out.println("3.exit");
			System.out.println("-------------------------");
			System.out.print("Enter Number > ");
			int userSel = CheckInput.checkGameListUserInput();
			if (userSel == 1) {
				UpDownGameApp updowngame = new UpDownGameApp();
				updowngame.gameStart();
			} else if (userSel == 2) {
				ThirtyOneGameApp thirtyonegame = new ThirtyOneGameApp();
				thirtyonegame.gameStart();
			} else if (userSel == 3) {
				break;
			}

			
		}
	}

}
