import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("도서관리 프로그램");
		setSize(800, 500);
		
		createMenu();
		
		setVisible(true);
		//화면 가운데 생성
		setLocationRelativeTo(null);
	}
	
	private void createMenu() {
		/* Menu를 만듭니다. */
		JMenuBar mb = new JMenuBar();
		JMenu personMenu = new JMenu("Person");
		JMenuItem loginMenuItem = new JMenuItem("Log-in");
		JMenuItem logoutMenuItem = new JMenuItem("Log-out");
		personMenu.add(loginMenuItem);
		personMenu.add(logoutMenuItem);
		
		JMenu memberMenu = new JMenu("Members");
		JMenuItem membersMenuItem = new JMenuItem("Members ...");
		memberMenu.add(membersMenuItem);
		
		JMenu bookMenu = new JMenu("Book");
		JMenuItem addBook = new JMenuItem("Add Book");
		JMenuItem bookList = new JMenuItem("Book List");
		bookMenu.add(addBook);
		bookMenu.add(bookList);
		
		JMenu etcMenu = new JMenu("etc");
		JMenuItem borrowbook = new JMenuItem("Borrow Book");
		JMenuItem returnbook = new JMenuItem("Return Book");
		JMenuItem reservationbook = new JMenuItem("Reservation Book");
		etcMenu.add(borrowbook);
		etcMenu.add(returnbook);
		etcMenu.add(reservationbook);
		
		mb.add(personMenu);
		mb.add(memberMenu);
		mb.add(bookMenu);
		mb.add(etcMenu);
		
		MenuActionListener menuListener = new MenuActionListener(this);
		membersMenuItem.addActionListener(menuListener);
		addBook.addActionListener(menuListener);
		bookList.addActionListener(menuListener);
		logoutMenuItem.addActionListener(menuListener);
		borrowbook.addActionListener(menuListener);
		returnbook.addActionListener(menuListener);
		reservationbook.addActionListener(menuListener);
		setJMenuBar(mb);
	}
}
