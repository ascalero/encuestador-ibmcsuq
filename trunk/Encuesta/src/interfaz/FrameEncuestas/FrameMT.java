/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.FrameEncuestas;

import estructuras.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jdesktop.swingx.JXFrame;

/**
 *
 * @author Shadow
 */
public class FrameMT extends JXFrame{

    private int foo;
    private String strTemp[]=new String[4];
    
    private Survey s;
    private RespEnq re;
    
    //MouseTraking mt;
    MouseTraking1 mt;
    
    private JPanel body;
    
    public FrameMT(int foo,Survey s,RespEnq re){
        this.foo=foo;
        this.s=s;
        this.re=re;
        
        //setTitle(s.getName());
        setTitle("Name Enc");
        initComp();
        
        setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
        setLocation(10,20);
        setSize(690, 560);
        setVisible (true);
    }

    public void initComp(){
        body=new JPanel(new GridLayout(0, 1));
        body.setBounds(10, 10, 650, 500);
        //body.setBorder(BorderFactory.createTitledBorder(s.getNextQG().getQuest(foo)));
        body.setBorder(BorderFactory.createTitledBorder("¿Pregunta?"));
        
        //mt=new MouseTraking(s.getNextQG().getDir());
        //mt=new MouseTraking("test.png");
        mt=new MouseTraking1("test.png");
        mt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println("Escuche el Click");
            }
         });
        body.add(mt);
        
        setLayout(null);
        add(body);
    }
}
