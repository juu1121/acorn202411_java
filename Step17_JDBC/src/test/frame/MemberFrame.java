package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MemberFrame extends JFrame implements ActionListener, PropertyChangeListener {
	// 필요한 필드 정의하기
	JTextField inputName, inputAddr;
	DefaultTableModel model;
	JTable table;
	
	// 생성자 (런되는시점에 {}의 코딩이 실행됨! )
	public MemberFrame(String title) {
		super(title);
		// 레이아웃 설정(BorderLayout)
		setLayout(new BorderLayout());
		// JLable 2개
		JLabel label2 = new JLabel("이름");
		JLabel label3 = new JLabel("주소");
		// JTextField 1row
		inputName = new JTextField(10);
		inputAddr = new JTextField(10);
		// JButton
		JButton addBtn = new JButton("추가쓰");
		JButton deleteBtn = new JButton("삭제");
		// 패널에 5개 UI배치
		JPanel panel = new JPanel();
		panel.add(label2);
		panel.add(inputName);
		panel.add(label3);
		panel.add(inputAddr);
		panel.add(addBtn);
		panel.add(deleteBtn);
		// 패널의 배경색설정
		panel.setBackground(Color.orange);

		// 패널의 프레임을 위쪽에 배치
		add(panel, BorderLayout.NORTH);

		// 버튼에 액션 리스너 등록
		addBtn.addActionListener(this); // 버튼을 누를때마다 actionPerformed의 메소드 실행
		deleteBtn.addActionListener(this);
		//버튼에 액션command설정
		addBtn.setActionCommand("add"); //액션커멘드는 내가 맘대로 설정가능!//저스트 식별자부여
		deleteBtn.setActionCommand("delete");
		
		// 회원 목록을 출력할 테이블
		table = new JTable();
		// 테이블의 컬럼명을 배열로 미리 준비한다.
		String[] colNames = { "번호", "이름", "주소" };
		// 테이블에 연결할 모델객체
	    //DefaultTableModel model = new DefaultTableModel(); //필드로 선언했음
		model = new DefaultTableModel() { //DefaultTableModel를 상속받은 익명의 클래스 (메소드를 재정의해서 사용하려고!)
			@Override
			public boolean isCellEditable(int row, int column) { //()에 전달되는 row번째로우의, column번쨰칼럼이 수정가능한지 true/false로 리턴
				//0번째 칼럼은 false를 리턴해서 수정불가능하게 만들고//0번째칼럼은 번호! 바뀌면 안 되는거여서 false를 리턴하게 만듦!
				if(column == 0) {
					return false;
				}else { //그 이외의 경우에는 true를 리턴해서 수정가능하게 만든다.
					return true;
				}
			}
		};
		
		model.setColumnIdentifiers(colNames);
		model.setRowCount(0);  //데이터가아무것도없을때 빈 로우생김
		
		// 모델을 테이블에 연결
		table.setModel(model);
		// 스크롤이 가능하도록 테이블을 JScrollPane에 감싼다.
		JScrollPane scroll = new JScrollPane(table);
		// JScrollPane을 프레임의 가운데에 배치하기
		add(scroll, BorderLayout.CENTER);

		// 샘플! 테이블에 출력되나 확인하려는 샘플데이터
		// JTable에 출력할 sample row 데이터(오브젝트배열에 row데이터 담기)
		// Object[] row = {1, "김구라", "노량진"};
		// 테이블에 연결된 모델에 row 추가하기
		// model.addRow(row);

		printMember();
		//칼럼의 제목 글자 조정
		table.getTableHeader().setFont(new Font("Sans-serif", Font.BOLD, 18));
		table.setFont(new Font("Sans-serif", Font.PLAIN, 16)); //데이터 글자 크기 16
		table.setRowHeight(25); //각 행의 높이를 조정
		
		table.addPropertyChangeListener(this);

	}//여기까지 생성자

	public static void main(String[] args) {
		MemberFrame f = new MemberFrame("회원정보 관리");
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {//발생한 이벤트의 정보가 ActionEvent타입객체에 담겨서 ()여기에 전달된다 
		//눌러진 버튼의 action command을 읽어온다.
		String command = e.getActionCommand();
		//action commane를 이용해서 분기한다.
		if(command.equals("add")) { //java에서는 문자열비교를 .equlas()메소드를 이용해서 비교한다.(자바스크립트에서는 command == "add")였지만, 자바에서는 메소드이용해야함!
			// 입력한 이름과 주소를 읽어온다.
			String name = inputName.getText(); //JTextField에 입력한값
			String addr = inputAddr.getText(); // JTextField의 참조값이 필드에 저장되어있다.
			// 입력한 이름과 주소를 MemberDto객체에 담는다.
			MemberDto dto = new MemberDto();
			dto.setName(name);
			dto.setAddr(addr);
			// MemberDao 객체를 생성해서
			MemberDao dao = new MemberDao();
			// insert()메소드를 이용해서 회원정보를DB에 저장한다.
			dao.insert(dto);
		}else if (command.equals("delete")) {
			//선택된 JTable Row가 있다면 몇번째 row가 선택되었는지 읽어와서
			int selectedRow = table.getSelectedRow(); //JTable의 메소드
			//첫번째로우를 선택한상태에서 삭제버튼누르면 ->0이 리턴 (인덱스를 얻어낼수있음)
			//아무것도 안 넣고 삭제버튼누르면 -> -1이 리턴
			if(selectedRow == -1) {
				JOptionPane.showMessageDialog(this, "삭제할 row선택하세요");//알림창 
				return;//메소드를 여기서 끝내기(리턴타입이 void기때문에 뒤에 명시할필요없음)
			}
			//삭제할 회원의 번호 (primary key)를 읽어온다.
			int num = (int)model.getValueAt(selectedRow, 0); 
			//숫자인데 오브젝트리턴되니까 캐스팅필요(진짜는 번호가 리턴됨_로우의인덱스, 컬럼의인덱스)
			//model이 가진 값 가져오기!
			
			new MemberDao().delete(num);
		}
		
		printMember(); //같은 코드를 위에서도 쓰니까 메소드로 만들었음!(DB의 회원목록을 테이블에 출력하는 메소드)
		//추가하거나 삭제한 다음 printMember();코드가 있으니까 -> ex)DB에서 삭제하고 ->불러오는메소드가 나오니가 :새로고침효과// db에서삭제된 후 그 내용이 프레임에 다시 출력!
	}

	// DB의 회원목록을 JTable에 출력하는 메소드
	public void printMember() {
		//기존에 출력된 내용을 초기화 한 후에 
		model.setRowCount(0);
		
		//테이블에 출력할 회원 정보 얻어도기
		MemberDao dao = new MemberDao();
		List<MemberDto> list = dao.getList();
		// 반복문돌면서
		for (MemberDto tmp : list) {
			// MemberDto객체에 담긴 회원정보를 이용해서 Object[]에 담은다음
			Object[] rowData = { tmp.getNum(), tmp.getName(), tmp.getAddr() };
			// 테이블에 연결된 모델에 추가하기
			model.addRow(rowData);
		}
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) { //얘가 실행되는시점은 row를수정하고->포커스를 잃을떄!
		/*
		 * property name이 "tableCellEditor"이고
		 * table이 수정중이 아닐때
		 * 현재 포커스가 있는 곳의 정보를 모두 읽어와서 DB에 수정반영하기
		 */
		if(evt.getPropertyName().equals("tableCellEditor") && !table.isEditing()) {
			//현재 포커스가 있는 row의 정보를 DB에 수정반영한다.
			//변화된 값을 읽어와서 DB에 반영한다.
			//수정된 칼럼에 있는 row전체의 값을 읽어온다.
			int selectedIndex=table.getSelectedRow();//현재선택된로우를 읽어와서 0번칼럼1번칼럼2번칼럼의 값을 담기
			int num=(int)model.getValueAt(selectedIndex, 0);
			String name = (String)model.getValueAt(selectedIndex, 1);
			String addr = (String)model.getValueAt(selectedIndex, 2);
			//읽어온 내용을 MemberDto에 담고
			MemberDto dto = new MemberDto();
			dto.setNum(num);
			dto.setName(name);
			dto.setAddr(addr);
			//MemberDao 객체를 이용해서 수정 반영한다.
			new MemberDao().update(dto);
			//선택된 포커스 해제
			table.clearSelection();
			
			
			
		}
		
	}

}
