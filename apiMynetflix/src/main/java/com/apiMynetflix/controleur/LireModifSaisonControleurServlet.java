package com.apiMynetflix.controleur;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apiMynetflix.Dao.SaisonDao;
import com.apiMynetflix.Dao.SerieDao;
import com.apiMynetflix.modele.Saison;

@WebServlet("/LireModifSaison")
public class LireModifSaisonControleurServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	SaisonDao saisondao;
	Saison saison;
	SerieDao seriedao;
	int id = 0;
	private static final String VUE_FORMULAIRE = "/WEB-INF/jsp/patchSaison.jsp";
	private static final String CONTROLE_OK = "1 enregistrement SAISON mis à jour";
	private static final String CONTROLE_NOK = "Aucune mise à jour de SAISON n'a été effectuée !!!";

	public void init() throws ServletException {
		saisondao = new SaisonDao();
		saisondao = (SaisonDao) getServletContext().getAttribute("saisondao");
		seriedao = (SerieDao) getServletContext().getAttribute("seriedao");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idserie = 0;
		String titre_serie = null;
		if (req.getParameter("saison") != null)
			id = Integer.valueOf(req.getParameter("saison"));
		if (id > 0) {
			if (req.getParameter("idserie") != null)
				idserie = Integer.valueOf(req.getParameter("idserie"));
			try {
				titre_serie = seriedao.getNom(idserie);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

			saison = new Saison();
			saison = saisondao.getSaison(id);
			req.setAttribute("titre_serie", titre_serie);
			req.setAttribute("saison", saison);
			req.setAttribute("idstatut", saison.getIdStatut());

		}

		getServletContext().getRequestDispatcher(VUE_FORMULAIRE).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int control = 0;

		String numero = req.getParameter("numero");
		String resume = req.getParameter("resume");
		String anneedeparution = req.getParameter("anneedediffusion");
		String statut = req.getParameter("statut");

		Saison saison = new Saison(Integer.parseInt(numero), resume, Integer.parseInt(anneedeparution),
				Integer.parseInt(statut));
		req.setAttribute("saison", saison);

		control = saisondao.modifierSaison(saison, id);

		if (control == 0)
			req.setAttribute("control", CONTROLE_NOK);
		else
			req.setAttribute("control", CONTROLE_OK);
		getServletContext().getRequestDispatcher(VUE_FORMULAIRE).forward(req, resp);

	}

}
