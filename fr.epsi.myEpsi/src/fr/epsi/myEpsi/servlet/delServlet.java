package fr.epsi.myEpsi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.myEpsi.Constantes;
import fr.epsi.myEpsi.beans.Annonce;
import fr.epsi.myEpsi.beans.Utilisateur;
import fr.epsi.myEpsi.dao.DAOFactory;
import fr.epsi.myEpsi.dao.IAnnonceDao;
import fr.epsi.myEpsi.dao.IUserDao;

/**
 * Servlet implementation class delServlet
 */
@WebServlet("/update_annonce")
public class delServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserDao utilisateurDao;
	private IAnnonceDao annonceDao;
	public static final String CONF_DAO_FACTORY = "daofactory";
		
	public void init() throws ServletException {
	     /* Récupération d'une instance de notre DAO Utilisateur */
	        this.utilisateurDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUtilisateurDao();
	        this.annonceDao=( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getAnnonceDao();
	 }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    	String id = request.getParameter("id");
    	int i=Integer.parseInt(id);
    	Annonce a =annonceDao.get(i);
    	request.getSession().setAttribute(Constantes.PARAM_ANNONCE_UPDATE, a);
    	request.getRequestDispatcher("update.jsp").forward(request, response);
    }
     	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		
	}

}
