package INTERNAL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class App {
	public static ArrayList<GroupData> groups=new ArrayList<GroupData>();
	public static ArrayList<Group> groupsnd=new ArrayList<Group>();
	public static ArrayList<User> users=new ArrayList<User>();
	public static Map<String, String>database=new HashMap<String, String>();//This keeps username-password pairs
	public App() {
		// TODO Auto-generated constructor stub
	}
	public static ArrayList<User> getUsers() {
		return users;
	}
	
	public static ArrayList<Group> getGroupsnd() {
		return groupsnd;
	}
	public static void setGroupsnd(ArrayList<Group> groupsnd) {
		App.groupsnd = groupsnd;
	}
	public static ArrayList<GroupData> getGroups() {
		return groups;
	}
	public static void setGroups(ArrayList<GroupData> groups) {
		App.groups = groups;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	

}
