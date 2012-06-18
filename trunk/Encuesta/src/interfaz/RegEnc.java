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
    
    private void initComp(){
        JPanel jpEnc=new JPanel(new GridLayout(0, 2));
        jpEnc.setBounds(10,10,100,200);
        
        
        //<editor-fold defaultstate="collapsed" desc="Inicializacion contenido">
        JPanel contenedor=new JPanel(new GridLayout(0, 2));
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
        sexo =new JComboBox(selectSexo());
        contenedor.add(jlSexo);
        contenedor.add(sexo);
        
        strTemp[0]="Escolaridad";strTemp[1]="Schooling";strTemp[2]="Schulung";strTemp[3]="Scolarité";
        jlEscolaridad=new JLabel(strTemp[foo]);
        escolaridad =new JComboBox(selectEscolaridad());
        contenedor.add(jlEscolaridad);
        contenedor.add(escolaridad);
        
        strTemp[0]="Experiencia";strTemp[1]="Experience";strTemp[2]="Erfahrung";strTemp[3]="Expérience";
        jlExperiencia=new JLabel(strTemp[foo]);
        experiencia =new JComboBox(selectExperiancia());
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
    
    private Object[] selectSexo(){
        Object[] sex=new Object[3];
        switch(foo){
            case 0 :sex[0]="Hombre";sex[1]="Mujer";sex[2]="Otros";break;
            case 1 :sex[0]="Man";sex[1]="Woman";sex[2]="Others";break;
            case 2 :sex[0]="Mann";sex[1]="Frau";sex[2]="Andere";break;
            default :sex[0]="Homme";sex[1]="Femme";sex[2]="D'autres";break;
        }
        return sex;
    }
    
    private Object[] selectEscolaridad(){
        Object[] sex=new Object[3];
        switch(foo){
            case 0 :sex[0]="Sin Estudios";sex[1]="Peparatoria";sex[2]="Superior";break;
            case 1 :sex[0]="No Education";sex[1]="Preparatory";sex[2]="High School";break;
            case 2 :sex[0]="Keine Erziehung";sex[1]="Vorbereitende";sex[2]="Hochschule";break;
            default :sex[0]="Pas de l'éducation";sex[1]="Préparatoire";sex[2]="Université";break;
        }
        return sex;
    }
    
    private Object[] selectExperiancia(){
        Object[] sex=new Object[3];
        switch(foo){
            case 0 :sex[0]="Poca";sex[1]="Regular";sex[2]="Mucha";break;
            case 1 :sex[0]="Little";sex[1]="Regular";sex[2]="Much";break;
            case 2 :sex[0]="Wenig";sex[1]="Regelmäßig";sex[2]="Viel";break;
            default :sex[0]="Peu";sex[1]="Ordinaire";sex[2]="Beaucoup";break;
        }
        return sex;
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
}
