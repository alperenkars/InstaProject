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


public class Login extends JFrame {
	
	private JButton loginbutton;
	private JButton signupbutton;
	private JTextField text1;
	private JTextField text1a;
	private JTextField text2;
	private JTextField text2a;
	private JTextArea textArea;

	public Login() {
		// TODO Auto-generated constructor stub
		setLayout(new FlowLayout());
		text1 = new JTextField("Username");
		text1.setEditable(false);
		add(text1);
		text1a= new JTextField(20);
		add(text1a);
		text2 = new JTextField("   Password");
		text2.setEditable(false);
		add(text2);
		text2a= new JTextField(20);
		add(text2a);
		textArea = new JTextArea();
		add(textArea);
		
		
		
		
		loginbutton=new JButton("Sign in");
		
		signupbutton=new JButton("Sign up");
				
		add(loginbutton, BorderLayout.NORTH);
		add(signupbutton, BorderLayout.SOUTH);
		
		
		loginbutton.addActionListener(
				
				new ActionListener() 
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							
							if(App.database.get(text1a.getText()).equals(text2a.getText())) {
								/*If the given username exists on the database (if not, catch statement will handle it) 
								 * and maps to an existing account information*/
								for(int i=0;i<App.users.size();i++) {
									if(App.users.get(i).getNickname().equals(text1a.getText())) {
										//If the nicknames match, a new homepage (boş) is created for the user
										boş b=new boş(App.users.get(i));
										App.users.get(i).setPage(b);
										b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
										b.setSize(800, 1000);
										b.setVisible(true);
										setVisible(false);
										dispose();
										for(Content e:App.users.get(i).contents) {
											//Display of the contents, following's first and user's after
											e.setBounds(50, 50, 500, 400);
											e.setVisible(true);
											App.users.get(i).page.panel.add(e);
											
											SwingUtilities.updateComponentTreeUI(App.users.get(i).page.panel);
											
										}
										for(User e:App.users.get(i).getFollowing()) {
											for(Content a:e.contents) {
											a.setBounds(50, 50, 500, 400);
											a.setVisible(true);
											App.users.get(i).page.panel.add(a);
											
											SwingUtilities.updateComponentTreeUI(App.users.get(i).page.panel);}
											
										}
									}
								}
								
								
							}
							
							else {
								//If the nicknames match but passwords do not
								textArea.setText("");
								textArea.append("Invalid password");
								
							}
							}
						
						catch(NullPointerException a){
							//If there is no such an existing account with the given nickname
							textArea.setText("");
								textArea.append("User cannot be found. ");
								System.out.println(a);
								
							
						}
						
					}
						
						
							
						}
						

					
			
		); 
		
		signupbutton.addActionListener(
				//This button creates a new signUp object through which the new users can register
				new ActionListener() 
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						
						signUp c = new signUp();
						c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						c.setSize(295, 370);
						c.setVisible(true);
						setVisible(false);
						dispose();
							
						}}
						
					
			
		); 
		

	}
	
	
	}


