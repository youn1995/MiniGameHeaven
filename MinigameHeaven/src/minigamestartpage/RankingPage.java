package minigamestartpage;

import database.MemberMain;
import util.CheckInput;

public class RankingPage {
	MemberMain memMain = new MemberMain();
	int memberId = 0;

	public RankingPage(int memberId) {
		this.memberId = memberId;
	}

	void rankingExecute() {
		while (true) {
			System.out.println("--------------------------------");
			System.out.println("          Ranking Page");
			System.out.println("--------------------------------");
			System.out.println("1.Updown Ranking");
			System.out.println("2.Thirtyone Ranking");
			System.out.println("3.Return to menu");
			System.out.println();
			System.out.print("Enter Number > ");
			int rangPageSel = CheckInput.checkMenuUserInput(3);

			if (rangPageSel == 1) {
				System.out.println("--------------------------------");
				System.out.println("         Updown Ranking");
				System.out.println("--------------------------------");
				System.out.println("1.Top 10 Ranking");
				System.out.println("2.User Ranking");
				System.out.println("3.Return to menu");
				System.out.println();
				System.out.print("Enter Number > ");
				int updown = CheckInput.checkMenuUserInput(3);
				if (updown == 1) {
					memMain.top10Ranking(1);
					System.out.println("Enter to continue...");
					CheckInput.continueNext();
					
				} else if (updown == 2) {
					memMain.userRanking(memberId, 1);
					System.out.println("Enter to continue...");
					CheckInput.continueNext();
				} else if (updown == 3) {
					break;
				}

			} else if (rangPageSel == 2) {
				System.out.println("--------------------------------");
				System.out.println("       Thirtyone Ranking");
				System.out.println("--------------------------------");
				System.out.println("1.Top 10 Ranking");
				System.out.println("2.User Ranking");
				System.out.println("3.Return to menu");
				System.out.println();
				System.out.print("Enter Number > ");
				int thirtyone = CheckInput.checkMenuUserInput(3);

				if (thirtyone == 1) {
					memMain.top10Ranking(2);
					System.out.println("Enter to continue...");
					CheckInput.continueNext();
				} else if (thirtyone == 2) {
					memMain.userRanking(memberId, 2);
					System.out.println("Enter to continue...");
					CheckInput.continueNext();
				} else if (thirtyone == 3) {
					break;
				}
			} else if (rangPageSel == 3) {
				break;
			}
			
		}
	}
}
