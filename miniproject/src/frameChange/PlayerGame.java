package frameChange;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlayerGame extends JPanel implements KeyListener, Runnable{
	   private Image screenImage;
	   private ChangePanel win;
	   private Graphics screenGraphics; 
	   private boolean playMove;
	   final int perMove = 20;
	   Thread th;
	
	   
	   // 아래와 같이 변수명 변경하였으니 확인 요망

	   
	   private int changeImg = 1;
	   
	   
	   
	   private Image mainTownBackGround, player, imgNPC, imgPlayerUp, imgPlayerUp1, imgPlayerUp2, imgPlayerDown,
	         imgPlayerDown1, imgPlayerDown2, imgPlayerLeft, imgPlayerLeft1, imgPlayerLeft2, imgPlayerRight,
	         imgPlayerRight1, imgPlayerRight2, imgTrash;
	   
	   

	   private int x, y;   

	   private int status;

	   
	   
	   public PlayerGame(ChangePanel win) {
	      this.win = win;
	      
	      this.setFocusable(true);
	      win.setTitle("player");
	      
	      win.setSize(1024, 768);
	      win.setResizable(false);
	      win.setVisible(true);
	      win.setLocationRelativeTo(null);
	      win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	//   아래와 같이 이미지 불러오는 방식 조정 요망
	      
	         
	      String path = System.getProperty("user.dir") + "\\images\\";

	      mainTownBackGround = new ImageIcon(path + "bg\\gametown.png").getImage();
	      player = new ImageIcon(path + "character\\downStand.png").getImage();

	      imgPlayerUp = new ImageIcon(path + "character\\upStand.png").getImage();
	      imgPlayerUp1 = new ImageIcon(path + "character\\upLeft.png").getImage();
	      imgPlayerUp2 = new ImageIcon(path + "character\\upRight.png").getImage();

	      imgPlayerDown = new ImageIcon(path + "character\\downStand.png").getImage();
	      imgPlayerDown1 = new ImageIcon(path + "character\\downLeft.png").getImage();
	      imgPlayerDown2 = new ImageIcon(path + "character\\downRight.png").getImage();

	      imgPlayerLeft = new ImageIcon(path + "character\\leftStand.png").getImage();
	      imgPlayerLeft1 = new ImageIcon(path + "character\\leftLeft.png").getImage();
	      imgPlayerLeft2 = new ImageIcon(path + "character\\leftRight.png").getImage();

	      imgPlayerRight = new ImageIcon(path + "character\\rightStand.png").getImage();
	      imgPlayerRight1 = new ImageIcon(path + "character\\rightLeft.png").getImage();
	      imgPlayerRight2 = new ImageIcon(path + "character\\rightRight.png").getImage();

	    
	         
      
      
      

      
      
      // ĳ���� �ʱ� ��ġ
      x = 440;
      y = 660;

      
      this.addKeyListener(this);
      th = new Thread(this);
      th.start();

   }
   
   public void paint(Graphics g) {
      screenImage = createImage(1024, 768);
      screenGraphics = screenImage.getGraphics();
      doubleBuffered(screenGraphics);
      g.drawImage(screenImage , 0, 0, null);
      g.drawImage(player, x, y, null);
    
   }
   
   public void doubleBuffered(Graphics g) { 
      // ���ۿ� �̸� �÷��� ������� �����ش�.
      g.drawImage(MoveImage(),x,y,null);
      g.drawImage(mainTownBackGround, 0, 0, null);
   
//      this.repaint();
   }
   
   
   
   @Override
   public void run() {
      
      // TODO Auto-generated method stub
      while(true) {
         try {
            Thread.sleep(50);
            this.requestFocus();
            repaint();
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
//   
//   for(int i = 0; )
   
   public Image MoveImage() {
         if (playMove == true) {

             switch (status) {
                     case 1:
                        if(changeImg == 1) {
                           player = imgPlayerUp1;
                           changeImg *= -1;
                        } else {
                           player = imgPlayerUp2;
                           changeImg *= -1;
                        }
                        break;
                     case 2:
                        if(changeImg == 1) {
                           player = imgPlayerDown1;
                           changeImg *= -1;                   
                        } else {
                           player = imgPlayerDown2;
                           changeImg *= -1;
                        }
                        break;
                     case 3:
                        if(changeImg == 1) {
                           player = imgPlayerLeft1;
                           changeImg *= -1;
                        } else {
                           player = imgPlayerLeft2;
                           changeImg *= -1;
                        }
                        break;
                     case 4:
                        if(changeImg == 1) {
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
         case KeyEvent.VK_SPACE:
        	 game1(x, y);
           
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
          
          for(int i = 410; i < 520; i++) {
             for(int j = 250; j < 700; j++) {
                maxXY[i][j] = true;
             }
          }
          
          for(int i = 20; i < 930; i++) {
             for(int j=250; j<590; j++) {
                maxXY[i][j] = true;
             }
          }

          return maxXY[x][y]; 
   }
   
   public void inMart(int x, int y) {
      if((x >= 420 && x <= 480) && (y >= 680 && y<= 700)) {
	         win.change("playerMain");
	      }
   }
   public void game1(int x, int y) {
	   if((x >= 240 && x <= 280) && ( y == 260)) {
		   win.change("numbergame");
	   }
	   if((x >= 560 && x <= 700) && (y == 260)) {
		   win.change("startpage");
	   }
   }
  
   
   
}

