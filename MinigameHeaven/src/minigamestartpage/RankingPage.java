package minigamestartpage;

import database.MemberMain;
import util.CheckInput;

public class RankingPage {

	int memberId = 0;

	public RankingPage(int memberId) {
		this.memberId = memberId;
	}

	void rankingExecute() {
		while (true) {
			CheckInput.clearScreen();
			System.out.println("--------------------------------");
			System.out.println("1.Updown Ranking");
			System.out.println("2.Thirtyone Ranking");
			System.out.println("3.Return to menu");
			System.out.println();
			System.out.print("Enter Number > ");
			int rangPageSel = CheckInput.checkMenuUserInput(3);

			if (rangPageSel == 1) {
				System.out.println("1.Top 10 Ranking");
				System.out.println("2.User Ranking");
				System.out.println("3.Return to menu");
				int updown = CheckInput.checkMenuUserInput(3);
				if (updown == 1) {
					top10Ranking(1);
				} else if (updown == 2) {
					playerRanking(1);
				} else if (updown == 3) {
					break;
				}

			} else if (rangPageSel == 2) {
				System.out.println("1.Top 10 Ranking");
				System.out.println("2.User Ranking");
				System.out.println("3.Return to menu");
				int thirtyone = CheckInput.checkMenuUserInput(3);

				if (thirtyone == 1) {
					top10Ranking(2);
				} else if (thirtyone == 2) {
					playerRanking(2);
				} else if (thirtyone == 3) {
					break;
				}
			} else if (rangPageSel == 3) {
				break;
			}
		}
	}

	void top10Ranking(int menuNum) {
		System.out.print("Top 10 in all players in ");
		if(menuNum == 1) {
			System.out.println("updowngame");
		} else if(menuNum == 2) {
			System.out.println("thirtyonegame");
			new MemberMain().ranking(1, 1);
		}
	}

	void playerRanking(int menuNum) {
		System.out.print("Your Ranking in ");
		if (menuNum == 1) {
			System.out.println("updowngame");
		} else if (menuNum == 2) {
			System.out.println("thirtyonegame");
		}
	}
}
