package view;
//통합
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import main.CoronaDamoaMain;
import model.ImmunizationClinicNewsDao;

public class CoronaNews extends JFrame implements HyperlinkListener {

	private JPanel contentPane;
	private JPanel innerPane;

	private static CoronaNews news;
	
	GridBagLayout gb;
	GridBagConstraints gbc;  // option
	
	public static CoronaNews getInstance(){
		if(news != null)
			news.dispose();
		news= new CoronaNews();
		return news;
	}

	private CoronaNews() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setResizable(false);
		setBounds(100, 100, 1400, 900);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//좌측 메뉴	, 우측상단 메뉴
		CoronaDamoaMain.leftMenu(contentPane, CoronaNews.this, CoronaNews.this);
		CoronaDamoaMain.topRightMenu(contentPane, CoronaNews.this, CoronaNews.this);
		gb = new GridBagLayout();
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		
		innerPane = new JPanel();
		innerPane.setLayout(gb);
		innerPane.setBounds(200, 120, 1130, 700);
		contentPane.add(innerPane);
		
		JEditorPane news1 = new JEditorPane();
		gbAdd(news1, 0, 0, 1, 1);
		news1.setContentType("text/html");
		news1.setText(getData(0));
		news1.setEditable(false);
		innerPane.add(news1);
		
		JEditorPane news2 = new JEditorPane();
		gbAdd(news2, 1, 0, 1, 1);
		news2.setContentType("text/html");
		news2.setText(getData(1));
		news2.setEditable(false);
		innerPane.add(news2);
		
		JEditorPane news3 = new JEditorPane();
		gbAdd(news3, 0, 1, 1, 1);
		news3.setContentType("text/html");
		news3.setText(getData(2));
		news3.setEditable(false);
		innerPane.add(news3);
		
		JEditorPane news4 = new JEditorPane();
		gbAdd(news4, 1, 1, 1, 1);
		news4.setContentType("text/html");
		news4.setText(getData(3));
		news4.setEditable(false);
		innerPane.add(news4);
		
		JEditorPane news5 = new JEditorPane();
		gbAdd(news5, 0, 2, 1, 1);
		news5.setContentType("text/html");
		news5.setText(getData(4));
		news5.setEditable(false);
		innerPane.add(news5);
		
		JEditorPane news6 = new JEditorPane();
		gbAdd(news6, 1, 2, 1, 1);
		news6.setContentType("text/html");
		news6.setText(getData(5));
		news6.setEditable(false);
		innerPane.add(news6);
		
		JEditorPane news7 = new JEditorPane();
		gbAdd(news7, 0, 3, 1, 1);
		news7.setContentType("text/html");
		news7.setText(getData(6));
		news7.setEditable(false);
		innerPane.add(news7);
		
		JEditorPane news8 = new JEditorPane();
		gbAdd(news8, 1, 3, 1, 1);
		news8.setContentType("text/html");
		news8.setText(getData(7));
		news8.setEditable(false);
		innerPane.add(news8);
		
		news1.addHyperlinkListener(this);
		news2.addHyperlinkListener(this);
		news3.addHyperlinkListener(this);
		news4.addHyperlinkListener(this);
		news5.addHyperlinkListener(this);
		news6.addHyperlinkListener(this);
		news7.addHyperlinkListener(this);
		news8.addHyperlinkListener(this);
		
			
		
		JLabel lblNewLabel = new JLabel("오늘의 뉴스");
		
		
		lblNewLabel.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 40));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(600, 10, 260, 60);
		contentPane.add(lblNewLabel);
		
	
		
	}
	
	private void gbAdd(JComponent c, int x, int y, int w, int h) {
		gbc.gridx = x; gbc.gridy = y;
		gbc.gridwidth = w; gbc.gridheight = h;
		gb.setConstraints(c, gbc);
		this.add(c, gbc);
	}
	
	private String getData(int i) {
		ImmunizationClinicNewsDao jDao = new ImmunizationClinicNewsDao();
		StringBuffer sb = new StringBuffer();
		Vector v = (Vector) jDao.newsDao().get(i);
		sb.append("<html><style>\r\n"
				+ "@import url(//fonts.googleapis.com/earlyaccess/nanumgothic.css);\r\n"
				+ "</style>\r\n"
				+ "<body><p style=\"font-family:맑은 고딕;\">").append(v.get(0)).append("<br>");
		sb.append("<a href =\"" + v.get(1) + "\">").append(v.get(1)).append("</a><br>");
		sb.append(v.get(2)).append("<br>").append("</p></body></html>");
		return sb.toString();
	}

	@Override
	public void hyperlinkUpdate(HyperlinkEvent e) {
		 if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
			 try {
				Desktop.getDesktop().browse(e.getURL().toURI());
			} catch (IOException | URISyntaxException e1) {
				e1.printStackTrace();
			}
         }
	}
	
	
	
}
