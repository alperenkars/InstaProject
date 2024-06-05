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


public class signUp extends JFrame {
	
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
	private static final String[] types = {"Standard","Premium"};
	

	public signUp() {
		// TODO Auto-generated constructor stub
		setLayout(new FlowLayout());
		text1 = new JTextField("Username ");
		text1.setEditable(false);
		add(text1);
		text1a= new JTextField(20);
		add(text1a);
		text2 = new JTextField("Password");
		text2.setEditable(false);
		add(text2);
		text2a= new JTextField(20);
		add(text2a);
		text3=new JTextField("Name  ");
		text3.setEditable(false);
		add(text3);
		text3a=new JTextField(20);
		add(text3a);
		text4=new JTextField("Surname ");
		text4.setEditable(false);
		add(text4);
		text4a=new JTextField(20);
		add(text4a);
		text5=new JTextField("Age   ");
		text5.setEditable(false);
		add(text5);
		text5a=new JTextField(20);
		add(text5a);
		text6=new JTextField("Email  ");
		text6.setEditable(false);
		add(text6);
		text6a=new JTextField(20);
		add(text6a);
		combo = new JComboBox<String>(types);
		add(combo);
		textArea = new JTextArea("Registration Information");
		add(textArea);
		
		
		
		
		
		
		backbutton=new JButton("Go Back");
		//Returns to the Login page
		signupbutton=new JButton("Sign Up");
		//Completes the registration
				
		add(backbutton, BorderLayout.NORTH);
		add(signupbutton, BorderLayout.SOUTH);
		
		
		signupbutton.addActionListener(
				
				new ActionListener() 
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							if(App.database.keySet().contains(text1a.getText())!=true) {
								//If the username does not exist, a new User object is created
							User aa=new User(text1a.getText(),text2a.getText(),text3a.getText(),text4a.getText(),text5a.getText(),text6a.getText(),(String) combo.getSelectedItem());
							textArea.setText("Registration completed. Click 'Go Back' to sign in");
							}
							else {
								textArea.setText("Username already exists.");
								//If the username exists
								
							}
							
											
										}
									
								
								
								
							
							
							
						catch(NullPointerException a){
							textArea.setText("All the blanks must be filled.");
								//If one or more blanks are blank and throw an exception
								
							
						}
						
					}
						
						
							
						}
						

					
			
		); 
		backbutton.addActionListener(
				
				new ActionListener()
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Login c = new Login();
						c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						c.setSize(350, 350);
						c.setVisible(true);
						setVisible(false);
						dispose();
							
						}}
						

					
			
		); 
		
		

	}
	
	
	}


