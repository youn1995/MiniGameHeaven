package updowngame;

public class SelectRange {
	private int userSelRange;
	private int comThinkNum;
	private int attemptNumber;

	public void startInfo() {
		System.out.println("ENTER RANGE YOU WANT TO PLAY");
		System.out.print("INSERT (BETWEEN 1 AND 2,147,483,647) : ");
	}

	public int getUserSelRange() {
		return userSelRange;
	}

	public void setUserSelRange(int userSelRange) {
		if (userSelRange < 1) {
			System.out.println("MINIMUM INPUT IS 1");
			System.out.println("AUTO SETING TO 50");
			this.userSelRange = 50;
			this.comThinkNum = (int) (Math.random() * 50) + 1;
			this.attemptNumber = (int) (Math.log(50) / Math.log(2));
		} else {
			this.userSelRange = userSelRange;
			this.comThinkNum = (int) (Math.random() * userSelRange) + 1;
			this.attemptNumber = (int) (Math.log(userSelRange) / Math.log(2));
		}
	}

	public int getComThinkNum() {
		return comThinkNum;
	}

	public int getAttemptNumber() {
		return attemptNumber;
	}
	
	public void levelSelInfo() {
		System.out.println("CHOOSE LEVEL"); // 난이도 선택
        System.out.println("1: EASY, 2:NOMAL, 3:HARD");
        System.out.print("INSERT: ");
	}
	
	public void chooseLevel(int selectLevel) {
		System.out.println("-----------------------------------------");
		if (selectLevel == 1) {
			System.out.println("YOU CAN GET ONE MORE CHANCE");
			attemptNumber = attemptNumber + 1;
		} else if (selectLevel == 2) {
			System.out.println("PLAY IN DEFALUT SETTING");
		} else if (selectLevel == 3) {
			System.out.println("HARD MODE DOSEN'T TELL RANGE HINT FOR YOU");
			if (userSelRange >= 4) {
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
	
	public int upDownTalkBack(int num) {
        if (num > userSelRange || num < 1) {
            System.out.println("INSERT BETWEEN 1 AND " + userSelRange);
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


}