package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import application.User;

public class AppConnectDB {
	private Connection mConnection;
	private Statement mStatement;
	List<User> mListAccount;
	int posUser;
	Scanner sc;

	public AppConnectDB() throws ClassNotFoundException, SQLException {
		mConnection = SQLServerConnUtils.getSQLServerConnection();
		mListAccount = new ArrayList<>();
		if (mConnection != null) {
			try {
				mStatement = mConnection.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<User> getListAccount() {
		String query = "Select * from " + StructureDB.TABLE_USER;
		ResultSet resultSet = null;
		try {
			resultSet = mStatement.executeQuery(query);
			while (resultSet.next()) {
				mListAccount.add(new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(query);
		}
		return mListAccount;
	}

	public boolean isExistUserInDB(String strCheck) {
		mListAccount = getListAccount();
		int size = mListAccount.size();
		boolean result = false;
		for (int i = 0; i < size; i++) {
			if (strCheck.equalsIgnoreCase(mListAccount.get(i).getAccount())) {
				result = true;
				posUser = i;
			}
		}
		return result;
	}

	public void updateProfileToDB(String account) {
		String sql = "UPDATE User_table SET First_Name = ?, Last_Name = ?, Account = ?, Email = ? WHERE ID= ?";

		if (isExistUserInDB(account)) {
			// editProfile();
			try {
				PreparedStatement preparedStatement = mConnection.prepareStatement(sql);
				preparedStatement.setInt(5, mListAccount.get(posUser).getId());
				preparedStatement.setString(1, mListAccount.get(posUser).getFirstName());
				preparedStatement.setString(2, mListAccount.get(posUser).getLastName());
				preparedStatement.setString(3, mListAccount.get(posUser).getAccount());
				preparedStatement.setString(4, mListAccount.get(posUser).getEmail());
				preparedStatement.execute();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	public User enterInfoUser() {
		sc = new Scanner(System.in);
		System.out.print("Enter First Name: ");
		String firstName = sc.nextLine();
		System.out.print("Enter Last Name: ");
		String lastName = sc.nextLine();
		System.out.print("Enter your Account: ");
		String account = sc.nextLine();
		System.out.println("Enter your email: ");
		String email = sc.nextLine();
		return new User(10, firstName, lastName, account, email);
	}

	public void showListProfile() {
		mListAccount = getListAccount();
		for (int i = 0; i < mListAccount.size(); i++) {
			System.out.println(mListAccount.get(i).toString());
		}
	}

	public void getListProflie() {

	}
}
