package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import main.CoronaDamoaMain;

public class CoronaDistance extends JFrame {

	
	private static CoronaDistance coronaDistance;

	public static CoronaDistance getInstance(){
		if(coronaDistance != null)
			coronaDistance.dispose();
		coronaDistance=new CoronaDistance();
		return coronaDistance;
	}
	
	
	private JPanel contentPane;

	Vector<Object> items;
	private JTable agTable;
	private JButton button;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	CoronaDamoaMain main;
	private JButton btnNewButton_2;

	JScrollPane scrollPane;
	
	private CoronaDistance() {
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
		CoronaDamoaMain.leftMenu(contentPane, CoronaDistance.this, CoronaDistance.this);
		CoronaDamoaMain.topRightMenu(contentPane, CoronaDistance.this, CoronaDistance.this);
	

		JLabel lblNewLabel = new JLabel("사회적거리두기");
		lblNewLabel.setForeground(Color.black);
		lblNewLabel.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 40));
		lblNewLabel.setBounds(600, 10, 400, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lt2 = new JLabel("거리두기 단계별 조치사항");
		lt2.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 30));
		lt2.setForeground(new Color(0, 0, 0));
		lt2.setBounds(210, 70, 700, 61);
		contentPane.add(lt2);

		//이미지 넣기, inner  부분
		File file = new File("img/NewDistance.png");
		BufferedImage img = null;
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel lb = new JLabel(new ImageIcon(img));
		lb.setForeground(Color.WHITE);
		lb.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 30));
		lb.setBounds(200, 120, 1130, 700);
		this.getContentPane().add(lb);
	
			}
}
