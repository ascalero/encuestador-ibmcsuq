/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import conex.LoginConx;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import org.jdesktop.swingx.JXCollapsiblePane;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.JXPanel;

/**
 *
 * @author Ascalero
 */
public class PanelMiembro extends JXFrame implements ActionListener{
    String[] strTemp= new String[4];
    int foo;
    private JXPanel panelContenido,panelBotones;
    private CardLayout containerStack;
    private JXCollapsiblePane panelTMie;
    private JButton butAdmon,butClient,butAdmonLogin,butEncuestado,butReg;
    private JTextArea taNombreUser;
    private JPasswordField taContra;
       
    public PanelMiembro(int lenguaje){
    foo=lenguaje;
    strTemp[0]="Selecciona el tipo de Usuario que eres";strTemp[1]="Select the type of user you are";
    strTemp[2]="Wählen Sie die Art der Benutzer Sie sind";strTemp[3]="Sélectionnez le type d'usager que vous êtes";
    this.setTitle(strTemp[foo]);
    setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
    setLocation(10,0);
    this.setResizable(true);
    setSize(640,480);
    setVisible (true);
    initComp();
    bind();
    }
    
    private void initComp(){
        
        //<editor-fold defaultstate="collapsed" desc="Inicializacion panel Botones">
        panelBotones= new JXPanel(new GridLayout(0, 2));
        panelBotones.setBounds(160,300,320,120);
        strTemp[0]="Selecciona el tipo de Usuario que eres";strTemp[1]="Select the type of user you are";
        strTemp[2]="Wählen Sie die Art der Benutzer Sie sind";strTemp[3]="Sélectionnez le type d'usager que vous êtes";
        panelBotones.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
        strTemp[0]="Administrador";strTemp[1]="Administrator";strTemp[2]="Administrator";strTemp[3]="administrateur";
        butAdmon= new JButton(strTemp[foo]);
       butAdmon.addActionListener(this);
       strTemp[0]="Encuestado";strTemp[1]="tester";strTemp[2]="Tester";strTemp[3]="testeur";
        butClient = new JButton(strTemp[foo]);
       butClient.addActionListener(this);
        panelBotones.add(butAdmon);
        panelBotones.add(butClient);
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Inicializacion panel Colapsable">
        panelContenido= new JXPanel(new BorderLayout());
        panelContenido.setBounds(10,10,600,280);
        strTemp[0]="inicio";strTemp[1]="Login";strTemp[2]="Login";strTemp[3]="Login";
        panelContenido.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
        panelTMie = new JXCollapsiblePane();
        panelTMie.setCollapsed(true);
        panelTMie.setAnimated(true);
        strTemp[0]="Bienvenido ";strTemp[1]="Welcome ";strTemp[2]="Willkommen";strTemp[3]="Accueil ";
        panelContenido.add(new JLabel(strTemp[foo], JLabel.CENTER));
        panelContenido.add(panelTMie,BorderLayout.SOUTH);
        containerStack = new CardLayout(); 
        
        panelTMie.setLayout(containerStack); 
        panelTMie.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        
        
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Inicializacion panel Login Admon">
        JPanel admon= new JPanel(new GridLayout(3, 0));
        strTemp[0]="Nombre De Usuario";strTemp[1]="Nickname";strTemp[2]="Spitzname";strTemp[3]="surnom";
        JLabel label1= new JLabel(strTemp[foo], JLabel.CENTER);
        strTemp[0]="Contraseña";strTemp[1]="Password";strTemp[2]="Password";strTemp[3]="mot de passe";
        JLabel label2= new JLabel(strTemp[foo], JLabel.CENTER);
        taNombreUser= new JTextArea();
        taContra= new JPasswordField();
         strTemp[0]="inicio";strTemp[1]="Login";strTemp[2]="Login";strTemp[3]="Login";
        butAdmonLogin= new JButton(strTemp[foo]);
        butAdmonLogin.addActionListener(this);
        strTemp[0]="Registrate";strTemp[1]="Sign Up";strTemp[2]="Registrieren";strTemp[3]="Signer";
        butReg= new JButton(strTemp[foo]);
        butReg.addActionListener(this);
        
        admon.add(label1);
        admon.add(taNombreUser);
        admon.add(label2);
        admon.add(taContra);
        admon.add(butAdmonLogin);
        admon.add(butReg);
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Inicializacion panel Login Encuestados">
        JPanel enquest= new JPanel(new GridLayout(2,1));
        strTemp[0]="Empezar Encuesta?";strTemp[1]="Start Survey?";strTemp[2]="Start Umfrage?";strTemp[3]="Début Enquête?";
        JLabel label3= new JLabel(strTemp[foo], JLabel.CENTER);
        strTemp[0]="Aceptar";strTemp[1]="OK";strTemp[2]="OK";strTemp[3]="OK";
        butEncuestado= new JButton(strTemp[foo]);
        butEncuestado.addActionListener(this);
        enquest.add(label3);
        enquest.add(butEncuestado);
        panelTMie.add(admon, "admon");
        panelTMie.add(enquest, "enq");
        //</editor-fold>
       setLayout(null);
        add(panelBotones);
        add(panelContenido);
    
    }

   
    
    private void bind() { 
         butAdmon.addActionListener(panelTMie.getActionMap().get( 
                 JXCollapsiblePane.TOGGLE_ACTION));
         butClient.addActionListener(panelTMie.getActionMap().get( 
                 JXCollapsiblePane.TOGGLE_ACTION)); 
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==butAdmon){
            containerStack.show(panelTMie.getContentPane(), "admon");
        }
        if(e.getSource()==butClient){
            containerStack.show(panelTMie.getContentPane(),"enq");
        }
        if(e.getSource()==butEncuestado){
            //this.setVisible(false);
            //FrameSurvey beta= new FrameSurvey(foo);
            RegEnc re=new RegEnc(foo);
            this.dispose();
        }
        
        if(e.getSource()==butAdmonLogin){
            if (taNombreUser.getText().equals("")){
                strTemp[0]="Introduce tu Usuario";strTemp[1]="Provide your NickName";strTemp[2]="";strTemp[3]="";
                JOptionPane.showMessageDialog(null,strTemp[foo],"MSG",JOptionPane.INFORMATION_MESSAGE);
                taNombreUser.requestFocus();
            }else{
                String temo=new String(taContra.getPassword());
                //System.out.println(""+temo);
                if (temo.equals("")){
                    strTemp[0]="Introduce tu Contraseña";strTemp[1]="Provide your Password";strTemp[2]="Bieten Sie Ihren NickName";strTemp[3]="Donnez votre Pseudo";
                    JOptionPane.showMessageDialog(null,strTemp[foo],"MSG",JOptionPane.INFORMATION_MESSAGE);
                    taContra.requestFocus();
                }else{
                    int h = new LoginConx().getLogin(taNombreUser.getText(),temo);
                    switch(h){
                        case 1:
                            strTemp[0]="Bienvenido"+taNombreUser.getText();
                            strTemp[1]="Welcome"+taNombreUser.getText();
                            strTemp[2]="Willkommen"+taNombreUser.getText();
                            strTemp[3]="Accueil"+taNombreUser.getText();
                            JOptionPane.showMessageDialog(null,strTemp[foo],"MSG",JOptionPane.INFORMATION_MESSAGE);
                            FrameAdmon b= new FrameAdmon(foo,taNombreUser.getText());
                            this.dispose();
                            break;
                        case 2:
                            strTemp[0]="Contraseña Incorrecta";
                            strTemp[1]="Wrong Password"; strTemp[2]="Falsches Passwort";strTemp[3]="Mot de passe incorrect";
                            JOptionPane.showMessageDialog(null,strTemp[foo],"Error",JOptionPane.ERROR_MESSAGE);
                            taContra.setText("");
                            break;
                        case 3:
                            strTemp[0]="El Usuario NO existe";
                            strTemp[1]="Username doesn't exist";
                            strTemp[2]="Benutzername existiert nicht";
                            strTemp[3]="Nom d'utilisateur n'existe pas";
                            JOptionPane.showMessageDialog(null,strTemp[foo],"Error",JOptionPane.ERROR_MESSAGE);
                            taNombreUser.setText("");
                            taContra.setText("");
                            break;
                        default:
                            break;
                    }
                    
                    //System.out.println("valor: "+h);
                    
                }
            }
            
            
            
        
        
        }
        if(e.getSource()==butReg){
            RegAdmin a=new RegAdmin(foo);
            this.dispose();
        }
        
    }
    
}
