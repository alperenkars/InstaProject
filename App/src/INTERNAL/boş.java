package INTERNAL;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class boş extends JFrame{

	public User user;
	private JPanel contentPane;
	public JPanel panel;
	public boş(User user) {
		
	        setTitle("COMP132 APP");
	       
	        setLayout(new BorderLayout());

	        JLabel m1 = new JLabel(user.getNickname()+"'s Page");
	        
	        
	        for(User flwing:user.getFollowing()) {/*This part displays all the contents in the main page by iterating over the list of people that the user follows and by using the database unique to them, namely 'contentpaths'*/
	        	for(String pth:flwing.contentpaths) {
	        	Content a=new Content(flwing,"aa",LocalDateTime.now(),flwing.contdescrptn.get(pth),pth);
	        	 
	        		 
	        		 
	        		a.setBounds(50, 50, 500, 500);
	        		a.setVisible(true);
	        		panel.add(a); 
	        		SwingUtilities.updateComponentTreeUI(panel);
	  			
	  			panel.invalidate();
	  			panel.validate();
	  			panel.repaint();
	  			for(String path:user.contentpaths) {/*This part displays all the contents created by the users her/himself*/
	  				Content b=new Content(user,"aa",LocalDateTime.now(),user.contdescrptn.get(path),path);
		        	 
	        		 
	        		 
	        		b.setBounds(50, 50, 500, 500);
	        		b.setVisible(true);
	        		panel.add(b); 
	        		SwingUtilities.updateComponentTreeUI(panel);
	  			
	  			panel.invalidate();
	  			panel.validate();
	  			panel.repaint();
	  			}
	        }}
	        this.panel = new JPanel();
	        
	        panel.setLayout((LayoutManager) new BoxLayout(panel, BoxLayout.Y_AXIS));
	        panel.setAutoscrolls(true);
	        add(panel,BorderLayout.NORTH);
	        
	        

	        JScrollPane scrollPane = new JScrollPane(panel);
	        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	        scrollPane.setBounds(50, 30, 500, 750);

	        JPanel contentPane = new JPanel(null);
	        contentPane.setPreferredSize(new Dimension(600, 900));
	        contentPane.add(scrollPane);

	       add(m1, BorderLayout.NORTH);
	        add(contentPane, BorderLayout.CENTER);
	       pack();
	       JButton btnNewButton_1 = new JButton("CREATE NEW CONTENT");
			btnNewButton_1.addActionListener(
					
					new ActionListener()
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {
						/*This button allows user to share a content through creating a filechooser object, which creates the content*/
							filechooser h = new filechooser(user);
							h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							h.setSize(300, 350);
							h.setVisible(true);
							
							

						}
					} 
			); 
			
			JButton btnNewButton_2 = new JButton(" MY PROFILE "
					+ "\n\n"+user.getNickname());
			btnNewButton_2.addActionListener(
				
					new ActionListener() 
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {
						/*This button creates a new prf object (profile) specific to the user*/	  
							prf profile=new prf(user, user);
							profile.setSize(1000,600);
							
							profile.setDefaultCloseOperation(EXIT_ON_CLOSE);
							profile.setVisible(true);
							setVisible(false);
							dispose();
							
							

						}
					} 
			); 
			
			JButton btnNewButton_3 = new JButton("LOG OUT");
			btnNewButton_3.addActionListener(
			
					new ActionListener() 
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {
							/*This button logs out from the user's account and returns her/him back to the login page*/
							Login c = new Login();
							c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							c.setSize(300, 350);
							c.setVisible(true);
							setVisible(false);
							dispose();
							
							

						}
					} 
			);

			JButton btnNewButton_4 = new JButton("SEARCH FOR PEOPLE");
			btnNewButton_4.addActionListener(
				/*This button creates a new searchTool object which allows the user to search for other users*/
					new ActionListener() 
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {
							
							searchTool h = new searchTool(user);
							h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							h.setSize(440, 350);
							h.setVisible(true);
							
							
						
						}
					} 
			); 
			
			JButton btnNewButton_7 = new JButton("SEARCH FOR GROUPS");
			btnNewButton_7.addActionListener(
					
					new ActionListener() // anonymous inner class
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {
						/*This button creates a new searchTool object -constructor is different from the previous one- which allows the user to search for the groups*/
							searchTool h = new searchTool(user, "kl");
							h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							h.setSize(440, 350);
							h.setVisible(true);
							
							
							

						}
					}
			);

			JButton btnNewButton_5 = new JButton("CREATE A GROUP");
			if(user.accountType.equals("Standard")) {
				btnNewButton_5.setVisible(false);
			}
			btnNewButton_5.addActionListener(
					
					new ActionListener() 
					{ 
						@Override
						public void actionPerformed(ActionEvent arg0) {
						 /*This button allows premium users to create new groups. It is displayed only when the user's account type is Premium*/
							String groupName = JOptionPane.showInputDialog("What is the group name?");
							String countryName = JOptionPane.showInputDialog("What is the country name?");
							String hobbyName = JOptionPane.showInputDialog("What are the hobbies?");
							GroupData data=new GroupData(user,groupName, countryName, hobbyName);
							
							Group newgrp=new Group(data,user);
							newgrp.asCreator();
							newgrp.setSize(800, 1000);
							newgrp.setVisible(true);
							
							setVisible(false);
							dispose();
							
						}
					} 
			); 
			JPanel pane = new JPanel();
			/*This is the right-hand side panel in which there are a plenty of functional buttons*/
	        pane.setLayout((LayoutManager) new BoxLayout(pane, BoxLayout.Y_AXIS));
	        pane.setSize(300,900);
	        pane.add(btnNewButton_1);
	        pane.add(btnNewButton_2);
	        pane.add(btnNewButton_3);
	        pane.add(btnNewButton_4);
	        pane.add(btnNewButton_5);
	        pane.add(btnNewButton_7);
	        add(pane,BorderLayout.EAST);
	}
	public void makePostUnvisible(User a) { 
		/*This method makes posts unvisible, it is used when a user unfollows another user*/
		for(Component t:panel.getComponents()) {
			for(Content b:a.contents) {
				
			if(t.toString().equals(b.toString())) {
			
					
				
				
				t.setVisible(false);
				panel.remove(t);
				SwingUtilities.updateComponentTreeUI(panel);
				
				panel.invalidate();
				panel.validate();
				panel.repaint();}
			}
		}
		
	}
	public void makePostVisible(User profileowner) {
		/*If the visitor starts following user, then this method displays user's posts in main page*/
		for(String pth:profileowner.contentpaths) { 
			Content a=new Content(profileowner,"aa",LocalDateTime.now(),profileowner.contdescrptn.get(pth),pth);
        	 
    		 
    		 
    		a.setBounds(50, 50, 500, 500);
    		a.setVisible(true);
    		panel.add(a);
    		SwingUtilities.updateComponentTreeUI(panel);
			
    		panel.invalidate();
    		panel.validate();
    		panel.repaint();
	}
	
	
}}
