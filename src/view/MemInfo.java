package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import main.CoronaDamoaMain;
import main.LoginMain;
import model.MeminfoDao;
import model.MeminfoVo;
import model.SearchDoroName;
import model.SearchDoroVo;

public class MemInfo extends JFrame implements FocusListener, ActionListener, KeyListener {

	private static MemInfo meminfo;
	private static MeminfoVo meminfoVo;
	private static MeminfoDao mDao;
	private static SearchDoroName sDoro;
	private static SearchDoroVo sDoroVo;
	static String id;
	String pw;
	static String address;

	public static MemInfo getInstance() {
		if (meminfo != null)
			meminfo.dispose();
		meminfo = new MemInfo();
		return meminfo;
	}

	public static void meminfo_dispose() {
		meminfo.dispose();
	}

	private JPanel contentPane;
	private JPanel leftPane;
	private JPanel rightPane;

	private JLabel l_id;
	private JLabel l_pw;
	private JLabel l_name;
	private JLabel l_birth;
	private JLabel l_gender;
	private JLabel l_tel;
	private JLabel l_email;
	private JLabel l_address_doro;
	private JLabel l_address_detail;

	private JTextField idtf;
	private JPasswordField pwtf;
	private JTextField name;
	private JTextField birth;
	private JRadioButton male;
	private JRadioButton female;
	private JTextField tel;
	private JTextField email;
	public JTextField address_doro;
	private JTextField address_detail;

	private JButton search;

	private JButton join;
	private JButton update;
	private JButton delete;

	GridBagLayout gb;
	GridBagConstraints gbc;

	public MemInfo() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 450, 650);

		gb = new GridBagLayout();
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(gb);
		setLocationRelativeTo(null);

		l_id = new JLabel("아이디", SwingConstants.CENTER);
		idtf = new JTextField();
		gbAdd(l_id, 0, 0, 1, 1);
		gbAdd(idtf, 1, 0, 3, 1);

		l_pw = new JLabel("패스워드", SwingConstants.CENTER);
		pwtf = new JPasswordField();
		gbAdd(l_pw, 0, 1, 1, 1);
		gbAdd(pwtf, 1, 1, 3, 1);

		l_name = new JLabel("이름", SwingConstants.CENTER);
		name = new JTextField();
		gbAdd(l_name, 0, 2, 1, 1);
		gbAdd(name, 1, 2, 3, 1);

		l_birth = new JLabel("생년월일", SwingConstants.CENTER);
		birth = new JTextField("생년월일 6자리");
		birth.setForeground(Color.LIGHT_GRAY);
		birth.setFont(new Font("굴림", Font.ITALIC, 12));
		gbAdd(l_birth, 0, 3, 1, 1);
		gbAdd(birth, 1, 3, 3, 1);

		JPanel genderPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
		genderPane.setBackground(Color.WHITE);
		l_gender = new JLabel("성별", SwingConstants.CENTER);
		male = new JRadioButton("남성");
		male.setBackground(Color.WHITE);
		female = new JRadioButton("여성");
		female.setBackground(Color.WHITE);
		genderPane.add(male);
		genderPane.add(female);
		gbAdd(l_gender, 0, 4, 1, 1);
		gbAdd(genderPane, 1, 4, 3, 1);

		l_tel = new JLabel("TEL", SwingConstants.CENTER);
		tel = new JTextField();
		gbAdd(l_tel, 0, 5, 1, 1);
		gbAdd(tel, 1, 5, 3, 1);

		l_email = new JLabel("EMAIL", SwingConstants.CENTER);
		email = new JTextField();
		gbAdd(l_email, 0, 6, 1, 1);
		gbAdd(email, 1, 6, 3, 1);

		JPanel DoroPane = new JPanel(new FlowLayout());
		l_address_doro = new JLabel("도로명 주소", SwingConstants.CENTER);
		address_doro = new JTextField("", SwingConstants.CENTER);
		address_doro.setBackground(Color.WHITE);
		address_doro.setPreferredSize(new Dimension(250, 53));
		address_doro.setEditable(false);
		search = new JButton("검색");
		DoroPane.add(address_doro);
		DoroPane.add(search);
		DoroPane.setBackground(Color.white);
		gbAdd(l_address_doro, 0, 7, 1, 1);
		gbAdd(DoroPane, 1, 7, 1, 1);

		DoroPane.add(address_doro);
		DoroPane.add(search);
		gbAdd(l_address_doro, 0, 7, 1, 1);
		gbAdd(DoroPane, 1, 7, 3, 1);

		l_address_detail = new JLabel("상세주소", SwingConstants.CENTER);
		address_detail = new JTextField("상세 주소 입력");
		address_detail.setForeground(Color.LIGHT_GRAY);
		address_detail.setFont(new Font("굴림", Font.ITALIC, 12));
		gbAdd(l_address_detail, 0, 8, 1, 1);
		gbAdd(address_detail, 1, 8, 3, 1);

		JPanel btnPane = new JPanel(new GridBagLayout());
		btnPane.setBounds(10, 10, 10, 10);
		btnPane.setBackground(Color.WHITE);
		join = new JButton("가입");
		update = new JButton("수정");
		delete = new JButton("탈퇴");
		btnPane.add(join);
		btnPane.add(update);
		btnPane.add(delete);
		gbAdd(btnPane, 0, 11, 11, 1);

		birth.addFocusListener(this);
		address_detail.addFocusListener(this);
		search.addActionListener(this);
		join.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);
		idtf.addKeyListener(this);

		setVisible(true);
	}

	private void gbAdd(JComponent c, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gb.setConstraints(c, gbc);
		gbc.insets = new Insets(2, 2, 2, 2);
		this.add(c, gbc);
	}

	private MeminfoVo join_getData() {
		String address_doro;
		id = this.idtf.getText();
		String pw = this.pwtf.getText();
		String name = this.name.getText();
		String birth = this.birth.getText();
		String gender;
		if (male.isSelected())
			gender = "남";
		else if (female.isSelected())
			gender = "여";
		else
			gender = null;
		String tel = this.tel.getText();
		String email = this.email.getText();
		String address_detail = this.address_detail.getText();
//		if (this.address_doro == null) {
//			address_doro = sDoro.address_doro;
//		} else {
//			address_doro = this.address_doro.getText();
//		}

//		MeminfoVo mVo = new MeminfoVo(id, pw, name, birth, gender, tel, email, address_doro, address_detail);
		MeminfoVo mVo = new MeminfoVo(id, pw, name, birth, gender, tel, email, sDoro.sDoroVo, address_detail);

		return mVo;
	}

	private MeminfoVo update_getData() {
		MeminfoVo mVo = null;
		String address_doro;
		id = this.idtf.getText();
		String pw = this.pwtf.getText();
		String name = this.name.getText();
		String birth = this.birth.getText();
		String gender;
		if (male.isSelected())
			gender = "남";
		else if (female.isSelected())
			gender = "여";
		else
			gender = null;
		String tel = this.tel.getText();
		String email = this.email.getText();
		String address_detail = this.address_detail.getText();
//		if (this.address_doro == null) {
//			address_doro = sDoro.address_doro;
//		} else {
//			address_doro = this.address_doro.getText();
//		}

//		MeminfoVo mVo = new MeminfoVo(id, pw, name, birth, gender, tel, email, address_doro, address_detail);
		if (sDoro.sDoroVo != null)
			mVo = new MeminfoVo(id, pw, name, birth, gender, tel, email, sDoro.sDoroVo, address_detail);
		else
			mVo = new MeminfoVo(id, pw, name, birth, gender, tel, email, meminfoVo.meminfoVoToSearchDoroVo(meminfoVo),
					address_detail);

		return mVo;
	}

	public void btnOnOff(boolean a) {
		join.setEnabled(a);
		update.setEnabled(!a);
		delete.setEnabled(!a);
	}

	public void showDataById(String id) {
		MeminfoDao mDao = new MeminfoDao();
		meminfoVo = mDao.showInfo(id);
		System.out.println(meminfoVo.toString());
		this.idtf.setText(meminfoVo.getId());
		this.pwtf.setText(meminfoVo.getPw());
		this.name.setText(meminfoVo.getName());
		this.birth.setText(meminfoVo.getBirth());
		this.birth.setFont(new Font("굴림", Font.PLAIN, 12));
		this.birth.setForeground(Color.BLACK);
		if (meminfoVo.getGender() != null) {
			if (meminfoVo.getGender().equals("남"))
				male.setSelected(true);
			if (meminfoVo.getGender().equals("여"))
				female.setSelected(true);
		} else {
			male.setSelected(false);
			female.setSelected(false);
		}
		this.tel.setText(meminfoVo.getTel());
		this.email.setText(meminfoVo.getEmail());

		String address = meminfoVo.getSido() + " " + meminfoVo.getSigungu() + " ";
		if (meminfoVo.getEup_myeon_dong() != null)
			if (meminfoVo.getEup_myeon_dong().endsWith("읍") || (meminfoVo.getEup_myeon_dong().endsWith("면")))
				address += meminfoVo.getEup_myeon_dong() + " ";
		if (meminfoVo.getLi() != null)
			address += meminfoVo.getLi() + " ";
		if (meminfoVo.getDoro() != null)
			address += meminfoVo.getDoro() + " ";
		if (meminfoVo.getDoro_bon() != null)
			address += meminfoVo.getDoro_bon() + " - ";
		if (meminfoVo.getDoro_bu() != null)
			address += meminfoVo.getDoro_bu() + " ";
		if (meminfoVo.getSigungu_build_name() != null)
			address += meminfoVo.getSigungu_build_name() + " ";
		if (meminfoVo.getBuild_detail() != null)
			address += meminfoVo.getBuild_detail() + " ";
		if (meminfoVo.getEup_myeon_dong() != null)
			if (!(meminfoVo.getEup_myeon_dong().endsWith("읍") || (meminfoVo.getEup_myeon_dong().endsWith("면"))))
				address += "(" + meminfoVo.getEup_myeon_dong() + ")";

		/*
		 * v.add(sido); v.add(sigungu); if (eup_myeon_dong.endsWith("읍"))
		 * v.add(eup_myeon_dong); if (li != null && li.endsWith("리")) v.add(li);
		 * v.add(doro); v.add(doro_bon); v.add(doro_bu); if (sigungu_build_name != null)
		 * v.add(sigungu_build_name); if (build_detail != null) v.add(build_detail); if
		 * (!eup_myeon_dong.endsWith("읍")) v.add("(" + eup_myeon_dong + ")");
		 */

		this.address_doro.setText(address);
		this.address_detail.setText(meminfoVo.getAddress_detail());
		this.address_detail.setFont(new Font("굴림", Font.PLAIN, 12));
		this.address_detail.setForeground(Color.BLACK);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == join) {
			if (idtf.getText().equals("") || pwtf.getText().equals("") || name.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "아이디, 패스워드, 이름은 필수 항목입니다", "오류", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (0 < birth.getText().length() && birth.getText().length() < 6) {
				JOptionPane.showMessageDialog(null, "생년월일은 6자리로 입력하세요", "오류", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (address_doro.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "정보 제공을 위한 도로명 주소를 입력해 주세요 ^^", "오류", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (address_detail.getText().equals("상세 주소 입력"))
				address_detail.setText(null);
			if (birth.getText().equals("생년월일 6자리"))
				birth.setText(null);
			mDao = MeminfoDao.getInstance();
			mDao.join(join_getData());
//			System.out.println("meminfo error : " + mDao.joinError);
//			System.out.println(MeminfoDao.joinError);

			if (mDao.joinError == 1) {
				JOptionPane.showMessageDialog(null, "이미 가입된 정보 입니다", "오류", JOptionPane.ERROR_MESSAGE);
				mDao.joinError = -1;
				return;
			} else if (mDao.joinError == 12899) {
				JOptionPane.showMessageDialog(null, "아이디는 (영어+숫자) 8자 이하, 비밀번호는 (영어+숫자+특수문자) 12자 이하 입니다.", "오류",
						JOptionPane.ERROR_MESSAGE);
				mDao.joinError = -1;
				return;
			} else if (mDao.joinError == 1861) {
				JOptionPane.showMessageDialog(null, "날짜 형식이 이상합니다.", "오류", JOptionPane.ERROR_MESSAGE);
				mDao.joinError = -1;
				return;
			} else if (mDao.joinError > 1) {
				JOptionPane.showMessageDialog(null, "알 수 없는 오류 발생", "오류", JOptionPane.ERROR_MESSAGE);
				mDao.joinError = -1;
				return;
			} else {
				JOptionPane.showMessageDialog(null, idtf.getText() + "님 가입을 축하합니다!", "성공",
						JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
				return;
			}
		}
		if (e.getSource() == update) {
			pw = JOptionPane.showInputDialog("비밀번호를 입력 해주세요");
			if (pw.equals(CoronaDamoaMain.getPw())) {
				if (idtf.getText().equals("") || pwtf.getText().equals("") || name.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디, 패스워드, 이름은 필수 항목입니다", "오류", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (0 < birth.getText().length() && birth.getText().length() < 6) {
					JOptionPane.showMessageDialog(null, "생년월일은 6자리로 입력하세요", "오류", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (address_doro.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "정보 제공을 위한 도로명 주소를 입력해 주세요 ^^", "오류",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (address_detail.getText().equals("상세 주소 입력"))
					address_detail.setText(null);
				if (birth.getText().equals("생년월일 6자리"))
					birth.setText(null);
				mDao = MeminfoDao.getInstance();
				mDao.update(update_getData());
				if (mDao.updateError == 1840) {
					JOptionPane.showMessageDialog(null, "날짜 형식이 이상합니다.", "오류", JOptionPane.ERROR_MESSAGE);
					mDao.updateError = -1;
					return;
				} else {
					JOptionPane.showMessageDialog(null, "수정 성공", "성공", JOptionPane.INFORMATION_MESSAGE);
					this.dispose();
				}
			} else {
				JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요", "오류", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if (e.getSource() == delete) {
			pw = JOptionPane.showInputDialog("비밀번호를 입력 해주세요");
			if (pw.equals(CoronaDamoaMain.getPw())) {
				mDao = new MeminfoDao();
				mDao.delete(idtf.getText());
				JOptionPane.showMessageDialog(null, "탈퇴 되었습니다.", "성공", JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
				CoronaDamoaMain.cddispose();
				LoginMain.getInstance();
			} else {
				JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요", "오류", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if (e.getSource() == search) {
			sDoro = SearchDoroName.getInstance(this);
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource() == birth) {
			birth.setText("");
			birth.setFont(new Font("굴림", Font.PLAIN, 10));
			birth.setForeground(Color.BLACK);
		}
		if (e.getSource() == address_detail) {
			address_detail.setText("");
			address_detail.setFont(new Font("굴림", Font.PLAIN, 10));
			address_detail.setForeground(Color.BLACK);

		}
	}

	@Override
	public void focusLost(FocusEvent e) {
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
			showDataById(id);
		}
	}

	public static void main(String[] args) {
		MemInfo meminfo = MemInfo.getInstance();
	}

//	public static String getAddress_doro() {
//		this.address_doro = address_doro;
//		return null;
//	}

}
