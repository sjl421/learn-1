package com.undergrowth;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * �ļ�ͨ��������
 * �ļ�ͨ��ֻ��ʹ������ģʽ
 * A FileChannel cannot be set into non-blocking mode. It always runs in blocking mode
 * @author u1
 *
 */
public class BasicFileChannel {

	RandomAccessFile randomAccessFile;
	FileChannel channel;
	ByteBuffer buffer;
	
	@Before
	public void before() throws IOException{
		randomAccessFile=new RandomAccessFile(ClassLoader.getSystemResource("selector.txt").getFile(), "rw");
		channel=randomAccessFile.getChannel();
		//ǿ��ˢ��
		channel.force(true);
		buffer=ByteBuffer.allocate(1024);
	}
	
	@After
	public void after() throws IOException{
		randomAccessFile.close();
		channel.close();
	}
	
	/**
	 * //1����ȡ����Buffer
		//2��ת��ģʽ
		//3����ȡBuffer
		//4�����Buffers
	 * @throws IOException 
	 */
	@Test
	public void readTest() throws IOException{
		System.out.println(read());
	}

	private String read() throws IOException {
		StringBuilder builder=new StringBuilder();
		int readByte=channel.read(buffer);
		while(readByte!=-1){
			//1����ȡ����Buffer
			//2��ת��ģʽ
			buffer.flip();
			//3����ȡBuffer
			byte[] datas=new byte[buffer.limit()];
			buffer.get(datas);
			//System.out.println(new String(datas));
			builder.append(new String(datas));
			//4�����Buffer
			buffer.clear();
		 readByte=channel.read(buffer);
		}
		 return builder.toString();
	}
	
	/**
	 * ���������ļ����ݻ�д���ļ���  
	 * ���ļ��Ŀ�ʼ�ط�д��
	 * @throws IOException
	 */
	@Test
	public void writeTest() throws IOException{
		//��ȡԭ���ַ���
		String originString=read();
		originString+=System.currentTimeMillis();
		//д�뵽buffer
		buffer.put(originString.getBytes());
		//ת��ģʽ
		buffer.flip();
		//��buffer�е�����д�뵽�ļ���
		channel.position(0);
		System.out.println("size:"+channel.size()+"\t"+"position:"+channel.position());
		while(buffer.hasRemaining()) channel.write(buffer);
		
	}
	
	@Test
	public void writeAsyncTest() throws IOException{
		//��ȡԭ���ַ���
	String originString=read();
	originString+=System.currentTimeMillis();
	//д�뵽buffer
	buffer.put(originString.getBytes());
	//ת��ģʽ
	buffer.flip();
	
	}
}
