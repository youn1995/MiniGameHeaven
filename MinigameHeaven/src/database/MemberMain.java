package database;

import java.util.List;
import java.util.Scanner;

import util.CheckInput;

public class MemberMain {
	Scanner scn = new Scanner(System.in);
	MemberService service = new MemberServiceImpl();

	public void accountSettingExecute() {
		while (true) {
			System.out.println("----------Account setting----------");
			System.out.println("1.Change password");
			System.out.println("2.Delet account");
			System.out.println("3.Return to main");
			System.out.println("-----------------------------------");
			int userInput = CheckInput.checkMenuUserInput(3);
			if (userInput == 1) {
				updateUser();
			} else if (userInput == 2) {

			} else if (userInput == 3) {
				break;
			}
		}
	}
	
	public void adminAccountExecute() {
		while (true) {
			System.out.println("----------Account setting----------");
			System.out.println("1.Account list");
			System.out.println("2.Change password");
			System.out.println("3.Delet account");
			System.out.println("4.Return to main");
			System.out.println("-----------------------------------");
			int userInput = CheckInput.checkMenuUserInput(4);
			if (userInput == 1) {
				service.getMemberList();
			} else if (userInput == 2) {
				updateUser();
			} else if (userInput == 3) {
				
			} else if (userInput == 4) {
				break;
			}
		}
	}

	public int loginExecute() {
		int memId = 0;
		System.out.println("-------------Login-------------");
		while (true) {

			System.out.print("INSERT ID > ");
			String userid = scn.nextLine();
			System.out.print("INSERT Password > ");
			String userpw = scn.nextLine();
			memId = login(userid, userpw);
			if (memId != 0) {
				break;
			} else if (memId == 0) {
				System.out.println("Login fail check ID or PassWord");
			}
		}
		return memId;
	}

	private int login(String userid, String userpw) {
		int memId = service.findingMember(userid, userpw);
		return memId;
	}

	public void insertUser() {
		System.out.println("Create Account");
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
		int deleteCheckNum = CheckInput.checkMenuUserInput(2);
		if (deleteCheckNum == 1) {
			System.out.print("Checking Password > ");

			// service.removeMember(deptId);
		}
		System.out.println();
		System.out.println("Enter to continue...");
		scn.nextLine();
	}

	public void updateUser() {
		System.out.println("Do you want to change your password?");
	}

	public void ranking(int menuNum, int gameNum) {
		
		if (menuNum == 1) {
			if (gameNum == 1) {System.out.println("Top10");
				int rank = 1;
				List<Member> members = service.ranking31_10List();
				System.out.println("Top10");
				System.out.println("Rank   UserId   WinRate  Palytime");
				for(Member mem :members) {
					System.out.println(CheckInput.convertOrdinal(rank)+" "+mem.getMemberUserId()
					+" "+mem.getMemberRankingPer()+" "+mem.getMember31PlayNumber());
					rank++;
				}
			}else if(gameNum == 2) {
				
			}
		} else if (menuNum == 2) {
			if(gameNum == 1) {
				
			} else if(gameNum == 2) {
				
			}
		}
	}

}