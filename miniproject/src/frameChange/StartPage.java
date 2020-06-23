package miniProjectGame.frameChange;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class StartPage extends JPanel{
	   
    private JButton jButton1; private JButton jButton2;
    private ChangePanel win;
    
    public StartPage(ChangePanel win){
        this.win = win;
        setLayout(null);
        
        jButton1 = new JButton("ȸ������");
        jButton1.setSize(120,20);        
        jButton1.setLocation(10, 10);
        add(jButton1);
        
        jButton2 = new JButton("�α���");
        jButton2.setSize(120,20);
        jButton2.setLocation(150, 10);
        add(jButton2);
        
        jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("newuser");
				
			}
		});
        
        jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("login");
				
			}
		});
    }
	
}

