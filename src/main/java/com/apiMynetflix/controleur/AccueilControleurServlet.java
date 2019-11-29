package com.apiMynetflix.controleur;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(urlPatterns = "/",loadOnStartup = 0)
public class AccueilControleurServlet extends HttpServlet{
	
	private InitialContext ic;
    private static DataSource ds = null;       
	private static final long serialVersionUID = 1L;
	private static final String VUE_ACCUEIL = "/WEB-INF/jsp/accueil.jsp";
	
	 public void init() throws ServletException {
	       try { 
	        ic = new InitialContext();
	        Context envContext = (Context) ic.lookup("java:comp/env");
	        ds = (DataSource)envContext.lookup("netflix");        
	    }catch (NamingException e) {
	    	System.out.println(e.getMessage());
	    }
	 }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher(VUE_ACCUEIL).forward(req, resp);
	}
	
	protected static DataSource getDataSource() {
		
		return ds;
	}
	
	
}
