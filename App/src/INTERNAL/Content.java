package INTERNAL;
import java.time.LocalDateTime;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;



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

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Content extends JPanel {

	public User creator;
	public String title;
	private LocalDateTime time;
	private BufferedImage image;
	private String text;
	public JTextField textField;
	private JTextField textField_1;
	public String path;
	public JPanel panel_1;
	public JPanel panel;
	

	
	
	
	
	public User getCreator() {
		return creator;
	}


	public void setCreator(User creator) {
		this.creator = creator;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public BufferedImage getImage() {
		return image;
	}


	public void setImage(BufferedImage image) {
		this.image = image;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public Content(User creator, String title, LocalDateTime time, String text, String path) {
		/*Content has only one constructor which includes the content's creator, its title, creation time, caption and file path*/
		 this.creator=creator;
		 this.title=title;
		 this.time=time;
		 this.path=path;
		 this.text=text;
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBackground(new Color(255, 250, 240));
		
		 panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		
		JButton btnNewButton = new JButton("••");
		btnNewButton.setForeground(new Color(173, 216, 230));
		btnNewButton.setBackground(new Color(255, 0, 255));
		btnNewButton.addActionListener(
				
				new ActionListener() 
				{ 
					@Override
					public void actionPerformed(ActionEvent arg0) {
						/*This button allows user to edit her/his content by creating a filechooser object
						 * -constructor is different from the other filechooser objects, which are used to share a post*/
						filechooser h = new filechooser(path, creator);
						h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						h.setSize(300, 350);
						h.setVisible(true);

									}
								} 
						); 
		textField = new JTextField();
		textField.setForeground(new Color(255, 0, 255));
		textField.setEditable(false);
		textField.setBackground(new Color(173, 216, 230));
		textField.setColumns(10);
		textField.setText(text);
		
		textField_1 = new JTextField(creator.getNickname());
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		panel_1 = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(18)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(28)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(10))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(26))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(3)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		try 
		  {
		   /*This is the part that the image is created through using its file location*/

		   BufferedImage img = ImageIO.read(new File(path));
		   JLabel pic = new JLabel(new ImageIcon(img));
		   panel_1.add(pic);

		  
		  } 
		  catch (IOException e) {}


		
		creator.page.add(this);
		creator.contents.add(this);
		
		for(User use:creator.getFollowers()) {
			//This adds newly created contents to the creator's followers' main pages
			btnNewButton.setVisible(false);
			use.page.add(this);
		}
	}

	
	@Override
	public String toString() {
		return "Content [creator=" + creator + ", path=" + path + "]";
	}
}
