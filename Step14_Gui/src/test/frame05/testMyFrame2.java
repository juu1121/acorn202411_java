package test.frame05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class testMyFrame2 extends JFrame{
	//다른메소드에서 쓰기위해 필드로 만듦
	JTextArea ta;
	
   //생성자
   public testMyFrame2() {
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
      JTextField inputMsg = new JTextField(30);
      JButton sendBtn = new JButton("받아오기");
      //Panel에 추가
      topPanel.add(inputMsg);
      topPanel.add(sendBtn);
      //프레임의 위쪽에 Panel추가
      add(topPanel, BorderLayout.NORTH); //topPanel을 북쪽에!
      
      
      ta = new JTextArea();
      
      //TextArea를 Scroll패널에 감싼다.
      JScrollPane scroll = new JScrollPane(ta);
      
      //프레임의 가운데에 TextArea추가
      add(scroll, BorderLayout.CENTER);
      Font font = new Font("Serif", Font.BOLD, 20);
      ta.setFont(font);
      
      //버튼을 눌렀을때 호출되는 함수 등록
      sendBtn.addActionListener((event)->{
    	  //TextField에 입력한 문자열을 읽어온다
    	  String msg = inputMsg.getText();
    	  //미리 준비된 메소드를 호출하면서 입력한 문자열 등록
    	  request(msg); 
      });
      
      //화면상에 실제 보이도록 한다.
      setVisible(true);
   }
   //매개변수에 전달되는 주소로 요청을 하는 메소드
   public void request(String requesturl) {
	   try {
           // 요청 보낼 URL 설정
           URL url = new URL(requesturl); // url은 매개변수에 전달된 requesturl
           HttpURLConnection connection = (HttpURLConnection) url.openConnection();

           // HTTP 요청 메서드 설정
           connection.setRequestMethod("GET");

           // 헤더 설정 (필요에 따라 추가)
           connection.setRequestProperty("Accept", "application/json");

           // 응답 코드 확인
           int responseCode = connection.getResponseCode();
           System.out.println("Response Code: " + responseCode);
           //응답한 문자열을 누적시킬 객체 
           StringBuilder response = new StringBuilder();
           //만일 정상적인 응답이라면 
           if (responseCode == HttpURLConnection.HTTP_OK) {
           	//응답하는 내용을 읽어들일 객체 
           	BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));           
               //반복문 돌면서
           	while (true) {
               	//한줄씩 읽어들이고 
               	String line=br.readLine();
               	//만일 다 읽었다면 
               	if(line==null) {
               		break; //반복문 탈출
               	}
               	//읽은 문자열 한줄을 누적시킨다.
                   response.append(line+"\r\n");
               }
              
           } else {
               System.out.println("Request failed. Response Code: " + responseCode);
           }
           //누적된 문자열을 출력하기 
          // System.out.println(response.toString());
          //누적된 문자열을 TextArea에 출력하기
           ta.setText(response.toString());
           
           // 연결 해제
           connection.disconnect();

       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   //main 메소드
   public static void main(String[] args) {
	   new testMyFrame2();
   }
}