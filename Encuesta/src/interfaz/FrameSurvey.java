/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import org.jdesktop.swingx.JXLabel;

/**
 *
 * @author Ascalero
 */
public class FrameSurvey extends JFrame implements ActionListener{
    int foo,cont,answer[]=new int[19];
    String strTemp[]= new String[4];
    ArrayList <String> pregunta= new ArrayList<>();
    JPanel panelPreg,panelOption,panelbotones;
    JButton butNext,butReady;
    JRadioButton[] rbVal;
    ButtonGroup rbValores;
    JXLabel labPreg;
    

    public FrameSurvey(int lang/*,ArrayList <String> datoEnc,String nameEncuesta*/){
    foo=lang;
    strTemp[0]="Encuesta X";strTemp[1]="SurveyX";strTemp[2]="";strTemp[3]="";
    this.setTitle(strTemp[foo]);
    setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
    setLocation(10,0);
    this.setResizable(true);
    setSize(720,480);
    setVisible (true);
    cargaPreguntas(foo);
    initComp();
    }
    
    public void initComp(){
    panelPreg = new JPanel();
    panelPreg.setBounds(10,10, 680,400);
    strTemp[0]="Pregunta "+cont+" de 19";strTemp[1]="Question "+cont+" of 19";strTemp[2]="";strTemp[3]="";
    panelPreg.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
    panelPreg.setLayout(new GridLayout(3,1));
    labPreg= new JXLabel(pregunta.get(cont),JLabel.CENTER);
    labPreg.setMaxLineSpan(500);
    labPreg.setLineWrap(true);
    
    panelPreg.add(labPreg);
    
    rbValores= new ButtonGroup();
    rbVal = new JRadioButton[8];
    
    JPanel paneAnswer= new JPanel(new BorderLayout());
    panelOption= new JPanel(new GridLayout(1,0));
    for(int i=0;i<8;i++){
        rbVal[i]= new JRadioButton((""+(i+1)));
        rbValores.add(rbVal[i]);
        rbVal[i].setSelected(false);
        if(i==7)continue;
        panelOption.add(rbVal[i]);
        
    }
    //rbVal[7].setVisible(false);
    strTemp[0]="Totalmente Deacuerdo";strTemp[1]="Strongly Agree";strTemp[2]="";strTemp[3]="";
    JLabel mostL= new JLabel(strTemp[foo]);
    strTemp[0]="Totalmente en Desacuerdo";strTemp[1]="Strongly Desagree";strTemp[2]="";strTemp[3]="";
    JLabel lessL= new JLabel(strTemp[foo]);
    paneAnswer.add(panelOption,BorderLayout.CENTER);
    paneAnswer.add(lessL,BorderLayout.WEST);
    paneAnswer.add(mostL,BorderLayout.EAST);
    
    
    JPanel paneBotones= new JPanel(new GridLayout(1,2));
    String temp="../ima/next"+foo+".png";
    butNext= new JButton(new ImageIcon(getClass().getResource(temp)));
    butNext.addActionListener(this);
    butReady= new JButton("Finalizar");
    butReady.addActionListener(this);
    butReady.setEnabled(false);
    paneBotones.add(butNext);
    paneBotones.add(butReady);
    
    panelPreg.add(paneAnswer);
    panelPreg.add(paneBotones);
    setLayout(null);
    add(panelPreg);
   
    
    
    }
    
    public void cargaPreguntas(int foo){
        switch(foo){
            case 0:
                pregunta.add("1. En general, estoy satisfecho con lo facil que es utilizar el Sistema");
                pregunta.add("2. Es sencillo de utilizar el sistema ");
                pregunta.add("3. Puedo efectivamente completar mi trabajo con el sistema ");
                pregunta.add("4. Puedo terminar mi trabajo de forma rapida usando el sistema *");
                pregunta.add("5. Soy capaz de completar de manera eficiente mi trabajo con el sistema ");
                pregunta.add("6. Me siento comodo con el sistema ");
                pregunta.add("7. Es facil aprender a utilizar este sistema");
                pregunta.add("8. Creo que me converti productivo rapidamente con el sistema");
                pregunta.add("9. El sistema da mensajes de error que claramente me digan como solucionar los problemas ");
                pregunta.add("10. Cada vez que cometo un error al utilizar el sistema, se puede recuperar facil y rapidamente");
                pregunta.add("11. La informacionn (como la ayuda en línea, los mensajes en pantalla, y otra documentación), proporcionada con el sistema es clara");
                pregunta.add("12. Es fácil encontrar la información que necesito");
                pregunta.add("13. La información proporcionada por el sistema es fácil de entender");
                pregunta.add("14. La información es eficaz para ayudar a completar las tareas");
                pregunta.add("15. La organización de la información en las pantallas del sistema está clara");
                pregunta.add("16. La interfaz del sistema es agradable");
                pregunta.add("17. Me gusta usar la interfaz del sistema");
                pregunta.add("18. Este sistema tiene todas las funciones y capacidades que espero que tenga");
                pregunta.add("19. En general, estoy satisfecho con el sistema");
                break;
            case 1:
                pregunta.add("1. Overall, I am satisfied with how easy it is to use this system.");
                pregunta.add("2. It was simple to use this system.");
                pregunta.add("3. I could effectively complete the tasks and scenarios using this system.");
                pregunta.add("4. I was able to complete the tasks and scenarios quickly using this system.");
                pregunta.add("5. I was able to efficiently complete the tasks and scenarios using this system.");
                pregunta.add("6. I felt comfortable using this system.");
                pregunta.add("7. It was easy to learn to use this system.");
                pregunta.add("8. I believe I could become productive quickly using this system.");
                pregunta.add("9. The system gave error messages that clearly told me how to fix problems.");
                pregunta.add("10. Whenever I made a mistake using the system, I could recover easily and quickly.");
                pregunta.add("11. The information (such as on-line help, on-screen messages and other documentation)provided with this system was clear.");
                pregunta.add("12. It was easy to find the information I needed.");
                pregunta.add("13. The information provided for the system was easy to understand.");
                pregunta.add("14. The information was effective in helping me complete the tasks and scenarios.");
                pregunta.add("15. The organization of information on the system screens was clear.Note: The interface includes those items that you use to interact with thesystem. For example, some components of the interface are thekeyboard, the mouse, the screens (including their use of graphics andlanguage).");
                pregunta.add("16. The interface of this system was pleasant.");
                pregunta.add("17. I liked using the interface of this system.");
                pregunta.add("18. This system has all the functions and capabilities I expect it to have.");
                pregunta.add("19. Overall, I am satisfied with this system.");
                
                break;
            default:
                break;
        }
        
    }
    
    private boolean checaRespuesta(){
        for(int i=0;i<7;i++){
            if(rbVal[i].isSelected()){
            answer[cont]=i+1;
            return true;
            }        
        }
    return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==butNext){
            if(checaRespuesta()){   
            cont++;
                    if(cont<=18){
                        labPreg.setText(pregunta.get(cont));
                        strTemp[0]="Pregunta "+(cont+1)+" de 19";strTemp[1]="Question "+(cont+1)+" of 19";strTemp[2]="";strTemp[3]="";
                        panelPreg.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
                            for(JRadioButton a:rbVal)a.setSelected(true);
                    }
                if(cont==18){
                    butNext.setEnabled(false);
                    butReady.setEnabled(true);
                
                }
            }else{
                strTemp[0]="Debes de Selecionar una Opcion";strTemp[1]="You Must select a choise";strTemp[2]="";strTemp[3]="";
                JOptionPane.showMessageDialog(null,strTemp[foo],"Error",JOptionPane.ERROR_MESSAGE);
            }
       }
        if(e.getSource()==butReady){
            if(checaRespuesta()){
                //lanza validador en BD
            }else{
                strTemp[0]="Debes de Selecionar una Opcion";strTemp[1]="You Must select a choise";strTemp[2]="";strTemp[3]="";
                JOptionPane.showMessageDialog(null,strTemp[foo],"Error",JOptionPane.ERROR_MESSAGE);
            }
            
            
        }
    }
    
   
    
    }
    

