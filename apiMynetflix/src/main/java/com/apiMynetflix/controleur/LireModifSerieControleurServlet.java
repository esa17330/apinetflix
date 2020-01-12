package com.apiMynetflix.controleur;

import java.io.IOException;
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

	private static final String VUE_FORMULAIRE = "/WEB-INF/jsp/patchSerie.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		seriedao = (SerieDao) getServletContext().getAttribute("seriedao");
		genres = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		if (req.getParameter("serie") != null)
			id = Integer.valueOf(req.getParameter("serie"));
		serie = seriedao.getSerie(id);

		req.setAttribute("serie", serie);
		req.setAttribute("idstatut", serie.getidStatut());
		req.setAttribute("idpaysorig", serie.getIdPaysOrigine());
		genres = seriedao.getGenreSerie(serie.getId());
		for (Genre g : genres) {
			sb.append(g.getLibelle());
			sb.append(",");
		}
		req.setAttribute("genresTolibelle", sb);

		getServletContext().getRequestDispatcher(VUE_FORMULAIRE).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		seriedao = (SerieDao) getServletContext().getAttribute("seriedao");
		String nom = req.getParameter("nom");
		String nomoriginal = req.getParameter("nomoriginal");
		String anneedeparution = req.getParameter("anneeparution");
		String synopsis = req.getParameter("synopsis");
		String statut = req.getParameter("statut");
		String pays = req.getParameter("pays");

		Serie serie = new Serie(id, nom, nomoriginal, Integer.parseInt(anneedeparution), synopsis,
				Integer.parseInt(statut), Integer.parseInt(pays));
		req.setAttribute("serie", serie);
		seriedao.modifier(serie);

		getServletContext().getRequestDispatcher(VUE_FORMULAIRE).forward(req, resp);

	}

}
