package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest_07 {

	public static void main(String[] args) {
		Scanner sc=null;
		int empno=0;
		Connection con=null;
		Statement st=null;
		String query=null;
		ResultSet rs=null;
		
		try {
			//Read the Inputs from end user
			sc=new Scanner(System.in);
			if (sc!=null) {
				System.out.println("Enter the Empno::");
				empno=sc.nextInt();
			}//end if
			//Register the JDBC Driver
			Class.forName("jdbc.oracle.driver.OracleDriver");
			//Establishing the connection with db
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","java","java");
			//create Statement object
			if (con!=null) {
				st=con.createStatement();
			}
			query="SELECT *FROM EMP WHERE EMPNO="+empno;
			//send and execute query
			if (st!=null) {
				rs=st.executeQuery(query);
				//process the ResultSet
				if (rs!=null) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getInt(7)+" "+rs.getInt(8));	
				}
				else {
					System.out.println("Emp not found");
				}
			}
		} catch(SQLException se)
			{
				se.printStackTrace();
				}
		catch(ClassNotFoundException cnf){cnf.printStackTrace();}
		catch(Exception e){e.printStackTrace();
		}//end catch
		finally {
			try{
				if(rs!=null)
					rs.close();
				}
			catch(SQLException se)
				{
					se.printStackTrace();
			}
			try{
				if(st!=null)
					st.close();
				}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
    		try{
    			if(con!=null)
    				con.close();
    			}
			catch(SQLException se)
    		{
				se.printStackTrace();
			}
		}

	}

}
