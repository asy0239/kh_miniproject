package frameChange;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlayerMain extends JPanel implements KeyListener, Runnable{
	private Image screenImage;
	private ChangePanel win;
	private Graphics screenGraphics; // 어떤 컴포넌트에 그리기위한 정보를 담고 있는 추상 클래스
	private boolean playMove;
	final int perMove = 10;
	Thread th;
	private Image imgMainTown, imgPlayerUp, imgPlayerDown,imgPlayerStop,
	imgPlayerLeft,imgPlayerRight , imgNPC, imgPlayerUping, imgPlayerDowning,
	imgPlayerLefting, imgPlayerRighting;

	private int npcX, x;  // x ,y 좌표값
	private int npcY, y;
	private int status; // 방향키의 상태를 체크
	Random ran;
	
	private Image mainTownBackGround, player;
	public PlayerMain(ChangePanel win) {
		this.win = win;
		
		this.setFocusable(true);
		win.setTitle("player");
		
		win.setSize(1024, 768);
		win.setResizable(false); // 창 크기 변경 가능 여부
		win.setVisible(true);
		win.setLocationRelativeTo(null); // 창을 상대적인 위치에 지정 할 수 있다. null 은 윈도우 창의 가운데를 의미한다.
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		String path = "./images/";
		mainTownBackGround = new ImageIcon(path + "maintown.png").getImage(); 
		player = new ImageIcon(path + "downstop.png").getImage();
		imgMainTown = new ImageIcon(path + "외부마을.png").getImage().getScaledInstance(50, 50, 0); // 외부 마을 이미지
		imgPlayerUp = new ImageIcon(path + "upstop.png").getImage().getScaledInstance(50, 50, 0); // 캐릭터 이미지
		imgPlayerDown = new ImageIcon(path + "downstop.png").getImage().getScaledInstance(50, 50, 0); // 캐릭터 이미지
		imgPlayerLeft = new ImageIcon(path + "leftstop.png").getImage().getScaledInstance(50, 50, 0); // 캐릭터 이미지
		imgPlayerRight = new ImageIcon(path + "rightstop.png").getImage().getScaledInstance(50, 50, 0); // 캐릭터 이미지
		imgPlayerUping = new ImageIcon(path + "upgo.png").getImage().getScaledInstance(50,50, 0); // 캐릭터 이미지
		imgPlayerRighting = new ImageIcon(path + "rightgo.png").getImage().getScaledInstance(50, 50, 0); // 캐릭터 이미지
		imgPlayerLefting = new ImageIcon(path + "leftgo.png").getImage().getScaledInstance(50, 50, 0); // 캐릭터 이미지
		imgPlayerDowning = new ImageIcon(path + "downgo.png").getImage().getScaledInstance(50, 50, 0); // 캐릭터 이미지
		imgPlayerStop = new ImageIcon(path + "downstop.png").getImage().getScaledInstance(50, 50, 0); // 캐릭터 이미지
		
		imgNPC = new ImageIcon(path + "downstop.png").getImage().getScaledInstance(50, 50, 0); // npc 이미지

		player = player.getScaledInstance(50, 50, 0);
		
		
		
		//Main.class.getResource(name) 프로젝트 경로, 메인 경로를 알려줌
		
		
		// 캐릭터 초기 위치
		x = 10;
		y = 10;

		
		this.addKeyListener(this);
		th = new Thread(this);
		th.start();

	}
	
	public void paint(Graphics g) {
		screenImage = createImage(1024, 768);
		screenGraphics = screenImage.getGraphics(); // graphics 객체로 변환
		doubleBuffered(screenGraphics);
		g.drawImage(screenImage , 0, 0, null);
		g.drawImage(player, x, y, null);
		g.drawImage(imgNPC, npcX,npcY,null);
	}
	
	public void doubleBuffered(Graphics g) {  // paint 와 doubleBuffered 를 이용해 깜빡거림을 제거할 수 있다.
		// 버퍼에 미리 올려놔 끊김없이 보여준다.
		g.drawImage(MoveImage(),x,y,null);
		g.drawImage(mainTownBackGround, 0, 0, null);
//		g.drawImage(imgNPC, npcX,npcY, null);
//		this.repaint();
	}
	
	
	
	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		while(true) {
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
	             player = imgPlayerUping;
	             break;
	          case 2:
	             // g.drawImage(imgPlayerDowning, x,y ,this);
	             player = imgPlayerDowning;
	             break;
	          case 3:
	             // g.drawImage(imgPlayerLefting, x,y ,this);
	             player = imgPlayerLefting;
	             break;
	          case 4:
	             // g.drawImage(imgPlayerRighting, x,y ,this);
	             player = imgPlayerRighting;
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
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	      System.out.println(x + " + " + y);
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
	
	public boolean checkXY2(int x , int y) {
	      boolean[][] maxXY = new boolean[1023][767];
	      
	      // 초기화
	      for(int i=0; i<maxXY.length; i++) {
	         for(int j=0; j<maxXY[i].length; j++) {
	            maxXY[i][j] = false;
	         }
	      }
	      
	      for(int i = 1; i < 75; i++) {
	         for(int j = 1; j < 668; j++) {
	            maxXY[i][j] = true;
	         }
	      }
	      
	      for(int i = 1; i < 1000; i++) {
	         for(int j=290; j<370; j++) {
	            maxXY[i][j] = true;
	         }
	      }
	      
	      for(int i=540; i<690; i++) {
	         for(int j=0; j<718; j++) {
	            maxXY[i][j] = true;
	         }
	      }
	      for(int i = 1; i < 1000; i++) {
	    	  for(int j = 650; j < 720; j++) {
	    		  maxXY[i][j] = true;
	    	  }
	      }
	      
	      // 오른쪽 상단 - 건물(My)
	      for(int i = 850; i < 900; i++) {
	    	  for(int j = 270; j < 300; j++) {
	    		  maxXY[i][j] = true;
	    	  }
	      }
	      // 왼쪽 상단 - 건물(박물관)
	      for(int i = 170; i < 230; i++) {
	    	  for(int j = 260; j < 300; j++) {
	    		  maxXY[i][j] = true;
	    	  }
	      }
	      
	      // 가운데 상단 - 건물()
	      for(int i = 350; i < 400; i++) {
	    	  for(int j = 270; j < 300; j++) {
	    		  maxXY[i][j] = true;
	    	  }
	      }
	    	 
	      return maxXY[x][y]; 

	}
	
	public void inMart(int x, int y) {
		if((x >= 850 && x <= 900) && (y >= 270 && y <= 290)) {
			win.change("playerMart");
		}
		if((x >= 170 && x <= 230) && (y >= 240 && y <= 270)) {
			win.change("playerGame");
		}
		
		if((x >= 350 && x <= 400) && (y >= 270 && y <= 300)) {
			win.change("maintown");
		}
	}
}

//public class npc implements Runnable {
//
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		Thread.sleep(100);
//		
//	}
//	
//}

