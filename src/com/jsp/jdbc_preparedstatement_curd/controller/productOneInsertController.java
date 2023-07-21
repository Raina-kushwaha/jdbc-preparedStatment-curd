package com.jsp.jdbc_preparedstatement_curd.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class productOneInsertController {
	public static void main(String[]args) {
		Connection connection=null;
		try {
			//step-1 load driver& load register
			Class.forName("com.mysql.cj.jdbc.Driver");
			//step-2 create connection
			String url="jdbc:mysql://localhost:3306/jdbc-preparedstatement";
			String user="root";
			String pass="motu";
			connection=DriverManager.getConnection(url, user, pass);
			String insertQuery="insert into product values(?,?,?,?)";
			//step-3 create statement
			PreparedStatement prepareStatement =connection.prepareStatement(insertQuery);
			// step-4 Execute Query
			
			prepareStatement.setInt(1,100);
			prepareStatement.setString(2,"pen");
			prepareStatement.setDouble(3,20);
			prepareStatement.setString(4,"black");
			prepareStatement.execute();
			
			
			System.out.println("data inserted==============");
			
			
		}catch(ClassNotFoundException | SQLException e){
			//Todo auto generate catch block
			e.printStackTrace();
			
		}finally {
			try {
				//step-5 close the connection
				if(connection!=null) {
					connection.close();
				}
				else {
					System.out.println("first establish the connection=====> ");
				}
			}catch(SQLException e) {
				//Todo auto generate catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

}
