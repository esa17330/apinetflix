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
import com.apiMynetflix.modele.Pays;
import com.apiMynetflix.modele.Serie;
import com.apiMynetflix.modele.Statut;

@WebServlet("/CreerSerie")
public class CreerSerieControleurServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VUE_FORMULAIRE = "/WEB-INF/jsp/FormCreerSerie.jsp";

	SerieDao seriedao = new SerieDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Statut> listest = new ArrayList<>();
		listest = seriedao.getListeStatut(3);
		req.setAttribute("liste", listest);
		List<Pays> listepays = new ArrayList<>();
		listepays = seriedao.getListePays();
		req.setAttribute("listep", listepays);
		getServletContext().getRequestDispatcher(VUE_FORMULAIRE).forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("ajouter");
		if (name.equals("ajouter")) {

			String nom = req.getParameter("nom");
			String nomoriginal = req.getParameter("nomoriginal");
			String anneedeparution = req.getParameter("anneedeparution");
			String synopsis = req.getParameter("synopsis");
			String statut = req.getParameter("statut");
			String pays = req.getParameter("pays");

			Serie serie = new Serie(nom, nomoriginal, Integer.parseInt(anneedeparution), synopsis,
					Integer.parseInt(statut), Integer.parseInt(pays));
			req.setAttribute("serie", serie);
			seriedao.creer(serie);
			// RequestDispatcher rd =
			// getServletContext().getRequestDispatcher(VUE_RECAP_SERIE);
			// rd.forward(req, resp);
			// } catch (ErreursFormulaireException e) {
			// req.setAttribute("erreurs", e.getErreurs());
			// afficherCommande(req, resp);
		}

	}
}
