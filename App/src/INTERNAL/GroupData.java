package INTERNAL;

import java.util.ArrayList;

import javax.swing.JPanel;

public class GroupData {
	public ArrayList<User> members=new ArrayList<User>();
	public ArrayList<Content> contents=new ArrayList<Content>();
	public User creator;	
	public String groupName;
	public String country;
	public String hobbies;
	public Group group;

	public GroupData(User creator,String groupName,String country,String hobbies) {
		//GroupData fundamentally contains all the necessary information for a group
		App.groups.add(this);
		members.add(creator);
		this.creator=creator;
		this.groupName=groupName;
		this.country=country;
		this.hobbies=hobbies;
	}

	public ArrayList<User> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<User> members) {
		this.members = members;
	}

	public ArrayList<Content> getContents() {
		return contents;
	}

	public void setContents(ArrayList<Content> contents) {
		this.contents = contents;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

}
