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
 * 文件通道测试类
 * 文件通道只能使用阻塞模式
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
		//强制刷新
		channel.force(true);
		buffer=ByteBuffer.allocate(1024);
	}
	
	@After
	public void after() throws IOException{
		randomAccessFile.close();
		channel.close();
	}
	
	/**
	 * //1、读取数据Buffer
		//2、转换模式
		//3、读取Buffer
		//4、清除Buffers
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
			//1、读取数据Buffer
			//2、转换模式
			buffer.flip();
			//3、读取Buffer
			byte[] datas=new byte[buffer.limit()];
			buffer.get(datas);
			//System.out.println(new String(datas));
			builder.append(new String(datas));
			//4、清除Buffer
			buffer.clear();
		 readByte=channel.read(buffer);
		}
		 return builder.toString();
	}
	
	/**
	 * 将读出的文件内容回写到文件中  
	 * 从文件的开始地方写入
	 * @throws IOException
	 */
	@Test
	public void writeTest() throws IOException{
		//获取原有字符串
		String originString=read();
		originString+=System.currentTimeMillis();
		//写入到buffer
		buffer.put(originString.getBytes());
		//转换模式
		buffer.flip();
		//将buffer中的数据写入到文件中
		channel.position(0);
		System.out.println("size:"+channel.size()+"\t"+"position:"+channel.position());
		while(buffer.hasRemaining()) channel.write(buffer);
		
	}
	
	@Test
	public void writeAsyncTest() throws IOException{
		//获取原有字符串
	String originString=read();
	originString+=System.currentTimeMillis();
	//写入到buffer
	buffer.put(originString.getBytes());
	//转换模式
	buffer.flip();
	
	}
}
