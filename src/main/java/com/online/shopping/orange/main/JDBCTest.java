/**
 *@Project: Team-Excellence-Hibernate-Repository
 *
 *@Date: 2015��2��3��
 *@Copyright: 2015 sg.nomaka.tk Inc. All rights reserved.
 */
package com.online.shopping.orange.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Cain
 * 
 */
public class JDBCTest {
	public static void main(String args[]) {
		/*
		 * String url = "jdbc:hsqldb:hsql://localhost:9001"; String className =
		 * "org.hsqldb.jdbcDriver"; String user = "sa"; String password = "sa";
		 * String query = "select * from Email";
		 */

		// String url =
		// "jdbc:derby://localhost:1527//orange;create=true;user=orange;password=orange";
		String url = "jdbc:derby:D://Apache//derby-database//orange";
//		String url="jdbc:derby://localhost:1527//orange";
		String className = "org.apache.derby.jdbc.ClientDriver";
		String user = "orange";
		String password = "orange";
		String query = "select * from USER_ACCOUNT";
		try {
			Class.forName(className);
			Connection conn = DriverManager.getConnection(url, "orange",
					"orange");
			if (conn != null) {
				System.out.println("Connected db success!");
				Statement stmt = conn.createStatement();
				// String sql =
				// "CREATE TABLE TBL_USERS(ID INT, NAME VARCHAR(50))";
				// stmt.execute(sql);
//				String sql = "INSERT INTO TBL_USERS VALUES (1, 'ADMIN')";
//				stmt.executeUpdate(sql);
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					System.out.println(rs.getInt(1));
					System.out.println(rs.getString(2));
					// System.out.println(rs.getString(3));
				}
				if (stmt != null) {
					stmt.close();
				}
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}
