package minigamestartpage;

import database.MemberLogin;
import database.MemberMain;

public class StartPage {
	public static void main(String[] args) {

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
			int menuSel = CheckInput.checkMenuUserInput();
			if (menuSel == 1) {
				while (true) {
					MemberLogin memberlogin = new MemberLogin();
					int memId = memberlogin.loginExecute();
					System.out.println("1.Game Start");
					System.out.println("2.Ranking");
					System.out.println("3.Account Setting");
					System.out.println("4.Logout and exit");
					int loginMenuSel = CheckInput.checkMenuUserInput();
					if (loginMenuSel == 1) {
						GameStartPage gameStartPage = new GameStartPage();
						gameStartPage.gameList(memId);
					} else if (loginMenuSel == 2) {
						
					} else if (loginMenuSel == 3) {
						MemberMain membermain = new MemberMain();
						membermain.execute();
					} else if (loginMenuSel == 4) {
						break;
					}
				}
			} else if (menuSel == 2) {
				MemberMain membermain = new MemberMain();
				membermain.insertUser();
			} else if (menuSel == 3) {
				GameStartPage gameStartPage = new GameStartPage();
				gameStartPage.gameList(0);
			} else if (menuSel == 4) {
				break;
			}

		}

	}

}
