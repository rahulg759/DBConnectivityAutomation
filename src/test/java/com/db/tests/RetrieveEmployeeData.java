package com.db.tests;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.db.base.BaseClass;

public class RetrieveEmployeeData extends BaseClass{
	
	@Test
	public void retrieveDataEmployee() throws SQLException {
		stmt=conn.createStatement();  

		//step4 execute query  
		rs=stmt.executeQuery("select * from employee");  
		while(rs.next())  
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6));  
	}
	}