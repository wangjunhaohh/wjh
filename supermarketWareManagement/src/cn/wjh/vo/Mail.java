package cn.wjh.vo;
import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
/**
 * �ʼ�����
 *     QQ����--->�������
 * @author shiyunpeng
 */
public class Mail extends Thread {
  private String mailAdr;//����
  private String content;//�ʼ�������
  private String subject;//�ʼ�����Ŀ
  public Mail(String mailAdr, String subject, String content) {
    super();
    this.mailAdr = mailAdr;
    this.subject = subject;
    this.content = content;
  }
  public Mail() {}
  @Override
  public void run() {
	  super.run();
	  try {
		  	sendMail(mailAdr, subject, content);
	  		} catch (Exception e) {
      e.printStackTrace();
	  	}
  }
  //llrupyofmlyibcbg
  private void sendMail(String mailAdr, String subject, String content) throws Exception {
    //���ܵ��ʼ��׽���Э�鹤��
    MailSSLSocketFactory sf = new MailSSLSocketFactory();
    sf.setTrustAllHosts(true);
    final Properties props = new Properties();
    // ��ʾSMTP�����ʼ�����Ҫ���������֤
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.host", "smtp.qq.com");
    // smtp��½���˺š����� ���迪��smtp��½
    props.setProperty("mail.debug", "true");
    props.put("mail.user", "853824636@qq.com");
    props.put("mail.password", "basjdniitaxtbbgg");
    // �ر���Ҫע�⣬Ҫ��sslЭ������Ϊtrue,����ᱨ530����
    props.put("mail.smtp.ssl.enable", "true");
    props.put("mail.smtp.ssl.socketFactory", sf);
    Authenticator authenticator = new Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        // �û���������
        String userName = props.getProperty("mail.user");
        String password = props.getProperty("mail.password");
        return new PasswordAuthentication(userName, password);
      }
    };
    // ʹ�û������Ժ���Ȩ��Ϣ�������ʼ��Ự
    Session mailSession = Session.getInstance(props, authenticator);
    // �����ʼ���Ϣ
    MimeMessage message = new MimeMessage(mailSession);
    // ���÷�����
    try {
      InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
      message.setFrom(form);
      // �����ռ���
      InternetAddress to = new InternetAddress(mailAdr);
      message.setRecipient(Message.RecipientType.TO, to);
      // �����ʼ�����
      message.setSubject(subject);
      // �����ʼ���������
      message.setContent(content, "text/html;charset=UTF-8");
      // �����ʼ�
      Transport.send(message);
    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
	  Stochastic s=new Stochastic();
	  Mail e = new Mail("853824636@qq.com", "�û���", "�������ʼ�����������ģ�����ԡ�ע����֤��:"+s.achieveCode());
	  e.start();
	 
  }
  
}