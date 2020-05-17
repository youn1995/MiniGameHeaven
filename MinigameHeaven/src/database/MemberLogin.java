package database;

import java.util.Scanner;

public class MemberLogin {
	Scanner scn = new Scanner(System.in);
	MemberService service = new MemberServiceImpl();

	public int loginExecute() {
		int checkLogin = 0;
		System.out.println("-------------Login-------------");
		while (true) {
			
			System.out.print("INSERT ID > ");
			String userid = scn.nextLine();
			System.out.print("INSERT Password > ");
			String userpw = scn.nextLine();
			checkLogin = login(userid, userpw);
			if(checkLogin != 0) {
				break;
			}else if(checkLogin == 0){
				System.out.println("Login fail check ID or PassWord");
			}
		}
		return checkLogin;
	}

	public int login(String userid, String userpw) {
		int checkLoginFail = service.findingMember(userid, userpw);
		return checkLoginFail;
	}

}
