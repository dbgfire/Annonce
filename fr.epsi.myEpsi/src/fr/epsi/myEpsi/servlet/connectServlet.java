package fr.epsi.myEpsi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epsi.myEpsi.Constantes;
import fr.epsi.myEpsi.beans.Annonce;
import fr.epsi.myEpsi.beans.Utilisateur;
import fr.epsi.myEpsi.dao.IUserDao;
import fr.epsi.myEpsi.listeners.StartupListener;
import fr.epsi.myEpsi.dao.DAOFactory;
import fr.epsi.myEpsi.dao.IAnnonceDao;

/**
 * Servlet implementation class ConnectServlet
 */
@WebServlet("/ConnectServlet")
public class connectServlet extends HttpServlet {	
	private static final long serialVersionUID = 1L;
    private IUserDao utilisateurDao;
    private IAnnonceDao annonceDao;
    public static final String CONF_DAO_FACTORY = "daofactory";
    private static final Logger logger = LogManager.getLogger(StartupListener.class);
    private static final Logger logger2 = LogManager.getLogger(StartupListener.class);
    private static final Logger logger3 = LogManager.getLogger(StartupListener.class);
    private static final Logger logger4 = LogManager.getLogger(StartupListener.class);
    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.utilisateurDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUtilisateurDao();
        this.annonceDao=( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getAnnonceDao();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public connectServlet() {
        super();
    	logger.info("connectServlet");
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("index.html").forward(request, response);
    }
     	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("email");
		String pwd = request.getParameter("passwd");

		
		Utilisateur utilisateur =new Utilisateur() ;
		utilisateur.setId(id);
		utilisateur.setPassword(pwd);
		System.out.println(utilisateur.getId()+" "+utilisateur.getPassword());
		logger2.debug("check user = "+utilisateurDao.check(utilisateur));

		if(id.isEmpty() || pwd.isEmpty()|| !utilisateurDao.check(utilisateur)){

			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			List<Annonce> a =annonceDao.get(utilisateurDao.get(id));
			logger3.debug("check user annonce = "+annonceDao.get(utilisateurDao.get(id)));
			List<Annonce> all =annonceDao.allPublic(utilisateurDao.get(id));
			logger4.debug("check all annonce = "+annonceDao.allPublic(utilisateurDao.get(id)));
			request.getSession().setAttribute(Constantes.PARAM_UTILISATEUR, utilisateurDao.get(id));
			request.getSession().setAttribute(Constantes.PARAM_ANNONCE, a);
			request.getSession().setAttribute(Constantes.PARAM_ANNONCE_ALL, all);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}
	}
}