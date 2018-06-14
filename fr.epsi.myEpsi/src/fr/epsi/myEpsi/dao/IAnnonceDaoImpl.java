package fr.epsi.myEpsi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epsi.myEpsi.beans.Annonce;
import fr.epsi.myEpsi.beans.Utilisateur;

public class IAnnonceDaoImpl implements IAnnonceDao {

	 DAOFactory daoFactory;
		private static final String SQL_INSERT = "INSERT INTO ANNONCES (ID,CONTENT,PRIX) VALUES (?, ?,?)";
		 private static final String SQL_SELECT_PAR_ID = "SELECT * FROM ANNONCES WHERE id = ?";
		 private static final String SQL_UPDATE="UPDATE ANNONCES SET ID=? CONTENT=? PRIX=? WHERE ID= ? ";
		 private static final String SQL_DELETE_ANNONCE="DELETE FROM ANNONCES WHERE id=? ";
		 private static final String SQL_SELECT_LIST_ANNONCE = "SELECT * FROM ANNONCES WHERE USER_ID = ?";
		 private static final String SQL_SELECT_LIST_ANNONCE_ALL = "SELECT * FROM ANNONCES WHERE STATUS = ? AND USER_ID != ?";
		 /*
		     * Simple méthode utilitaire permettant de faire la correspondance (le
		     * mapping) entre une ligne issue de la table des Annonce (un
		     * ResultSet) et un bean Annonce.
		     */
		 private static Annonce map( ResultSet resultSet ) throws SQLException {
			 Annonce annonce = new Annonce();
			 annonce.setId( resultSet.getInt( "ID" ) );
			 annonce.setTitre(resultSet.getString("TITLE"));
			 annonce.setDescription(resultSet.getString("CONTENT"));
			 annonce.setPrix(resultSet.getDouble("PRIX"));
		     return annonce;
		}

	IAnnonceDaoImpl( DAOFactory daoFactory ) {
			this.daoFactory = daoFactory;
	}
	
	@Override
	public boolean create(Annonce annonce) {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet valeursAutoGenerees = null;
	    int statut;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_INSERT, true, annonce.getId(), annonce.getDescription(),annonce.getPrix() );
	        statut = preparedStatement.executeUpdate();
	        /* Analyse du statut retourné par la requête d'insertion */
	        if ( statut == 0 ) {
	            throw new DAOException( "�chec de la cr�ation d'une annonce, aucune ligne ajout�e dans la table." );
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
	public boolean update(Annonce annonce) {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet valeursAutoGenerees = null;
	    int statut;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_UPDATE, true, annonce.getId(), annonce.getDescription(),annonce.getPrix(), annonce.getId() );
	        statut = preparedStatement.executeUpdate();
	        /* Analyse du statut retourné par la requête d'insertion */
	        if ( statut == 0 ) {
	            throw new DAOException( "�chec de la mise � jour d'une annonce, aucune ligne modifi� dans la table." );
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
	public Annonce get(int id) {
		 	Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    Annonce annonce = null;

		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_SELECT_PAR_ID, false, id );
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		        if ( resultSet.next() ) {
		        	annonce = map( resultSet );
		        }
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        DAOUtilitaire.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		    }
		    return annonce;
	}

	@Override
	public List<Annonce> get(Utilisateur utilisateur) {
			Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    List<Annonce> a = new ArrayList<Annonce>();
		    Annonce annonce = null;
		    
		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_SELECT_LIST_ANNONCE, false, utilisateur.getId() );
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		   

		       
		        while( resultSet.next() ) {
		        	annonce = map( resultSet );
		        	a.add(annonce);
		        }
		        
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        DAOUtilitaire.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		    }
		return a;
	}

	@Override
	public boolean delete(int id) {
		
			Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet valeursAutoGenerees = null;
		    int statut;
		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_DELETE_ANNONCE, true, id );
		        statut = preparedStatement.executeUpdate();
		        /* Analyse du statut retourné par la requête d'insertion */
		        if ( statut == 0 ) {
		            throw new DAOException( "�chec de la suppression de l'annonce, aucune ligne supprimée dans la table." );
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
	public List<Annonce> allPublic(Utilisateur utilisateur) {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    List<Annonce> a = new ArrayList<Annonce>();
	    Annonce annonce = null;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_SELECT_LIST_ANNONCE_ALL, false,1,utilisateur.getId() );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	   

	       
	        while( resultSet.next() ) {
	        	annonce = map( resultSet );
	        	a.add(annonce);
	        }
	        
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        DAOUtilitaire.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
	return a;
	}

}
