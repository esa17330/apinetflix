package com.apiMynetflix.controleur;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apiMynetflix.Dao.SaisonDao;
import com.apiMynetflix.Dao.SerieDao;
import com.apiMynetflix.modele.Saison;
import com.apiMynetflix.modele.Serie;

@WebServlet("/Saison")
public class SaisonControleurServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VUE_FORMULAIRE1 = "/WEB-INF/jsp/saison.jsp";
	SerieDao seriedao;
	SaisonDao saisondao = new SaisonDao();
	List<Serie> liste = new ArrayList<>();
	List<Saison> liste_saison = new ArrayList<>();
	Map<String, Integer> rows = new HashMap<>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id;

		seriedao = (SerieDao) getServletContext().getAttribute("seriedao");
		getServletContext().setAttribute("saisondao", saisondao);

		liste = fillSeries();

		if (req.getParameter("serie") != null) {
			id = Integer.valueOf(req.getParameter("serie"));
			liste_saison = saisondao.listerSaison(id);

		}
		if (req.getParameter("supprimer") != null) {
			id = Integer.valueOf(req.getParameter("supprimer"));
			try {
				rows = saisondao.supprimerSaison(id);

				getServletContext().setAttribute("liste_rows", rows);

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		req.setAttribute("serie", liste);
		req.setAttribute("saison", liste_saison);
		getServletContext().getRequestDispatcher(VUE_FORMULAIRE1).forward(req, resp);

	}

	private List<Serie> fillSeries() {
		try {
			liste = seriedao.listerSerie();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return liste;
	}

}
