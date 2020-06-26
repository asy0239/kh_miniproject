package frameChange;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class oneTo50 extends JPanel implements ActionListener {
	String path = System.getProperty("user.dir") + "\\images\\";
	private ChangePanel win;
	Random ran = new Random();

	JButton gameBtn[][];
	JButton resetBtn;
	JButton exitBtn;

	int front[][];
	int back[][];
	int gameNum; // 맞춰야하는 숫자
	int clickNum; //클릭 수. 잘못 클릭한것도 세준다
	ImageIcon backG = new ImageIcon(path + "bg\\1to50bg.png");

	public oneTo50(ChangePanel win) {
		this.win = win;
		setLayout(null);

		exitBtn = new JButton("exit");
		exitBtn.setBounds(800, 250, 100, 50);
		exitBtn.setBorder(null);
		exitBtn.addActionListener(this);

		resetBtn = new JButton("reset");
		resetBtn.setBorder(null);
		resetBtn.setBounds(800, 400, 100, 50);
		resetBtn.addActionListener(this);
		add(exitBtn);
		add(resetBtn);

		gameNum = 1;
		clickNum = 0;


		gameBtn = new JButton[5][5];
		front = new int[5][5];
		back = new int[5][5];
		setNumber();
		setButton();

	}

	// 배경을 그리는 부분
	public void paintComponent(Graphics g) {
		g.drawImage(backG.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}

	//숫자를 설정하는 부분
	public void setNumber() {
		int o = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				front[i][j] = o; // front[0][0~4] = 1 ~ 25
				back[i][j] = o + 25; // back[0] [0~4] = 26~
				o += 1;
			}
		}
		shuffle();
	}

	// 섞기
	public void shuffle() {
		for (int i = 0; i < 200; i++) { //i의 값으로 숫자를 섞는다
			int r1 = ran.nextInt(5); // 0~4 의 배열 내에서 섞기 위해 랜덤값 지정
			int r2 = ran.nextInt(5); // 0~4 의 배열 내에서 섞기 위한 랜던값 지정

			int temp = front[0][0]; // temp값에 0 0 값 담음
			front[0][0] = front[r1][r2];
			front[r1][r2] = temp;

			r1 = ran.nextInt(5);
			r2 = ran.nextInt(5);

			temp = back[0][0];
			back[0][0] = back[r1][r2];
			back[r1][r2] = temp;
		}
	}

	//버튼을 생성하는 부분
	public void setButton() {

		Font font = new Font("맑은 고딕", Font.BOLD, 40);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				gameBtn[i][j] = new JButton(); // 새버튼 생성
				gameBtn[i][j].setSize(100, 100); // 사이즈 설정
				gameBtn[i][j].setLocation(150 + j * 100, 150 + i * 100); // 위치를 설정한다
				gameBtn[i][j].setText("" + front[i][j]);
				gameBtn[i][j].setFont(font);
				gameBtn[i][j].setBackground(Color.lightGray);
				gameBtn[i][j].addActionListener(this);
				add(gameBtn[i][j]); // 버튼을 추가한다
			}
		}
	}

	// 게임을 다시 재설정하는 부분임.
	public void reset() {
		setNumber(); // 숫자 재설정을 해준다 내부에 셔플있음.
		clickNum = 0;
		gameNum = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				gameBtn[i][j].setText("" + front[i][j]);
				gameBtn[i][j].setBackground(Color.lightGray); //배경색을 다시 원점으로 돌려준다
				
				

			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (e.getSource() == gameBtn[i][j]) {
					clickNum++;
					if (front[i][j] == gameNum) {
						
						if (0 < gameNum && gameNum < 26) {
							front[i][j] = back[i][j];
							gameBtn[i][j].setText("" + front[i][j]);
							gameBtn[i][j].setBackground(Color.orange);
						} else {
							front[i][j] = 0;
							gameBtn[i][j].setText("");
							gameBtn[i][j].setBackground(Color.darkGray);
						}
						gameNum += 1;
						if (gameNum > 50) {
							gameNum = 50;
							JOptionPane.showMessageDialog(null, "게임이 종료되었습니다. 클릭한 횟수는 " + clickNum + "입니다.  다시하시려면 리셋 버튼을 눌러주세요");
						}

					}
				}
			}
		}

		if (e.getSource() == resetBtn) {
			reset();
		}
		if (e.getSource() == exitBtn) {
			win.change("playerGame",win);
		}

	}

}

