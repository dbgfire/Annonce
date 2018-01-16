package fr.epsi.myEpsi.MBean;

public class Premier implements PremierMBean {
	private int valeur=100;
	private static String nom ="PremierMBeam";

	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return this.nom;
	}

	@Override
	public int getValeur() {
		// TODO Auto-generated method stub
		return this.valeur;
	}

	@Override
	public void setValeur(int valeur) {
		this.valeur=valeur;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rafraichier() {
		// TODO Auto-generated method stub
		System.out.println("Rafraichir les donnees");
		
	}

}
