package database;

public class Member {
	int rowNum;
	int memberId;
	String memberUserId;
	String memberPW;
	int memberPlayNumber;
	int memberWinRate;
	double memberRankingPer;
	
	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public void setMemberPlayNumber(int memberPlayNumber) {
		this.memberPlayNumber = memberPlayNumber;
	}

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
