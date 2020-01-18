package com.apiMynetflix.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apiMynetflix.interfaces.UtilsDao;
import com.apiMynetflix.modele.Serie;

public class SerieDao implements UtilsDao {

	Connection cnx = null;
	int control;
	PreparedStatement pprst = null;

	public int creer(Serie serie) throws SQLException {

		String request = "insert into serie (nom,nomoriginal,anneeparution,synopsys,"
				+ "idstatut,idpaysorigine) values (?,?,?,?,?,?)";
		try {
			cnx = MariaDbConnection.getCnx();
			cnx.setAutoCommit(false);
			PreparedStatement pprst = cnx.prepareStatement(request);
			pprst.setObject(1, serie.getNom(), Types.VARCHAR);
			pprst.setObject(2, serie.getNomOriginal(), Types.VARCHAR);
			pprst.setObject(3, serie.getAnneeParution(), Types.NUMERIC);
			pprst.setObject(4, serie.getSynopsis(), Types.VARCHAR);
			pprst.setObject(5, serie.getidStatut(), Types.NUMERIC);
			pprst.setObject(6, serie.getIdPaysOrigine(), Types.NUMERIC);
			control = pprst.executeUpdate();
			cnx.commit();
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
			if (cnx != null) {
				try {
					System.out.println("Transaction annulée");
					cnx.rollback();
				} catch (SQLException e2) {
					System.out.println(e2.getMessage());

				}
			}
		}

		finally {
			if (pprst != null)
				pprst.close();
			if (cnx != null) {
				cnx.setAutoCommit(true);
				cnx.close();
			}

		}
		return control;
	}

	public int modifier(Serie serie) throws SQLException {

		String request = "update serie set nom= ?, nomoriginal = ?,anneeparution = ?,synopsys = ?,"
				+ "idstatut = ?, idpaysorigine = ? where id = ?";
		try {

			cnx = MariaDbConnection.getCnx();
			cnx.setAutoCommit(false);
			PreparedStatement pprst = cnx.prepareStatement(request);
			pprst.setObject(1, serie.getNom(), Types.VARCHAR);
			pprst.setObject(2, serie.getNomOriginal(), Types.VARCHAR);
			pprst.setObject(3, serie.getAnneeParution(), Types.NUMERIC);
			pprst.setObject(4, serie.getSynopsis(), Types.VARCHAR);
			pprst.setObject(5, serie.getidStatut(), Types.NUMERIC);
			pprst.setObject(6, serie.getIdPaysOrigine(), Types.NUMERIC);
			pprst.setObject(7, serie.getId(), Types.NUMERIC);
			control = pprst.executeUpdate();
			cnx.commit();
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
			if (cnx != null) {
				try {
					System.out.println("Transaction annulée");
					cnx.rollback();
				} catch (SQLException e2) {
					System.out.println(e2.getMessage());

				}
			}
		}

		finally {
			if (pprst != null)
				pprst.close();
			if (cnx != null) {
				cnx.setAutoCommit(true);
				cnx.close();
			}

		}
		return control;
	}

	public List<Serie> listerSerie() throws SQLException {

		ResultSet rs = null;
		List<Serie> listeserie = new ArrayList<>();
		String request = "select * from serie";

		try {
			cnx = MariaDbConnection.getCnx();
			PreparedStatement pprst = cnx.prepareStatement(request);

			rs = pprst.executeQuery(request);
			while (rs.next()) {
				listeserie.add(new Serie(rs.getInt("id"), rs.getString("nom"), rs.getString("nomoriginal"),
						rs.getInt("anneeparution"), rs.getString("synopsys"), rs.getInt("idstatut"),
						rs.getInt("idpaysorigine")));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (pprst != null)
				pprst.close();
			if (cnx != null)
				cnx.close();
		}

		return listeserie;
	}

	public Serie getSerie(int id) throws SQLException {

		ResultSet rs = null;
		Serie serie = null;
		String request = "select * from serie where id=" + id;

		try {
			cnx = MariaDbConnection.getCnx();
			PreparedStatement pprst = cnx.prepareStatement(request);
			rs = pprst.executeQuery(request);
			while (rs.next()) {
				serie = new Serie(rs.getInt("id"), rs.getString("nom"), rs.getString("nomoriginal"),
						rs.getInt("anneeparution"), rs.getString("synopsys"), rs.getInt("idstatut"),
						rs.getInt("idpaysorigine"));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (pprst != null)
				pprst.close();
			if (cnx != null)
				cnx.close();
		}

		return serie;
	}

	public Map<String, Integer> supprimerSerie(int id) throws SQLException {
		final String[] tables_episode = { "participer", "streamer", "soustitre", "audio", "trailer", };
		Map<String, Integer> updated_rows = new HashMap<>();
		int nb_table = 0;
		String request;
		String key = null;

		// on supprime en 1 les tables avec la référence idepisode

		String request_episode = "delete from episode where episode.idsaison in "
				+ "(select saison.id from saison inner join serie on saison.idserie=serie.id " + " where serie.id= "
				+ id + ")";

		String request_saison = "delete from saison where saison.idserie in (select id from serie where serie.id= " + id
				+ ")";

		String request_serie = "delete from serie where serie.id= " + id;

		try {
			cnx = MariaDbConnection.getCnx();
			cnx.setAutoCommit(false);
			for (nb_table = 0; nb_table < tables_episode.length; nb_table++) {
				request = "delete from " + tables_episode[nb_table] + " where " + tables_episode[nb_table]
						+ ".idepisode in " + " (select episode.id from episode "
						+ " inner join saison on episode.idsaison=saison.id "
						+ " inner join serie on saison.idserie=serie.id " + " where serie.id =" + id + ")";

				PreparedStatement pprst = cnx.prepareStatement(request);
				key = parse_request(request);
				control = pprst.executeUpdate();
				cnx.commit();
				updated_rows.put(key, control);

			}

			control = executeQuery(cnx, request_episode);
			key = parse_request(request_episode);
			updated_rows.put(key, control);
			control = executeQuery(cnx, request_saison);
			key = parse_request(request_saison);
			updated_rows.put(key, control);
			control = executeQuery(cnx, request_serie);
			key = parse_request(request_serie);
			updated_rows.put(key, control);

		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
			if (cnx != null) {
				try {
					System.out.println("Transaction annulée");
					cnx.rollback();
				} catch (SQLException e2) {
					System.out.println(e2.getMessage());

				}
			}
		}

		finally {
			if (pprst != null)
				pprst.close();
			if (cnx != null) {
				cnx.setAutoCommit(true);
				cnx.close();
			}

		}
		return updated_rows;
	}

	private int executeQuery(Connection cnx, String req) throws SQLException {
		int control;
		PreparedStatement pprst = cnx.prepareStatement(req);

		control = pprst.executeUpdate();
		cnx.commit();
		return control;

	}

	private String parse_request(String req) {
		String[] elem_req = req.split(" ");
		String commande = elem_req[0].strip();
		String key;
		switch (commande) {
		case "delete":
			key = elem_req[2].strip();
			break;
		case "update":
			key = elem_req[1].strip();
			break;
		default:
			key = "table inconnue ????";
			break;

		}
		return key;

	}

}
