package database;

import java.util.Scanner;


public class MemberMain {
	Scanner scn = new Scanner(System.in);
	MemberService service = new MemberServiceImpl();

	// 회원생성 회원비밀번호변경 회원삭제
	public void execute() {
		while (true) {
			System.out.println("----------Account setting----------");
			System.out.println("1.Change password");
			System.out.println("2.Delet account");
			System.out.println("3.Return to main");
			System.out.println("-----------------------------------");
			int userInput = checkUserInput();
			if (userInput == 1) {
				updateUser();
			} else if (userInput == 2) {
				
			}  else if (userInput == 3) {
				break;
			}
		}
	}

	public void insertUser() {
		System.out.println("Create department");
		System.out.print("Enter User ID > ");
		String userid = scn.nextLine();
		System.out.print("Enter User password > ");
		String userpw = scn.nextLine();
		Member member = new Member(userid, userpw);
		service.createMember(member);
		System.out.println();
		System.out.println("Enter to continue...");
		scn.nextLine();
	}

	public void deleteUser() {
		System.out.println("Do you really want to Delete your account?");
		System.out.println("1.YES 2.NO");
		System.out.print("INSERT > ");
		int deleteCheckNum = checkYesNo();
		if(deleteCheckNum == 1) {
		System.out.print("Checking Password > ");
		
		
		//service.removeMember(deptId);
		}
		System.out.println();
		System.out.println("Enter to continue...");
		scn.nextLine();
	}

	public void updateUser() {

	}
	int checkYesNo() {
		int checkInput = 0;
		while (true) {
			try {
				checkInput = scn.nextInt();
				scn.nextLine();
				if (checkInput == 1 && checkInput == 2) {
					break;
				} else {
					scn = new Scanner(System.in);
					System.out.print("Enter Correct Number > ");
				}
			} catch (Exception e) {
				scn = new Scanner(System.in);
				System.out.print("Enter Only Number > ");
			}
		}
		return checkInput;
	}
	int checkUserInput() {
		int checkInput = 0;
		while (true) {
			try {
				checkInput = scn.nextInt();
				scn.nextLine();
				if (checkInput >= 1 && checkInput <= 3) {
					break;
				} else {
					scn = new Scanner(System.in);
					System.out.print("Enter Correct Number > ");
				}
			} catch (Exception e) {
				scn = new Scanner(System.in);
				System.out.print("Enter Only Number > ");
			}
		}
		return checkInput;
	}
}