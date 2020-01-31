package com.apiMynetflix.controleur;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apiMynetflix.Dao.SerieDao;
import com.apiMynetflix.modele.Serie;

@WebServlet("/Serie")
public class SerieControleurServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VUE_FORMULAIRE1 = "/WEB-INF/jsp/serie.jsp";
	SerieDao seriedao;
	List<Serie> liste;
	Map<String, Integer> rows = new HashMap<>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id;

		String annee = null;
		seriedao = (SerieDao) getServletContext().getAttribute("seriedao");
		fillSeries();
		if (req.getParameter("serie") != null) {
			id = Integer.valueOf(req.getParameter("serie"));
			for (Serie s : liste) {
				if (s.getId() == id) {
					annee = Integer.toString(s.getAnneeParution());

					break;
				}

			}

		}
		if (req.getParameter("supprimer") != null) {
			id = Integer.valueOf(req.getParameter("supprimer"));
			try {
				rows = seriedao.supprimerSerie(id);
				fillSeries();
				getServletContext().setAttribute("liste_rows", rows);

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		getServletContext().setAttribute("annee", annee);
		req.setAttribute("serie", liste);
		getServletContext().getRequestDispatcher(VUE_FORMULAIRE1).forward(req, resp);

	}

	private void fillSeries() {
		try {
			liste = seriedao.listerSerie();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
