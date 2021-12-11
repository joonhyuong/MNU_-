import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class Database {
	private volatile static Database instance = null;
	private Connection connection = null;
	private Database() {
		initDatabase();
	}
	public static Database getInstance() {
		if(instance == null) {
			synchronized (Database.class) {
				if(instance == null)
					instance = new Database();
			}
		}
		return instance;
	}
	//NAME을 조회합니다.
	public boolean checkName(String name) {
		boolean retValue = false;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM member WHERE name='"+name+"'");
			if(rs.getInt(1) >= 1)
				retValue = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retValue;
	}
	public boolean checkTitle(String title) {
		boolean retValue = false;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM addbook WHERE title='"+title+"'");
			if(rs.getInt(1)>=1)
				retValue=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retValue;
	}
	//NAME과 Password 확인
	public boolean checkNameAndPwd(String name, String password) {
		boolean retValue = false;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(
					"SELECT COUNT(*) FROM member "
					+ "WHERE name='"+name+"' and pwd='"+password+"'");
			
			if(rs.getInt(1) >= 1)
				retValue = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retValue;
	}
	public void insertMemberData(String name, String password) {
		try {
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);  // set timeout to 30 sec.
	        statement.executeUpdate(
	        		"INSERT INTO member (name, pwd) "
	        		+ "values('"+name+"', '"+password+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
	}
	
	public void insertAddData(String isbn,String number,String authors
			,String title, String publisher, String book_date,String status, String regist_date) {
		try {
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate(
					"INSERT INTO addbook (isbn, number, authors, title, publisher, book_date, status, regist_date) "
					+ "values('"+isbn+"', '"+number+"', '"+authors+"', '"+title+"', '"+publisher+"', '"+book_date+"', '"+status+"', '"+regist_date+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void initDatabase() {
		// create a database connection
        try {
			connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			Statement statement = connection.createStatement();
			if( !checkExistTable("member") ) {
				statement.executeUpdate(
						"CREATE TABLE member "
						+ "(id INTEGER NOT NULL, "
						+ "name STRING NOT NULL, "
						+ "pwd STRING NOT NULL, "
						+ "PRIMARY KEY(ID AUTOINCREMENT))");
			} else if( !checkExistTable("addbook")) {
				statement.executeUpdate(
						"CREATE TABLE addbook "
						+ "(id INTEGER NOT NULL, "
						+ "isbn STRING NOT NULL, "
						+ "number STRING NOT NULL, "
						+ "authors STRING NOT NULL, "
						+ "title STRING NOT NULL, "
						+ "publisher STRING NOT NULL, "
						+ "book_date STRING NOT NULL, "
						+ "status STRING NOT NULL, "
						+ "regist_date STRING NOT NULL, "
						+ "PRIMARY KEY(ID AUTOINCREMENT))"
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private boolean checkExistTable(String tableName) {
		boolean retValue = false;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM sqlite_master WHERE name='"+tableName+"'");
			if(rs.getInt(1) == 1)
				retValue = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retValue;
	}
	
	public void printBookList(DefaultTableModel model) {
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM addbook");
			System.out.println("");
			System.out.println("<<<< 추가된 책들의 목록은 다음과 같습니다 :) >>>>");
			while(rs.next())
			{
				String []record = new String[9];
				record[0] = Integer.toString(rs.getInt("id"));
				record[1] = rs.getString("isbn");
				record[2] = rs.getString("number");
				record[3] = rs.getString("authors");
				record[4] = rs.getString("title");
				record[5] = rs.getString("publisher");
				record[6] = rs.getString("book_date");
				record[7] = rs.getString("status");
				record[8] = rs.getString("regist_date");
				System.out.println("");
				System.out.println("===== id : "+record[0]+" =====");
				System.out.println("TITLE : "+record[4]);
				System.out.println("ISBN : "+record[1]);
				System.out.println("AUTHORS : "+record[3]);
				System.out.println("NUMBER : "+record[2]);
				System.out.println("PUBLISHER : "+record[5]);
				System.out.println("BOOK_DATE : "+record[6]);
				System.out.println("STATUS : "+record[7]);
				System.out.println("REGIST_DATE : "+record[8]);
				System.out.println("");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertJTable(DefaultTableModel model) {
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM member");
			model.setNumRows(0);
			while(rs.next())
			{
				String []record = new String[3];
				record[0] = Integer.toString(rs.getInt("id"));
				record[1] = rs.getString("name");
				record[2] = rs.getString("pwd");
				//record[3] = Integer.toString(rs.getInt("Book"));
				
				model.addRow(record);
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
