package database;


public interface MemberService {
	public void createMember(Member member);

	public void getMemberList();

	public void changeMember(Member member);

	public void removeMember(String userId);

	public int findingMember(String userid, String userpw);

	public void updatingPlaytime(int memid, int playtime, int winrate);
	
}
