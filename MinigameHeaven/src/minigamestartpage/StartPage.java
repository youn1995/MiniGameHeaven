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
				MemberLogin memberlogin = new MemberLogin();
				memberlogin.loginExecute();
				System.out.println("1.Game Start");
				System.out.println("2.Ranking");
				System.out.println("3.Account Setting");
				System.out.println("4.Logout and exit");
				GameStartPage gameStartPage = new GameStartPage();
				gameStartPage.gameList();
			} else if (menuSel == 2) {

			} else if (menuSel == 3) {
				GameStartPage gameStartPage = new GameStartPage();
				gameStartPage.gameList();
			} else if (menuSel == 4) {
				break;
			}

		}

	}

}
