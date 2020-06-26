package frameChange;

import java.awt.Window;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.PasswordAuthentication;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class PlainMail {
	final String user = "";
	final String password = "";
    public static String emailText = "";
    public static String emailText2 = "";
    
	public static void gmailSend(String email) {
        String user = "gimgeim331@gmail.com"; // ���̹��� ��� ���̹� ����, gmail��� gmail ����
        String password = "tnsrl785";   // �н�����
        
        // SMTP ���� ������ �����Ѵ�.
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com"); 
        prop.put("mail.smtp.port", 465); 
        prop.put("mail.smtp.auth", "true"); 
        prop.put("mail.smtp.ssl.enable", "true"); 
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        
        int randomValue = (int) (Math.random() * 8888) + 1111;
        emailText2 = Integer.toString(randomValue);
        emailText = emailText2;
        
        Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
        	String un=user; 
        	String pw=password; 
        	protected javax.mail.PasswordAuthentication getPasswordAuthentication() { 
        		return new javax.mail.PasswordAuthentication(un, pw); 
        		} 
        	});
        	
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));

            //�����ڸ����ּ�
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email)); 
            
            // Subject
            message.setSubject("이메일인증을 완료해주세요!"); //���� ������ �Է�

            // Text
//          message.setText("������ȣ : " + emailText2);    //���� ������ �Է�
            
            MimeMultipart multipart = new MimeMultipart("related");
            
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            String htmlText = "<img src=\"cid:image\">" +
            		"\n   " + "인증번호 : " + emailText2;
            messageBodyPart.setContent(htmlText, "text/html; charset=UTF-8");
            //"<img src=\"http://www.rgagnon.com/images/jht.gif\">"
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            DataSource fds = new FileDataSource("C:\\images\\image.jpg");
            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setHeader("Content-ID", "<image>");
            
            multipart.addBodyPart(messageBodyPart);
            
            message.setContent(multipart);
            
//            message.setContent("<img src=\"cid:///C:/Users/user/Desktop/HTML.html\">"
//            		+ "\n ������ȣ : "+ emailText2,
//            		"text/html; charset=UTF-8");
            
            // send the message
            Transport.send(message); ////����
            System.out.println("이메일 전송 완료!");
            
        } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
	}
}
