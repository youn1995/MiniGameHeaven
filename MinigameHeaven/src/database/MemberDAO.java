package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MemberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	public Member[] getMemberList() {
		Member[] members = new Member[100];
		String sql = "select * from member";
		conn = getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next()) {
				Member member = new Member(rs.getInt("mem_id"), rs.getString("mem_userid"),
						rs.getString("mem_passwd"));
				members[i++] = member;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Check completed");
		return members;
	}
	public Connection getConnect() {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "hr", "hr");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void insertMember(Member member) {
		String sql = String.format("insert into member values(member_id_seq.nextval,lower('%s'),'%s')",
				member.getMemberUserId(), member.getMemberPW());
		conn = getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			int r = pstmt.executeUpdate();
			System.out.println(r + " Row has been insert");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public void updateMember(Member member) {
		String sql = String.format("update member set mem_passwd = '%s' where mem_id = %d",
				member.getMemberPW(), member.getMemberId());
		conn = getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			int r = pstmt.executeUpdate();
			System.out.println(r + " Row has been updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteMember(String userId) {
		String sql = String.format("delete from member where mem_userid = lower('(%s)')", userId);
		conn = getConnect();

		try {
			pstmt = conn.prepareStatement(sql);
			int r = pstmt.executeUpdate();
			System.out.println(r + " Row has been deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Member findMember(String userid, String userpw) {
		Member[] members = new Member[100];
		String sql = String.format("select * from member where mem_userid = lower('%s') and mem_passwd = '%s'",
									userid, userpw);
		conn = getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next()) {
				Member member = new Member(rs.getInt("mem_id"), rs.getString("mem_userid"),
						rs.getString("mem_passwd"));
				members[i++] = member;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return members[0];
	}
	
}
