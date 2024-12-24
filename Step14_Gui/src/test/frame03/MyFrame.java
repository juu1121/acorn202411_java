package test.frame03;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
	//필드
	int count; //0을 안 넣어도 자동으로 0이 들어감 (여기선언해도되고,ActionListener()안에 선언해도 됨! )
	  
   //생성자
   public MyFrame() {
      //프레임의 제목 설정
      this.setTitle("나의 프레임");
      //프레임의 위치와 크기 설정 setBounds(x, y, width, height)
      setBounds(100, 100, 500, 500); 
      //종료 버튼을 눌렀을때 프로세스 전체가 종료 되도록 한다
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      //레이아웃 매니저 객체 생성
      FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
      //프레임의 레이아웃 매니저 설정
      setLayout(layout);
      //JButton 객체 생성
      JButton countBtn = new JButton("0");
      //프레임의 add() 메소드 호출하면서 JButton 객체의 참조값을 전달하면 프레임에 버튼이 배치된다.
      add(countBtn);
      
       
      //버튼에 전달할 ActionListener 인터페이스type
      ActionListener listener = new ActionListener() { //ActionListener인터페이스여서 재정의!
    	  //필드
    	  //int count =0;
    	  
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("버튼을 눌렀다");
			//count를 1 증가시키고
			count++;
			//정수를 문자열로 변경한 다음 set Text() 메소드를 전달한다.
			countBtn.setText(Integer.toString(count)); //countBtn.setText스트링타입만 됨
			
			
			//countBtn.setText("오잉"); //버튼텍스트변경
		}
      };
      
      countBtn.addActionListener(listener); //인터페이스객체타입의 메소드가 자동호출
      //버튼 클릭할떄 매개변수에 값을 전달하면 -> listener를 전달하면 재정의한 메소드가 호출 
      
      
      //화면상에 실제 보이도록 한다.
      setVisible(true);
   }
   //main 메소드
   public static void main(String[] args) {
	   new MyFrame();
   }
}