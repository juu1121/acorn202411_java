package test.frame04;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame{
   //생성자
   public MyFrame() {
      //프레임의 제목 설정
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
    	  String msg = inputMsg.getText();
    	  //TextArea에 출력한다.
    	  ta.append(msg+"\r\n");//TextArea는 개행기호도 해석을 해준다.
      });//버튼누르면 {}가 실행
      
      //화면상에 실제 보이도록 한다.
      setVisible(true);
   }
   //main 메소드
   public static void main(String[] args) {
	   new MyFrame();
   }
}