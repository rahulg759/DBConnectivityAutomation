package com.db.rough;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {

	 public static void main(String[] args) {
		 
	        Connection conn = null;
	 
	        try {
	 //"jdbc:sqlserver://localhost:1433;" + "databaseName=rahulTestDB";
	            String dbURL = "jdbc:sqlserver://localhost:1433";
	            String user = "LAPTOP-E069LGRR\\rahul";
	            String pass = "";
	            conn = DriverManager.getConnection(dbURL, user, pass);
	            if (conn != null) {
	                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
	                System.out.println("Driver name: " + dm.getDriverName());
	                System.out.println("Driver version: " + dm.getDriverVersion());
	                System.out.println("Product name: " + dm.getDatabaseProductName());
	                System.out.println("Product version: " + dm.getDatabaseProductVersion());
	            }
	 
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
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


