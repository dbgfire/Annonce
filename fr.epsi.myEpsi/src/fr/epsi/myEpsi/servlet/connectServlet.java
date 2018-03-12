package fr.epsi.myEpsi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.myEpsi.Constantes;
import fr.epsi.myEpsi.beans.Utilisateur;

/**
 * Servlet implementation class ConnectServlet
 */
@WebServlet("/ConnectServlet")
public class connectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		if(id.isEmpty() || pwd.isEmpty()) {
			request.getRequestDispatcher("index.html").forward(request, response);
		} else {
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setId(id);
			request.getSession().setAttribute(Constantes.PARAM_UTILISATEUR, utilisateur);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}
	}
}
