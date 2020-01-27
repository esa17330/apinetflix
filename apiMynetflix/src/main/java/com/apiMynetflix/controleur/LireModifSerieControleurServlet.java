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
import com.apiMynetflix.modele.Genre;
import com.apiMynetflix.modele.Serie;

@WebServlet("/LireModifSerie")
public class LireModifSerieControleurServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	SerieDao seriedao;
	Serie serie;
	List<Genre> genres;
	int id = 0;
	StringBuilder sb = null;

	private static final String VUE_FORMULAIRE = "/WEB-INF/jsp/patchSerie.jsp";
	private static final String CONTROLE_OK = "1 enregistrement SERIE mis à jour";
	private static final String CONTROLE_NOK = "Aucune mise à jour de SERIE n'a été effectuée !!!";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		seriedao = (SerieDao) getServletContext().getAttribute("seriedao");
		genres = new ArrayList<>();

		if (req.getParameter("serie") != null)
			id = Integer.valueOf(req.getParameter("serie"));
		if (id > 0) {
			try {

				serie = seriedao.getSerie(id);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

			req.setAttribute("serie", serie);
			req.setAttribute("idstatut", serie.getidStatut());
			req.setAttribute("idpaysorig", serie.getIdPaysOrigine());
			genres = seriedao.getGenreSerie(serie.getId());
			sb = new StringBuilder();
			for (Genre g : genres) {
				sb.append(g.getLibelle());
				sb.append(",");
			}
			req.setAttribute("genresTolibelle", sb);
		} else {
			String err = "N° ID incorrect";
			req.setAttribute("err", err);
		}
		getServletContext().getRequestDispatcher(VUE_FORMULAIRE).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int control = 0;

		seriedao = (SerieDao) getServletContext().getAttribute("seriedao");
		String[] genres = req.getParameterValues("genre");
		int[] tab_genres = getGenreToInt(genres);
		String nom = req.getParameter("nom");
		String nomoriginal = req.getParameter("nomoriginal");
		String anneedeparution = req.getParameter("anneeparution");
		String synopsis = req.getParameter("synopsis");
		String statut = req.getParameter("statut");
		String pays = req.getParameter("pays");

		Serie serie = new Serie(id, nom, nomoriginal, Integer.parseInt(anneedeparution), synopsis,
				Integer.parseInt(statut), Integer.parseInt(pays));
		req.setAttribute("serie", serie);
		req.setAttribute("genres", genres);
		try {
			control = seriedao.modifier(serie, tab_genres);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		if (control == 0)
			req.setAttribute("control", CONTROLE_NOK);
		else
			req.setAttribute("control", CONTROLE_OK);
		getServletContext().getRequestDispatcher(VUE_FORMULAIRE).forward(req, resp);

	}

	private int[] getGenreToInt(String[] ts) {
		int[] ti = new int[ts.length];
		for (int i = 0; i < ts.length; i++) {
			ti[i] = Integer.valueOf(ts[i]);
		}
		return ti;
	}

}
