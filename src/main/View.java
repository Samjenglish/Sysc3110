package main;
   import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class View extends JFrame{
	
	private AddressBook model = new AddressBook();
	private JList<String> buddyList;
	private  DefaultListModel<String> listModel;
	private View viewInstance;
	private JPanel createView;
	private JPanel displayView;
	private JMenuItem createM, saveM, displayM; 
	private JTextField addressInput, nameInput, numberInput;
	private boolean guiChange;
	private int selectedBuddy;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		View view = new View();
		
	}
	public View() {
		 	//Create Panel
			  guiChange = false;
			  viewInstance = this;
			  createView = new JPanel(new FlowLayout());
		 	  JPanel createPane = new JPanel();
		 	  createPane.setLayout(new GridLayout(0,1));
		 	  createPane.setSize(400,400); 
		      JLabel tf1=new JLabel("Name:");  
		      tf1.setBounds(50,40, 150,20);
			  createPane.add(tf1);
		      nameInput = new JTextField();
		      nameInput.setBounds(50,60, 150,20);  
		      createPane.add(nameInput);
			  
			  JLabel tf2=new JLabel("Number:");  
		      tf2.setBounds(50,80, 150,20);
		      createPane.add(tf2);
		      numberInput =new JTextField();
		      numberInput.setBounds(50,100, 150,20);  
		      createPane.add(numberInput);
			  
			  JLabel tf3=new JLabel("Address:");  
		      tf3.setBounds(50,120, 150,20);
		      createPane.add(tf3);
		      addressInput =new JTextField();
		      addressInput.setBounds(50,140, 150,20);  
		      createPane.add(addressInput);	
		      
		      JButton addBuddy = new JButton("Add Buddy");
		      addBuddy.setBounds(50,160, 150,20);
		      createPane.add(addBuddy);
		      createView.add(createPane);
		      //End of Create Panel
		      
			  //DisplayPanel 
		     
		      displayView = new JPanel(new GridLayout(0,1));
		      listModel= new DefaultListModel<String>();
		      buddyList = new JList<>(listModel);
		      buddyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		      JScrollPane displayPane= new JScrollPane(buddyList);
		      displayPane.setSize(this.getSize());
		     		      
		      buddyList.addListSelectionListener(new ListSelectionListener() {
		    	    @Override
		    	    public void valueChanged(ListSelectionEvent e)
		    	    {	
		    	    	if(guiChange) {
		    	    		return;
		    	    	}
		    	        if(!e.getValueIsAdjusting()) {
		    	        	
		    	            selectedBuddy = buddyList.getSelectedIndex();
		    	            BuddyInfo chosenBud = viewInstance.model.seeBuddy(selectedBuddy);
		    	            viewInstance.entryChoice(chosenBud);
		    	            
		    	        }
            
		    	    }
		    	});   
		      displayView.add(displayPane);
		      //End of Display Panel   
		      
		      
	          JMenu menu;  
	          JMenuBar menub=new JMenuBar();  
	          menu=new JMenu("Menu");   
	          createM=new JMenuItem("Create AddressBook");  
	          saveM=new JMenuItem("Save AddressBook");  
	          displayM=new JMenuItem("Display AddressBook");  

	          menu.add(createM); menu.add(saveM); menu.add(displayM);   
	          menub.add(menu);  
	          saveM.setEnabled(false);
	          displayM.setEnabled(false);
	          this.setJMenuBar(menub);  
			  this.setSize(400,400);  
			  this.setLayout(null);
			  this.setContentPane(displayView);
			  this.setVisible(true);
			  
			  
			  //Content Changing events
			  createM.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	 viewInstance.switchPane(createView);
			        	 displayM.setEnabled(true);
			        	 saveM.setEnabled(true);
			         }
			  });
			  displayM.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			          viewInstance.update();
			          viewInstance.switchPane(displayView);
			         }
			  });
			  saveM.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
		                BufferedWriter out;
			  			  try {
							  out = new BufferedWriter(new FileWriter("addressFile.txt"));
				               String currentEntries = "";
				               int count = 1;
				               for(BuddyInfo f:  viewInstance.model.getBookList()) {
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
			  //Addbuddy event
			  addBuddy.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	 BuddyInfo newBud = new BuddyInfo(nameInput.getText(), numberInput.getText(), addressInput.getText());
			        	 model.addBuddy(newBud);
			         }
			  });
		            	
			  
	}
	private void entryChoice(BuddyInfo chosenBud) {
		 JTextField field1 = new JTextField("What would you like to do with the selected entry?");
         JPanel entryPanel = new JPanel(new GridLayout(0, 1));
         JButton edit = new JButton("Edit");
         JButton remove = new JButton("Remove");
         edit.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 viewInstance.editEntry(chosenBud);
	         }
         });
         remove.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	         viewInstance.model.removeBuddy(selectedBuddy);   	
	         }
         });
         entryPanel.add(field1);
         entryPanel.add(edit);
         entryPanel.add(remove);

         int result = JOptionPane.showConfirmDialog(null, entryPanel, "Editing Entry",
             JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
         viewInstance.update();

	}
	private void editEntry(BuddyInfo chosenBud) {
		
		 JTextField field1 = new JTextField(chosenBud.getName());
         JTextField field2 = new JTextField(chosenBud.getPhoneNumber());
         JTextField field3 = new JTextField(chosenBud.getAddress());
         JPanel panel = new JPanel(new GridLayout(0, 1));
         
         panel.add(new JLabel("Name:"));
         panel.add(field1);
         panel.add(new JLabel("Number:"));
         panel.add(field2);
         panel.add(new JLabel("Address:"));
         panel.add(field3);
         
         int result = JOptionPane.showConfirmDialog(null, panel, "Editing Entry",
             JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
         if (result == JOptionPane.OK_OPTION) {
             chosenBud.setName(field1.getText());
             chosenBud.setPhoneNumber(field2.getText());
             chosenBud.setAddress(field3.getText());
             field1.setText("");
             field2.setText("");
             field3.setText("");
             viewInstance.update();
         } else {
             System.out.println("Cancelled");
         }
		
	}
	private void switchPane(JPanel newPane) {
		this.setContentPane(newPane);
		refresh();
	}

	public void update() {
		try {
		    guiChange = true;
		    
			if(listModel.isEmpty() != true) {
				listModel.clear();
			}
			buddyList.clearSelection();
			int count = 0;
			for(BuddyInfo f:  viewInstance.model.getBookList()) {
	     	   listModel.addElement(f.toString());
	     	   count++;
	        }
		} finally {
		    guiChange = false;
		}

		
	}
	public void refresh(){
		this.invalidate();
		this.validate();
	}
}
