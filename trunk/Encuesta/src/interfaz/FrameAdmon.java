/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import com.sun.corba.se.spi.ior.MakeImmutable;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import org.jdesktop.swingx.*;

/**
 *
 * @author Ascalero
 */
public class FrameAdmon extends JXFrame{
    private String strTemp[]= new String[4],User;
    private Font fuenteGrande=new Font("Arial",Font.BOLD,20);
    private JXPanel panelTareas,panelCard,panelEE,panelNE,panelSE,panelDatos;
    private CardLayout containerStack = new CardLayout(); 
    private JXTaskPane tareas,sesTask;
    private JXTaskPaneContainer contTask;
    private JButton butOKSurvey,butOKdel,butOKsel;
    private JComboBox jcbSurvey, jcbSel;
    private Object valCombo[],valCombo2[];
    
    int foo;
    
    private JTextField nombreEnc;
    private JTextArea descrip;

    public FrameAdmon(int lang,String du) {
    foo=lang;
    User=du;
    strTemp[0]="Consola Administrador: Bienvenido"+User;
    strTemp[1]="Administrator Settings: Welcome "+User; strTemp[2]="";strTemp[3]="";
    this.setTitle(strTemp[foo]);
    setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
    setLocation(10,0);
    this.setResizable(false);
    setSize(1240,720);
    setVisible (true);
    initComp();
    //bind();
    
    }
    
    private void initComp(){
        //<editor-fold defaultstate="collapsed" desc="Inicializacion panel de Tareas">
        panelTareas = new JXPanel(new BorderLayout());
        panelTareas.setBounds(10,10, 200, 500);
        strTemp[0]="Tareas Comunes";strTemp[1]="Common Task";strTemp[2]="";strTemp[3]="";
        panelTareas.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
        
        contTask = new JXTaskPaneContainer();
        contTask.setLayout(new VerticalLayout(2));
        contTask.setBackground(Color.LIGHT_GRAY);
        
        tareas=new JXTaskPane();
        strTemp[0]="Opciones";strTemp[1]="Options";strTemp[2]="";strTemp[3]="";
        tareas.setTitle(strTemp[foo]);
        strTemp[0]="Crear nuevo Proyecto";strTemp[1]="Make new Project";strTemp[2]="";strTemp[3]="";
        tareas.add(new AbstractAction(strTemp[foo]) {
            @Override
            public void actionPerformed(ActionEvent e) {
                containerStack.show(panelCard, "Nuevo");
                
            }
        });
        strTemp[0]="Ver Projecto";strTemp[1]="Check Project";strTemp[2]="";strTemp[3]="";
        tareas.add(new AbstractAction(strTemp[foo]) {
            @Override
            public void actionPerformed(ActionEvent e) {
                eraseDataJcb(jcbSel);
                valCombo2=getProy(User);
                if (valCombo2==null){
                strTemp[0]="No tienes Proyectos";strTemp[1]="You dont have any project";strTemp[2]="";strTemp[3]="";
                jcbSel.addItem(strTemp[0]);    
                }else{
                    for(Object d:valCombo2){
                    jcbSel.addItem(d);    
                    }
                }
                containerStack.show(panelCard, "Ver");
            }
        });
        strTemp[0]="Borrar Proyecto";strTemp[1]="Delete Project";strTemp[2]="";strTemp[3]="";
        tareas.add(new AbstractAction(strTemp[foo]) {
            @Override
            public void actionPerformed(ActionEvent e) {
                eraseDataJcb(jcbSurvey);
                valCombo=getProy(User);
                if (valCombo==null){
                strTemp[0]="No tienes Proyectos";strTemp[1]="You dont have any project";strTemp[2]="";strTemp[3]="";
                jcbSurvey.addItem(strTemp[foo]);    
                }else{
                    for(Object d:valCombo){
                    jcbSurvey.addItem(d);    
                    }
                }
                containerStack.show(panelCard, "Elimina");
                
                
            }
        });
        
        sesTask= new JXTaskPane();
        strTemp[0]="Opciones de Sesion";strTemp[1]="Session Options";strTemp[2]="";strTemp[3]="";
        sesTask.setTitle(strTemp[0]);
        strTemp[0]="Cerrar Sesion";strTemp[1]="Logout";strTemp[2]="";strTemp[3]="";
        sesTask.add(new AbstractAction(strTemp[foo]){
                @Override
                public void actionPerformed(ActionEvent e) {
                cerrarS();
                }});
        strTemp[0]="Salir";strTemp[1]="Close";strTemp[2]="";strTemp[3]="";
        sesTask.add(new AbstractAction(strTemp[foo]){
                @Override
                public void actionPerformed(ActionEvent e) {
                salir();
                }});
        
        contTask.add(tareas);
        contTask.add(sesTask);
        panelTareas.add(contTask);
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Inicializacion panel NuevaEncuesta">
        panelNE= new JXPanel(new BorderLayout());
        
        JPanel cont1=new JPanel();
        strTemp[0]="Nuevo Projecto";strTemp[1]="New Project";strTemp[2]="";strTemp[3]="";
        cont1.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
        cont1.setLayout(null);
        strTemp[0]="Crear Nuevo Projecto";strTemp[1]="Create New Project";strTemp[2]="";strTemp[3]="";
        JLabel neTitleJL= new JLabel(strTemp[foo],JLabel.CENTER);
        neTitleJL.setBounds(237,50,475,100);
        neTitleJL.setFont(fuenteGrande);
        strTemp[0]="Nombre del Proyecto";strTemp[1]="Project's Name";strTemp[2]="";strTemp[3]="";
        JLabel neNombreJL= new JLabel(strTemp[foo],JLabel.CENTER);
        neNombreJL.setBounds(118,150,237,100);
        neNombreJL.setFont(fuenteGrande);
        strTemp[0]="Descripcion";strTemp[1]="Description";strTemp[2]="";strTemp[3]="";
        JLabel neDescripJL= new JLabel(strTemp[foo],JLabel.CENTER);
        neDescripJL.setBounds(118,250,237,100);
        neDescripJL.setFont(fuenteGrande);
        
        nombreEnc=new JTextField(25);
        nombreEnc.setBounds(473,180,237,30);
        descrip= new JTextArea(10, 20);
        descrip.setBounds(473,280,237,80);
        descrip.setWrapStyleWord(true);
        descrip.setLineWrap(true);
        descrip.setAutoscrolls(true);
        strTemp[0]="Aceptar";strTemp[1]="Ok";strTemp[2]="";strTemp[3]="";
        butOKSurvey= new JButton("Aceptar");
        butOKSurvey.setBounds(355,380,200,100);
        
        
        cont1.add(neTitleJL);
        cont1.add(neNombreJL);
        cont1.add(neDescripJL);
        cont1.add(nombreEnc);
        cont1.add(descrip);
        cont1.add(butOKSurvey);
        panelNE.add(cont1,BorderLayout.CENTER);
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Inicializacion panel Borrar Encuestas">
        panelEE= new JXPanel(new BorderLayout());
        JPanel cont2= new JPanel();
        cont2.setLayout(null);
        strTemp[0]="Borrar Proyecto";strTemp[1]="Delete Project";strTemp[2]="";strTemp[3]="";
        cont2.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
        strTemp[0]="Selecione projecto a eliminar";strTemp[1]="Select Project to delete";strTemp[2]="";strTemp[3]="";
        JLabel neTitleJL2= new JLabel(strTemp[foo],JLabel.CENTER);
        neTitleJL2.setBounds(237,50,475,100);
        neTitleJL2.setFont(fuenteGrande);
        jcbSurvey= new JComboBox();
        jcbSurvey.setBounds(237, 250, 475, 40);
        jcbSurvey.setFont(fuenteGrande);
        //jcbSurvey.setModel(null);
        strTemp[0]="Aceptar";strTemp[1]="OK";strTemp[2]="";strTemp[3]="";
        butOKdel= new JButton(strTemp[foo]);
        butOKdel.setBounds(355,380,200,100);
        cont2.add(neTitleJL2);
        cont2.add(jcbSurvey);
        cont2.add(butOKdel);
        panelEE.add(cont2,BorderLayout.CENTER);
         //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Inicializacion panel Selecionar Encuesta">
        panelSE= new JXPanel(new BorderLayout());
        JPanel cont3= new JPanel();
        cont3.setLayout(null);
        strTemp[0]="Revisar Datos de la Encuesta";strTemp[1]="Check survey's Info";strTemp[2]="";strTemp[3]="";
        cont3.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
        strTemp[0]="Seleccionar el Proyecto a revisar";strTemp[1]="Select projects to check";strTemp[2]="";strTemp[3]="";
        JLabel neTitleJL3= new JLabel(strTemp[foo],JLabel.CENTER);
        neTitleJL3.setBounds(237,50,475,100);
        neTitleJL3.setFont(fuenteGrande);
        jcbSel= new JComboBox();
        jcbSel.setBounds(237, 250, 475, 40);
        jcbSel.setFont(fuenteGrande);
        //jcbSurvey.setModel(null);
        strTemp[0]="Aceptar";strTemp[1]="OK";strTemp[2]="";strTemp[3]="";
        butOKsel= new JButton(strTemp[foo]);
        butOKsel.setBounds(355,380,200,100);
        cont3.add(neTitleJL3);
        cont3.add(jcbSel);
        cont3.add(butOKsel);
        panelSE.add(cont3,BorderLayout.CENTER);
        //</editor-fold >
        
        
        
        
        
        
        panelCard= new JXPanel(containerStack);
        panelCard.setBounds(230, 10, 950 , 550);
        panelCard.add(panelNE,"Nuevo");
        panelCard.add(panelEE,"Elimina");
        panelCard.add(panelSE,"Ver");
        setLayout(null);
        add(panelTareas);
        add(panelCard);
        }
    
    private void eraseDataJcb(JComboBox d){
        d.removeAllItems();
    }
    private Object[] getProy(String user){
        return new conex.LoginConx().getproy(user);
    }
    
    private void cerrarS(){
        new PanelMiembro(foo);
        this.dispose();
    }
    private void salir(){
        new IntroFrame();
        this.dispose();
    }
        
}
