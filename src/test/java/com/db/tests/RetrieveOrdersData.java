package com.db.tests;

import org.testng.annotations.Test;

import java.sql.SQLException;
import com.db.base.BaseClass;

public class RetrieveOrdersData extends BaseClass{

	@Test(priority=2, dependsOnMethods="getOrderDataForID")
	public void retrieveOrderData() throws SQLException {
		
		stmt=conn.createStatement();

		rs=stmt.executeQuery("select * from orders");   

		while(rs.next())  
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));  
	}
	
	@Test(priority=1)
	public void getOrderDataForID() throws SQLException {
		
		int orderid= 10251;
		
		stmt=conn.createStatement();
		rs=stmt.executeQuery("select * from orders where orderid=\'10253\'");		
		rs=stmt.executeQuery("select * from orders where orderid=\'"+orderid+"\'");
		
		System.out.println("Order details for id : ");
		while(rs.next())  
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\n");  
	} 
		
	}

