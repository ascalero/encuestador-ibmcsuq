/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conex;






import estructuras.Survey;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;

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

    @Override
    public Object[] getproy(String Id) {
        return super.getproy(Id);
    }

    @Override
    public int getIdProy(String a) {
        return super.getIdProy(a);
    }
    
    
    
        
}
