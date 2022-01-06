package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import main.CoronaDamoaMain;
import model.MyRenderer;
import model.VaccineStaticsDao;

public class VaccineStatics extends JFrame implements ActionListener, MouseListener, KeyListener, FocusListener {

	private JPanel contentPane;
	private JPanel innerPane;
	private JTable jTable;
	private JScrollPane scroll;
	private JPanel searchPanel;
	private JTextField textfield_sido;
	private JTextField textfield_sigungu;
	private JButton btnSearch;

	private static VaccineStatics immun = null;

	private String sido = "";
	private String sigungu = "";

	public static VaccineStatics getInstance() throws Exception {
		if (immun != null)
			immun.dispose();
		immun = new VaccineStatics();
		return immun;
	}

	public VaccineStatics() throws Exception {
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
		CoronaDamoaMain.leftMenu(contentPane, VaccineStatics.this, VaccineStatics.this);
		CoronaDamoaMain.topRightMenu(contentPane, VaccineStatics.this, VaccineStatics.this);
		
		
		
		jTable = new JTable();
		
		TableColumnModel columnModel = jTable.getColumnModel();

		jTable.setModel(new DefaultTableModel(getDataList(), getColumns()) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		
		MyRenderer myRenderer = new MyRenderer();
		jTable.setDefaultRenderer(Object.class, myRenderer);
		
		JLabel lblNewLabel = new JLabel("예방접종통계");
		lblNewLabel.setForeground(Color.black);
		lblNewLabel.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 40));
		lblNewLabel.setBounds(600, 10, 260, 60);
		contentPane.add(lblNewLabel);
		
		
		
		scroll = new JScrollPane(jTable);
		contentPane.add(scroll);
		scroll.setBounds(200, 120, 1130, 700);
		columnModel.getColumn(0).setPreferredWidth(20);
		columnModel.getColumn(1).setPreferredWidth(20);
		columnModel.getColumn(2).setPreferredWidth(20);
		columnModel.getColumn(3).setPreferredWidth(20);
		columnModel.getColumn(4).setPreferredWidth(20);
		
		jTable.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 14));
		jTable.getTableHeader().setFont(new Font("한컴 윤고딕 230", Font.BOLD, 14));
//		textfield_sido = new JTextField("시도");
//		textfield_sido.setForeground(Color.LIGHT_GRAY);
//		textfield_sido.setFont(new Font("굴림", Font.ITALIC, 12));
//		textfield_sido.setBounds(217, 63, 160, 30);
//		contentPane.add(textfield_sido);
//		
//		textfield_sigungu = new JTextField("시군구");
//		textfield_sigungu.setSize(160, 30);
//		textfield_sigungu.setLocation(423, 63);
//		textfield_sigungu.setForeground(Color.LIGHT_GRAY);
//		textfield_sigungu.setFont(new Font("굴림", Font.ITALIC, 12));
//		contentPane.add(textfield_sigungu);
//		
//		btnSearch = new JButton("검색");
//		btnSearch.setSize(135, 40);
//		btnSearch.setLocation(640, 57);
//		contentPane.add(btnSearch);
		
//		btnSearch.addActionListener(this);
//		btnSearch.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				sido = textfield_sido.getText();
//				sigungu = textfield_sigungu.getText();
//				refresh();
//				
//			
//			}
//		});
//		textfield_sido.addMouseListener(this);
//		textfield_sido.addFocusListener(this);
//		textfield_sido.addKeyListener(this);
//		textfield_sigungu.addMouseListener(this);
//		textfield_sigungu.addFocusListener(this);
//		textfield_sigungu.addKeyListener(this);
//		
		setVisible(true);

	}

	private Vector getColumns() {
		Vector cols = new Vector();
		cols.add("시도");
		cols.add("당일1차 접종통계");
		cols.add("당일2차 접종통계");
		cols.add("1차 접종 누적 통계");
		cols.add("2차 접종 누적 통계");
		cols.add("기준일");
		/*
		 * v.add(tmp.get("centerName")); v.add(tmp.get("facilityName"));
		 * v.add(tmp.get("address")); v.add(tmp.get("centerType"));
		 * v.add(tmp.get("createdAt")); v.add(tmp.get("org"));
		 * v.add(tmp.get("phoneNumber"));
		 */
		return cols;
	}

	private Vector getDataList() throws Exception {
		VaccineStaticsDao jDao = new VaccineStaticsDao();
		Vector v = jDao.VaccineDao();
		return v;
	}
	
	private void refresh() throws Exception {
		jTable.setModel(new DefaultTableModel(getDataList(), getColumns()) {
			public boolean isCellEditable() {
				return false;
			}
		});
		scroll.repaint();
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		sido = textfield_sido.getText();
//		sigungu = textfield_sigungu.getText();
//		textfield_sido.setText("시도");
//		textfield_sigungu.setText("시군구");
//		textfield_sido.setForeground(Color.LIGHT_GRAY);
//		textfield_sigungu.setForeground(Color.LIGHT_GRAY);
//		textfield_sido.setFont(new Font("굴림", Font.ITALIC, 12));
//		textfield_sigungu.setFont(new Font("굴림", Font.ITALIC, 12));
//		
//	}


	public static void main(String[] args) throws Exception {
		new VaccineStatics();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
//		int keyCode = e.getKeyCode();
//		if (keyCode == KeyEvent.VK_ENTER) {
//			sido = textfield_sido.getText();
//			sigungu = textfield_sigungu.getText();
//			refresh();
//		}
	}

	@Override
	public void focusGained(FocusEvent e) {
//		if (e.getSource() == textfield_sido) {
//			textfield_sido.setText("");
//			textfield_sido.setFont(new Font("굴림", Font.PLAIN, 12));
//			textfield_sido.setForeground(Color.black);
//		}
//		if (e.getSource() == textfield_sigungu) {
//			textfield_sigungu.setText("");
//			textfield_sigungu.setFont(new Font("굴림", Font.PLAIN, 12));
//			textfield_sigungu.setForeground(Color.black);
//		}
	}

	@Override
	public void focusLost(FocusEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
