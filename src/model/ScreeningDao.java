package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class ScreeningDao {
	DBConn dbconn;
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public Vector get_Frist (String sido, String juso) {
		Vector outV = new Vector();
		try {
			String sql = "select 기준일, 시도, 시군구, 의료기관명, 주소" + " from SCREENING_CLINIC"
					+ " order by 시도, 시군구";
			conn = dbconn.getInstance();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(sido.equals("서울특별시")) 
				sido = "서울";
			if(sido.equals("부산광역시")) 
				sido = "부산";
			if(sido.equals("대구광역시")) 
				sido = "대구";
			if(sido.equals("인천광역시")) 
				sido = "인천";
			if(sido.equals("대전광역시")) 
				sido = "대전";
			if(sido.equals("세종특별자치시")) 
				sido = "세종";
			if(sido.equals("울상광역시")) 
				sido = "울산";
			if(sido.equals("경기도")) 
				sido = "경기";
			if(sido.equals("강원도")) 
				sido = "강원";
			if(sido.equals("충청북도")) 
				sido = "충북";
			if(sido.equals("충청남도")) 
				sido = "충남";
			if(sido.equals("전라북도")) 
				sido = "전북";
			if(sido.equals("전라남도")) 
				sido = "전남";
			if(sido.equals("경상북도")) 
				sido = "경북";
			if(sido.equals("경상남도")) 
				sido = "경남";
			if(sido.equals("제주특별자치도")) 
				sido = "제주";
			
			

			while (rs.next()) {

 		    	if (rs.getString("시도").contains(sido) && rs.getString("시군구").contains(juso)  ) {
					Vector v = new Vector();
					v.add(rs.getString("기준일"));
					v.add(rs.getString("시도"));
					v.add(rs.getString("시군구"));
					v.add(rs.getString("의료기관명"));
					v.add(rs.getString("주소"));
					  outV.add(v);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return outV;
	}
	
	public Vector get (String juso) {
		Vector outV = new Vector();
		try {
			String sql = "select 기준일, 시도, 시군구, 의료기관명, 주소" + " from SCREENING_CLINIC"
			+ " order by 시도, 시군구";
			conn = dbconn.getInstance();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			

			while (rs.next()) {

 		    	if (rs.getString("주소").contains(juso) ) {
					Vector v = new Vector();
					v.add(rs.getString("기준일"));
					v.add(rs.getString("시도"));
					v.add(rs.getString("시군구"));
					v.add(rs.getString("의료기관명"));
					v.add(rs.getString("주소"));
					  outV.add(v);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return outV;
	}
}
