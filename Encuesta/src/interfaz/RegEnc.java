/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

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
    JLabel jlNick,jlEdad,jlSexo,jlEscolaridad,jlExperiencia;
    JTextField jtfNick,jtfEdad;
    JComboBox escolaridad,experiencia,sexo,encuestas;
    JButton jbOk,jbCancelar;
    
    public RegEnc(int lenguaje){
        foo=lenguaje;
        strTemp[0]="Registro Usuario";strTemp[1]="";strTemp[2]="";strTemp[3]="";
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
        strTemp[0]="Introduce tus Datos";strTemp[1]="";strTemp[2]="";strTemp[3]="";
        contenedor.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
        
        strTemp[0]="Usuario";strTemp[1]="User";strTemp[2]="";strTemp[3]="";
        jlNick=new JLabel(strTemp[foo]);
        jtfNick=new JTextField();
        contenedor.add(jlNick);
        contenedor.add(jtfNick);
        
        strTemp[0]="Edad";strTemp[1]="Age";strTemp[2]="";strTemp[3]="";
        jlEdad=new JLabel(strTemp[foo]);
        jtfEdad=new JTextField();
        contenedor.add(jlEdad);
        contenedor.add(jtfEdad);
        
        strTemp[0]="Sexo";strTemp[1]="Sex";strTemp[2]="";strTemp[3]="";
        jlSexo=new JLabel(strTemp[foo]);
        sexo =new JComboBox(selectSexo());
        contenedor.add(jlSexo);
        contenedor.add(sexo);
        
        strTemp[0]="Escolaridad";strTemp[1]="";strTemp[2]="";strTemp[3]="";
        jlEscolaridad=new JLabel(strTemp[foo]);
        escolaridad =new JComboBox(selectEscolaridad());
        contenedor.add(jlEscolaridad);
        contenedor.add(escolaridad);
        
        strTemp[0]="Experiencia";strTemp[1]="Sex";strTemp[2]="";strTemp[3]="";
        jlExperiencia=new JLabel(strTemp[foo]);
        experiencia =new JComboBox(selectExperiancia());
        contenedor.add(jlExperiencia);
        contenedor.add(experiencia);
        
        strTemp[0]="Aceptar";strTemp[1]="Accept";strTemp[2]="";strTemp[3]="";
        jbOk=new JButton(strTemp[foo]);
        jbOk.addActionListener(this);
        strTemp[0]="Cancelar";strTemp[1]="Cancel";strTemp[2]="";strTemp[3]="";
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
            case 2 :sex[0]="";sex[1]="";sex[2]="";break;
            default :sex[0]="";sex[1]="";sex[2]="";break;
        }
        return sex;
    }
    
    private Object[] selectEscolaridad(){
        Object[] sex=new Object[3];
        switch(foo){
            case 0 :sex[0]="Sin Estudios";sex[1]="Peparatoria";sex[2]="Superior";break;
            case 1 :sex[0]="";sex[1]="";sex[2]="";break;
            case 2 :sex[0]="";sex[1]="";sex[2]="";break;
            default :sex[0]="";sex[1]="";sex[2]="";break;
        }
        return sex;
    }
    
    private Object[] selectExperiancia(){
        Object[] sex=new Object[3];
        switch(foo){
            case 0 :sex[0]="Poca";sex[1]="Regular";sex[2]="Mucha";break;
            case 1 :sex[0]="";sex[1]="";sex[2]="";break;
            case 2 :sex[0]="";sex[1]="";sex[2]="";break;
            default :sex[0]="";sex[1]="";sex[2]="";break;
        }
        return sex;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList <String> info=new ArrayList <String>();
        if(e.getSource()==jbOk){
            if(getDatos()){
                FrameSurvey beta= new FrameSurvey(foo/*info*/);
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
            strTemp[0]="Itrodusca su Usuario";strTemp[1]="";strTemp[2]="";strTemp[3]="";
            JOptionPane.showMessageDialog(null,strTemp[foo],"MSG",JOptionPane.INFORMATION_MESSAGE);
            return false;}
        if (jtfEdad.getText().equals("")){jtfNick.requestFocus();
            strTemp[0]="Itrodusca su Edad";strTemp[1]="";strTemp[2]="";strTemp[3]="";
            JOptionPane.showMessageDialog(null,strTemp[foo],"MSG",JOptionPane.INFORMATION_MESSAGE);
            return false;}
        return true;
    }
}
