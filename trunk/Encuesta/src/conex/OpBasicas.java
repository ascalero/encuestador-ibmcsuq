/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conex;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

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
    
    public void Consultar(){
        
    }
}
