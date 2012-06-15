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
import javax.swing.WindowConstants;
import org.jdesktop.swingx.JXFrame;

/**
 *
 * @author Shadow
 */
public class RegAdmin extends JXFrame implements ActionListener{
    String[] strTemp= new String[4];
    int foo;
    JLabel jlNombre,jlApPat,jlApMat,jlNick,jlPass;
    JTextField jtfNombre,jtfApPat,jtfApMat,jtfNick,jtfPass;
    JButton jbOk,jbCancelar;
    
    public RegAdmin(int lenguaje){
        foo=lenguaje;
        strTemp[0]="Registro Administrador";strTemp[1]="";strTemp[2]="";strTemp[3]="";
        this.setTitle(strTemp[foo]);
        setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
        setLocation(10,0);
        setSize(535,255);
        setVisible (true);
        initComp();
    }
    
    private void initComp(){
        JPanel contenedor=new JPanel(new GridLayout(0, 2));
        contenedor.setBounds(10,10,500,200);
        strTemp[0]="Introduce tus Datos";strTemp[1]="";strTemp[2]="";strTemp[3]="";
        contenedor.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
        
        //<editor-fold defaultstate="collapsed" desc="Inicializacion contenido">
        strTemp[0]="Nombre";strTemp[1]="Name";strTemp[2]="";strTemp[3]="";
        jlNombre=new JLabel(strTemp[foo]);
        jtfNombre=new JTextField();
        contenedor.add(jlNombre);
        contenedor.add(jtfNombre);
        
        strTemp[0]="Apellido Paterno";strTemp[1]="";strTemp[2]="";strTemp[3]="";
        jlApPat=new JLabel(strTemp[foo]);
        jtfApPat=new JTextField();
        contenedor.add(jlApPat);
        contenedor.add(jtfApPat);
        
        strTemp[0]="Apellido Materno";strTemp[1]="";strTemp[2]="";strTemp[3]="";
        jlApMat=new JLabel(strTemp[foo]);
        jtfApMat=new JTextField();
        contenedor.add(jlApMat);
        contenedor.add(jtfApMat);
        
        strTemp[0]="Usuario";strTemp[1]="User";strTemp[2]="";strTemp[3]="";
        jlNick=new JLabel(strTemp[foo]);
        jtfNick=new JTextField();
        contenedor.add(jlNick);
        contenedor.add(jtfNick);
        
        strTemp[0]="Contraseña";strTemp[1]="Password";strTemp[2]="";strTemp[3]="";
        jlPass=new JLabel(strTemp[foo]);
        jtfPass=new JTextField();
        contenedor.add(jlPass);
        contenedor.add(jtfPass);
        
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
    
    private boolean getDatos(){
        if (jtfNombre.getText().equals("")){jtfNombre.requestFocus();
            strTemp[0]="Falto Nombre";strTemp[1]="";strTemp[2]="";strTemp[3]="";
            JOptionPane.showMessageDialog(null,strTemp[foo],"MSG",JOptionPane.INFORMATION_MESSAGE);
            return false;}
        if (jtfApPat.getText().equals("")){jtfApPat.requestFocus();
            strTemp[0]="Falto Apellido Paterno";strTemp[1]="";strTemp[2]="";strTemp[3]="";
            JOptionPane.showMessageDialog(null,strTemp[foo],"MSG",JOptionPane.INFORMATION_MESSAGE);
            return false;}
        if (jtfApMat.getText().equals("")){jtfApMat.requestFocus();
            strTemp[0]="Falto Apellido Materno";strTemp[1]="";strTemp[2]="";strTemp[3]="";
            JOptionPane.showMessageDialog(null,strTemp[foo],"MSG",JOptionPane.INFORMATION_MESSAGE);
            return false;}
        if (jtfNick.getText().equals("")){jtfNick.requestFocus();
            strTemp[0]="Itrodusca su Usuario";strTemp[1]="";strTemp[2]="";strTemp[3]="";
            JOptionPane.showMessageDialog(null,strTemp[foo],"MSG",JOptionPane.INFORMATION_MESSAGE);
            return false;}
        if (jtfPass.getText().equals("")){jtfNick.requestFocus();
            strTemp[0]="Itrodusca su Contraseña";strTemp[1]="";strTemp[2]="";strTemp[3]="";
            JOptionPane.showMessageDialog(null,strTemp[foo],"MSG",JOptionPane.INFORMATION_MESSAGE);
            return false;}
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList <String> info=new ArrayList <String>();
        if(e.getSource()==jbOk){
            if(getDatos()){
                //jtfNombre,jtfApPat,jtfApMat,jtfNick,jtfPass;
                info.add(jtfNombre.getText());
                info.add(jtfApPat.getText());
                info.add(jtfApMat.getText());
                info.add(jtfNick.getText());
                info.add(jtfPass.getText());
            }
        }
        if(e.getSource()==jbCancelar){
            PanelMiembro pm=new PanelMiembro(foo);
            this.dispose();
        }
    }
}
