package test.frame03;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame03 extends JFrame implements ActionListener {
	//필드
	int count; //0을 안 넣어도 자동으로 0이 들어감 (여기선언해도되고,ActionListener()안에 선언해도 됨! )
	JButton countBtn; //null이 들어가있음
	//객체안에서 공유할 자원은 필드에 담아둠
	
   //생성자
   public MyFrame03() {
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
      //JButton countBtn = new JButton("0");  
      countBtn = new JButton("0");  //필드에 선언해서..this.countBtn인데, this가 생략된거임!
      
      //프레임의 add() 메소드 호출하면서 JButton 객체의 참조값을 전달하면 프레임에 버튼이 배치된다.
      add(countBtn);
     
  
      
      //MyFrame3 클래스는 implements ActionListener 인터페이스를 구현했기 떄문에 this전달가능
      countBtn.addActionListener(this); 
      //()에 ActionListener만 받아주는데, this는 (this...MyFrame3 /JFrame/Object)이런타입이어서 에러
      //MyFrame3가 ActionListener도 받을수있게 -> ActionListener를 implements함 -> 인터페이스니까 Override해야함
      //대신, 버튼을 누르면 밑에 Override된 메소드가 호출 
      
      //화면상에 실제 보이도록 한다.
      setVisible(true);
   }
   //main 메소드
   public static void main(String[] args) {
	   new MyFrame03();
   }
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("이게 호출");
		count++;
		countBtn.setText(Integer.toString(count));
		
	}
}