package database;

import java.util.List;

public interface MemberService {
	public void createMember(Member member); //create user

	public void getMemberList(); // list of member for admin

	public void changeMember(Member member); // Account setting password change

	public void removeMember(String userId); // delete account

	public int findingMember(String userid, String userpw); //for login

	public void updatingPlaytime(int memid, int playtime, int winrate); //for ranking
	
	public List<Member> ranking10List(int gameNum);
	
	public Member finfingMemberRanking(int memId, int gameNum);
}
