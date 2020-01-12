package com.apiMynetflix.Dao;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitConnectionDao implements ServletContextListener {

	private static final String CONNEXION = "connexion";

	public void contextInitialized(ServletContextEvent ev) {
		ServletContext servletcontext = ev.getServletContext();
		try {

			servletcontext.setAttribute(CONNEXION, MariaDbConnection.getCnx());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
