package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ImmunizationClinicNewsDao {

	private static String Address;
	private static URL url;
	private static BufferedReader br;
	private static HttpURLConnection conn;
	private static String protocol = "GET";
	private static String id;
	private static String secret;
	private static String size;
	private static String search;
	private static Vector outV;
	private static String authKey;

	public Vector newsDao() {

		try {
			Address = "https://openapi.naver.com/v1/search/news.json?sort=sim&query=";
			id = "VFcnH9cj3uNJ3ZgobKdr"; // api
			id = "VFcnH9cj3uNJ3ZgobKdr"; // client-id
			secret = "aZrGgcxeXR"; // api secret key
			search = URLEncoder.encode("코로나", "UTF-8");// 검색어
			size = "&display=" + 8; // 8개 검색

			url = new URL(Address + search + size);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("X-Naver-Client-Id", id);
			conn.setRequestProperty("X-Naver-Client-Secret", secret);
			conn.setRequestMethod(protocol);

			br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			StringBuffer sb = new StringBuffer();
			String json;

			while ((json = br.readLine()) != null)
				sb.append(json);
//			--------------------------------------------------------------------------------
//			 원본 보기
//			System.out.println(sb.toString());
//			--------------------------------------------------------------------------------

			// 쓸 수 있도록 형태 가공
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject) parser.parse(sb.toString());
			JSONArray items = (JSONArray) obj.get("items");
			outV = new Vector();
			for (int i = 0; i < items.size(); i++) {
				Vector v = new Vector();
				JSONObject tmp = (JSONObject) items.get(i);

				v.add(((String) tmp.get("title")).replace("<b>", "").replace("</b>", "").replace("&quot;", "")
						.replace("Q&amp;", ""));
				v.add((String) tmp.get("link"));
				v.add(((String) tmp.get("description")).replace("<b>", "").replace("</b>", "").replace("&quot;", "")
						.replace("&lt;", "").replace("&gt;", ""));
				outV.add(v);
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return outV;

	}

	public Vector VaccinationCenterDao(// String sido,
			String sigungu) {
		try {
			Address = "https://api.odcloud.kr/api/15077586/v1/centers?serviceKey=";
			authKey = "L1pgoDpVUPJYRf6a%2BVEOyYG7c%2BBVuYzHOwbRLx8h2GyKLmETCICflwglq5NQQ64umxGjdkra%2F0B8VDMkGl4fBQ%3D%3D";
			String perPage = "&perPage=" + 1000;

			url = new URL(Address + authKey + perPage);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(protocol);

			br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			StringBuffer sb = new StringBuffer();
			String json;

			while ((json = br.readLine()) != null)
				sb.append(json);
//			--------------------------------------------------------------------------------
//			 원본 보기
//			System.out.println(sb.toString());
//			--------------------------------------------------------------------------------
			if (sigungu.equals("경남"))
				sigungu = "경상남도";
			if (sigungu.equals("경북"))
				sigungu = "경상북도";
			if (sigungu.equals("충북"))
				sigungu = "충청북도";
			if (sigungu.equals("충남"))
				sigungu = "충청남도";
			if (sigungu.equals("전북"))
				sigungu = "전라북도";
			if (sigungu.equals("전남"))
				sigungu = "전라남도";

			// 쓸 수 있도록 형태 가공
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject) parser.parse(sb.toString());
			JSONArray items = (JSONArray) obj.get("data");
			outV = new Vector();

			for (int i = 0; i < items.size(); i++) {
				Vector v = new Vector();
				JSONObject tmp = (JSONObject) items.get(i);

				if (tmp.get("sigungu").toString().contains(sigungu) || tmp.get("sido").toString().contains(sigungu)) {
					v.add(tmp.get("centerName"));
					v.add(tmp.get("facilityName"));
					v.add(tmp.get("address"));
					v.add(tmp.get("centerType"));
					v.add(tmp.get("org"));
					v.add(tmp.get("phoneNumber"));
					v.add(tmp.get("createdAt"));
					outV.add(v);
				}
			}

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		return outV;
	}

	public Vector VaccinationCenterDao_sido(String sido, 
			String sigungu) {
		try {
			//  https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=10&serviceKey=L1pgoDpVUPJYRf6a%2BVEOyYG7c%2BBVuYzHOwbRLx8h2GyKLmETCICflwglq5NQQ64umxGjdkra%2F0B8VDMkGl4fBQ%3D%3D
			Address = "https://api.odcloud.kr/api/15077586/v1/centers?serviceKey=";
			authKey = "L1pgoDpVUPJYRf6a%2BVEOyYG7c%2BBVuYzHOwbRLx8h2GyKLmETCICflwglq5NQQ64umxGjdkra%2F0B8VDMkGl4fBQ%3D%3D";
			String perPage = "&perPage=" + 1000;
			
			url = new URL(Address + authKey + perPage);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(protocol);

			br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			StringBuffer sb = new StringBuffer();
			String json;

			while ((json = br.readLine()) != null)
				sb.append(json);
//			--------------------------------------------------------------------------------
//			 원본 보기
//			System.out.println(sb.toString());
//			--------------------------------------------------------------------------------

			// 쓸 수 있도록 형태 가공
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject) parser.parse(sb.toString());
			JSONArray items = (JSONArray) obj.get("data");
			outV = new Vector();
			
			if (sido.equals("경남"))
				sido = "경상남도";
			if (sido.equals("경북"))
				sido = "경상북도";
			if (sido.equals("충북"))
				sido = "충청북도";
			if (sido.equals("충남"))
				sido = "충청남도";
			if (sido.equals("전북"))
				sido = "전라북도";
			if (sido.equals("전남"))
				sido = "전라남도";

			for (int i = 0; i < items.size(); i++) {
				Vector v = new Vector();
				JSONObject tmp = (JSONObject) items.get(i);

				if (tmp.get("sido").toString().contains(sido) &&
						tmp.get("sigungu").toString().equals(sigungu)) {
					  v.add(tmp.get("centerName"));
					  v.add(tmp.get("facilityName"));
					  v.add(tmp.get("address"));
					  v.add(tmp.get("centerType"));
					  v.add(tmp.get("org"));
					  v.add(tmp.get("phoneNumber"));
					  v.add(tmp.get("createdAt"));
					  outV.add(v);
				}
			}

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		return outV;
	}

	public static void main(String[] args) {
		ImmunizationClinicNewsDao jDao = new ImmunizationClinicNewsDao();
		jDao.VaccinationCenterDao(// "",
				"");
	}
}
