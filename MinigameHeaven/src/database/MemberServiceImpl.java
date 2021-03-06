package database;

import java.util.List;

public class MemberServiceImpl implements MemberService {
	MemberDAO dao = new MemberDAO();

	@Override
	public void createMember(Member member) {
		dao.insertMember(member);
	}

	@Override
	public void getMemberList() {
		for (Member member : dao.getMemberList()) {
			if (member != null) {
				System.out.println(member.toString());
			}
		}
	}

	@Override
	public void changeMember(Member member) {
		dao.updateMember(member);
	}

	@Override
	public void removeMember(String userId) {
		dao.deleteMember(userId);
	}

	@Override
	public int findingMember(String userid, String userpw) {
		Member member1 = dao.findMember(userid, userpw);
		if (member1 != null) {
			System.out.println("Hello "+ member1.getMemberUserId());
			return member1.getMemberId();
		} else {
			return 0;
		}

	}

	@Override
	public void updatingPlaytime(int memid, int playtime, int winrate) {
		dao.updateMemberRate31(memid, playtime, winrate);
	}

	@Override
	public List<Member> ranking10List(int gameNum) {
		return dao.getMemberRanking10List(gameNum);
	}

	@Override
	public Member finfingMemberRanking(int memId, int gameNum) {
		return dao.findMemberRanking(memId, gameNum);
		
	}
	
	

}
