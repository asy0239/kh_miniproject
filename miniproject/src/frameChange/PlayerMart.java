package frameChange;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlayerMart extends JPanel implements KeyListener, Runnable {
	private Image screenImage;
	private ChangePanel win;
	private Graphics screenGraphics;
	private boolean playMove;
	final int perMove = 10;
	private int ctnTrash = 5;
	private int[][] trashXY = new int[5][2];

	Thread th;
	private Image mainMartBackGround, player, imgNPC, imgPlayerUp, imgPlayerUp1, imgPlayerUp2, imgPlayerDown,
			imgPlayerDown1, imgPlayerDown2, imgPlayerLeft, imgPlayerLeft1, imgPlayerLeft2, imgPlayerRight,
			imgPlayerRight1, imgPlayerRight2, imgTrash;

	private int x, y; // 좌표
	private int guestX, guestY;
	private int status; //
	Random ran;
	int changeImg = 1;

	public PlayerMart(ChangePanel win) {
		this.win = win;

		this.setFocusable(true);
		win.setTitle("player");

		win.setSize(1024, 768);
		win.setResizable(false);
		win.setVisible(true);
		win.setLocationRelativeTo(null);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String path = System.getProperty("user.dir") + "\\miniproject\\images\\";

		mainMartBackGround = new ImageIcon(path + "bg\\mainmart.png").getImage();
		player = new ImageIcon(path + "character\\downStand.png").getImage().getScaledInstance(100, 100, 0);

		imgPlayerUp = new ImageIcon(path + "character\\upStand.png").getImage().getScaledInstance(100, 100, 0);
		imgPlayerUp1 = new ImageIcon(path + "character\\upLeft.png").getImage().getScaledInstance(100, 100, 0);
		imgPlayerUp2 = new ImageIcon(path + "character\\upRight.png").getImage().getScaledInstance(100, 100, 0);

		imgPlayerDown = new ImageIcon(path + "character\\downStand.png").getImage().getScaledInstance(100, 100, 0);
		imgPlayerDown1 = new ImageIcon(path + "character\\downLeft.png").getImage().getScaledInstance(100, 100, 0);
		imgPlayerDown2 = new ImageIcon(path + "character\\downRight.png").getImage().getScaledInstance(100, 100, 0);

		imgPlayerLeft = new ImageIcon(path + "character\\leftStand.png").getImage().getScaledInstance(100, 100, 0);
		imgPlayerLeft1 = new ImageIcon(path + "character\\leftLeft.png").getImage().getScaledInstance(100, 100, 0);
		imgPlayerLeft2 = new ImageIcon(path + "character\\leftRight.png").getImage().getScaledInstance(100, 100, 0);

		imgPlayerRight = new ImageIcon(path + "character\\rightStand.png").getImage().getScaledInstance(100, 100, 0);
		imgPlayerRight1 = new ImageIcon(path + "character\\rightLeft.png").getImage().getScaledInstance(100, 100, 0);
		imgPlayerRight2 = new ImageIcon(path + "character\\rightRight.png").getImage().getScaledInstance(100, 100, 0);

		imgTrash = new ImageIcon(path + "shop\\icon_trash.png").getImage().getScaledInstance(50, 50, 0);

		x = 900;
		y = 120;

		this.addKeyListener(this);
		th = new Thread(this);
		makeTrash();
		th.start();
	}

	public void paint(Graphics g) {
		screenImage = createImage(1024, 768);
		screenGraphics = screenImage.getGraphics();
		doubleBuffered(screenGraphics);
		g.drawImage(screenImage, 0, 0, null);
		for (int i = 0; i < 5; i++) {
			if (trashXY[i][0] != -1 && trashXY[i][1] != -1)
				g.drawImage(imgTrash, trashXY[i][0], trashXY[i][1], null);
		}
		g.drawImage(player, x, y, null);
	}

	public void doubleBuffered(Graphics g) {
		g.drawImage(MoveImage(), x, y, null);
		g.drawImage(mainMartBackGround, 0, 0, null);
	}

	@Override
	public void run() {

		// TODO Auto-generated method stub
		while (true) {
			try {
				this.requestFocus();
				Thread.sleep(50);
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public Image MoveImage() {
		if (playMove == true) {

			switch (status) {

			case 1:
				// g.drawImage(imgPlayerUping, x,y ,this);
				if (changeImg == 1) {
					player = imgPlayerUp1;
					changeImg *= -1;
				} else {
					player = imgPlayerUp2;
					changeImg *= -1;
				}
				break;
			case 2:
				// g.drawImage(imgPlayerDowning, x,y ,this);
				if (changeImg == 1) {
					player = imgPlayerDown1;
					changeImg *= -1;

				} else {
					player = imgPlayerDown2;
					changeImg *= -1;
				}
				break;
			case 3:
				// g.drawImage(imgPlayerLefting, x,y ,this);
				if (changeImg == 1) {
					player = imgPlayerLeft1;
					changeImg *= -1;
				} else {
					player = imgPlayerLeft2;
					changeImg *= -1;
				}
				break;
			case 4:
				// g.drawImage(imgPlayerRighting, x,y ,this);
				if (changeImg == 1) {
					player = imgPlayerRight1;
					changeImg *= -1;
				} else {
					player = imgPlayerRight2;
					changeImg *= -1;
				}

				break;
			}
		} else {

			switch (status) {
			case 1:
				// g.drawImage(imgPlayerUp, x, y ,this);
				player = imgPlayerUp;
				break;
			case 2:
				// g.drawImage(imgPlayerDown, x, y ,this);
				player = imgPlayerDown;
				break;
			case 3:
				// g.drawImage(imgPlayerLeft, x, y ,this);
				player = imgPlayerLeft;
				break;
			case 4:
				// g.drawImage(imgPlayerRight, x, y ,this);
				player = imgPlayerRight;
				break;
			}
		}
		return player;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(x + " + " + y);
		int keyCode = e.getKeyCode();

		switch (e.getKeyCode()) {

		case KeyEvent.VK_UP:

			if (checkXY2(x, y - perMove)) {
				y -= perMove;
				status = 1;
				playMove = true;
				return;
			} else {
				status = 1;
				return;
			}
		case KeyEvent.VK_DOWN:
			if (checkXY2(x, y + perMove)) {
				y += perMove;
				status = 2;
				playMove = true;
				return;
			} else {
				status = 2;
				return;
			}
		case KeyEvent.VK_LEFT:
			if (checkXY2(x - perMove, y)) {
				x -= perMove;
				status = 3;
				playMove = true;
				return;
			} else {
				status = 3;
				return;
			}
		case KeyEvent.VK_RIGHT:
			if (checkXY2(x + perMove, y)) {
				x += perMove;
				status = 4;
				playMove = true;
				return;
			} else {
				status = 4;
				return;
			}
		case KeyEvent.VK_SPACE:

			for (int i = 0; i < trashXY.length; i++) {

				// 캐릭터 좌표에 +- 50위 단위 내에서 선택 시
				if ((trashXY[i][0] >= x && trashXY[i][0] <= x + 50)
						&& (trashXY[i][1] >= y && trashXY[i][1] <= y+100)) {
					trashXY[i][0] = -1;
					trashXY[i][1] = -1;
				}
			}
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		inMart(x, y);
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			playMove = false;
			break;
		case KeyEvent.VK_DOWN:
			playMove = false;
			break;
		case KeyEvent.VK_LEFT:
			playMove = false;
			break;
		case KeyEvent.VK_RIGHT:
			playMove = false;
			break;
		}
	}

	public boolean checkXY2(int x, int y) {
		boolean[][] maxXY = new boolean[1023][767];

		// 초기화
		for (int i = 0; i < maxXY.length; i++) {
			for (int j = 0; j < maxXY[i].length; j++) {
				maxXY[i][j] = false;
			}
		}

		// 좌상단1 ok
		for (int i = 50; i <= 300; i++) {
			for (int j = 110; j <= 230; j++) {
				maxXY[i][j] = true;
			}
		}

		// 좌상단2 ok
		for (int i = 300; i <= 430; i++) {
			for (int j = 180; j <= 230; j++) {
				maxXY[i][j] = true;
			}
		}

		// 상단(카운터 뒤) ok
		for (int i = 520; i <= 750; i++) {
			for (int j = 40; j <= 60; j++) {
				maxXY[i][j] = true;
			}
		}

		// 상단(카운터 골목) ok
		for (int i = 740; i <= 750; i++) {
			for (int j = 40; j <= 190; j++) {
				maxXY[i][j] = true;
			}
		}

		// 우상단(입구) ok
		for (int i = 750; i <= 920; i++) {
			for (int j = 110; j <= 200; j++) {
				maxXY[i][j] = true;
			}
		}

		// 우중단
		for (int i = 410; i <= 820; i++) {
			for (int j = 180; j <= 420; j++) {
				maxXY[i][j] = true;
			}
		}

		// 하단 ok
		for (int i = 30; i <= 840; i++) {
			for (int j = 420; j <= 590; j++) {
				maxXY[i][j] = true;
			}
		}

		return maxXY[x][y];

	}
	// 900,120 ~ 910,200

	public void inMart(int x, int y) {
		if (x >= 900 && (y >= 120 && y <= 200)) {
			win.change("playerMain");
		}
	}

	public void makeTrash() {

		for (int i = 0; i < ctnTrash; i++) {
			for (int j = 0; j < 2; j++) {
				trashXY[i][j] = 0;
			}
		}

		for (int i = 0; i < ctnTrash; i++) {
			trashXY[i][0] = ((int) ((Math.random() * 1024)) / 10) * 10; // 1의 자리 버림
			trashXY[i][1] = (int) (((Math.random() * 768)) / 10) * 10; // 1의 자리 버림

//			System.out.println("\t\t\t" + trashXY[i][0] + "\t" + trashXY[i][1]);

			if (!checkXY2(trashXY[i][0], trashXY[i][1])) {
				i--;
			}
		}
	}
	
	public void guestMove() {
		
		
	}
}
