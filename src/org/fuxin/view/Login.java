package org.fuxin.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame{
	
	private JLabel unameJLabel;
	
	private JTextField unameJTextField;
	
	private JButton btnJButton;

	private JButton cancelJButton;
	public Login()
	{
		//创建组件对象
		this.unameJLabel=new JLabel("用户名:");
		this.unameJTextField= new JTextField();
		this.btnJButton=new JButton("登陆");
		this.cancelJButton=new JButton("取消");
		//设置窗口属性
		this.setSize(400,300);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new GridLayout(2,2));
		
		//添加组件到窗口
		this.add(unameJLabel);
		this.add(unameJTextField);
		this.add(btnJButton);
		this.add(cancelJButton);
		
		//创建监听器对象，绑定到按钮上
		MyEvent myEvent=new MyEvent();
		this.btnJButton.addActionListener(myEvent);
	}

	class MyEvent implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			//点击登录
			//1，获得用户名
			String uname=unameJTextField.getText();
			
			//2,创建一个SOCKET连接服务器端
			try {
				Socket socket = new Socket("127.0.0.1",8888);
				
				//3，跳转到主窗口
				new MainFrame(uname,socket);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
}
