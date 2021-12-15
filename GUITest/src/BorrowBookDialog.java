import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BorrowBookDialog extends JFrame implements ActionListener{
	
	private JTextField title = new JTextField();

	private JLabel J_title = new JLabel("TITLE");

	private JButton Borrow_Btn = new JButton("Borrow");
	private JButton Exit_Btn = new JButton("Exit");
	
	private AddButtonListener Borrow_buttonListener = null;
	
	public BorrowBookDialog() {
		
		Borrow_buttonListener = new AddButtonListener(this);
		setTitle("Borrow");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		title.setBounds(10,50,100,20);
	
		
		J_title.setBounds(130, 50, 150, 20);

		
		Borrow_Btn.setBounds(30, 120, 100, 40);
		Exit_Btn.setBounds(140, 120, 70, 40);
		add(title);
	
		add(J_title);

		
		add(Borrow_Btn);
		add(Exit_Btn);
		
		Borrow_Btn.addActionListener(this);
		Exit_Btn.addActionListener(this);
		
		setSize(250,200);
		setLayout(null);
		setVisible(true);
	
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("exit")) {
			dispose();
		}
		if(e.getActionCommand().equals("Borrow")) {
			if(title.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Title is empty");
				title.requestFocus();
			}
			
			else {
				
				if(!Database.getInstance().checkTitle(title.getText())) {
				JOptionPane.showConfirmDialog(null,"Title exists");
				title.setText("");
				} else {
					Database.getInstance().BorrowBook(title.getText());{
						JOptionPane.showMessageDialog(null,"완료되었습니다.");
					}
				}
			}
			
			 dispose();
			 title.requestFocus();
		}
		else if(e.getActionCommand().equals("Exit_Btn")) {
			dispose();
		}
	}
}
