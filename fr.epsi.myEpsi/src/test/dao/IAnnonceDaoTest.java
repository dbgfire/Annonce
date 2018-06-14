package test.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.epsi.myEpsi.beans.Annonce;
import fr.epsi.myEpsi.beans.Utilisateur;
import fr.epsi.myEpsi.dao.DAOConfigurationException;
import fr.epsi.myEpsi.dao.DAOFactory;
import fr.epsi.myEpsi.dao.IAnnonceDao;
import fr.epsi.myEpsi.dao.IUserDao;


public class IAnnonceDaoTest {
	DAOFactory daoFactory;
	int i =4;
	@Test
	public void insertAnnonce() throws DAOConfigurationException {
		IAnnonceDao AnnonceDao;
		daoFactory = DAOFactory.getInstance();
		AnnonceDao=daoFactory.getAnnonceDao();	
		Annonce a=new Annonce();
		a.setId(i);
		i++;
		a.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris sollicitudin venenatis leo, ac ullamcorper quam tincidunt vel. Cras ac convallis.");
		a.setTitre("Lorem ipsum");
		a.setPrix((Double)25.0);
		
		Assert.assertEquals(true,AnnonceDao.create(a));
		
	}
	@Test
	public void getAnnonce() throws DAOConfigurationException {
		IAnnonceDao AnnonceDao;
		daoFactory = DAOFactory.getInstance();
		AnnonceDao=daoFactory.getAnnonceDao();	
		Annonce a=AnnonceDao.get(1);
		
		Assert.assertEquals(a.getDescription(),AnnonceDao.get(1).getDescription());
		
	}
	@Test
	public void updateAnnonce() throws DAOConfigurationException {
		IAnnonceDao AnnonceDao;
		daoFactory = DAOFactory.getInstance();
		AnnonceDao=daoFactory.getAnnonceDao();	
		Annonce a=new Annonce();
		a.setId(3);
		a.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris sollicitudin venenatis leo, ac ullamcorper quam tincidunt vel. Cras ac convallis.");
		a.setTitre("Super annonce");
		a.setPrix((Double)10.0);
		Assert.assertEquals(true,AnnonceDao.update(a));
		
	}
	@Test
	public void deleteAnnonce() throws DAOConfigurationException {
		IAnnonceDao AnnonceDao;
		daoFactory = DAOFactory.getInstance();
		AnnonceDao=daoFactory.getAnnonceDao();	
		Assert.assertEquals(true,AnnonceDao.delete(1));
		
	}
	
	@Test
	public void getListAnnonce() throws DAOConfigurationException {
		IAnnonceDao AnnonceDao;
		IUserDao utilisateurDao;
		
		daoFactory = DAOFactory.getInstance();
		
		AnnonceDao=daoFactory.getAnnonceDao();	
		utilisateurDao=daoFactory.getUtilisateurDao();	
		
		Utilisateur u= utilisateurDao.get("ADMIN");
		List<Annonce> a =AnnonceDao.get(u);
		for(int i=0;i<a.size();i++) {
			System.out.println(a.get(i).getTitre());
		}
		Assert.assertEquals(false,a.isEmpty());
		
	}
	@Test
	public void getListAllAnnonce() throws DAOConfigurationException {
		IAnnonceDao AnnonceDao;
		IUserDao utilisateurDao;
		daoFactory = DAOFactory.getInstance();
		AnnonceDao=daoFactory.getAnnonceDao();	
		utilisateurDao=daoFactory.getUtilisateurDao();	
		
		Utilisateur u= utilisateurDao.get("ADMIN");
		List<Annonce> a =AnnonceDao.allPublic(u);
		for(int i=0;i<a.size();i++) {
			System.out.println(a.get(i).getTitre());
		}
		Assert.assertEquals(false,a.isEmpty());
		
	}

}
