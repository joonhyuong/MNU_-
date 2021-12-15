
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ReservationBookDialog extends JFrame implements ActionListener{
	
	private JTextField title = new JTextField();
	private JLabel J_title = new JLabel("TITLE");

	private JButton Reservation_Btn = new JButton("Reservation");
	private JButton Exit_Btn = new JButton("Exit");
	
	private AddButtonListener Reservation_buttonListener = null;
	
	public ReservationBookDialog() {
		
		Reservation_buttonListener = new AddButtonListener(this);
		setTitle("Reservation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		title.setBounds(10,50,100,20);
	
		
		J_title.setBounds(130, 50, 150, 20);

		
		Reservation_Btn.setBounds(15, 120, 120, 40);
		Exit_Btn.setBounds(140, 120, 70, 40);
		add(title);

		
	
		add(J_title);

		
		add(Reservation_Btn);
		add(Exit_Btn);
		
		Reservation_Btn.addActionListener(this);
		Exit_Btn.addActionListener(this);
		
		setSize(250, 200);
		setLayout(null);
		setVisible(true);
	
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("exit")) {
			dispose();
		}
		if(e.getActionCommand().equals("Reservation")) {
			if(title.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "Title is empty");
				title.requestFocus();
			}
			
			else {
				
				if(!Database.getInstance().checkTitle(title.getText())) {
				JOptionPane.showConfirmDialog(null,"Title exists");
				title.setText("");
				} else {
					Database.getInstance().ReservationBook(title.getText());{
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
