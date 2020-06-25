package frameChange;

import javax.swing.JFrame;

public class ChangePanel extends JFrame{
	
	public StartPage startpage;
	public NewUser newuser;
	public Login login;
	public MartIn martin;
	public ChangePanel mf;
	public PlayerMain playerMain;
	public PlayerGame playerGame;
	public PlayerMart playerMart;
	
	public void change(String panelName) {
		
		if(panelName.equals("startpage")) {
			getContentPane().removeAll();
			getContentPane().add(startpage);
			revalidate();
			repaint();
		}
		
		if(panelName.equals("newuser")) {
			getContentPane().removeAll();
			getContentPane().add(newuser);
			revalidate();
			repaint();
		}
		
		if(panelName.equals("login")) {
			getContentPane().removeAll();
			getContentPane().add(login);
			revalidate();
			repaint();
		}
		
		if(panelName.equals("martin")) {
			getContentPane().removeAll();
			getContentPane().add(martin);
			revalidate();
			repaint();
		}
		if(panelName.equals("playerMain")) {
			getContentPane().removeAll();
			getContentPane().add(playerMain);
			revalidate();
			repaint();
		}
		if(panelName.equals("playerMart")) {
			getContentPane().removeAll();
			getContentPane().add(playerMart);
			revalidate();
			repaint();
		}
		if(panelName.equals("playerGame")) {
			getContentPane().removeAll();
			getContentPane().add(playerGame);
			revalidate();
			repaint();
		}
		
	}
	
}
