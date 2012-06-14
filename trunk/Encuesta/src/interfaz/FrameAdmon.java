/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.*;
import org.jdesktop.swingx.*;

/**
 *
 * @author Ascalero
 */
public class FrameAdmon extends JXFrame{
    public String strTemp[]= new String[4];
    public JXPanel panelTareas,panelCard,panelBotones,panelNE,panelEE;
    public JXTaskPane tareas,sesTask;
    public JXTaskPaneContainer contTask;
    int foo;

    public FrameAdmon(int lang) {
    foo=lang;
    strTemp[0]="Consola Administrador";strTemp[1]="Administrator Settings";strTemp[2]="";strTemp[3]="";
    this.setTitle(strTemp[foo]);
    setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
    setLocation(10,0);
    this.setResizable(true);
    setSize(1240,720);
    setVisible (true);
    initComp();
    //bind();
    
    }
    
    private void initComp(){
        panelTareas = new JXPanel(new BorderLayout());
        panelTareas.setBounds(10,10, 200, 500);
        panelTareas.setBorder(BorderFactory.createTitledBorder("Tareas Comunes"));
        
        contTask = new JXTaskPaneContainer();
        contTask.setLayout(new VerticalLayout(2));
        contTask.setBackground(Color.LIGHT_GRAY);
        
        tareas=new JXTaskPane();
        tareas.setTitle("Opciones");
        
        tareas.add(new AbstractAction("Crear Encuesta") {
            @Override
            public void actionPerformed(ActionEvent e) {
                ;
            }
        });
        tareas.add(new AbstractAction("Ver Encuesta") {
            @Override
            public void actionPerformed(ActionEvent e) {
                ;
            }
        });
        tareas.add(new AbstractAction("Borrar Encuesta") {
            @Override
            public void actionPerformed(ActionEvent e) {
                ;
            }
        });
        
        sesTask= new JXTaskPane();
        sesTask.setTitle("Sesion");
        
            sesTask.add(new AbstractAction("Cerrar Sesion"){
                @Override
                public void actionPerformed(ActionEvent e) {
                ;
                }});
            sesTask.add(new AbstractAction("Salir"){
                @Override
                public void actionPerformed(ActionEvent e) {
                ;
                }});
        
        contTask.add(tareas);
        contTask.add(sesTask);
        panelTareas.add(contTask);
        
        setLayout(null);
        add(panelTareas);
    }

    

}
