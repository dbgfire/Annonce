package test.dao;



import org.junit.Assert;
import org.junit.Test;

import fr.epsi.myEpsi.beans.Utilisateur;
import fr.epsi.myEpsi.dao.DAOConfigurationException;
import fr.epsi.myEpsi.dao.DAOFactory;
import fr.epsi.myEpsi.dao.IUserDao;

public class IUserDaoTest {
	DAOFactory daoFactory;
	@Test
	public void getUser() throws DAOConfigurationException {
		
		
		
		IUserDao utilisateurDao;
		daoFactory = DAOFactory.getInstance();
		utilisateurDao=daoFactory.getUtilisateurDao();	
		Utilisateur u= utilisateurDao.get("ADMIN");
	//	System.out.println(utilisateurDao.get("Alan32").getPassword()+" "+u.getPassword());
		Assert.assertEquals(u.getPassword(),utilisateurDao.get("ADMIN").getPassword());
	}
	
	
	@Test
	public void insertUser() throws DAOConfigurationException {
		
		
		Utilisateur u=new Utilisateur();
		u.setId("Alan322");
		u.setNom("Alan");
		u.setPassword("alanalan");
		u.setTelephone("0311268144");
		u.setAdministrateur(false);
		IUserDao utilisateurDao;
		daoFactory = DAOFactory.getInstance();
		utilisateurDao=daoFactory.getUtilisateurDao();	  
		Assert.assertEquals(true,utilisateurDao.create(u));
	}
	@Test
	public void deleteUser() throws DAOConfigurationException {
		
		IUserDao utilisateurDao;
		daoFactory = DAOFactory.getInstance();
		utilisateurDao=daoFactory.getUtilisateurDao();	
		System.out.println(utilisateurDao.get("Alan3").getNom());
		Utilisateur u= utilisateurDao.get("Alan3");
		/*Utilisateur u=new Utilisateur();
		u.setId("Alan3");
		u.setNom("Alan");
		u.setPassword("alanalan");
		u.setAdministrateur(false);*/
		System.out.println("La suppresion est "+utilisateurDao.delete(u));
		Assert.assertEquals(true,utilisateurDao.delete(u));
	}
	
	
	
	
}
