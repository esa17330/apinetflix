package com.apiMynetflix.Dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MariaDbConnection {

	static Connection cnx = null;

	// TODO Auto-generated method stub
	public static Connection getCnx() throws SQLException {
		try {

			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/netflix");
			try {
				cnx = ds.getConnection();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} catch (NamingException e) {
			System.out.println(e);
		}
		return cnx;
	}

}