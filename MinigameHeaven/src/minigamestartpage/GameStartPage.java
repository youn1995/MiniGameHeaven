package minigamestartpage;

import thirtyonegame.ThirtyOneGameApp;
import updowngame.UpDownGameApp;
import util.CheckInput;

public class GameStartPage {

	public void gameList(int memId) {
		while (true) {
			System.out.println("-------------------------");
			System.out.println("1.Updown");
			System.out.println("2.Thirtyone");
			System.out.println("3.Return to menu");
			System.out.println();
			System.out.print("Enter Number > ");
			int userSel = CheckInput.checkMenuUserInput(3);
			if (userSel == 1) {
				UpDownGameApp updowngame = new UpDownGameApp(memId);
				updowngame.gameStart();
			} else if (userSel == 2) {
				ThirtyOneGameApp thirtyonegame = new ThirtyOneGameApp(memId);
				thirtyonegame.gameStart();
			} else if (userSel == 3) {
				break;
			}

			
		}
	}

}
