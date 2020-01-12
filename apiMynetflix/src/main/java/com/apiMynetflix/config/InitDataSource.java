/*
 * package com.apiMynetflix.config;
 * 
 * import javax.servlet.ServletContext; import
 * javax.servlet.ServletContextEvent; import
 * javax.servlet.ServletContextListener;
 * 
 * import com.apiMynetflix.Dao.MyDataSource;
 * 
 * public class InitDataSource implements ServletContextListener {
 * 
 * private static final String DATASOURCE = "datasource";
 * 
 * private MyDataSource dts;
 * 
 * public void contextInitialized(ServletContextEvent event) { ServletContext
 * servletcontext = event.getServletContext();
 * 
 * servletcontext.setAttribute(DATASOURCE, dts.getDataSource()); }
 * 
 * }
 */