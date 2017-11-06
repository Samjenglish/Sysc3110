import javax.swing.*;

public class View extends JFrame{
	private JList<String> buddyList;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		View view = new View();
	}
	
	
	public View() {
		DefaultListModel<String> listModel= new DefaultListModel<String>();
		buddyList = new JList<>(listModel);
		buddyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listModel.addElement("Sam");
		listModel.addElement("Jo");
		add(new JScrollPane(buddyList));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JList Example");       
        this.setSize(200,200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}
	public  View addView() {
		return this;
	}
}
