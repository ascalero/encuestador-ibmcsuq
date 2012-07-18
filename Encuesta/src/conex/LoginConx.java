/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conex;
import estructuras.Survey;
import java.io.ObjectInputStream;
import java.sql.*;

//import java.sql.ResultSet;
import java.util.ArrayList;
/**
 * 
 *
 * @author Ascalero
 */
public class LoginConx {
        ResultSetMetaData rsm= null;
        Conectador conexion =null;
	Statement st= null;
	ResultSet rs= null;
        final String S_N_P= "INSERT INTO survey (idsurvey,nombreSur,descripcion,idusuario,infosurvey) VALUES ";
    public LoginConx(){
    conexion= new Conectador();
                try{
			st = conexion.conx.createStatement();
			}catch(Exception e){
			System.out.println("fallo creacion de statment");
		};
    
    }
    
    public void NovoPro(String nP,String dP,String Usu){
		
		try{
                   String ax= S_N_P+"(NULL,'"+nP+"','"+dP+"','"+Usu+"',NULL);"; 
                    //System.out.println("" +ax);
                    st.executeUpdate(ax);
        			}catch(Exception e){
				e.printStackTrace();
			
		};
		
    }
    public void delProy(String nS){
        
                try{
                   String ax= "DELETE FROM survey WHERE idsurvey = "+getIdProy(nS)+";"; 
                    //System.out.println(""+ax);
                    
                    st.executeUpdate(ax);
        			}catch(Exception e){
				e.printStackTrace();
			
		};
    }
    public int getLogin(String u,String p){
        int val=0;
        try{
                        String query="SELECT iduser, pass FROM user WHERE idUser =\""+u+"\"";
			rs = st.executeQuery (query);
                        if(rs.next()){
                           if(rs.getString(2).equals(p)){
                            val=1;    
                            }else{
                            val=2;
                            }
                            
                            
                        }else{
                            val=3;
                        }
                        
                         }catch(Exception e){
				e.printStackTrace();
				
			};
    return val;
    }
    public Object[] getproy(String Id){
    ArrayList<Object> delta= new ArrayList<Object>();
        Object proyec[]=null;
            try{
            rs = st.executeQuery ("SELECT nombreSur FROM survey where idusuario=\""+Id+"\"");
            rsm= rs.getMetaData();
            
            while(rs.next()){
                    delta.add(rs.getString(1));
                    //System.out.println(rs.getString(1));
                    proyec= delta.toArray();
            }
            return proyec;
            }catch(Exception e){
                
            };
        return proyec;
    
    }
    
    public int getIdProy(String a){
        
        try{
            rs = st.executeQuery ("SELECT idsurvey FROM survey where nombreSur=\""+a+"\"");
            while(rs.next()){
                return rs.getInt(1);
            }
            }catch(Exception e){
            e.printStackTrace();    
            };
        return 0;
    }
    public Survey getBLOBProy(String a){
        int id =getIdProy(a);
        Survey info=null;
        try{
            rs = st.executeQuery ("SELECT infosurvey FROM survey where nombreSur=\""+a+"\" and idsurvey=\""+id+"\"");
            while(rs.next()){
                Blob blb= rs.getBlob(1);
                if (blb==null){return null;}
                ObjectInputStream dos= new ObjectInputStream(blb.getBinaryStream());
                info= (Survey)dos.readObject();
                return info;
            }
            }catch(Exception e){
            e.printStackTrace();    
            };
        return null;
    }
    
    public int[][] rangos(int idEnc,String Attrib){
        int val[][]= null,alpha[]=null;
        ArrayList<int[]> delta= new ArrayList<int[]>();
            try{
                String sta="SELECT q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12,q13,q14,q15,q16,q17,q18,q19 FROM valores WHERE Codigo=\""+idEnc+"\""+Attrib;
                //System.out.println(""+sta);
                rs = st.executeQuery (sta);
                
            rsm= rs.getMetaData();
            while(rs.next()){
                        alpha= new int[rsm.getColumnCount()];
                        for(int i=0;i<rsm.getColumnCount();i++){
                        alpha[i]=rs.getInt(i+1);
                }
                delta.add(alpha);
            }
            if (delta.isEmpty())return null;
            val= new int[delta.size()][];
            int x=0;
                for(int[] a:delta){
                val[x]=a;
                x++;
            }
            
            }catch(Exception e){
                e.printStackTrace();
            };
        return val;
    }
}