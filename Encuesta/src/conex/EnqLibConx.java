/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conex;






import estructuras.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ascalero
 */
public class EnqLibConx extends LoginConx {
        ResultSetMetaData rsm= null;
        Conectador conexion =null;
	Statement st= null;
	ResultSet rs= null;
        PreparedStatement ps=null;

    public EnqLibConx() {
        super();
        conexion= new Conectador();
                try{
			st = conexion.conx.createStatement();
			}catch(Exception e){
			System.out.println("fallo creacion de statment");
		
                }
    }
        
    public void newProy(Survey alpha,String Desc,String User){
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        ObjectOutputStream oos;
        try{
        oos = new ObjectOutputStream(byteArray);
        oos.writeObject(alpha);
        }catch(IOException a){
        a.printStackTrace();
        }catch(Exception e){
        e.printStackTrace();
        }
        try {
            ps=conexion.conx.prepareStatement("insert into survey values(null,?,?,?,?)");
            //ps.setInt(1,(int)(Math.random()*1000)%100);
            ps.setString(1, alpha.getName());
            ps.setString(2, Desc);
            ps.setBytes(3,byteArray.toByteArray());
            ps.setString(4, User);
            System.out.println("values"+ps);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
    
    public void setRes(RespEnq alpha,ArrayList <String> datos,String nomEnc){
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        ObjectOutputStream oos;
        try{
            oos = new ObjectOutputStream(byteArray);
            oos.writeObject(alpha);
        }catch(IOException a){
            a.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            /*String query="INSERT INTO valores (idvals, nombre, edad, sexo, Escolaridad, experiencia, datosblob, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, Codigo) VALUES (NULL, '";
            query+=datos.get(0)+"','"+datos.get(1)+"','"+datos.get(2)+"','"+datos.get(3)+"','"+datos.get(4) +"','"+byteArray.toByteArray().toString()+"',";
            query+="NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '"+this.getIdProy(nomEnc) +"')";            
            st.execute(query);*/
            ps=conexion.conx.prepareStatement("INSERT INTO valores(idvals, nombre, edad, sexo, Escolaridad, experiencia,datosblob,Codigo) values(null,?,?,?,?,?,?,?)");
            System.out.println("calquery"+ps.toString());
            ps.setString(1, datos.get(0));
            int xy=Integer.parseInt(datos.get(1));
            ps.setInt(2, xy);
           // ps.setString(2, datos.get(1));
            ps.setString(3, datos.get(2));
            ps.setString(4, datos.get(3));
            ps.setString(5, datos.get(4));
            ps.setBytes(6, byteArray.toByteArray());
            ps.setInt(7, getIdProy(nomEnc));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OpBasicas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Survey getInfoProy(String Id){
        Survey alpha=null; 
        try{
            rs = st.executeQuery ("SELECT infoSurvey FROM survey where idSurvey=\""+getIdProy(Id) +"\"");
            while(rs.next()){
                Blob blb= rs.getBlob(1);
                ObjectInputStream dos= new ObjectInputStream(blb.getBinaryStream());
                alpha= (Survey)dos.readObject();
            }
            return alpha;
            }catch(Exception e){
                e.printStackTrace();
            };
            return alpha;
    }
    
    public Respuestas getRespuestas(int idEnc,String Attrib){
        Respuestas valores= new Respuestas();
         try{
                String sta="SELECT nombre,datosblob FROM valores WHERE Codigo=\""+idEnc+"\""+Attrib;
                rs = st.executeQuery (sta);
                while(rs.next()){
                    valores.addUser(rs.getString(1));
                    Blob blb= rs.getBlob(2);
                    if (blb==null)return null;
                    ObjectInputStream dos= new ObjectInputStream(blb.getBinaryStream());
                    RespEnq beta=(RespEnq)dos.readObject();
                    valores.addRespEnq(beta);
                }
                
            }catch(Exception e){
                e.printStackTrace();
            };
        return valores;
    }


    @Override
    public Object[] getproy(String Id) {
        return super.getproy(Id);
    }

    @Override
    public int getIdProy(String a) {
        return super.getIdProy(a);
    }
    
    
    
        
}
