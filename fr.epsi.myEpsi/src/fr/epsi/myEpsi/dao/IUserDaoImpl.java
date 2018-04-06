package fr.epsi.myEpsi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import fr.epsi.myEpsi.beans.Utilisateur;
import fr.epsi.myEpsi.dao.DAOUtilitaire;

public class IUserDaoImpl implements IUserDao {
	 DAOFactory daoFactory;
	 private static final String SQL_INSERT = "INSERT INTO UTILISATEURS (ID,PASSWORD,ISADMINISTRATOR,NAME) VALUES (?, ?, ?, ?)";
	 private static final String SQL_SELECT_PAR_EMAIL = "SELECT * FROM UTILISATEURS WHERE id = ?";
	    /*
	     * Simple méthode utilitaire permettant de faire la correspondance (le
	     * mapping) entre une ligne issue de la table des utilisateurs (un
	     * ResultSet) et un bean Utilisateur.
	     */
	 private static Utilisateur map( ResultSet resultSet ) throws SQLException {
	        Utilisateur utilisateur = new Utilisateur();
	        utilisateur.setId( resultSet.getString( "ID" ) );
	        utilisateur.setNom( resultSet.getString( "NAME" ) );
	        utilisateur.setPassword( resultSet.getString( "PASSWORD" ) );
	        utilisateur.setAdministrateur(resultSet.getBoolean( "ISADMINISTRATOR" ) );
	        return utilisateur;
	}

	IUserDaoImpl( DAOFactory daoFactory ) {
		this.daoFactory = daoFactory;
	}

	@Override
	public boolean create(Utilisateur utilisateur) {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet valeursAutoGenerees = null;
	    int statut;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_INSERT, true, utilisateur.getId(), utilisateur.getPassword(),utilisateur.isAdministrateur(), utilisateur.getNom() );
	        statut = preparedStatement.executeUpdate();
	        /* Analyse du statut retourné par la requête d'insertion */
	        if ( statut == 0 ) {
	            throw new DAOException( "Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table." );
	        }
	        
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	    	DAOUtilitaire.fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
	    }
	    if(statut==0) 
	    	return false;
	    else 
	    	return true;
		
	}

	@Override
	public boolean delete(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Utilisateur get(String id) {
		  Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Utilisateur utilisateur = null;

		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_SELECT_PAR_EMAIL, false, id );
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		        if ( resultSet.next() ) {
		            utilisateur = map( resultSet );
		        }
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        DAOUtilitaire.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		    }
		return utilisateur;
	}

	

	@Override
	public boolean check(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return false;
	}

}
