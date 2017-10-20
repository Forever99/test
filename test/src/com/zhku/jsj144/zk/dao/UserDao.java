package com.zhku.jsj144.zk.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zhku.jsj144.zk.Utils.JdbcUtils;
import com.zhku.jsj144.zk.domain.User;

//持久层
public class UserDao {

	public User login(User user) throws ClassNotFoundException, SQLException {
		User result=new User();
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		con = JdbcUtils.getConnecion();//获得连接对象
		//查询语句
		String name=user.getName();
		String password=user.getPassword();
		String sql="select * from user where name='"+name+"' and password='"+password+"'";
//		String sql="select * from user where name='张三' and password='1234'";
		stmt=con.createStatement();
		rs=stmt.executeQuery(sql);
		
		if(rs.next()){
			int id=rs.getInt("id");
			name=rs.getString("name");
			password=rs.getString("password");
			String sex=rs.getString("sex");
			
			result.setId(id);
			result.setName(name);
			result.setPassword(password);
			result.setSex(sex);
			
		}
		else{
			result=null;
		}
		
		//释放资源
		JdbcUtils.relaseResource(rs, stmt, con);
		return result;
	}
}
