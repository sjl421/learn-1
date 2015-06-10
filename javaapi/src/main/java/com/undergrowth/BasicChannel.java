package com.undergrowth;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BasicChannel {

	RandomAccessFile randomAccessFile,randomAccessFile2;
	FileChannel fileChannel,fileChannel2;
	ByteBuffer buffer, buffer2;

	/**
	 * ����֮ǰ���ļ� ����buffer
	 * 
	 * @throws FileNotFoundException
	 */
	@Before
	public void before() throws FileNotFoundException {
		randomAccessFile = new RandomAccessFile(ClassLoader.getSystemResource(
				"channel.xml").getFile(), "rw");
		randomAccessFile2 = new RandomAccessFile(ClassLoader.getSystemResource(
				"channel2.xml").getFile(), "rw");
		fileChannel = randomAccessFile.getChannel();
		fileChannel2 = randomAccessFile2.getChannel();
		buffer = ByteBuffer.allocate(1024);
		buffer2 = ByteBuffer.allocate(512);
	}

	/**
	 * ������ɺ� �ر��ļ�
	 * 
	 * @throws IOException
	 */
	@After
	public void after() throws IOException {
		fileChannel.close();
		fileChannel2.close();
		randomAccessFile.close();
		randomAccessFile2.close();
	}

	/**
	 * ���Զ�д
	 */
	@Test
	public void testRead() {
		// TODO Auto-generated method stub
		try {
			System.out.println(readBuffer(fileChannel, buffer));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * ���Ա�������� You can mark a given position in a Buffer by calling the
	 * Buffer.mark() method. You can then later reset the position back to the
	 * marked position by calling the Buffer.reset() method
	 * 
	 * @throws IOException
	 */
	@Test
	public void testMarkReset() throws IOException {
		int byteRead = fileChannel.read(buffer);
		if (byteRead != -1) {
			// ��תbufferģʽ
			buffer.flip();
			while (buffer.hasRemaining()) {
				char tmp = (char) buffer.get();
				// ������9�ַ���ʱ�� ���б�ע
				if (tmp == '9')
					buffer.mark();
				System.out.print(tmp);
			}
			// ��buffer��position��Ϊ9�ַ���λ��
			buffer.reset();
			System.out.println();
			System.out.println("��Ϊ9�ַ�����ʼλ�ÿ�ʼ��ȡ����");
			while (buffer.hasRemaining())
				System.out.print((char) buffer.get());
		}
	}

	/**
	 * ����equals��compareTo �������������ǱȽ�ʣ��Ԫ�� equals() Two buffers are equal if: 5.
	 * They are of the same type (byte, char, int etc.) 6. They have the same
	 * amount of remaining bytes, chars etc. in the buffer. 7. All remaining
	 * bytes, chars etc. are equal.
	 * 
	 * compareTo() The compareTo() method compares the remaining elements
	 * (bytes, chars etc.) of the two buffers, for use in e.g. sorting routines.
	 * A buffer is considered "smaller" than another buffer if: 8. The first
	 * element which is equal to the corresponding element in the other buffer,
	 * is smaller than that in the other buffer. 9. All elements are equal, but
	 * the first buffer runs out of elements before the second buffer does (it
	 * has fewer elements).
	 * 
	 * @throws IOException
	 */
	@Test
	public void testEqualsCompare() throws IOException {
		int byteRead = fileChannel.read(buffer);
		buffer2.put((byte) 'q');
		int byteRead2 = fileChannel.read(buffer2);
		if (byteRead != -1 && byteRead2 != -1) {
			buffer.flip();
			buffer2.flip();
			System.out.println("ʣ��Ԫ��");
			System.out.println(buffer.remaining());
			System.out.println(buffer2.remaining());
			// �Ƚ�����buffer�Ƿ����
			System.out.println();
			System.out.println(buffer.equals(buffer2));
			System.out.println(buffer.compareTo(buffer2));
		}
	}

	/**
	 * �������÷��� The Buffer.rewind() sets the position back to 0, so you can reread
	 * all the data in the buffer. The limit remains untouched, thus still
	 * marking how many elements (bytes, chars etc.) that can be read from the
	 * Buffer.
	 * 
	 * @throws IOException
	 */
	@Test
	public void testRewind() throws IOException {
		int byteRead = fileChannel.read(buffer);
		if (byteRead != -1) {
			// ��תbufferģʽ
			buffer.flip();
			while (buffer.hasRemaining())
				System.out.print((char) buffer.get());
			// ���¶�ȡbuffer
			System.out.println();
			System.out.println("���¶�ȡbuffer");
			// ��buffer��positon��Ϊ0
			buffer.rewind();
			while (buffer.hasRemaining())
				System.out.print((char) buffer.get());

		}
	}

	/**
	 * ���ļ�ͨ�������ݶ��뵽������ �ӻ����ж������� ���� If you call clear() the position is set back
	 * to 0 and the limit to capacity. In other words, the Buffer is cleared.
	 * The data in the Buffer is not cleared. Only the markers telling where you
	 * can write data into the Buffer are.
	 * 
	 * 
	 * compact() copies all unread data to the beginning of the Buffer. Then it
	 * sets position to right after the last unread element. The limit property
	 * is still set to capacity, just like clear() does. Now the Buffer is ready
	 * for writing, but you will not overwrite the unread data.
	 * 
	 * @param fileChannel
	 * @param buffer
	 * @return
	 * @throws IOException
	 */
	public String readBuffer(FileChannel fileChannel, ByteBuffer buffer)
			throws IOException {
		StringBuilder builder = new StringBuilder();
		// 1���������ݵ�������
		int byteRead = fileChannel.read(buffer);
		while (byteRead != -1) {
			// 2��ת�������ģʽ
			buffer.flip();
			// 3���ӻ����ж�������
			while (buffer.hasRemaining())
				builder.append((char) buffer.get());

			// 4�����������
			buffer.clear();
			byteRead = fileChannel.read(buffer);
		}
		// System.out.println(builder.toString());
		return builder.toString();
	}
	
	@Test
	public void testWriteBuffer() throws IOException{
		buffer.put((byte)'1');
		buffer.put((byte)'2');
		buffer.put((byte)'3');
		buffer.put((byte)'4');
		System.out.println(fileChannel.write(buffer));
	}
	
	/**
	 * Scatter��Gatherģʽ
	 * Scatter Read֧�ִ�һ��ͨ����ȡ�����������
	 * Gather Write֧�ִӶ��������������д�뵽һ��ͨ����
	 * @throws IOException
	 */
	@Test
	public void testScatterGather() throws IOException{
		//����buffer����
		ByteBuffer[] buffers={buffer,buffer2};
		//�����ݵ����������
		System.out.println(fileChannel.read(buffers));;
		//ת������ģʽ
		buffer.flip();
		buffer2.flip();
		//��ȡ��������
		System.out.println("����1");
		while(buffer.hasRemaining()) System.out.print((char)buffer.get());
        buffer.rewind();
        System.out.println();
        System.out.println("����1��2");
        while(buffer.hasRemaining()) System.out.print((char)buffer.get());
		while(buffer2.hasRemaining()) System.out.print((char)buffer2.get());
		buffer.rewind();
		buffer2.rewind();
		System.out.println();
		System.out.println("�ַ������");
		System.out.println(Charset.defaultCharset().decode(buffer));
		buffer.rewind();
		buffer2.rewind();
		//д��������
		fileChannel2.write(buffers);
		
	}
	
	/**
	 * ��һ��ͨ��ת������һ��ͨ��
	 * @throws IOException
	 */
	@Test
	public void testChannerTransfer() throws IOException{
		System.out.println(fileChannel2.transferFrom(fileChannel, 0, fileChannel.size()));;
	}
}
