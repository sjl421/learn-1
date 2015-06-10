package com.undergrowth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * ���Զ�·������ Selector
 * @author u1
 *
 */
public class BasicSelector {
	
	//��·������  ���7777��8888�˿�
	private Selector selector;
	private ServerSocketChannel channel7777,channel8888;
	
	@Before
	public void before() throws IOException{
		selector=Selector.open();
		//��7777�˿ڷ���ͨ��
		channel7777=ServerSocketChannel.open();
		//��7777�˿ڵķ������
		channel7777.socket().bind(new InetSocketAddress(7777));
		//����Ϊ������ģʽ
		channel7777.configureBlocking(false);
		//��ͨ��ע�ᵽ��·��������
		channel7777.register(selector,  SelectionKey.OP_ACCEPT);
		//��8888�˿ڷ���ͨ��
		channel8888=ServerSocketChannel.open();
		//��8888�˿ڵķ������
		channel8888.socket().bind(new InetSocketAddress(9999));
		//����Ϊ������ģʽ
		channel8888.configureBlocking(false);
		//��ע������
		channel8888.register(selector, SelectionKey.OP_ACCEPT);
	}
	
	/**
	 * �ر���Դ
	 * @throws IOException
	 */
	@After
	public void after() throws IOException{
		selector.close();
		channel7777.close();
		channel8888.close();
	}
	
	@Test
	public void select() throws IOException{
		//����ѭ��
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			System.out.println("�Ƿ�Ҫ����");
			String isGoString=reader.readLine();
			if("N".equalsIgnoreCase(isGoString)) break;
			System.out.println("�ȴ��¼�Դ����");
			//�ȴ�ע����¼�Դ����
			int readyChannel=selector.select();
			if(readyChannel==0) continue;
			System.out.println("��"+readyChannel+"��׼������");
			//��ȡ׼���õ�ͨ��
			Set<SelectionKey> selectionKeys=selector.selectedKeys();
			Iterator<SelectionKey> selectKeyIterator=selectionKeys.iterator();
			while (selectKeyIterator.hasNext()) {
				SelectionKey selectionKey = (SelectionKey) selectKeyIterator
						.next();
				//����ע����׼���õ��¼�Դ
				interestSet(selectionKey.interestOps());
				if(selectionKey.isAcceptable()){
					//���ͻ��˽�������ʱ  ��ȡsocket  ��д��Ϣ
					ServerSocketChannel serverSocketChannel=(ServerSocketChannel) selectionKey.channel();
					System.out.println(serverSocketChannel.socket().getLocalPort()+"�˿�\t"+"����Ȥ�Ĳ���:"+serverSocketChannel.validOps());
					Socket socket=serverSocketChannel.socket().accept();
					socket.getOutputStream().write("��selector�з��ظ��ͻ���".getBytes());
					socket.getOutputStream().flush();
					socket.close();
				}
				//�Ƴ��Ѿ�������¼�Դ
				selectKeyIterator.remove();
			}
		}
		
		
	}

	/**
	 * ����ע����׼���õ��¼�Դ
	 * @param interestOps
	 */
	private void interestSet(int interestSet) {
		// TODO Auto-generated method stub
		if((interestSet&SelectionKey.OP_ACCEPT)!=0) System.out.println("ע��Ŀɽ���");
		if((interestSet&SelectionKey.OP_CONNECT)!=0) System.out.println("ע��Ŀ�����");
		if((interestSet&SelectionKey.OP_READ)!=0) System.out.println("ע��Ŀɶ�");
		if((interestSet&SelectionKey.OP_WRITE)!=0) System.out.println("ע��Ŀ�д");
	}
	
	
}
