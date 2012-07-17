/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;


import conex.*;
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
    ArrayList <String> pregunta= new ArrayList<String>();
    JPanel panelPreg,panelOption,panelbotones;
    JButton butNext,butReady;
    JRadioButton[] rbVal;
    ButtonGroup rbValores;
    JXLabel labPreg;
    ArrayList <String> datoEnc;
    String nomEnc;
            
    //<editor-fold defaultstate="collapsed" desc="Variables Menu">
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    JRadioButtonMenuItem rbMILang[];
    
    //</editor-fold>
    
    

    public FrameSurvey(int lang,ArrayList <String> datoEnc,String nomEnc){
    foo=lang;
    this.datoEnc=datoEnc;
    this.nomEnc=nomEnc;
    this.setTitle(this.nomEnc);
    setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
    setLocation(10,0);
    this.setResizable(true);
    setSize(720,480);
    setVisible (true);
    cargaPreguntas(foo);
    initComp();
    menuCharger();
    }
    
    public void initComp(){
    panelPreg = new JPanel();
    panelPreg.setBounds(10,10, 680,400);
    strTemp[0]="Pregunta "+cont+" de 19";strTemp[1]="Question "+cont+" of 19";
    strTemp[2]="Frage "+cont+" von 19";strTemp[3]="Question "+cont+" sur 19";
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
    strTemp[0]="Totalmente Deacuerdo";strTemp[1]="Strongly Agree";
    strTemp[2]="Trifft Uneingeschränkt Zu";strTemp[3]="Entièrement D'accord";
    JLabel mostL= new JLabel(strTemp[foo]);
    strTemp[0]="Totalmente en Desacuerdo";strTemp[1]="Strongly Desagree";
    strTemp[2]="Trifft überhaupt nicht zu";strTemp[3]="Fortement en désaccord";
    JLabel lessL= new JLabel(strTemp[foo]);
    paneAnswer.add(panelOption,BorderLayout.CENTER);
    paneAnswer.add(lessL,BorderLayout.WEST);
    paneAnswer.add(mostL,BorderLayout.EAST);
    
    
    JPanel paneBotones= new JPanel(new GridLayout(1,2));
    String temp="../ima/next.png";
    butNext= new JButton(new ImageIcon(getClass().getResource(temp)));
    butNext.addActionListener(this);
    strTemp[0]="Finalizar";strTemp[1]="Finish";strTemp[2]="Fertig stellen";strTemp[3]="Terminer";
    butReady= new JButton(strTemp[foo]);
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
                pregunta.add("1. En general, estoy satisfecho con lo facil que es utilizar el Sistema.");
                pregunta.add("2. Es sencillo de utilizar el sistema.");
                pregunta.add("3. Puedo efectivamente completar mi trabajo con el sistema.");
                pregunta.add("4. Puedo terminar mi trabajo de forma rapida usando el sistema.");
                pregunta.add("5. Soy capaz de completar de manera eficiente mi trabajo con el sistema.");
                pregunta.add("6. Me siento comodo con el sistema.");
                pregunta.add("7. Es facil aprender a utilizar este sistema.");
                pregunta.add("8. Creo que me converti productivo rapidamente con el sistema.");
                pregunta.add("9. El sistema da mensajes de error que claramente me digan como solucionar los problemas.");
                pregunta.add("10. Cada vez que cometo un error al utilizar el sistema, se puede recuperar facil y rapidamente.");
                pregunta.add("11. La informacionn (como la ayuda en linea, los mensajes en pantalla, y otra documentacion), proporcionada con el sistema es clara.");
                pregunta.add("12. Es facil encontrar la informacion que necesito.");
                pregunta.add("13. La informacion proporcionada por el sistema es facil de entender.");
                pregunta.add("14. La informacion es eficaz para ayudar a completar las tareas.");
                pregunta.add("15. La organizacion de la informacion en las pantallas del sistema esta clara.");
                pregunta.add("16. La interfaz del sistema es agradable.");
                pregunta.add("17. Me gusta usar la interfaz del sistema.");
                pregunta.add("18. Este sistema tiene todas las funciones y capacidades que espero que tenga.");
                pregunta.add("19. En general, estoy satisfecho con el sistema.");
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
            case 2:
                pregunta.add("1. Insgesamt bin ich mit, wie einfach es ist, das System verwenden zufrieden.");
                pregunta.add("2. Es ist leicht, das System zu verwenden.");
                pregunta.add("3. Ich kann meine Arbeit effektiv zu erledigen mit dem System.");
                pregunta.add("4. Ich kann meine Arbeit schnell fertig mit dem System.");
                pregunta.add("5. Ich kann meine Arbeit effizienter ausführen mit dem System.");
                pregunta.add("6. Ich fühle mich wohl mit dem System.");
                pregunta.add("7. Es ist leicht zu lernen, dieses System zu verwenden.");
                pregunta.add("8. Ich glaube, ich wurde schnell produktiv mit dem System.");
                pregunta.add("9. Das System gibt Fehlermeldungen, die klar sagen Sie mir, wie Probleme zu lösen.");
                pregunta.add("10. Jedes Mal wenn ich einen Fehler machen, wenn Sie das System einfach und schnell wiederhergestellt werden.");
                pregunta.add("11. Informacionn (wie z. B. Online-Hilfe, Display-Meldungen und sonstige Dokumentation) mit dem System zur Verfügung gestellt ist klar.");
                pregunta.add("12. Es ist einfach, die Informationen finden, ich brauche.");
                pregunta.add("13. Die Informationen, die vom System bereitgestellt ist leicht zu verstehen.");
                pregunta.add("14. Die Informationen sind wirksam bei der Aufgaben zu erledigen.");
                pregunta.add("15. Die Organisation von Informationen in den System-Bildschirme ist klar.");
                pregunta.add("16. Das System Interface ist schön.");
                pregunta.add("17. Ich mag, um das System-Schnittstelle verwenden.");
                pregunta.add("18. Dieses System verfügt über alle Funktionen und Möglichkeiten, dass ich hoffe, Sie haben.");
                pregunta.add("19. Im Allgemeinen bin ich zufrieden mit dem System.");
                break;
            default:
                pregunta.add("1. Dans l'ensemble, je suis satisfait de la façon dont il est facile d'utiliser le système.");
                pregunta.add("2. Il est facile d'utiliser le système.");
                pregunta.add("3. Je ne peux terminer mon travail de manière efficace avec le système.");
                pregunta.add("4. Je ne peux terminer mon travail rapidement en utilisant le système.");
                pregunta.add("5. Je ne peux terminer mon travail efficacement avec le système.");
                pregunta.add("6. Je me sens à l'aise avec le système.");
                pregunta.add("7. Il est facile d'apprendre à utiliser ce système.");
                pregunta.add("8. Je crois que je suis devenu rapidement productif avec le système.");
                pregunta.add("9. Le système donne des messages d'erreur que me disent clairement comment résoudre les problèmes.");
                pregunta.add("10. Chaque fois que je fais une erreur lors de l'utilisation du système peut être récupéré facilement et rapidement.");
                pregunta.add("11. Informacionn (tels que l'aide en ligne, affichage des messages, et d'autres documents) fourni avec le système est clair.");
                pregunta.add("12. Il est facile de trouver l'information nécessaire.");
                pregunta.add("13. Les informations fournies par le système est facile à comprendre.");
                pregunta.add("14. L'information est efficace pour aider à effectuer des tâches.");
                pregunta.add("15. L'organisation de l'information dans les écrans du système est clair.");
                pregunta.add("16. L'interface du système est agréable.");
                pregunta.add("17. J'aime utiliser l'interface du système.");
                pregunta.add("18. Ce système possède toutes les caractéristiques et les capacités qui je l'espère, vous avez.");
                pregunta.add("19. En général, je suis satisfait du système.");
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
                        strTemp[0]="Pregunta "+(cont+1)+" de 19";strTemp[1]="Question "+(cont+1)+" of 19";
                        strTemp[2]="Frage "+(cont+1)+" von 19";strTemp[3]="Question "+(cont+1)+" sur 19";
                        panelPreg.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
                            for(JRadioButton a:rbVal)a.setSelected(true);
                    }
                if(cont==18){
                    butNext.setEnabled(false);
                    butReady.setEnabled(true);
                
                }
            }else{
                strTemp[0]="Debes de Seleccionar una Opcion";strTemp[1]="You Must select a choise";
                strTemp[2]="Sie müssen eine Wahl";strTemp[3]="Vous devez sélectionner un choix";
                JOptionPane.showMessageDialog(null,strTemp[foo],"Error",JOptionPane.ERROR_MESSAGE);
            }
            
            for(int i=0;i<4;i++){
                if(e.getSource()==rbMILang[i]){
                    for(int j=0;j<4;j++){
                        rbMILang[j].setSelected(false);
                    }
                    rbMILang[i].setSelected(true);
                    //setIdioma(i);
            }
        }
       }
        if(e.getSource()==butReady){
            if(checaRespuesta()){
                for(int i=0;i<answer.length;i++){
                    datoEnc.add(answer[i]+"");
                }
                Comentario c=new Comentario(foo,nomEnc);
                OpBasicas op=new OpBasicas();
                LoginConx lc=new LoginConx();
                datoEnc.add(lc.getIdProy(nomEnc)+"");
                op.Insertar2(datoEnc);
                this.dispose();
            }else{
                strTemp[0]="Debes de Selecionar una Opcion";strTemp[1]="You Must select a choise";
                strTemp[2]="Sie müssen eine Wahl";strTemp[3]="Vous devez sélectionner un choix";
                JOptionPane.showMessageDialog(null,strTemp[foo],"Error",JOptionPane.ERROR_MESSAGE);
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
    

