package com.apiMynetflix.controleur;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apiMynetflix.Dao.SerieDao;
import com.apiMynetflix.modele.Serie;

@WebServlet("/CreerSerie")
public class CreerSerieControleurServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VUE_FORMULAIRE = "/WEB-INF/jsp/ajoutSerie.jsp";

	Serie serie;
	int control;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		getServletContext().getRequestDispatcher(VUE_FORMULAIRE).forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SerieDao seriedao = (SerieDao) getServletContext().getAttribute("seriedao");
		String[] genres = req.getParameterValues("genre");
		int[] tab_genres = getGenreToInt(genres);
		String nom = req.getParameter("nom");
		String nomoriginal = req.getParameter("nomoriginal");
		String anneedeparution = req.getParameter("anneedeparution");
		String synopsis = req.getParameter("synopsis");
		String statut = req.getParameter("statut");
		String pays = req.getParameter("pays");

		Serie serie = new Serie(nom, nomoriginal, Integer.parseInt(anneedeparution), synopsis, Integer.parseInt(statut),
				Integer.parseInt(pays));
		req.setAttribute("serie", serie);
		try {
			control = seriedao.creer(serie, tab_genres);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher(VUE_FORMULAIRE);
		rd.forward(req, resp);

	}

	private int[] getGenreToInt(String[] ts) {
		int[] ti = new int[ts.length];
		for (int i = 0; i < ts.length; i++) {
			ti[i] = Integer.valueOf(ts[i]);
		}
		return ti;
	}

}
