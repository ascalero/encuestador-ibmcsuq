/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conex;
import java.sql.*;



/**
 *
 * 
 */
public class Conectador {
	Connection conx; 
        /**
         * Crea La Conexion con la base de datos en caliente
         */
        public Conectador() {
    	
    	try{
    	Class.forName("com.mysql.jdbc.Driver").newInstance();
    	//DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
    	     	}catch(Exception e){
    System.out.println("no conecto1");
    e.printStackTrace();
    
    	};
    
    try{
    	//conx = DriverManager.getConnection("jdbc:mysql://localhost/ibmcsuq","root","");
        conx = DriverManager.getConnection("jdbc:mysql://localhost/ibmcsuq","root","(@ImaginE@)");
    	//conx = DriverManager.getConnection("jdbc:mysql://localhost/ibmcsuq","root","310304");
    	//conx = DriverManager.getConnection("jdbc:mysql://169.254.217.19/CYCLE","CCIAA","alpha1");
    	}catch(Exception e){
            System.out.println("no conecto ");
            e.printStackTrace();
            System.exit(1);
        };
    }
}