package database;

public class Member {
	int memberId;
	String memberUserId;
	String memberPW;
	
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


	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberUserId=" + memberUserId + ", memberPW=" + memberPW + "]";
	}
	
	
}
