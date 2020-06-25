package frameChange;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NewUser extends JPanel{

	private String userId, userPwd, userPwd2, userName, userBirth, userEmail, userEnumber, userPhone;
	private JTextField txtID, txtPWd, txtPwd2, txtName, txtBirth, txxtEmail, txtEnumber, txtPhone;

	private boolean idTrue = false;

	private ChangePanel win;

	public PlainMail pm = new PlainMail();
	
	public NewUser(ChangePanel win) {

		setLayout(null);

		this.win = win;
		this.setBackground(Color.WHITE);

		//라벨
		JLabel userId = new JLabel("아이디");
		JLabel userPwd = new JLabel("비밀번호");
		JLabel userPwd2 = new JLabel("비밀번호 확인");
		JLabel userName = new JLabel("이름");
		JLabel userBirth = new JLabel("생년월일 ex) 19970415");
		JLabel userEmail = new JLabel("이메일");
		JLabel userEnumber = new JLabel("인증번호 4자리를 입력해주세요.");
		JLabel userPhone = new JLabel("전화번호 '-' 없이 번호만 입력해주세요.");

		//라벨 위치
		add(userId).setBounds(150, 50, 200, 30);
		add(userPwd).setBounds(150, 110, 200, 30);
		add(userPwd2).setBounds(150, 170, 200, 30);
		add(userName).setBounds(150, 230, 200, 30);
		add(userBirth).setBounds(150, 295, 200, 30);
		add(userEmail).setBounds(150, 360, 200, 30);
		add(userEnumber).setBounds(150, 430, 200, 30);
		add(userPhone).setBounds(150, 490, 300, 30);

		//텍스트필드
		JTextField txtID = new JTextField(10);
		JPasswordField txtPwd = new JPasswordField(10);
		JPasswordField txtPwd2 = new JPasswordField(10);
		JTextField txtName = new JTextField(10);
		JTextField txtBirth = new JTextField(8);
		JTextField txtEmail = new JTextField(20);
		JTextField txtEnumber = new JTextField(4);
		JTextField txtPhone = new JTextField(11);

		//텍스트필드 위치
		add(txtID).setBounds(150, 80, 200, 30);
		add(txtPwd).setBounds(150, 140, 200, 30);
		add(txtPwd2).setBounds(150, 200, 200, 30);
		add(txtName).setBounds(150, 260, 200, 30);
		add(txtBirth).setBounds(150, 328, 200, 30);
		add(txtEmail).setBounds(150, 395, 200, 30);
		add(txtEnumber).setBounds(150, 460, 200, 30);
		add(txtPhone).setBounds(150, 525, 200, 30);

		//버튼
		//뒤로가기
		JButton backbtn = new JButton("BACK");
		add(backbtn).setBounds(35, 30, 80, 30);
		backbtn.addActionListener(new MyActionListener());

		//중복검사
		JButton idbtn = new JButton("중복검사");
		add(idbtn).setBounds(380, 80, 100, 30);
		idbtn.addActionListener(new IDActionListener());

		//비밀번호 확인
		JButton pwdbtn = new JButton("비밀번호 확인");
		add(pwdbtn).setBounds(380, 200, 115, 30);
		pwdbtn.addActionListener(new PwdActionListener());

		//인증하기
		JButton emailbtn = new JButton("인증하기");
		add(emailbtn).setBounds(380, 395, 100, 30);
		emailbtn.addActionListener(new EmailActionListener());

		//인증완료
		JButton enumberbtn = new JButton("인증완료");
		add(enumberbtn).setBounds(380, 460, 100, 30);
		enumberbtn.addActionListener(new ENumActionListener());

		//가입하기
		JButton signupbtn = new JButton("가입하기");
		add(signupbtn).setBounds(220, 630, 150, 35);
		signupbtn.addActionListener(new SignActionListener());

		txtID.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(KeyEvent.VK_ENTER == e.getKeyCode()) {


					String id = "kheee";

					//id
					if(id.equals(txtID.getText())) {
						JOptionPane.showMessageDialog(null, "이미 등록된 아이디입니다.");

					} else {
						JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.");
						idTrue = true;
					}

				}

			}
		});


		txtPwd2.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(KeyEvent.VK_ENTER == e.getKeyCode()) {

					//pwd, pwd2
					if(txtPwd.getText().equals(txtPwd2.getText())) {
						JOptionPane.showMessageDialog(null, "비밀번호 확인 성공");

					} else {
						JOptionPane.showMessageDialog(null, "비밀번호 확인 실패");
					}

				}

			}
		});

		idbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(txtID.equals(txtID.getText())) {
					JOptionPane.showMessageDialog(null, "이미 등록된 아이디입니다.");

				} else {
					JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.");
					idTrue = true;
				}

			}
		});

		pwdbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(txtPwd.getText().equals(txtPwd2.getText())) {
					JOptionPane.showMessageDialog(null, "비밀번호 확인 성공");

				} else {
					JOptionPane.showMessageDialog(null, "비밀번호 확인 실패");
				}

			}
		});

		emailbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				pm.gmailSend(txtEmail.getText());
				JOptionPane.showMessageDialog(null, "이메일 전송 완료!");

			}
		});

		enumberbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(pm.emailText2);
				if(pm.emailText2.equals(txtEnumber.getText())) {
					System.out.println("인증완료!");
					JOptionPane.showMessageDialog(null, "이메일 인증 완료!", "이메일 인증완료", JOptionPane.OK_CANCEL_OPTION);

				} else {
					System.out.println("인증번호 다시 입력하세요~");
					JOptionPane.showMessageDialog(null, "인증번호를 다시 확인하세요!", "다시 입력", JOptionPane.OK_CANCEL_OPTION);
				}

			}
		});

		signupbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(idTrue == true) {
					JOptionPane.showMessageDialog(null, "회원가입 성공");
					win.change("startpage");

					try {
						BufferedWriter bw = new BufferedWriter(new FileWriter("member.txt", true));
						bw.write(txtID.getText() + "/");
						bw.write(txtPwd.getText() + "/");
						bw.write(txtPwd2.getText() + "/");
						bw.write(txtName.getText() + "/");
						bw.write(txtBirth.getText() + "/");
						bw.write(txtEmail.getText() + "/");
						bw.write(txtPhone.getText() + "\n");

						bw.flush();

					} catch (IOException e1) {
						e1.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(null, "회원가입 실패");
				}

			}
		});

	}

	//뒤로가기
	class MyActionListener implements ActionListener {     
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("startpage");
		}
	}

	//중복검사
	class IDActionListener implements ActionListener {     
		@Override
		public void actionPerformed(ActionEvent e) {
			//win.change("startpage");
		}
	}

	//비밀번호 확인
	class PwdActionListener implements ActionListener {     
		@Override
		public void actionPerformed(ActionEvent e) {
			//win.change("startpage");
		}
	}

	//이메일인증
	class EmailActionListener implements ActionListener {     
		@Override
		public void actionPerformed(ActionEvent e) {
			//win.change("startpage"); 인증페이지로 변경해야함
		}
	}

	//이메일인증완료
	class ENumActionListener implements ActionListener {     
		@Override
		public void actionPerformed(ActionEvent e) {
			//win.change("startpage"); //인증페이지로 변경해야함
		}
	}

	//회원가입완료
	class SignActionListener implements ActionListener {     
		@Override
		public void actionPerformed(ActionEvent e) {
			//win.change("startpage");
		}
	}

}
