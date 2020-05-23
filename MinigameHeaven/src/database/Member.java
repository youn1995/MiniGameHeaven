package database;

public class Member {
	int memberId;
	String memberUserId;
	String memberPW;
	int memberPlayNumber;
	int member31PlayNumber;
	int memberWinRate;
	double memberRankingPer;
	
	public Member() {
		
	}
	
	public Member(String memberUserId, String memberPW) {
		super();
		this.memberUserId = memberUserId;
		this.memberPW = memberPW;
	}
	
	
	public Member(int memberId, String memberUserId, String memberPW) {
		super();
		this.memberId = memberId;
		this.memberUserId = memberUserId;
		this.memberPW = memberPW;
	}


	public Member(int memberId, int memberPlayNumber, int memberWinRate) {
		super();
		this.memberId = memberId;
		this.memberPlayNumber = memberPlayNumber;
		this.memberWinRate = memberWinRate;
	}

	public int getMember31PlayNumber() {
		return member31PlayNumber;
	}

	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberUserId() {
		return memberUserId;
	}
	public void setMemberUserId(String memberUserId) {
		this.memberUserId = memberUserId;
	}
	public String getMemberPW() {
		return memberPW;
	}
	public void setMemberPW(String memberPW) {
		this.memberPW = memberPW;
	}

	
	public int getMemberPlayNumber() {
		return memberPlayNumber;
	}

	public void setMember31PlayNumber(int member31PlayNumber) {
		this.member31PlayNumber = member31PlayNumber;
	}

	public int getMemberWinRate() {
		return memberWinRate;
	}

	public void setMemberWinRate(int memberWinRate) {
		this.memberWinRate = memberWinRate;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberUserId=" + memberUserId + ", memberPW=" + memberPW + "]";
	}

	public double getMemberRankingPer() {
		return memberRankingPer;
	}

	public void setMemberRankingPer(double memberRankingPer) {
		this.memberRankingPer = memberRankingPer;
	}
	
	
}
