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
		//1.����һ���ʼ�
		Properties properties = new Properties();
		Session session = Session.getDefaultInstance(properties);
		MimeMessage message = new MimeMessage(session);
		
		//2.From:������
		message.setFrom(new InternetAddress("838533527@qq.com", "lustboy", "UTF-8"));
		
		//3.To:�ռ���
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("838533527@qq.com", "hutao", "UTF-8"));
		
		//To:�����ռ��ˣ���ѡ��
		//message.addRecipient(MimeMessage.RecipientType.TO,new InternetAddress("", "", ""));
		
		//Cc:���ͣ���ѡ��
		//message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress("","",""));
		
		//Bcc:���ͣ���ѡ��
		//message.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress("","",""));
		
		//4.Subject:�ʼ�����
		message.setSubject("�����ʼ�����", "UTF-8");
		
		//5.�ʼ�����
		message.setContent("hello world...", "text/html;charset=UTF-8");
		
		//6.������ʾ�ʼ����͵�ʱ��
		message.setSentDate(new Date());
		
		//7.����ǰ�������
		message.saveChanges();
		
		//8.�����ʼ����浽����
		OutputStream out = new FileOutputStream("MyEmail.eml");
		message.writeTo(out);
		out.flush();
		out.close();
		System.out.println("���ͽ���");
	}
}
