package frameChange;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JPanel01 extends JPanel{
	   
    private JButton jButton1; private JButton jButton2;
    private MainFrame win;
    
    public JPanel01(MainFrame win){
        this.win = win;
        setLayout(null);
        
        jButton1 = new JButton("로그인");
        jButton1.setSize(120,20);        
        jButton1.setLocation(10, 10);
        add(jButton1);
        
        jButton2 = new JButton("회원가입");
        jButton2.setSize(120,20);
        jButton2.setLocation(150, 10);
        add(jButton2);
        
        jButton1.addActionListener(/*new MyActionListener()*/new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("panel02");
				
			}
		});
        
        jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("login");
				
			}
		});
    }
//    class MyActionListener implements ActionListener {    // ��ư Ű ������ �г� 2�� ȣ��
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            win.change("panel02");
//        }
//     }
	
}

