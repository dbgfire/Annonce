package fr.epsi.myEpsi.dao;

import java.util.List;

import fr.epsi.myEpsi.beans.Annonce;
import fr.epsi.myEpsi.beans.Utilisateur;

public interface IAnnonceDao {

	boolean create(Annonce annonce);
	boolean update(Annonce annonce);
	boolean delete(int id);
	Annonce get(int id);
	List<Annonce> allPublic(Utilisateur utilisateur);
	List<Annonce> get(Utilisateur utilisateur);

}
