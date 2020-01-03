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
		//�����������
		this.unameJLabel=new JLabel("�û���:");
		this.unameJTextField= new JTextField();
		this.btnJButton=new JButton("��½");
		this.cancelJButton=new JButton("ȡ��");
		//���ô�������
		this.setSize(400,300);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new GridLayout(2,2));
		
		//�������������
		this.add(unameJLabel);
		this.add(unameJTextField);
		this.add(btnJButton);
		this.add(cancelJButton);
		
		//�������������󣬰󶨵���ť��
		MyEvent myEvent=new MyEvent();
		this.btnJButton.addActionListener(myEvent);
	}

	class MyEvent implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			//�����¼
			//1������û���
			String uname=unameJTextField.getText();
			
			//2,����һ��SOCKET���ӷ�������
			try {
				Socket socket = new Socket("127.0.0.1",8888);
				
				//3����ת��������
				new MainFrame(uname,socket);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
}