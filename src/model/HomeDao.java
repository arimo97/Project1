package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class HomeDao {

	private static String Address;
	private static URL url;
	private static BufferedReader br;
	private static HttpURLConnection conn;
	private static String protocol = "GET";
	private static String id;
	private static String secret;
	private static String size;
	private static String search;
	public static Vector outV;
	private static String authKey;
	
	public Vector DistanceDao() {
		try {
			Address = "https://api.odcloud.kr/api/15089317/v1/uddi:23f5d02f-0047-46c8-a938-defadc2ab47c?serviceKey=";
			authKey = "hRXt5X1gQAgvpF06fQ7kUIW1%2BdY%2BQ4LiV3g5DFhFiH%2FvJUSK%2FEo%2BiOfn9YVDsdZPN%2FWaabFsPga4Nlu7KYzX0A%3D%3D"; // api secret key
			String perPage = "&perPage=" + 17;
			url = new URL(Address + authKey + perPage);
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
			JSONArray data = (JSONArray) obj.get("data");
			outV = new Vector();
			for (int i = 0; i < data.size(); i++) {
				Vector v = new Vector();
				JSONObject tmp = (JSONObject) data.get(i);				
				
				v.add(tmp.get("시도명").toString());
				v.add(tmp.get("거리 두기 단계").toString());
				v.add(tmp.get("거리 두기 비고").toString());
				v.add(tmp.get("기준일시").toString());
				outV.add(v);
				
			}
			System.out.println(outV);
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

	
	public static void main(String[] args) {
		HomeDao hDao = new HomeDao();
		hDao.DistanceDao();
	}
	
}
