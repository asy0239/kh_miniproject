package frameChange;

import javax.swing.JPanel;

public class PlayerGame extends JPanel{

	private int i;		// 삭제하세요
	
	PlayerGame() {
		
		i=0;		// 삭제하세요
		
	}
	
}



// 이미지 따오는 부분 아래 내용 참조하여 수정 요망

/*

String path = System.getProperty("user.dir") + "\\miniproject\\images\\";

mainMartBackGround = new ImageIcon(path + "bg\\mainmart.png").getImage();
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