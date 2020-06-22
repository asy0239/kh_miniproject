package miniProjectGame.frameChange;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import miniProjectGame.frameChange.JPanel02.MyActionListener;

public class MainTown extends JPanel{
    private MainFrame win;
    
    public MainTown(MainFrame win) {
        setLayout(null);
        this.win = win;
        
		Image icon = new ImageIcon("images/maintown.png").getImage().getScaledInstance(1024, 600, 0);
		JLabel label = new JLabel(new ImageIcon(icon));
		label.setSize(1024,600);
		label.setLocation(0,100);
		
		add(label);
		
        JButton btn = new JButton("버튼");
        btn.setSize(70,20);
        btn.setLocation(10,10);
        add(btn);
        btn.addActionListener(new MyActionListener());
        
        JButton btn2 = new JButton("로그인화면");
        btn2.setSize(70,20);
        btn.setLocation(100, 10);
        add(btn2);
        btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("panel01");
				
			}
		});
        
    }
    class MyActionListener implements ActionListener {         // 버튼 키 눌리면 패널 1번 호출
        @Override
        public void actionPerformed(ActionEvent e) {
            win.change("martin");
        }
    }
}
