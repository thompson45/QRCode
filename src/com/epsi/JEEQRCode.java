package com.epsi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.epsi.lib.Authentification;
//import com.epsi.lib.ConnexionDB;

//@WebServlet("/QRCode")
public class JEEQRCode extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	static Connection Con ;
	static Statement St ;
	
	public String user = "";
	public String pass = "";
	
	public HttpSession session;
	public Integer idUser;
	
	@PersistenceContext(unitName="qrcodePU")
	protected EntityManagerFactory 	emf;
	protected EntityManager 		em;
	
  
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		//ConnexionDB conn = new ConnexionDB();
		//try{
		System.out.println("Initialisation Hibernate");
		emf = Persistence.createEntityManagerFactory("qrcodePU");
		em = emf.createEntityManager();
		System.out.println("Initialisation réussie");
		/*}
		catch(Exception E)
		{
			System.out.println("Message : "+E.getMessage());
			System.out.println("Message : "+E.getLocalizedMessage());
			System.out.println("Message : "+E.getCause());
			System.out.println("Message : "+E.getClass());
		}*/
	}
	
	private String gestionAction(HttpServletRequest request)
	{
		String action = null;
		
		// Connexion
		String conn	= request.getParameter("conn");
		
		if(conn != null && conn != "")
		{
			action = "Connexion";
		}
		
		
		if(action == null || action == "")
		{
			action = "";
			session.setAttribute("message", "");
		}

		session.setAttribute("action", action);
		System.out.println("[Action : '"+action+"']");
		return action;
	}
	
	private void call(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		this.getServletContext().getRequestDispatcher( "/QRCode"+page ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession(true);
		user = (String) session.getAttribute("user");
		idUser = (Integer) session.getAttribute("idUser");
		
		if(idUser == null || idUser == -1){user = "";idUser = -1;session.setAttribute("user",user);session.setAttribute("idUser",idUser);}
		
		String action = gestionAction(request);
		
		if (action != null && action != "")
		{
			if (action.equalsIgnoreCase("Connexion")){
				try
				{
					doAuthentification(request, response);
				}
				catch (Exception e)
				{
					System.out.println("Erreur au niveau de l'action "+action);
				}			
			}
			else
			{
				if(idUser != null && idUser != -1)
				{
					/*if (action.equalsIgnoreCase("AjouteUser")){
						try {
							doInscription(request, response);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							System.out.println("erreur d'action ajouter user");
						}
					}*/
				}
				else
				{
					call("",request,response);
				}
			}
		}
		else
		{
			call("",request,response);
		}
		
		
	}

	public void doAuthentification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try
		{
			String user	= request.getParameter("user");
			String pass = request.getParameter("pass");
			String UserN = "";
			String PassW = "";
			if(user!="" && pass!="" && user!=null && pass!=null)
			{
				//Authentification id = new Authentification(user, pass);
				/*while(id.rs.next()){
					UserN = id.rs.getString(1);
					PassW = id.rs.getString(2);
				}
				*/
				if(user.equalsIgnoreCase(UserN) && pass.equalsIgnoreCase(PassW))
				{
					session.setAttribute("user", UserN);
					session.setAttribute("message", "Vous êtes connecté en tant que "+user);
				}
				else
				{
					session.setAttribute("user", "");
					session.setAttribute("pass", "");
					session.setAttribute("idUser", -1);
					session.setAttribute("message", "Combinaison login/mdp incorrect");
				}
			}
			else
			{
				session.setAttribute("message", "Veuillez renseigner les champs de connexion");
			}
		}
		catch (Exception E)
		{
			System.out.println("Problème au niveau de la requête d'authentification");
			session.setAttribute("message", "Erreur à la connexion à la base de données");
		}
		call("",request,response);
	}	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}