/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Ascalero
 */
public class Respuestas {

    private ArrayList<RespEnq> resp= new ArrayList<RespEnq>();
    private ArrayList<String> idNickName= new ArrayList<String>();
    public Respuestas() {
        
    }
    
    
    public void  addRespEnq(RespEnq tmp){
        resp.add(tmp);
    }

    public void  addUser(String tmp){
        idNickName.add(tmp);
    }
    
    public ArrayList<String> getIdnick(){
        return idNickName;
    }
   
    public ArrayList<Integer> getSelIma(int index){
         ArrayList<Integer> tmpresp= new ArrayList<Integer>();
        for(RespEnq val:resp){
            tmpresp.add(val.getselIma().get(index));
        }
    return tmpresp;
    
    }
    
    public int[] getAnsLI(int index){
        int [] answer= new int[resp.size()];
        int i=0;
        for(RespEnq val:resp){
            answer[i]=val.getSImaVAL(index);
            i++;
        }
        return answer;
    }
    
    public ArrayList<String> getResPL(int index){
        ArrayList<String> tmpresp= new ArrayList<String>();
        for(RespEnq val:resp){
            tmpresp.add(val.getComA().get(index));
        }
    return tmpresp;
    }
    
    public ArrayList<Point> getResClicks(int index){
        ArrayList<Point> tmpresp= new ArrayList<Point>();
        for(RespEnq val:resp){
            tmpresp.add(val.getClick(index));
        }
    return tmpresp;
    }
    
    public ArrayList<Point> getTrace(int index){
        ArrayList<Point> tmpresp= new ArrayList<Point>();
        for(RespEnq val:resp){
            ArrayList<Point[]>  tmp2 = val.getPoints();
                Point[] alpha=tmp2.get(index);
            tmpresp.addAll(Arrays.asList(alpha));
            
        }
        return tmpresp;
    }
    
    
    
    
}
