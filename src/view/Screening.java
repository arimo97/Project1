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
import model.ScreeningDao;

public class Screening extends JFrame implements ActionListener, MouseListener, KeyListener, FocusListener{
   
private static Screening screen = null;
   public static Screening getInstance() {
      if (screen != null)
         screen.dispose(); 
         screen = new Screening();
      return screen;
   }
   
   private JPanel contentPane;
   private JPanel innerPane;
   private JTable jTable;
   private JLabel lblNewLabel;
   private JScrollPane scroll;
   private JPanel searchPanel;
   private JButton btnSearch;
   private JTextField textfield_sido;
   
   String juso = CoronaDamoaMain.getSigungu();
   String sido = CoronaDamoaMain.getSido();
   
   TableColumnModel columnModel;
   
   Screening(){
      initComponent();
   }
   private void initComponent() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      setBounds(100, 100, 1400, 900);
      contentPane = new JPanel();
      
      contentPane.setBackground(new Color(255, 255, 255));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
		setLocationRelativeTo(null);
      
      //좌측 메뉴   , 우측상단 메뉴
      CoronaDamoaMain.leftMenu(contentPane, Screening.this, Screening.this);
      CoronaDamoaMain.topRightMenu(contentPane, Screening.this, Screening.this);
      
      
      
      jTable = new JTable();
      
      columnModel = jTable.getColumnModel();

      jTable.setModel(new DefaultTableModel(getDataList_first(), getColumns()) {
         public boolean isCellEditable(int row, int column) {
            return false;
         }
      });
      
      JLabel lblNewLabel = new JLabel("선별진료소");
      lblNewLabel.setForeground(Color.black);
	  lblNewLabel.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 40));
	  lblNewLabel.setBounds(600, 10, 400, 60);
      contentPane.add(lblNewLabel);
      
      
      
      scroll = new JScrollPane(jTable);
      contentPane.add(scroll);
      scroll.setBounds(200, 120, 1130, 700);
 //각 칼럼별 너비 조정!
      columnModel.getColumn(0).setPreferredWidth(70);
      columnModel.getColumn(1).setPreferredWidth(3);
      columnModel.getColumn(2).setPreferredWidth(5);
      columnModel.getColumn(3).setPreferredWidth(170);
      columnModel.getColumn(4).setPreferredWidth(370);
      
      jTable.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 14));
	  jTable.getTableHeader().setFont(new Font("한컴 윤고딕 230", Font.BOLD, 14));
      
      textfield_sido = new JTextField("시군구");
      textfield_sido.setSize(383, 30);
      textfield_sido.setLocation(200, 73);
      textfield_sido.setForeground(Color.LIGHT_GRAY);
      textfield_sido.setFont(new Font("굴림", Font.ITALIC, 12));
      contentPane.add(textfield_sido);
      
      btnSearch = new JButton("검색");
      btnSearch.setSize(135, 40);
      btnSearch.setLocation(640, 67);
      contentPane.add(btnSearch);
      
      btnSearch.addActionListener(this);
      textfield_sido.addMouseListener(this);
      textfield_sido.addFocusListener(this);
      textfield_sido.addKeyListener(this);
      
      setVisible(true);
   }
   private Vector getColumns() {
      Vector v = new  Vector();
      v.add("기준일");
      v.add("시도");
      v.add("시군구");
      v.add("의료기관명");
      v.add("주소");
//      v.add(rs.getString("기준일"));
//      v.add(rs.getString("시도"));
//      v.add(rs.getString("시군구"));
//      v.add(rs.getString("의료기관명"));
//      v.add(rs.getString("주소"));
      return v;
   }
   
   private Vector getDataList_first() {
      ScreeningDao sDao = new ScreeningDao();
      Vector v = sDao.get_Frist(sido, juso);
      return v;
   }
   
   private Vector getDataList() {
	      ScreeningDao sDao = new ScreeningDao();
	      Vector v = sDao.get(juso);
	      return v;
	   }
   
   private void refresh() {
      jTable.setModel(new DefaultTableModel(getDataList(), getColumns()) {
         public boolean isCellEditable(int row, int column) {
            return false;
         }
      });
      scroll.repaint();
      
      
      columnModel.getColumn(0).setPreferredWidth(70);
      columnModel.getColumn(1).setPreferredWidth(3);
      columnModel.getColumn(2).setPreferredWidth(5);
      columnModel.getColumn(3).setPreferredWidth(170);
      columnModel.getColumn(4).setPreferredWidth(370);
   }
   

   
   
   public static void main(String[] args) {
      new Screening();
   }
   /////////////////
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
			juso = textfield_sido.getText();
//			sigungu = textfield_sigungu.getText();
			refresh();
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource() == textfield_sido) {
			textfield_sido.setText("");
			textfield_sido.setFont(new Font("굴림", Font.PLAIN, 12));
			textfield_sido.setForeground(Color.black);
		}
	}

	@Override
	public void focusLost(FocusEvent e) 
	{
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
		juso = textfield_sido.getText();
//		sigungu = textfield_sigungu.getText();
		refresh();		
		}
	}
   
   
   
   

}