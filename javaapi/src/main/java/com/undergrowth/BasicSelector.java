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
 * 测试多路复用器 Selector
 * @author u1
 *
 */
public class BasicSelector {
	
	//多路复用器  检测7777和8888端口
	private Selector selector;
	private ServerSocketChannel channel7777,channel8888;
	
	@Before
	public void before() throws IOException{
		selector=Selector.open();
		//打开7777端口服务通道
		channel7777=ServerSocketChannel.open();
		//绑定7777端口的服务监听
		channel7777.socket().bind(new InetSocketAddress(7777));
		//配置为非阻塞模式
		channel7777.configureBlocking(false);
		//将通道注册到多路复用器上
		channel7777.register(selector,  SelectionKey.OP_ACCEPT);
		//打开8888端口服务通道
		channel8888=ServerSocketChannel.open();
		//绑定8888端口的服务监听
		channel8888.socket().bind(new InetSocketAddress(9999));
		//配置为非阻塞模式
		channel8888.configureBlocking(false);
		//关注读操作
		channel8888.register(selector, SelectionKey.OP_ACCEPT);
	}
	
	/**
	 * 关闭资源
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
		//控制循环
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			System.out.println("是否还要进行");
			String isGoString=reader.readLine();
			if("N".equalsIgnoreCase(isGoString)) break;
			System.out.println("等待事件源发生");
			//等待注册的事件源发生
			int readyChannel=selector.select();
			if(readyChannel==0) continue;
			System.out.println("有"+readyChannel+"个准备好了");
			//获取准备好的通道
			Set<SelectionKey> selectionKeys=selector.selectedKeys();
			Iterator<SelectionKey> selectKeyIterator=selectionKeys.iterator();
			while (selectKeyIterator.hasNext()) {
				SelectionKey selectionKey = (SelectionKey) selectKeyIterator
						.next();
				//遍历注册中准备好的事件源
				interestSet(selectionKey.interestOps());
				if(selectionKey.isAcceptable()){
					//当客户端进行连接时  获取socket  会写信息
					ServerSocketChannel serverSocketChannel=(ServerSocketChannel) selectionKey.channel();
					System.out.println(serverSocketChannel.socket().getLocalPort()+"端口\t"+"感兴趣的操作:"+serverSocketChannel.validOps());
					Socket socket=serverSocketChannel.socket().accept();
					socket.getOutputStream().write("从selector中返回给客户端".getBytes());
					socket.getOutputStream().flush();
					socket.close();
				}
				//移除已经处理的事件源
				selectKeyIterator.remove();
			}
		}
		
		
	}

	/**
	 * 遍历注册中准备好的事件源
	 * @param interestOps
	 */
	private void interestSet(int interestSet) {
		// TODO Auto-generated method stub
		if((interestSet&SelectionKey.OP_ACCEPT)!=0) System.out.println("注册的可接受");
		if((interestSet&SelectionKey.OP_CONNECT)!=0) System.out.println("注册的可连接");
		if((interestSet&SelectionKey.OP_READ)!=0) System.out.println("注册的可读");
		if((interestSet&SelectionKey.OP_WRITE)!=0) System.out.println("注册的可写");
	}
	
	
}
