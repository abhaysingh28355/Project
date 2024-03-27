package com.railworld.AxisBank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	// ****** Extra added ******
	private int userId;
	private int acBalance;
	// *************************

	public static void main(String[] args) throws Exception {

		App app = new App();

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		User user = new User();
		System.out.println("````````````````````Welcome to AxisBank`````````````````");
		System.out.println("_______________Please Select What you want______________");
		System.out.println("********************************************************");
		System.out.println("1 for new user");
		System.out.println("2 for Login");
		System.out.print("> ");
		Scanner sc = new Scanner(System.in);
		int selection = sc.nextInt();

		switch (selection) {
		case 1:
			System.out.println("Please enter First Name");
			System.out.print("> ");
			String fname = sc.next();
			user.setFirstname(fname);

			System.out.println("Please enter Last Name");
			System.out.print("> ");
			String lname = sc.next();
			user.setLastname(lname);

			System.out.println("Please enter Email");
			System.out.print("> ");
			String email = sc.next();
			user.setEmail(email);

			System.out.println("Please enter Password");
			System.out.print("> ");
			String pass = sc.next();
			user.setPassword(pass);

			System.out.println("Please enter how much amount you want to deposit ");
			System.out.print("> ");
			int amount = sc.nextInt();
			user.setBalance(amount);

			session.persist(user);

			System.out.println("Congrulations! You are a new member of our Bank ");

			t.commit();
			factory.close();
			session.close();

			break;

		case 2:

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/axisbank", "root",
					"ABab12@$");
			PreparedStatement ps = con.prepareStatement("select * from User_bank");

			ResultSet rs = ps.executeQuery();

			System.out.println("Enter Email");
			System.out.print("> ");
			String uname = sc.next();
			System.out.println("Enter Password");
			System.out.print("> ");
			String pass2 = sc.next();
			int c = 1;

			while (rs.next() && c == 1) {
				String name1 = rs.getString("email");
				String name2 = rs.getString("password");

				if (uname.equals(name1) && name2.equals(pass2)) {
					// ****** Extra added ******
					app.userId = rs.getInt("id");
					app.acBalance = rs.getInt("Balance");
					// *************************
					System.out.println(rs.getString("id"));
					c++;
				}
			}
			if (c > 1) {
				System.out.println("Login Success");
				System.out.println("_______________Please Select What you want______________");
				System.out.println("********************************************************");
				System.out.println("1 for User details");
				System.out.println("2 for Edit/Add details");
				System.out.println("3 for Add amount");
				System.out.println("4 for Withdraw Amount");
				System.out.println("5 for Update details");
				System.out.println("6 for Delete Account");
				System.out.println("5 Log out");
				System.out.print("> ");

				Scanner sc2 = new Scanner(System.in);
				int userInput = sc2.nextInt();

				switch (userInput) {
				case 1:
					System.out.println("User Details");
					break;
				case 2:
					System.out.println("Edit/Add details");
					break;
				case 3:
					System.out.println("Enter amount");
					System.out.print("> ");
					// Input scanner
					Scanner sc3 = new Scanner(System.in);
					// New amount
					int newAmount = sc3.nextInt();
					// Old balance from database
					int previousBalance = app.acBalance;
					// Print previous balance
					System.out.println("Previous balance > " + previousBalance);
					// Print new balance
					System.out.println("Added to your account > " + newAmount);
					// Print current balance
					int currentBalance = newAmount + previousBalance;
					System.out.print("Your current balance > ");
					System.out.println(currentBalance);
					// Update the data in database
					User usr = session.get(User.class, app.userId);
					usr.setBalance(currentBalance);
					session.update(usr);
					t.commit();

					break;
				case 4:
					System.out.println("Withdraw balance");
					break;
				case 5:
					
					Scanner sc1 = new Scanner(System.in);
					System.out.println("Please fill your address");
					System.out.print("> ");
					
					//Address
					String Address = sc1.next();
					
					//Account Type
					String Accounttype = sc1.next();
					
					//Gender
					
					String gender = sc1.next();
					
					//Age
					
					int age = sc1.nextInt();
					
					//Phone
					
					long phone = sc1.nextLong();
					
					//State
					String state = sc1.next();
					
					
					User uda = session.get(User.class, app.userId);
					uda.setAddress(Address);
					uda.setIFSC_CODE("AIs123456");
					uda.setAccountType(Accounttype);
					uda.setGender(gender);
					uda.setAge(age);
					uda.setPhoneNo(phone);
					uda.setState(state);
					session.update(uda);
					t.commit();
				
					break;
				case 6:
					System.out.println("Account deleted");
					break;
				case 7:
					System.out.println("You are Loged out");
					break;
				default:
					System.out.println("Invalid input ... please try again");
					break;
				}

			} else {
				System.out.println("Wrong Username or Password ! Please check it once...");
			}

			break;

		default:
			System.out.println("Invalid input ... please try again");
			break;
		}

	}
}
