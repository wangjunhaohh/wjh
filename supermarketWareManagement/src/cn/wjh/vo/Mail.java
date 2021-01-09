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
 * 邮件发送
 *     QQ邮箱--->别的邮箱
 * @author shiyunpeng
 */
public class Mail extends Thread {
  private String mailAdr;//邮箱
  private String content;//邮件的内容
  private String subject;//邮件的题目
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
    //加密的邮件套接字协议工厂
    MailSSLSocketFactory sf = new MailSSLSocketFactory();
    sf.setTrustAllHosts(true);
    final Properties props = new Properties();
    // 表示SMTP发送邮件，需要进行身份验证
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.host", "smtp.qq.com");
    // smtp登陆的账号、密码 ；需开启smtp登陆
    props.setProperty("mail.debug", "true");
    props.put("mail.user", "853824636@qq.com");
    props.put("mail.password", "basjdniitaxtbbgg");
    // 特别需要注意，要将ssl协议设置为true,否则会报530错误
    props.put("mail.smtp.ssl.enable", "true");
    props.put("mail.smtp.ssl.socketFactory", sf);
    Authenticator authenticator = new Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        // 用户名、密码
        String userName = props.getProperty("mail.user");
        String password = props.getProperty("mail.password");
        return new PasswordAuthentication(userName, password);
      }
    };
    // 使用环境属性和授权信息，创建邮件会话
    Session mailSession = Session.getInstance(props, authenticator);
    // 创建邮件消息
    MimeMessage message = new MimeMessage(mailSession);
    // 设置发件人
    try {
      InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
      message.setFrom(form);
      // 设置收件人
      InternetAddress to = new InternetAddress(mailAdr);
      message.setRecipient(Message.RecipientType.TO, to);
      // 设置邮件标题
      message.setSubject(subject);
      // 设置邮件的内容体
      message.setContent(content, "text/html;charset=UTF-8");
      // 发送邮件
      Transport.send(message);
    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
	  Stochastic s=new Stochastic();
	  Mail e = new Mail("853824636@qq.com", "用户：", "如果这封邮件不是你操作的，请忽略。注册验证码:"+s.achieveCode());
	  e.start();
	 
  }
  
}