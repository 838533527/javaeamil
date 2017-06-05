package mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	public static String myEmailAccount = "hutao1187@163.com";
	public static String myEmailPassword = "hutao1187";
	public static String myEmailSMTPHost = "smtp.163.com";
	
	public static void main(String[] args) throws Exception{
		//1.��������
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.smtp.host", myEmailSMTPHost);
		properties.setProperty("mail.smtp.auth", "true");
		
		//2.�������ô����Ự�������ں��ʼ�����������
		Session session = Session.getDefaultInstance(properties);
		session.setDebug(true);
		
		//3.����һ���ʼ�
		MimeMessage message = createMimeMessage(session,myEmailAccount,myEmailAccount);
		
		//4.����Session��ȡ�ʼ��������
		Transport transport = session.getTransport();
		
		//5.��������
		transport.connect(myEmailAccount, myEmailPassword);
		
		//6.�����ʼ�
		transport.sendMessage(message, message.getAllRecipients());
		
		//7.�ر�����
		transport.close();
		System.out.println("������������");
	}
	
	public static MimeMessage createMimeMessage(Session session,String sendMail,String receiveMail) throws Exception{
		//1.����һ���ʼ�
		MimeMessage message = new MimeMessage(session);
		
		//2.������
		message.setFrom(new InternetAddress(sendMail, "lustboy", "UTF-8"));
		
		//3.�ռ���
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail,"hutao","UTF-8"));
		
		//4.�ʼ�����
		message.setSubject("�����ʼ�����");
		
		//5.�ʼ�����
		message.setContent("hello world !!!", "text/html;charset=UTF-8");
		
		//6.���÷���ʱ��
		message.setSentDate(new Date());
		
		//7.��������
		message.saveChanges();
		
		return message;
	}
}
