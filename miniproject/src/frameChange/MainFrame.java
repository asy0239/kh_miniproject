package frameChange;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	public JPanel01 jpanel01;
	public JPanel02 jpanel02;
	public Login login;
	public MainTown maintown;
	public MartIn martin;
	public MainFrame mf;
	
/*	public MainFrame() {
		setSize(1024, 768);
		jpanel01 = new JPanel01(mf);
		jpanel02 = new JPanel02(mf);
		login = new Login(mf);
		maintown = new MainTown(mf);
		martin = new MartIn(mf);
		
		add(jpanel01);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}*/
	
	public void change(String panelName) {
		
		if(panelName.equals("panel01")) {
			getContentPane().removeAll();
			getContentPane().add(jpanel01);
			revalidate();
			repaint();
		}
		if(panelName.equals("panel02")) {
			getContentPane().removeAll();
			getContentPane().add(jpanel02);
			revalidate();
			repaint();
		}
		
		if(panelName.equals("login")) {
			getContentPane().removeAll();
			getContentPane().add(login);
			revalidate();
			repaint();
		}
		
		if(panelName.equals("maintown")) {
			getContentPane().removeAll();
			getContentPane().add(maintown);
			revalidate();
			repaint();
		}
		
		if(panelName.equals("martin")) {
			getContentPane().removeAll();
			getContentPane().add(martin);
			revalidate();
			repaint();
		}
		
	}
	
}
