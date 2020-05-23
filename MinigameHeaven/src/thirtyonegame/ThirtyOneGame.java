package thirtyonegame;

import java.util.Scanner;

public class ThirtyOneGame {
	Scanner scn = new Scanner(System.in);

	int selectNumFailCheck() { // input 1~3number check
		int checkInput = 0;
		while (true) {
			try {
				checkInput = scn.nextInt();
				if (1 <= checkInput && checkInput <= 3) {
					break;
				} else {
					System.out.println("-----------------------");
					System.out.println("INSERT CORRET NUMBER");
					System.out.println("-----------------------");
					System.out.print("INSERT > ");
				}
			} catch (Exception e) {
				System.out.println("-----------------------");
				System.out.println("INSERT CORRET NUMBER");
				System.out.println("-----------------------");
				System.out.print("INSERT > ");
				scn = new Scanner(System.in);
			}
		} // end of while
		return checkInput;
	}// end of selectNumFailCheck()

	int gameSet() {
		int userInputNum = 0;
		int resultOfRPS = 0;
		System.out.println("Play Rock-Paper-Scissors to Who goes first.");
		while (true) {
			System.out.println("-----------------------");
			System.out.println("1.Scissor, 2.Rock, 3.Paper");
			System.out.print("INSERT(1~3) > ");
			userInputNum = selectNumFailCheck();
			int comThinkNum = (int) (Math.random() * 3 + 1);
			if (comThinkNum == 1) {
				System.out.println("Computer: Scissor");
				System.out.println("vs");
				if (userInputNum == 1) {
					System.out.println("You: Scissor");
					System.out.println("Draw.");
					System.out.println("Replay");
				} else if (userInputNum == 2) {
					System.out.println("You: Rock");
					System.out.println("You go first");
					resultOfRPS = 1; // player first
					break;
				} else {
					System.out.println("You: Paper");
					System.out.println("Computer will go first");
					resultOfRPS = 2; // computer first
					break;
				}

			} else if (comThinkNum == 2) {
				System.out.println("Computer: Rock");
				System.out.println("vs");
				if (userInputNum == 2) {
					System.out.println("You: Rock");
					System.out.println("Draw");
					System.out.println("Replay");
				} else if (userInputNum == 1) {
					System.out.println("You: Scissor");
					System.out.println("Computer will go first");
					resultOfRPS = 2;
					break;
				} else {
					System.out.println("You: Paper");
					System.out.println("You go first");
					resultOfRPS = 1;
					break;
				}

			} else if (comThinkNum == 3) {
				System.out.println("Computer: Paper");
				System.out.println("vs");
				if (userInputNum == 3) {
					System.out.println("You: Paper");
					System.out.println("Draw");
					System.out.println("Replay");
				} else if (userInputNum == 2) {
					System.out.println("You: Rock");
					System.out.println("Computer will go first");
					resultOfRPS = 2;
					break;

				} else {
					System.out.println("You: Scissor");
					System.out.println("You go first");
					resultOfRPS = 1;
					break;
				}
			}
		} // end of while
		System.out.println("-----------------------");
		return resultOfRPS;
	}// end of gameSet()

	int[] gamePlay(int resultOfRPS) {
		System.out.println("You Can Choose 1~3 to insert");
		System.out.println("if you choose 2 the number will insert n, n+1");
		int sum = 1;
		int selectNum;
		int playtime =0;
		int scoreSum =0;
		
		if (resultOfRPS == 1) {
			while (sum <= 31) {
				System.out.print("INSERT(1~3) > ");
				selectNum = selectNumFailCheck();
				System.out.println("YOU");
				if (sum < 31) {
					if (selectNum == 3) {
						System.out.print(sum++ + ", ");
						System.out.print(sum++ + ", ");
						System.out.println(sum++ + "!");
					} else if (selectNum == 2) {
						System.out.print(sum++ + ", ");
						System.out.println(sum++ + "!");
					} else if (selectNum == 1) {
						System.out.println(sum++ + "!");
					}
				} else if (sum == 31) {
					System.out.println(sum + "!");
					System.out.println("You Lose");
					break;
				}
				System.out.println("COM");
				int comThinkNum = (int) (Math.random() * 3 + 1);
				if (sum <= 27) {
					if (comThinkNum == 3) {
						System.out.print(sum++ + ", ");
						System.out.print(sum++ + ", ");
						System.out.println(sum++ + "!");
					} else if (comThinkNum == 2) {
						System.out.print(sum++ + ", ");
						System.out.println(sum++ + "!");
					} else if (comThinkNum == 1) {
						System.out.println(sum++ + "!");
					}
				} else if (sum == 28) {
					System.out.print(sum++ + ", ");
					System.out.print(sum++ + ", ");
					System.out.println(sum++ + "!");
				} else if (sum == 29) {
					System.out.print(sum++ + ", ");
					System.out.println(sum++ + "!");
				} else if (sum == 30) {
					System.out.println(sum++ + "!");
				} else if (sum == 31) {
					System.out.println(sum + "!");
					System.out.println("YOU WIN");
					scoreSum++;
					break;
				}
			} // end of while
			System.out.println("-----------------------");
			playtime++;
		} else if (resultOfRPS == 2) {
			while (sum <= 31) {
				System.out.println("COM");
				int comThinkNum = (int) (Math.random() * 3 + 1);
				if (sum <= 27) {
					if (comThinkNum == 3) {
						System.out.print(sum++ + ", ");
						System.out.print(sum++ + ", ");
						System.out.println(sum++ + "!");
					} else if (comThinkNum == 2) {
						System.out.print(sum++ + ", ");
						System.out.println(sum++ + "!");
					} else if (comThinkNum == 1) {
						System.out.println(sum++ + "!");
					}
				} else if (sum == 28) {
					System.out.print(sum++ + ", ");
					System.out.print(sum++ + ", ");
					System.out.println(sum++ + "!");
				} else if (sum == 29) {
					System.out.print(sum++ + ", ");
					System.out.println(sum++ + "!");
				} else if (sum == 30) {
					System.out.println(sum++ + "!");
				} else if (sum == 31) {
					System.out.println(sum + "!");
					System.out.println("YOU WIN");
					scoreSum++;
					break;
				}
				System.out.print("INSERT(1~3) > ");
				selectNum = selectNumFailCheck();
				System.out.println("YOU");
				if (sum < 31) {
					if (selectNum == 3) {
						System.out.print(sum++ + ", ");
						System.out.print(sum++ + ", ");
						System.out.println(sum++ + "!");
					} else if (selectNum == 2) {
						System.out.print(sum++ + ", ");
						System.out.println(sum++ + "!");
					} else if (selectNum == 1) {
						System.out.println(sum++ + "!");
					}
				} else if (sum == 31) {
					System.out.println(sum + "!");
					System.out.println("You Lose");
					break;
				}
				
			} // end of while
			System.out.println("-----------------------");
			playtime++;
		}
		
		int[] totalResult = new int[2];
		totalResult[0] = playtime;
		totalResult[1] = scoreSum;
		System.out.println(playtime + ", "+scoreSum);
		return totalResult;
	}// end of gamePlay
}// end of class