package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import view.MemInfo;

public class SearchDoroName extends JFrame implements ActionListener, MouseListener, KeyListener{

	private static MemInfo meminfo;
	static SearchDoroName sDoro;
	static SearchDoroDao sDao;
	public static String address_doro;
	public static String address_detail;
	public static SearchDoroVo sDoroVo;
	
	public static SearchDoroName getInstance(MemInfo get){
		if (sDoro != null)
			sDoro.dispose();
		sDoro = new SearchDoroName();
		meminfo = get;
		return sDoro;
	}

	static JPanel ContentPane;
	private JList jList;
	private JTextField doro;
	private JButton search;
	private JScrollPane scrollPane;
	private DefaultListModel<String> dlm;
	public SearchDoroName(){
	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 600, 500);
		ContentPane = new JPanel();
		getContentPane().add(ContentPane);
		ContentPane.setBackground(Color.WHITE);
		ContentPane.setLayout(null);
		
		doro = new JTextField();
		doro.setSize(398, 50);
		doro.setLocation(52, 76);
		ContentPane.add(doro);
		
		search = new JButton("검색");
		search.setSize(76, 50);
		search.setLocation(464, 75);
		ContentPane.add(search);
		
		dlm = new DefaultListModel<String>();
		jList = new JList(dlm);
		scrollPane = new JScrollPane(jList);
		scrollPane.setSize(488, 233);
		scrollPane.setLocation(52, 175);
		ContentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("도로명 주소 검색", SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel.setBounds(112, 16, 366, 50);
		ContentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("검색예) 반계로, 반계로 104, 반계로 104-9");
		lblNewLabel_1.setBounds(52, 136, 398, 15);
		ContentPane.add(lblNewLabel_1);
		
		search.addActionListener(this);
		jList.addMouseListener(this);
		doro.addKeyListener(this);
		

		setVisible(true);
	}
	

	private void getDataList(Vector v) {
		for (int i = 0; i < v.size(); i++) {
			String temp = "";
			for (int j = 0; j < ((Vector) v.get(i)).size(); j++) {
				temp += ((Vector) v.get(i)).get(j) + " ";
			}
			dlm.addElement(temp);
		}
		if (SearchDoroDao.errorcode == 1722) {
			JOptionPane.showMessageDialog(null, "형식을 다시 확인해주세요", "오류", JOptionPane.ERROR_MESSAGE);
			SearchDoroDao.errorcode = -1;
		}
	}

	public static void main(String[] args) {
		sDoro = new SearchDoroName();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == search) {
			sDao = new SearchDoroDao();
			String word = doro.getText();
			Vector v = sDao.doSearch(word);
			dlm.removeAllElements();
			getDataList(v);
			jList.setModel(dlm);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() > 1) {
			int r = jList.getSelectedIndex();
			sDoroVo = SearchDoroDao.eup_li.get(r);
			System.out.println( SearchDoroDao.eup_li.get(r));
			address_doro = (String) jList.getSelectedValue();
			meminfo.address_doro.setText(address_doro);
			this.dispose();
		}
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
		if(keyCode == KeyEvent.VK_ENTER) {
			sDao = new SearchDoroDao();
			String word = doro.getText();
			Vector v = sDao.doSearch(word);
			dlm.removeAllElements();
			getDataList(v);
			jList.setModel(dlm);
		}
	}
}
