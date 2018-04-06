package fr.epsi.myEpsi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.epsi.myEpsi.Constantes;
import fr.epsi.myEpsi.beans.Utilisateur;
import fr.epsi.myEpsi.dao.IUserDao;
import fr.epsi.myEpsi.dao.DAOFactory;

/**
 * Servlet implementation class ConnectServlet
 */
@WebServlet("/ConnectServlet")
public class connectServlet extends HttpServlet {	
	private static final long serialVersionUID = 1L;
    private IUserDao utilisateurDao;

    public static final String CONF_DAO_FACTORY = "daofactory";
	
    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.utilisateurDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUtilisateurDao();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public connectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("connexion.jsp").forward(request, response);
    }
     	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("email");
		String pwd = request.getParameter("motdepasse");

		
		Utilisateur utilisateur =new Utilisateur() ;
		utilisateur.setId(id);
		utilisateur.setPassword(pwd);
		 

		if(id.isEmpty() || pwd.isEmpty()/*|| !utilisateurDao.check(user)*/){

			request.getRequestDispatcher("connexion.jsp").forward(request, response);
		} else {
			
			request.getSession().setAttribute(Constantes.PARAM_UTILISATEUR, utilisateurDao.get(id));
			//request.getSession().setAttribute(Constantes.PARAM_ANNONCE, userAnnonce);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}
	}
}