package org.fuxin.view;

import java.net.Socket;

import javax.swing.JFrame;

import org.fuxin.thread.SendThread;

public class MainFrame extends JFrame{
	public MyPanel myPanel;
	public String uname;
	public Socket socket;
	public SendThread sendThread;
	
	public MainFrame(String uname, Socket socket)
	{
		this.uname=uname;
		this.socket=socket;
		//���ô��ڵ�����
		this.setSize(1200,700);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//���myPanel
		myPanel=new MyPanel();
		myPanel.setBounds(0,0,1200,700);
		this.add(myPanel);
		
		//��������Ϣ���߳�
		sendThread=new SendThread(socket,uname);
		sendThread.start();
	}
}
