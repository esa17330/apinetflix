package com.apiMynetflix.controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apiMynetflix.Dao.SerieDao;
import com.apiMynetflix.modele.Serie;

@WebServlet("/Serie")
public class SerieControleurServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String VUE_FORMULAIRE1 = "/WEB-INF/jsp/serie.jsp";
	SerieDao seriedao;
	List<Serie> liste;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int annee = 0;
		seriedao = (SerieDao) getServletContext().getAttribute("seriedao");

		// liste = new ArrayList<>();
		liste = seriedao.listerSerie();
		req.setAttribute("serie", liste);
		if (req.getParameter("serie") != null) {
			int id = Integer.valueOf(req.getParameter("serie"));
			if (id != 0) {
				int index = 0;
				for (Serie s : liste) {
					if (s.getId() == id) {
						annee = liste.get(index).getAnneeParution();
						req.setAttribute("annee", annee);
						break;
					} else {
						index++;
					}
				}

			}
		}
		getServletContext().getRequestDispatcher(VUE_FORMULAIRE1).forward(req, resp);
	}
}
