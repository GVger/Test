package cn.vger.schedule.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {
	public static Connection getConnection() {
		String urls = "jdbc:mysql://localhost:3306/course_schedule";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(urls, "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("测试这里的异常有没有");
		}
		return con;
	}

	public static void release(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null)
			try {
				rs.close();
			} catch (Exception e) {
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (Exception e) {
			}
		if (conn != null)
			try {
				conn.close();
			} catch (Exception e) {
			}
	}
}
