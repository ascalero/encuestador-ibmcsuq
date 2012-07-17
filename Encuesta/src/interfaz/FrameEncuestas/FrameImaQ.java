/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.FrameEncuestas;

import estructuras.*;
import interfaz.JPanelConFondo;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jdesktop.swingx.JXFrame;

/**
 *
 * @author Shadow
 */
public class FrameImaQ extends JXFrame implements ActionListener{

    private int foo;
    private Survey s;
    private RespEnq re;
    
    //Componentes de la interfaz
    private JPanel body;
    private JRadioButton jrbImaQ[];
    private JButton jbNext;
    
    public FrameImaQ(int foo,Survey s,RespEnq re){
        this.foo=foo;
        this.s=s;
        this.re=re;
        
        //setTitle(s.getName());
        setTitle("Name Enc");
        initComp();
        
        setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
        setLocation(10,0);
        setSize(535,350);
        setVisible (true);
    }
    
    public void initComp(){
        body=new JPanel(new GridLayout(0,1));
        body.setBounds(10, 10, 500, 290);
        //body.setBorder(BorderFactory.createTitledBorder(s.getNextStIQ().getQuest(foo)));
        body.setBorder(BorderFactory.createTitledBorder("¿Pregunta?"));
        
        //String imgQ[]=s.getNextStIQ().getDir();
        //JPanelConFondo jpImgs[]=new JPanelConFondo[imgQ.length];
        JPanelConFondo jpImgs[]=new JPanelConFondo[4];
        for(int i=0;i<4;i++){
            //jpImgs[i]=new JPanelConFondo(imgQ[i]);
            jpImgs[i]=new JPanelConFondo("test.png");
            jrbImaQ[i]=new JRadioButton(""+(i+1),null);
        }
        
        
        
        setLayout(null);
        add(body);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {}
    
}
