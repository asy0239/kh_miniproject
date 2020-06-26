package frameChange.cardGame.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import frameChange.ChangePanel;
import frameChange.cardGame.vo.Player;


public class MiniPoker extends JPanel{
	
//	Card[] cards;
//	String[] kinds = { "spade", "heart","diamond","clover","joker"};
	
	private ChangePanel mf;
	private JPanel mainPage;
	
	private JButton die; private JButton call;
	private JButton ddable; private JButton half;
	
	private JDialog dlog;
	private JLabel myMoney; private JLabel panDon;
	private JLabel comMoney;
	
	private JLabel myJocbo; private JLabel comJocbo;
	
	private JLabel turnTimer; int turnCho = 10;
	
	private JLabel myCard1;
	private JLabel myCard2;
	private JLabel myCard3;
	private JLabel myCard4;
	private JLabel myCard5;
	
	private JLabel comCard1;
	private JLabel comCard2;
	private JLabel comCard3;
	private JLabel comCard4;
	private JLabel comCard5;
	
	private JLabel start; Image[] images = new Image[6]; ImageIcon[] images2 = new ImageIcon[6];
	
	public static int myMoney1 = 100000;
	public static int comMoney1 = 100000;
	public static int panDon1 = 1000 * 2;
	public static int panDon2 = 1000 * 2;
	
	int kind; int number; int mypoint = 0; int compoint = 0;
	int jocbo[][] = new int[5][1]; Player[] players = new Player[2];
	int jocbo2[][] = new int[5][1];
	
	private boolean isDie = false;
	private boolean game = true;
	private boolean isWin = false;
	private boolean btnEn = false;
	private boolean stop = true;
	
	public static boolean myTurn = false;
	public static boolean comTurn = false;
	public static boolean turnExit = false;
	
	private Image icon; private Image icon2; private Image icon3;
	private Image icon4; private Image icon5;
	private ImageIcon icon1_1; private ImageIcon icon1_2; private ImageIcon icon1_3;
	private ImageIcon icon1_4; private ImageIcon icon1_5;
	private Image icon1_11; private Image icon1_21; private Image icon1_31;
	private Image icon1_41; private Image icon1_51;
	ImageIcon back;
	///////////////////////////////////////
	int random = 0; int random2 = 0;
	int[] cards = new int[7];
	int[] cards2 = new int[7];
	 ///////////////////////////////////////
	Buffer buffer = new Buffer();
	
	Thread t1 = new Producer(buffer);
	Thread t2 = new Consumer(buffer);
	
	public MiniPoker(ChangePanel mf) {
		this.mf = mf;
		this.mainPage = this;
        
/*		if(comTurn == true) {
			
			t1.start();
			
		} else {
			
			t2.start();
			
		}*/
		
		play();
		JButton gameSty = new JButton("나가기");
		dlog = new JDialog(mf, "게임설명", true);
		dlog.setSize(300, 300);
		dlog.setLocation(400, 400);
		dlog.setLayout(null);
//		dlog.setUndecorated(true);
		dlog.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		dlog.add(gameSty);
		dlog.setVisible(false);
		
		gameSty.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dlog.setVisible(false);
				dlog.dispose();
				
			}
		});
		
		this.setLayout(null);
		
		back = new ImageIcon("images/card/PokerTable.PNG");
		
		turnTimer = new JLabel(turnCho + "초");
		turnTimer.setSize(100,20);
		turnTimer.setLocation(950, 10);
		turnTimer.setFont(new Font("Serif", Font.BOLD, 16));
		turnTimer.setForeground(Color.WHITE);
		add(turnTimer);
		
		myMoney = new JLabel(myMoney1 + "원");
		myMoney.setSize(100,100);
		myMoney.setLocation(850, 600);
		myMoney.setFont(new Font("Serif", Font.BOLD, 20));
		myMoney.setForeground(Color.WHITE);
		add(myMoney);
		
		comMoney = new JLabel(comMoney1 + "원");
		comMoney.setSize(100,100);
		comMoney.setLocation(70, 0);
		comMoney.setFont(new Font("Serif", Font.BOLD, 20));
		comMoney.setForeground(Color.WHITE);
		add(comMoney);
		
		panDon = new JLabel(panDon1 + "원");
		panDon.setSize(100,100);
		panDon.setLocation(480, 310);
		panDon.setFont(new Font("Serif", Font.BOLD, 20));
		panDon.setForeground(Color.WHITE);
		add(panDon);
		
        die = new JButton("다이");
        die.setSize(256,30);        
        die.setLocation(0, 710);
        add(die);
        
        die.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("다이");
				sound("sound/music/die.wav");
				isDie = true;
				myTurn = true;
				comTurn = false;
				stop = false;
				die.setEnabled(false);
				call.setEnabled(false);
				ddable.setEnabled(false);
				half.setEnabled(false);
			}
		});
        
        call = new JButton("콜");
        call.setSize(256,30);
        call.setLocation(256, 710);
        add(call);
		
        call.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("콜");
				sound("sound/music/call.wav");
				panDon1 += panDon2;
				myMoney1 -= panDon2;
				panDon.setText(Integer.toString(panDon1));
				myMoney.setText(Integer.toString(myMoney1));
				panDon2 += panDon2;
				myTurn = true;
				comTurn = false;
				stop = false;
				
				if(myMoney1 < 0) {
					call.setEnabled(false);
					ddable.setEnabled(false);
					half.setEnabled(false);
				}
				
			}
		});
        
        ddable = new JButton("더블");
        ddable.setSize(256,30);
        ddable.setLocation(512, 710);
        add(ddable);
        
        ddable.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("더블");
				sound("sound/music/ddable.wav");
				panDon1 += panDon2 * 2;
				myMoney1 -= panDon2 * 2;
				panDon.setText(Integer.toString(panDon1));
				myMoney.setText(Integer.toString(myMoney1));
				panDon2 += panDon2 * 2;
				myTurn = true;
				comTurn = false;
				stop = false;
				
				if(myMoney1 < 0) {
					call.setEnabled(false);
					ddable.setEnabled(false);
					half.setEnabled(false);
				}
				
			}
		});
        
        half = new JButton("하프");
        half.setSize(256,30);
        half.setLocation(768, 710);
        add(half);
        
        half.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("하프");
				sound("sound/music/half.wav");
				panDon1 += panDon2 / 2;
				myMoney1 -= panDon2 / 2;
				panDon.setText(Integer.toString(panDon1));
				myMoney.setText(Integer.toString(myMoney1));
				panDon2 += panDon2 / 2;
				myTurn = true;
				comTurn = false;
				stop = false;
				
				if(myMoney1 < 0) {
					call.setEnabled(false);
					ddable.setEnabled(false);
					half.setEnabled(false);
				}
				
			}
		});
        
        this.setSize(1024, 768);
        mf.add(this);
        
        this.addKeyListener(new KeyAdapter() {
        	
        	@Override
        	public void keyPressed(KeyEvent e) {
        		
        		switch(e.getKeyCode()) {
        		
        		case KeyEvent.VK_F1 :

        			dlog.setVisible(true);
        			
        		case KeyEvent.VK_ESCAPE :
        			mf.change("playerGame");
        			
        		case KeyEvent.VK_SPACE :
        			
        			t1.start(); t2.start();
        			
        		}
        			
        	}
		});
        
	}
	
	public void paintComponent(Graphics g) {
        MiniPoker.this.requestFocus();
        MiniPoker.this.setFocusable(true);
		g.drawImage(back.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}
	
	public void addImage(int turn) {
		int zz = turn;
			
			if(zz == 1) {
//				icon = new ImageIcon("images/card/J_1.png").getImage().getScaledInstance(100, 150, 0);
				icon = images[0];
				myCard1 = new JLabel(new ImageIcon(icon));
				myCard1.setSize(80,140);
				myCard1.setLocation(289,502);
				
				add(myCard1);
				
//				icon2 = new ImageIcon("images/card/J_1.png").getImage().getScaledInstance(100, 150, 0);
				icon2 = images[1];
				myCard2 = new JLabel(new ImageIcon(icon2));
				myCard2.setSize(80,140);
				myCard2.setLocation(382,502);
				
				add(myCard2);	

			}
			if(zz == 2) {
//				icon3 = new ImageIcon("images/card/J_1.png").getImage().getScaledInstance(100, 150, 0);
				icon3 = images[2];
				myCard3 = new JLabel(new ImageIcon(icon3));
				myCard3.setSize(80,140);
				myCard3.setLocation(472,502);
				
				add(myCard3);	
				mf.repaint();

			}
			if(zz == 3) {
//				icon4 = new ImageIcon("images/card/J_1.png").getImage().getScaledInstance(100, 150, 0);
				icon4 = images[3];
				myCard4 = new JLabel(new ImageIcon(icon4));
				myCard4.setSize(80,140);
				myCard4.setLocation(566,502);
				
				add(myCard4);	
				mf.repaint();

			}
			if(zz == 4) {
//				icon5 = new ImageIcon("images/card/J_1.png").getImage().getScaledInstance(100, 150, 0);
				icon5 = images[4];
				myCard5 = new JLabel(new ImageIcon(icon5));
				myCard5.setSize(80,140);
				myCard5.setLocation(658,502);
				
				add(myCard5);	
				mf.repaint();

			}
		
		

	}
	
	public void addImage2(int turn) {
		int zz = turn;
		
		if(zz == 1) {
			///////////////////////////////////////////////��ǻ��
//			icon1_1 = new ImageIcon("images/card/green_back.png").getImage().getScaledInstance(80, 140, 0);
			icon1_1 = images2[0];
			icon1_11 = images2[0].getImage();
			icon1_11 = icon1_11.getScaledInstance(80, 140, Image.SCALE_DEFAULT);
			ImageIcon icon1 = new ImageIcon(icon1_11);
			comCard1 = new JLabel(icon1);
			comCard1.setSize(80,140);
			comCard1.setLocation(289,33);
			
			add(comCard1);
			
//			icon1_2 = new ImageIcon("images/card/green_back.png").getImage().getScaledInstance(80, 140, 0);
			icon1_2 = images2[1];
			icon1_21 = images2[1].getImage();
			icon1_21 = icon1_21.getScaledInstance(80, 140, Image.SCALE_DEFAULT);
			ImageIcon icon2 = new ImageIcon(icon1_21);
			comCard2 = new JLabel(icon2);
			comCard2.setSize(80,140);
			comCard2.setLocation(382,33);
			
			add(comCard2);
			mf.repaint();
		}
		if(zz == 2) {
			///////////////////////////////////////////////��ǻ��
			icon1_3 = new ImageIcon("images/card/green_back.png");
			icon1_31 = icon1_3.getImage();
			icon1_31 = icon1_31.getScaledInstance(80, 140, Image.SCALE_DEFAULT);
			ImageIcon icon3 = new ImageIcon(icon1_31);
			comCard3 = new JLabel(icon3);
			comCard3.setSize(80,140);
			comCard3.setLocation(474,33);
			
			add(comCard3);
			mf.repaint();
		}
		if(zz == 3) {
			//////////////////////////////////////////////��ǻ��
			icon1_4 = new ImageIcon("images/card/green_back.png");
			icon1_41 = icon1_4.getImage();
			icon1_41 = icon1_41.getScaledInstance(80, 140, Image.SCALE_DEFAULT);
			ImageIcon icon4 = new ImageIcon(icon1_41);
			comCard4 = new JLabel(icon4);
			comCard4.setSize(80,140);
			comCard4.setLocation(566,33);
			
			add(comCard4);
			mf.repaint();
		}
		if(zz == 4) {
			//////////////////////////////////////////////��ǻ��
			icon1_5 = new ImageIcon("images/card/green_back.png");
			icon1_51 = icon1_5.getImage();
			icon1_51 = icon1_51.getScaledInstance(80, 140, Image.SCALE_DEFAULT);
			ImageIcon icon5 = new ImageIcon(icon1_51);
			comCard5 = new JLabel(icon5);
			comCard5.setSize(80,140);
			comCard5.setLocation(658,33);
			
			add(comCard5);
			mf.repaint();
		}
		
	}
	
	public void exitImage() {
			
			///////////////////////////////////////////////��ǻ��
			icon1_3 = images2[2];
			icon1_31 = images2[2].getImage();
			icon1_31 = icon1_31.getScaledInstance(80, 140, Image.SCALE_DEFAULT);
			ImageIcon icon3 = new ImageIcon(icon1_31);
			comCard3.setIcon(icon3);
			mf.repaint();
			
			//////////////////////////////////////////////��ǻ��
			icon1_4 = images2[3];
			icon1_41 = images2[3].getImage();
			icon1_41 = icon1_41.getScaledInstance(80, 140, Image.SCALE_DEFAULT);
			ImageIcon icon4 = new ImageIcon(icon1_41);
			comCard4.setIcon(icon4);
			mf.repaint();
			
			//////////////////////////////////////////////��ǻ��
			icon1_5 = images2[4];
			icon1_51 = images2[4].getImage();
			icon1_51 = icon1_51.getScaledInstance(80, 140, Image.SCALE_DEFAULT);
			ImageIcon icon5 = new ImageIcon(icon1_51);
			comCard5.setIcon(icon5);

			mf.repaint();
		
	}
	
	public void play() {
		
		for(int i = 0; i < players.length; i++) {
			players[i] = new Player();
		}
		
		players[0].name = "user";
		players[1].name = "computer";
			
//		t1.start(); t2.start();
		
		int random = 0; int random2 = 0;
		int[] cards = new int[6];
		int[] cards2 = new int[6];
		
		String tmp = "";
			
/*		for(int q = 0; q < 5; q++) {
			random = (int) (Math.random() * 19);
			random2 = (int) (Math.random() * 19);
			cards[q] = random;
			cards2[q] = random2;
			
			for(int w = 0; w < q; w++) {
				
				if(cards[q]==cards[w]) {
					
					q--;
					
				}
				
			}
			
			for(int e = 0; e < q; e++) {
				
				if(cards2[q]==cards2[e]) {
					
					q--;
					
				}
				
			}
			players[0].cards[q] = cards[q];
			players[1].cards2[q] = cards2[q];
		}*/
		
		for(int q = 0; q < 5; q++) {
			random = (int) (Math.random() * 19);
			cards[q] = random;
			
			for(int w = 0; w < q; w++) {
				
				if(cards[q]==cards[w]) {
					
					q--;
					
				}
				
			}
			players[0].cards[q] = cards[q];
		}
		
		for(int q = 0; q < 5; q++) {
			random2 = (int) (Math.random() * 19);
			cards2[q] = random2;
			
			for(int e = 0; e < q; e++) {
				
				if(cards2[q]==cards2[e]) {
					
					q--;
					
				}
				
			}
			players[1].cards2[q] = cards2[q];
		}
		
/*		for(int x = 0; x < 7; x++) {
			random2 = (int) (Math.random() * 19);
			cards2[x] = random2;
			
			for(int v = 0; v < x; v++) {
				
				if(cards[x] == cards2[v]) {
					
					x--;
					
				}
				
			}
			players[0].cards[x] = cards[x];
			players[1].cards2[x] = cards2[x];
		}*/
		
//		deck();
	}
	
	public void deck(int turn) {
		
		int zz = turn + 1;
		
		if(turn == 1) {
			for(int z = 0; z < 2; z++) {
				
				for(int pp = 0; pp < 1; pp++) {
					
					switch(players[0].cards[z]) {
					case 0 : 
					images[z] = new ImageIcon("images/card/a_Joker.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[0][0]++;
					break;
					case 1 :
					images[z] = new ImageIcon("images/card/b_Joker.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[0][0]++;
					break;
					case 2 :
					images[z] = new ImageIcon("images/card/J_1.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[1][0]++;
					break;
					case 3 :
					images[z] = new ImageIcon("images/card/J_2.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[1][0]++;
					break;
					case 4 :
					images[z] = new ImageIcon("images/card/J_3.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[1][0]++;
					break;
					case 5 :
					images[z] = new ImageIcon("images/card/J_4.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[1][0]++;
					break;
					case 6 :
					images[z] = new ImageIcon("images/card/Q_1.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[2][0]++;
					break;
					case 7 :
					images[z] = new ImageIcon("images/card/Q_2.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[2][0]++;
					break;
					case 8 :
					images[z] = new ImageIcon("images/card/Q_3.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[2][0]++;
					break;
					case 9 :
					images[z] = new ImageIcon("images/card/Q_4.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[2][0]++;
					break;
					case 10 :
					images[z] = new ImageIcon("images/card/K_1.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[3][0]++;
					break;
					case 11 :
					images[z] = new ImageIcon("images/card/K_2.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[3][0]++;
					break;
					case 12 :
					images[z] = new ImageIcon("images/card/K_3.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[3][0]++;
					break;
					case 13 : 
					images[z] = new ImageIcon("images/card/K_4.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[3][0]++;
					break;
					case 14 :
					images[z] = new ImageIcon("images/card/r_Joker.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[0][0]++;
					break;
					case 15 :
					images[z] = new ImageIcon("images/card/A_1.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[4][0]++;
					break;
					case 16 :
					images[z] = new ImageIcon("images/card/A_2.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[4][0]++;
					break;
					case 17 :
					images[z] = new ImageIcon("images/card/A_3.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[4][0]++;
					break;
					case 18 :
					images[z] = new ImageIcon("images/card/A_4.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[4][0]++;
					break;
					}

				}
				addImage(z);
				
			}
			
		} else {
			for(int z = turn; z < zz; z++) {
				
				for(int pp = 0; pp < 1; pp++) {
					
					switch(players[0].cards[z]) {
					case 0 : 
					images[z] = new ImageIcon("images/card/a_Joker.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[0][0]++;
					break;
					case 1 :
					images[z] = new ImageIcon("images/card/b_Joker.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[0][0]++;
					break;
					case 2 :
					images[z] = new ImageIcon("images/card/J_1.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[1][0]++;
					break;
					case 3 :
					images[z] = new ImageIcon("images/card/J_2.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[1][0]++;
					break;
					case 4 :
					images[z] = new ImageIcon("images/card/J_3.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[1][0]++;
					break;
					case 5 :
					images[z] = new ImageIcon("images/card/J_4.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[1][0]++;
					break;
					case 6 :
					images[z] = new ImageIcon("images/card/Q_1.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[2][0]++;
					break;
					case 7 :
					images[z] = new ImageIcon("images/card/Q_2.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[2][0]++;
					break;
					case 8 :
					images[z] = new ImageIcon("images/card/Q_3.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[2][0]++;
					break;
					case 9 :
					images[z] = new ImageIcon("images/card/Q_4.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[2][0]++;
					break;
					case 10 :
					images[z] = new ImageIcon("images/card/K_1.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[3][0]++;
					break;
					case 11 :
					images[z] = new ImageIcon("images/card/K_2.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[3][0]++;
					break;
					case 12 :
					images[z] = new ImageIcon("images/card/K_3.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[3][0]++;
					break;
					case 13 :
					images[z] = new ImageIcon("images/card/K_4.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[3][0]++;
					break;
					case 14 :
					images[z] = new ImageIcon("images/card/r_Joker.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[0][0]++;
					break;
					case 15 :
					images[z] = new ImageIcon("images/card/A_1.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[4][0]++;
					break;
					case 16 :
					images[z] = new ImageIcon("images/card/A_2.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[4][0]++;
					break;
					case 17 :
					images[z] = new ImageIcon("images/card/A_3.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[4][0]++;
					break;
					case 18 :
					images[z] = new ImageIcon("images/card/A_4.png").getImage().getScaledInstance(80, 140, 0);
					jocbo[4][0]++;
					break;
					}
					
				}

				addImage(z);
			}	
			
		}
		
		
/*		for(int b = 0; b < jocbo.length; b++) {
			
			for(int n = 0; n < 1; n++) {
				System.out.print("jocbo: " + jocbo[b][n]);
			}
			
			System.out.println();
		}
		System.out.println();
		for(int b = 0; b < jocbo2.length; b++) {
			
			for(int n = 0; n < 1; n++) {
				System.out.print("jocbo2: " + jocbo2[b][n]);
			}
			
			System.out.println();
		}*/
		
/*		System.out.println(myresult()); System.out.println(mypoint + " "); 
		System.out.println(comresult()); System.out.println(compoint + " ");
		System.out.println(isWin());*/
		
	}
	
	public void deck2(int turn) {
		int zz = turn +1;
		
		if(turn == 1) {
			
			for(int z = 0; z < 2; z++) {
				
				for(int pp = 0; pp < 1; pp++) {
					
					////////////////////////////////////////////////��ǻ��
					switch(players[1].cards2[z]) {
					case 0 : System.out.println("a_Joker");
					images2[z] = new ImageIcon("images/card/a_Joker.png");
					jocbo2[0][0]++;
					break;
					case 1 : System.err.println("b_Joker");
					images2[z] = new ImageIcon("images/card/b_Joker.png");
					jocbo2[0][0]++;
					break;
					case 2 : System.out.println("J_1");
					images2[z] = new ImageIcon("images/card/J_1.png");
					jocbo2[1][0]++;
					break;
					case 3 : System.out.println("J_2");
					images2[z] = new ImageIcon("images/card/J_2.png");
					jocbo2[1][0]++;
					break;
					case 4 : System.out.println("J_3");
					images2[z] = new ImageIcon("images/card/J_3.png");
					jocbo2[1][0]++;
					break;
					case 5 : System.out.println("J_4");
					images2[z] = new ImageIcon("images/card/J_4.png");
					jocbo2[1][0]++;
					break;
					case 6 : System.out.println("Q_1");
					images2[z] = new ImageIcon("images/card/Q_1.png");
					jocbo2[2][0]++;
					break;
					case 7 : System.out.println("Q_2");
					images2[z] = new ImageIcon("images/card/Q_2.png");
					jocbo2[2][0]++;
					break;
					case 8 : System.out.println("Q_3");
					images2[z] = new ImageIcon("images/card/Q_3.png");
					jocbo2[2][0]++;
					break;
					case 9 : System.out.println("Q_4");
					images2[z] = new ImageIcon("images/card/Q_4.png");
					jocbo2[2][0]++;
					break;
					case 10 : System.out.println("K_1");
					images2[z] = new ImageIcon("images/card/K_1.png");
					jocbo2[3][0]++;
					break;
					case 11 : System.out.println("K_2");
					images2[z] = new ImageIcon("images/card/K_2.png");
					jocbo2[3][0]++;
					break;
					case 12 : System.out.println("K_3");
					images2[z] = new ImageIcon("images/card/K_3.png");
					jocbo2[3][0]++;
					break;
					case 13 : System.out.println("K_4");
					images2[z] = new ImageIcon("images/card/K_4.png");
					jocbo2[3][0]++;
					break;
					case 14 : System.out.println("r_Joker");
					images2[z] = new ImageIcon("images/card/r_Joker.png");
					jocbo2[0][0]++;
					break;
					case 15 : System.out.println("A_1");
					images2[z] = new ImageIcon("images/card/A_1.png");
					jocbo2[4][0]++;
					break;
					case 16 : System.out.println("A_2");
					images2[z] = new ImageIcon("images/card/A_2.png");
					jocbo2[4][0]++;
					break;
					case 17 : System.out.println("A_3");
					images2[z] = new ImageIcon("images/card/A_3.png");
					jocbo2[4][0]++;
					break;
					case 18 : System.out.println("A_4");
					images2[z] = new ImageIcon("images/card/A_4.png");
					jocbo2[4][0]++;
					break;
					}
				}

				addImage2(z);
			}	
			
		} else {
			
			for(int z = turn; z < zz; z++) {
				
				for(int pp = 0; pp < 1; pp++) {
					
					////////////////////////////////////////////////��ǻ��
					switch(players[1].cards2[z]) {
					case 0 : System.out.println("a_Joker");
					images2[z] = new ImageIcon("images/card/a_Joker.png");
					jocbo2[0][0]++;
					break;
					case 1 : System.err.println("b_Joker");
					images2[z] = new ImageIcon("images/card/b_Joker.png");
					jocbo2[0][0]++;
					break;
					case 2 : System.out.println("J_1");
					images2[z] = new ImageIcon("images/card/J_1.png");
					jocbo2[1][0]++;
					break;
					case 3 : System.out.println("J_2");
					images2[z] = new ImageIcon("images/card/J_2.png");
					jocbo2[1][0]++;
					break;
					case 4 : System.out.println("J_3");
					images2[z] = new ImageIcon("images/card/J_3.png");
					jocbo2[1][0]++;
					break;
					case 5 : System.out.println("J_4");
					images2[z] = new ImageIcon("images/card/J_4.png");
					jocbo2[1][0]++;
					break;
					case 6 : System.out.println("Q_1");
					images2[z] = new ImageIcon("images/card/Q_1.png");
					jocbo2[2][0]++;
					break;
					case 7 : System.out.println("Q_2");
					images2[z] = new ImageIcon("images/card/Q_2.png");
					jocbo2[2][0]++;
					break;
					case 8 : System.out.println("Q_3");
					images2[z] = new ImageIcon("images/card/Q_3.png");
					jocbo2[2][0]++;
					break;
					case 9 : System.out.println("Q_4");
					images2[z] = new ImageIcon("images/card/Q_4.png");
					jocbo2[2][0]++;
					break;
					case 10 : System.out.println("K_1");
					images2[z] = new ImageIcon("images/card/K_1.png");
					jocbo2[3][0]++;
					break;
					case 11 : System.out.println("K_2");
					images2[z] = new ImageIcon("images/card/K_2.png");
					jocbo2[3][0]++;
					break;
					case 12 : System.out.println("K_3");
					images2[z] = new ImageIcon("images/card/K_3.png");
					jocbo2[3][0]++;
					break;
					case 13 : System.out.println("K_4");
					images2[z] = new ImageIcon("images/card/K_4.png");
					jocbo2[3][0]++;
					break;
					case 14 : System.out.println("r_Joker");
					images2[z] = new ImageIcon("images/card/r_Joker.png");
					jocbo2[0][0]++;
					break;
					case 15 : System.out.println("A_1");
					images2[z] = new ImageIcon("images/card/A_1.png");
					jocbo2[4][0]++;
					break;
					case 16 : System.out.println("A_2");
					images2[z] = new ImageIcon("images/card/A_2.png");
					jocbo2[4][0]++;
					break;
					case 17 : System.out.println("A_3");
					images2[z] = new ImageIcon("images/card/A_3.png");
					jocbo2[4][0]++;
					break;
					case 18 : System.out.println("A_4");
					images2[z] = new ImageIcon("images/card/A_4.png");
					jocbo2[4][0]++;
					break;
					}
				}

				addImage2(z);
			}	
			
		}
		
	}
	
	public String myresult() {
		
			if (jocbo[4][0] == 4) {
				mypoint += 20;
				return "A포카드!";
			} else if (jocbo[3][0] == 4) {
				mypoint += 19;
				return "K포카드!";
			} else if (jocbo[2][0] == 4) {
				mypoint += 18;
				return "Q포카드!";
			} else if (jocbo[1][0] == 4) {
				mypoint += 17;
				return "J포카드!";
			} else if(jocbo[0][0] == 3) {
				mypoint += 16;
				return "조커트리플!";
			} else if (jocbo[4][0] == 3) {
				mypoint += 15;
				return "A트리플!";
			} else if (jocbo[3][0] == 3) {
				mypoint += 14;
				return "K트리플!";
			} else if (jocbo[2][0] == 3) {
				mypoint += 13;
				return "Q트리플!";
			} else if (jocbo[1][0] == 3) {
				mypoint += 12;
				return "J트리플!";
			} else if (jocbo[0][0] == 2) {
				mypoint += 11;
				return "조커투페어!";
			} else if (jocbo[4][0] == 2) {
				mypoint += 10;
				return "A투페어!";
			} else if (jocbo[3][0] == 2) {
				mypoint += 9;
				return "K투페어!";
			} else if (jocbo[2][0] == 2) {
				mypoint += 8;
				return "Q투페어!";
			} else if (jocbo[1][0] == 2) {
				mypoint += 7;
				return "J투페어!";
			} else if (jocbo[0][0] == 1) {
				mypoint += 6;
				return "조커원페어!";
			} else if (jocbo[4][0] == 1) {
				mypoint += 5;
				return "A원페어!";
			} else if (jocbo[3][0] == 1) {
				mypoint += 4;
				return "K원페어!";
			} else if (jocbo[2][0] == 1) {
				mypoint += 3;
				return "Q원페어!";
			} else if (jocbo[1][0] == 1) {
				mypoint += 2;
				return "J원페어!";
			}		
			
		return "";
		
	}
	
	public String comresult() {
		
		if (jocbo2[4][0] == 4) {
			compoint += 20;
			return "A포카드!";
		} else if (jocbo2[3][0] == 4) {
			compoint += 19;
			return "K포카드!";
		} else if (jocbo2[2][0] == 4) {
			compoint += 18;
			return "Q포카드!";
		} else if (jocbo2[1][0] == 4) {
			compoint += 17;
			return "J포카드!";
		} else if(jocbo2[0][0] == 3) {
			compoint += 16;
			return "조커트리플!";
		} else if (jocbo2[4][0] == 3) {
			compoint += 15;
			return "A트리플!";
		} else if (jocbo2[3][0] == 3) {
			compoint += 14;
			return "K트리플!";
		} else if (jocbo2[2][0] == 3) {
			compoint += 13;
			return "Q트리플!";
		} else if (jocbo2[1][0] == 3) {
			compoint += 12;
			return "J트리플!";
		} else if (jocbo2[0][0] == 2) {
			compoint += 11;
			return "조커투페어!";
		} else if (jocbo2[4][0] == 2) {
			compoint += 10;
			return "A투페어!";
		} else if (jocbo2[3][0] == 2) {
			compoint += 9;
			return "K투페어!";
		} else if (jocbo2[2][0] == 2) {
			compoint += 8;
			return "Q투페어!";
		} else if (jocbo2[1][0] == 2) {
			compoint += 7;
			return "J투페어!";
		} else if (jocbo2[0][0] == 1) {
			compoint += 6;
			return "조커원페어!";
		} else if (jocbo2[4][0] == 1) {
			compoint += 5;
			return "A원페어!";
		} else if (jocbo2[3][0] == 1) {
			compoint += 4;
			return "K원페어!";
		} else if (jocbo2[2][0] == 1) {
			compoint += 3;
			return "Q원페어!";
		} else if (jocbo2[1][0] == 1) {
			compoint += 2;
			return "J원페어!";
		}
		
		return "";
		
	}
	
	public String isWin() {
		
		if(mypoint > compoint) {
			
			return "나의 승리!";
		} else if (mypoint < compoint) {
			
			return "컴퓨터 승리!";
		} else {
			return "무승부!";
		}
	 
	}
	
	public void sound(String fileName) {
		
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileName));
			Clip clip = AudioSystem.getClip();
			clip.stop();
			clip.open(ais);
			clip.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
//��ǻ��
	class Producer extends Thread{

		private Buffer criticalData;
		
		public Producer(Buffer buffer) {
			this.criticalData = buffer;

		}
		
		@Override
		public void run() {

			for(int i = 1; i <= 4; i++) {
				criticalData.comTurn(i);
				
				if(i == 1) {
					
//					for(int ii = 0; ii < 2; ii++) {
//						random = (int) (Math.random() * 19);
//						players[1].cards2[ii] = random;
//					}
					
					deck2(i);
				} else if (i == 2) {
//					random = (int) (Math.random() * 19);
//					players[1].cards2[i] = random;
					
					deck2(i);
				} else if (i == 3) {
//					random = (int) (Math.random() * 19);
//					players[1].cards2[i] = random;
					
					deck2(i);
				} else if (i == 4) {
//					random = (int) (Math.random() * 19);
//					players[1].cards2[i] = random;
					
					deck2(i);
				}
				
				try {
					
					Thread.sleep(3000);
					
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		}
		
	}
//����
	class Consumer  extends Thread{
		private Buffer criticalData;
		
		public Consumer(Buffer buffer) {
			this.criticalData = buffer;
			
		}
		
		@Override
		public void run() {

			for(int i = 1; i <= 4; i++) {
				criticalData.myTurn();
				
				if(i == 1) {
					
					deck(i);
//					addImage(i);
				} else if (i == 2) {
					
					deck(i);
//					addImage(i);
					
				} else if (i == 3) {

					
					deck(i);
//					addImage(i);
					
				} else if (i == 4) {
					
					deck(i);
//					addImage(i);
					System.out.println("나의 족보: " + myresult());
					System.out.println("컴퓨터 족보: " + comresult());
					System.out.println(mypoint);
					System.out.println(compoint);
					System.out.println(isWin());
					
					if("나의 승리!".equals(isWin())) {
						
						exitImage();
						JOptionPane.showMessageDialog(null, "나의 족보: " + myresult() + "\n" + "컴퓨터 족보: " + comresult() + "\n   "
								+ "               승리","승리", JOptionPane.OK_CANCEL_OPTION);
						
					} else if("컴퓨터 승리!".equals(isWin())){
						
						exitImage();
						JOptionPane.showMessageDialog(null, "나의 족보: " + myresult() + "\n" + "컴퓨터 족보: " + comresult() + "\n   "
								+ "               패배","패배", JOptionPane.OK_CANCEL_OPTION);
						
					} else {
						
						exitImage();
						JOptionPane.showMessageDialog(null, "나의 족보: " + myresult() + "\n" + "컴퓨터 족보: " + comresult() + "\n   "
								+ "               무승부","무승부", JOptionPane.OK_CANCEL_OPTION);
						
					} 
					
				}
				
				try {
						
						if(stop == false) {
							interrupt();
						}
					
						Thread.sleep(1000);
						
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		
	}	
	
}



