package frameChange;

import javax.swing.JFrame;

import frameChange.cardGame.view.MiniPoker;

public class ChangePanel extends JFrame{
	
	public StartPage startpage;
	public NewUser newuser;
	public Login login;
	public FindPage findpage;
	public MainTown maintown;
	public MartIn martin;
	public ChangePanel mf;
	public PlayerMain playerMain;
	public PlayerGame playerGame;
	public PlayerMart playerMart;
	public MiniPoker miniPoker;
	public oneTo50 oneTo50;
	
	public void change(String panelName) {
		
		if(panelName.equals("startpage")) {
			getContentPane().removeAll();
			getContentPane().add(startpage);
			revalidate();
			repaint();
		}
		
		if(panelName.equals("newuser")) {
			newuser = new NewUser(this);
			getContentPane().removeAll();
			getContentPane().add(newuser);
			revalidate();
			repaint();
		}
		
		if(panelName.equals("login")) {
			login = new Login(this);
			getContentPane().removeAll();
			getContentPane().add(login);
			revalidate();
			repaint();
		}
		if(panelName.equals("FindPage")) {
			findpage = new FindPage(this);
			getContentPane().removeAll();
			getContentPane().add(findpage);
			revalidate();
			repaint();
		}
		if(panelName.equals("maintown")) {
			maintown = new MainTown(this);
			getContentPane().removeAll();
			getContentPane().add(maintown);
			revalidate();
			repaint();
		}
		
		if(panelName.equals("martin")) {
			martin = new MartIn(this);
			getContentPane().removeAll();
			getContentPane().add(martin);
			revalidate();
			repaint();
		}
		if(panelName.equals("playerMain")) {
			playerMain = new PlayerMain(this);
			getContentPane().removeAll();
			getContentPane().add(playerMain);
			revalidate();
			repaint();
		}
		if(panelName.equals("playerMart")) {
			playerMart = new PlayerMart(this);
			getContentPane().removeAll();
			getContentPane().add(playerMart);
			revalidate();
			repaint();
		}
		if(panelName.equals("playerGame")) {
			playerGame = new PlayerGame(this);
			getContentPane().removeAll();
			getContentPane().add(playerGame);
			revalidate();
			repaint();
		}
		if(panelName.equals("miniPoker")) {
			miniPoker = new MiniPoker(this);
			getContentPane().removeAll();
			getContentPane().add(miniPoker);
			revalidate();
			repaint();
		}
		if(panelName.equals("oneTo50")) {
			oneTo50 = new oneTo50(this);
			getContentPane().removeAll();
			getContentPane().add(oneTo50);
			revalidate();
			repaint();
		}
	}
	
}
