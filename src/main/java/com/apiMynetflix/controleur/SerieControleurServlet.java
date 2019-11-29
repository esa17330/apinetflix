package com.apiMynetflix.controleur;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apiMynetflix.modele.Pays;
import com.apiMynetflix.modele.Serie;
import com.apiMynetflix.modele.Statut;

@WebServlet("/ajoutSerie")
public class SerieControleurServlet extends HttpServlet {
	private static final String VUE_FORMULAIRE = "/WEB-INF/jsp/ajoutSerie.jsp";
	private static final String VUE_RECAP_SERIE = "WEB-INF/jsp/vueRecapSerie.jsp";
	SerieDao seriedao = new SerieDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {

			List<Statut> listest = seriedao.getListeStatut();
			req.setAttribute("liste", listest);
			List<Pays> listepays=seriedao.getListePays();
			req.setAttribute("listep", listepays);
			getServletContext().getRequestDispatcher(VUE_FORMULAIRE).forward(req, resp);

		} catch (SQLException e) {
			resp.sendError(500, e.getMessage());
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 try {
		int idstatut =0;
		String name=req.getParameter("ajouter");
		if(name.equals("ajouter")) { 
		
		String nom = req.getParameter("nom");
		String nomoriginal = req.getParameter("nomoriginal");
		String anneedeparution = req.getParameter("anneedeparution");
		String synopsis = req.getParameter("synopsis");
		String statut = req.getParameter("statut");
		//idstatut=seriedao.getIdStatut(statut);
		String pays = req.getParameter("pays");

		 Serie serie=new Serie(nom,nomoriginal,Integer.parseInt(anneedeparution),synopsis,Integer.parseInt(statut),Integer.parseInt(pays));
		 req.setAttribute("serie",serie);
		 seriedao.InsertSerie(serie);
		// RequestDispatcher rd =  getServletContext().getRequestDispatcher(VUE_RECAP_SERIE);
		// rd.forward(req, resp);
		// } catch (ErreursFormulaireException e) {
		// req.setAttribute("erreurs", e.getErreurs());
		// afficherCommande(req, resp);
		// }

	
	}
}catch (SQLException e) {
	System.out.println(e.getMessage());
}
	}
}
