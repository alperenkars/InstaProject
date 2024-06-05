package INTERNAL;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileSystemView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

class searchTool extends JFrame implements ActionListener {

	
	static JLabel l;
	private JButton button1;
	
	private JTextField text;
	public String posttext;
	
	public boolean status;
	public User user;

	
	searchTool(User user)
	{//This constructor searches for users
	this.user=user;

	


		button1 = new JButton("search");
		

		// Panel to add the buttons
		JPanel p = new JPanel();
		text= new JTextField(20);
		p.add(text);


		p.add(button1);
		

		//Initial message
		l = new JLabel("Search for users by \nwriting the nickname and clicking on Search");

		
		p.add(l);
		this.add(p);
		
		button1.addActionListener(
				//This button passes the input to the method and opens the page of the user if exists
				
				new ActionListener() {
					public void actionPerformed(ActionEvent evt)
					{
						posttext=text.getText();
						int c=0;
						for(int a=0;a<App.users.size();a++) {
							if(App.users.get(a).getNickname().equals(posttext)) {
								//If the nicknames match
								c=a;
								//Creating a new prf -profile- object
								prf prof=new prf(App.users.get(c), user);
								prof.setSize(1000,600);
								
								prof.setDefaultCloseOperation(EXIT_ON_CLOSE);
								prof.setVisible(true);
								setVisible(false);
								dispose();
							}
							else {
								//Nicknames do not match
								l.setText("Username does not exist in the database");
							}
						}
						
						
						
						
						
						
						
						
						
						
					
						
						
						
						
						
						
						
						
					}});

	}
	searchTool(User user, String group)
	{//This constructor searches for a group
	this.user=user;

	


		
		button1 = new JButton("search");

		

		//Panel to add the buttons
		JPanel p = new JPanel();
		text= new JTextField(20);
		p.add(text);

		
		p.add(button1);
		

		
		l = new JLabel("Search for groups by writing the group name and clicking on Search");

		
		p.add(l);
		this.add(p);
		
		button1.addActionListener(

				
				new ActionListener() {
					public void actionPerformed(ActionEvent evt)
					{//This button checks if there is any matching group and displays it
						posttext=text.getText();
						
							if(user.search(posttext)!=null) {
								
								GroupData t=user.search(posttext);
								Group prof=new Group(t,user);
								
								prof.setSize(800,1000);
								
							
								prof.setVisible(true);
								setVisible(false);
								dispose();
							}
							else {
								l.setText(" Group name does not exist in the database");
								//There is no matching group
							}
						
						
						
						
						
						
						
						
						
						
						
					
						
						
						
						
						
						
						
						
					}});

	}
	public void actionPerformed(ActionEvent evt)
	{
		//Implemented just as in the filechooser class
		String com = evt.getActionCommand();

		if (com.equals("open")) {
			// create an object of JFileChooser class
			JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

			// invoke the showsSaveDialog function to show the save dialog
			int r = j.showSaveDialog(null);

			// if the user selects a file
			if (r == JFileChooser.APPROVE_OPTION)

			{
				// set the label to the path of the selected file
				String path=j.getSelectedFile().getAbsolutePath();
				l.setText(j.getSelectedFile().getAbsolutePath());
			}
			// if the user cancelled the operation
			else
				l.setText("the user cancelled the operation");
		}

		// if the user presses the open dialog show the open dialog
		else {
			setVisible(false); 
			dispose(); 
		}
	}

}
