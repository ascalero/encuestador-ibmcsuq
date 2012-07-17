/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.FrameEncuestas;

import estructuras.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jdesktop.swingx.JXFrame;

/**
 *
 * @author Shadow
 */
public class FrameLikeIt extends JXFrame implements ActionListener{

    private int foo;
    private Survey s;
    private RespEnq re;
    
    public FrameLikeIt(int foo,Survey s,RespEnq re){
        this.foo=foo;
        this.s=s;
        this.re=re;
        
        setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
        setLocation(10,0);
        setSize(535,350);
        setVisible (true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {}
    
}
