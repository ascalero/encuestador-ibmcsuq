/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.FrameEncuestas;

import estructuras.*;

/**
 *
 * @author Shadow
 */
public class MainTest {
    public static void main(String args[]){
        Survey s=new Survey("tempo","ja");
        int[] x=new int[2];
        x[0]=1;
        x[1]=2;
        RespEnq re=new RespEnq(x);
        //FrameComent fc=new FrameComent(0,s,re);
        //FrameMT mt=new FrameMT(0,s,re);
        FrameImaQ imq=new FrameImaQ(0,s,re);
    }
}
