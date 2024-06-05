package INTERNAL;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class User {

	private String nickname;
	private String password;
	private String name;
	private String surname;
	private ArrayList<User> followers=new ArrayList<User>();
	private ArrayList<User> following=new ArrayList<User>();
	private String age;
	private String email;
	String accountType;
	ArrayList<String> contentpaths=new ArrayList<String>();
	public ArrayList<Content> contents=new ArrayList<Content>();
	public boş page;
	public Map<String, String>contdescrptn=new HashMap<String, String>();//This HashMap keeps content paths and matching contents' captions
	
	public boş getPage() {
		return page;
	}

	public void setPage(boş page) {
		this.page = page;
	}

	
	
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<User> getFollowers() {
		return followers;
	}

	public void setFollowers(ArrayList<User> followers) {
		this.followers = followers;
	}

	public ArrayList<User> getFollowing() {
		return following;
	}

	public void setFollowing(ArrayList<User> following) {
		this.following = following;
	}

	public User(String nickname, String password, String name, String surname, String age, String email, String type) {
		//User information is stored in the HashMap App.database as well as ArrayList<User> App.users 
		App.database.put(nickname, password);
		App.users.add(this);
		this.nickname = nickname;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.email = email;
		this.accountType=type;
		
		
	}
	
	public GroupData search(String name){
		//A searching method that returns needed GroupData
		for(GroupData group:App.getGroups()) {
			if(group.getGroupName().equals(name)) {
				return group;
			}
		}
		return null;
	}
	
	public Group searchgroup(String name){
		//A searching method that returns needed Group
		for(Group group:App.getGroupsnd()) {
			if(group.getGroupName().equals(name)) {
				return group;
			}
		}
		return null;
	}
	public Content searchcontent(String name){
		//A searching method that returns needed Content
		for(Content group:this.contents) {
			if(group.getPath().equals(name)) {
				return group;
			}
		}
		return null;
	}
	

	public void follow(User user) {
		
		user.followers.add(this);
		this.following.add(user);
	}
	
	public void unfollow(User user) {
		
		user.followers.remove(this);
		this.following.remove(user);
	}
	
	public void joingroup(GroupData group) {
		group.members.add(this);
	}
	public void leavegroup(GroupData group) {
		group.members.remove(this);
	}
}

