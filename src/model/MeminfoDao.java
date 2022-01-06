package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MeminfoDao {
	
	static MeminfoDao mDao;

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public static int joinError = -1 ;
	public static int updateError = -1 ;
	
	public static MeminfoDao getInstance() {
			mDao = new MeminfoDao();
		return mDao;
	}

	public void join(MeminfoVo mVo) {
		try {
			String sql = "INSERT INTO MEMBERS"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			conn = DBConn.getInstance();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getId());
			pstmt.setString(2, mVo.getPw());
			pstmt.setString(3, mVo.getName());
			pstmt.setString(4, mVo.getBirth());
			pstmt.setString(5, mVo.getGender());
			pstmt.setString(6, mVo.getTel());
			pstmt.setString(7, mVo.getEmail());
			pstmt.setString(8, mVo.getSido());
			pstmt.setString(9, mVo.getSigungu());
			pstmt.setString(10, mVo.getEup_myeon_dong());
			pstmt.setString(11, mVo.getLi());
			pstmt.setString(12, mVo.getDoro());
			pstmt.setString(13, mVo.getDoro_bon());
			pstmt.setString(14, mVo.getDoro_bu());
			pstmt.setString(15, mVo.getSigungu_build_name());
			pstmt.setString(16, mVo.getBuild_detail());
			pstmt.setString(17, mVo.getAddress_detail());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			joinError = e.getErrorCode();
			e.printStackTrace();
		}
	}
	
	public void update(MeminfoVo mVo) {
		try {
			String sql = "UPDATE MEMBERS"
					+ " SET PASSWD = ?,"
					+ " NAME = ?,"
					+ "	BIRTH = ?,"
					+ " GENDER = ?,"
					+ " TEL = ?,"
					+ " EMAIL = ?,"
					+ " SIDO = ?,"
					+ " SIGUNGU = ?,"
					+ " EUP_MYEON_DONG = ?,"
					+ " LI = ?,"
					+ " DORO = ?,"
					+ " DORO_BON = ?,"
					+ " DORO_BU = ?,"
					+ " SIGUNGU_BUILD_NAME = ?,"
					+ " BUILD_DETAIL = ?,"
					+ " ADDRESS_DETAIL = ?"
					+ " WHERE ID = ?";
			conn = DBConn.getInstance();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getPw());
			pstmt.setString(2, mVo.getName());
			pstmt.setString(3, mVo.getBirth());
			pstmt.setString(4, mVo.getGender());
			pstmt.setString(5, mVo.getTel());
			pstmt.setString(6, mVo.getEmail());
			pstmt.setString(7, mVo.getSido());
			pstmt.setString(8, mVo.getSigungu());
			pstmt.setString(9, mVo.getEup_myeon_dong());
			pstmt.setString(10, mVo.getLi());
			pstmt.setString(11, mVo.getDoro());
			pstmt.setString(12, mVo.getDoro_bon());
			pstmt.setString(13, mVo.getDoro_bu());
			pstmt.setString(14, mVo.getSigungu_build_name());
			pstmt.setString(15, mVo.getBuild_detail());
			pstmt.setString(16, mVo.getAddress_detail());
			pstmt.setString(17, mVo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			updateError = e.getErrorCode();
			e.printStackTrace();
		}
	}
	
	public void delete(String id) {
		try {
			String sql = "delete "
					+ " FROM MEMBERS"
					+ " WHERE ID = ?";
			conn = DBConn.getInstance();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public MeminfoVo showInfo(String id) {
		MeminfoVo mVo = null;
		try {
			String sql = "SELECT ID,"
					+ " PASSWD,"
					+ " NAME,"
					+ " TO_CHAR(BIRTH, 'YYMMDD'),"
					+ " GENDER,"
					+ " TEL,"
					+ " EMAIL,"
					+ " SIDO,"
					+ " SIGUNGU,"
					+ " EUP_MYEON_DONG,"
					+ " LI,"
					+ " DORO,"
					+ " DORO_BON,"
					+ " DORO_BU,"
					+ " SIGUNGU_BUILD_NAME,"
					+ " BUILD_DETAIL,"
					+ " ADDRESS_DETAIL"
					+ " FROM MEMBERS"
					+ " WHERE ID = ?";
			conn = DBConn.getInstance();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mVo = new MeminfoVo(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),
						rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),
						rs.getString(15),rs.getString(16),rs.getString(17));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mVo;
	}
}
