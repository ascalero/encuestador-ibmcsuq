package interfaz.FrameEncuestas;


import interfaz.JPanelConFondo;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.plaf.basic.BasicTreeUI;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shadow
 */
public class MouseTraking extends JPanelConFondo implements MouseMotionListener,MouseListener{
    
    int w,h;
    ArrayList<Point> datos;
    Point p;
    
    public MouseTraking(String imgAsk){
        w=640;h=480;
        datos=new ArrayList<Point>();
        
        this.setImagen(imgAsk);
        
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }
    
    public void clear(){
        datos.clear();
        p=null;
    }
    
    public ArrayList<Point> getPoints(){
        return datos;
    }
    
    public Point getClick(){
        return p;
    }
    
    public boolean isEmpty(){
        return datos.isEmpty();
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
        if((e.getPoint().getX() < w) && (e.getPoint().getY() < h)){
            datos.add(e.getPoint());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if((e.getPoint().getX() < w) && (e.getPoint().getY() < h)){
            datos.add(e.getPoint());
            p=e.getPoint();
        }
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
}
