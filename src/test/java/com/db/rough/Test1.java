package com.db.rough;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test1 {

	static String dataBaseName = "rahulTestDB";
	static String dbDriver = "jdbc:sqlserver://localhost:1433/";
	//Windows authentication
	static String user = "";
	static String pass = "";
	String Query;
	ResultSet rs;

	public static void main(String[] args) throws SQLException {

		Connection conn=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=rahulTestDB;integratedSecurity=true;" ; 

			conn = DriverManager.getConnection(connectionUrl);  

			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
			}

			System.out.println(" ======================================================================================================");

			Statement stmt=conn.createStatement();  

			//step4 execute query  
			ResultSet rs=stmt.executeQuery("select * from employee");  
			while(rs.next())  
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6));  





		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}