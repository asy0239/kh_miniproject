package frameChange;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
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
	private boolean loginTrue = false;

	private ChangePanel win;

	public PlainMail pm = new PlainMail();
	public Member m;

	public NewUser(ChangePanel win) {

		setLayout(null);

		this.win = win;
		//this.setBackground(Color.BLACK);

		//라벨
		JLabel signup = new JLabel("회원가입");
		JLabel userId = new JLabel("아이디");
		JLabel userPwd = new JLabel("비밀번호");
		JLabel userPwd2 = new JLabel("비밀번호 확인");
		JLabel userName = new JLabel("이름");
		JLabel userBirth = new JLabel("생년월일 ex) 19970415");
		JLabel userEmail = new JLabel("이메일");
		JLabel userEnumber = new JLabel("인증번호 4자리를 입력해주세요.");
		JLabel userPhone = new JLabel("전화번호 '-' 없이 번호만 입력해주세요.");

		//라벨 위치
		add(signup).setBounds(270, 50, 200, 20);
		add(userId).setBounds(270, 90, 200, 30);
		add(userPwd).setBounds(270, 165, 200, 30);
		add(userPwd2).setBounds(270, 230, 200, 30);
		add(userName).setBounds(270, 300, 200, 30);
		add(userBirth).setBounds(270, 375, 200, 30);
		add(userEmail).setBounds(270, 445, 200, 30);
		add(userEnumber).setBounds(270, 515, 200, 30);
		add(userPhone).setBounds(270, 585, 300, 30);

		//텍스트필드
		JTextField txtID = new JTextField(10);;
		JPasswordField txtPwd = new JPasswordField(10);
		JPasswordField txtPwd2 = new JPasswordField(10);
		JTextField txtName = new JTextField(10);
		JTextField txtBirth = new JTextField(8);
		JTextField txtEmail = new JTextField(20);
		JTextField txtEnumber = new JTextField(4);
		JTextField txtPhone = new JTextField(11);

		//텍스트필드 위치
		add(txtID).setBounds(270, 125, 200, 30);
		add(txtPwd).setBounds(270, 195, 200, 30);
		add(txtPwd2).setBounds(270, 265, 200, 30);
		add(txtName).setBounds(270, 335, 200, 30);
		add(txtBirth).setBounds(270, 410, 200, 30);
		add(txtEmail).setBounds(270, 480, 200, 30);
		add(txtEnumber).setBounds(270, 550, 200, 30);
		add(txtPhone).setBounds(270, 620, 200, 30);

		//폰트 크기
		signup.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		userId.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		userPwd.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		userPwd2.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		userName.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		userBirth.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		userEmail.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		userEnumber.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		userPhone.setFont(new Font("맑은 고딕", Font.BOLD, 13));

		//버튼
		//뒤로가기
		JButton backbtn = new JButton("BACK");
		add(backbtn).setBounds(35, 30, 80, 30);
		backbtn.addActionListener(new BACKActionListener());

		//중복검사
		JButton idbtn = new JButton("중복검사");
		add(idbtn).setBounds(515, 125, 115, 30);
		idbtn.addActionListener(new IDActionListener());

		//비밀번호 확인
		JButton pwdbtn = new JButton("비밀번호 확인");
		add(pwdbtn).setBounds(515, 265, 115, 30);
		pwdbtn.addActionListener(new PwdActionListener());

		//인증하기
		JButton emailbtn = new JButton("인증하기");
		add(emailbtn).setBounds(515, 480, 115, 30);
		emailbtn.addActionListener(new EmailActionListener());

		//인증완료
		JButton enumberbtn = new JButton("인증완료");
		add(enumberbtn).setBounds(515, 550, 115, 30);
		enumberbtn.addActionListener(new ENumActionListener());

		//가입하기
		JButton signupbtn = new JButton("가입하기");
		add(signupbtn).setBounds(740, 675, 115, 30);
		signupbtn.addActionListener(new SignActionListener());

		//가입취소
		JButton cancelbtn = new JButton("가입취소");
		add(cancelbtn).setBounds(870, 675, 115, 30);
		cancelbtn.addActionListener(new CancelActionListener());

		//백그라운드
		JPanel background = new JPanel();
		add(background).setBounds(240, 30, 460, 680);
		background.setBackground(Color.WHITE);

		//백그라운드 이미지
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images/main/start.jpg").getImage().getScaledInstance(1024, 768, 0)));
		add(label).setBounds(0, 0, 1024, 768);

		//버튼 폰트, 색깔
		backbtn.setBackground(Color.WHITE);
		idbtn.setBackground(Color.BLACK);
		pwdbtn.setBackground(Color.BLACK);
		emailbtn.setBackground(Color.BLACK);
		enumberbtn.setBackground(Color.BLACK);
		signupbtn.setBackground(Color.WHITE);
		cancelbtn.setBackground(Color.WHITE);

		backbtn.setForeground(Color.BLACK);
		idbtn.setForeground(Color.WHITE);
		pwdbtn.setForeground(Color.WHITE);
		emailbtn.setForeground(Color.WHITE);
		enumberbtn.setForeground(Color.WHITE);
		signupbtn.setForeground(Color.BLACK);
		cancelbtn.setForeground(Color.BLACK);

		idbtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		pwdbtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		emailbtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		enumberbtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		signupbtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		cancelbtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));


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
					win.change("login",win);

					m = new Member();
					m.setUserId(txtID.getText());
					m.setUserPwd(txtPwd.getText());

					fileSave();
					fileOpen();

				} else {

					JOptionPane.showMessageDialog(null, "회원가입 실패");

				}

			}
		});
	}

	//패널변경, 마우스이벤트
	//뒤로가기
	class BACKActionListener implements ActionListener {     
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("startpage",win);
		}
	}

	//중복검사
	class IDActionListener implements ActionListener {     
		@Override
		public void actionPerformed(ActionEvent e) {

		}
	}

	//비밀번호 확인
	class PwdActionListener implements ActionListener {     
		@Override
		public void actionPerformed(ActionEvent e) {

		}
	}

	//이메일인증
	class EmailActionListener implements ActionListener {     
		@Override
		public void actionPerformed(ActionEvent e) {

		}
	}

	//이메일인증완료
	class ENumActionListener implements ActionListener {     
		@Override
		public void actionPerformed(ActionEvent e) {

		}
	}

	//회원가입하기
	class SignActionListener implements ActionListener {     
		@Override
		public void actionPerformed(ActionEvent e) {

			if(loginTrue == true) {
				//JOptionPane.showMessageDialog(null, "회원가입 성공");
				win.change("login",win);

			} else {			
				//JOptionPane.showMessageDialog(null, "회원가입 실패");
			}

		}
	}

	//회원가입취소
	class CancelActionListener implements ActionListener {     
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("startpage",win);
		}	
	}

	public void fileSave() {

		try (ObjectOutputStream object = 
				new ObjectOutputStream(
						new FileOutputStream("member.txt"));) {

			object.writeObject(m);
			object.flush(); 

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fileOpen() {

		try(ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("member.txt"));) {

			System.out.println(objIn.readObject());

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}
