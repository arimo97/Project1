package view;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.CovidInfoVo;
import model.CovidinfoDao;

public class CovidInfoUpdDel  extends  JFrame
	implements ActionListener, KeyListener   {

	// component 
	JPanel          	p;
	JTextField          tfId, tfNo,   tfHospital, tfdate,   tfIndate;
	JPasswordField      pfPwd;
//	JComboBox           cbJob1, cbJob2, cbJob3;
	JRadioButton        rb1, rb2, rb3, rbPositive, rbNegative;
	JTextArea           taSymptom;
	JButton             btnInsert, btnDelete, btnUpdate, btnList;
	JLabel 				lblno;
	private static CovidInfoUpdDel covidinfo = null;

	GridBagLayout       gb;
	GridBagConstraints  gbc;   // option 
	CovidInfoList covidInfoList;
	
	String no;
	
	public static CovidInfoUpdDel getInstance() {
		if (covidinfo != null)
			covidinfo.dispose();
		covidinfo = new CovidInfoUpdDel();
		return covidinfo;
	}
	
	//생성자목록
	//기본생성자
	public  CovidInfoUpdDel() {
		initComponent();
		
	}
//	 회원가입버튼 클릭 생성자
	public CovidInfoUpdDel(CovidInfoList covidInfoList) {
		this(); // 내클래스의 기본생성자 호출

		
		this.covidInfoList = covidInfoList;
		
		
	}
//	 covidInfoList에서 정보 가져오기
	public CovidInfoUpdDel(String id,String no ,CovidInfoList covidInfoList) {
		this();
		this.covidInfoList = covidInfoList;
		this.no = no;
		// 해당 id를 조회 - 화면에 출력
		this.tfId.setText(id);
		this.tfId.setEnabled(false);
//		검색실행		
		viewData(no);
		
		
		
		
	}

	
	
	// initComponent
	private void initComponent() {
		this.setTitle("회원정보(개인)");
		
		gb      =  new GridBagLayout();
		getContentPane().setLayout( gb );
		
		gbc          =  new GridBagConstraints();
		gbc.fill     =  GridBagConstraints.BOTH;
		gbc.weightx  = 1.0;
		gbc.weighty  = 1.0;

		
		// 아이디
		JLabel  lblid   =  new  JLabel("아이디");
		tfId  	        =  new  JTextField(20);
		gbAdd( lblid, 0, 0, 1, 1);
		gbAdd( tfId,  1, 0, 3, 1);
		


		// 백신여부
		JLabel  lblVaccine		=  new  JLabel("백신여부");
		
		this.rb1         =  new  JRadioButton("1차완료", false);   
		this.rb2       =  new  JRadioButton("2차완료", false);   
		this.rb3       =  new  JRadioButton("없음", false);   
		
		/// 선택 그룹 지정 
		ButtonGroup   group  = new  ButtonGroup();
		group.add( rb1 );
		group.add( rb2 );
		group.add( rb3 );
		
		// 패널 사용
		JPanel      pVaccine  =  new JPanel( new FlowLayout(FlowLayout.LEFT) );
		pVaccine.add( rb1 );
		pVaccine.add( rb2 );
		pVaccine.add( rb3 );
		
		gbAdd( lblVaccine, 0, 2, 1, 1);
		gbAdd( pVaccine, 1, 2, 3, 1);
		
		
			
		
		// 검사날짜
		JLabel  lbldate   =  new  JLabel("검사날짜(20211022)");
		tfdate           =  new  JTextField(20);
		gbAdd( lbldate, 0, 3,  1, 1);
		gbAdd( tfdate,  1, 3, 3, 1);

		// 검사한병원
		JLabel  lblName  =  new  JLabel("검사한 병원");
		tfHospital           =  new  JTextField(20);
		gbAdd( lblName,		0, 4, 1, 1);
		gbAdd( tfHospital,  1, 4, 3, 1);
		
		
		// 검사결과
		JLabel  lblResult   =  new  JLabel("검사결과");
		
		this.rbPositive         =  new  JRadioButton("양성", false);   
		this.rbNegative       =  new  JRadioButton("음성", false);   
		
		/// 선택 그룹 지정 
		ButtonGroup   group2  = new  ButtonGroup();
		group2.add( rbNegative );
		group2.add( rbPositive );
		
		// 패널 사용
		JPanel      pResult  =  new JPanel( new FlowLayout(FlowLayout.LEFT) );
		pResult.add( rbPositive );
		pResult.add( rbNegative );
		
		gbAdd( lblResult, 0, 5, 1, 1);
		gbAdd( pResult ,  1, 5, 3, 1);
		
		// 자기소개
		JLabel       lblIntro  =  new  JLabel("증상기록");
		taSymptom                =  new  JTextArea(5, 20); // 행 열
		JScrollPane   pane     =  new JScrollPane( taSymptom );
		gbAdd( lblIntro, 0, 6, 1, 1);
		gbAdd( pane   ,  1, 6, 3, 1);
		
		
		
		// 버튼들
		JPanel   pButton  =  new  JPanel();
		btnUpdate         =  new  JButton("수정"); 
		btnDelete         =  new  JButton("삭제"); 
		btnInsert         =  new  JButton("저장창"); 
		
		pButton.add( this.btnUpdate );
		pButton.add( this.btnDelete );
		pButton.add( this.btnInsert );
//		pButton.add( this.btnList );
		gbAdd(pButton,0, 11, 4, 1);
		
		// 이벤트 연결 - 기능추가\
		this.btnInsert.addActionListener( this );
		this.btnUpdate.addActionListener( this );
		this.btnDelete.addActionListener( this );
		
		// Enter 키 연결
		this.tfId.addKeyListener(this);
		
				
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize( 350, 700 );
		this.setVisible(true);
	}

	private void gbAdd(JComponent c, int x, int y, int w, int h) {
		gbc.gridx       =  x;  
		gbc.gridy       =  y;
		gbc.gridwidth   =  w; 
		gbc.gridheight  =  h;
		gb.setConstraints(c, gbc);
		gbc.insets      =  new Insets(2, 2, 2, 2);
		getContentPane().add(c, gbc);
		
	}
	
	public static void main(String[] args) {
		new CovidInfoUpdDel();
	}
	
	//입력 저장
	private CovidInfoVo getViewData() {
		
		String   userid    =  this.tfId.getText();
		String   recordNo    =  this.no;
		String   vaccine        =  "";
		if(  rb1.isSelected()     )   vaccine = "1차완료";
		if(  rb2.isSelected()   )   vaccine = "2차완료";
		if(  rb3.isSelected()   )   vaccine = "없음";
		String   date    =  this.tfdate.getText();
		String   hospitalN  =  this.tfHospital.getText();
		String   result        =  "";
		if(  rbPositive.isSelected()     )   result = "양성";
		if(  rbNegative.isSelected()   )   result = "음성";
		String   symptom      =  this.taSymptom.getText();
		
		
		
		CovidInfoVo   covidinfo    = new  CovidInfoVo(userid, recordNo, vaccine, date, hospitalN,result,symptom);
		return   covidinfo;
	}

	// 추가
	private void insertUser() {
		
		CovidinfoDao  uDao      =  new  CovidinfoDao();
		CovidInfoVo   covidinfo      =  getViewData();
		String   result    =  uDao.insertUser( covidinfo );
		
//		새로고침
		JOptionPane.showMessageDialog(null, 
				result,
				"추가",
				JOptionPane.INFORMATION_MESSAGE
				);		
		//창닫음
		this.dispose();
	}
	
//	 수정
	private void updateUser() {
		

		CovidinfoDao  uDao   =  new  CovidinfoDao();
		CovidInfoVo   user   =  getViewData();
		String  	 result	 = 	uDao.updateUser( user );
		
//		새로고침
		covidInfoList.jTableRefresh();
		
		JOptionPane.showMessageDialog(null, 
				result,
				"수정",
				JOptionPane.INFORMATION_MESSAGE
				);		
		//창닫음
		this.dispose();
	}

//	 삭제
	private void deleteUser() {
		
		CovidinfoDao  uDao   =  new  CovidinfoDao();
		CovidInfoVo   user   =  getViewData();
		String   result =  uDao.deleteUser( user );
//		새로고침
		covidInfoList.jTableRefresh();
		JOptionPane.showMessageDialog(null, 
				result,
				"삭제",
				JOptionPane.INFORMATION_MESSAGE
				);		
		//창닫음
		this.dispose();
		
	}
	
	// 조회된 UserVo  의 data를  JTextField 등에 출력
	// data 가져오기
	
	private void setViewData(CovidInfoVo covidinfo) {
		String   id    			=  covidinfo.getId();
		String   no    			=  covidinfo.getNum();
		String   vaccine  		=  covidinfo.getVaccine();				
		String   test_date      =  covidinfo.getTest_date();
		String   test_hospital  =  covidinfo.getTest_hospital();
		String   test_result   	=  covidinfo.getTest_result();
		String   symptom   		=  covidinfo.getSymptom();
		
		this.tfId.setText( id );
		if(  vaccine.equals("1차완료")  )
			this.rb1.setSelected(true);
		if(  vaccine.equals( "2차완료")  )
			this.rb2.setSelected(true);
		if(  vaccine.equals( "없음")  )
			this.rb3.setSelected(true);
		this.tfdate.setText( test_date );
		this.tfHospital.setText( test_hospital );
		if(  test_result.equals("양성")  )
			this.rbPositive.setSelected(true);
		if(  test_result.equals( "음성")  )
			this.rbNegative.setSelected(true);
		this.taSymptom.setText( symptom );
		
		
	}
	
	// 조회실패시 화면 초기화 
	private void clearViewData() {
		this.tfId.setText("");
//		this.tfNo.setText("");
		this.rb1.setSelected(false);
		this.rb2.setSelected(false);
		this.rb3.setSelected(false);
		this.tfdate.setText("");
		this.tfHospital.setText("");
		this.rbPositive.setSelected(false);
		this.rbNegative.setSelected(false);
		this.taSymptom.setText("");
	}
	

	//----------------------------------------------------
	// 이벤트 처리
	@Override
	public void actionPerformed(ActionEvent e) {
		switch( e.getActionCommand()  ) {
		case  "저장창":
			CovidInfo cif = new CovidInfo();
			break;
		case  "수정":  
			updateUser();
			clearViewData();
			break;
		case  "삭제":  
			deleteUser();
			clearViewData();
		
			break;
			
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	// Enter 키를 눌렀다 땔때
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	//  회원조회(개인)  getUser("admin")
	public void viewData(String no) {
		System.out.println("검색실행");
		CovidinfoDao uDao   = new CovidinfoDao(); 
	    String  userid = this.tfId.getText();
	    String  recordno = no;
	    CovidInfoVo  user   = uDao.getUser(userid, recordno);
	    if ( user != null ) {
	    	setViewData( user );
	    	
	    	
	    	
	    } else {
	    	JOptionPane.showMessageDialog(null, 
					"조회된 자료가 없습니다",
					"자료없습",
					JOptionPane.OK_OPTION
					);
	    	// 화면 초기화
	    	clearViewData();
	    }
	
	}
	

}








