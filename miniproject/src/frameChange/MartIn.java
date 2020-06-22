package miniProjectGame.frameChange;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import miniProjectGame.frameChange.MainTown.MyActionListener;

public class MartIn extends JPanel{
    private MainFrame win;
    
    public MartIn(MainFrame win) {
        setLayout(null);
        this.win = win;
        
		Image icon = new ImageIcon("images/martIn.png").getImage().getScaledInstance(1024, 600, 0);
		JLabel label = new JLabel(new ImageIcon(icon));
		label.setSize(1024,600);
		label.setLocation(0,100);
		
		add(label);
        
        JButton btn = new JButton("��ư");
        btn.setSize(70,20);
        btn.setLocation(10,10);
        add(btn);
        btn.addActionListener(new MyActionListener());
    }
    class MyActionListener implements ActionListener {         // ��ư Ű ������ �г� 1�� ȣ��
        @Override
        public void actionPerformed(ActionEvent e) {
            win.change("maintown");
        }
    }
	
}