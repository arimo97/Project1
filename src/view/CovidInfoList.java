package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import main.CoronaDamoaMain;
import model.CovidinfoDao;

public class CovidInfoList  extends  JFrame
	implements ActionListener, MouseListener, KeyListener {

	// Component  목록
	 JButton             btnInsert,  btnRefresh,  btnToExcel, btnSearch ;
	 JPanel              topPane;
	 JTable              jTable;    // 데이터 표시
	 JScrollPane         pane;
	 JTextField			tfId; // id 검색 용
	 static CovidInfoList covidinfo = null;

	DefaultTableModel   dtm;
	static String id = ""; // id 검색 용
	

	
	// Vector : ArrayList  thread safe 버전
	 Vector              v;      // data list     
	 Vector              cols;   // list 의 제목들
	
	static CovidInfoList ulist = null; //변수
	
	// data  출력
	//  oracle resultset -> vector -> defaultmodel -> jtable
	
	CovidInfoUpdDel  uProc = null;
	
	// 생성자 : class를 new 할때 실행되는 명령들
	public CovidInfoList() {
		initComponent();
	}
	
	// initComponent()
	private void initComponent() {
		this.setTitle("개인 코로나 정보 기록");
		
		jTable  = new JTable();
		//jTable 에 option 
		
		jTable.setModel(
			new DefaultTableModel( getDataList(), getColumns() ) {
				public boolean  isCellEditable(int row, int column) {
					return false;
					
				}
			}
		);
		pane    =   new JScrollPane( jTable );
		this.add(pane);
		topPane     =   new JPanel();
		this.add( topPane, BorderLayout.NORTH);
		
		this.jTable.addMouseListener(this);
		
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600, 500);
		this.setVisible(true);		
	}
	


	
	
	
	// jTable에 출력할 자료검색
			private Vector getDataList() {
			
				System.out.println(id);

				CovidinfoDao   uDao 	= new CovidinfoDao();
				Vector    v    = uDao.getMemList(CoronaDamoaMain.getId()); //		Vector    v    = uDao.getMemList(id); id 검색 확인용

				
				return  v;
			}
	

	// header 지정 - 제목
	// jtable 제목줄 header 지정
	private Vector getColumns() {
		Vector  cols = new Vector();
		cols.add("아이디");
		cols.add("백신여부");
		cols.add("검사날짜");
		cols.add("검사한병원");
		cols.add("검사결과");
		cols.add("증상기록");
		return  cols;
	}


	

		// main ()
		public static void main(String[] args) {
			CovidInfoList cil = new CovidInfoList();



		}	
	// 이벤트 목록들
	//  버튼들의 기능연결 클릭될때
	@Override
	public void actionPerformed(ActionEvent e) {
	}

	public void jTableRefresh() {
		
		jTable.setModel(
		new DefaultTableModel( getDataList(), getColumns() ) {
			public boolean  isCellEditable(int row, int column) {
				return false;
				
				}
			}
		);
		jTable.repaint();   
		
	}

	private DefaultTableModel initTable() {
		cols  =  getColumns();
		v     =  getDataList();
		DefaultTableModel  dtm = new DefaultTableModel( v, cols );
		return  dtm;
	}

	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int       r      =  jTable.getSelectedRow();
		int       c      =  jTable.getSelectedColumn();
		String    no     =  (String) CovidinfoDao.num.get(r);  // 클릭한 no
		String    id     =  (String) jTable.getValueAt(r,  0);  // 클릭한 userid
		if( uProc != null )
			uProc.dispose();
		uProc  = new CovidInfoUpdDel(id, no, this);
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
	

	}


}
