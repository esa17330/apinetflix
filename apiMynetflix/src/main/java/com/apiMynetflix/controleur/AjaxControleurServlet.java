package com.apiMynetflix.controleur;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apiMynetflix.Dao.SerieDao;
import com.apiMynetflix.modele.Serie;
import com.google.gson.Gson;

@WebServlet(urlPatterns = "/ajax", loadOnStartup = 0)
public class AjaxControleurServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	SerieDao seriedao;
	List<Serie> liste = new ArrayList<>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Gson seriejson = new Gson();

		seriedao = (SerieDao) getServletContext().getAttribute("seriedao");
		try {
			liste = seriedao.listerSerie();
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}

		if (req.getParameter("serie") != null) {
			int id;
			id = Integer.valueOf(req.getParameter("serie"));
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			String Stringjson = seriejson.toJson(liste);
			resp.getWriter().print(Stringjson);
			resp.getWriter().flush();
		}

	}
}
