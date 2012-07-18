package interfaz.FrameEncuestas;


import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shadow
 */
public class PaintWork {
    
    Color c[];
    
    public PaintWork(){
        c=new Color[11];
        //c[0]=new Color(3,4,5);
        c[0]=Color.GRAY;
        c[1]=Color.BLUE;
        c[2]=Color.GREEN;
        c[3]=Color.DARK_GRAY;
        c[4]=Color.ORANGE;
        c[5]=Color.PINK;
        c[6]=Color.CYAN;
        c[7]=Color.RED;
        c[8]=Color.YELLOW;
        c[9]=Color.MAGENTA;
    }
    
    public Color getColor(int max,int dato){
        //regresa un color deacuerdo al porcetaje
        int op=dato*10/max;
        return c[op-1];
    }
}
