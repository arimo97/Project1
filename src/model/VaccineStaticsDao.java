package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class VaccineStaticsDao {

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
   private static LocalDate date = LocalDate.now();
   
   
   public Vector VaccineDao() throws java.text.ParseException {
      try {
         Address = "https://api.odcloud.kr/api/15077756/v1/vaccine-stat?&cond%5BbaseDate%3A%3AGTE%5D="; 
         authKey = "OpXrReIFM3WssvT1gl8awDpSJusm5iswRhH80AwQNFPNUCPbDXxRmfNkrTarhDCq6N0Izazwla%2FOMt9RlBpc%2Fw%3D%3D"; 
         String perPage = "&perPage=" + 18;
         String servicekey = "&serviceKey=";
        LocalDate	date1		= date.now();
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd"); 
        Date time = new Date();
        String today1 = simpleDate.format(time);
        Date selectDate = simpleDate.parse(today1);
        Calendar cal =new GregorianCalendar(Locale.KOREA);
        cal.setTime(selectDate);
        cal.add(Calendar.DATE, -1);
        String yesterDay = simpleDate.format(cal.getTime());
         url = new URL(Address + yesterDay + servicekey + authKey + perPage);
         conn = (HttpURLConnection) url.openConnection();
         conn.setRequestProperty("X-Naver-Client-Id", id);
         conn.setRequestProperty("X-Naver-Client-Secret", secret);
         conn.setRequestMethod(protocol);
         br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
         StringBuffer sb = new StringBuffer();
         String json;
         
         
         while ((json = br.readLine()) != null)
            sb.append(json);
//         --------------------------------------------------------------------------------
//          원본 보기
         System.out.println(sb.toString());
//         --------------------------------------------------------------------------------

         // 쓸 수 있도록 형태 가공
         JSONParser parser = new JSONParser();
         JSONObject obj = (JSONObject) parser.parse(sb.toString());
         JSONArray data = (JSONArray) obj.get("data");
         outV = new Vector();
         for (int i = 0; i < data.size(); i++) {
            Vector v = new Vector();
            JSONObject tmp = (JSONObject) data.get(i);
            
            v.add(tmp.get("sido").toString()); 
            v.add(tmp.get("firstCnt").toString()); 
            v.add(tmp.get("secondCnt").toString()); 
            v.add(tmp.get("accumulatedFirstCnt").toString()); 
            v.add(tmp.get("accumulatedSecondCnt").toString());
            v.add(tmp.get("baseDate").toString()); 
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
   
   public static void main(String[] args) throws Exception {
      VaccineStaticsDao jDao = new VaccineStaticsDao();
      jDao.VaccineDao();
      

   }
   
}