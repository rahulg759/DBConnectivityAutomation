package com.db.tests;

import org.testng.annotations.Test;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.db.base.BaseClass;

public class RetrieveOrderDetailsData extends BaseClass{

	@Test
	public void retrieveDataEmployee() throws SQLException {
		stmt=conn.createStatement();  

		rs=stmt.executeQuery("select * from orderdetails");  

		while(rs.next())  
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));  
	}
}
