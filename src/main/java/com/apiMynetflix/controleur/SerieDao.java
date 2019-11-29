package com.apiMynetflix.controleur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.apiMynetflix.modele.Pays;
import com.apiMynetflix.modele.Serie;
import com.apiMynetflix.modele.Statut;

public class SerieDao {

	public List<Statut> getListeStatut() throws SQLException {
		ResultSet resultSet;
		List<Statut> listestatut=new ArrayList<>();
		String request = "select * from statut inner join affectation on statut.idaffectation="
				+ "affectation.id where affectation.id=3";
		try {

			Connection con= AccueilControleurServlet.getDataSource().getConnection();

			try (Statement st=con.createStatement())
			{
				resultSet = st.executeQuery(request);
				while (resultSet.next()) {
					listestatut.add(new Statut(resultSet.getInt("id"),resultSet.getNString("libelle"),
							resultSet.getInt("idaffectation")));
				}
				
				
			}catch (SQLException e) {
		System.out.println(e.getMessage());
	}

}catch (SQLException e) {
	System.out.println(e.getMessage());
	}
		return listestatut;
}

	public List<Pays> getListePays() throws SQLException {

		List<Pays> listepays=new ArrayList<>();
		String request = "select * from pays";
		ResultSet resultSet;

		
		try {

			Connection con= AccueilControleurServlet.getDataSource().getConnection();

			try (Statement st=con.createStatement())
			{
				resultSet = st.executeQuery(request);
				while (resultSet.next()) {
					listepays.add(new Pays(	resultSet.getInt("id"),resultSet.getString("nom"),
							resultSet.getString("code")));
				}
						
			}catch (SQLException e) {
		System.out.println(e.getMessage());
			
	}

}catch (SQLException e) {
	System.out.println(e.getMessage());
	}
		return listepays;
}
	
	/*
	 * public int getIdStatut(String libelle) throws SQLException { ResultSet
	 * resultSet; int id=0; String request =
	 * "select statut.id from statut inner join affectation on " +
	 * "statut.idaffectation=affectation.id where affectation.libelle='Série' and "
	 * +"statut.libelle="
	 * 
	 * 
	 * try {
	 * 
	 * Connection con= AccueilControleurServlet.getDataSource().getConnection();
	 * 
	 * try (Statement st=con.createStatement()) { resultSet =
	 * st.executeQuery(request); while(resultSet.next()) id=resultSet.getInt("id");
	 * 
	 * }catch (SQLException e) { System.out.println(e.getMessage());
	 * 
	 * }
	 * 
	 * }catch (SQLException e) { System.out.println(e.getMessage()); } return id;
	 * 
	 * }
	 * 
	 */	
public void InsertSerie(Serie serie) throws SQLException {
		
		
		String request = "insert into serie (nom,nomoriginal,anneeparution,synopsys,"
				+ "idstatut,idpaysorigine) values (?,?,?,?,?,?)";
		try {

			Connection con= AccueilControleurServlet.getDataSource().getConnection();
					
			
			try (PreparedStatement st=con.prepareStatement(request))
			{
				
				st.setObject(1, serie.getNom(),Types.VARCHAR);
				st.setObject(2, serie.getNomOriginal(),Types.VARCHAR);
				st.setObject(3, serie.getAnneeParution(),Types.NUMERIC);
				st.setObject(4, serie.getSynopsis(),Types.VARCHAR);
				st.setObject(5, serie.getidStatut(),Types.NUMERIC);
				st.setObject(6, serie.getIdPaysOrigine(),Types.NUMERIC);
				st.executeUpdate();
				
				
				}catch (SQLException e) {
		System.out.println(e.getMessage());
			
			}

		}catch (SQLException e) {
			System.out.println(e.getMessage());
	}
		
}
}
	
	
	
	
	