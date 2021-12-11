import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;


public class MenuActionListener implements ActionListener {
	
	String[] str = {"재로그인", "종료"};
	
	private MainFrame mainWindow = null;
	private JTable table = null;
	public MenuActionListener(MainFrame mainWindow) {
		this.mainWindow = mainWindow;
		createTable();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Members ..."))
		{
			System.out.println("members... ok");
			
			DefaultTableModel model= (DefaultTableModel)table.getModel();
			Database.getInstance().insertJTable(model);
		}
		
		else if(e.getActionCommand().equals("Add Book"))
		{
			System.out.println("Add Book!");
			new AddBookFrame();
		}
		
		else if(e.getActionCommand().equals("add"))
		{
			System.out.println("======== 등록을 완료하였습니다! ========");
			DefaultTableModel model= (DefaultTableModel)table.getModel();
			Database.getInstance().insertJTable(model);
		}
		
		else if(e.getActionCommand().equals("Book List"))
		{
			DefaultTableModel model= (DefaultTableModel)table.getModel();
			Database.getInstance().printBookList(model);
		}
		
		else if(e.getActionCommand().equals("Log-out"))
		{
			System.out.println("로그아웃 선택창");
			int result = JOptionPane.showOptionDialog(null,"로그아웃 하시겠습니까?","로그아웃",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,null,str,str[1]);
			if(result == JOptionPane.YES_OPTION) {
				mainWindow.setVisible(false); //재로그인을 선택했을 때 기존 창 사라짐
				new LoginWindows(); //새로운 로그인 화면 등장
			}
			else {
				System.exit(0); 
			}
		}
		
		else if(e.getActionCommand().equals("Borrow Book")) //책 대여 
		{
			System.out.println("borrow book... ok");
			String Book = JOptionPane.showInputDialog("대여를 원하는 책 제목을 입력해주세요");
			System.out.println(Book); //Book에 값이 들어가는지 확인
		}
		
		else if(e.getActionCommand().equals("Return Book"))//책 반납
		{
			System.out.println("return book... ok");
			String Book = JOptionPane.showInputDialog("반납을 하려는 책 제목을 입력해주세요");
			System.out.println(Book); //Book에 값이 들어가는지 확인
		}
		
		else if(e.getActionCommand().equals("Reservation Book")) // 책 예약
		{
			System.out.println("reservation book... ok");
			String Book = JOptionPane.showInputDialog("예약하실 책 제목을 입력해주세요");
			System.out.println(Book); //Book에 값이 들어가는지 확인
		}
	}
	
	private void createTable() {
		String []header = {"id", "name", "password"};
		DefaultTableModel model=new DefaultTableModel(header,0);
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		mainWindow.add(scroll);
	}
	
	
	
}
