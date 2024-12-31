package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import test.dao.FoodDao;
import test.dto.FoodDto;
import test.dto.MemberDto;

public class FoodFrame extends JFrame implements ActionListener {
	//필드
	JTextField inputFname, inputAddr;
	DefaultTableModel model;
	JTable table;
	
	//생성자
	public FoodFrame(String title) {
		super(title);
		
		//레이아웃
		setLayout(new BorderLayout());
		JLabel label1 = new JLabel("맛집이름");
		JLabel label2 = new JLabel("맛집위치");
		inputFname = new JTextField(10);
		inputAddr = new JTextField(10);
		
		JButton addBtn = new JButton("추가");
		JButton deleteBtn = new JButton("삭제");
		
		JPanel panel = new JPanel();
		panel.add(label1);
		panel.add(inputFname);
		panel.add(label2);
		panel.add(inputAddr);
		panel.add(addBtn);
		panel.add(deleteBtn);
		
		panel.setBackground(Color.pink);
		add(panel, BorderLayout.NORTH);
		
		addBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		
		addBtn.setActionCommand("add");
		deleteBtn.setActionCommand("delete");
		
		
		table = new JTable();
		String[] colNames= {"순번", "맛도리가게", "어디에있게" };
		
		model = new DefaultTableModel();
		model.setColumnIdentifiers(colNames);
		model.setRowCount(0); //여기없어도되지않ㅇ나?
		
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		add(scroll, BorderLayout.CENTER);

		printFood();
		//칼럼의 제목 글자 조정
		table.getTableHeader().setFont(new Font("Sans-serif", Font.BOLD, 18));
		table.setFont(new Font("Sans-serif", Font.PLAIN, 16)); //데이터 글자 크기 16
		table.setRowHeight(25); //각 행의 높이를 조정
		
	}//생성자
	
	public static void main(String[] args) {
		FoodFrame MF = new FoodFrame("히주의 맛집리스트");
		MF.setDefaultCloseOperation(EXIT_ON_CLOSE);
		MF.setBounds(100, 100, 800, 500);
		MF.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("add")) {
			String Fname = inputFname.getText();
			String addr = inputAddr.getText();
			
			FoodDto dto = new FoodDto();
			dto.setFname(Fname);
			dto.setAddr(addr);
			
			FoodDao dao = new FoodDao();
			dao.insert(dto);
		}else if (command.equals("delete")) {
			int selectedRow = table.getSelectedRow();
			if(selectedRow == -1) {
				JOptionPane.showMessageDialog(this, "아무것도 지우기시롱?");
				return;
			}
			int num = (int)model.getValueAt(selectedRow, 0);
			new FoodDao().delete(num);
		}
		
		printFood();
	}
	
	public void printFood() {
		model.setRowCount(0);
		
		FoodDao dao = new FoodDao();
		List<FoodDto> list = dao.getList();
		for (FoodDto tmp : list) {
			// MemberDto객체에 담긴 회원정보를 이용해서 Object[]에 담은다음
			Object[] rowData = { tmp.getNum(), tmp.getFname(), tmp.getAddr() };
			// 테이블에 연결된 모델에 추가하기
			model.addRow(rowData);
			
		}
		
	}
}


