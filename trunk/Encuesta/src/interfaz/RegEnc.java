/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import conex.OpBasicas;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    
    public RegEnc(int lenguaje){
        foo=lenguaje;
        strTemp[0]="Registro Usuario";strTemp[1]="User Registration";strTemp[2]="Benutzer Anmelden";strTemp[3]="Enregistrement de l'utilisateur";
        this.setTitle(strTemp[foo]);
        setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
        setLocation(10,0);
        setSize(535,255);
        setVisible (true);
        initComp();
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
                
                FrameSurvey beta= new FrameSurvey(foo,info,nomEnc);
                this.dispose();
            }
        }
        if(e.getSource()==jbCancelar){
            PanelMiembro pm=new PanelMiembro(foo);
            this.dispose();
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
}
