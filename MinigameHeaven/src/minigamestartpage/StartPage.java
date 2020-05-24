package minigamestartpage;

import database.MemberMain;
import util.CheckInput;

public class StartPage {

	public static void main(String[] args) {

		MemberMain memberMain = new MemberMain();

		while (true) {
			System.out.println("--------------------------------");
			System.out.println("   Welcome to Minigameheaven   ");
			System.out.println("--------------------------------");
			System.out.println("1.Login");
			System.out.println("2.Create Account");
			System.out.println("3.Start as a non-member");
			System.out.println("4.Exit");
			System.out.println();
			System.out.print("Enter Number > ");
			int menuSel = CheckInput.checkMenuUserInput(4);
			if (menuSel == 1) {
				int memId = 0;
				int breakingPoint = 0;
				while (true) {
					if (memId == 0) {
						memId = memberMain.loginExecute();
					}
					System.out.println("--------------------------------");
					System.out.println("           Main Page");
					System.out.println("--------------------------------");
					System.out.println("1.Game Start");
					System.out.println("2.Ranking");
					System.out.println("3.Account Setting");
					System.out.println("4.Logout and exit");
					System.out.println();
					System.out.print("Enter Number > ");
					int loginMenuSel = CheckInput.checkMenuUserInput(4);
					if (loginMenuSel == 1) {
						new GameStartPage().gameList(memId);
					} else if (loginMenuSel == 2) {
						new RankingPage(memId).rankingExecute();
					} else if (loginMenuSel == 3) {
						if(memId == 1000) {
							memberMain.adminAccountExecute();
						} else {
							memberMain.accountSettingExecute();
						}
						
					} else if (loginMenuSel == 4) {
						System.out.println("--------------------------------");
						System.out.println("            GoodBye");
						System.out.println("--------------------------------");
						breakingPoint = 1;
						break;
					}
				} // end of inner while
				if(breakingPoint == 1) //logout and exit
					break;
			} else if (menuSel == 2) {
				memberMain.insertUser();
			} else if (menuSel == 3) {
				new GameStartPage().gameList(0);
			} else if (menuSel == 4) {
				break;
			}

		} // end of outer while
		System.out.println("Program End");
	} // end of main()

} // end of StartPage
