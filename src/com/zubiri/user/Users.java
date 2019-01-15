package com.zubiri.user;

import java.io.*;
import java.util.Scanner;

public class Users {
	private File users = new File("../../../usersData.txt");
	
	
	public void setUsers(File users) {
		this.users = users;
	}

	public File getUsers() {
		return this.users;
	}
	

	/**
	 * @author Koldo
	 * @param User class object which you want to save in a file named 'userData.txt' in 'src' folder
	 */
	public void setUser(User user) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(users));
			bw.write(user.getName()+"::"+user.getPassword());
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author Koldo
	 * @param username you want to find in the ArrayList of created users
	 * @return index of the User object that has that name, if there's no user with
	 *         that name it returns -1
	 */
	public User getUser(String username) {
		User user = new User();
		try {
			Scanner sc = new Scanner(users);
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] words = line.split("::");
				if(username.equals(words[0])) {
					user.setName(words[0]);
					user.setPassword(words[1]);
				}
			}
			sc.close();
		}catch(FileNotFoundException e) {
			e.getLocalizedMessage();
		}
		return user;
	}

	/**
	 * @author Koldo
	 * @return true if there's any User already added to the ArrayList, else, it
	 *         returns false
	 */
	public boolean hasUser() {
		boolean hasUser = false;
		try {
			Scanner sc = new Scanner(users);
			if (sc.hasNext())
				hasUser = true;
			sc.close();
		}catch(FileNotFoundException e) {
			e.getLocalizedMessage();
		}
		
		return hasUser;
	}
	
}
