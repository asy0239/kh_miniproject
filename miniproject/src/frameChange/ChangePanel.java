package frameChange;

import javax.swing.JFrame;

import frameChange.cardGame.view.MiniPoker;

public class ChangePanel extends JFrame{
	
	public StartPage startpage;
	public NewUser newuser;
	public Login login;
	public MainTown maintown;
	public MartIn martin;
	public ChangePanel mf;
	public PlayerMain playerMain;
	public PlayerGame playerGame;
	public PlayerMart playerMart;
	public MiniPoker miniPoker;
	public oneTo50 oneTo50;
	
	public void change(String panelName, ChangePanel mf) {
		
		if(panelName.equals("startpage")) {
			getContentPane().removeAll();
			getContentPane().add(startpage);
			revalidate();
			repaint();
		}
		
		if(panelName.equals("newuser")) {
			newuser = new NewUser(mf);
			getContentPane().removeAll();
			getContentPane().add(newuser);
			revalidate();
			repaint();
		}
		
		if(panelName.equals("login")) {
			login = new Login(mf);
			getContentPane().removeAll();
			getContentPane().add(login);
			revalidate();
			repaint();
		}
		
		if(panelName.equals("maintown")) {
			maintown = new MainTown(mf);
			getContentPane().removeAll();
			getContentPane().add(maintown);
			revalidate();
			repaint();
		}
		
		if(panelName.equals("martin")) {
			martin = new MartIn(mf);
			getContentPane().removeAll();
			getContentPane().add(martin);
			revalidate();
			repaint();
		}
		if(panelName.equals("playerMain")) {
			playerMain = new PlayerMain(mf);
			getContentPane().removeAll();
			getContentPane().add(playerMain);
			revalidate();
			repaint();
		}
		if(panelName.equals("playerMart")) {
			playerMart = new PlayerMart(mf);
			getContentPane().removeAll();
			getContentPane().add(playerMart);
			revalidate();
			repaint();
		}
		if(panelName.equals("playerGame")) {
			playerGame = new PlayerGame(mf);
			getContentPane().removeAll();
			getContentPane().add(playerGame);
			revalidate();
			repaint();
		}
		if(panelName.equals("miniPoker")) {
			miniPoker = new MiniPoker(mf);
			getContentPane().removeAll();
			getContentPane().add(miniPoker);
			revalidate();
			repaint();
		}
		if(panelName.equals("oneTo50")) {
			oneTo50 = new oneTo50(mf);
			getContentPane().removeAll();
			getContentPane().add(oneTo50);
			revalidate();
			repaint();
		}
	}
	
}
