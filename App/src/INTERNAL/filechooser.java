package INTERNAL;



import java.io.*;
import java.time.LocalDateTime;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.filechooser.*;
class filechooser extends JFrame implements ActionListener {

	
	static JLabel l;
	private JButton button1;
	private JButton button2;
	private JTextField text;
	public String posttext;
	public String imagepath;
	public boolean status;
	public User user;

	
	filechooser(User user)
	{ //This constructor is for Content sharings from the Homepage -boş-
	this.user=user;

	


		// This button saves all the information provided and passes it to the displayer components
		button1 = new JButton("Save");

		// This button creates a JFileChooser object and allows user to select the item to be shared
		button2 = new JButton("Open");

	
		

		
		
		button2.addActionListener(this);

		//This panel is used to add the buttons
		JPanel p = new JPanel();
		text= new JTextField(20);
		p.add(text);

	
		p.add(button1);
		p.add(button2);
		//This is a default message displayed at the beginning
		l = new JLabel("no file selected");

		
		p.add(l);
		this.add(p);
		
		button1.addActionListener(

				
				new ActionListener() {
					public void actionPerformed(ActionEvent evt)
					{  //Getting entered inputs to create a Content object
						posttext=text.getText();
					
						imagepath=l.getText();
						LocalDateTime tm=LocalDateTime.now();
						
						
						Content ct=new Content(user,"flgkdl",tm,posttext,imagepath);
						user.contentpaths.add(imagepath);
						user.contdescrptn.put(imagepath, posttext);
						
						//Content is created and is added to the database
						
						
						ct.setBounds(50, 50, 500, 400);
						ct.setVisible(true);
						user.page.panel.add(ct);
						if(user.contents.contains(ct)!=true) {
							user.contents.add(ct);}
						SwingUtilities.updateComponentTreeUI(user.page.panel);
						
						
						setVisible(false);
						dispose();
						
						
						
						
						
						
						
						
					}});

	}
	
	filechooser(String k,User user)
	//This constructor is for editing a previously shared content
	{
	

	


		
		button1 = new JButton("Save");

		button2 = new JButton("Open");
		JButton leavebutton=new JButton("Back");
		
		leavebutton.addActionListener(
				//Being different from the previous constructor, this button allows user to return to the previous page
				new ActionListener() 
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
						dispose();
						
						

					}
				} 
		); 


		//These parts are same with the previous constructor
		
		button2.addActionListener(this);

		JPanel p = new JPanel();
		text= new JTextField(20);
		p.add(text);

		
		p.add(button1);
		p.add(button2);
		p.add(leavebutton);


		l = new JLabel("No New Image Selected");


		p.add(l);
		this.add(p);
		
		button1.addActionListener(

				
				new ActionListener() {
					public void actionPerformed(ActionEvent evt)
					{
						
						

						posttext=text.getText();
					
						imagepath=l.getText();
						LocalDateTime tm=LocalDateTime.now();
						Content a=user.searchcontent(k);
						

						a.textField.setText(posttext);
						try 
						//This is the part where the image and the caption is editted, through overlapping the images 
						  {
						   

						   BufferedImage img = ImageIO.read(new File(imagepath));
						   JLabel pic = new JLabel(new ImageIcon(img));
						   a.panel_1.add(pic);

						  
						  } 
						
						  catch (IOException e) {}
						//Removing prior content information from relevant databases and adding the new ones
						user.contentpaths.remove(a.getPath());
						user.contentpaths.add(imagepath);
						user.contdescrptn.remove(a.getPath(), a.getText());
						user.contdescrptn.put(imagepath, posttext);
						SwingUtilities.updateComponentTreeUI(a.panel_1);
			  			//Panel reset
						a.panel_1.invalidate();
						a.panel_1.validate();
						a.panel_1.repaint();
						SwingUtilities.updateComponentTreeUI(a.panel);
			  			
						a.panel.invalidate();
						a.panel.validate();
						a.panel.repaint();
						
						
						
						SwingUtilities.updateComponentTreeUI(user.page.panel);
			  			
						user.page.panel.invalidate();
						user.page.panel.validate();
						user.page.panel.repaint();
						
						
						setVisible(false);
						dispose();
						
						
						
						
						
						
						
						
					}});

	}
	
	
	filechooser(User user, String groupName)
	{
		//This constructor is for sharing a post in the group
	this.user=user;

	


		
		button1 = new JButton("Save");

		
		button2 = new JButton("Open");

	
		
		button2.addActionListener(this);

		JPanel p = new JPanel();
		text= new JTextField(20);
		text.setText("Group post");
		p.add(text);


		p.add(button1);
		p.add(button2);

		l = new JLabel("no file selected");

	
		p.add(l);
		this.add(p);
		
		button1.addActionListener(

				
				new ActionListener() {
					public void actionPerformed(ActionEvent evt)
					{
						posttext=text.getText();
					
						imagepath=l.getText();
						LocalDateTime tm=LocalDateTime.now();
						
						//New content is created, just as in the first part
						Content ct=new Content(user,"title",tm,posttext,imagepath);
					
						
						
						 
					    //Using the given info in the constructor, this part finds the relevant group and adds the content
						Group a=user.searchgroup(groupName);
						ct.setBounds(50, 50, 500, 400);
						ct.setVisible(true);
						
						a.addPost(ct);


					
						
						
						setVisible(false);
						dispose();
						
						
						
						
						
						
						
						
						
						
					}});

	}
	public void actionPerformed(ActionEvent evt)
	{
		// When the user presses the save button this allows the program to pass the provided information to be processed
		String com = evt.getActionCommand();

		if (com.equals("Open")) {
			// JFileChooser object is created
			JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

			// Helper to the JFileChooser, showing save dialog
			int r = j.showSaveDialog(null);

			// If user selects a file this checks the selection status
			if (r == JFileChooser.APPROVE_OPTION)

			{
				// Label at the beginning is set to display the path of the Content
				String path=j.getSelectedFile().getAbsolutePath();
				l.setText(j.getSelectedFile().getAbsolutePath());
			}
			// If the user quits from the JFileChooser
			else
				l.setText("The user quitted from the file selection");
		}

		// When the user clicks on the Save button the window disappears
		else {
			setVisible(false); 
			dispose(); 
		}
	}

}