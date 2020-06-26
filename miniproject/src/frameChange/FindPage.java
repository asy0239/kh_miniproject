package frameChange;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FindPage extends JPanel{

	private String userName1, userEamil1, userName2, userID, userEamil2;
	private JTextField txtName1, txtEmail1, txtName2, txtID, txtEmail2;

	private boolean idTrue = false;
	private boolean loginTrue = false;

	private ChangePanel win;

	public FindPage(ChangePanel win) {

		setLayout(null);

		this.win = win;
		//this.setBackground(Color.BLACK);

		//아이디 찾기
		JLabel findID = new JLabel("아이디 찾기");
		JLabel findID2 = new JLabel("아이디는 가입시 입력하신 이메일을 통해 찾을 수 있습니다.");
		JLabel userName1 = new JLabel("이름");
		JLabel userEmail1 = new JLabel("이메일");

		//비밀번호 찾기
		JLabel findPWD = new JLabel("비밀번호 찾기");
		JLabel findPWD2 = new JLabel("비밀번호는 가입한 아이디, 이름, 이메일을 통해 찾을 수 있습니다.");
		JLabel userID = new JLabel("아이디");
		JLabel userName2 = new JLabel("이름");
		JLabel userEmail2 = new JLabel("이메일");

		//라벨 위치
		add(findID).setBounds(270, 50, 200, 20);
		add(findID2).setBounds(270, 80, 500, 20);
		add(userName1).setBounds(270, 120, 200, 30);
		add(userEmail1).setBounds(270, 195, 200, 30);

		add(findPWD).setBounds(270, 310, 200, 30);
		add(findPWD2).setBounds(270, 340, 500, 30);
		add(userID).setBounds(270, 380, 200, 30);
		add(userName2).setBounds(270, 460, 200, 30);
		add(userEmail2).setBounds(270, 540, 200, 30);

		//텍스트필드
		JTextField txtName1 = new JTextField(10);
		JPasswordField txtEmail1 = new JPasswordField(10);

		JPasswordField txtName2 = new JPasswordField(10);
		JTextField txtID = new JTextField(10);
		JTextField txtEmail2 = new JTextField(8);

		//텍스트필드 위치
		add(txtName1).setBounds(270, 160, 200, 30);
		add(txtEmail1).setBounds(270, 235, 200, 30);

		add(txtID).setBounds(270, 420, 200, 30);
		add(txtName2).setBounds(270, 500, 200, 30);
		add(txtEmail2).setBounds(270, 580, 200, 30);

		//폰트 크기
		findID.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		findID2.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		userName1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		userEmail1.setFont(new Font("맑은 고딕", Font.BOLD, 13));

		findPWD.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		findPWD2.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		userID.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		userName2.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		userEmail2.setFont(new Font("맑은 고딕", Font.BOLD, 13));

		//버튼
		//뒤로가기
		JButton backbtn = new JButton("BACK");
		add(backbtn).setBounds(35, 30, 80, 30);
		backbtn.addActionListener(new BACKActionListener());

		//아이디 찾기
		JButton findbtn1 = new JButton("아이디 찾기");
		add(findbtn1).setBounds(515, 235, 115, 30);
		findbtn1.addActionListener(new IDActionListener());

		//비밀번호 찾기
		JButton findbtn2 = new JButton("비밀번호 찾기");
		add(findbtn2).setBounds(515, 580, 115, 30);
		findbtn2.addActionListener(new PWDActionListener());

		//백그라운드
		JPanel background = new JPanel();
		add(background).setBounds(240, 30, 460, 680);
		background.setBackground(Color.WHITE);

		//백그라운드 이미지
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images/main/start.jpg").getImage().getScaledInstance(1024, 768, 0)));
		add(label).setBounds(0, 0, 1024, 768);

		//버튼 폰트, 색깔
		backbtn.setBackground(Color.WHITE);
		findbtn1.setBackground(Color.BLACK);
		findbtn2.setBackground(Color.BLACK);

		backbtn.setForeground(Color.BLACK);
		findbtn1.setForeground(Color.WHITE);
		findbtn2.setForeground(Color.WHITE);

		findbtn1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		findbtn2.setFont(new Font("맑은 고딕", Font.BOLD, 13));

		findbtn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(txtEmail1.equals(txtEmail1.getText())) {
					JOptionPane.showMessageDialog(null, "이메일을 다시 입력해주세요.");

				} else {
					JOptionPane.showMessageDialog(null, "이메일 확인이 완료되었습니다.");
					idTrue = true;
				}

			}
		});
	}

	//패널변경, 마우스이벤트
	//뒤로가기
	class BACKActionListener implements ActionListener {     
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("startpage");
		}
	}

	//중복검사
	class IDActionListener implements ActionListener {     
		@Override
		public void actionPerformed(ActionEvent e) {

		}
	}

	//비밀번호 확인
	class PWDActionListener implements ActionListener {     
		@Override
		public void actionPerformed(ActionEvent e) {

		}
	}
}