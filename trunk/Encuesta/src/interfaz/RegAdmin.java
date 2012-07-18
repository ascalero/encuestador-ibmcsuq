/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import conex.*;
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
    JPanel contenedor;
            
    //<editor-fold defaultstate="collapsed" desc="Variables Menu">
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    JRadioButtonMenuItem rbMILang[];
    
    //</editor-fold>
    
    
    public RegAdmin(int lenguaje){
        foo=lenguaje;
        strTemp[0]="Registro Administrador";strTemp[1]="Registration Administrator";strTemp[2]="Registrierung Administrator";strTemp[3]="D'enregistrement Administrateur";
        this.setTitle(strTemp[foo]);
        setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
        setLocation(10,0);
        setSize(535,275);
        setVisible (true);
        initComp();
        menuCharger();
    }
    
    public void setIdioma(int foobar){
        this.foo=foobar;
        strTemp[0]="Registro Administrador";strTemp[1]="Registration Administrator";strTemp[2]="Registrierung Administrator";strTemp[3]="D'enregistrement Administrateur";
        this.setTitle(strTemp[foo]);
        
        strTemp[0]="Introduce tus Datos";strTemp[1]="Enter your Details";strTemp[2]="Geben Sie Ihre Daten";strTemp[3]="Entrez vos Coordonnées";
        contenedor.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
        
        strTemp[0]="Id Usuario";strTemp[1]="Name";strTemp[2]="Name";strTemp[3]="Nom";
        jlNombre.setText(strTemp[foo]);
        strTemp[0]="Nombre(s)";strTemp[1]="Name(s)";strTemp[2]="Namen";strTemp[3]="Nom(s)";
        jlApPat.setText(strTemp[foo]);
        strTemp[0]="Apellido Paterno";strTemp[1]="Last Name";strTemp[2]="Nachname";strTemp[3]="Nom de Famille";
        jlApMat.setText(strTemp[foo]);
        strTemp[0]="Apellido Materno";strTemp[1]="Second Last Name";strTemp[2]="Mädchenname der Mutter";strTemp[3]="Nom de Jeune Fille de la Mère";
        jlNick.setText(strTemp[foo]);
        strTemp[0]="Contraseña";strTemp[1]="Password";strTemp[2]="Passwort";strTemp[3]="Mot de Passe";
        jlPass.setText(strTemp[foo]);
        strTemp[0]="Aceptar";strTemp[1]="Accept";strTemp[2]="Akzeptieren";strTemp[3]="Accepter";
        jbOk.setText(strTemp[foo]);
        strTemp[0]="Cancelar";strTemp[1]="Cancel";strTemp[2]="Stornieren";strTemp[3]="Annuler";
        jbCancelar.setText(strTemp[foo]);
    }
    
    private void initComp(){
        contenedor=new JPanel(new GridLayout(0, 2));
        contenedor.setBounds(10,10,500,200);
        strTemp[0]="Introduce tus Datos";strTemp[1]="Enter your Details";strTemp[2]="Geben Sie Ihre Daten";strTemp[3]="Entrez vos Coordonnées";
        contenedor.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
        
        //<editor-fold defaultstate="collapsed" desc="Inicializacion contenido">
        strTemp[0]="Id Usuario";strTemp[1]="Name";strTemp[2]="Name";strTemp[3]="Nom";
        jlNombre=new JLabel(strTemp[foo]);
        jtfNombre=new JTextField();
        contenedor.add(jlNombre);
        contenedor.add(jtfNombre);
        
        strTemp[0]="Nombre(s)";strTemp[1]="Name(s)";strTemp[2]="Namen";strTemp[3]="Nom(s)";
        jlApPat=new JLabel(strTemp[foo]);
        jtfApPat=new JTextField();
        contenedor.add(jlApPat);
        contenedor.add(jtfApPat);
        
        strTemp[0]="Apellido Paterno";strTemp[1]="Last Name";strTemp[2]="Nachname";strTemp[3]="Nom de Famille";
        jlApMat=new JLabel(strTemp[foo]);
        jtfApMat=new JTextField();
        contenedor.add(jlApMat);
        contenedor.add(jtfApMat);
        
        strTemp[0]="Apellido Materno";strTemp[1]="Second Last Name";strTemp[2]="Mädchenname der Mutter";strTemp[3]="Nom de Jeune Fille de la Mère";
        jlNick=new JLabel(strTemp[foo]);
        jtfNick=new JTextField();
        contenedor.add(jlNick);
        contenedor.add(jtfNick);
        
        strTemp[0]="Contraseña";strTemp[1]="Password";strTemp[2]="Passwort";strTemp[3]="Mot de Passe";
        jlPass=new JLabel(strTemp[foo]);
        jtfPass=new JTextField();
        contenedor.add(jlPass);
        contenedor.add(jtfPass);
        
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
    
    private boolean getDatos(){
        if (jtfNombre.getText().equals("")){jtfNombre.requestFocus();
            strTemp[0]="Falto Nombre";strTemp[1]="Lack Name";strTemp[2]="Mangel Namen";strTemp[3]="Nom Absence";
            JOptionPane.showMessageDialog(null,strTemp[foo],"MSG",JOptionPane.INFORMATION_MESSAGE);
            return false;}
        if (jtfApPat.getText().equals("")){jtfApPat.requestFocus();
            strTemp[0]="Falto Apellido Paterno";strTemp[1]="Missing Last Name";strTemp[2]="Fehlende Nachname";strTemp[3]="Nom de Famille Manquant";
            JOptionPane.showMessageDialog(null,strTemp[foo],"MSG",JOptionPane.INFORMATION_MESSAGE);
            return false;}
        if (jtfApMat.getText().equals("")){jtfApMat.requestFocus();
            strTemp[0]="Falto Apellido Materno";strTemp[1]="Missing Second Last Name";strTemp[2]="Nachname Fehlt";strTemp[3]="Le Nom de Famille Disparus";
            JOptionPane.showMessageDialog(null,strTemp[foo],"MSG",JOptionPane.INFORMATION_MESSAGE);
            return false;}
        if (jtfNick.getText().equals("")){jtfNick.requestFocus();
            strTemp[0]="Introduzca su Usuario";strTemp[1]="Enter your Username";strTemp[2]="Geben Sie Ihren Benutzernamen";strTemp[3]="Entrez Votre Nom D'utilisateur";
            JOptionPane.showMessageDialog(null,strTemp[foo],"MSG",JOptionPane.INFORMATION_MESSAGE);
            return false;}
        if (jtfPass.getText().equals("")){jtfNick.requestFocus();
            strTemp[0]="Introduzca su Contraseña";strTemp[1]="Enter your Password";strTemp[2]="Geben Sie Ihr Kennwort";strTemp[3]="Entrez Votre Mot De Passe";
            JOptionPane.showMessageDialog(null,strTemp[foo],"MSG",JOptionPane.INFORMATION_MESSAGE);
            return false;}
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList <String> info=new ArrayList <String>();
        if(e.getSource()==jbOk){
            if(getDatos()){
                OpBasicas op=new OpBasicas();
                
                info.add(jtfNombre.getText());
                info.add(jtfApPat.getText());
                info.add(jtfApMat.getText());
                info.add(jtfNick.getText());
                info.add(jtfPass.getText());
                
                op.Insertar(info);
                
                PanelMiembro pm=new PanelMiembro(foo);
                this.dispose();
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
