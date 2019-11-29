package com.apiMynetflix.controleur;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BddDataSource  {
	
	private DataSource ds;
		
		
		// TODO Auto-generated method stub
	public BddDataSource() throws NamingException {
	
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:comp/env");
		ds = (DataSource) envContext.lookup("netflix");
		
	}	
	
	public DataSource getDataSource() {
		return ds;
	}
	
}
	

