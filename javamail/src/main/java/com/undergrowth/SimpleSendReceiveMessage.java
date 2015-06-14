package com.undergrowth;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Header;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


/**
 * �򵥷��ͺͽ����ʼ�
 * @author u1
 *
 */
public class SimpleSendReceiveMessage {

	//�ʼ�ͨ�ŻỰ
	Session session;
	//�ʼ����մ������
	Store store;
	
	//�����ʼ����͵��˺�������
	String username="xxxxxxx";
	private String passwd="xxxxxx";
	private String receiveHost="imap.qq.com";
	private String sendHost="smtp.qq.com";
	
	/**
	 * �ʼ����ò��������ӽ����ʼ�������
	 * @throws MessagingException
	 */
	private void init() throws MessagingException{
		Properties properties=new Properties();
		//���÷��ͺͽ���Э��
		properties.put("mail.transport.protocal", "smtp");
		properties.put("mail.store.protocal", "imap");
		//����ssl�Ķ˿�
		properties.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.setProperty("mail.imap.socketFactory.fallback", "false");
		properties.setProperty("mail.imap.port", "993");
		properties.setProperty("mail.imap.socketFactory.port", "993");/*
		properties.put("mail.imap.port", "993");
		properties.put("mail.smtp.port", "465");*/
		//smtp��֤
		properties.put("mail.smtp.auth", "true");
		//���÷��ͺͽ��մ�����
		properties.put("mail.transport.class", "com.sun.mail.smtp.SMTPTransport");
		properties.put("mail.imap.class", "com.sun.mail.imap.IMAPStore");
		//���÷����ʼ�������
		properties.put("mail.smtp.host",sendHost);
		//��ȡ�ʼ�ͨ�ŻỰ
		Authenticator auth=new MailAuthenticator();
		session=Session.getDefaultInstance(properties,auth);
		session.setDebug(true);
		//��ȡ�����ʼ�����
		store=session.getStore("imap");
		//���ӽ����ʼ�������
		store.connect(receiveHost, null, null);
	}
	
	/**
	 * �ر��ʼ����շ�����
	 * @throws MessagingException
	 * @throws IOException 
	 */
	public void close() throws MessagingException, IOException
	{
		store.close();
		
	}
	
	/**
	 * ����һ��򵥵��ʼ�
	 * @param fromAddr
	 * @param toAddr
	 * @return
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public Message createSimpleMessage(String fromAddr,String toAddr) throws AddressException, MessagingException{
		//����һ���ʼ�
		MimeMessage message=new MimeMessage(session);
		//���÷����ߺͽ�����
		message.setFrom(new InternetAddress(fromAddr));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(toAddr));
		//��������
		message.setSubject("ʹ��JAVAMAIL�����ʼ�");
		//��������
		message.setSentDate(new Date(System.currentTimeMillis()));
		//��������
		message.setText("������2015-6-12����ְһ���ܣ�׼����һ�ݹ���");
		return message;
	}
	
	public Message createComplexMessage(String fromAddr,String toAddr) throws AddressException, MessagingException{
		//����һ���ʼ�
		MimeMessage message=new MimeMessage(session);
		//���÷����ߺͽ�����
		message.setFrom(new InternetAddress(fromAddr));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(toAddr));
		//��������
		message.setSubject("ʹ��JAVAMAIL�����ʼ�");
		//��������
		message.setSentDate(new Date(System.currentTimeMillis()));
		//��������
		Multipart mp=createMultiPart();
		message.setContent(mp);
		return message;
	}
	
	/**
	 * �������ӵ�����
	 * @return
	 * @throws MessagingException 
	 */
	private Multipart createMultiPart() throws MessagingException {
		// TODO Auto-generated method stub
		Multipart multipart=new MimeMultipart();
		
		//��һ��
		BodyPart bodyPart1=new MimeBodyPart();
		bodyPart1.setText("�������ӵ��ʼ�����Ϊ���Ĳ���");
		multipart.addBodyPart(bodyPart1);
		
		//�ڶ��� �Ը�����ʽ����
		MimeBodyPart bodyPart2=new MimeBodyPart();
		//���ø����Ĵ�����
		FileDataSource attachFile=new FileDataSource(ClassLoader.getSystemResource("attach.txt").getFile());
		DataHandler dh=new DataHandler(attachFile);
		bodyPart2.setDataHandler(dh);
		bodyPart2.setDisposition(Part.ATTACHMENT);
		bodyPart2.setFileName("test");
		multipart.addBodyPart(bodyPart2);
		
		return multipart;
	}

	/**
	 * �����ʼ�
	 * @param message
	 * @throws MessagingException
	 */
	public void send(Message message) throws MessagingException{
		Transport.send(message);
	}
	
	/**
	 * �����ʼ�
	 * @throws Exception 
	 */
	public void receive() throws Exception{
		browseMessageFromFolder("INBOX");
	}

	/**
	 * �����ʼ�����������ʼ�
	 * @param folderName
	 * @throws Exception
	 */
	private void browseMessageFromFolder(String folderName) throws Exception {
		// TODO Auto-generated method stub
		Folder folder=store.getFolder(folderName);
		if(folder==null) throw new Exception(folderName+"�ʼ��в�����");
		browseMessageFromFolder(folder);
	}

	/**
	 * �����ʼ��ж�������ʼ�
	 * @param folder
	 * @throws MessagingException 
	 * @throws IOException 
	 */
	private void browseMessageFromFolder(Folder folder) throws MessagingException, IOException {
		// TODO Auto-generated method stub
		folder.open(Folder.READ_ONLY);
		System.out.println("�ܹ���"+folder.getMessageCount()+"���ʼ�");
		System.out.println("�ܹ���"+folder.getUnreadMessageCount()+"��δ���ʼ�");
		Message[] messages=folder.getMessages();
		for (int i = 1; i <=messages.length; i++) {
			System.out.println("���ǵ�"+i+"���ʼ�");
			getMessageHeader(folder.getMessage(i));
			writeSubjectToOutPutStream(folder.getMessage(i));;
		}
		folder.close(false);
	}
	
	/**
	 * ����ÿ���ʼ���ͷ������
	 * @param message
	 * @throws MessagingException 
	 */
	private void getMessageHeader(Message message) throws MessagingException {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		Enumeration<Header> allHeader=message.getAllHeaders();
		for(;allHeader.hasMoreElements();){
			Header header=allHeader.nextElement();
			System.out.println(header.getName()+":"+header.getValue());
		}
	}

	/**
	 * ��ÿ���ʼ�������д���������
	 * @param message
	 * @throws MessagingException 
	 */
	private void writeSubjectToOutPutStream(Message message) throws MessagingException {
		// TODO Auto-generated method stub
		System.out.println("�ʼ�����Ϊ:"+message.getSubject());
	}

	public static void main(String[] args){
		SimpleSendReceiveMessage sendReceiveMessage=new SimpleSendReceiveMessage();
		try {
			sendReceiveMessage.init();
			Message message=sendReceiveMessage.createSimpleMessage(sendReceiveMessage.username, sendReceiveMessage.username);
			sendReceiveMessage.send(message);
			message=sendReceiveMessage.createComplexMessage(sendReceiveMessage.username, sendReceiveMessage.username);
			sendReceiveMessage.send(message);
			sendReceiveMessage.receive();
			sendReceiveMessage.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * ��½��֤
	 * @author u1
	 *
	 */
	private class MailAuthenticator extends Authenticator{

		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			// TODO Auto-generated method stub
			return new PasswordAuthentication(username, passwd);
		}
		
	}
}
