package frameChange;

import javax.swing.JFrame;

public class Run {

	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
		
		mf.setSize(1024, 768);
		mf.jpanel01 = new JPanel01(mf);
		mf.jpanel02 = new JPanel02(mf);
		mf.login = new Login(mf);
		mf.maintown = new MainTown(mf);
		mf.martin = new MartIn(mf);
		
		mf.add(mf.jpanel01);
		
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}


