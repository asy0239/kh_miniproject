package frameChange;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import frameChange.JPanel02.MyActionListener;

public class Login extends JPanel{
	
	 private JTextField textField;
	    private JPasswordField passwordField;
	    private MainFrame win;
	    
	    public Login(MainFrame win) {
	        setLayout(null);
	        this.win = win;
	        JLabel lblLbl = new JLabel("로그인 :");
	        lblLbl.setBounds(31, 40, 67, 15);
	        add(lblLbl);
	        
	        textField = new JTextField();
	        textField.setBounds(123, 40, 116, 21);
	        add(textField);
	        textField.setColumns(10);
	        
	        JLabel lblLbl_1 = new JLabel("회원가입:");
	        lblLbl_1.setBounds(31, 84, 67, 15);
	        add(lblLbl_1);
	        
	        passwordField = new JPasswordField();
	        passwordField.setBounds(123, 84, 116, 21);
	        add(passwordField);
	        
	        JButton btn = new JButton("회원가입");
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
