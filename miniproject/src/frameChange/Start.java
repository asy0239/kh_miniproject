package frameChange;

import javax.swing.JFrame;

public class Start {

	public Start() {
		ChangePanel mf = new ChangePanel();
		
		mf.setSize(1024, 768);
		mf.startpage = new StartPage(mf);
		mf.newuser = new NewUser(mf);
		mf.login = new Login(mf);
		mf.martin = new MartIn(mf);
		mf.playerMain = new PlayerMain(mf);
		mf.playerMart = new PlayerMart(mf);
//		mf.playerGame = new PlayerGame(mf);
		mf.add(mf.startpage);
		
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}