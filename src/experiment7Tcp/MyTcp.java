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
	private BufferedReader reader; // 创建BufferedReader对象
	private ServerSocket server; // 创建ServerSocket对象
	private Socket socket; // 创建Socket对象socket
	private JTextArea ta = new JTextArea(); // 创建JtextArea对象
	private JTextField tf = new JTextField(); // 创建JtextField对象
	Container cc; // 声明Container对象
	private PrintWriter writer; // 声明PrintWriter类对象
	
	public MyTcp(String title) { // 构造方法
		super(title); // 调用父类的构造方法
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cc = this.getContentPane(); // 实例化对象
		final JScrollPane scrollPane = new JScrollPane();      
		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(ta);
		cc.add(tf, "South"); // 将文本框放在窗体的下部		
		tf.addActionListener(new ActionListener() {
			// 绑定事件
			public void actionPerformed(ActionEvent e) {
				// 将文本框中信息写入流
				writer.println(tf.getText());
				// 将文本框中信息显示在文本域中
				ta.setForeground(Color.red);
				ta.append("服务器:"+tf.getText() + '\n');
				ta.setSelectionEnd(ta.getText().length());
				tf.setText(""); // 将文本框清空
			}
		});
	}
	
	

	void getserver() {
		try {
			server = new ServerSocket(8998); // 实例化Socket对象
			ta.append("服务器套接字已经创建成功"+'\n'); // 输出信息
			while (true) { // 如果套接字是连接状态
				ta.append("等待客户机的连接"+'\n'); // 输出信息
				socket = server.accept();
				connect();// 实例化Socket对象
				reader = new BufferedReader(new InputStreamReader(socket
						.getInputStream())); // 实例化BufferedReader对象
				getClienMessage(); // 调用getClientMessage()方法
				writer = new PrintWriter(socket.getOutputStream(), true);
			}
		} catch (Exception e) {
			e.printStackTrace(); // 输出异常信息
		}
	}
	
	private void getClienMessage() {
		try {
			while (true) { // 如果套接字是连接状态
				if (reader.ready()) {
					// 获得客户

					ta.setForeground(Color.blue);
					ta.append("客户端:" +reader.readLine()+'\n');
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace(); // 输出异常信息
		}
		try {
			if (reader != null) {
				reader.close(); // 关闭流
			}
			if (socket != null) {
				socket.close(); // 关闭套接字
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void connect() { // 连接套接字方法
		try { // 捕捉异常
			writer = new PrintWriter(socket.getOutputStream(), true);
		} catch (Exception e) {
			e.printStackTrace(); // 输出异常信息
		}
	}
	
	public static void main(String[] args) { // 主方法
		MyTcp tcp = new MyTcp("服务器"); // 创建本类对象
		tcp.setSize(400, 400); // 设置窗体大小
		tcp.setVisible(true); // 将窗体显示
		tcp.getserver(); // 调用方法
	}

}








