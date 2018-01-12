package experiment7Tcp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.*;
import java.net.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;


public class MyTcp extends JFrame{
	private static final long serialVersionUID = 1L;
	private BufferedReader reader; // ����BufferedReader����
	private ServerSocket server; // ����ServerSocket����
	private Socket socket; // ����Socket����socket
	private JTextArea ta = new JTextArea(); // ����JtextArea����
	private JTextField tf = new JTextField(); // ����JtextField����
	Container cc; // ����Container����
	private PrintWriter writer; // ����PrintWriter�����
	
	public MyTcp(String title) { // ���췽��
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
				ta.append("������:"+tf.getText() + '\n');
				ta.setSelectionEnd(ta.getText().length());
				tf.setText(""); // ���ı������
			}
		});
	}
	
	

	void getserver() {
		try {
			server = new ServerSocket(8998); // ʵ����Socket����
			ta.append("�������׽����Ѿ������ɹ�"+'\n'); // �����Ϣ
			while (true) { // ����׽���������״̬
				ta.append("�ȴ��ͻ���������"+'\n'); // �����Ϣ
				socket = server.accept();
				connect();// ʵ����Socket����
				reader = new BufferedReader(new InputStreamReader(socket
						.getInputStream())); // ʵ����BufferedReader����
				getClienMessage(); // ����getClientMessage()����
				writer = new PrintWriter(socket.getOutputStream(), true);
			}
		} catch (Exception e) {
			e.printStackTrace(); // ����쳣��Ϣ
		}
	}
	
	private void getClienMessage() {
		try {
			while (true) { // ����׽���������״̬
				if (reader.ready()) {
					// ��ÿͻ�

					ta.setForeground(Color.blue);
					ta.append("�ͻ���:" +reader.readLine()+'\n');
					
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
	
	private void connect() { // �����׽��ַ���
		try { // ��׽�쳣
			writer = new PrintWriter(socket.getOutputStream(), true);
		} catch (Exception e) {
			e.printStackTrace(); // ����쳣��Ϣ
		}
	}
	
	public static void main(String[] args) { // ������
		MyTcp tcp = new MyTcp("������"); // �����������
		tcp.setSize(400, 400); // ���ô����С
		tcp.setVisible(true); // ��������ʾ
		tcp.getserver(); // ���÷���
	}

}








