package com.apiMynetflix.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.apiMynetflix.interfaces.UtilsDao;
import com.apiMynetflix.modele.Serie;

public class SerieDao implements UtilsDao {

	Connection cnx;

	public void creer(Serie serie) throws DaoException {

		String request = "insert into serie (nom,nomoriginal,anneeparution,synopsys,"
				+ "idstatut,idpaysorigine) values (?,?,?,?,?,?)";
		try {

			cnx = MariaDbConnection.getCnx();

			try (PreparedStatement pprst = cnx.prepareStatement(request)) {

				pprst.setObject(1, serie.getNom(), Types.VARCHAR);
				pprst.setObject(2, serie.getNomOriginal(), Types.VARCHAR);
				pprst.setObject(3, serie.getAnneeParution(), Types.NUMERIC);
				pprst.setObject(4, serie.getSynopsis(), Types.VARCHAR);
				pprst.setObject(5, serie.getidStatut(), Types.NUMERIC);
				pprst.setObject(6, serie.getIdPaysOrigine(), Types.NUMERIC);
				pprst.executeUpdate();

				pprst.close();
				cnx.close();

			} catch (DaoException e) {
				System.out.println(e.getMessage());

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public void modifier(Serie serie) throws DaoException {

		String request = "update serie set nom= ?, nomoriginal = ?,anneeparution = ?,synopsys = ?,"
				+ "idstatut = ?, idpaysorigine = ? where id = ?";
		try {

			cnx = MariaDbConnection.getCnx();

			try (PreparedStatement pprst = cnx.prepareStatement(request)) {

				pprst.setObject(1, serie.getNom(), Types.VARCHAR);
				pprst.setObject(2, serie.getNomOriginal(), Types.VARCHAR);
				pprst.setObject(3, serie.getAnneeParution(), Types.NUMERIC);
				pprst.setObject(4, serie.getSynopsis(), Types.VARCHAR);
				pprst.setObject(5, serie.getidStatut(), Types.NUMERIC);
				pprst.setObject(6, serie.getIdPaysOrigine(), Types.NUMERIC);
				pprst.setObject(7, serie.getId(), Types.NUMERIC);
				pprst.executeUpdate();

				pprst.close();
				cnx.close();

			} catch (DaoException e) {
				System.out.println(e.getMessage());

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public List<Serie> listerSerie() throws DaoException {

		ResultSet rs;
		List<Serie> listeserie = new ArrayList<>();
		String request = "select * from serie";

		try {
			cnx = MariaDbConnection.getCnx();

			try (PreparedStatement pprst = cnx.prepareStatement(request)) {
				// pprst.setInt(1, affectation_id);
				rs = pprst.executeQuery(request);
				while (rs.next()) {
					listeserie.add(new Serie(rs.getInt("id"), rs.getString("nom"), rs.getString("nomoriginal"),
							rs.getInt("anneeparution"), rs.getString("synopsys"), rs.getInt("idstatut"),
							rs.getInt("idpaysorigine")));
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

		return listeserie;
	}

	public Serie getSerie(int id) throws DaoException {

		ResultSet rs;
		Serie serie = null;
		String request = "select * from serie where id=" + id;

		try {
			cnx = MariaDbConnection.getCnx();

			try (PreparedStatement pprst = cnx.prepareStatement(request)) {

				rs = pprst.executeQuery(request);
				while (rs.next()) {
					serie = new Serie(rs.getInt("id"), rs.getString("nom"), rs.getString("nomoriginal"),
							rs.getInt("anneeparution"), rs.getString("synopsys"), rs.getInt("idstatut"),
							rs.getInt("idpaysorigine"));
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

		return serie;
	}

}
