package view;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import main.CoronaDamoaMain;
import model.MyRenderer;
import model.XMLDaoCovidStatusDao;

public class CovidStatus extends JFrame {
	JPanel contentPane;
	JTable jTable;
	JScrollPane scroll;

	DefaultTableModel dtm;
	private static CovidStatus immun = null;

	Vector v; // data list
	Vector cols; // list 의 제목들
	
	public static CovidStatus getInstance() throws IOException, ParserConfigurationException, SAXException {
		if (immun != null)
			immun.dispose(); 
		immun = new CovidStatus();
		return immun;
	}

	public CovidStatus() throws IOException, ParserConfigurationException, SAXException {
		initComponent();
	}

	private void initComponent() throws IOException, ParserConfigurationException, SAXException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1400, 900);
		contentPane = new JPanel();
		
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		//좌측 메뉴	, 우측상단 메뉴
		CoronaDamoaMain.leftMenu(contentPane, CovidStatus.this, CovidStatus.this);
		CoronaDamoaMain.topRightMenu(contentPane, CovidStatus.this, CovidStatus.this);
		
		jTable = new JTable();
		
		jTable.setModel(new DefaultTableModel(getDataList(), getColumns()) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		
		
		MyRenderer myRenderer = new MyRenderer();
		jTable.setDefaultRenderer(Object.class, myRenderer);
		
		
		
		JLabel lblNewLabel = new JLabel("코로나현재상황");
		lblNewLabel.setForeground(Color.black);
		lblNewLabel.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 40));
		lblNewLabel.setBounds(600, 10, 400, 60);
		contentPane.add(lblNewLabel);
		
		scroll = new JScrollPane(jTable);
		contentPane.add(scroll);
		scroll.setBounds(200, 120, 1130, 700);
		
		 //각 칼럼별 너비 조정!
		 TableColumnModel columnModel = jTable.getColumnModel();
	      columnModel.getColumn(0).setPreferredWidth(80);
	      columnModel.getColumn(1).setPreferredWidth(80);
	      columnModel.getColumn(2).setPreferredWidth(80);
	      columnModel.getColumn(3).setPreferredWidth(150);
	      columnModel.getColumn(4).setPreferredWidth(150);
	      columnModel.getColumn(5).setPreferredWidth(150);
	      columnModel.getColumn(6).setPreferredWidth(150);
	      columnModel.getColumn(7).setPreferredWidth(250);
//	      columnModel.getColumn(8).setPreferredWidth(200);

		jTable.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 14));
		jTable.getTableHeader().setFont(new Font("한컴 윤고딕 230", Font.BOLD, 14));
		

		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	private Vector getColumns() {
		Vector  cols = new Vector();
		cols.add("지역명");
		cols.add("확진자 수");
		cols.add("사망자 수");
		cols.add("지역 발생 수");
		cols.add("격리중 환자 수");
		cols.add("격리 해제 수");
		cols.add("10만 명당 발생률");
		cols.add("기준일");
		return cols;
	}

	private Vector getDataList() throws IOException, ParserConfigurationException, SAXException {
		XMLDaoCovidStatusDao xDao = new XMLDaoCovidStatusDao();
		Vector v = xDao.ConfirmedCasesDao();
		return v;
	}

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		new CovidStatus();
	}
}
