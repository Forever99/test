package com.zhku.jsj144.zk.Utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * jdbc工具包
 * 1.获得数据库连接对象
 * 2.释放资源
 */
public class JdbcUtils {
	//1.获得数据库连接对象
	public static Connection getConnecion() throws ClassNotFoundException, SQLException{
		Connection con=null;
//		Class.forName("com.mysql.jdbc.driver");//加载驱动
		Class.forName("com.mysql.jdbc.Driver");//加载驱动
		String url="jdbc:mysql://localhost:3306/mydb1?useSSL=false";
		String user="root";
		String password="1234";
		con=DriverManager.getConnection(url, user, password);
		return con; 
	}
	
	//2.释放资源
	public static void relaseResource(ResultSet rs,Statement stmt,Connection con){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs=null;
		}
		
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt=null;
		}
		
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			con=null;
		}
	}

}
