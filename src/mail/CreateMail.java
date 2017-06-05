package mail;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class CreateMail {
	
	public static void main(String[] args) throws Exception{
		//1.创建一封邮件
		Properties properties = new Properties();
		Session session = Session.getDefaultInstance(properties);
		MimeMessage message = new MimeMessage(session);
		
		//2.From:发件人
		message.setFrom(new InternetAddress("838533527@qq.com", "lustboy", "UTF-8"));
		
		//3.To:收件人
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("838533527@qq.com", "hutao", "UTF-8"));
		
		//To:增加收件人（可选）
		//message.addRecipient(MimeMessage.RecipientType.TO,new InternetAddress("", "", ""));
		
		//Cc:抄送（可选）
		//message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress("","",""));
		
		//Bcc:密送（可选）
		//message.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress("","",""));
		
		//4.Subject:邮件主题
		message.setSubject("测试邮件发送", "UTF-8");
		
		//5.邮件正文
		message.setContent("hello world...", "text/html;charset=UTF-8");
		
		//6.设置显示邮件发送的时间
		message.setSentDate(new Date());
		
		//7.保存前面的设置
		message.saveChanges();
		
		//8.将该邮件保存到本地
		OutputStream out = new FileOutputStream("MyEmail.eml");
		message.writeTo(out);
		out.flush();
		out.close();
		System.out.println("发送结束");
	}
}
