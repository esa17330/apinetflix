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

import com.apiMynetflix.modele.Saison;

public class SaisonDao {

	Connection cnx = null;
	int control;
	PreparedStatement pprst = null;

	public void creer(Saison saison) throws DaoException {

		String request = "insert into saison (numero,resume,anneeDiffusion,idStatut) values (?,?,?,?)";
		try {

			cnx = MariaDbConnection.getCnx();

			try (PreparedStatement pprst = cnx.prepareStatement(request)) {

				pprst.setObject(1, saison.getNumero(), Types.INTEGER);
				pprst.setObject(2, saison.getResume(), Types.VARCHAR);
				pprst.setObject(3, saison.getAnneeDiffusion(), Types.NUMERIC);
				pprst.setObject(4, saison.getIdStatut(), Types.INTEGER);

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

	public List<Saison> listerSaison(int idserie) throws DaoException {

		ResultSet rs;
		List<Saison> listesaison = new ArrayList<>();
		String request = "select * from saison where idserie =" + idserie;

		try {
			cnx = MariaDbConnection.getCnx();

			try (PreparedStatement pprst = cnx.prepareStatement(request)) {
				// pprst.setInt(1, affectation_id);
				rs = pprst.executeQuery(request);
				while (rs.next()) {
					listesaison.add(new Saison(rs.getInt("id"), rs.getInt("numero"), rs.getString("resume"),
							rs.getInt("annee_diffusion"), rs.getInt("idstatut"), rs.getInt("idserie")));
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

		return listesaison;
	}

	public Saison getSaison(int id) throws DaoException {

		ResultSet rs;
		Saison saison = null;
		String request = "select * from saison where id=" + id;

		try {
			cnx = MariaDbConnection.getCnx();

			try (PreparedStatement pprst = cnx.prepareStatement(request)) {

				rs = pprst.executeQuery(request);
				while (rs.next()) {
					saison = new Saison(rs.getInt("numero"), rs.getString("resume"), rs.getInt("annee_diffusion"),
							rs.getInt("idstatut"), rs.getInt("idserie"));
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

		return saison;
	}

	public int getMaxNumero(int idserie) throws DaoException {

		ResultSet rs;
		int numero = 0;
		String request = "select max(numero) from saison where idserie=" + idserie;

		try {
			cnx = MariaDbConnection.getCnx();

			try (PreparedStatement pprst = cnx.prepareStatement(request)) {

				rs = pprst.executeQuery(request);
				while (rs.next()) {
					numero = rs.getInt("numero");
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

		return numero;
	}

	public int modifierSaison(Saison saison, int id) throws DaoException {
		int control = 0;
		String request = "update saison set numero= ?, resume= ?,annee_diffusion = ?," + "idstatut = ? where id = "
				+ id;

		try {

			cnx = MariaDbConnection.getCnx();
			cnx.setAutoCommit(false);
			try (PreparedStatement pprst = cnx.prepareStatement(request)) {

				pprst.setObject(1, saison.getNumero(), Types.INTEGER);
				pprst.setObject(2, saison.getResume(), Types.VARCHAR);
				pprst.setObject(3, saison.getAnneeDiffusion(), Types.INTEGER);
				pprst.setObject(4, saison.getIdStatut(), Types.INTEGER);

				control = pprst.executeUpdate();
				cnx.commit();
				pprst.close();
				cnx.close();

			} catch (DaoException e) {
				System.out.println(e.getMessage());
				if (cnx != null) {
					try {
						System.out.println("Transaction annulée");
						cnx.rollback();
					} catch (SQLException e2) {
						System.out.println(e2.getMessage());

					}
				}
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return control;
	}

	public Map<String, Integer> supprimerSaison(int id) throws SQLException {
		final String[] tables_episode = { "participer", "streamer", "soustitre", "audio", "trailer", };
		Map<String, Integer> updated_rows = new HashMap<>();
		int nb_table = 0;
		String request;
		String key = null;

		String request_episode = "delete from episode where episode.idsaison in (select id from saison where saison.id= "
				+ id + ")";

		String request_saison = "delete from saison where saison.id= " + id;

		try {
			// on supprime en 1 les tables avec la référence idepisode
			cnx = MariaDbConnection.getCnx();
			cnx.setAutoCommit(false);
			for (nb_table = 0; nb_table < tables_episode.length; nb_table++) {
				request = "delete from " + tables_episode[nb_table] + " where " + tables_episode[nb_table]
						+ ".idepisode in " + " (select episode.id from episode "
						+ " inner join saison on episode.idsaison=saison.id " + "where saison.id =" + id + ")";

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
