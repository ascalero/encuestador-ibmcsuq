/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conex;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shadow
 */
public class OpBasicas {
    ResultSetMetaData rsm= null;
    Conectador conexion =null;
    Statement st= null;
    ResultSet rs= null;
    
    public OpBasicas(){
        conexion= new Conectador();
        try{
            st = conexion.conx.createStatement();
        }catch(Exception e){
            System.out.println("fallo creacion de statment");
	};
    }
    
    public void Insertar(ArrayList<String>datos){
        try {
            String query="INSERT INTO ibmcsuq.user (idUser,nombre,apeP,apeM,pass) VALUES (";
            for(int i=0;i<datos.size();i++){
                query+="'"+datos.get(i)+"'";
                if(i<datos.size()-1){query+=",";}
            }query+=");";
            System.out.println(query);
            st.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(OpBasicas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
