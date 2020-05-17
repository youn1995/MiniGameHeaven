package database;

import java.util.Scanner;

public class MemberLogin {
	Scanner scn = new Scanner(System.in);
	MemberService service = new MemberServiceImpl();

	public void loginExecute() {
		System.out.println("-------------Login-------------");
		while (true) {
			
			System.out.print("INSERT ID > ");
			String userid = scn.nextLine();
			System.out.print("INSERT Password > ");
			String userpw = scn.nextLine();
			int checkLoginFail = login(userid, userpw);
			if(checkLoginFail == 1) {
				break;
			}else if(checkLoginFail == 2){
				System.out.println("Login fail check ID or PassWord");
			}
		}
		
	}

	public int login(String userid, String userpw) {
		int checkLoginFail = service.findingMember(userid, userpw);
		return checkLoginFail;
	}

}
