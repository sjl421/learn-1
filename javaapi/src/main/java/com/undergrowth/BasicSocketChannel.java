package com.undergrowth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;


/**
 * ���ӷ���ServerSocket
 * @author u1
 *
 */
public class BasicSocketChannel {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//���ڿͻ��˵�Socket���� ����
		Socket socket=new Socket();
		socket.connect(new InetSocketAddress(7777));
		BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream())); 
		System.out.println("��ȡ���ַ���Ϊ:"+reader.readLine());
		
	}

}
