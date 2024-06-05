package INTERNAL;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class profileEdit extends JFrame {
	
	private JButton backbutton;
	private JButton signupbutton;
	private JTextField text1;
	private JTextField text1a;
	private JTextField text2;
	private JTextField text2a;
	private JTextArea textArea;
	private JTextField text3;
	private JTextField text3a;
	private JTextField text4;
	private JTextField text4a;
	private JTextField text5;
	private JTextField text5a;
	private JTextField text6;
	private JTextField text6a;
	private JComboBox<String> combo;
	private User owner;
	private static final String[] types = {"Standard","Premium"}; //Types to be placed in the comboBox
	

	public profileEdit(User a) {
		this.owner=a;
		// TODO Auto-generated constructor stub
		setLayout(new FlowLayout());
		text1 = new JTextField("Username");
		text1.setEditable(false);
		add(text1);
		text1a= new JTextField(25);
		text1a.setEditable(false);
		text1a.setText(owner.getNickname());
		add(text1a);
		text2 = new JTextField("Password");
		text2.setEditable(false);
		add(text2);
		text2a= new JTextField(25);
		add(text2a);
		text3=new JTextField("Name  ");
		text3.setEditable(false);
		add(text3);
		text3a=new JTextField(25);
		add(text3a);
		text4=new JTextField("Surname");
		text4.setEditable(false);
		add(text4);
		text4a=new JTextField(25);
		add(text4a);
		text5=new JTextField("Age    ");
		text5.setEditable(false);
		add(text5);
		text5a=new JTextField(25);
		add(text5a);
		text6=new JTextField("Email  ");
		text6.setEditable(false);
		add(text6);
		text6a=new JTextField(25);
		add(text6a);
		
		textArea = new JTextArea("      Edit User Information      ");
		add(textArea);
		
		
		
		
		
		
		backbutton=new JButton("Go Back");
		signupbutton=new JButton("Save");
				
		add(backbutton, BorderLayout.NORTH);
		add(signupbutton, BorderLayout.SOUTH);
		
		
		signupbutton.addActionListener(
				
				new ActionListener() 
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							//Each line is filled according to the personal information
							//A relevant message is displayed if one or more lines are left blank
							
								if(text3a.getText().isBlank())
							
							textArea.setText("You must enter a name");
							
							else {
								owner.setName(text3a.getText());
								
							}
								if(text2a.getText().isBlank())
									
									textArea.setText("You must enter a password");
									
									else {
										owner.setPassword(text2a.getText());
										
										App.database.replace(owner.getNickname(),text2a.getText());
										
									}   
								if(text4a.getText().isBlank())
									
									textArea.setText("You must enter a surname");
									
									else {
										owner.setSurname(text4a.getText());
										
									}
								if(text5a.getText().isBlank())
									
									textArea.setText("You must enter an age");
									
									else {
										owner.setAge(text5a.getText());
										
									}
								if(text6a.getText().isBlank())
									
									textArea.setText("You must enter an email");
									
									else {
										owner.setEmail(text6a.getText());
										
									}
								textArea.setText("Edit was successful. Click 'Go Back' to return to your profile.");
								//Edit process is successfully completed
							
											
										}
									
								
								
								
							
							
							
						catch(NullPointerException a){
							textArea.setText("All the blanks must be filled.");
								
								
							
						}
						
					}
						
						
							
						}
						

					
			
		); 
		backbutton.addActionListener(
				//A basic button that returns the user to the profile page
				new ActionListener()
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						prf profile=new prf(owner,owner);
						profile.setSize(1000,600);
						
						profile.setDefaultCloseOperation(EXIT_ON_CLOSE);
						profile.setVisible(true);
						setVisible(false);
						dispose();
							
						}}
						

					
			
		); 
		
		

	}
	
	
	}



