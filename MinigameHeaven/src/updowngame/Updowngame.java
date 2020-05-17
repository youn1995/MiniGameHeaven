package updowngame;

import java.util.Scanner;

public class Updowngame {
	Scanner scn = new Scanner(System.in);

	private int selectRange;
	private int comThinkNum;
	private int attemptNumber;
	private int selectLevel;

	void numFailCheck() {

	}

	void attemptNumberCreate(int userSelRange) {
		if (userSelRange == 1) {
			attemptNumber = 1;
		} else {
			attemptNumber = (int) (Math.log(userSelRange) / Math.log(2));
		}
	}

	void comThinkNumCreate(int userSelRange) {
		comThinkNum = (int) (Math.random() * userSelRange) + 1;
	}

	void chooseLevel() {
		System.out.println("CHOOSE LEVEL"); // 난이도 선택
		System.out.println("1: EASY, 2:NOMAL, 3:HARD");
		System.out.print("INSERT: ");
		selectLevel = scn.nextInt();
		System.out.println("-----------------------------------------");
		if (selectLevel == 1) {
			System.out.println("YOU CAN GET ONE MORE CHANCE");
			attemptNumber = attemptNumber + 1;
		} else if (selectLevel == 2) {
			System.out.println("PLAY IN DEFALUT SETTING");
		} else if (selectLevel == 3) {
			System.out.println("HARD MODE DOSEN'T TELL RANGE HINT FOR YOU");
			if (selectRange >= 4) {
				System.out.println("YOUR CHANE WILL BE ONE LESS THAN NOMAL");
				attemptNumber = attemptNumber - 1;
			} else {
				System.out.println("YOUR CHANCE WILL NOT BE CHAGE");
			}
		} else {

		}
		System.out.println("-----------------------------------------");
		System.out.println("YOU HAVE " + attemptNumber + " CHANCE");
		System.out.println();
	}

	int upDownTalkBack(int num) {
		if (num > selectRange || num < 1) {
			System.out.println("INSERT BETWEEN 1 AND " + selectRange);
			return 0;
		} else if (comThinkNum == num) {
			System.out.println("YOU WIN");
			return 1;
		} else if (comThinkNum > num) {
			System.out.println("UP");
			return 2;
		} else if (comThinkNum < num) {
			System.out.println("DOWN");
			return 3;
		} else {
			System.out.println("INSERT CORRECT NUMBER IN CORRECT RANGE");
			return 4;
		}
	}

	void playGame() {
		int userSelectNum = 0;
		int minNum = 1;
		int maxNum = selectRange;

		for (int i = 1; i <= attemptNumber; i++) {
			System.out.println();
			System.out.println(i + " ATTEMPT");
			System.out.print("INSERT: ");
			userSelectNum = scn.nextInt();
			System.out.println("-----------------------------------------");
			int talkBackNum = upDownTalkBack(userSelectNum);
			System.out.println("-----------------------------------------");
			if (comThinkNum == userSelectNum) {
				break;
			}
			if (selectLevel == 1 || selectLevel == 2) { // 힌트제공
				if (talkBackNum == 2) {
					minNum = userSelectNum;
					System.out.println(minNum + " < FIND IN < " + maxNum);
					System.out.println("-----------------------------------------");
				} else if (talkBackNum == 3) {
					maxNum = userSelectNum;
					System.out.println(minNum + " < FIND IN < " + maxNum);
					System.out.println("-----------------------------------------");
				}
			} else if (selectLevel == 3) {

			}
		}

		if (comThinkNum != userSelectNum) { // 정답을 못 맞추면 출력
			System.out.println("YOU LOSE ANSER IS " + comThinkNum);
		} 
	}

	void execute() {
		while (true) {
			System.out.println("ENTER RANGE YOU WANT TO PLAY");
			System.out.print("INSERT (BETWEEN 1 AND 2,147,483,647) : ");
			int userSelRange = 0;
			while (true) {
				try {
					userSelRange = scn.nextInt();
					break;
				} catch (Exception e) {
					System.out.print("정수만 입력하세요 >");
					scn = new Scanner(System.in);

				}
			}
			selectRange = userSelRange;

			comThinkNumCreate(userSelRange);
			attemptNumberCreate(userSelRange);
			chooseLevel();
			playGame();
			
			System.out.println("DO YOU WANT TO RETRY?");
			System.out.println("1.YES 2.NO");
			System.out.print("INSERT NUMBER >");
			int selretry = scn.nextInt();
			if(selretry == 2) {
				break;
			}
		}
		System.out.println("PROGRAM END");
	}

}// end of class
