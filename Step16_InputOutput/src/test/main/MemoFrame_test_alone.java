package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MemoFrame_test_alone extends JFrame {
	public static String msg;
	public MemoFrame_test_alone() {
	      this.setTitle("나의 프레임");
	      //프레임의 위치와 크기 설정 setBounds(x, y, width, height)
	      setBounds(100, 100, 500, 500); 
	      //종료 버튼을 눌렀을때 프로세스 전체가 종료 되도록 한다
	      setDefaultCloseOperation(EXIT_ON_CLOSE);
	      //레이아웃 매니저 객체 생성
	      BorderLayout layout = new BorderLayout(); //동서남북 중앙에 배치하는거!
	      //프레임의 레이아웃 매니저 설정
	      setLayout(layout);
	      
	     //TextField와 Button을 배치할 Panel객체
	      JPanel topPanel=new JPanel();  //UI를 배치할수있는 객체 (패널에 버튼과 Msg추가)
	      topPanel.setBackground(Color.YELLOW);
	      //TextField와 Button을 생성해서
	      JTextField inputMsg = new JTextField(10);
	      JButton sendBtn = new JButton("전송");
	      //Panel에 추가
	      topPanel.add(inputMsg);
	      topPanel.add(sendBtn);
	      //프레임의 위쪽에 Panel추가
	      add(topPanel, BorderLayout.NORTH); //topPanel을 북쪽에!
	      
	      JTextArea ta = new JTextArea();
	      //프레임의 가운데에 TextArea추가
	      add(ta, BorderLayout.CENTER);
	      Font font = new Font("Serif", Font.BOLD, 20);
	      ta.setFont(font);
	      
	      sendBtn.addActionListener((event)->{
	    	  //TextField에 입력한 문자열을 읽어온다
	    	  msg = inputMsg.getText();
	    	  String msg2 = msg;
	  		
	  		//memo.txt 파일을 만들기 위한 File객체 생성하기
	  		//File f = new File("C:\\Users\\acorn\\Desktop\\playground\\myFolder\\memo.txt");//절대경로 적어!
	  		//슬래시는 하나만써도 인식 = 슬래시 하나로 대체가능
	  		File f = new File("C:/Users/acorn/Desktop/playground/myFolder/test.txt");
	  		try {
	  			//만일 해당 파일이 존대하지않으면
	  			if(!f.exists()) {
	  				//새로 만들어라
	  				f.createNewFile();
	  				System.out.println("test.txt파일을 만들었습니다.");
	  			}
	  			//파일에 문자열을 출력하는 객체, 어떤파일에 문자열을 출력할지 대상을 전달해줘야함
	  			
	  			//new FrileWriter(File객체, append mode 여부)
	  			var fw = new FileWriter(f, true);
	  			//var fw = new FileWriter(f); //append가 디폴트는 false.
	  			fw.append(msg2);
	  			fw.append("\r\n"); ////개행기호
	  			fw.flush(); //실제출력
	  			fw.close(); //마무리
	  			System.out.println("test.txt파일에 문자열 기록!");
	  		} catch (IOException e) {
	  			e.printStackTrace();
	  		}
	    	  
	      });//버튼누르면 {}가 실행
	      
	      //화면상에 실제 보이도록 한다.
	      setVisible(true);
		
	}
	public static void main(String[] args) {
		
		new MemoFrame_test_alone() { };
		
		
	}
}
