package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;

	public Connection getConnect() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
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

	public Member[] getMemberList() {
		Member[] members = new Member[100];
		String sql = "select * from member";
		conn = getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next()) {
				Member member = new Member(rs.getInt("mem_id"), rs.getString("mem_userid"), rs.getString("mem_passwd"));
				members[i++] = member;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Check completed");
		return members;
	}

	public void insertMember(Member member) {
		String sql = String.format("insert into member values(mem_id_seq.nextval,lower('%s'),'%s',default,default)",
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
		String sql = String.format("update member set mem_passwd = '%s' where mem_id = %d", member.getMemberPW(),
				member.getMemberId());
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
		List<Member> members = new ArrayList<>();
		String sql = String.format("select * from member where mem_userid = lower('%s') and mem_passwd = '%s'", userid,
				userpw);
		conn = getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Member member = new Member(rs.getInt("mem_id"), rs.getString("mem_userid"), rs.getString("mem_passwd"));
				members.add(member);
			}
			return members.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (IndexOutOfBoundsException e1) {
			return null;
		}

	}
	

	public void updateMemberRateUpdown(int memberId, int memberPlaytime, int memberWinRate) {
		Member[] members = new Member[1];
		int originPlaytime = 0;
		int originWinrate = 0;
		conn = getConnect();
		String sql3 = String.format("select mem_id, mem_playtime, mem_winrate from member where mem_id = %d", memberId);
		try {
			pstmt = conn.prepareStatement(sql3);
			ResultSet rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next()) {
				Member member = new Member(rs.getInt("mem_id"), rs.getInt("mem_playtime"), rs.getInt("mem_winrate"));
				members[i++] = member;
				i++;
			}
			originPlaytime = members[0].getMemberPlayNumber();
			originWinrate = members[0].getMemberWinRate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String sql = String.format("update member set mem_playtime = '%s' where mem_id = %d",
				originPlaytime + memberPlaytime, memberId);
		String sql2 = String.format("update member set mem_winrate = '%s' where mem_id = %d",
				originWinrate + memberWinRate, memberId);
		try {
			pstmt = conn.prepareStatement(sql);
			int r = pstmt.executeUpdate();
			System.out.println(r + " Row has been updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql2);
			int r = pstmt.executeUpdate();
			System.out.println(r + " Row has been updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateMemberRate31(int memberId, int memberPlaytime, int memberWinRate) {
		Member[] members = new Member[1];
		int originPlaytime = 0;
		int originWinrate = 0;
		conn = getConnect();
		String sql3 = String.format("select mem_id, mem_31playtime, mem_31winrate from member where mem_id = %d",
				memberId);
		try {
			pstmt = conn.prepareStatement(sql3);
			ResultSet rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next()) {
				Member member = new Member(rs.getInt("mem_id"), rs.getInt("mem_31playtime"),
						rs.getInt("mem_31winrate"));
				members[i++] = member;
				i++;
			}
			originPlaytime = members[0].getMemberPlayNumber();
			originWinrate = members[0].getMemberWinRate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String sql = String.format("update member set mem_31playtime = '%s' where mem_id = %d",
				originPlaytime + memberPlaytime, memberId);
		String sql2 = String.format("update member set mem_31winrate = '%s' where mem_id = %d",
				originWinrate + memberWinRate, memberId);
		try {
			pstmt = conn.prepareStatement(sql);
			int r = pstmt.executeUpdate();
			System.out.println(r + " Row has been updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql2);
			int r = pstmt.executeUpdate();
			System.out.println(r + " Row has been updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Member> getMemberRanking10List(int gameNum) {
		List<Member> members = new ArrayList<>();
		String sql1 = "select mem_userid, mem_updownplaytime ,mem_updownwinrate, \n"
				+ "       round((mem_updownwinrate/replace(mem_updownplaytime, 0, 1)*100),2) as ranking \n"
				+ "from (select mem_userid,mem_updownplaytime ,mem_updownwinrate, \n"
				+ "             round((mem_updownwinrate/replace(mem_updownplaytime, 0, 1)*100),2) as ran \n"
				+ "     from member\n" + "     order by ran desc, mem_updownplaytime desc) m\n" + "where rownum < 11";

		String sql2 = "select mem_userid, mem_31playtime ,mem_31winrate, \n"
				+ "       round((mem_31winrate/replace(mem_31playtime, 0, 1)*100),2) as ranking \n"
				+ "from (select mem_userid,mem_31playtime ,mem_31winrate, \n"
				+ "             round((mem_31winrate/replace(mem_31playtime, 0, 1)*100),2) as ran \n"
				+ "     from member\n" + "     order by ran desc, mem_31playtime desc) m\n" + "where rownum < 11";
		conn = getConnect();
		try {
			if (gameNum == 1) {
				pstmt = conn.prepareStatement(sql1);
				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					Member member = new Member();
					member.setMemberUserId(rs.getString("mem_userid"));
					member.setMemberPlayNumber(rs.getInt("mem_updownplaytime"));
					member.setMemberRankingPer(rs.getDouble("ranking"));
					members.add(member);
				}
			} else if (gameNum == 2) {
				pstmt = conn.prepareStatement(sql2);
				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					Member member = new Member();
					member.setMemberUserId(rs.getString("mem_userid"));
					member.setMemberPlayNumber(rs.getInt("mem_31playtime"));
					member.setMemberRankingPer(rs.getDouble("ranking"));
					members.add(member);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return members;
	}

	public Member findMemberRanking(int memId, int gameNum) {
		List<Member> members = new ArrayList<>();
		String sql1 = String
				.format("with rank as (select rownum as ranknum, mem_id, mem_updownplaytime ,mem_updownwinrate,\n"
						+ "round((mem_updownwinrate/replace(mem_updownplaytime, 0, 1)*100),2) as ranking\n"
						+ "from (select mem_id, mem_updownplaytime ,mem_updownwinrate,\n"
						+ "round((mem_updownwinrate/replace(mem_updownplaytime, 0, 1)*100),2) as ran\n"
						+ "from member\n" + "order by ran desc, mem_updownplaytime desc))\n"
						+ "select ranknum, mem_id, mem_updownplaytime, mem_updownwinrate, ranking\n" + "from rank\n"
						+ "where mem_id = %d", memId);

		String sql2 = String.format("with rank as (select rownum as ranknum, mem_id, mem_31playtime ,mem_31winrate,\n"
				+ "round((mem_31winrate/replace(mem_31playtime, 0, 1)*100),2) as ranking\n"
				+ "from (select mem_id, mem_31playtime ,mem_31winrate,\n"
				+ "round((mem_31winrate/replace(mem_31playtime, 0, 1)*100),2) as ran\n" + "from member\n"
				+ "order by ran desc, mem_31playtime desc))\n"
				+ "select ranknum, mem_id, mem_31playtime, mem_31winrate, ranking\n" + "from rank\n"
				+ "where mem_id = %d", memId);

		conn = getConnect();
		try {
			if (gameNum == 1) {
				pstmt = conn.prepareStatement(sql1);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {

					Member member = new Member();
					member.setMemberPlayNumber(rs.getInt("mem_updownplaytime"));
					member.setMemberWinRate(rs.getInt("mem_updownwinrate"));
					member.setMemberRankingPer(rs.getDouble("ranking"));
					member.setRowNum(rs.getInt("ranknum"));
					members.add(member);
				}
			} else if (gameNum == 2) {
				pstmt = conn.prepareStatement(sql2);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {

					Member member = new Member();
					member.setMemberPlayNumber(rs.getInt("mem_31playtime"));
					member.setMemberWinRate(rs.getInt("mem_31winrate"));
					member.setMemberRankingPer(rs.getDouble("ranking"));
					member.setRowNum(rs.getInt("ranknum"));
					members.add(member);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return members.get(0);
	}

}
