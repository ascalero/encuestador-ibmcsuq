/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import conex.LoginConx;
import conex.OpBasicas;
import estructuras.RespEnq;
import estructuras.Survey;
import interfaz.FrameEncuestas.FrameAskFree;
import interfaz.FrameEncuestas.FrameImaQ;
import interfaz.FrameEncuestas.FrameLikeIt;
import interfaz.FrameEncuestas.FrameMouseTraking;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.jdesktop.swingx.JXFrame;

/**
 *
 * @author Shadow
 */
public class RegEnc extends JXFrame implements ActionListener{
    String[] strTemp= new String[4];
    int foo;
    JLabel jlNick,jlEdad,jlSexo,jlEscolaridad,jlExperiencia,jlEncuesta;
    JTextField jtfNick,jtfEdad;
    JComboBox escolaridad,experiencia,sexo,encuestas;
    JButton jbOk,jbCancelar;
    JPanel contenedor;
            
    //<editor-fold defaultstate="collapsed" desc="Variables Menu">
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    JRadioButtonMenuItem rbMILang[];
    
    //</editor-fold>
    
    
    public RegEnc(int lenguaje){
        foo=lenguaje;
        strTemp[0]="Registro Usuario";strTemp[1]="User Registration";strTemp[2]="Benutzer Anmelden";strTemp[3]="Enregistrement de l'utilisateur";
        this.setTitle(strTemp[foo]);
        setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
        setLocation(10,0);
        setSize(535,255);
        setVisible (true);
        initComp();
        menuCharger();
    }
    
    public void setIdioma(int foobar){
        this.foo=foobar;
        strTemp[0]="Registro Usuario";strTemp[1]="User Registration";strTemp[2]="Benutzer Anmelden";strTemp[3]="Enregistrement de l'utilisateur";
        this.setTitle(strTemp[foo]);
        
        strTemp[0]="Introduce tus Datos";strTemp[1]="Enter your Details";strTemp[2]="Geben Sie Ihre Daten";strTemp[3]="Entrez vos Coordonnées";
        contenedor.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
        
        strTemp[0]="Seleccionar Encuesta";strTemp[1]="Select survey";strTemp[2]="Wählen Umfrage";strTemp[3]="Sélectionnez l'enquête";
        jlEncuesta.setText(strTemp[foo]);
        strTemp[0]="Usuario";strTemp[1]="User";strTemp[2]="Benutzer";strTemp[3]="Utilisateur";
        jlNick.setText(strTemp[foo]);
        strTemp[0]="Edad";strTemp[1]="Age";strTemp[2]="Alter";strTemp[3]="âge";
        jlEdad.setText(strTemp[foo]);
        strTemp[0]="Sexo";strTemp[1]="Sex";strTemp[2]="Sex";strTemp[3]="Sexe";
        jlSexo.setText(strTemp[foo]);
        strTemp[0]="Escolaridad";strTemp[1]="Schooling";strTemp[2]="Schulung";strTemp[3]="Scolarité";
        jlEscolaridad.setText(strTemp[foo]);
        strTemp[0]="Experiencia";strTemp[1]="Experience";strTemp[2]="Erfahrung";strTemp[3]="Expérience";
        jlExperiencia.setText(strTemp[foo]);
        strTemp[0]="Aceptar";strTemp[1]="Accept";strTemp[2]="Akzeptieren";strTemp[3]="Accepter";
        jbOk.setText(strTemp[foo]);
        strTemp[0]="Cancelar";strTemp[1]="Cancel";strTemp[2]="Stornieren";strTemp[3]="Annuler";
        jbCancelar.setText(strTemp[foo]);
        
        setSexo(sexo);
        setExperiancia(experiencia);
        setEscolaridad(escolaridad);
    }
    
    private void initComp(){
        JPanel jpEnc=new JPanel(new GridLayout(0, 2));
        jpEnc.setBounds(10,10,100,200);
        
        
        //<editor-fold defaultstate="collapsed" desc="Inicializacion contenido">
        contenedor=new JPanel(new GridLayout(0, 2));
        contenedor.setBounds(10,10,500,200);
        strTemp[0]="Introduce tus Datos";strTemp[1]="Enter your Details";strTemp[2]="Geben Sie Ihre Daten";strTemp[3]="Entrez vos Coordonnées";
        contenedor.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
        
        strTemp[0]="Seleccionar Encuesta";strTemp[1]="Select survey";strTemp[2]="Wählen Umfrage";strTemp[3]="Sélectionnez l'enquête";
        jlEncuesta=new JLabel(strTemp[foo]);
        encuestas =new JComboBox(selectEncuesta());
        contenedor.add(jlEncuesta);
        contenedor.add(encuestas);
        
        strTemp[0]="Usuario";strTemp[1]="User";strTemp[2]="Benutzer";strTemp[3]="Utilisateur";
        jlNick=new JLabel(strTemp[foo]);
        jtfNick=new JTextField();
        contenedor.add(jlNick);
        contenedor.add(jtfNick);
        
        strTemp[0]="Edad";strTemp[1]="Age";strTemp[2]="Alter";strTemp[3]="âge";
        jlEdad=new JLabel(strTemp[foo]);
        jtfEdad=new JTextField();
        contenedor.add(jlEdad);
        contenedor.add(jtfEdad);
        
        strTemp[0]="Sexo";strTemp[1]="Sex";strTemp[2]="Sex";strTemp[3]="Sexe";
        jlSexo=new JLabel(strTemp[foo]);
        sexo =new JComboBox();
        setSexo(sexo);
        contenedor.add(jlSexo);
        contenedor.add(sexo);
        
        strTemp[0]="Escolaridad";strTemp[1]="Schooling";strTemp[2]="Schulung";strTemp[3]="Scolarité";
        jlEscolaridad=new JLabel(strTemp[foo]);
        escolaridad =new JComboBox();
        setEscolaridad(escolaridad);
        contenedor.add(jlEscolaridad);
        contenedor.add(escolaridad);
        
        strTemp[0]="Experiencia";strTemp[1]="Experience";strTemp[2]="Erfahrung";strTemp[3]="Expérience";
        jlExperiencia=new JLabel(strTemp[foo]);
        experiencia =new JComboBox();
        setExperiancia(experiencia);
        contenedor.add(jlExperiencia);
        contenedor.add(experiencia);
        
        strTemp[0]="Aceptar";strTemp[1]="Accept";strTemp[2]="Akzeptieren";strTemp[3]="Accepter";
        jbOk=new JButton(strTemp[foo]);
        jbOk.addActionListener(this);
        strTemp[0]="Cancelar";strTemp[1]="Cancel";strTemp[2]="Stornieren";strTemp[3]="Annuler";
        jbCancelar=new JButton(strTemp[foo]);
        jbCancelar.addActionListener(this);
        contenedor.add(jbOk);
        contenedor.add(jbCancelar);
        //</editor-fold>
        
        setLayout(null);
        add(contenedor);
    }
    
    private void setSexo(JComboBox jcb){
        eraseDataJcb(jcb);
        Object[] sex=new Object[3];
        switch(foo){
            case 0 :sex[0]="Hombre";sex[1]="Mujer";sex[2]="Otros";break;
            case 1 :sex[0]="Man";sex[1]="Woman";sex[2]="Others";break;
            case 2 :sex[0]="Mann";sex[1]="Frau";sex[2]="Andere";break;
            default :sex[0]="Homme";sex[1]="Femme";sex[2]="D'autres";break;
        }
        for(Object a:sex){
            jcb.addItem(a);
        }
    }
    
    private void setEscolaridad(JComboBox jcb){
        eraseDataJcb(jcb);
        Object[] grado=new Object[3];
        switch(foo){
            case 0 :grado[0]="Sin Estudios";grado[1]="Peparatoria";grado[2]="Superior";break;
            case 1 :grado[0]="No Education";grado[1]="Preparatory";grado[2]="High School";break;
            case 2 :grado[0]="Keine Erziehung";grado[1]="Vorbereitende";grado[2]="Hochschule";break;
            default :grado[0]="Pas de l'éducation";grado[1]="Préparatoire";grado[2]="Université";break;
        }
        for(Object a:grado){
            jcb.addItem(a);
        }
    }
    
    private void setExperiancia(JComboBox jcb){
        eraseDataJcb(jcb);
        Object[] exp=new Object[3];
        switch(foo){
            case 0 :exp[0]="Poca";exp[1]="Regular";exp[2]="Mucha";break;
            case 1 :exp[0]="Little";exp[1]="Regular";exp[2]="Much";break;
            case 2 :exp[0]="Wenig";exp[1]="Regelmäßig";exp[2]="Viel";break;
            default :exp[0]="Peu";exp[1]="Ordinaire";exp[2]="Beaucoup";break;
        }
        for(Object a:exp){
            jcb.addItem(a);
        }
    }
    
    public Object[] selectEncuesta(){
        OpBasicas op=new OpBasicas();
        Object[] encuestas;
        encuestas=op.getproy();
        if (encuestas==null){
            encuestas=new Object[0];
            switch(foo){
                case 0 :encuestas[0]="No hay encuestas";break;
                case 1 :encuestas[0]="No surveys";break;
                case 2 :encuestas[0]="Keine Umfragen";break;
                default :encuestas[0]="Aucun Sondage";break;
            }
        }
        return encuestas;
    }

    private void launchEnq(ArrayList<String> datos,String nE){
        LoginConx contmp=new LoginConx();
        Survey sur=contmp.getBLOBProy(nE);
        if(sur==null){
            System.out.println("Vacio");
            FrameSurvey beta= new FrameSurvey(foo,datos,nE);
            this.dispose();
            return;
        }
        int []temp=new int[sur.getActSize()];
        int i=0;
        for(int x:sur.getSeq()){
            temp[i]=x;
            i++;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(RegEnc.class.getName()).log(Level.SEVERE, null, ex);
        }
        RespEnq re=new RespEnq(temp);
        sur.resetActuales();
        switch(sur.getNext()){
                case 0:new FrameAskFree(foo,sur,re,datos,sur.getNextStq());break;
                case 1:new FrameLikeIt(foo,sur,re,datos,sur.getNextLI());break;
                case 2:new FrameImaQ(foo,sur,re,datos,sur.getNextStIQ());break;
                case 3:new FrameMouseTraking(foo,sur,re,datos,sur.getNextQG());
                default:break;
            }
            this.dispose();
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList <String> info=new ArrayList <String>();
        if(e.getSource()==jbOk){
            if(getDatos()){
                info.add(jtfNick.getText());
                info.add(jtfEdad.getText());
                info.add(sexo.getSelectedIndex()+"");
                info.add(escolaridad.getSelectedIndex()+"");
                info.add(experiencia.getSelectedIndex()+"");
                
                String nomEnc=encuestas.getSelectedItem()+"";
                launchEnq(info, nomEnc);
                
            }
        }
        if(e.getSource()==jbCancelar){
            PanelMiembro pm=new PanelMiembro(foo);
            this.dispose();
        }
        for(int i=0;i<4;i++){
                if(e.getSource()==rbMILang[i]){
                    for(int j=0;j<4;j++){
                        rbMILang[j].setSelected(false);
                    }
                    rbMILang[i].setSelected(true);
                    setIdioma(i);
                }
        }
    }
    
    private boolean getDatos(){
        if (jtfNick.getText().equals("")){jtfNick.requestFocus();
            strTemp[0]="Introduzca su Usuario";strTemp[1]="Enter your Username";strTemp[2]="Geben Sie Ihren Benutzernamen";strTemp[3]="Entrez Votre Nom D'utilisateur";
            JOptionPane.showMessageDialog(null,strTemp[foo],"MSG",JOptionPane.INFORMATION_MESSAGE);
            return false;}
        if (jtfEdad.getText().equals("")){jtfNick.requestFocus();
            strTemp[0]="Introduzca su Edad";strTemp[1]="Enter your Age";strTemp[2]="Geben Sie Ihr Alter";strTemp[3]="Entrer Votre âge";
            JOptionPane.showMessageDialog(null,strTemp[foo],"MSG",JOptionPane.INFORMATION_MESSAGE);
            return false;}
        return true;
    }
    
    private void eraseDataJcb(JComboBox d){
        d.removeAllItems();
    }
    
    
    public void menuCharger(){
    menuBar=new JMenuBar();
    menu = new JMenu();
    strTemp[0]="Idioma";strTemp[1]="Language";strTemp[2]="Sprache";strTemp[3]="langue";
    menu.setText(strTemp[foo]);
    menuBar.add(Box.createHorizontalGlue());
    menuBar.add(menu);
    strTemp[0]="Selecciona tu idioma";strTemp[1]="Select your language";strTemp[2]="Wählen Sie Ihre Sprache";strTemp[3]="Choisissez votre langue";
    menuItem = new JMenuItem(strTemp[foo]);
    menuItem.setEnabled(false);
    menu.add(menuItem);
    menu.addSeparator();
    rbMILang= new JRadioButtonMenuItem[4];
    rbMILang[0]= new JRadioButtonMenuItem("Español");
    rbMILang[1]= new JRadioButtonMenuItem("English");
    rbMILang[2]= new JRadioButtonMenuItem("Deutsh");
    rbMILang[3]= new JRadioButtonMenuItem("Française");
    rbMILang[foo].setSelected(true);
    menu.addSeparator();
    for(int i=0;i<4;i++){
        menu.add(rbMILang[i]);
        rbMILang[i].addActionListener(this);
    }
    this.setJMenuBar(menuBar);
        //this.add(menuBar);
    }
    
}
