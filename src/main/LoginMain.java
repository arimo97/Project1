package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.LoginDao;
import view.MemInfo;

public class LoginMain extends JFrame implements ActionListener, KeyListener{
	
	static LoginMain loginmain;
	static CoronaDamoaMain cdmain;
	static MemInfo meminfo;
	
	LoginDao lDao;
	private String id;
	private static String pw;
	
	public static LoginMain getInstance() {
		if (loginmain != null)
			loginmain.dispose();
		loginmain = new LoginMain();
		return loginmain;
	}
	
	JTextField idtf;
	JPasswordField pwtf;
	JButton join;
	JButton login;
	JLabel l_id;
	JLabel l_pw;
	
	
	LoginMain(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(450, 350);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		initComponent();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void initComponent() {
		l_id = new JLabel("아이디", SwingConstants.CENTER);
		l_id.setSize(60, 35);
		l_id.setLocation(10, 85);
		getContentPane().add(l_id);
		l_pw = new JLabel("비밀번호", SwingConstants.CENTER);
		l_pw.setSize(60, 35);
		l_pw.setLocation(10, 135);
		getContentPane().add(l_pw);
		
		idtf = new JTextField();
		idtf.setSize(300, 35);
		idtf.setLocation(90, 85);
		pwtf = new JPasswordField();
		pwtf.setSize(300, 35);
		pwtf.setLocation(90, 135);
		
		getContentPane().add(idtf, BorderLayout.NORTH);
		getContentPane().add(pwtf);
		
		join = new JButton("회원 가입");
		join.setSize(100, 50);
		join.setLocation(270, 230);
		login = new JButton("로그인");
		login.setLocation(70, 230);
		login.setSize(100, 50);
		getContentPane().add(join);
		getContentPane().add(login);
		
		join.addActionListener(this);
		login.addActionListener(this);
		idtf.addKeyListener(this);
		pwtf.addKeyListener(this);
	}

	private void logininit() {
		loginPorc();
		if (lDao.result == 1) {
			JOptionPane.showMessageDialog(null, id + "님 환영합니다!", "성공", JOptionPane.INFORMATION_MESSAGE);
			cdmain = CoronaDamoaMain.getInstance(loginmain);
			loginmain.dispose();
			pw = pwtf.getText(); 
		} else if (lDao.result == 0) {
			JOptionPane.showMessageDialog(null, "일치하는 정보가 없습니다. ID, PASSWD를 확인해 주세요", "오류", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "알 수 없는 오류 발생", "오류", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void loginPorc() {
		id = this.idtf.getText();
		pw = this.pwtf.getText();
		lDao = new LoginDao();
		lDao.loginProc(id, pw);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == join) {
			meminfo = MemInfo.getInstance();
			meminfo.btnOnOff(true);
		}
		if (e.getSource() == login) {
			logininit();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			logininit();
		}
	}
	

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public static String getPw() {
		return pw;
	}
	public static void main(String[] args) {
		loginmain = new LoginMain();
	}


}
