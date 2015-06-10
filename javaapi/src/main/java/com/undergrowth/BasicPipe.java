package com.undergrowth;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

import org.junit.Before;
import org.junit.Test;

/**
 * �ܵ�����
 * 
 * A Java NIO Pipe is a one-way data connection between two threads. A Pipe has
 * a source channel and a sink channel. You write data to the sink channel. This
 * data can then be read from the source channel
 * 
 * @author u1
 * 
 */
public class BasicPipe {

	Pipe pipe;
	Pipe.SinkChannel writePipe;
	Pipe.SourceChannel readPipe;
	ByteBuffer buffer;
	
	@Before
	public void before() throws IOException{
		pipe=Pipe.open();
		writePipe=pipe.sink();
		readPipe=pipe.source();
		buffer=ByteBuffer.allocate(1024);
	}
	
	@Test
	public void testPipe() throws IOException{
		String string="ͨ���ܵ����д�������";
		buffer.put(string.getBytes());
		buffer.flip();
		//������д����ܵ�ͨ����
		while(buffer.hasRemaining()) writePipe.write(buffer);
		//�����ݴӶ���ͨ���ж���
		ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
		StringBuilder builder=new StringBuilder();
		int readByte=readPipe.read(byteBuffer);
		byteBuffer.flip();
		byte[] dst=new byte[byteBuffer.limit()];
		byteBuffer.get(dst);
		builder.append(new String(dst));
		byteBuffer.clear();
		System.out.println("�Ӷ���ͨ���ж���������Ϊ:"+builder.toString());
	}
}
