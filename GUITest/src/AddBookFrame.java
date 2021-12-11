import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddBookFrame extends JFrame implements ActionListener{
	
	private JTextField id = new JTextField();
	private JTextField isbn = new JTextField();
	private JTextField number = new JTextField();
	private JTextField authors = new JTextField();
	private JTextField title = new JTextField();
	private JTextField publisher = new JTextField();
	private JTextField book_date = new JTextField();
	private JTextField status = new JTextField();
	private JTextField regist_date = new JTextField();
	
	private JLabel J_id = new JLabel("ID");
	private JLabel J_isbn = new JLabel("ISBN");
	private JLabel J_number = new JLabel("NUMBER");
	private JLabel J_authors = new JLabel("AUTHORS");
	private JLabel J_title = new JLabel("TITLE");
	private JLabel J_publisher = new JLabel("PUBLISHER");
	private JLabel J_book_date = new JLabel("BOOK_DATE");
	private JLabel J_status = new JLabel("STATUS");
	private JLabel J_regist_date = new JLabel("REGIST_DATE");
	
	private JButton Add_Btn = new JButton("add");
	private JButton Exit_Btn = new JButton("exit");
	
	private AddButtonListener add_buttonListener = null;
	
	public AddBookFrame() {
		
		add_buttonListener = new AddButtonListener(this);
		setTitle("Add");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		id.setBounds(10,10,100,20);
		isbn.setBounds(10,40,100,20);
		number.setBounds(10,70,100,20);
		authors.setBounds(10,100,100,20);
		title.setBounds(10,130,100,20);
		publisher.setBounds(10,160,100,20);
		book_date.setBounds(10,190,100,20);
		status.setBounds(10,220,100,20);
		regist_date.setBounds(10,250,100,20);
		
		J_id.setBounds(130, 10, 150, 20);
		J_isbn.setBounds(130, 40, 150, 20);
		J_number.setBounds(130, 70, 150, 20);
		J_authors.setBounds(130, 100, 150, 20);
		J_title.setBounds(130, 130, 150, 20);
		J_publisher.setBounds(130, 160, 150, 20);
		J_book_date.setBounds(130, 190, 150, 20);
		J_status.setBounds(130, 220, 150, 20);
		J_regist_date.setBounds(130, 250, 150, 20);
		
		Add_Btn.setBounds(60, 300, 70, 40);
		Exit_Btn.setBounds(140, 300, 70, 40);
		add(id);
		add(isbn);
		add(number);
		add(authors);
		add(title);
		add(publisher);
		add(book_date);
		add(status);
		add(regist_date);
		
		add(J_id);
		add(J_isbn);
		add(J_number);
		add(J_authors);
		add(J_title);
		add(J_publisher);
		add(J_book_date);
		add(J_status);
		add(J_regist_date);
		
		add(Add_Btn);
		add(Exit_Btn);
		
		Add_Btn.addActionListener(this);
		Exit_Btn.addActionListener(this);
		
		setSize(270, 500);
		setLayout(null);
		setVisible(true);
	
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("exit")) {
			dispose();
		}
		if(e.getActionCommand().equals("add")) {
			if(isbn.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "ISBN is empty");
				isbn.requestFocus();
			}
			else if(number.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Number is empty");
				number.requestFocus();
			}
			else if(authors.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Authors is empty");
				authors.requestFocus();
			}
			else if(title.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Title is empty");
				title.requestFocus();
			}
			else if(publisher.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Publisher is empty");
				publisher.requestFocus();
			}
			else if(book_date.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Book_date is empty");
				book_date.requestFocus();
			}
			else if(status.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Status is empty");
				status.requestFocus();
			}
			else if(regist_date.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Regist_date is empty");
				regist_date.requestFocus();
			}
			else {
				if(!Database.getInstance().checkTitle(title.getText())) {
					Database.getInstance().insertAddData(isbn.getText() ,number.getText(), 
							authors.getText(), title.getText(), publisher.getText(), 
							book_date.getText(), status.getText(), 
							regist_date.getText());
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Title exists");
					isbn.setText("");
					number.setText("");
					authors.setText("");
					title.setText("");
					publisher.setText("");
					book_date.setText("");
					status.setText("");
					regist_date.setText("");
					
					title.requestFocus();
				}
			}
		}
		else if(e.getActionCommand().equals("Exit_Btn")) {
			dispose();
		}
	}
}
