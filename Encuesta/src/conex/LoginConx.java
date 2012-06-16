/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conex;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Ascalero
 */
public class LoginConx {
        ResultSetMetaData rsm= null;
        Conectador conexion =null;
	Statement st= null;
	ResultSet rs= null;
        final String S_N_A= "INSERT INTO areas (id_area,descr) VALUES";
    public LoginConx(){
    conexion= new Conectador();
                try{
			st = conexion.conx.createStatement();
			}catch(Exception e){
			System.out.println("fallo creacion de statment");
		};
    
    }
    
    public void NovoArea(ArrayList<String>uno){
		
		try{
	st.executeUpdate(S_N_A+"(NULL,'"+uno.get(0)+"');");
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
    ArrayList<Object> delta= new ArrayList<>();
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
    
    public int[][] rangos(int idEnc){
        int val[][]= null,alpha[]=null;
        ArrayList<int[]> delta= new ArrayList<>();
            try{
            rs = st.executeQuery ("SELECT q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12,q13,q14,q15,q16,q17,q18,q19 FROM valores WHERE\""+idEnc+"\"");
            rsm= rs.getMetaData();
            
            
            while(rs.next()){
                    alpha= new int[rsm.getColumnCount()];
                    for(int i=0;i<rsm.getColumnCount();i++){
                    alpha[i]=rs.getInt(i+1);
            
                    }
            
                    
                    delta.add(alpha);
            }
            
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