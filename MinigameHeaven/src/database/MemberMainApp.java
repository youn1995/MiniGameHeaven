package database;

public class MemberMainApp {
	public static void main(String[] args) {
		MemberLogin memberlogin = new MemberLogin();
		memberlogin.loginExecute();
		
		MemberMain membermain = new MemberMain();
		membermain.execute();
		
		
	}
}
