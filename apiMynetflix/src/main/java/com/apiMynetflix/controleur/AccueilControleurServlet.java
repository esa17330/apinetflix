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
import com.apiMynetflix.modele.Pays;
import com.apiMynetflix.modele.Statut;

@WebServlet(urlPatterns = "/accueil", loadOnStartup = 0)
public class AccueilControleurServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String VUE_ACCUEIL = "/WEB-INF/jsp/accueil.jsp";

	public void init() throws ServletException {

		SerieDao seriedao = new SerieDao();
		getServletContext().setAttribute("seriedao", seriedao);
		List<Statut> liste_statut = new ArrayList<>();
		List<Pays> liste_pays = new ArrayList<>();
		List<Genre> liste_genre = new ArrayList<>();

		liste_statut = seriedao.getListeStatut(3);
		liste_pays = seriedao.getListePays();
		liste_genre = seriedao.getListeGenre();

		getServletContext().setAttribute("liste_statut", liste_statut);
		getServletContext().setAttribute("liste_pays", liste_pays);
		getServletContext().setAttribute("liste_genre", liste_genre);

		// getServletContext().setAttribute("cocktailService", cocktailService);
		// on place la liste des cocktails en portée "application" pour que les vues
		// puissent y accéder.
		// getServletContext().setAttribute("listeCocktails",
		// cocktailService.getListeCocktails());
		// ListeCommande listecommande = new ListeCommande();
		// getServletContext().setAttribute("ListeCommande", listecommande);
		// getServletContext().setAttribute("listecommande",
		// listecommande.getListeCommande());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		getServletContext().getRequestDispatcher(VUE_ACCUEIL).forward(req, resp);
	}

}
