/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package encuesta;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Ascalero
 */
public class RespEnq implements Serializable {
    int [] seriepre;
    private ArrayList <Integer> resLikeIt= new ArrayList<Integer>();
    private ArrayList <String> sourceImaTrakin= new ArrayList<String>();    
    private ArrayList <Integer> xImaTra= new ArrayList<Integer>();
    private ArrayList <Integer> yImaTra= new ArrayList<Integer>();
    private ArrayList <String> resCommen= new ArrayList<String>();
    private ArrayList <Integer> selIMA= new ArrayList<Integer>();
    
    
    
    
    
    
    public RespEnq(int [] res) {
        seriepre=res;
    
    }
    
    
    public ArrayList <Integer> getRLI(){
        return resLikeIt;
    }
    
    public ArrayList <String> getSIT(){
        return sourceImaTrakin;
    }
    public ArrayList <Integer> getXIT(){
        return xImaTra;
    }
    
    public ArrayList <Integer> getYIT(){
        return yImaTra;
    }
    public ArrayList <String> getComA(){
        return resCommen;
    }
    public ArrayList <Integer> getselIma(){
        return selIMA;
    }
    
    public int getRLIVal(int index){
        return resLikeIt.get(index);
    }
    public String getSITVal(int index){
        return sourceImaTrakin.get(index);
    }
    public int getXITVal(int index){
        return xImaTra.get(index);
    }
    public int getYITVal(int index){
        return yImaTra.get(index);
    }
    public String getRCVAL(int index){
    return resCommen.get(index);
    }
    public int getSImaVAL(int index){
        return selIMA.get(index);
    }
    
    public void setSIT(String var,int x,int y){
     sourceImaTrakin.add(var);
     xImaTra.add(x);
     yImaTra.add(y);
     }
    public void setCom(String var){
     resCommen.add(var);    
     }
    public void setRLISI(int var,int type){
     
     switch(type){
         case 1:
             resLikeIt.add(var);
             break;
         case 2:
             selIMA.add(var);
             break;
         default:
             break;
     }
        
     }
     
    public void  setMine(){
        RespEnq temp =new RespEnq(seriepre);
        
    }
    
    
}
