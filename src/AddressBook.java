
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;


public class AddressBook extends JFrame{
    
    
	private List<BuddyInfo> addressBook = new ArrayList<BuddyInfo>();
	private static AddressBook currentBook;
	private static int entryCount = 0;
	private static int emptyVal = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AddressBook Book1 = new AddressBook();
		BuddyInfo buddy1 = new BuddyInfo("Sam English");
		Book1.addBuddy(buddy1);	
		Book1.removeBuddy(0);
	    newFrame();

	}
	public static void newFrame() {
		
		 AddressBook frame = new AddressBook(); 
		 
		 //Create Panel
		 
		 	  JPanel createPane = new JPanel();
		 	  createPane.setLayout(null);
		 	  createPane.setSize(400,400); 
		      final JLabel tf1=new JLabel();  
		      tf1.setBounds(50,40, 150,20);
			  createPane.add(tf1);
		      final JTextField nameInput =new JTextField();
		      nameInput.setBounds(50,60, 150,20);  
		      createPane.add(nameInput);
			  
			  final JLabel tf2=new JLabel();  
		      tf2.setBounds(50,80, 150,20);
		      createPane.add(tf2);
		      final JTextField numberInput =new JTextField();
		      numberInput.setBounds(50,100, 150,20);  
		      createPane.add(numberInput);
			  
			  final JLabel tf3=new JLabel();  
		      tf3.setBounds(50,120, 150,20);
		      createPane.add(tf3);
		      final JTextField addressInput =new JTextField();
		      addressInput.setBounds(50,140, 150,20);  
		      createPane.add(addressInput);		  
		      final JButton addBuddy = new JButton("Add Buddy");
		      addBuddy.setBounds(50,160, 150,20);
		      createPane.add(addBuddy);
		//End of Create Panel 
		      
		//Display Panel
		      JPanel displayPane = new JPanel();
		 	  displayPane.setLayout(null);
		 	  displayPane.setSize(400,400); 
		 	  
		 	  final JTextArea displayEntries =new JTextArea();
		      displayEntries.setBounds(50,50, 200,200);  
		      displayPane.add(displayEntries);
		      
		//End of Display Panel     
	          JMenu menu;  
	          JMenuItem createM, saveM, displayM;  
	          JMenuBar menub=new JMenuBar();  
	          menu=new JMenu("Menu");   
	          createM=new JMenuItem("Create AddressBook");  
	          saveM=new JMenuItem("Save AddressBook");  
	          displayM=new JMenuItem("Display AddressBook");  

	          menu.add(createM); menu.add(saveM); menu.add(displayM);   
	          menub.add(menu);  
	          saveM.setEnabled(false);
	          displayM.setEnabled(false);
	          frame.setJMenuBar(menub);  
			  frame.setSize(400,400);  
			  frame.setLayout(null);  
			  frame.setVisible(true);
			  
			  createM.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e)
	            {
	               frame.setContentPane(createPane);
	               createAddressBook();
	               tf1.setText("BuddyInfo Name:");
	               tf2.setText("BuddyInfo Number:");
	               tf3.setText("BuddyInfo Address:");
	            }
	        });   
			  displayM.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e)
		            {
		               frame.setContentPane(displayPane);
		               String currentEntries = "";
		               int count = 1;
		               for(BuddyInfo f: currentBook.addressBook ) {
		            	   currentEntries +="Buddy " + count + ": \n" + f.toString() + "\n\n";
		            	   count++;
		               }
		               displayEntries.setText(currentEntries);
		            }
		        }); 
			  
			  saveM.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e)
		            {
		                BufferedWriter out;
			  			  try {
							  out = new BufferedWriter(new FileWriter("addressFile.txt"));
				               String currentEntries = "";
				               int count = 1;
				               for(BuddyInfo f: currentBook.addressBook ) {
				            	   currentEntries +="Buddy " + count + ": " + f.toString() + "\n\n";
				            	   count++;
				               }
				              out.write(currentEntries);
				              out.close();

			  			  } catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
						  }
		            }
		        });  
			 addBuddy.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e)
		            {
		             
		              saveM.setEnabled(true);
		              displayM.setEnabled(true);
		               
		              String inpName = nameInput.getText();
		              String inpNumber = numberInput.getText();
		              String inpAddress = addressInput.getText();
		              currentBook.addBuddy(new BuddyInfo(inpName, inpNumber, inpAddress));
		              entryCount++;
		              nameInput.setText("");
		              numberInput.setText("");
		              addressInput.setText("");

		              
		            }
		        }); 
	}
	
	private static void createAddressBook() {
		currentBook = new AddressBook();
	}
	
	public AddressBook() {
	        setBounds(100, 100, 450, 300);      
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addBuddy(BuddyInfo newBuddy) {
		if(newBuddy != null) {
			this.addressBook.add(newBuddy);
		}

	}
	public BuddyInfo seeBuddy(int index) {
		if(index >= 0 && index < this.addressBook.size()) {
			return this.addressBook.get(index);
		}
		return null;
	}
	public BuddyInfo removeBuddy(int index) {
		if(index >= 0 && index < this.addressBook.size()) {
			return this.addressBook.remove(index);
		}
		return null;
	}

}


