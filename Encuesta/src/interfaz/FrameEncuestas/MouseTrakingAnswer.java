package interfaz.FrameEncuestas;


import interfaz.JPanelConFondo;
import java.awt.*;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shadow
 */
public class MouseTrakingAnswer extends JPanelConFondo{
    
    private String imgAsk;
    //las veces que paso el mause en un punto seran guardados en la matriz
    private int[][] matriz;
    private int x,y,w,h;
    //maximo de veces que paso el mouse por un punto
    private int max;
    private PaintWork pw;
    private boolean points,click;
    private ArrayList<Point> clicks;
    private Graphics2D g2;
    
    public MouseTrakingAnswer(String imgAsk){
        max=0;w=640;h=480;
        pw=new PaintWork();
        
        matriz=new int[w][h];
        for(x=0;x<w;x++){
            for(int y=0;y<h;y++){
                matriz[x][y]=0;
            }
        }
        x=y=0;
        click=points=false;
        this.imgAsk=imgAsk;
        this.setImagen(imgAsk);
    }
    
    public void setImageAsk(String imgAsk){
        this.imgAsk=imgAsk;
    }
    
    public void setPoints(ArrayList<Point> puntos){
        if(!puntos.isEmpty()){
            for(int i=0;i<puntos.size();i++){
                x=(int)puntos.get(i).getX();
                y=(int)puntos.get(i).getY();
                matriz[x][y]++;
                if(max<matriz[x][y])
                    max=matriz[x][y];
            }
            points=true;
            click=false;
        }
    }
    
    public void setPointClick(ArrayList<Point> puntos){
        if(!puntos.isEmpty()){
            clicks=puntos;
            points=false;
            click=true;
        }
    }
    
    public void clear(){
        max=0;
        for(x=0;x<w;x++){
            for(int y=0;y<h;y++){
                matriz[x][y]=0;
            }
        }
        click=points=false;
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        g2=(Graphics2D)g;
        this.setImagen(imgAsk);
        if(points){
            for(x=0;x<w;x++){
                for(y=0;y<h;y++){
                    if(matriz[x][y]!=0){
                        g2.setColor(pw.getColor(max, matriz[x][y]));
                        g2.fillOval(x-20, y-20, 40, 40);
                    }
                }
            }
        }
        if(click){
            for(int i=0;i<clicks.size();i++){
                x=(int)clicks.get(i).getX();
                y=(int)clicks.get(i).getY();
                g2.drawOval(x-20, y-20, 40, 40);
                g2.fillOval(x-10, y-10, 20, 20);
            }
        }
    }
}