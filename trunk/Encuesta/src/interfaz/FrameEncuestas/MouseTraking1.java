package interfaz.FrameEncuestas;


import interfaz.JPanelConFondo;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shadow
 */
public class MouseTraking1 extends JPanelConFondo implements MouseMotionListener,MouseListener{
    
    int w,h;
    ArrayList<Point> puntos;
    Point p;
    String imgAsk;
    
    public MouseTraking1(String imgAsk){
        w=640;h=480;
        this.imgAsk=imgAsk;
        puntos=new ArrayList<Point>();
        
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.setImagen(imgAsk);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2=(Graphics2D)g;
        this.setImagen(imgAsk);
        if(!puntos.isEmpty()){
            g2.setColor(Color.red);
            for(int i=1;i<puntos.size();i++){
                g2.drawLine((int)puntos.get(i-1).getX(), //punto 1
                            (int)puntos.get(i-1).getY(),
                            (int)puntos.get(i).getX(),   //punto 2
                            (int)puntos.get(i).getY());
            }
            //Click
            if(p!=null){
                g2.drawOval((int)p.getX()-15, (int)p.getY()-15, 30, 30);
                g2.fillOval((int)p.getX()-5, (int)p.getY()-5, 10, 10);
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if((e.getPoint().getX() < w) && (e.getPoint().getY() < h)){
            puntos.add(e.getPoint());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if((e.getPoint().getX() < w) && (e.getPoint().getY() < h)){
            puntos.add(e.getPoint());
            p=e.getPoint();
        }
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        puntos.clear();
        p=null;
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {}    
    
    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}
}
