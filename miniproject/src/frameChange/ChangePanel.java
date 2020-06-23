package miniProjectGame.frameChange;

import javax.swing.JFrame;

public class ChangePanel extends JFrame{
	
	public StartPage startpage;
	public NewUser newuser;
	public Login login;
	public MainTown maintown;
	public MartIn martin;
	public ChangePanel mf;
	//
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
