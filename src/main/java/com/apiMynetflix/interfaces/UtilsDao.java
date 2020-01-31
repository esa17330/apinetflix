package com.apiMynetflix.interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.apiMynetflix.Dao.DaoException;
import com.apiMynetflix.Dao.MariaDbConnection;
import com.apiMynetflix.modele.Genre;
import com.apiMynetflix.modele.Pays;
import com.apiMynetflix.modele.Statut;

public interface UtilsDao {

	// cette méthode renvoie une liste de statut dépendant du type de l'affectation
	// 1=saison 2=episode 3=serie

	default List<Statut> getListeStatut(Integer affectation_id) throws DaoException {

		ResultSet rs;
		List<Statut> listestatut = new ArrayList<>();
		String request = "select * from statut inner join affectation on statut.idaffectation="
				+ "affectation.id where affectation.id= " + affectation_id;
		try {

			Connection cnx = MariaDbConnection.getCnx();

			try (PreparedStatement pprst = cnx.prepareStatement(request)) {
				// pprst.setInt(1, affectation_id);
				rs = pprst.executeQuery(request);
				while (rs.next()) {
					listestatut.add(new Statut(rs.getInt("id"), rs.getString("libelle"), rs.getInt("idaffectation")));
				}
				rs.close();
				pprst.close();
				cnx.close();

			} catch (DaoException e) {
				System.out.println(e.getMessage());

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return listestatut;
	}

	default List<Pays> getListePays() throws DaoException {

		ResultSet rs;
		List<Pays> listepays = new ArrayList<>();
		String request = "select * from pays";
		try {

			Connection cnx = MariaDbConnection.getCnx();

			try (PreparedStatement pprst = cnx.prepareStatement(request)) {

				rs = pprst.executeQuery(request);
				while (rs.next()) {
					listepays.add(new Pays(rs.getInt("id"), rs.getString("nom"), rs.getString("code")));

				}
				rs.close();
				pprst.close();
				cnx.close();

			} catch (DaoException e) {
				System.out.println(e.getMessage());

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return listepays;
	}

	default List<Genre> getListeGenre() throws DaoException {

		ResultSet rs;
		List<Genre> liste_genre = new ArrayList<>();
		String request = "select * from genre";
		try {
			Connection cnx = MariaDbConnection.getCnx();

			try (PreparedStatement pprst = cnx.prepareStatement(request)) {

				rs = pprst.executeQuery(request);
				while (rs.next()) {
					liste_genre.add(new Genre(rs.getInt("id"), rs.getString("libelle")));

				}
				rs.close();
				pprst.close();
				cnx.close();

			} catch (DaoException e) {
				System.out.println(e.getMessage());

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return liste_genre;
	}

	default List<Genre> getGenreSerie(int serieid) throws DaoException {

		ResultSet rs;
		List<Genre> genres = new ArrayList<>();
		final String request = "select genre.id,genre.libelle " + " from appartient inner join genre on "
				+ "idgenre = genre.id where idserie= " + serieid;
		try {
			Connection cnx = MariaDbConnection.getCnx();

			try (PreparedStatement pprst = cnx.prepareStatement(request)) {

				rs = pprst.executeQuery(request);
				while (rs.next()) {
					genres.add(new Genre(rs.getInt("id"), rs.getString("libelle")));

				}
				rs.close();
				pprst.close();
				cnx.close();

			} catch (DaoException e) {
				System.out.println(e.getMessage());

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return genres;
	}

}
