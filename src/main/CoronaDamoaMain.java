package main;

////////////통합
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import model.HomeDao;
import model.LoginDao;
import view.CoronaDistance;
import view.CoronaNews;
import view.CovidInfo;
import view.CovidStatus;
import view.ImmunizationClinic;
import view.MemInfo;
import view.Screening;
import view.VaccineStatics;

public class CoronaDamoaMain extends JFrame {
	
	public static String getId() {
		return id;
	}
	public static String getPw() {
		return pw;
	}
	public static void cddispose() {
		frame.dispose();
	}
	
	private static LoginMain loginmain;
	static HomeDao hDao = null;
	private static String id;
	private static String pw;
	private static String sido;
	private static String sigungu;
	private static MemInfo meminfo;
	private static ImmunizationClinic imunclinic;

	static String Seoul;
	static String Busan;
	static String Daegu;
	static String Inchon;
	static String Gwangju;
	static String Daejion;
	static String Ulsan;
	static String Sejong;
	static String Gyunggi;
	static String Gangwon;
	static String ChungB;
	static String ChungN;
	static String JunB;
	static String JunN;
	static String GyungB;
	static String GyungN;
	static String Jeju;

	static String ISeoul;
	static String IBusan;
	static String IDaegu;
	static String IInchon;
	static String IGwangju;
	static String IDaejion;
	static String IUlsan;
	static String ISejong;
	static String IGyunggi;
	static String IGangwon;
	static String IChungB;
	static String IChungN;
	static String IJunB;
	static String IJunN;
	static String IGyungB;
	static String IGyungN;
	static String IJeju;

	static String SeoulImg;
	static String BusanImg;
	static String DaeguImg;
	static String InchonImg;
	static String GwangjuImg;
	static String DaejionImg;
	static String UlsanImg;
	static String SejongImg;
	static String GyunggiImg;
	static String GangwonImg;
	static String ChungBImg;
	static String ChungNImg;
	static String JunBImg;
	static String JunNImg;
	static String GyungBImg;
	static String GyungNImg;
	static String JejuImg;

	static JPanel innerPane;
	private JPanel sidePane;
	private JScrollPane scrollPane;

	JLabel Dan4;
	JLabel Dan3;
	JLabel Dan2;
	JLabel Dan1;
	JLabel Dan0;
	JLabel Emp;

	Dimension size = new Dimension();

	
	private JPanel contentPane;
	private static CoronaDamoaMain frame;
	static CoronaDamoaMain home;
	static Object dis;
	
	GridBagLayout gb;
	GridBagConstraints gbc;
	
	private JList tab_1_List;

	private JTextArea tab_1_textArea;
	private JScrollPane scrollPane_1;
	private JTextArea tab_2_textArea;
	
	public static CoronaDamoaMain getInstance(LoginMain loginMain) {
		if(frame != null)
			frame.dispose();
		frame = new CoronaDamoaMain();
		frame.setVisible(true);
		id = loginMain.getId();
		pw = LoginMain.getPw();
		return frame;
	}
	
	public static CoronaDamoaMain getInstance(){
		if(frame==null){
			frame=new CoronaDamoaMain();
			
			
		}
		return frame;
	}
	
	//메인
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = CoronaDamoaMain.getInstance();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


//생성자
	public CoronaDamoaMain() {
		size.setSize(400, 1000);

		getDataList();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setResizable(false);
		setBounds(100, 100, 1400, 900);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		innerPane = new JPanel();
		innerPane.setLayout(gb);
		innerPane.setBounds(200, 120, 1130, 700);
		contentPane.add(innerPane);

		scrollPane = new JScrollPane(sidePane, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		scrollPane.setBounds(620, 100, 450, 550);
		innerPane.add(scrollPane);

		sidePane = new JPanel();
		sidePane.setBackground(new Color(255, 255, 255));
		sidePane.setLayout(new BoxLayout(sidePane, BoxLayout.Y_AXIS));
		sidePane.setPreferredSize(size);
		scrollPane.setViewportView(sidePane);

		gb = new GridBagLayout();
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;

		ArrayList<String> List4 = new ArrayList<String>();
		ArrayList<String> List3 = new ArrayList<String>();
		ArrayList<String> List2 = new ArrayList<String>();
		ArrayList<String> List1 = new ArrayList<String>();
		ArrayList<String> List0 = new ArrayList<String>();

		String[] ISeoulArr = ISeoul.split("-", 0);
		String[] IBusanArr = IBusan.split("-", 0);
		String[] IDaeguArr = IDaegu.split("-", 0);
		String[] IInchonArr = IInchon.split("-", 0);
		String[] IGwangjuArr = IGwangju.split("-", 0);
		String[] IDaejionArr = IDaejion.split("-", 0);
		String[] IUlsanArr = IUlsan.split("-", 0);
		String[] ISejongArr = ISejong.split("-", 0);
		String[] IGyunggiArr = IGyunggi.split("-", 0);
		String[] IGangwonArr = IGangwon.split("-", 0);
		String[] IChungBArr = IChungB.split("-", 0);
		String[] IChungNArr = IChungN.split("-", 0);
		String[] IJunBArr = IJunB.split("-", 0);
		String[] IJunNArr = IJunN.split("-", 0);
		String[] IGyungBArr = IGyungB.split("-", 0);
		String[] IGyungNArr = IGyungN.split("-", 0);
		String[] IJejuArr = IJeju.split("-", 0);

		// ---------------------------------------------------------------

		// 좌측 메뉴
		CoronaDamoaMain.leftMenu(contentPane, CoronaDamoaMain.this, CoronaDamoaMain.this);
		CoronaDamoaMain.topRightMenu(contentPane, CoronaDamoaMain.this, CoronaDamoaMain.this);
		
		// 버튼

		// 제목
		JLabel lt1 = new JLabel("My 코로나");
		lt1.setFont(new Font("맑은 고딕", Font.BOLD, 70));
		lt1.setForeground(new Color(0, 0, 0));
		lt1.setBounds(500, 0, 700, 100);
		contentPane.add(lt1);

		// 부제목

		JLabel lt2 = new JLabel("지역별 거리두기 단계");
		lt2.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 30));
		lt2.setForeground(new Color(0, 0, 0));
		lt2.setBounds(50, 8, 300, 61);
		innerPane.add(lt2);
		// 주소 ID 가져오기
		sido = LoginDao.getSido();
		sigungu = LoginDao.getSigungu();
		String id1 = LoginDao.getId();
		String dan = null;
		if(sido.contains("서울")) {
			dan = Seoul;
		} else if(sido.contains("부산")) {
			dan = Busan;
			
		} else if(sido.contains("대구")) {
			dan = Daegu;
		} else if(sido.contains("인천")) {
			dan = Inchon;
		} else if(sido.contains("광주")) {
			dan = Gwangju;
		} else if(sido.contains("대전")) {
			dan = Daejion;
		} else if(sido.contains("울산")) {
			dan = Ulsan;
		} else if(sido.contains("세종")) {
			dan = Sejong;
		} else if(sido.contains("경기")) {
			dan = Gyunggi;
		} else if(sido.contains("강원")) {
			dan = Gangwon;
		} else if(sido.contains("충북")) {
			dan = ChungB;
		} else if(sido.contains("충남")) {
			dan = ChungN;
		} else if(sido.contains("전북")) {
			dan = JunB;
		} else if(sido.contains("전남")) {
			dan = JunN;
		} else if(sido.contains("경북")) {
			dan = GyungB;
		} else if(sido.contains("경남")) {
			dan = GyungN;
		} else if(sido.contains("제주")) {
			dan = Jeju;
		}
		JLabel lt3 = new JLabel(id1 + "님의 거주지 " + sido + " " + sigungu + "의 현재 거리두기 단계 : " + dan + "단계");

		
		lt3.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 17));
		lt3.setForeground(new Color(0, 0, 0));
		lt3.setBounds(50, 40, 600, 61);
		innerPane.add(lt3);

		// 서울
		JLabel lSeoul = new JLabel("<html><body style='text-align:center;'>서울<br />" + Seoul + "단계</body></html>");
		lSeoul.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 9));
		JButton bSeoul = new JButton();
		bSeoul.setBounds(270, 170, 59, 30);
		bSeoul.setEnabled(false);
		bSeoul.setFocusPainted(false);

		innerPane.add(bSeoul);
		bSeoul.add(lSeoul);

		// 부산
		JLabel lBusan = new JLabel("<html><body style='text-align:center;'>부산<br />" + Busan + "단계</body></html>");
		lBusan.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 9));
		JButton bBusan = new JButton();
		bBusan.setBounds(430, 520, 59, 30);
		bBusan.setEnabled(false);
		bBusan.setFocusPainted(false);

		innerPane.add(bBusan);
		bBusan.add(lBusan);

		// 대구
		JLabel lDaegu = new JLabel("<html><body style='text-align:center;'>대구<br />" + Daegu + "단계</body></html>");
		lDaegu.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 9));
		JButton bDaegu = new JButton();
		bDaegu.setBounds(390, 395, 59, 30);
		bDaegu.setEnabled(false);
		bDaegu.setFocusPainted(false);

		innerPane.add(bDaegu);
		bDaegu.add(lDaegu);

		// 인천
		JLabel lInchon = new JLabel("<html><body style='text-align:center;'>인천<br />" + Inchon + "단계</body></html>");
		lInchon.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 9));
		JButton bInchon = new JButton();
		bInchon.setBounds(200, 200, 59, 30);
		bInchon.setEnabled(false);
		bInchon.setFocusPainted(false);

		innerPane.add(bInchon);
		bInchon.add(lInchon);

		// 광주
		JLabel lGwangju = new JLabel("<html><body style='text-align:center;'>광주<br />" + Gwangju + "단계</body></html>");
		lGwangju.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 9));
		JButton bGwangju = new JButton();
		bGwangju.setBounds(260, 480, 59, 30);
		bGwangju.setEnabled(false);
		bGwangju.setFocusPainted(false);

		innerPane.add(bGwangju);
		bGwangju.add(lGwangju);

		// 대전
		JLabel lDaejion = new JLabel("<html><body style='text-align:center;'>대전<br />" + Daejion + "단계</body></html>");
		lDaejion.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 9));
		JButton bDaejion = new JButton();
		bDaejion.setBounds(320, 340, 59, 30);
		bDaejion.setEnabled(false);
		bDaejion.setFocusPainted(false);

		innerPane.add(bDaejion);
		bDaejion.add(lDaejion);

		// 울산
		JLabel lUlsan = new JLabel("<html><body style='text-align:center;'>울산<br />" + Ulsan + "단계</body></html>");
		lUlsan.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 9));
		JButton bUlsan = new JButton();
		bUlsan.setBounds(460, 460, 59, 30);
		bUlsan.setEnabled(false);
		bUlsan.setFocusPainted(false);

		innerPane.add(bUlsan);
		bUlsan.add(lUlsan);

		// 세종
		JLabel lSejong = new JLabel("<html><body style='text-align:center;'>세종<br />" + Sejong + "단계</body></html>");
		lSejong.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 9));
		JButton bSejong = new JButton();
		bSejong.setBounds(250, 300, 59, 30);
		bSejong.setEnabled(false);
		bSejong.setFocusPainted(false);

		innerPane.add(bSejong);
		bSejong.add(lSejong);

		// 경기
		JLabel lGyunggi = new JLabel("<html><body style='text-align:center;'>경기<br />" + Gyunggi + "단계</body></html>");
		lGyunggi.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 9));
		JButton bGyunggi = new JButton();
		bGyunggi.setBounds(280, 230, 59, 30);
		bGyunggi.setEnabled(false);
		bGyunggi.setFocusPainted(false);

		innerPane.add(bGyunggi);
		bGyunggi.add(lGyunggi);

		// 강원
		JLabel lGangwon = new JLabel("<html><body style='text-align:center;'>강원<br />" + Gangwon + "단계</body></html>");
		lGangwon.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 9));
		JButton bGangwon = new JButton();
		bGangwon.setBounds(380, 190, 59, 30);
		bGangwon.setEnabled(false);
		bGangwon.setFocusPainted(false);

		innerPane.add(bGangwon);
		bGangwon.add(lGangwon);

		// 충북
		JLabel lChungB = new JLabel("<html><body style='text-align:center;'>충북<br />" + ChungB + "단계</body></html>");
		lChungB.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 9));
		JButton bChungB = new JButton();
		bChungB.setBounds(330, 270, 59, 30);
		bChungB.setEnabled(false);
		bChungB.setFocusPainted(false);

		innerPane.add(bChungB);
		bChungB.add(lChungB);

		// 충남
		JLabel lChungN = new JLabel("<html><body style='text-align:center;'>충남<br />" + ChungN + "단계</body></html>");
		lChungN.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 9));
		JButton bChungN = new JButton();
		bChungN.setBounds(220, 340, 59, 30);
		bChungN.setEnabled(false);
		bChungN.setFocusPainted(false);

		innerPane.add(bChungN);
		bChungN.add(lChungN);

		// 전북
		JLabel lJunB = new JLabel("<html><body style='text-align:center;'>전북<br />" + JunB + "단계</body></html>");
		lJunB.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 9));
		JButton bJunB = new JButton();
		bJunB.setBounds(250, 400, 59, 30);
		bJunB.setEnabled(false);
		bJunB.setFocusPainted(false);

		innerPane.add(bJunB);
		bJunB.add(lJunB);

		// 전남
		JLabel lJunN = new JLabel("<html><body style='text-align:center;'>전남<br />" + JunN + "단계</body></html>");
		lJunN.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 9));
		JButton bJunN = new JButton();
		bJunN.setBounds(180, 510, 59, 30);
		bJunN.setEnabled(false);
		bJunN.setFocusPainted(false);

		innerPane.add(bJunN);
		bJunN.add(lJunN);

		// 경북
		JLabel lGyungB = new JLabel("<html><body style='text-align:center;'>경북<br />" + GyungB + "단계</body></html>");
		lGyungB.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 9));
		JButton bGyungB = new JButton();
		bGyungB.setBounds(400, 330, 59, 30);
		bGyungB.setEnabled(false);
		bGyungB.setFocusPainted(false);

		innerPane.add(bGyungB);
		bGyungB.add(lGyungB);
		// 경남
		JLabel lGyungN = new JLabel("<html><body style='text-align:center;'>경남<br />" + GyungN + "단계</body></html>");
		lGyungN.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 9));
		JButton bGyungN = new JButton();
		bGyungN.setBounds(340, 470, 59, 30);
		bGyungN.setEnabled(false);
		bGyungN.setFocusPainted(false);

		innerPane.add(bGyungN);
		bGyungN.add(lGyungN);

		// 제주
		JLabel lJeju = new JLabel("<html><body style='text-align:center;'>제주<br />" + Jeju + "단계</body></html>");
		lJeju.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 9));
		JButton bJeju = new JButton();
		bJeju.setBounds(230, 595, 59, 30);
		bJeju.setEnabled(false);
		bJeju.setFocusPainted(false);

		innerPane.add(bJeju);
		bJeju.add(lJeju);
//----------------------------------------------------------------------
		// 이미지
		JLabel lb = null;

		// 서울

		if (Seoul.equals("1")) {
			SeoulImg = "img/서울_1.png";
			for (int i = 0; i < ISeoulArr.length; i++) {
				if (ISeoulArr[i].contains("1단계")) {
					List1.add(ISeoulArr[i]);
				}
			}
		} else if (Seoul.equals("2")) {
			SeoulImg = "img/서울_2.png";
			for (int i = 0; i < ISeoulArr.length; i++) {
				if (ISeoulArr[i].contains("1단계")) {
					List1.add("서울 " + ISeoulArr[i]);
				} else if (ISeoulArr[i].contains("2단계")) {
					List2.add(ISeoulArr[i]);
				}
			}
		} else if (Seoul.equals("3")) {
			SeoulImg = "img/서울_3.png";
			for (int i = 0; i < ISeoulArr.length; i++) {
				if (ISeoulArr[i].contains("1단계")) {
					List1.add("서울 " + ISeoulArr[i]);
				} else if (ISeoulArr[i].contains("2단계")) {
					List2.add("서울 " + ISeoulArr[i]);
				} else if (ISeoulArr[i].contains("3단계")) {
					List3.add(ISeoulArr[i]);
				}
			}
		} else if (Seoul.equals("4")) {
			SeoulImg = "img/서울_4.png";
			for (int i = 0; i < ISeoulArr.length; i++) {
				if (ISeoulArr[i].contains("1단계")) {
					List1.add("서울 " + ISeoulArr[i]);
				} else if (ISeoulArr[i].contains("2단계")) {
					List2.add("서울 " + ISeoulArr[i]);
				} else if (ISeoulArr[i].contains("3단계")) {
					List3.add("서울 " + ISeoulArr[i]);
				} else if (ISeoulArr[i].contains("4단계")) {
					List4.add(ISeoulArr[i]);
				}
			}
			
		}
		// 이미지 설정
		BufferedImage img1;
		try {
			img1 = ImageIO.read(new File(SeoulImg));
			Image scaled = img1.getScaledInstance(900, 800, Image.SCALE_SMOOTH);
			ImageIcon icon1 = new ImageIcon(scaled);

			lb = new JLabel(icon1);
			lb.setForeground(Color.WHITE);
			lb.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 30));
			lb.setBounds(150, 100, 450, 700);
			innerPane.add(lb);

		} catch (IOException e) {

			e.printStackTrace();
		}
		// ------------------------------------------------

		// 부산

		if (Busan.equals("1")) {
			BusanImg = "img/부산_1.png";
			for (int i = 0; i < IBusanArr.length; i++) {
				if (IBusanArr[i].contains("1단계")) {
					List1.add(IBusanArr[i]);
				}
			}
		} else if (Busan.equals("2")) {
			BusanImg = "img/부산_2.png";
			for (int i = 0; i < IBusanArr.length; i++) {
				if (IBusanArr[i].contains("1단계")) {
					List1.add("부산 " + IBusanArr[i]);
				} else if (IBusanArr[i].contains("2단계")) {
					List2.add(IBusanArr[i]);
				}
			}
		} else if (Busan.equals("3")) {
			BusanImg = "img/부산_3.png";
			for (int i = 0; i < IBusanArr.length; i++) {
				if (IBusanArr[i].contains("1단계")) {
					List1.add("부산 " + IBusanArr[i]);
				} else if (IBusanArr[i].contains("2단계")) {
					List2.add("부산 " + IBusanArr[i]);
				} else if (IBusanArr[i].contains("3단계")) {
					List3.add(IBusanArr[i]);
				}
			}
		} else if (Busan.equals("4")) {
			BusanImg = "img/부산_4.png";
			for (int i = 0; i < IBusanArr.length; i++) {
				if (IBusanArr[i].contains("1단계")) {
					List1.add("부산 " + IBusanArr[i]);
				} else if (IBusanArr[i].contains("2단계")) {
					List2.add("부산 " + IBusanArr[i]);
				} else if (IBusanArr[i].contains("3단계")) {
					List3.add("부산 " + IBusanArr[i]);
				} else if (IBusanArr[i].contains("4단계")) {
					List4.add(IBusanArr[i]);
				}
			}
			
		}
		BufferedImage img2;
		try {
			img2 = ImageIO.read(new File(BusanImg));
			Image scaled = img2.getScaledInstance(900, 800, Image.SCALE_SMOOTH);
			ImageIcon icon2 = new ImageIcon(scaled);

			lb = new JLabel(icon2);
			lb.setForeground(Color.WHITE);
			lb.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 30));
			lb.setBounds(150, 100, 450, 700);
			innerPane.add(lb);

		} catch (IOException e) {

			e.printStackTrace();
		}

		// 대구

		if (Daegu.equals("1")) {
			DaeguImg = "img/대구_1.png";
			for (int i = 0; i < IDaeguArr.length; i++) {
				if (IDaeguArr[i].contains("1단계")) {
					List1.add(IDaeguArr[i]);
				}
			}
		} else if (Daegu.equals("2")) {
			DaeguImg = "img/대구_2.png";
			for (int i = 0; i < IDaeguArr.length; i++) {
				if (IDaeguArr[i].contains("1단계")) {
					List1.add("대구 " + IDaeguArr[i]);
				} else if (IDaeguArr[i].contains("2단계")) {
					List2.add(IDaeguArr[i]);
				}
			}
		} else if (Daegu.equals("3")) {
			DaeguImg = "img/대구_3.png";
			for (int i = 0; i < IDaeguArr.length; i++) {
				if (IDaeguArr[i].contains("1단계")) {
					List1.add("대구 " + IDaeguArr[i]);
				} else if (IDaeguArr[i].contains("2단계")) {
					List2.add("대구 " + IDaeguArr[i]);
				} else if (IDaeguArr[i].contains("3단계")) {
					List3.add(IDaeguArr[i]);
				}
			}
		} else if (Daegu.equals("4")) {
			DaeguImg = "img/대구_4.png";
			for (int i = 0; i < IDaeguArr.length; i++) {
				if (IDaeguArr[i].contains("1단계")) {
					List1.add("대구 " + IDaeguArr[i]);
				} else if (IDaeguArr[i].contains("2단계")) {
					List2.add("대구 " + IDaeguArr[i]);
				} else if (IDaeguArr[i].contains("3단계")) {
					List3.add("대구 " + IDaeguArr[i]);
				} else if (IDaeguArr[i].contains("4단계")) {
					List4.add(IDaeguArr[i]);
				}
			}
		}
		BufferedImage img3;
		try {
			img3 = ImageIO.read(new File(DaeguImg));
			Image scaled = img3.getScaledInstance(900, 800, Image.SCALE_SMOOTH);
			ImageIcon icon3 = new ImageIcon(scaled);

			lb = new JLabel(icon3);
			lb.setForeground(Color.WHITE);
			lb.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 30));
			lb.setBounds(150, 100, 450, 700);
			innerPane.add(lb);

		} catch (IOException e) {

			e.printStackTrace();
		}

		// 인천

		if (Inchon.equals("1")) {
			InchonImg = "img/인천_1.png";
			for (int i = 0; i < IInchonArr.length; i++) {
				if (IInchonArr[i].contains("1단계")) {
					List1.add(IInchonArr[i]);
				}

			}
		} else if (Inchon.equals("2")) {
			InchonImg = "img/인천_2.png";
			for (int i = 0; i < IInchonArr.length; i++) {
				if (IInchonArr[i].contains("1단계")) {
					List1.add("인천 " + IInchonArr[i]);
				} else if (IInchonArr[i].contains("2단계")) {
					List2.add(IInchonArr[i]);
				}
			}
		} else if (Inchon.equals("3")) {
			InchonImg = "img/인천_3.png";
			for (int i = 0; i < IInchonArr.length; i++) {
				if (IInchonArr[i].contains("1단계")) {
					List1.add("인천 " + IInchonArr[i]);
				} else if (IInchonArr[i].contains("2단계")) {
					List2.add("인천 " + IInchonArr[i]);
				} else if (IInchonArr[i].contains("3단계")) {
					List3.add(IInchonArr[i]);
				}
			}
		} else if (Inchon.equals("4")) {
			InchonImg = "img/인천_4.png";
			for (int i = 0; i < IInchonArr.length; i++) {
				if (IInchonArr[i].contains("1단계")) {
					List1.add("인천 " + IInchonArr[i]);
				} else if (IInchonArr[i].contains("2단계")) {
					List2.add("인천 " + IInchonArr[i]);
				} else if (IInchonArr[i].contains("3단계")) {
					List3.add("인천 " + IInchonArr[i]);
				} else if (IInchonArr[i].contains("4단계")) {
					List4.add(IInchonArr[i]);
				}
			}
		}
		BufferedImage img4;
		try {
			img4 = ImageIO.read(new File(InchonImg));
			Image scaled = img4.getScaledInstance(900, 800, Image.SCALE_SMOOTH);
			ImageIcon icon4 = new ImageIcon(scaled);

			lb = new JLabel(icon4);
			lb.setForeground(Color.WHITE);
			lb.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 30));
			lb.setBounds(150, 100, 450, 700);
			innerPane.add(lb);

		} catch (IOException e) {

			e.printStackTrace();
		}

		// 광주

		if (Gwangju.equals("1")) {
			GwangjuImg = "img/광주_1.png";
			for (int i = 0; i < IGwangjuArr.length; i++) {
				if (IGwangjuArr[i].contains("1단계")) {
					List1.add(IGwangjuArr[i]);
				}
			}
		} else if (Gwangju.equals("2")) {
			GwangjuImg = "img/광주_2.png";
			for (int i = 0; i < IGwangjuArr.length; i++) {
				if (IGwangjuArr[i].contains("1단계")) {
					List1.add("광주 " + IGwangjuArr[i]);
				} else if (IGwangjuArr[i].contains("2단계")) {
					List2.add(IGwangjuArr[i]);
				}
			}
		} else if (Gwangju.equals("3")) {
			GwangjuImg = "img/광주_3.png";
			for (int i = 0; i < IGwangjuArr.length; i++) {
				if (IGwangjuArr[i].contains("1단계")) {
					List1.add("광주 " + IGwangjuArr[i]);
				} else if (IGwangjuArr[i].contains("2단계")) {
					List2.add("광주 " + IGwangjuArr[i]);
				} else if (IGwangjuArr[i].contains("3단계")) {
					List3.add(IGwangjuArr[i]);
				}
			}
		} else if (Gwangju.equals("4")) {
			GwangjuImg = "img/광주_4.png";
			for (int i = 0; i < IGwangjuArr.length; i++) {
				if (IGwangjuArr[i].contains("1단계")) {
					List1.add("광주 " + IGwangjuArr[i]);
				} else if (IGwangjuArr[i].contains("2단계")) {
					List2.add("광주 " + IGwangjuArr[i]);
				} else if (IGwangjuArr[i].contains("3단계")) {
					List3.add("광주 " + IGwangjuArr[i]);
				} else if (IGwangjuArr[i].contains("4단계")) {
					List4.add(IGwangjuArr[i]);
				}
			}
		}
		BufferedImage img5;
		try {
			img5 = ImageIO.read(new File(GwangjuImg));
			Image scaled = img5.getScaledInstance(900, 800, Image.SCALE_SMOOTH);
			ImageIcon icon5 = new ImageIcon(scaled);

			lb = new JLabel(icon5);
			lb.setForeground(Color.WHITE);
			lb.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 30));
			lb.setBounds(150, 100, 450, 700);
			innerPane.add(lb);

		} catch (IOException e) {

			e.printStackTrace();
		}

		// 대전

		if (Daejion.equals("1")) {
			DaejionImg = "img/대전_1.png";
			for (int i = 0; i < IDaejionArr.length; i++) {
				if (IDaejionArr[i].contains("1단계")) {
					List1.add(IDaejionArr[i]);
				}
			}
		} else if (Daejion.equals("2")) {
			DaejionImg = "img/대전_2.png";
			for (int i = 0; i < IDaejionArr.length; i++) {
				if (IDaejionArr[i].contains("1단계")) {
					List1.add("대전 " + IDaejionArr[i]);
				} else if (IDaejionArr[i].contains("2단계")) {
					List2.add(IDaejionArr[i]);
				}
			}
		} else if (Daejion.equals("3")) {
			DaejionImg = "img/대전_3.png";
			for (int i = 0; i < IDaejionArr.length; i++) {
				if (IDaejionArr[i].contains("1단계")) {
					List1.add("대전 " + IDaejionArr[i]);
				} else if (IDaejionArr[i].contains("2단계")) {
					List2.add("대전 " + IDaejionArr[i]);
				} else if (IDaejionArr[i].contains("3단계")) {
					List3.add(IDaejionArr[i]);
				}
			}
		} else if (Daejion.equals("4")) {
			DaejionImg = "img/대전_4.png";
			for (int i = 0; i < IDaejionArr.length; i++) {
				if (IDaejionArr[i].contains("1단계")) {
					List1.add("대전 " + IDaejionArr[i]);
				} else if (IDaejionArr[i].contains("2단계")) {
					List2.add("대전 " + IDaejionArr[i]);
				} else if (IDaejionArr[i].contains("3단계")) {
					List3.add("대전 " + IDaejionArr[i]);
				} else if (IDaejionArr[i].contains("4단계")) {
					List4.add(IDaejionArr[i]);
				}
			}
		}
		BufferedImage img6;
		try {
			img6 = ImageIO.read(new File(DaejionImg));
			Image scaled = img6.getScaledInstance(900, 800, Image.SCALE_SMOOTH);
			ImageIcon icon6 = new ImageIcon(scaled);

			lb = new JLabel(icon6);
			lb.setForeground(Color.WHITE);
			lb.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 30));
			lb.setBounds(150, 100, 450, 700);
			innerPane.add(lb);

		} catch (IOException e) {

			e.printStackTrace();
		}

		// 울산

		if (Ulsan.equals("1")) {
			UlsanImg = "img/울산_1.png";
			for (int i = 0; i < IUlsanArr.length; i++) {
				if (IUlsanArr[i].contains("1단계")) {
					List1.add(IUlsanArr[i]);
				}
			}
		} else if (Ulsan.equals("2")) {
			UlsanImg = "img/울산_2.png";
			for (int i = 0; i < IUlsanArr.length; i++) {
				if (IUlsanArr[i].contains("1단계")) {
					List1.add("울산 " + IUlsanArr[i]);
				} else if (IUlsanArr[i].contains("2단계")) {
					List2.add(IUlsanArr[i]);
				}
			}
		} else if (Ulsan.equals("3")) {
			UlsanImg = "img/울산_3.png";
			for (int i = 0; i < IUlsanArr.length; i++) {
				if (IUlsanArr[i].contains("1단계")) {
					List1.add("울산 " + IUlsanArr[i]);
				} else if (IUlsanArr[i].contains("2단계")) {
					List2.add("울산 " + IUlsanArr[i]);
				} else if (IDaejionArr[i].contains("3단계")) {
					List3.add(IUlsanArr[i]);
				}
			}
		} else if (Ulsan.equals("4")) {
			UlsanImg = "img/울산_4.png";
			for (int i = 0; i < IUlsanArr.length; i++) {
				if (IUlsanArr[i].contains("1단계")) {
					List1.add("울산 " + IUlsanArr[i]);
				} else if (IUlsanArr[i].contains("2단계")) {
					List2.add("울산 " + IUlsanArr[i]);
				} else if (IUlsanArr[i].contains("3단계")) {
					List3.add("울산 " + IUlsanArr[i]);
				} else if (IUlsanArr[i].contains("4단계")) {
					List4.add(IUlsanArr[i]);
				}
			}
		}
		BufferedImage img7;
		try {
			img7 = ImageIO.read(new File(UlsanImg));
			Image scaled = img7.getScaledInstance(900, 800, Image.SCALE_SMOOTH);
			ImageIcon icon7 = new ImageIcon(scaled);

			lb = new JLabel(icon7);
			lb.setForeground(Color.WHITE);
			lb.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 30));
			lb.setBounds(150, 100, 450, 700);
			innerPane.add(lb);

		} catch (IOException e) {

			e.printStackTrace();
		}

		// 세종

		if (Sejong.equals("1")) {
			SejongImg = "img/세종_1.png";
			for (int i = 0; i < IUlsanArr.length; i++) {
				if (IUlsanArr[i].contains("1단계")) {
					List1.add(IUlsanArr[i]);
				}
			}
		} else if (Sejong.equals("2")) {
			SejongImg = "img/세종_2.png";
			for (int i = 0; i < ISejongArr.length; i++) {
				if (ISejongArr[i].contains("1단계")) {
					List1.add("세종 " + ISejongArr[i]);
				} else if (ISejongArr[i].contains("2단계")) {
					List2.add(ISejongArr[i]);
				}
			}
		} else if (Sejong.equals("3")) {
			SejongImg = "img/세종_3.png";
			for (int i = 0; i < ISejongArr.length; i++) {
				if (ISejongArr[i].contains("1단계")) {
					List1.add("세종 " + ISejongArr[i]);
				} else if (ISejongArr[i].contains("2단계")) {
					List2.add("세종 " + ISejongArr[i]);
				} else if (ISejongArr[i].contains("3단계")) {
					List3.add(ISejongArr[i]);
				}
			}
		} else if (Sejong.equals("4")) {
			SejongImg = "img/세종_4.png";
			for (int i = 0; i < ISejongArr.length; i++) {
				if (ISejongArr[i].contains("1단계")) {
					List1.add("세종 " + ISejongArr[i]);
				} else if (ISejongArr[i].contains("2단계")) {
					List2.add("세종 " + ISejongArr[i]);
				} else if (ISejongArr[i].contains("3단계")) {
					List3.add("세종 " + ISejongArr[i]);
				} else if (ISejongArr[i].contains("4단계")) {
					List4.add(ISejongArr[i]);
				}
			}
		}
		BufferedImage img8;
		try {
			img8 = ImageIO.read(new File(SejongImg));
			Image scaled = img8.getScaledInstance(900, 800, Image.SCALE_SMOOTH);
			ImageIcon icon8 = new ImageIcon(scaled);

			lb = new JLabel(icon8);
			lb.setForeground(Color.WHITE);
			lb.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 30));
			lb.setBounds(150, 100, 450, 700);
			innerPane.add(lb);

		} catch (IOException e) {

			e.printStackTrace();
		}

		// 경기

		if (Gyunggi.equals("1")) {
			GyunggiImg = "img/경기_1.png";
			for (int i = 0; i < IGyunggiArr.length; i++) {
				if (IGyunggiArr[i].contains("1단계")) {
					List1.add(IGyunggiArr[i]);
				}
			}
		} else if (Gyunggi.equals("2")) {
			GyunggiImg = "img/경기_2.png";
			for (int i = 0; i < IGyunggiArr.length; i++) {
				if (IGyunggiArr[i].contains("1단계")) {
					List1.add("경기 " + IGyunggiArr[i]);
				} else if (IGyunggiArr[i].contains("2단계")) {
					List2.add(IGyunggiArr[i]);
				}
			}
		} else if (Gyunggi.equals("3")) {
			GyunggiImg = "img/경기_3.png";
			for (int i = 0; i < IGyunggiArr.length; i++) {
				if (IGyunggiArr[i].contains("1단계")) {
					List1.add("경기 " + IGyunggiArr[i]);
				} else if (IGyunggiArr[i].contains("2단계")) {
					List2.add("경기 " + IGyunggiArr[i]);
				} else if (IGyunggiArr[i].contains("3단계")) {
					List3.add(IGyunggiArr[i]);
				}
			}
		} else if (Gyunggi.equals("4")) {
			GyunggiImg = "img/경기_4.png";
			for (int i = 0; i < IGyunggiArr.length; i++) {
				if (IGyunggiArr[i].contains("1단계")) {
					List1.add("경기 " + IGyunggiArr[i]);
				} else if (IGyunggiArr[i].contains("2단계")) {
					List2.add("경기 " + IGyunggiArr[i]);
				} else if (IGyunggiArr[i].contains("3단계")) {
					List3.add("경기 " + IGyunggiArr[i]);
				} else if (IGyunggiArr[i].contains("4단계")) {
					List4.add(IGyunggiArr[i]);
				}
			}
		}

		BufferedImage img9;
		try {
			img9 = ImageIO.read(new File(GyunggiImg));
			Image scaled = img9.getScaledInstance(900, 800, Image.SCALE_SMOOTH);
			ImageIcon icon9 = new ImageIcon(scaled);

			lb = new JLabel(icon9);
			lb.setForeground(Color.WHITE);
			lb.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 30));
			lb.setBounds(150, 100, 450, 700);
			innerPane.add(lb);

		} catch (IOException e) {

			e.printStackTrace();
		}

		// 강원

		if (Gangwon.equals("1")) {
			GangwonImg = "img/강원_1.png";
			for (int i = 0; i < IGangwonArr.length; i++) {
				if (IGangwonArr[i].contains("1단계")) {
					List1.add(IGangwonArr[i]);
				}
			}
		} else if (Gangwon.equals("2")) {
			GangwonImg = "img/강원_2.png";
			for (int i = 0; i < IGangwonArr.length; i++) {
				if (IGangwonArr[i].contains("1단계")) {
					List1.add("강원 " + IGangwonArr[i]);
				} else if (IGangwonArr[i].contains("2단계")) {
					List2.add(IGangwonArr[i]);
				}
			}
		} else if (Gangwon.equals("3")) {
			GangwonImg = "img/강원_3.png";
			for (int i = 0; i < IGangwonArr.length; i++) {
				if (IGangwonArr[i].contains("1단계")) {
					List1.add("강원 " + IGangwonArr[i]);
				} else if (IGangwonArr[i].contains("2단계")) {
					List2.add("강원 " + IGangwonArr[i]);
				} else if (IGangwonArr[i].contains("3단계")) {
					List3.add(IGangwonArr[i]);
				}
			}
		} else if (Gangwon.equals("4")) {
			GangwonImg = "img/강원_4.png";
			for (int i = 0; i < IGangwonArr.length; i++) {
				if (IGangwonArr[i].contains("1단계")) {
					List1.add("강원 " + IGangwonArr[i]);
				} else if (IGangwonArr[i].contains("2단계")) {
					List2.add("강원 " + IGangwonArr[i]);
				} else if (IGangwonArr[i].contains("3단계")) {
					List3.add("강원 " + IGangwonArr[i]);
				} else if (IGangwonArr[i].contains("4단계")) {
					List4.add(IGangwonArr[i]);
				}
			}
		}
		BufferedImage img10;
		try {
			img10 = ImageIO.read(new File(GangwonImg));
			Image scaled = img10.getScaledInstance(900, 800, Image.SCALE_SMOOTH);
			ImageIcon icon10 = new ImageIcon(scaled);

			lb = new JLabel(icon10);
			lb.setForeground(Color.WHITE);
			lb.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 30));
			lb.setBounds(150, 100, 450, 700);
			innerPane.add(lb);

		} catch (IOException e) {

			e.printStackTrace();
		}

		// 충북

		if (ChungB.equals("1")) {
			ChungBImg = "img/충북_1.png";
			for (int i = 0; i < IChungBArr.length; i++) {
				if (IChungBArr[i].contains("1단계")) {
					List1.add(IChungBArr[i]);
				}
			}
		} else if (ChungB.equals("2")) {
			ChungBImg = "img/충북_2.png";
			for (int i = 0; i < IChungBArr.length; i++) {
				if (IChungBArr[i].contains("1단계")) {
					List1.add("충북 " + IChungBArr[i]);
				} else if (IChungBArr[i].contains("2단계")) {
					List2.add(IChungBArr[i]);
				}
			}
		} else if (ChungB.equals("3")) {
			ChungBImg = "img/충북_3.png";
			for (int i = 0; i < IChungBArr.length; i++) {
				if (IChungBArr[i].contains("1단계")) {
					List1.add("충북 " + IChungBArr[i]);
				} else if (IChungBArr[i].contains("2단계")) {
					List2.add("충북 " + IChungBArr[i]);
				} else if (IChungBArr[i].contains("3단계")) {
					List3.add(IChungBArr[i]);
				}
			}
		} else if (ChungB.equals("4")) {
			ChungBImg = "img/충북_4.png";
			for (int i = 0; i < IChungBArr.length; i++) {
				if (IChungBArr[i].contains("1단계")) {
					List1.add("충북 " + IChungBArr[i]);
				} else if (IChungBArr[i].contains("2단계")) {
					List2.add("충북 " + IChungBArr[i]);
				} else if (IChungBArr[i].contains("3단계")) {
					List3.add("충북 " + IChungBArr[i]);
				} else if (IChungBArr[i].contains("4단계")) {
					List4.add(IChungBArr[i]);
				}
			}
		}
		BufferedImage img11;
		try {
			img11 = ImageIO.read(new File(ChungBImg));
			Image scaled = img11.getScaledInstance(900, 800, Image.SCALE_SMOOTH);
			ImageIcon icon11 = new ImageIcon(scaled);

			lb = new JLabel(icon11);
			lb.setForeground(Color.WHITE);
			lb.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 30));
			lb.setBounds(150, 100, 450, 700);
			innerPane.add(lb);

		} catch (IOException e) {

			e.printStackTrace();
		}

		// 충남

		if (ChungN.equals("1")) {
			ChungNImg = "img/충남_1.png";
			for (int i = 0; i < IChungNArr.length; i++) {
				if (IChungNArr[i].contains("1단계")) {
					List1.add(IChungNArr[i]);
				}
			}
		} else if (ChungN.equals("2")) {
			ChungNImg = "img/충남_2.png";
			for (int i = 0; i < IChungNArr.length; i++) {
				if (IChungNArr[i].contains("1단계")) {
					List1.add("충남 " + IChungNArr[i]);
				} else if (IChungNArr[i].contains("2단계")) {
					List2.add(IChungNArr[i]);
				}
			}
		} else if (ChungN.equals("3")) {
			ChungNImg = "img/충남_3.png";
			for (int i = 0; i < IChungNArr.length; i++) {
				if (IChungNArr[i].contains("1단계")) {
					List1.add("충남 " + IChungNArr[i]);
				} else if (IChungNArr[i].contains("2단계")) {
					List2.add("충남 " + IChungNArr[i]);
				} else if (IChungNArr[i].contains("3단계")) {
					List3.add(IChungNArr[i]);
				}
			}
		} else if (ChungN.equals("4")) {
			ChungNImg = "img/충남_4.png";
			for (int i = 0; i < IChungNArr.length; i++) {
				if (IChungNArr[i].contains("1단계")) {
					List1.add("충남 " + IChungNArr[i]);
				} else if (IChungNArr[i].contains("2단계")) {
					List2.add("충남 " + IChungNArr[i]);
				} else if (IChungNArr[i].contains("3단계")) {
					List3.add("충남 " + IChungNArr[i]);
				} else if (IChungNArr[i].contains("4단계")) {
					List4.add(IChungNArr[i]);
				}
			}
		}
		BufferedImage img12;
		try {
			img12 = ImageIO.read(new File(ChungNImg));
			Image scaled = img12.getScaledInstance(900, 800, Image.SCALE_SMOOTH);
			ImageIcon icon12 = new ImageIcon(scaled);

			lb = new JLabel(icon12);
			lb.setForeground(Color.WHITE);
			lb.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 30));
			lb.setBounds(150, 100, 450, 700);
			innerPane.add(lb);

		} catch (IOException e) {

			e.printStackTrace();
		}

		// 전북

		if (JunB.equals("1")) {
			JunBImg = "img/전북_1.png";
			for (int i = 0; i < IJunBArr.length; i++) {
				if (IJunBArr[i].contains("1단계")) {
					List1.add(IJunBArr[i]);
				}
			}
		} else if (JunB.equals("2")) {
			JunBImg = "img/전북_2.png";
			for (int i = 0; i < IJunBArr.length; i++) {
				if (IJunBArr[i].contains("1단계")) {
					List1.add("전북 " + IJunBArr[i]);
				} else if (IJunBArr[i].contains("2단계")) {
					List2.add(IJunBArr[i]);
				}
			}
		} else if (JunB.equals("3")) {
			JunBImg = "img/전북_3.png";
			for (int i = 0; i < IJunBArr.length; i++) {
				if (IJunBArr[i].contains("1단계")) {
					List1.add("전북 " + IJunBArr[i]);
				} else if (IJunBArr[i].contains("2단계")) {
					List2.add("전북 " + IJunBArr[i]);
				} else if (IJunBArr[i].contains("3단계")) {
					List3.add(IJunBArr[i]);
				}
			}
		} else if (JunB.equals("4")) {
			JunBImg = "img/전북_4.png";
			for (int i = 0; i < IJunBArr.length; i++) {
				if (IJunBArr[i].contains("1단계")) {
					List1.add("전북 " + IJunBArr[i]);
				} else if (IJunBArr[i].contains("2단계")) {
					List2.add("전북 " + IJunBArr[i]);
				} else if (IJunBArr[i].contains("3단계")) {
					List3.add("전북 " + IJunBArr[i]);
				} else if (IJunBArr[i].contains("4단계")) {
					List4.add(IJunBArr[i]);
				}
			}
		}
		BufferedImage img13;
		try {
			img13 = ImageIO.read(new File(JunBImg));
			Image scaled = img13.getScaledInstance(900, 800, Image.SCALE_SMOOTH);
			ImageIcon icon13 = new ImageIcon(scaled);

			lb = new JLabel(icon13);
			lb.setForeground(Color.WHITE);
			lb.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 30));
			lb.setBounds(150, 100, 450, 700);
			innerPane.add(lb);

		} catch (IOException e) {

			e.printStackTrace();
		}

		// 전남

		if (JunN.equals("1")) {
			JunNImg = "img/전남_1.png";
			for (int i = 0; i < IJunNArr.length; i++) {
				if (IJunNArr[i].contains("1단계")) {
					List1.add(IJunNArr[i]);
				}
			}
		} else if (JunN.equals("2")) {
			JunNImg = "img/전남_2.png";
			for (int i = 0; i < IJunNArr.length; i++) {
				if (IJunNArr[i].contains("1단계")) {
					List1.add("전남 " + IJunNArr[i]);
				} else if (IJunNArr[i].contains("2단계")) {
					List2.add(IJunNArr[i]);
				}
			}
		} else if (JunN.equals("3")) {
			JunNImg = "img/전남_3.png";
			for (int i = 0; i < IJunNArr.length; i++) {
				if (IJunNArr[i].contains("1단계")) {
					List1.add("전남 " + IJunNArr[i]);
				} else if (IJunNArr[i].contains("2단계")) {
					List2.add("전남 " + IJunNArr[i]);
				} else if (IJunNArr[i].contains("3단계")) {
					List3.add(IJunNArr[i]);
				}
			}
		} else if (JunN.equals("4")) {
			JunNImg = "img/전남_4.png";
			for (int i = 0; i < IJunNArr.length; i++) {
				if (IJunNArr[i].contains("1단계")) {
					List1.add("전남 " + IJunNArr[i]);
				} else if (IJunNArr[i].contains("2단계")) {
					List2.add("전남 " + IJunNArr[i]);
				} else if (IJunNArr[i].contains("3단계")) {
					List3.add("전남 " + IJunNArr[i]);
				} else if (IJunNArr[i].contains("4단계")) {
					List4.add(IJunNArr[i]);
				}
			}
		}
		BufferedImage img14;
		try {
			img14 = ImageIO.read(new File(JunNImg));
			Image scaled = img14.getScaledInstance(900, 800, Image.SCALE_SMOOTH);
			ImageIcon icon14 = new ImageIcon(scaled);

			lb = new JLabel(icon14);
			lb.setForeground(Color.WHITE);
			lb.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 30));
			lb.setBounds(150, 100, 450, 700);
			innerPane.add(lb);

		} catch (IOException e) {

			e.printStackTrace();
		}

		// 경북

		if (GyungB.equals("1")) {
			GyungBImg = "img/경북_1.png";
			for (int i = 0; i < IGyungBArr.length; i++) {
				if (IGyungBArr[i].contains("1단계")) {
					List1.add(IGyungBArr[i]);
				}
			}
		} else if (GyungB.equals("2")) {
			GyungBImg = "img/경북_2.png";
			for (int i = 0; i < IGyungBArr.length; i++) {
				if (IGyungBArr[i].contains("1단계")) {
					List1.add("경북 " + IGyungBArr[i]);
				} else if (IGyungBArr[i].contains("2단계")) {
					List2.add(IGyungBArr[i]);
				}
			}
		} else if (GyungB.equals("3")) {
			GyungBImg = "img/경북_3.png";
			for (int i = 0; i < IGyungBArr.length; i++) {
				if (IGyungBArr[i].contains("1단계")) {
					List1.add("경북 " + IGyungBArr[i]);
				} else if (IGyungBArr[i].contains("2단계")) {
					List2.add("경북 " + IGyungBArr[i]);
				} else if (IGyungBArr[i].contains("3단계")) {
					List3.add(IGyungBArr[i]);
				}
			}
		} else if (GyungB.equals("4")) {
			GyungBImg = "img/경북_4.png";
			for (int i = 0; i < IGyungBArr.length; i++) {
				if (IGyungBArr[i].contains("1단계")) {
					List1.add("경북 " + IGyungBArr[i]);
				} else if (IGyungBArr[i].contains("2단계")) {
					List2.add("경북 " + IGyungBArr[i]);
				} else if (IGyungBArr[i].contains("3단계")) {
					List3.add("경북 " + IGyungBArr[i]);
				} else if (IGyungBArr[i].contains("4단계")) {
					List4.add(IGyungBArr[i]);
				}
			}
		}

		BufferedImage img15;
		try {
			img15 = ImageIO.read(new File(GyungBImg));
			Image scaled = img15.getScaledInstance(900, 800, Image.SCALE_SMOOTH);
			ImageIcon icon15 = new ImageIcon(scaled);

			lb = new JLabel(icon15);
			lb.setForeground(Color.WHITE);
			lb.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 30));
			lb.setBounds(150, 100, 450, 700);
			innerPane.add(lb);

		} catch (IOException e) {

			e.printStackTrace();
		}

		// 경남

		if (GyungN.equals("1")) {
			GyungNImg = "img/경남_1.png";
			for (int i = 0; i < IGyungNArr.length; i++) {
				if (IGyungNArr[i].contains("1단계")) {
					List1.add(IGyungNArr[i]);
				}
			}
		} else if (GyungN.equals("2")) {
			GyungNImg = "img/경남_2.png";
			for (int i = 0; i < IGyungNArr.length; i++) {
				if (IGyungNArr[i].contains("1단계")) {
					List1.add("경남 " + IGyungNArr[i]);
				} else if (IGyungNArr[i].contains("2단계")) {
					List2.add(IGyungNArr[i]);
				}
			}
		} else if (GyungN.equals("3")) {
			GyungNImg = "img/경남_3.png";
			for (int i = 0; i < IGyungNArr.length; i++) {
				if (IGyungNArr[i].contains("1단계")) {
					List1.add("경남 " + IGyungNArr[i]);
				} else if (IGyungNArr[i].contains("2단계")) {
					List2.add("경남 " + IGyungNArr[i]);
				} else if (IGyungNArr[i].contains("3단계")) {
					List3.add(IGyungNArr[i]);
				}
			}
		} else if (GyungN.equals("4")) {
			GyungNImg = "img/경남_4.png";
			for (int i = 0; i < IGyungNArr.length; i++) {
				if (IGyungNArr[i].contains("1단계")) {
					List1.add("경남 " + IGyungNArr[i]);
				} else if (IGyungNArr[i].contains("2단계")) {
					List2.add("경남 " + IGyungNArr[i]);
				} else if (IGyungNArr[i].contains("3단계")) {
					List3.add("경남 " + IGyungNArr[i]);
				} else if (IGyungNArr[i].contains("4단계")) {
					List4.add(IGyungNArr[i]);
				}
			}
		}
		BufferedImage img16;
		try {
			img16 = ImageIO.read(new File(GyungNImg));
			Image scaled = img16.getScaledInstance(900, 800, Image.SCALE_SMOOTH);
			ImageIcon icon16 = new ImageIcon(scaled);

			lb = new JLabel(icon16);
			lb.setForeground(Color.WHITE);
			lb.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 30));
			lb.setBounds(150, 100, 450, 700);
			innerPane.add(lb);

		} catch (IOException e) {

			e.printStackTrace();
		}

		// 제주

		if (Jeju.equals("1")) {
			JejuImg = "img/제주_1.png";
			for (int i = 0; i < IJejuArr.length; i++) {
				if (IJejuArr[i].contains("1단계")) {
					List1.add(IJejuArr[i]);
				}
			}
		} else if (Jeju.equals("2")) {
			JejuImg = "img/제주_2.png";
			for (int i = 0; i < IJejuArr.length; i++) {
				if (IJejuArr[i].contains("1단계")) {
					List1.add("제주 " + IJejuArr[i]);
				} else if (IJejuArr[i].contains("2단계")) {
					List2.add(IJejuArr[i]);
				}
			}
		} else if (Jeju.equals("3")) {
			JejuImg = "img/제주_3.png";
			for (int i = 0; i < IJejuArr.length; i++) {
				if (IJejuArr[i].contains("1단계")) {
					List1.add("제주 " + IJejuArr[i]);
				} else if (IJejuArr[i].contains("2단계")) {
					List2.add("제주 " + IJejuArr[i]);
				} else if (IJejuArr[i].contains("3단계")) {
					List3.add(IJejuArr[i]);
				}
			}
		} else if (Jeju.equals("4")) {
			JejuImg = "img/제주_4.png";
			for (int i = 0; i < IJejuArr.length; i++) {
				if (IJejuArr[i].contains("1단계")) {
					List1.add("제주 " + IJejuArr[i]);
				} else if (IJejuArr[i].contains("2단계")) {
					List2.add("제주 " + IJejuArr[i]);
				} else if (IJejuArr[i].contains("3단계")) {
					List3.add("제주 " + IJejuArr[i]);
				} else if (IJejuArr[i].contains("4단계")) {
					List4.add(IJejuArr[i]);
				}
			}
		}
		BufferedImage img17;
		try {
			img17 = ImageIO.read(new File(JejuImg));
			Image scaled = img17.getScaledInstance(900, 800, Image.SCALE_SMOOTH);
			ImageIcon icon17 = new ImageIcon(scaled);

			lb = new JLabel(icon17);
			lb.setForeground(Color.WHITE);
			lb.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 30));
			lb.setBounds(165, 40, 450, 700);
			innerPane.add(lb);

		} catch (IOException e) {

			e.printStackTrace();
		}

		// 단계 상세
		Dan4 = new JLabel("4단계");
		Dan4.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 15));
		Dan4.setBounds(5, 0, 40, 30);

		Dan3 = new JLabel("3단계");
		Dan3.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 15));
		Dan3.setBounds(5, 300, 40, 30);

		Dan2 = new JLabel("2단계");
		Dan2.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 15));
		Dan2.setBounds(5, 600, 40, 30);

		Dan1 = new JLabel("1단계");
		Dan1.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 15));
		Dan1.setBounds(5, 900, 40, 30);

		Dan0 = new JLabel("거리두기 단계 해제");
		Dan0.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 15));
		Dan0.setBounds(5, 1200, 40, 30);
		
		Emp = new JLabel("     ");
		sidePane.add(Emp);
		sidePane.add(Dan4);
		Emp = new JLabel("     ");
		sidePane.add(Emp);
		JLabel Dan4_Info = null;
		for (int i = 0; i < List4.size(); i++) {

			Dan4_Info = new JLabel(List4.get(i));
			Dan4_Info.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 12));

			if (List4.size() != 0) {
				sidePane.add(Dan4_Info);
			} else if (List4.size() == 0) {
				Dan4_Info = new JLabel("지역이 없습니다.");
				sidePane.add(Dan4_Info);
			}
		}
		sidePane.add(Emp);
		Emp = new JLabel("     ");
		sidePane.add(Emp);
		Emp = new JLabel("     ");
		sidePane.add(Dan3);
		Emp = new JLabel("     ");
		sidePane.add(Emp);
		JLabel Dan3_Info = null;
		for (int i = 0; i < List3.size(); i++) {

			Dan3_Info = new JLabel(List3.get(i));
			Dan3_Info.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 12));

			if (List3.size() != 0) {
				sidePane.add(Dan3_Info);
			} else if (List3.size() == 0) {
				Dan3_Info = new JLabel("지역이 없습니다.");
				sidePane.add(Dan3_Info);
			}
		}
		sidePane.add(Emp);
		Emp = new JLabel("     ");
		sidePane.add(Emp);
		Emp = new JLabel("     ");
		sidePane.add(Dan2);
		Emp = new JLabel("     ");
		sidePane.add(Emp);
		JLabel Dan2_Info = null;
		for (int i = 0; i < List2.size(); i++) {

			Dan2_Info = new JLabel(List2.get(i));
			Dan2_Info.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 12));

			if (List2.size() != 0) {
				sidePane.add(Dan2_Info);
			} else if (List2.size() == 0) {
				Dan2_Info = new JLabel("지역이 없습니다.");
				sidePane.add(Dan2_Info);
			}
		}
		Emp = new JLabel("     ");
		sidePane.add(Emp);
		Emp = new JLabel("     ");
		sidePane.add(Emp);
		sidePane.add(Dan1);
		Emp = new JLabel("     ");
		sidePane.add(Emp);
		JLabel Dan1_Info = null;
		for (int i = 0; i < List1.size(); i++) {

			Dan1_Info = new JLabel(List1.get(i));
			Dan1_Info.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 12));

			if (List1.size() != 0) {
				sidePane.add(Dan1_Info);
			} else if (List1.size() == 0) {
				Dan1_Info = new JLabel("지역이 없습니다.");
				sidePane.add(Dan1_Info);
			}
		}
		Emp = new JLabel("     ");
		sidePane.add(Emp);
		Emp = new JLabel("     ");
		sidePane.add(Emp);
		sidePane.add(Dan0);
		Emp = new JLabel("     ");
		sidePane.add(Emp);
		JLabel Dan0_Info = null;
		for (int i = 0; i < List0.size(); i++) {

			Dan0_Info = new JLabel(List0.get(i));
			Dan0_Info.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 12));

			if (List0.size() != 0) {
				sidePane.add(Dan0_Info);
			} else if (List0.size() == 0) {
				Dan0_Info = new JLabel("지역이 없습니다.");
				sidePane.add(Dan0_Info);
			}
		}

		// ----------------------------------------------------

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(1400, 900);
		this.setVisible(true);

		// System.out.println(hDao.outV);

		

	}
	
	private static void getDataList() {

		hDao = new HomeDao();
		Vector v = hDao.DistanceDao();
// 단계 숫자
		Seoul = ((Vector) v.get(0)).get(1).toString();
		Busan = ((Vector) v.get(1)).get(1).toString();
		Daegu = ((Vector) v.get(2)).get(1).toString();
		Inchon = ((Vector) v.get(3)).get(1).toString();
		Gwangju = ((Vector) v.get(4)).get(1).toString();
		Daejion = ((Vector) v.get(5)).get(1).toString();
		Ulsan = ((Vector) v.get(6)).get(1).toString();
		Sejong = ((Vector) v.get(7)).get(1).toString();
		Gyunggi = ((Vector) v.get(8)).get(1).toString();
		Gangwon = ((Vector) v.get(9)).get(1).toString();
		ChungB = ((Vector) v.get(10)).get(1).toString();
		ChungN = ((Vector) v.get(11)).get(1).toString();
		JunB = ((Vector) v.get(12)).get(1).toString();
		JunN = ((Vector) v.get(13)).get(1).toString();
		GyungB = ((Vector) v.get(14)).get(1).toString();
		GyungN = ((Vector) v.get(15)).get(1).toString();
		Jeju = ((Vector) v.get(16)).get(1).toString();

// 이름 지역명
		ISeoul = ((Vector) v.get(0)).get(2).toString();
		IBusan = ((Vector) v.get(1)).get(2).toString();
		IDaegu = ((Vector) v.get(2)).get(2).toString();
		IInchon = ((Vector) v.get(3)).get(2).toString();
		IGwangju = ((Vector) v.get(4)).get(2).toString();
		IDaejion = ((Vector) v.get(5)).get(2).toString();
		IUlsan = ((Vector) v.get(6)).get(2).toString();
		ISejong = ((Vector) v.get(7)).get(2).toString();
		IGyunggi = ((Vector) v.get(8)).get(2).toString();
		IGangwon = ((Vector) v.get(9)).get(2).toString();
		IChungB = ((Vector) v.get(10)).get(2).toString();
		IChungN = ((Vector) v.get(11)).get(2).toString();
		IJunB = ((Vector) v.get(12)).get(2).toString();
		IJunN = ((Vector) v.get(13)).get(2).toString();
		IGyungB = ((Vector) v.get(14)).get(2).toString();
		IGyungN = ((Vector) v.get(15)).get(2).toString();
		IJeju = ((Vector) v.get(16)).get(2).toString();

	}
	
//---------------------------------------------------왼쪽메뉴판
    public static void leftMenu(JPanel contentPane, final Object classNameThis, Object classFrame){

    	
    	
		JButton btnHome = new JButton("Home");
		btnHome.setFocusPainted(false);
		btnHome.setBackground(new Color(5 , 35 , 130));
		btnHome.setForeground(new Color(209, 211, 219));
		btnHome.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 40));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home = new CoronaDamoaMain();
				home.setVisible(true);
				((Window) classNameThis).dispose();
			}
			
		});
		btnHome.setBounds(25, 10, 165, 65);
		contentPane.add(btnHome);
		
		JButton btnDistance = new JButton("사회적거리두기");
		btnDistance.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnDistance.setBackground(new Color(183 , 207 , 223));
		btnDistance.setForeground(new Color(5 , 35 , 130));
		
		btnDistance.addActionListener(new ActionListener() {
			//사회적 거리두기 열기
			public void actionPerformed(ActionEvent e) {
				
				CoronaDistance coronaDistance = CoronaDistance.getInstance();
				coronaDistance.setVisible(true);
				
				
				if(classNameThis==coronaDistance){
					return;
				}
				((Window) classNameThis).dispose();
				
				
			}
		});
		btnDistance.setBounds(25, 170, 140, 50);
		contentPane.add(btnDistance);
		
		
		
		
		JButton btnStatus = new JButton("코로나현재상황");
		btnStatus.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnStatus.setBackground(new Color(183 , 207 , 223));
		btnStatus.setForeground(new Color(5 , 35 , 130));
		
		
		
		btnStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CovidStatus news = null;
				try {
					news = CovidStatus.getInstance();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (ParserConfigurationException e1) {
					e1.printStackTrace();
				} catch (SAXException e1) {
					e1.printStackTrace();
				}
				if(classNameThis==news){
					return;
				}
				news.setVisible(true);
			   ((Window)classNameThis).dispose();
			}
		});
		btnStatus.setBounds(25, 270, 140, 50);
		contentPane.add(btnStatus);
		

		JButton btnVaccine = new JButton("예방접종통계");
		btnVaccine.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnVaccine.setBackground(new Color(183 , 207 , 223));
		btnVaccine.setForeground(new Color(5 , 35 , 130));
		btnVaccine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VaccineStatics imun = null;
				try {
					imun = VaccineStatics.getInstance();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(classNameThis==imun){
					return;
				}
				imun.setVisible(true);
			   ((Window)classNameThis).dispose();
			}
		});
		btnVaccine.setBounds(25, 370, 140, 50);
		contentPane.add(btnVaccine);
		
		
		
		
		JButton btnVaccine1 = new JButton("예방접종센터");
		btnVaccine1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnVaccine1.setBackground(new Color(183 , 207 , 223));
		btnVaccine1.setForeground(new Color(5 , 35 , 130));
		btnVaccine1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imunclinic = ImmunizationClinic.getInstance();
				if(classNameThis == imunclinic){
					return;
				}
				imunclinic.setVisible(true);
			   ((Window)classNameThis).dispose();
			}
		});
		btnVaccine1.setBounds(25, 470, 140, 50);
		contentPane.add(btnVaccine1);
		
		JButton btnHospital = new JButton("선별진료소");
		btnHospital.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnHospital.setBackground(new Color(183 , 207 , 223));
		btnHospital.setForeground(new Color(5 , 35 , 130));
		btnHospital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Screening imun = Screening.getInstance();
				if(classNameThis==imun){
					return;
				}
				imun.setVisible(true);
			   ((Window)classNameThis).dispose();
			}
		});
		btnHospital.setBounds(25, 570, 140, 50);
		contentPane.add(btnHospital);
		
		
			
		
		JButton btnNews = new JButton("코로나뉴스");
		btnNews.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnNews.setBackground(new Color(183 , 207 , 223));
		btnNews.setForeground(new Color(5 , 35 , 130));
		btnNews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CoronaNews news = CoronaNews.getInstance();
				if(classNameThis==news){
					return;
				}
				news.setVisible(true);
			   ((Window)classNameThis).dispose();
			}
		});
		btnNews.setBounds(25, 670, 140, 50);
		contentPane.add(btnNews);
}

    
	
    
//----------------------------- 오른쪽상단 메뉴판
    public static void topRightMenu(JPanel contentPane, final Object classNameThis, Object classFrame){

    	
    	
		JButton btnLogout = new JButton("로그아웃");
		btnLogout.setBackground(new Color(5 , 35 , 130));
		btnLogout.setForeground(new Color(209, 211, 219));
		btnLogout.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loginmain = LoginMain.getInstance();
//				imunclinic.dispose();
				
				((Window) classNameThis).dispose();
			}
			
		});
		btnLogout.setBounds(1145, 10, 90, 35);
		contentPane.add(btnLogout);
		
		
		JButton btnMemInfo = new JButton("회원정보");
		btnMemInfo.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnMemInfo.setBackground(new Color(183 , 207 , 223));
		btnMemInfo.setForeground(new Color(5 , 35 , 130));
		
		btnMemInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				meminfo = MemInfo.getInstance();
				meminfo.showDataById(id);
				meminfo.btnOnOff(false);
				if(classNameThis==meminfo){
					return;
				}
				meminfo.setVisible(true);
			}
		});
		btnMemInfo.setBounds(1240, 10, 90, 35);
		contentPane.add(btnMemInfo);
		

		JButton btnMemCovid19 = new JButton("개인 코로나 정보");
		btnMemCovid19.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnMemCovid19.setBackground(new Color(183 , 207 , 223));
		btnMemCovid19.setForeground(new Color(5 , 35 , 130));
		btnMemCovid19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CovidInfo imun = CovidInfo.getInstance();
				if(classNameThis==imun){
					return;
				}
				imun.setVisible(true);
			}
		});
		btnMemCovid19.setBounds(1145, 50, 185, 35);
		contentPane.add(btnMemCovid19);
		
}

	public static String getSido() {
		return sido;
	}

	public static String getSigungu() {
		return sigungu;
	}
    
    
}



