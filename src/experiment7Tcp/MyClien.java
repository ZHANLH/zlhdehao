package experiment7Tcp;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.border.*;

public class MyClien extends JFrame { // ������̳�JFrame��
	private static final long serialVersionUID = 1L;
	private BufferedReader reader; // ����BufferedReader����
	private PrintWriter writer; // ����PrintWriter�����
	Socket socket; // ����Socket����
	private JTextArea ta = new JTextArea(); // ����JtextArea����
	private JTextField tf = new JTextField(); // ����JtextField����
	Container cc; // ����Container����
	
	public MyClien(String title) { // ���췽��
		super(title); // ���ø���Ĺ��췽��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cc = this.getContentPane(); // ʵ��������

		final JScrollPane scrollPane = new JScrollPane();      
		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(ta);
		cc.add(tf, "South"); // ���ı�����ڴ�����²�
		tf.addActionListener(new ActionListener() {
			// ���¼�
			public void actionPerformed(ActionEvent e) {
				// ���ı�������Ϣд����
				writer.println(tf.getText());
				// ���ı�������Ϣ��ʾ���ı�����
				ta.setForeground(Color.red);
				ta.append("�ͻ���:"+tf.getText() + '\n');
				ta.setSelectionEnd(ta.getText().length());
				tf.setText(""); // ���ı������
			}
		});
	}
	


	private void connect() { // �����׽��ַ���
		ta.append("��������\n"); // �ı�������ʾ��Ϣ
		try { // ��׽�쳣
			socket = new Socket("127.0.0.1", 8998); // ʵ����Socket����
			writer = new PrintWriter(socket.getOutputStream(), true);
			ta.append("�������\n"); // �ı�������ʾ��Ϣ
			reader = new BufferedReader(new InputStreamReader(socket
					.getInputStream())); // ʵ����BufferedReader����
			getTcpMessage(); // ����getClientMessage()����
		} catch (Exception e) {
			e.printStackTrace(); // ����쳣��Ϣ
		}
	}
	
	private void getTcpMessage() {
		// TODO �Զ����ɵķ������
		try {
			while (true) { // ����׽���������״̬
				if (reader.ready()) {
					// ��ÿͻ�����Ϣ
					ta.setForeground(Color.blue);
					ta.append("������:" + reader.readLine()+'\n');
				}
			}
		} catch (Exception e) {
			e.printStackTrace(); // ����쳣��Ϣ
		}
		try {
			if (reader != null) {
				reader.close(); // �ر���
			}
			if (socket != null) {
				socket.close(); // �ر��׽���
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	public static void main(String[] args) { // ������
		MyClien clien = new MyClien("�ͻ���"); // ������������
		clien.setSize(400, 400); // ���ô����С
		clien.setVisible(true); // ��������ʾ
		clien.connect(); // �������ӷ���
	}
}







