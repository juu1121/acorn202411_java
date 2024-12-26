package test.frame01;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemoFrame extends JFrame {
	//생성자
	public MemoFrame(String title) {
		super(title);
		
		JPanel topPanel = new JPanel();
		JTextField inputMsg = new JTextField(30);
		JButton saveBtn = new JButton("save");
		
		//패널에 UI두개추가
		topPanel.add(inputMsg);
		topPanel.add(saveBtn);
		//프레임의 레이아웃설정
		setLayout(new BorderLayout());
		//프레임의 북쪽에 패널패치
		add(topPanel, BorderLayout.NORTH);
		//저장버튼에 리스너 함수등록
		saveBtn.addActionListener((event)->{
			//입력한 문자열 읽어오기
			String msg = inputMsg.getText();
			
			File f = new File("C:/Users/acorn/Desktop/playground/myFolder/MemoFrame.txt");
			try {
				//만일 해당 파일이 존대하지않으면
				if(!f.exists()) {
					//새로 만들어라
					f.createNewFile();
					System.out.println("MemoFrame.txt파일을 만들었습니다.");
				}
				//파일에 문자열을 출력하는 객체, 어떤파일에 문자열을 출력할지 대상을 전달해줘야함
				
				//new FrileWriter(File객체, append mode 여부)
				var fw = new FileWriter(f, true);
				//var fw = new FileWriter(f); //append가 디폴트는 false.
				fw.append(msg);
				fw.append("\r\n"); ////개행기호
				fw.flush(); //실제출력
				fw.close(); //마무리
				System.out.println("MemoFrame.txt파일에 문자열 기록!");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		});
	}
	
	public static void main(String[] args) {
		var f = new MemoFrame("메모프레임");
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
