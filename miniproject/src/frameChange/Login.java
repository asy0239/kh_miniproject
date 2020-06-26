package frameChange;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JPanel{

	private JTextField txtID;
	private JPasswordField txtPwd;
	private ChangePanel win;
	
	public Login(ChangePanel win) {
		
		setLayout(null);
		this.win = win;
		
		this.setBackground(Color.BLACK);
		
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images/main/logo.png").getImage().getScaledInstance(800, 230, 0)));
		add(label).setBounds(105, 50, 800, 500);

		//아이디
		JLabel id = new JLabel("ID : ");
		add(id).setBounds(290, 472, 100, 30);

		txtID = new JTextField();
		add(txtID).setBounds(360, 470, 200, 40);
		txtID.setColumns(10);

		//비밀번호
		JLabel pwd = new JLabel("PW : ");
		add(pwd).setBounds(280, 534, 100, 30);

		txtPwd = new JPasswordField();
		add(txtPwd).setBounds(360, 530, 200, 40);

		//뒤로가기
		JButton backbtn = new JButton("BACK");
		add(backbtn).setBounds(35, 30, 80, 30);
		backbtn.addActionListener(new BackActionListener());

		//로그인
		JButton loginbtn = new JButton("LOGIN");
		add(loginbtn).setBounds(590, 469, 170, 100);
		add(loginbtn);
		
		
		//회원가입
		JButton signupbtn = new JButton("회원가입");
		add(signupbtn).setBounds(875, 660, 100, 30);
		signupbtn.addActionListener(new SignActionListener());
		
		//아이디, 비밀번호 찾기
		JButton findbtn = new JButton("ID/PW 찾기");
		add(findbtn).setBounds(755, 660, 100, 30);
		findbtn.addActionListener(new FindActionListener());
		
		//텍스트 크기
		id.setFont(new Font("Tahoma", Font.BOLD, 25));
		pwd.setFont(new Font("Tahoma", Font.BOLD, 25));
		loginbtn.setFont(new Font("Tahoma", Font.BOLD, 33));
		txtID.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtPwd.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		//텍스트 색깔
		id.setForeground(Color.WHITE);
		pwd.setForeground(Color.WHITE);
		
		//버튼 색깔
		backbtn.setBackground(Color.WHITE);
		loginbtn.setBackground(Color.WHITE);
		findbtn.setBackground(Color.WHITE);
		signupbtn.setBackground(Color.WHITE);
		
		//로그인 성공, 실패
		//엔터키리스너
		txtPwd.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(KeyEvent.VK_ENTER == e.getKeyCode()) {

					String id = "kh1234";
					String pwd = "123456";

					if(id.equals(txtID.getText()) && pwd.equals(txtPwd.getText() )) {
						JOptionPane.showMessageDialog(null, "로그인 성공");
							win.change("playerMain",win);

					} else {
						JOptionPane.showMessageDialog(null, "로그인 실패");
					}
				}

			}

		});

		//마우스리스너
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//				String id = "kh1234";
//				String pwd = "123456";

				if(id.equals(txtID.getText()) && pwd.equals(txtPwd.getText() )) {
					JOptionPane.showMessageDialog(null, "로그인 성공");

						win.change("playerMain",win);

				} else {
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}

			}
		});

	}

	//패널변경(뒤로가기)
	class BackActionListener implements ActionListener {     
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("startpage",win);
		}
	}
	
	
	//회원가입
	class SignActionListener implements ActionListener {     
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("newuser",win);
		}
	}
	
	//아이디, 비밀번호 찾기
	class FindActionListener implements ActionListener {     
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("FindPage");
		}
	}
	
}
