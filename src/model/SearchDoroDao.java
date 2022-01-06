package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SearchDoroDao {

	static DBConn dbconn;
	static int errorcode = -1; 

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String word_doro = "";
	String word_bonbun = "";
	String word_bubun = "";
	int word_idx = -1;
	
	static Vector<SearchDoroVo> eup_li = new Vector<SearchDoroVo>();   
	
	Vector outV = new Vector();
	
	public Vector doSearch(String word) {
		if ((word_idx = word.indexOf("길")) >= 0) {  
			word_doro = word.substring(0, word_idx).replace(" ", "");
			word_bonbun = word.substring(word_idx + 1, word.length()).replace(" ", "");
		} else if ((word_idx = word.indexOf("로")) >= 0) {
			word_doro = word.substring(0, word_idx).replace(" ", "");
			word_bonbun = word.substring(word_idx + 1, word.length()).replace(" ", "");
		}


		
		if ((word_idx = word_bonbun.indexOf("-")) >= 0) { 
			word_bubun = word_bonbun.substring(word_idx + 1, word_bonbun.length()).trim();
			word_bonbun = word_bonbun.substring(0, word_idx).trim();
		}

		if (word_bubun.isEmpty()) {
			if (word_bonbun.isEmpty()) {
				try {
					String sql = "SELECT DISTINCT SIDO, SIGUNGU, EUP_MYEON_DONG, LI, DORO, DORO_BON, DORO_BU, SIGUNGU_BUILD_NAME, BUILD_DETAIL"
							+ " FROM BUILD_ADDRESS"
							+ " WHERE DORO LIKE ?"
							+ " ORDER BY SIDO, SIGUNGU, DORO, DORO_BON, DORO_BU";
					conn = dbconn.getInstance();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%" + word.replace(" ", "") + "%");
					
					rs = pstmt.executeQuery();
					String temp = "";
					while (rs.next()) {
						Vector v = new Vector();
						String sido = rs.getString(1);
						String sigungu = rs.getString(2);
						String eup_myeon_dong = rs.getString(3);
						String li = rs.getString(4);
						String doro = rs.getString(5);
						String doro_bon = rs.getString(6);
						String doro_bu = rs.getString(7);
						String sigungu_build_name = rs.getString(8);
						String build_detail = rs.getString(9);
						
						v.add(sido);
						v.add(sigungu);
						if (eup_myeon_dong.endsWith("읍") || eup_myeon_dong.endsWith("면"))
							v.add(eup_myeon_dong);
						if (li != null && li.endsWith("리"))
							v.add(li);
						v.add(doro);
						v.add(doro_bon);
						v.add(doro_bu);
						if (sigungu_build_name != null)
							v.add(sigungu_build_name);
						if (build_detail != null)
							v.add(build_detail);
						if (!(eup_myeon_dong.endsWith("읍") || eup_myeon_dong.endsWith("면")))
							v.add("(" + eup_myeon_dong + ")");
						
						eup_li.add(new SearchDoroVo(sido, sigungu, eup_myeon_dong, li, doro, doro_bon, doro_bu, sigungu_build_name, build_detail));
						
						outV.add(v);
					}
					
				} catch (SQLException e) {
					errorcode = e.getErrorCode();
					e.printStackTrace();
				}
			} else {
				try {
					String sql = "SELECT DISTINCT SIDO, SIGUNGU, EUP_MYEON_DONG, LI, DORO, DORO_BON, DORO_BU, SIGUNGU_BUILD_NAME, BUILD_DETAIL"
							+ " FROM BUILD_ADDRESS"
							+ " WHERE DORO LIKE ? and DORO_BON = ?"
							+ " ORDER BY SIDO, SIGUNGU, DORO, DORO_BON, DORO_BU";
					conn = dbconn.getInstance();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%" + word_doro + "%");
					pstmt.setString(2, word_bonbun);
					
					rs = pstmt.executeQuery();
					String temp = "";
					while (rs.next()) {
						Vector v = new Vector();
						String sido = rs.getString(1);
						String sigungu = rs.getString(2);
						String eup_myeon_dong = rs.getString(3);
						String li = rs.getString(4);
						String doro = rs.getString(5);
						String doro_bon = rs.getString(6);
						String doro_bu = rs.getString(7);
						String sigungu_build_name = rs.getString(8);
						String build_detail = rs.getString(9);
						
						v.add(sido);
						v.add(sigungu);
						if (eup_myeon_dong.endsWith("읍") || eup_myeon_dong.endsWith("면"))
							v.add(eup_myeon_dong);
						if (li != null && li.endsWith("리"))
							v.add(li);
						v.add(doro);
						v.add(doro_bon);
						v.add(doro_bu);
						if (sigungu_build_name != null)
							v.add(sigungu_build_name);
						if (build_detail != null)
							v.add(build_detail);
						if (!(eup_myeon_dong.endsWith("읍") || eup_myeon_dong.endsWith("면")))
							v.add("(" + eup_myeon_dong + ")");
						
						eup_li.add(new SearchDoroVo(sido, sigungu, eup_myeon_dong, li, doro, doro_bon, doro_bu, sigungu_build_name, build_detail));
						
						outV.add(v);
					}
				} catch (SQLException e) {
					e.printStackTrace();
					errorcode = e.getErrorCode();
				}
			}

		}
		else {
			try {
				String sql = "SELECT DISTINCT SIDO, SIGUNGU, EUP_MYEON_DONG, LI, DORO, DORO_BON, DORO_BU, SIGUNGU_BUILD_NAME, BUILD_DETAIL"
						+ " FROM BUILD_ADDRESS" 
						+ " WHERE DORO LIKE ? and DORO_BON = ? AND DORO_BU = ?"
						+ " ORDER BY SIDO, SIGUNGU, DORO, DORO_BON, DORO_BU";
				conn = dbconn.getInstance();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + word_doro + "%");
				pstmt.setString(2, word_bonbun);
				pstmt.setString(3, word_bubun);
				
				rs = pstmt.executeQuery();
				String temp = "";
				if (rs.next()) {
					Vector v = new Vector();
					String sido = rs.getString(1);
					String sigungu = rs.getString(2);
					String eup_myeon_dong = rs.getString(3);
					String li = rs.getString(4);
					String doro = rs.getString(5);
					String doro_bon = rs.getString(6);
					String doro_bu = rs.getString(7);
					String sigungu_build_name = rs.getString(8);
					String build_detail = rs.getString(9);
					
					v.add(sido);
					v.add(sigungu);
					if (eup_myeon_dong.endsWith("읍") || eup_myeon_dong.endsWith("면"))
						v.add(eup_myeon_dong);
					if (li != null && li.endsWith("리"))
						v.add(li);
					v.add(doro);
					v.add(doro_bon);
					v.add(doro_bu);
					if (sigungu_build_name != null)
						v.add(sigungu_build_name);
					if (build_detail != null)
						v.add(build_detail);
					if (!(eup_myeon_dong.endsWith("읍") || eup_myeon_dong.endsWith("면")))
						v.add("(" + eup_myeon_dong + ")");
					
					eup_li.add(new SearchDoroVo(sido, sigungu, eup_myeon_dong, li, doro, doro_bon, doro_bu, sigungu_build_name, build_detail));
					outV.add(v);
				}

			} catch (SQLException e) {
				e.printStackTrace();
				errorcode = e.getErrorCode();
			}

		}
		return outV;
	}

}
