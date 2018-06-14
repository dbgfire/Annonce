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
 * Servlet implementation class subscribeServelt
 */
@WebServlet("/inscription")
public class subscribeServelt extends HttpServlet {
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
    public subscribeServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("email");
		String pwd1 = request.getParameter("passwd1");
		String name = request.getParameter("fname");
		
		Utilisateur utilisateur =new Utilisateur() ;
		utilisateur.setId(id);
		utilisateur.setPassword(pwd1);
		utilisateur.setNom(name);
		

		if(!id.isEmpty() || !pwd1.isEmpty()|| !utilisateurDao.check(utilisateur)){
			utilisateurDao.create(utilisateur);
			List<Annonce> all =annonceDao.allPublic(utilisateurDao.get(id));

			request.getSession().setAttribute(Constantes.PARAM_UTILISATEUR, utilisateurDao.get(id));
			
			request.getSession().setAttribute(Constantes.PARAM_ANNONCE_ALL, all);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
			
		} else {
			request.getRequestDispatcher("index.html").forward(request, response);

		}
	}

}
