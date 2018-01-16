package fr.epsi.myEpsi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epsi.myEpsi.Constantes;
import fr.epsi.myEpsi.beans.Utilisateur;
import fr.epsi.myEpsi.listeners.StartupListener;

/**
 * Servlet implementation class connectServlet
 */
@WebServlet("/connectServlet")
public class connectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(connectServlet.class);
	private static final String PARAM_ID = "id";
	private static final String PARAM_PWD = "pass";  
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter(PARAM_ID);
		String pass=request.getParameter(PARAM_PWD);
		logger.info("name = "+ name+"\npass = "+ pass);
		if(!name.equals("") && !pass.equals("")){
			Utilisateur user=new Utilisateur();
			user.setId(name);
			request.getSession().setAttribute(Constantes.PARAM_UTILISATEUR, user);
			request.getRequestDispatcher("acceuil.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("login.html").forward(request, response);
		}
	}

}
