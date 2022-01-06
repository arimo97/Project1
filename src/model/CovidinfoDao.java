package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class CovidinfoDao {

	public static Vector num;

	// 회원조회(개인) getUser("admin")
	public CovidInfoVo getUser(String memid, String recordno) {
		CovidInfoVo user = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " SELECT  ID, NUM, VACCINE, TEST_DATE, TEST_HOSPITAL, TEST_RESULT, SYMPTOM ";
		sql += " FROM    COVIDINFO ";
		sql += " WHERE   ID = ? ";
		sql += " AND    NUM = ? ";

		try {
			conn = DBConn.getInstance();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memid);
			pstmt.setString(2, recordno);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				String id = rs.getString("ID");
				String num = rs.getString("NUM");
				String vaccine = rs.getString("VACCINE");
				String test_date = rs.getString("TEST_DATE");
				String jobtest_hospital = rs.getString("TEST_HOSPITAL");
				String test_result = rs.getString("TEST_RESULT");
				String symptom = rs.getString("SYMPTOM");
				user = new CovidInfoVo(id, num, vaccine, test_date, jobtest_hospital, test_result, symptom);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}
		}
		return user;
	}

	// 회원조회(목록)

//	  회원 추가
	public void insertUser(String id, String vaccine, String test_date, String test_hospital, String test_result,
			String symptom) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";

		conn = DBConn.getInstance();
		sql = " INSERT  INTO    COVIDINFO ( ID, NUM, VACCINE, TEST_DATE, TEST_HOSPITAL,TEST_RESULT ,SYMPTOM  ) ";
		sql += " VALUES (  ?, ( SELECT NVL(MAX(NUM),0) +1 FROM COVIDINFO WHERE ID = ? )  , ? , ? , ? , ? , ? ) ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			pstmt.setString(3, vaccine);
			pstmt.setString(4, test_date);
			pstmt.setString(5, test_hospital);
			pstmt.setString(6, test_result);
			pstmt.setString(7, symptom);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
	}

	public String insertUser(CovidInfoVo covidinfo) {
		String result = "";

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";

		conn = DBConn.getInstance();
		sql = " INSERT  INTO    COVIDINFO ( ID, NUM, VACCINE, TEST_DATE, TEST_HOSPITAL,TEST_RESULT ,SYMPTOM  ) ";
		sql += " VALUES (  ?, ( SELECT NVL(MAX(NUM),0) +1 FROM COVIDINFO WHERE ID = ? )  , ? , ? , ? , ? , ? ) ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, covidinfo.getId());
			pstmt.setString(2, covidinfo.getId());
			pstmt.setString(3, covidinfo.getVaccine());
			pstmt.setString(4, covidinfo.getTest_date());
			pstmt.setString(5, covidinfo.getTest_hospital());
			pstmt.setString(6, covidinfo.getTest_result());
			pstmt.setString(7, covidinfo.getSymptom());

			pstmt.executeUpdate();

			result = "추가되었습니다";

		} catch (SQLException e) {
			switch (e.getErrorCode()) {
			case 1:
				result = "중복된 자료입니다";
				break;
			default:
				result = e.getMessage();
			}
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;

	}

	// 회원 수정
	public String updateUser(CovidInfoVo user) {
		String result = "";

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";

		conn = DBConn.getInstance();
		sql = " UPDATE    COVIDINFO ";
		sql += "  SET     VACCINE  = ?, ";
		sql += "          TEST_DATE     = ?,";
		sql += "          TEST_HOSPITAL   = ?,";
		sql += "          TEST_RESULT   = ?,";
		sql += "          SYMPTOM       = ?";
		sql += "  WHERE   ID  = ? ";
		sql += " AND    NUM = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getVaccine());
			pstmt.setString(2, user.getTest_date());
			pstmt.setString(3, user.getTest_hospital());
			pstmt.setString(4, user.getTest_result());
			pstmt.setString(5, user.getSymptom());
			pstmt.setString(6, user.getId());
			pstmt.setString(7, user.getNum());

			pstmt.executeUpdate();

			result = "수정 되었습니다";

		} catch (SQLException e) {
			switch (e.getErrorCode()) {
			default:
				result = e.getMessage();
			}
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;

	}
	// 회원 삭제

	public String deleteUser(CovidInfoVo user) {
		String result = "";

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";

		conn = DBConn.getInstance();
		sql = " DELETE  ";
		sql += " FROM   COVIDINFO";
		sql += " WHERE  ID = ? ";
		sql += " AND    NUM = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getNum());

			pstmt.executeUpdate();

			result = "삭제 되었습니다";

		} catch (SQLException e) {
			switch (e.getErrorCode()) {
			default:
				result = e.getMessage();
			}
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}
		}
		return result;

	}

	public Vector getMemList(String id) { // public Vector getMemList(String id)
		Vector outV = new Vector(); // 2차원배열 : ResultSet 전체

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = " SELECT  NUM, ID, VACCINE, TEST_DATE, TEST_HOSPITAL, TEST_RESULT, SYMPTOM ";
		sql += " FROM COVIDINFO ";
		sql += " WHERE ID = ? "; // id 확인용

		try {
			conn = DBConn.getInstance();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); // id 확인

			rs = pstmt.executeQuery();
			num = new Vector();
			while (rs.next()) {

				Vector v = new Vector();
				num.add(rs.getString("num"));
				v.add(rs.getString("id"));
				v.add(rs.getString("vaccine"));
				v.add(rs.getString("test_date"));
				v.add(rs.getString("test_hospital"));
				v.add(rs.getString("test_result"));
				v.add(rs.getString("symptom"));
				outV.add(v);

			}
			System.out.println(num);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}
		}
		return outV;
	}

}
