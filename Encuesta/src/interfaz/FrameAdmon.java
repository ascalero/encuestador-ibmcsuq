/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import conex.LoginConx;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.*;

/**
 *
 * @author Ascalero
 */
@SuppressWarnings("ResultOfObjectAllocationIgnored")
public class FrameAdmon extends JXFrame implements ActionListener{
    private String strTemp[]= new String[4],User;
    LoginConx driver=new conex.LoginConx();
    private Font fuenteGrande=new Font("Arial",Font.BOLD,20);
    private JXPanel panelTareas,panelCard,panelEE,panelNE,panelSE,panelDatos;
    private CardLayout containerStack = new CardLayout();
    private JXTaskPane tareas,sesTask;
    private JXTaskPaneContainer contTask;
    private JButton butOKSurvey,butOKdel,butOKsel,butRestric;
    private JComboBox jcbSurveyDel, jcbSel;
    private JComboBox jcbSexo,jcbEsc,jcbExp;
    private Object valCombo[],valCombo2[];
    private Grafica graf;
    private JLabel labTotalEnc;
    int foo;

    private JTextField nombreEnc;
    private JTextArea descrip;
    private DefaultTableModel modeloPromedios;
    private JTable valores2;
    private DefaultTableModel modeloPromP;
    private JTable valores3;
    private JPanel todo;
    
    private AbstractAction aaNewProy;
    //variables panel Nueva encuesta
    JPanel cont1,cont2,cont3,restric;
    JLabel neTitleJL,neNombreJL,neDescripJL,neTitleJL2,neTitleJL3;
    //variables del panel de encuesta
    JPanel panelTabla2,panelTabla3;
            
    //<editor-fold defaultstate="collapsed" desc="Variables Menu">
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    JRadioButtonMenuItem rbMILang[];
    
    //</editor-fold>
    
    public FrameAdmon(int lang,String du) {
    foo=lang;
    User=du;
    strTemp[0]="Consola Administrador: Bienvenido "+User;
    strTemp[1]="Administrator Settings: Welcome "+User; strTemp[2]="Administratoreinstellungen: Willkommen";strTemp[3]="Réglages Administrateur: Bienvenue";
    this.setTitle(strTemp[foo]);
    setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
    setLocation(10,0);
    this.setResizable(false);
    setVisible (true);
    initComp();
    menuCharger();
    setIdioma(foo);
    }

    private void initComp(){
        //<editor-fold defaultstate="collapsed" desc="Inicializacion panel de Tareas">
        panelTareas = new JXPanel(new BorderLayout());
        panelTareas.setBounds(10,10, 200, 500);
        strTemp[0]="Tareas Comunes";strTemp[1]="Common Task";strTemp[2]="Gemeinsame Aufgabe";strTemp[3]="tâche commune ";
        panelTareas.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));

        contTask = new JXTaskPaneContainer();
        contTask.setLayout(new VerticalLayout(2));
        contTask.setBackground(Color.LIGHT_GRAY);

        tareas=new JXTaskPane();
        strTemp[0]="Opciones";strTemp[1]="Options";strTemp[2]="Optionen";strTemp[3]="options de";
        tareas.setTitle(strTemp[foo]);
        strTemp[0]="Crear nuevo Proyecto";strTemp[1]="Make new Project";strTemp[2]="Finde neue Projekt";strTemp[3]="Assurez nouveau projet";
        
        aaNewProy=new AbstractAction(strTemp[foo]) {
            @Override
            public void actionPerformed(ActionEvent e) {
                containerStack.show(panelCard, "Nuevo");

            }
        };
        
        
        tareas.add(aaNewProy);
        strTemp[0]="Ver Projecto";strTemp[1]="Check Project";strTemp[2]="Projekt prüfen";strTemp[3]="Vérifier le projet";
        tareas.add(new AbstractAction(strTemp[foo]) {
            @Override
            public void actionPerformed(ActionEvent e) {
                eraseDataJcb(jcbSel);
                valCombo2=getProy(User);
                if (valCombo2==null){
                strTemp[0]="No tienes Proyectos";strTemp[1]="You dont have any project";
                strTemp[2]="Sie müssen nicht jedes Projekt";
                strTemp[3]="Vous n'avez pas de projet";
                jcbSel.addItem(strTemp[0]);
                }else{
                    for(Object d:valCombo2){
                    jcbSel.addItem(d);
                    }
                }
                containerStack.show(panelCard, "Ver");
            }
        });
        strTemp[0]="Borrar Proyecto";strTemp[1]="Delete Project";strTemp[2]="Projekt löschen";strTemp[3]="supprimer le projet";
        tareas.add(new AbstractAction(strTemp[foo]) {
            @Override
            public void actionPerformed(ActionEvent e) {
                eraseDataJcb(jcbSurveyDel);
                valCombo=getProy(User);
                if (valCombo==null){
                strTemp[0]="No tienes Proyectos";strTemp[1]="You dont have any project";
                strTemp[2]="Sie müssen nicht jedes Projekt";
                strTemp[3]="Vous n'avez pas de projet";
                jcbSurveyDel.addItem(strTemp[foo]);
                }else{
                    for(Object d:valCombo){
                    jcbSurveyDel.addItem(d);
                    }
                }
                containerStack.show(panelCard, "Elimina");


            }
        });

        sesTask= new JXTaskPane();
        strTemp[0]="Opciones de Sesion";strTemp[1]="Session Options";strTemp[2]="Session Options";strTemp[3]="options de session";
        sesTask.setTitle(strTemp[0]);
        strTemp[0]="Cerrar Sesion";strTemp[1]="Logout";strTemp[2]="Abmeldung";strTemp[3]="déconnexion";
        sesTask.add(new AbstractAction(strTemp[foo]){
                @Override
                public void actionPerformed(ActionEvent e) {
                cerrarS();
                }});
        strTemp[0]="Salir";strTemp[1]="Close";strTemp[2]="schließen";strTemp[3]="fermer";
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
        
        cont1=new JPanel();
        strTemp[0]="Nuevo Projecto";strTemp[1]="New Project";strTemp[2]="neues Projekt";strTemp[3]="Nouveau projet";
        cont1.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
        cont1.setLayout(null);
        strTemp[0]="Crear Nuevo Projecto";strTemp[1]="Create New Project";strTemp[2]="Neues Projekt";strTemp[3]="Créer un projet";
        neTitleJL= new JLabel(strTemp[foo],JLabel.CENTER);
        neTitleJL.setBounds(237,50,475,100);
        neTitleJL.setFont(fuenteGrande);
        strTemp[0]="Nombre del Proyecto";strTemp[1]="Project's Name";strTemp[2]="Projekt-Name";strTemp[3]="Projet Nom";
        neNombreJL= new JLabel(strTemp[foo],JLabel.CENTER);
        neNombreJL.setBounds(118,150,237,100);
        neNombreJL.setFont(fuenteGrande);
        strTemp[0]="Descripcion";strTemp[1]="Description";strTemp[2]="Beschreibung";strTemp[3]="Description";
        neDescripJL= new JLabel(strTemp[foo],JLabel.CENTER);
        neDescripJL.setBounds(118,250,237,100);
        neDescripJL.setFont(fuenteGrande);

        nombreEnc=new JTextField(25);
        nombreEnc.setBounds(473,180,237,30);
        descrip= new JTextArea(10, 20);
        descrip.setBounds(473,280,237,80);
        descrip.setWrapStyleWord(true);
        descrip.setLineWrap(true);
        descrip.setAutoscrolls(true);
        strTemp[0]="Aceptar";strTemp[1]="Ok";strTemp[2]="Ok";strTemp[3]="Ok";
        butOKSurvey= new JButton(strTemp[foo]);
        butOKSurvey.addActionListener(this);
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
        cont2= new JPanel();
        cont2.setLayout(null);
        strTemp[0]="Borrar Proyecto";strTemp[1]="Delete Project";strTemp[2]="Projekt löschen";strTemp[3]="supprimer le projet";
        cont2.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
        strTemp[0]="Selecione projecto a eliminar";strTemp[1]="Select Project to delete";strTemp[2]="Wählen Sie Projekt zu löschen";strTemp[3]="Sélectionner le projet de supprimer";
        neTitleJL2= new JLabel(strTemp[foo],JLabel.CENTER);
        neTitleJL2.setBounds(237,50,475,100);
        neTitleJL2.setFont(fuenteGrande);
        jcbSurveyDel= new JComboBox();
        jcbSurveyDel.setBounds(237, 250, 475, 40);
        jcbSurveyDel.setFont(fuenteGrande);
        //jcbSurvey.setModel(null);
        strTemp[0]="Aceptar";strTemp[1]="OK";strTemp[2]="Ok";strTemp[3]="Ok";
        butOKdel= new JButton(strTemp[foo]);
        butOKdel.setBounds(355,380,200,100);
        butOKdel.addActionListener(this);
        cont2.add(neTitleJL2);
        cont2.add(jcbSurveyDel);
        cont2.add(butOKdel);
        panelEE.add(cont2,BorderLayout.CENTER);
         //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Inicializacion panel Selecionar Encuesta">
        panelSE= new JXPanel(new BorderLayout());
        cont3= new JPanel();
        cont3.setLayout(null);
        strTemp[0]="Revisar Datos de la Encuesta";strTemp[1]="Check survey's Info";strTemp[2]="Überprüfen Umfragen Info";strTemp[3]="Vérifiez Infos enquêtes";
        cont3.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
        strTemp[0]="Seleccionar el Proyecto a revisar";strTemp[1]="Select projects to check";strTemp[2]="Auswahl der Projekte zu überprüfen,";strTemp[3]="Sélectionner les projets à vérifier";
        neTitleJL3= new JLabel(strTemp[foo],JLabel.CENTER);
        neTitleJL3.setBounds(237,50,475,100);
        neTitleJL3.setFont(fuenteGrande);
        jcbSel= new JComboBox();
        jcbSel.setBounds(237, 250, 475, 40);
        jcbSel.setFont(fuenteGrande);
        //jcbSurvey.setModel(null);
        strTemp[0]="Aceptar";strTemp[1]="OK";strTemp[2]="Ok";strTemp[3]="Ok";
        butOKsel= new JButton(strTemp[foo]);
        butOKsel.setBounds(355,380,200,100);
        butOKsel.addActionListener(this);
        cont3.add(neTitleJL3);
        cont3.add(jcbSel);
        cont3.add(butOKsel);

        panelSE.add(cont3,BorderLayout.CENTER);
        //</editor-fold >
        //<editor-fold defaultstate="collapsed" desc="Inicializacion Panel Ver Encuestas">
        panelDatos= new JXPanel(new BorderLayout());
        todo = new JPanel();
        todo.setLayout(null);
        strTemp[0]="Datos de Encuesta";strTemp[1]="Survey's data";strTemp[2]="Umfragedaten";strTemp[3]="Les données d'enquête";
        todo.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
        //<editor-fold defaultstate="collapsed" desc="PanelGrafica">
        double max[]={6.73,5.98,6.66,7.54};
        double min[]={4.02,3.07,3.9,5.12};
        double prom[]={5.38,4.52,5.28,6.33};
        graf= new Grafica("1.jpg", max, min, prom,foo);
        graf.setBounds(335, 20, graf.getWidth(), graf.getHeight());
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Inicializacion Panel Tabla Promedios">
        panelTabla2 = new JPanel();
        panelTabla2.setLayout(new FlowLayout(FlowLayout.LEFT));
        strTemp[0]="Promedios";strTemp[1]="Averages";strTemp[2]="Durchschnitts-";strTemp[3]="Moyennes";
	panelTabla2.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
	panelTabla2.setBounds(15,20,315,250);
	modeloPromedios = new DefaultTableModel();
	valores2 = new JTable(modeloPromedios);
        valores2.setPreferredScrollableViewportSize(new Dimension(280, 200));
		    valores2.setAutoscrolls(true);
		    JScrollPane guarda2 = new JScrollPane(valores2);
		    guarda2.setAutoscrolls(true);
		    panelTabla2.add(guarda2);
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Inicializacion Panel Tabla Promedios de promedios">
        panelTabla3 = new JPanel();
        panelTabla3.setLayout(new FlowLayout(FlowLayout.LEFT));
        strTemp[0]="Promedios por Pregunta";strTemp[1]="Averages per Question";strTemp[2]="Durchschnittswerte pro Frage";strTemp[3]="Moyennes par Question";
	panelTabla3.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
	panelTabla3.setBounds(335,370,500,125);
	modeloPromP = new DefaultTableModel();
	valores3 = new JTable(modeloPromP);
        valores3.setPreferredScrollableViewportSize(new Dimension(475,75));
		    valores3.setAutoscrolls(true);
		    JScrollPane guarda3 = new JScrollPane(valores3);
		    guarda3.setAutoscrolls(true);
		    panelTabla3.add(guarda3);

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Inicializacion Panel Restricciones">
        restric= new JPanel(new VerticalLayout(4));
        restric.setBounds(15, 270, 315, 225);
        strTemp[0]="Restricciones";strTemp[1]="Restrictions";strTemp[2]="Einschränkungen";strTemp[3]="Restrictions";
        restric.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
        jcbSexo= new JComboBox();
        setSexo(jcbSexo);
        jcbEsc= new JComboBox();
        setEscolaridad(jcbEsc);
        jcbExp= new JComboBox();
        setExperiancia(jcbExp);
        strTemp[0]="Agregar Cambios";strTemp[1]="add changes";strTemp[2]="Änderungen hinzufügen";strTemp[3]="ajouter les changements";
        butRestric= new JButton(strTemp[foo]);
        butRestric.addActionListener(this);
        jcbEsc.setSelectedIndex(3);
        jcbExp.setSelectedIndex(3);
        jcbSexo.setSelectedIndex(3);
        labTotalEnc= new JLabel("",JLabel.CENTER);
        restric.add(jcbSexo);
        restric.add(jcbExp);
        restric.add(jcbEsc);
        restric.add(butRestric);
        restric.add(labTotalEnc);
        //</editor-fold>
        
        
        
        todo.add(restric);
        todo.add(graf);
        todo.add(panelTabla2);
        todo.add(panelTabla3);
        panelDatos.add(todo,BorderLayout.CENTER);
        //</editor-fold>
        
        
        
        
        panelCard= new JXPanel(containerStack);
        panelCard.setBounds(230, 10, 1000 , 640);
        panelCard.add(panelNE,"Nuevo");
        panelCard.add(panelEE,"Elimina");
        panelCard.add(panelSE,"Ver");
        panelCard.add(panelDatos,"Datos");
        setLayout(null);
        setSize(1,1);
        setSize(1250,730);
        add(panelTareas);
        add(panelCard);
        }
    //<editor-fold defaultstate="collapsed" desc="Metodo Settitles PromP">
    public void  setTitles(DefaultTableModel c){
        Object[] a;		
                        switch(foo){
                            case 0:
                                a = new Object[5];
				a[0]=" ";
				a[1]="Uso del Sistema";
				a[2]="Calidad Informacion";
                                a[3]="Calidad Interface";
                                a[4]="General";
                                c.setColumnIdentifiers(a);
                            break;
                            case 1:
                                a = new Object[5];
				a[0]=" ";
				a[1]="Usability";
				a[2]="Information Dialog";
                                a[3]="Interface";
                                a[4]="General";
                                c.setColumnIdentifiers(a);
                            break;
                            case 2:
                                a = new Object[5];
				a[0]=" ";
				a[1]="Nutzbarkeit";
				a[2]="Information Dialog";
                                a[3]="Schnittstelle";
                                a[4]="allgemein";
                                c.setColumnIdentifiers(a);
                            break;
                            case 3:
                                a = new Object[5];
				a[0]=" ";
				a[1]="Usabilité";
				a[2]="de dialogue de l'information";
                                a[3]="Infinterface";
                                a[4]="général";
                                c.setColumnIdentifiers(a);
                            break;
                        
                        }
    }//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Metodo Settitles Promedios">
    public void  setTitles2(DefaultTableModel c){
        Object[] a;                        
                switch(foo){
                    case 0:
                    a = new Object[3];
                            a[0]="No.Preg";
                            a[1]="Promedio";
                            a[2]="DesvMedi";
                    c.setColumnIdentifiers(a);
                        break;
                    case 1:
                    a = new Object[3];
                            a[0]="Question #";
                            a[1]="average";
                            a[2]="standard deviation";
                    c.setColumnIdentifiers(a);
                        break;
                    case 2:
                    a = new Object[3];
                            a[0]="Frage Nr.";
                            a[1]="Durchschnitt";
                            a[2]="Standardabweichung";
                    c.setColumnIdentifiers(a);
                        break;
                    case 3:
                    a = new Object[3];
                            a[0]="question n °";
                            a[1]="moyenne";
                            a[2]="écart-type";
                    c.setColumnIdentifiers(a);
                        break;
                        
                }
    }//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Metodo Limpia Tabla">
public void limpiatabla(DefaultTableModel modeloT){
	int nr = modeloT.getRowCount(),i=0;
          try{
	     for( i=nr-1 ; i >= 0; i--) {
                 modeloT.removeRow(i);
             }
             }catch(Exception e){}
}//</editor-fold>

@Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==butOKsel){
                inicializaDatos(jcbSel.getSelectedItem().toString(),"");
            }
            if(e.getSource()==butOKSurvey){
                crearProy();
            }
            if(e.getSource()==butOKdel){
                borraProy();
            }
            if(e.getSource()==butRestric){
                setRestric();
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
    //<editor-fold defaultstate="collapsed" desc="Inicializa Datos">
    public boolean inicializaDatos(String nameSur,String Atrib){
                limpiatabla(modeloPromedios);
                limpiatabla(modeloPromP);
                setTitles(modeloPromP);
                setTitles2(modeloPromedios);
                int a[][]=driver.rangos(driver.getIdProy(nameSur),Atrib);
                if(a==null){
                    strTemp[0]="Total Encuestados: 0";strTemp[1]="Surveyed : 0";strTemp[2]="befragten: 0";strTemp[3]="Interrogés :0";
                    labTotalEnc.setText(strTemp[foo]);
                    strTemp[0]="No ahi datos que Mostrar";strTemp[1]="";strTemp[2]="";strTemp[3]="";
                    JOptionPane.showMessageDialog(null,strTemp[foo],"MSG",JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                containerStack.show(panelCard,"Datos");
                strTemp[0]="Total Encuestados: ";strTemp[1]="Surveyed : ";strTemp[2]="befragten: ";strTemp[3]="Interrogés: ";
                labTotalEnc.setText(strTemp[foo]+""+a.length);
                algoritmos.DesviacionEstandar h=new algoritmos.DesviacionEstandar();
                double[][] promP = h.Calcula(a);
                graf.setData(promP[0], promP[1], promP[2]);
                        Object[] o1=new Object[promP[0].length+1];
                            o1[0]="Max";
                        for(int i=0;i<promP[0].length;i++){
                            o1[i+1]=promP[0][i];
                        }
                        modeloPromP.addRow(o1);
                        o1=new Object[promP[0].length+1];
                            o1[0]="Min";
                        for(int i=0;i<promP[0].length;i++){
                            o1[i+1]=promP[1][i];
                        }
                        modeloPromP.addRow(o1);
                        o1=new Object[promP[0].length+1];
                            strTemp[0]="Promedios";strTemp[1]="Average";strTemp[2]="Durchschnitt";strTemp[3]="Moyenne";
                            o1[0]=strTemp[foo];
                        for(int i=0;i<promP[0].length;i++){
                            o1[i+1]=promP[2][i];
                        }
                        modeloPromP.addRow(o1);


                    double[] promedios = h.getPromedios();
                    double[] vars = h.getVars();
                    for(int i=0;i<vars.length;i++){
                        o1=new Object[3];
                            o1[0]="Q"+(i+1);
                            o1[1]=promedios[i];
                            o1[2]=vars[i];
                            modeloPromedios.addRow(o1);
                    }
    return true;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Metodo limpia JCB">
    public boolean borraProy(){
                driver.delProy(jcbSurveyDel.getSelectedItem().toString());
                eraseDataJcb(jcbSurveyDel);
                eraseDataJcb(jcbSel);
                valCombo=getProy(User);
                if (valCombo==null){
                strTemp[0]="No tienes Proyectos";strTemp[1]="You dont have any project";
                strTemp[2]="Sie müssen nicht jedes Projekt";
                strTemp[3]="Vous n'avez pas de projet";
                jcbSurveyDel.addItem(strTemp[foo]);
                jcbSel.addItem(strTemp[foo]);
                }else{
                    for(Object d:valCombo){
                    jcbSurveyDel.addItem(d);
                    jcbSel.addItem(d);
                    }
                    return true;
                }
            return false;
    }
    public int crearProy(){
        if (nombreEnc.getText().equals("")){
            nombreEnc.requestFocus();
                strTemp[0]="Falto Nombre";strTemp[1]="Miss Name";strTemp[2]="Fräulein Name";strTemp[3]="Mlle Nom";
            JOptionPane.showMessageDialog(null,strTemp[foo],"MSG",JOptionPane.INFORMATION_MESSAGE);
            return 1;
        }
        if (descrip.getText().equals("")){
            descrip.requestFocus();
            strTemp[0]="falta descripcion";strTemp[1]="Description missed";strTemp[2]="Beschreibung verpasst";strTemp[3]="Description de manquer";
            JOptionPane.showMessageDialog(null,strTemp[foo],"MSG",JOptionPane.INFORMATION_MESSAGE);
            return 1;
        }
        driver.NovoPro(nombreEnc.getText(), descrip.getText(), User);
        nombreEnc.setText("");
        descrip.setText("");
    return 0;
    }
    //</editor-fold>
    
    private void setRestric(){
        String atributos="";
        int anw=jcbEsc.getSelectedIndex();
        if(anw!=3) atributos+= " and Escolaridad= \""+anw+"\"";
        anw=jcbSexo.getSelectedIndex();
        if(anw!=3) atributos+= " and Sexo = \""+anw+"\"";
        anw=jcbExp.getSelectedIndex();
        if(anw!=3) atributos+= " and Experiencia = \""+anw+"\"";
        System.out.println(" attrib "+atributos);
        try {
            inicializaDatos(jcbSel.getSelectedItem().toString(),atributos);
        } catch (NullPointerException e) {
            
        }
        
    }
    
    private void cerrarS(){
        new PanelMiembro(foo);
        this.dispose();
    }
    
    private void salir(){
        new IntroFrame();
        this.dispose();
    }
    
    private void eraseDataJcb(JComboBox d){
        d.removeAllItems();
    }
    private Object[] getProy(String user){
        return new conex.LoginConx().getproy(user);
    }
    //<editor-fold defaultstate="collapsed" desc="Inicializa Contenido JCBRestricciones">
    private void setEscolaridad(JComboBox jcb){
        eraseDataJcb(jcb);
        Object[] sex=new Object[4];
        
        switch(foo){
            case 0 :sex[0]="Sin Estudios";sex[1]="Peparatoria";sex[2]="Superior";sex[3]="Sin Delimitar Escolaridad";break;
            case 1 :sex[0]="without studies";sex[1]="High School";sex[2]="University";sex[3]="level of education";break;
            case 2 :sex[0]="ohne Studium";sex[1]="Mittelschule";sex[2]="Hochschule";sex[3]="Bildungsniveau";break;
            case 3 :sex[0]="sans que des études";sex[1]="Lycée";sex[2]="université";sex[3]="niveau de l'éducation";break;
            default :sex[0]="";sex[1]="";sex[2]="";break;
        }
        for(Object a:sex){
            jcb.addItem(a);
        }
    }
    private void setExperiancia(JComboBox jcb){
        eraseDataJcb(jcb);
        Object[] sex=new Object[4];
        switch(foo){
            case 0 :sex[0]="Poca";sex[1]="Regular";sex[2]="Mucha";sex[3]="Sin Delimitar Experiencia";break;
            case 1 :sex[0]="few";sex[1]="Regular";sex[2]="Many";sex[3]="No Anchor Experience";break;
            case 2 :sex[0]="peu";sex[1]="regelmäßig";sex[2]="viele";sex[3]="Kein Anchor Experience";break;
            case 3 :sex[0]="wenige";sex[1]="normal";sex[2]="beaucoup";sex[3]="Aucune expérience d'ancrage";break;
            default :sex[0]="";sex[1]="";sex[2]="";sex[3]="";break;
        }
        for(Object a:sex){
            jcb.addItem(a);
        }
    }
    private void setSexo(JComboBox jcb){
        eraseDataJcb(jcb);
        Object[] sex=new Object[4];
        
        switch(foo){
            
            case 0 :sex[0]="Hombre";sex[1]="Mujer";sex[2]="Otros";sex[3]="Sin Delimitar Sexo";break;
            case 1 :sex[0]="Man";sex[1]="Woman";sex[2]="Others";sex[3]="Gender";break;
            case 2 :sex[0]="Mann";sex[1]="Frauen";sex[2]="andere";sex[3]="Geschlecht";break;
            case 3 :sex[0]="homme";sex[1]="femmes";sex[2]="Geschlecht";sex[3]="d'autres";break;
            default :sex[0]="";sex[1]="";sex[2]="";sex[3]="";break;
        }
        for(Object a:sex){
            jcb.addItem(a);
        }
        
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Cambio Idioma Actions Panel">
    private void resetActions(){
        tareas.removeAll();
        sesTask.removeAll();
    strTemp[0]="Crear nuevo Proyecto";strTemp[1]="Make new Project";strTemp[2]="Finde neue Projekt";strTemp[3]="Assurez nouveau projet";
        
        aaNewProy=new AbstractAction(strTemp[foo]) {
            @Override
            public void actionPerformed(ActionEvent e) {
                containerStack.show(panelCard, "Nuevo");

            }
        };
       tareas.add(aaNewProy);
       
       strTemp[0]="Ver Projecto";strTemp[1]="Check Project";strTemp[2]="Projekt prüfen";strTemp[3]="Vérifier le projet";
        tareas.add(new AbstractAction(strTemp[foo]) {
            @Override
            public void actionPerformed(ActionEvent e) {
                eraseDataJcb(jcbSel);
                valCombo2=getProy(User);
                if (valCombo2==null){
                strTemp[0]="No tienes Proyectos";strTemp[1]="You dont have any project";
                strTemp[2]="Sie müssen nicht jedes Projekt";
                strTemp[3]="Vous n'avez pas de projet";
                jcbSel.addItem(strTemp[0]);
                }else{
                    for(Object d:valCombo2){
                    jcbSel.addItem(d);
                    }
                }
                containerStack.show(panelCard, "Ver");
            }
        });
        strTemp[0]="Borrar Proyecto";strTemp[1]="Delete Project";strTemp[2]="Projekt löschen";strTemp[3]="supprimer le projet";
        tareas.add(new AbstractAction(strTemp[foo]) {
            @Override
            public void actionPerformed(ActionEvent e) {
                eraseDataJcb(jcbSurveyDel);
                valCombo=getProy(User);
                if (valCombo==null){
                strTemp[0]="No tienes Proyectos";strTemp[1]="You dont have any project";
                strTemp[2]="Sie müssen nicht jedes Projekt";
                strTemp[3]="Vous n'avez pas de projet";
                jcbSurveyDel.addItem(strTemp[foo]);
                }else{
                    for(Object d:valCombo){
                    jcbSurveyDel.addItem(d);
                    }
                }
                containerStack.show(panelCard, "Elimina");


            }
        });
        strTemp[0]="Cerrar Sesion";strTemp[1]="Logout";strTemp[2]="Abmeldung";strTemp[3]="déconnexion";
        sesTask.add(new AbstractAction(strTemp[foo]){
                @Override
                public void actionPerformed(ActionEvent e) {
                cerrarS();
                }});
        strTemp[0]="Salir";strTemp[1]="Close";strTemp[2]="schließen";strTemp[3]="fermer";
        sesTask.add(new AbstractAction(strTemp[foo]){
                @Override
                public void actionPerformed(ActionEvent e) {
                salir();
                }});
   }
    //</editor-fold>
    
    private void setIdioma(int foobar){
    this.foo=foobar;
    
    strTemp[0]="Consola Administrador: Bienvenido "+User;
    strTemp[1]="Administrator Settings: Welcome "+User; strTemp[2]="Administratoreinstellungen: Willkommen";strTemp[3]="Réglages Administrateur: Bienvenue";
    this.setTitle(strTemp[foo]);
    
    strTemp[0]="Tareas Comunes";strTemp[1]="Common Task";strTemp[2]="Gemeinsame Aufgabe";strTemp[3]="tâche commune ";
    panelTareas.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
    
    strTemp[0]="Opciones";strTemp[1]="Options";strTemp[2]="Optionen";strTemp[3]="options de";
    tareas.setTitle(strTemp[foo]);
    strTemp[0]="Opciones de Sesion";strTemp[1]="Session Options";strTemp[2]="Session Options";strTemp[3]="options de session";
    sesTask.setTitle(strTemp[0]);
    resetActions();
    strTemp[0]="Nuevo Projecto";strTemp[1]="New Project";strTemp[2]="neues Projekt";strTemp[3]="Nouveau projet";
    cont1.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
    strTemp[0]="Nombre del Proyecto";strTemp[1]="Project's Name";strTemp[2]="Projekt-Name";strTemp[3]="Projet Nom";
    neNombreJL.setText(strTemp[foo]);
    strTemp[0]="Crear Nuevo Projecto";strTemp[1]="Create New Project";strTemp[2]="Neues Projekt";strTemp[3]="Créer un projet";
     neTitleJL.setText(strTemp[foo]);
     
    //PANEÑ BORRA PROYECTO
     strTemp[0]="Borrar Proyecto";strTemp[1]="Delete Project";strTemp[2]="Projekt löschen";strTemp[3]="supprimer le projet";
     cont2.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
     strTemp[0]="Selecione projecto a eliminar";strTemp[1]="Select Project to delete";strTemp[2]="Wählen Sie Projekt zu löschen";strTemp[3]="Sélectionner le projet de supprimer";
     neTitleJL2.setText(strTemp[foo]);
     strTemp[0]="Aceptar";strTemp[1]="OK";strTemp[2]="Ok";strTemp[3]="Ok";
     butOKdel.setText(strTemp[foo]);
     //panel datos de encuenesta
     strTemp[0]="Revisar Datos de la Encuesta";strTemp[1]="Check survey's Info";strTemp[2]="Überprüfen Umfragen Info";strTemp[3]="Vérifiez Infos enquêtes";
     cont3.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
     strTemp[0]="Seleccionar el Proyecto a revisar";strTemp[1]="Select projects to check";strTemp[2]="Auswahl der Projekte zu überprüfen,";strTemp[3]="Sélectionner les projets à vérifier";
     neTitleJL3.setText(strTemp[foo]);
     //panel ver encuestas
     strTemp[0]="Datos de Encuesta";strTemp[1]="Survey's data";strTemp[2]="Umfragedaten";strTemp[3]="Les données d'enquête";
     todo.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
     strTemp[0]="Promedios";strTemp[1]="Averages";strTemp[2]="Durchschnitts-";strTemp[3]="Moyennes";
     panelTabla2.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
    
     strTemp[0]="Promedios por Pregunta";strTemp[1]="Averages per Question";strTemp[2]="Durchschnittswerte pro Frage";strTemp[3]="Moyennes par Question";
     panelTabla3.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
     strTemp[0]="Restricciones";strTemp[1]="Restrictions";strTemp[2]="Einschränkungen";strTemp[3]="Restrictions";
     restric.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
     strTemp[0]="Agregar Cambios";strTemp[1]="add changes";strTemp[2]="Änderungen hinzufügen";strTemp[3]="ajouter les changements";
     butRestric.setText(strTemp[foo]);
     int bar = jcbSexo.getSelectedIndex();
     setSexo(jcbSexo);
     jcbSexo.setSelectedIndex(bar);
     bar = jcbExp.getSelectedIndex();
     setExperiancia(jcbExp);
     jcbExp.setSelectedIndex(bar);
     bar = jcbEsc.getSelectedIndex();
     setEscolaridad(jcbEsc);
     jcbEsc.setSelectedIndex(bar);
     setRestric();
     graf.setIdioma(foo);
     
     //idioma en el menu
     strTemp[0]="Idioma";strTemp[1]="Language";strTemp[2]="Sprache";strTemp[3]="langue";
     menu.setText(strTemp[foo]);
     strTemp[0]="Selecciona tu idioma";strTemp[1]="Select your language";strTemp[2]="Wählen Sie Ihre Sprache";strTemp[3]="Choisissez votre langue";
     menuItem.setText(strTemp[foo]);
        
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


