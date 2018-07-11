package application;

import java.sql.SQLException;
import java.util.Scanner;

import database.AppConnectDB;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		AppConnectDB appConnectDB = new AppConnectDB();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your account,please: ");
		String account = sc.nextLine();
		System.out.println("Enter your first name, please: ");
		String firstName = sc.nextLine();
		System.out.println("Enter your last name, please: ");
		String lastName = sc.nextLine();
		System.out.println("Enter your email, please: ");
		String email = sc.nextLine();
		if (appConnectDB.isExistUserInDB(account)) {
			appConnectDB.updateProfileToDB(account);
		}
	}

}
