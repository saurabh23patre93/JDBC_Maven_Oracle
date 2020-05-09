package com.nt.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnTest 
{
	public static void main(String[] args)throws Exception 
	{
		//Register JDBC driver with DriverManager service
		//create JDBC Driver class obj
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//oracle.jdbc.driver.OracleDriver obj=new oracle.jdbc.driver.OracleDriver();
		//register jdbc driver softwere+
		//DriverManager.deregisterDriver(obj);
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","java","java");
		if(con!=null)
			System.out.println("connection is established");
				else
			System.out.println("connection is not established");
		
	}
}