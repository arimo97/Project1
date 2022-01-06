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
import model.ImmunizationClinicNewsDao;

public class ImmunizationClinic extends JFrame implements ActionListener, MouseListener, KeyListener, FocusListener {

	private JPanel contentPane;
	private JPanel innerPane;
	private JTable jTable;
	private JScrollPane scroll;
	private JPanel searchPanel;
//	private JTextField textfield_sido;
	private JTextField textfield_sigungu;
	private JButton btnSearch;
	TableColumnModel columnModel;
	private static ImmunizationClinic immun;

	private String sigungu = CoronaDamoaMain.getSigungu();

	public static ImmunizationClinic getInstance() {
		if (immun != null)
			immun.dispose();
		immun = new ImmunizationClinic();
		return immun;
	}

	public ImmunizationClinic() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1400, 900);
		contentPane = new JPanel();

		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		// 좌측 메뉴 , 우측상단 메뉴
		CoronaDamoaMain.leftMenu(contentPane, ImmunizationClinic.this, ImmunizationClinic.this);
		CoronaDamoaMain.topRightMenu(contentPane, ImmunizationClinic.this, ImmunizationClinic.this);

		jTable = new JTable();
//		MyRenderer myRenderer = new MyRenderer();

		columnModel = jTable.getColumnModel();

		jTable.setModel(new DefaultTableModel(getDataList_first(), getColumns()) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
//		jTable.setDefaultRenderer(Object.class, myRenderer);

		JLabel lblNewLabel = new JLabel("예방접종센터");
		lblNewLabel.setForeground(Color.black);
		lblNewLabel.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 40));
		lblNewLabel.setBounds(600, 10, 260, 60);
		contentPane.add(lblNewLabel);

		scroll = new JScrollPane(jTable);
		contentPane.add(scroll);
		scroll.setBounds(200, 120, 1130, 700);
		columnModel.getColumn(0).setPreferredWidth(220);
		columnModel.getColumn(2).setPreferredWidth(180);
		columnModel.getColumn(3).setPreferredWidth(5);
		columnModel.getColumn(4).setPreferredWidth(5);
		columnModel.getColumn(5).setPreferredWidth(10);
		columnModel.getColumn(6).setPreferredWidth(45);
		
		jTable.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 14));
		jTable.getTableHeader().setFont(new Font("한컴 윤고딕 230", Font.BOLD, 14));

//		textfield_sido = new JTextField("시도");
//		textfield_sido.setForeground(Color.LIGHT_GRAY);
//		textfield_sido.setFont(new Font("굴림", Font.ITALIC, 12));
//		textfield_sido.setBounds(217, 63, 160, 30);
//		contentPane.add(textfield_sido);

		textfield_sigungu = new JTextField("시군구");
		textfield_sigungu.setSize(383, 30);
		textfield_sigungu.setLocation(200, 73);
		textfield_sigungu.setForeground(Color.LIGHT_GRAY);
		textfield_sigungu.setFont(new Font("굴림", Font.ITALIC, 12));
		contentPane.add(textfield_sigungu);

		btnSearch = new JButton("검색");
		btnSearch.setSize(135, 40);
		btnSearch.setLocation(640, 67);
		contentPane.add(btnSearch);

		btnSearch.addActionListener(this);
//		btnSearch.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
////				sido = textfield_sido.getText();
//				sigungu = textfield_sigungu.getText();
//				refresh();
//
//			}
//		});
//		textfield_sido.addMouseListener(this);
//		textfield_sido.addFocusListener(this);
//		textfield_sido.addKeyListener(this);
		textfield_sigungu.addMouseListener(this);
		textfield_sigungu.addFocusListener(this);
		textfield_sigungu.addKeyListener(this);

		setVisible(true);

	}

	private Vector getColumns() {
		Vector cols = new Vector();
		cols.add("센터 이름");
		cols.add("기관 이름");
		cols.add("주소");
		cols.add("센터 분류");
		cols.add("운영 기관");
		cols.add("전화 번호");
		cols.add("자료 생성 시간");
		/*
		 * v.add(tmp.get("centerName")); v.add(tmp.get("facilityName"));
		 * v.add(tmp.get("address")); v.add(tmp.get("centerType"));
		 * v.add(tmp.get("createdAt")); v.add(tmp.get("org"));
		 * v.add(tmp.get("phoneNumber"));
		 */
		return cols;
	}

	private Vector getDataList() {
		ImmunizationClinicNewsDao jDao = new ImmunizationClinicNewsDao();
		Vector v = jDao.VaccinationCenterDao( sigungu);
		return v;
	}
	
	private Vector getDataList_first() {
		ImmunizationClinicNewsDao jDao = new ImmunizationClinicNewsDao();
		Vector v = jDao.VaccinationCenterDao_sido(CoronaDamoaMain.getSido(),sigungu);
		return v;
	}

	private void refresh() {
		jTable.setModel(new DefaultTableModel(getDataList(), getColumns()) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		scroll.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		sido = textfield_sido.getText();
//		textfield_sido.setText("시도");
//		textfield_sido.setForeground(Color.LIGHT_GRAY);
//		textfield_sido.setFont(new Font("굴림", Font.ITALIC, 12));
		sigungu = textfield_sigungu.getText();
		textfield_sigungu.setText("시군구");
		textfield_sigungu.setForeground(Color.LIGHT_GRAY);
		textfield_sigungu.setFont(new Font("굴림", Font.ITALIC, 12));
		refresh();
		columnModel.getColumn(0).setPreferredWidth(220);
		columnModel.getColumn(2).setPreferredWidth(180);
		columnModel.getColumn(3).setPreferredWidth(5);
		columnModel.getColumn(4).setPreferredWidth(5);
		columnModel.getColumn(5).setPreferredWidth(10);
		columnModel.getColumn(6).setPreferredWidth(45);

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
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_ENTER) {
//			sido = textfield_sido.getText();
			sigungu = textfield_sigungu.getText();
			textfield_sigungu.setText("시군구");
			textfield_sigungu.setForeground(Color.LIGHT_GRAY);
			textfield_sigungu.setFont(new Font("굴림", Font.ITALIC, 12));
			refresh();
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
//		if (e.getSource() == textfield_sido) {
//			textfield_sido.setText("");
//			textfield_sido.setFont(new Font("굴림", Font.PLAIN, 12));
//			textfield_sido.setForeground(Color.black);
//		}
		if (e.getSource() == textfield_sigungu) {
			textfield_sigungu.setText("");
			textfield_sigungu.setFont(new Font("굴림", Font.PLAIN, 12));
			textfield_sigungu.setForeground(Color.black);
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
	}
	
	public static void main(String[] args) {
		new ImmunizationClinic();
	}
}
