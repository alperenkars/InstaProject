package INTERNAL;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import INTERNAL.User;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;

public class prf extends JFrame {

	private JPanel contentPane;
	public User user;
	public User visitor;
	public JPanel panel_1;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public void panelreset(JPanel panel_1) {/*This method resets the given panel to display recent changes*/
		SwingUtilities.updateComponentTreeUI(panel_1);
		panel_1.invalidate();
		panel_1.validate();
		panel_1.repaint();
		
	}
	public prf(User user, User visitor) {
		this.user=user;
		this.visitor=visitor;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 637);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("PROFILE PHOTO");/*This is the Label where the profile owner's profile photo is displayed*/
		panel.add(lblNewLabel, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.EAST);
		String buttontext="";
		/*This button is multi-functional according to the viewer.
		If the user visits her/his own profile, then the button allows her/him to edit their information. 
		If the user visits another user's profile, then it is a Follow button*/
		if(visitor.getFollowing().contains(user)) {
		
		}
		else if(visitor.getNickname().equals(user.getNickname())) {
			buttontext="Edit Profile";
		}
		else{
			buttontext="Follow";
		}
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		JButton btnNewButton = new JButton(buttontext);
		JButton btnNewButton1 = new JButton("Back");
		/*This button allows user to go back to the main page*/
		btnNewButton1.setSize(40,40);
		panel_3.add(btnNewButton1);
		btnNewButton1.addActionListener(
				 
				new ActionListener() 
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						visitor.page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						visitor.page.setSize(800, 1000);
						visitor.page.setVisible(true);
						setVisible(false);
						dispose();
					}
				} 
		);
		
		JButton btnNewButton2 = new JButton("Unfollow"); 
		/*This button unfollows the user in whose profile this button is placed*/
		btnNewButton1.setSize(40,40);
		panel_3.add(btnNewButton2);
		if(visitor.getFollowing().contains(user)!=true) {
		btnNewButton2.setVisible(false);}
		btnNewButton2.addActionListener(
				 
				new ActionListener()
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						if(visitor.getFollowing().contains(user)) {
							
						visitor.unfollow(user);
						
						visitor.page.makePostUnvisible(user);
						panelreset(contentPane);
						btnNewButton2.setVisible(false);
						btnNewButton.setVisible(true);
						panel_1.setVisible(false);
						panelreset(panel_3);}
						
					}
				} 
		);

		
		btnNewButton.addActionListener(
				 
				new ActionListener() 
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						if(visitor.getFollowing().contains(user)) {
							/*If visitor already follows user, this button does nothing but vanish*/
							
						}
						else if(visitor.getNickname().equals(user.getNickname()))
						/*In this case, this button enables user to edit her/his profile*/ {
							profileEdit c = new profileEdit(user);
							c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							c.setSize(350, 370);
							c.setVisible(true);
							setVisible(false);
							dispose();
						}
						else {
							if(visitor.getFollowing().contains(user)==false) {
							/*In this case, the visitor starts to follow the user */
							visitor.follow(user);
							
							
							panelreset(panel_2);
							
							btnNewButton2.setVisible(true);
							btnNewButton.setVisible(false);
							
				        	visitor.page.makePostVisible(user);
				        		
				        		panelreset(panel_1);
				        		panel_1.setVisible(true);}
							panelreset(contentPane);
				        		
							}
	
							
						}
					});
			
		
		JTextArea textArea = new JTextArea();
		//This is the place where the personal information is displayed
		textArea.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 14));
		textArea.append("Username\n"+user.getNickname()+"\n"+"Name\n"+user.getName()+"\n"+"Surname\n"+user.getSurname()+"\n"+"Account Type\n"+user.accountType);
		textArea.setEditable(false);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		
		
		ArrayList<String> followernames=new ArrayList<String>();
		for(User e:user.getFollowers()) {
			followernames.add(e.getNickname());
		}
		
		
		 panel_1 = new JPanel();
		 //This is the panel in which the Groups and Friends are displayed
		
		
	     
	     
		 if(visitor.getFollowing().contains(user)==false&&visitor.getNickname().equals(user.getNickname())!=true) {
				panel_1.setVisible(false);
			}
		
		
		JTextArea friends=new JTextArea();
		
		//Friends' text area
		friends.setEditable(false);
		friends.append("FRIENDS: ");
		for(User fri:user.getFollowers()) {
			friends.append(fri.getNickname());
			friends.append("  ");
			
		}
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		
		panel_3.add(friends);
		
		JTextArea groups= new JTextArea();
		
		//Groups' text area
		groups.setEditable(false);
		groups.append("GROUPS: ");
		for(GroupData a:App.groups) {
			if(a.members.contains(user)) {
				groups.append(a.getGroupName());
				groups.append("  ");
			}
		}
		panel_3.add(groups);
		
		
		panel_1.setLayout( new BoxLayout(panel_1, BoxLayout.X_AXIS));
	    panel_1.setAutoscrolls(true);
	    add(panel_1,BorderLayout.SOUTH);
	    
	        
	        

	        JScrollPane scrollPane = new JScrollPane(panel_1);
	        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	        scrollPane.setBounds(50, 30, 800, 300);
	        
	        contentPane.add(scrollPane);
	        
	        for(String pth:user.contentpaths) {
	        	
	        	//Display all the contents of the user in her/his profile
	        Content a=new Content(user,"aa",LocalDateTime.now(),user.contdescrptn.get(pth),pth);
	        a.setBounds(50, 50, 500, 500);
    		a.setVisible(true);
    		panel_1.add(a); 
    		panelreset(panel_1);
	        }
	        
		}
	}

