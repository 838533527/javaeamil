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
		//1.参数配置
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.smtp.host", myEmailSMTPHost);
		properties.setProperty("mail.smtp.auth", "true");
		
		//2.根据配置创建会话对象，用于和邮件服务器交互
		Session session = Session.getDefaultInstance(properties);
		session.setDebug(true);
		
		//3.创建一封邮件
		MimeMessage message = createMimeMessage(session,myEmailAccount,myEmailAccount);
		
		//4.根据Session获取邮件传输对象
		Transport transport = session.getTransport();
		
		//5.链接邮箱
		transport.connect(myEmailAccount, myEmailPassword);
		
		//6.发送邮件
		transport.sendMessage(message, message.getAllRecipients());
		
		//7.关闭链接
		transport.close();
		System.out.println("。。。。。。");
	}
	
	public static MimeMessage createMimeMessage(Session session,String sendMail,String receiveMail) throws Exception{
		//1.创建一封邮件
		MimeMessage message = new MimeMessage(session);
		
		//2.发件人
		message.setFrom(new InternetAddress(sendMail, "lustboy", "UTF-8"));
		
		//3.收件人
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail,"hutao","UTF-8"));
		
		//4.邮件主题
		message.setSubject("测试邮件发送");
		
		//5.邮件正文
		message.setContent("hello world !!!", "text/html;charset=UTF-8");
		
		//6.设置发送时间
		message.setSentDate(new Date());
		
		//7.保存设置
		message.saveChanges();
		
		return message;
	}
}
