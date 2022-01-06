package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLImmunizationClinicDao {
	
	private static String Address;
	private static URL url;
	private static BufferedReader br;
	private static HttpURLConnection conn;
	private static String protocol = "GET";
	private static String authKey;

	public Vector ConfirmedCasesDao() throws IOException, ParserConfigurationException, SAXException {

		authKey = URLEncoder.encode(
				"L1pgoDpVUPJYRf6a+VEOyYG7c+BVuYzHOwbRLx8h2GyKLmETCICflwglq5NQQ64umxGjdkra/0B8VDMkGl4fBQ==", "UTF-8");
		Address = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson?serviceKey=";
		
		String cond = "&cond=" + "쓰고싶은거";

		url = new URL(Address + authKey + cond);
		

		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(protocol);

		br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		StringBuilder sb = new StringBuilder();
		String line;

		while ((line = br.readLine()) != null) {
			sb.append(line);
		}

//		-----------------------------------------------------------------------------------------
//		 xml 원문 보기
//		System.out.println(sb.toString());
//		-----------------------------------------------------------------------------------------

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(new InputSource(new StringReader(sb.toString())));
		doc.getDocumentElement().normalize();

		NodeList itemList = doc.getElementsByTagName("item");
		
		Vector outV = new Vector();
		
		for (int i = 0; i < 19; i++) {
		Vector v = new Vector();	
		Node itemNode = itemList.item(i);
		Element itemEle = (Element) itemNode;
		
		v.add(getValue(itemEle, "gubun"));
		v.add(getValue(itemEle, "defCnt"));
		v.add(getValue(itemEle, "deathCnt"));
		v.add(getValue(itemEle, "incDec"));
		v.add(getValue(itemEle, "localOccCnt"));
		v.add(getValue(itemEle, "isolIngCnt"));
		v.add(getValue(itemEle, "isolClearCnt"));
		v.add(getValue(itemEle, "qurRate"));
		v.add(getValue(itemEle, "stdDay"));

		outV.add(v);
		System.out.println(v);
		
		
		
		
		
		}
		return outV;
	}

	String getValue(Element Ele, String tag) {
		
		NodeList nList = Ele.getElementsByTagName(tag);
		Element nElmnt = (Element) nList.item(0);
		Node nNode = nElmnt.getFirstChild();
		return nNode.getNodeValue();
	}
	
public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
	XMLImmunizationClinicDao xdao = new XMLImmunizationClinicDao();
	System.out.println(xdao.ConfirmedCasesDao());
	
}
	
}
