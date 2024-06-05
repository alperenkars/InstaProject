package INTERNAL;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Group extends JFrame{


	public User creator;
	
	private JPanel contentPane;
	public JPanel panel;
	public GroupData gdata;
	public String groupName;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;

	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JPanel pane;
	private User visitor;

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public GroupData getGdata() {
		return gdata;
	}

	public void setGdata(GroupData gdata) {
		this.gdata = gdata;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Group(GroupData a, User visitor) {
		//GroupData contains all the necessary information related to each group object and visitor's status of membership determines the parts to be displayed.
			this.visitor=visitor;
			this.gdata = a;
			this.creator=a.creator;
			this.groupName=a.getGroupName();
	        setTitle("Group:"+a.groupName);
	        App.groupsnd.add(this);
	        setLayout(new BorderLayout());
	        //This is showed on top of the page, relevant group information
	        JLabel m1 = new JLabel("Country:"+a.country+"  Creator:"+creator.getNickname()+"  Hobbies:"+a.hobbies);
	        this.panel = new JPanel();
	        
	        panel.setLayout((LayoutManager) new BoxLayout(panel, BoxLayout.Y_AXIS));
	        panel.setAutoscrolls(true);
	        add(panel,BorderLayout.NORTH);
	        
	        

	        JScrollPane scrollPane = new JScrollPane(panel);
	        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	        scrollPane.setBounds(50, 30, 500, 750);

	        contentPane = new JPanel(null);
	        contentPane.setPreferredSize(new Dimension(600, 900));
	        contentPane.add(scrollPane);

	       add(m1, BorderLayout.NORTH);
	        add(contentPane, BorderLayout.CENTER);
	       pack();	
	        if(a.contents.isEmpty()!=true) {
	        	
	      
	       
	       for(Content t:a.contents) {
	        	
	        	//This loop adds each content to the group page
	        	 
      		 
      		 
       		t.setBounds(50, 50, 500, 500);
       		t.setVisible(true);
       		panel.add(t); 
       		panelReset(panel);
 			
       }}

	        
	        
	        
	        
	        
	        

	       
	   		pane = new JPanel();
	        btnNewButton_1 = new JButton("POST NEW CONTENT");
	        //This button creates a filechooser object for selecting the post&text to be shared
			btnNewButton_1.addActionListener(
					
					new ActionListener() 
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {
							
							filechooser h = new filechooser(visitor, groupName);
							h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							h.setSize(300, 350);
							h.setVisible(true);
							
						

						}
					}
			); 
			btnNewButton_3 = new JButton("LEAVE GROUP");
			btnNewButton_3.setVisible(false);
			
			btnNewButton_2 = new JButton("JOIN GROUP");
			btnNewButton_2.addActionListener(
					/*This part hides and displays several buttons through the method asMember(), 
					 * adds the user to the database and displays the group's content
					 */
					new ActionListener() 
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {
							  
							makePostVisible();
							a.members.add(visitor);
							asMember();
							
							
							panelReset(pane);
					
							
							

						}
					} 
			);
			
			
			btnNewButton_3.addActionListener(
					//Conversely, this button removes the user from the group and adjusts the membership status of the user through asVisitor()
					new ActionListener() 
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {
							
							
							a.members.remove(visitor);
							asVisitor();
							panelReset(pane);
					
							
							
						
						}
					} 
			); 

			btnNewButton_4 = new JButton("MEMBERS");
			//This button creates a JFrame in which the group members as well as a Back button are displayed
			btnNewButton_4.addActionListener(
					
					new ActionListener()
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {
							
							JFrame h = new JFrame();
							JPanel p = new JPanel();
							JButton leavebutton=new JButton("Back");
							//Return back to the group page
							leavebutton.addActionListener(
									
									new ActionListener() 
									{ 
										@Override
										public void actionPerformed(ActionEvent arg0) {
											h.setVisible(false);
											h.dispose();
											
											

										}
									}
							); 
							p.add(leavebutton);
							
							for(User k:a.members) {
								//Creating buttons for each member of the group and adding them to the panel
								JButton userbutton=new JButton(k.getNickname());
								p.add(userbutton);
							}
							h.add(p);
							
							h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							h.setSize(440, 350);
							h.setVisible(true);
							
							
						

						}
					}
			); 
			btnNewButton_5 = new JButton("REMOVE MEMBER");
			//This button is only active for the Creator, it displays the members of the group as buttons and removes the selected one from the group
			btnNewButton_5.addActionListener(
				
					new ActionListener() 
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {
							JFrame h = new JFrame();
							JPanel p = new JPanel();
							JButton leavebutton=new JButton("Back");
							//Return back to the group page
							leavebutton.addActionListener(
								
									new ActionListener() 
									{ 
										@Override
										public void actionPerformed(ActionEvent arg0) {
											h.setVisible(false);
											h.dispose();
											
											
										}
									} 
							); 
							p.add(leavebutton);
							
							for(User k:a.members) {
								//Creating a button for each member if they are not the Creator
								if(k.getNickname().equals(creator.getNickname())!=true) {
								JButton userbutton=new JButton(k.getNickname());
								userbutton.addActionListener(
									//Removal of clicked member
										new ActionListener() 
										{ 
											@Override
											public void actionPerformed(ActionEvent arg0) {
												a.members.remove(k);
												h.setVisible(false);
												h.dispose();
												
												
												
												

											}
										} 
								); 
								p.add(userbutton);
								
								
							}
							h.add(p);
							
							h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							h.setSize(440, 350);
							h.setVisible(true);
							
							
						

						}
						}} 
			); 
			
			btnNewButton_6 = new JButton("DELETE GROUP");
			//This basic utility allows the Creator to delete the group by deleting its information from databases and making it invisible
			btnNewButton_6.addActionListener(
					
					new ActionListener()
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {
							visitor.page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							visitor.page.setSize(800, 1000);
							visitor.page.setVisible(true); 
							setVisible(false);
							dispose();
							App.groups.remove(gdata);
							
							
							
							
						}
					} 
			); 
			
			btnNewButton_7 = new JButton("MAIN PAGE");
			//Allows user to go back to the main page
			btnNewButton_7.addActionListener(
					
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
			
			//Adding the buttons to the panel -pane- in the right-hand side
	        pane.setLayout((LayoutManager) new BoxLayout(pane, BoxLayout.Y_AXIS));
	        pane.setSize(300,900);
	        pane.add(btnNewButton_1);
	        pane.add(btnNewButton_2);
	        pane.add(btnNewButton_3);
	        pane.add(btnNewButton_4);
	        pane.add(btnNewButton_5);
	        pane.add(btnNewButton_6);
	        pane.add(btnNewButton_7);
	        add(pane,BorderLayout.EAST);
	        
	        //These selection statements determine the membership status of the user and call necessary methods
	        if(gdata.members.contains(visitor)!=true) {
	        	asVisitor();
	        }
	        else if(gdata.creator.getNickname().equals(visitor.getNickname())) {
	        	asCreator();
	        }
	        else {
	        	asMember();
	        }
	}
	
	public void makePostUnvisible() { /*This method makes posts invisible, it is to be used when someone leaves the group*/
		
		panel.setVisible(false);
		panelReset(panel);
		
	}
	public void makePostVisible() {
		 /*If the visitor joins a group, then this method displays group's posts in its page*/
			panel.setVisible(true);
    		panelReset(panel);
	
	
	
}
	public void panelReset(JPanel p){
		//Resetting a panel
		SwingUtilities.updateComponentTreeUI(p);
		
		p.invalidate();
		p.validate();
		p.repaint();
	}
	public void addPost(Content k){
		//Adding a post to both database and to the group
		gdata.contents.add(k);
		panel.add(k);
		panelReset(panel);
		
	}
	public void asCreator(){
		//Adjusting the buttons' visibility according to the membership status
		btnNewButton_5.setVisible(true);
		btnNewButton_6.setVisible(true);
		btnNewButton_4.setVisible(true);
		btnNewButton_1.setVisible(true);
		btnNewButton_2.setVisible(false);
		panelReset(pane);
		
		
	}
	public void asVisitor(){
		//Adjusting the buttons' visibility according to the membership status
		makePostUnvisible();
		btnNewButton_5.setVisible(false);
		btnNewButton_6.setVisible(false);
		btnNewButton_4.setVisible(false);
		btnNewButton_1.setVisible(false);
		btnNewButton_2.setVisible(true);
		btnNewButton_3.setVisible(false);
		panelReset(pane);
	}
	public void asMember(){
		//Adjusting the buttons' visibility according to the membership status
		btnNewButton_5.setVisible(false);
		btnNewButton_6.setVisible(false);
		btnNewButton_4.setVisible(true);
		btnNewButton_1.setVisible(true);
		btnNewButton_2.setVisible(false);
		btnNewButton_3.setVisible(true);
		panelReset(pane);
		
	}}


