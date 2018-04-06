package fr.epsi.myEpsi.listeners;

import java.lang.management.ManagementFactory;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epsi.myEpsi.MBean.Premier;
import fr.epsi.myEpsi.dao.DAOConfigurationException;
import fr.epsi.myEpsi.dao.DAOFactory;



/**
 * Application Lifecycle Listener implementation class StartupListener
 *
 */
@WebListener
public class StartupListener implements ServletContextListener {

	private static final Logger logger = LogManager.getLogger(StartupListener.class);
	 Statement stmt = null;
     ResultSet result = null;
     private static final String ATT_DAO_FACTORY = "daofactory";
     private DAOFactory daoFactory;
     
    /**
     * Default constructor. 
     */
    public StartupListener() {
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event)  { 
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
    	logger.error("Démarrage de l'application");
        /* Récupération du ServletContext lors du chargement de l'application */
        ServletContext servletContext = event.getServletContext();
        /* Instanciation de notre DAOFactory */
        try {
			this.daoFactory = DAOFactory.getInstance();
		} catch (DAOConfigurationException e1) {
			e1.printStackTrace();
		}
        /* Enregistrement dans un attribut ayant pour portée toute l'application */
        servletContext.setAttribute( ATT_DAO_FACTORY, this.daoFactory );
    	/*try {
			Class.forName("org.hsqldb.jdbcDriver");
			Connection con = DriverManager.getConnection("	", "SA", "");
			 if (con!= null)
		            System.out.println("Connection created successfully");
			 stmt = con.createStatement();
	         result = stmt.executeQuery(
	            "SELECT * FROM ANNONCES");
	         
	         while(result.next()){
	            System.out.println(result.getInt("id")+result.getString("TITLE"));
	         }
			//con.close();
		} catch (ClassNotFoundException | SQLException e) {
			logger.error("Connexion impossible "+e.getMessage());
		}*/
    	
    	MBeanServer mbs =ManagementFactory.getPlatformMBeanServer();
    	ObjectName name = null;

    	try {
    	    name = new ObjectName("fr.epsi.jmx:type=PremierMBean");
    	    Premier mbean = new Premier();

    	    mbs.registerMBean(mbean, name);

    	} catch (MalformedObjectNameException e) {
    	    e.printStackTrace();
    	} catch (NullPointerException e) {
    	    e.printStackTrace();
    	} catch (InstanceAlreadyExistsException e) {
    	    e.printStackTrace();
    	} catch (MBeanRegistrationException e) {
    	    e.printStackTrace();
    	} catch (NotCompliantMBeanException e) {
    	    e.printStackTrace();
    	}

    	
    }
	
}
