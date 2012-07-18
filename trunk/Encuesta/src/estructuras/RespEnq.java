/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Ascalero
 */
public class RespEnq implements Serializable {
    int [] seriepre;
    private ArrayList <Integer> resLikeIt= new ArrayList<Integer>();
    private ArrayList<Point[]> puntos=new ArrayList<Point[]>();
    private ArrayList<Point> clicks=new ArrayList<Point>();
    private ArrayList <String> resCommen= new ArrayList<String>();
    private ArrayList <Integer> selIMA= new ArrayList<Integer>();
        
    public RespEnq(int [] res) {
        seriepre=res;
    }
    
    public ArrayList <Integer> getRLI(){
        return resLikeIt;
    }
    public ArrayList<Point[]> getPoints(){
        return puntos;
    }
    public ArrayList<Point> getClicks(){
        return clicks;
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
    public ArrayList<Point> getSITVal(int index){
        ArrayList<Point> tmp= new ArrayList<Point>();
        tmp.addAll(Arrays.asList(puntos.get(index)));
        return tmp;
    }
    public Point getClick(int index){
        return clicks.get(index);
    }
    public String getRCVAL(int index){
    return resCommen.get(index);
    }
    public int getSImaVAL(int index){
        return selIMA.get(index);
    }
    
    public void setSIT(ArrayList<Point> var,Point click){
        Point []tem=new Point[var.size()];
        int i=0;
        for(Point a:var){
            tem[i]=var.get(i);
            i++;
        }
        puntos.add(tem);
        
        clicks.add(click);
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
