package test.frame01;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Frame_alone extends JFrame {
	StringBuilder sb;
	JTextArea ta;
	String msg;
	//생성자
	public Frame_alone(String title) {
		super(title);
		
		JPanel topPanel = new JPanel();
		JTextField inputMsg = new JTextField(30);
		JButton saveBtn = new JButton("save");
		JButton saveBtn2 = new JButton("road");
		//패널에 UI두개추가
		topPanel.add(inputMsg);
		topPanel.add(saveBtn);
		topPanel.add(saveBtn2);
		//프레임의 레이아웃설정
		setLayout(new BorderLayout());
		//프레임의 북쪽에 패널패치
		add(topPanel, BorderLayout.NORTH);
		//저장버튼에 리스너 함수등록
		
		ta = new JTextArea();
		JScrollPane scroll = new JScrollPane(ta);
		add(scroll, BorderLayout.CENTER);
		
		sb = new StringBuilder();
		saveBtn.addActionListener((event)->{
			msg = inputMsg.getText();
			sb.append(msg);

		});
		
		saveBtn2.addActionListener((event)->{
			String result = sb.toString();
			ta.append(result);


		});
		
	}
	
	public static void main(String[] args) {
		var f = new Frame_alone("저장하는프레임");
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
