package com.undergrowth;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

import org.junit.Before;
import org.junit.Test;

/**
 * 管道操作
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
		String string="通过管道进行传输数据";
		buffer.put(string.getBytes());
		buffer.flip();
		//将数据写入接受的通道中
		while(buffer.hasRemaining()) writePipe.write(buffer);
		//将数据从读的通道中读出
		ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
		StringBuilder builder=new StringBuilder();
		int readByte=readPipe.read(byteBuffer);
		byteBuffer.flip();
		byte[] dst=new byte[byteBuffer.limit()];
		byteBuffer.get(dst);
		builder.append(new String(dst));
		byteBuffer.clear();
		System.out.println("从读的通道中读出的数据为:"+builder.toString());
	}
}
