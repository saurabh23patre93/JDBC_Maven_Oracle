package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectTest {
	public static void main(String[] args) throws Exception {
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		//Load the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//create Connection
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","java","java");
		//Create the statement
		st=con.createStatement();
		//Create the ResultSet object
		rs=st.executeQuery("SELECT EMPNO,ENAME,JOB FROM EMP");
		while (rs.next()!=false) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
		//close the object
		rs.close();
		st.close();
		con.close();
	}
}
