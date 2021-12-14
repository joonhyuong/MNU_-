import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ReturnBookDialog extends JFrame implements ActionListener{
	
	private JTextField id = new JTextField();
	private JTextField title = new JTextField();

	private JLabel J_id = new JLabel("ID");
	private JLabel J_title = new JLabel("TITLE");

	private JButton Return_Btn = new JButton("Return");
	private JButton Exit_Btn = new JButton("Exit");
	
	private AddButtonListener Return_buttonListener = null;
	
	public ReturnBookDialog() {
		
		Return_buttonListener = new AddButtonListener(this);
		setTitle("Return");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		id.setBounds(10,40,100,20);
		title.setBounds(10,80,100,20);
	
		
		J_id.setBounds(130, 40, 150, 20);
		J_title.setBounds(130, 80, 150, 20);

		
		Return_Btn.setBounds(30, 120, 90, 40);
		Exit_Btn.setBounds(140, 120, 70, 40);
		add(id);
		add(title);

		
		add(J_id);
		add(J_title);

		
		add(Return_Btn);
		add(Exit_Btn);
		
		Return_Btn.addActionListener(this);
		Exit_Btn.addActionListener(this);
		
		setSize(250, 200);
		setLayout(null);
		setVisible(true);
	
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("exit")) {
			dispose();
		}
		if(e.getActionCommand().equals("Return")) {
			if(title.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Title is empty");
				title.requestFocus();
			}
			
			else {
				
				if(!Database.getInstance().checkTitle(title.getText())) {
				JOptionPane.showConfirmDialog(null,"Title exists");
				title.setText("");
				} else {
					Database.getInstance().ReturnBook(title.getText());{
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