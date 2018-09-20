import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
class Person {
	private String name;
	private List<String>friendList;
	public Person(String n) {
		this.name = n;
		friendList = new List<String>();
	}
	public void addAFriend(String name) {
		friendList.add(name);

	}
	public String getName() {
		return this.name;
	}
	public List getFriendList() {
		return this.friendList;
	}
	public String toString() {
		// String str = "[";
		// for (int i = 0; i < friendList.size()-1; i++) {
		// 	str = str + friendList.get(i) + "," ;
		// }
		// str = str+""+friendList.get(friendList.size() - 1)+"]";
		// return str;
		String str = this.name+": "+friendList.toString();
		return str;
	}
}
class Network {
	private List<Person>userList;
	public Network() {
		userList = new List<Person>();
	}
	public void addPerson(Person name) {
		userList.add(name);
	}
	public String getConnection(String user) {
		for (int i = 0; i < userList.size(); i++) {
			if (user.equals(userList.get(i).getName())) {
				return userList.get(i).toString();
			}
		}
		return "Not a user in Network";
	}
	public void addConnection(String objName, String newName) {
		for (int i = 0; i < userList.size(); i++) {
			if (objName.equals(userList.get(i).getName())) {
				userList.get(i).addAFriend(newName);
			}
		}
	}
	public void getCommonConnection(String p1, String p2) {
		List<String>listOne = new List<String>();
		List<String>listTwo = new List<String>();
		List<String>listResult = new List<String>();
		for (int i = 0; i<userList.size(); i++) {
			if (p1.equals(userList.get(i).getName())) {
				listOne = userList.get(i).getFriendList();
				break;
			}
		}
		for (int i = 0; i<userList.size(); i++) {
			if (p2.equals(userList.get(i).getName())) {
				listTwo = userList.get(i).getFriendList();
				break;
			}
		}
		for (int i = 0; i<listOne.size(); i++) {
			if (listTwo.contains(listOne.get(i))) {
				listResult.add(listOne.get(i));
			}
		}
		System.out.println(listResult);
	}
	public void show() {
		String[] userData = new String[userList.size()];
		for (int i = 0; i<userList.size(); i++) {
			userData[i] = userList.get(i).toString();
		}
		Arrays.sort(userData);
		String s = Arrays.toString(userData);
		System.out.println(s.substring(1,s.length()-1));

	}
}

class SocialNetwork {
	public SocialNetwork() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Network n = new Network();
		while (sc.hasNext()) {
			String line = sc.nextLine();
			if (line.contains("is connected to")) {
				String[] tokens = line.split(" is connected to ");
				String[] items = tokens[1].replace(".", "").split(", ");
				Person userObject = new Person(tokens[0]);
				for (int i = 0; i < items.length; i++) {
					userObject.addAFriend(items[i]);
				}
				n.addPerson(userObject);
			}
			else {
				String[] check = line.split(" ",2);
				switch (check[0]) {
				case "getConnections":
				System.out.println(n.getConnection(check[1]));
				break;
				case "addConnections":
				String[] list = check[1].split(" ");
				n.addConnection(list[0], list[1]);
				break;
				case "CommonConnections":
				String[] list1 = check[1].split(" ");
				n.getCommonConnection(list1[0], list1[1]);
				break;
				case "Network":
				n.show();
				default:
				}
			}
		}
	}
}