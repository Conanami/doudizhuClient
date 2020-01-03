package org.fuxin.thread;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

//发送消息的线程
public class SendThread extends Thread{

	private String msg;
	
	private Socket socket;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public SendThread(Socket socket)
	{
		this.socket=socket;

	}
	
	public SendThread()
	{
		

	}
	
	public SendThread(Socket socket,String msg) {
		this.msg = msg;
		this.socket = socket;
	}

	public void run()
	{
		DataOutputStream dataOutputStream;
		try {
			dataOutputStream=
					new DataOutputStream(socket.getOutputStream());
			while(true)
			{
				//如果消息不为空
				if(msg!=null)
				{
					//发送消息
					dataOutputStream.writeUTF(msg);
					//消息内容清空
					msg=null;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
