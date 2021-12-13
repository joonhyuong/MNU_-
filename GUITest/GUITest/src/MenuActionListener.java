import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.io.IOException;
//import java.awt.sql.SQLException;

import java.io.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;



public class MenuActionListener implements ActionListener {
	
	String[] str = {"��α���", "����"};
	String[] str1 = {"YES", "NO"};
	private MainFrame mainWindow = null;
	private JTable table = null;
	private JScrollPane scroll;

	public MenuActionListener(MainFrame mainWindow) {
		this.mainWindow = mainWindow;
		createBookTable();
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Members ..."))
		{
			createTable();
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
			System.out.println("======== ����� �Ϸ��Ͽ����ϴ�! ========");
			DefaultTableModel model= (DefaultTableModel)table.getModel();
            Database.getInstance().insertJTable(model);

		}
		
		else if(e.getActionCommand().equals("Book List"))
		{
			System.out.println("Book List... ok");
			DefaultTableModel model= (DefaultTableModel)table.getModel();
			Database.getInstance().insertBookJTable(model);
			
		}
		
		else if(e.getActionCommand().equals("Log-out"))
		{
			System.out.println("�α׾ƿ� ����â");
			int result = JOptionPane.showOptionDialog(null,"�α׾ƿ� �Ͻðڽ��ϱ�?","�α׾ƿ�",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,null,str,str[1]);
			if(result == JOptionPane.YES_OPTION) {
				mainWindow.setVisible(false); //��α����� �������� �� ���� â �����
				new LoginWindows(); //���ο� �α��� ȭ�� ����
			}
			else {
				System.exit(0); 
			}
		}
		
		else if(e.getActionCommand().equals("Log-in"))
		{
			System.out.println("��α���");
			int result1 = JOptionPane.showOptionDialog(null,"��α��� �Ͻðڽ��ϱ�?","�α׾ƿ�",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,null,str1,str1[1]);
			if(result1 == JOptionPane.YES_OPTION) {
				mainWindow.setVisible(false); //��α����� �������� �� ���� â �����
				new LoginWindows(); //���ο� �α��� ȭ�� ����
			}
		}
		
		else if(e.getActionCommand().equals("Borrow Book")) //å �뿩 
		{
			System.out.println("borrow book... ok");
			String Book = JOptionPane.showInputDialog("�뿩�� ���ϴ� å ������ �Է����ּ���");
			System.out.println(Book); //Book�� ���� ������ Ȯ��
		}
		
		else if(e.getActionCommand().equals("Return Book"))//å �ݳ�
		{
			System.out.println("return book... ok");
			String Book = JOptionPane.showInputDialog("�ݳ��� �Ϸ��� å ������ �Է����ּ���");
			System.out.println(Book); //Book�� ���� ������ Ȯ��
		}
		
		else if(e.getActionCommand().equals("Reservation Book")) // å ����
		{
			System.out.println("reservation book... ok");
			String Book = JOptionPane.showInputDialog("�����Ͻ� å ������ �Է����ּ���");
			System.out.println(Book); //Book�� ���� ������ Ȯ��
		}
	}
	
	private void createTable() {
		String []header = {"id", "name", "password"};
		DefaultTableModel model=new DefaultTableModel(header,0);
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		mainWindow.getContentPane().add(scroll);
	}
	
	private void createBookTable() {
		String []header = {"id", "isbn","number","authors","title","publisher","book_date","status","regist_date"}; //isbn, number, authors, title, publisher, book_date, status, regist_date
		DefaultTableModel model=new DefaultTableModel(header,0);
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		mainWindow.getContentPane().add(scroll);
	}
}
