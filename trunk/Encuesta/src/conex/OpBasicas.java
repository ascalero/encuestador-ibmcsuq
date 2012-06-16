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
            String query="INSERT INTO ibmcsuq.valores (idvals ,nombre ,edad ,sexo ,Escolaridad ,experiencia,q1 ,q2 ,q3 ,q4 ,q5 ,q6 ,q7 ,q8 ,q9 ,q10 ,q11 ,q12 ,q13 ,q14 ,q15 ,q16,q17,q18,q19,Codigo) VALUES (";
            for(int i=0;i<datos.size();i++){
                query+="'"+datos.get(i)+"'";
                if(i<datos.size()-1){query+=",";}
            }query+=");";
            st.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(OpBasicas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void Insertar2(ArrayList<String>datos){
        try {
            String query="INSERT INTO ibmcsuq.valores (idvals ,nombre ,edad ,sexo ,Escolaridad ,experiencia,q1 ,q2 ,q3 ,q4 ,q5 ,q6 ,q7 ,q8 ,q9 ,q10 ,q11 ,q12 ,q13 ,q14 ,q15 ,q16,q17,q18,q19,Codigo) VALUES (NULL ,";
            for(int i=0;i<datos.size();i++){
                query+="'"+datos.get(i)+"'";
                if(i<datos.size()-1){query+=",";}
            }query+=");";
            st.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(OpBasicas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public Object[] getproy(){
        ArrayList<Object> delta= new ArrayList<>();
        Object proyec[]=null;
        try{
            rs = st.executeQuery ("SELECT nombreSur FROM survey");
            rsm= rs.getMetaData();
            
            while(rs.next()){
                    delta.add(rs.getString(1));
                    //System.out.println(rs.getString(1));
                    proyec= delta.toArray();
            }
            return proyec;
        }catch(Exception e){};
        return proyec;
    
    }
}
