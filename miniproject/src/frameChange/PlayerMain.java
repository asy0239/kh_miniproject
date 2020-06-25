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
	private Graphics screenGraphics; 
	private boolean playMove;
	final int perMove = 10;
	Thread th;
	
	// 아래와 같이 변수명 변경하였으니 확인 요망
	private Image imgMainTown, imgPlayerUp, imgPlayerDown,imgPlayerStop,
	imgPlayerLeft,imgPlayerRight , imgNPC, imgPlayerUping, imgPlayerDowning,
	imgPlayerLefting, imgPlayerRighting;
	
	/*
	
	private Image mainMartBackGround, player, imgNPC, imgPlayerUp, imgPlayerUp1, imgPlayerUp2, imgPlayerDown,
			imgPlayerDown1, imgPlayerDown2, imgPlayerLeft, imgPlayerLeft1, imgPlayerLeft2, imgPlayerRight,
			imgPlayerRight1, imgPlayerRight2, imgTrash;
	
	*/

	private int x, y;
	private int npcX, npcY;
	private int status;
	Random ran;
	
	private Image mainTownBackGround, player;
	public PlayerMain(ChangePanel win) {
		this.win = win;
		
		this.setFocusable(true);
		win.setTitle("player");
		
		win.setSize(1024, 768);
		win.setResizable(false);
		win.setVisible(true);
		win.setLocationRelativeTo(null);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//	아래와 같이 이미지 불러오는 방식 조정 요망
		
		/*		
		String path = System.getProperty("user.dir") + "\\miniproject\\images\\";

		mainMartBackGround = new ImageIcon(path + "bg\\maintown.png").getImage();
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
			

*/
		String path = System.getProperty("user.dir") + "\\miniproject\\images\\";
		
		
		mainTownBackGround = new ImageIcon(path + "maintown.png").getImage(); 
		player = new ImageIcon(path + "downstop.png").getImage();
		imgMainTown = new ImageIcon(path + "maintown.png").getImage().getScaledInstance(50, 50, 0); // �ܺ� ���� �̹���
		imgPlayerUp = new ImageIcon(path + "upstop.png").getImage().getScaledInstance(50, 50, 0); // ĳ���� �̹���
		imgPlayerDown = new ImageIcon(path + "downstop.png").getImage().getScaledInstance(50, 50, 0); // ĳ���� �̹���
		imgPlayerLeft = new ImageIcon(path + "leftstop.png").getImage().getScaledInstance(50, 50, 0); // ĳ���� �̹���
		imgPlayerRight = new ImageIcon(path + "rightstop.png").getImage().getScaledInstance(50, 50, 0); // ĳ���� �̹���
		imgPlayerUping = new ImageIcon(path + "upgo.png").getImage().getScaledInstance(50,50, 0); // ĳ���� �̹���
		imgPlayerRighting = new ImageIcon(path + "rightgo.png").getImage().getScaledInstance(50, 50, 0); // ĳ���� �̹���
		imgPlayerLefting = new ImageIcon(path + "leftgo.png").getImage().getScaledInstance(50, 50, 0); // ĳ���� �̹���
		imgPlayerDowning = new ImageIcon(path + "downgo.png").getImage().getScaledInstance(50, 50, 0); // ĳ���� �̹���
		imgPlayerStop = new ImageIcon(path + "downstop.png").getImage().getScaledInstance(50, 50, 0); // ĳ���� �̹���
		
		
//		imgNPC = new ImageIcon(path + "downstop.png").getImage().getScaledInstance(50, 50, 0); // npc �̹���

		
		
		
		//Main.class.getResource(name) 
		
		
		//
		x = 10;
		y = 10;

		
		this.addKeyListener(this);
		th = new Thread(this);
		th.start();

	}
	
	public void paint(Graphics g) {
		screenImage = createImage(1024, 768);
		screenGraphics = screenImage.getGraphics(); //  
		doubleBuffered(screenGraphics);
		g.drawImage(screenImage , 0, 0, null);
		g.drawImage(player, x, y, null);
		g.drawImage(imgNPC, npcX,npcY,null);
	}
	
	public void doubleBuffered(Graphics g) {  //
		// 
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
	      
	      // �ʱ�ȭ
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
	      
	      // 
	      for(int i = 850; i < 900; i++) {
	    	  for(int j = 270; j < 300; j++) {
	    		  maxXY[i][j] = true;
	    	  }
	      }
	      // 
	      for(int i = 170; i < 230; i++) {
	    	  for(int j = 260; j < 300; j++) {
	    		  maxXY[i][j] = true;
	    	  }
	      }
	      
	      //
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

