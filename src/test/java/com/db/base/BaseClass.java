package com.db.base;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	public static String dataBaseName = "rahulTestDB";
	public static String dbDriver = "jdbc:sqlserver://localhost:1433/";
	//Windows authentication
	public static String user = "";
	public static String pass = "";
	public String Query;
	public ResultSet rs;
	public Connection conn;
	public Statement stmt;

	@BeforeMethod
	public void setUp() {


		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=rahulTestDB;integratedSecurity=true;" ; 

			conn = DriverManager.getConnection(connectionUrl);  

			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion()+"\n\n");
			}	
		}	
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  		
	}

	@AfterMethod
	public void tearDown() {

		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
