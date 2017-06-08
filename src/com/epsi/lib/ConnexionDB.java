package com.epsi.lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnexionDB {
	
	public static Connection Con ;
	static Statement St ;
	
	

	public ConnexionDB(){
		
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/qrcode";
		String login="root";
		String pswd="";
		        
		try
		   {
		       	Class.forName(driver);
		       	System.out.println("Driver OK");
		   }
		catch(ClassNotFoundException E)
	    	{
				System.out.println("Problème au chargement du driver");
	    	}
		try
		    {
		        Con = DriverManager.getConnection(url, login, pswd );
		        System.out.println("Connexion établie");
		    }
		catch(SQLException E)
		    {
		        System.out.println("Problème de connexion");
		    }
				
	}
	

	
	
	

}
