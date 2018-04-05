package fr.epsi.myEpsi.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
 * Servlet implementation class ConnectServlet
 */
@WebServlet("/ConnectServlet")
public class connectServlet extends HttpServlet {
	private static final Logger logger = LogManager.getLogger(connectServlet.class);
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
		String id = request.getParameter("email");
		String pwd = request.getParameter("motdepasse");
		 Utilisateur utilisateur = new Utilisateur();
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003", "SA", "");
			 if (con!= null)
		            System.out.println("Connection created successfully");
			 Statement stmt = con.createStatement();
	         ResultSet result = stmt.executeQuery(
	            "SELECT * FROM UTILISATEURS WHERE ID='"+id+"' AND PASSWORD='"+pwd+"';");
	         
	         while(result.next()){
	        	
	 			utilisateur.setId(result.getString("ID"));
	 			utilisateur.setPassword(result.getString("PASSWORD"));
	 			utilisateur.setAdministrateur(result.getBoolean("ISADMINISTRATOR"));
	 			utilisateur.setNom(result.getString("NAME"));
	            
	         }
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			logger.error("Connexion impossible "+e.getMessage());
		}
		if(id.isEmpty() || pwd.isEmpty()) {
			request.getRequestDispatcher("connexion.jsp").forward(request, response);
		} else {
			System.out.println("Connecter en tant que "+utilisateur.getId()+", vous etez "+utilisateur.getNom());
			request.getSession().setAttribute(Constantes.PARAM_UTILISATEUR, utilisateur);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}
	}
}
