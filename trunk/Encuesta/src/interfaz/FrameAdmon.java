/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import conex.LoginConx;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.*;
import sun.awt.HorizBagLayout;

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

    public FrameAdmon(int lang,String du) {
    foo=lang;
    User=du;
    strTemp[0]="Consola Administrador: Bienvenido "+User;
    strTemp[1]="Administrator Settings: Welcome "+User; strTemp[2]="";strTemp[3]="";
    this.setTitle(strTemp[foo]);
    setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
    setLocation(10,0);
    this.setResizable(false);
    setVisible (true);
    initComp();
    }

    private void initComp(){
        //<editor-fold defaultstate="collapsed" desc="Inicializacion panel de Tareas">
        panelTareas = new JXPanel(new BorderLayout());
        panelTareas.setBounds(10,10, 200, 500);
        strTemp[0]="Tareas Comunes";strTemp[1]="Common Task";strTemp[2]="";strTemp[3]="";
        panelTareas.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));

        contTask = new JXTaskPaneContainer();
        contTask.setLayout(new VerticalLayout(2));
        contTask.setBackground(Color.LIGHT_GRAY);

        tareas=new JXTaskPane();
        strTemp[0]="Opciones";strTemp[1]="Options";strTemp[2]="";strTemp[3]="";
        tareas.setTitle(strTemp[foo]);
        strTemp[0]="Crear nuevo Proyecto";strTemp[1]="Make new Project";strTemp[2]="";strTemp[3]="";
        tareas.add(new AbstractAction(strTemp[foo]) {
            @Override
            public void actionPerformed(ActionEvent e) {
                containerStack.show(panelCard, "Nuevo");

            }
        });
        strTemp[0]="Ver Projecto";strTemp[1]="Check Project";strTemp[2]="";strTemp[3]="";
        tareas.add(new AbstractAction(strTemp[foo]) {
            @Override
            public void actionPerformed(ActionEvent e) {
                eraseDataJcb(jcbSel);
                valCombo2=getProy(User);
                if (valCombo2==null){
                strTemp[0]="No tienes Proyectos";strTemp[1]="You dont have any project";strTemp[2]="";strTemp[3]="";
                jcbSel.addItem(strTemp[0]);
                }else{
                    for(Object d:valCombo2){
                    jcbSel.addItem(d);
                    }
                }
                containerStack.show(panelCard, "Ver");
            }
        });
        strTemp[0]="Borrar Proyecto";strTemp[1]="Delete Project";strTemp[2]="";strTemp[3]="";
        tareas.add(new AbstractAction(strTemp[foo]) {
            @Override
            public void actionPerformed(ActionEvent e) {
                eraseDataJcb(jcbSurveyDel);
                valCombo=getProy(User);
                if (valCombo==null){
                strTemp[0]="No tienes Proyectos";strTemp[1]="You dont have any project";strTemp[2]="";strTemp[3]="";
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
        strTemp[0]="Opciones de Sesion";strTemp[1]="Session Options";strTemp[2]="";strTemp[3]="";
        sesTask.setTitle(strTemp[0]);
        strTemp[0]="Cerrar Sesion";strTemp[1]="Logout";strTemp[2]="";strTemp[3]="";
        sesTask.add(new AbstractAction(strTemp[foo]){
                @Override
                public void actionPerformed(ActionEvent e) {
                cerrarS();
                }});
        strTemp[0]="Salir";strTemp[1]="Close";strTemp[2]="";strTemp[3]="";
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

        JPanel cont1=new JPanel();
        strTemp[0]="Nuevo Projecto";strTemp[1]="New Project";strTemp[2]="";strTemp[3]="";
        cont1.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
        cont1.setLayout(null);
        strTemp[0]="Crear Nuevo Projecto";strTemp[1]="Create New Project";strTemp[2]="";strTemp[3]="";
        JLabel neTitleJL= new JLabel(strTemp[foo],JLabel.CENTER);
        neTitleJL.setBounds(237,50,475,100);
        neTitleJL.setFont(fuenteGrande);
        strTemp[0]="Nombre del Proyecto";strTemp[1]="Project's Name";strTemp[2]="";strTemp[3]="";
        JLabel neNombreJL= new JLabel(strTemp[foo],JLabel.CENTER);
        neNombreJL.setBounds(118,150,237,100);
        neNombreJL.setFont(fuenteGrande);
        strTemp[0]="Descripcion";strTemp[1]="Description";strTemp[2]="";strTemp[3]="";
        JLabel neDescripJL= new JLabel(strTemp[foo],JLabel.CENTER);
        neDescripJL.setBounds(118,250,237,100);
        neDescripJL.setFont(fuenteGrande);

        nombreEnc=new JTextField(25);
        nombreEnc.setBounds(473,180,237,30);
        descrip= new JTextArea(10, 20);
        descrip.setBounds(473,280,237,80);
        descrip.setWrapStyleWord(true);
        descrip.setLineWrap(true);
        descrip.setAutoscrolls(true);
        strTemp[0]="Aceptar";strTemp[1]="Ok";strTemp[2]="";strTemp[3]="";
        butOKSurvey= new JButton("Aceptar");
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
        JPanel cont2= new JPanel();
        cont2.setLayout(null);
        strTemp[0]="Borrar Proyecto";strTemp[1]="Delete Project";strTemp[2]="";strTemp[3]="";
        cont2.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
        strTemp[0]="Selecione projecto a eliminar";strTemp[1]="Select Project to delete";strTemp[2]="";strTemp[3]="";
        JLabel neTitleJL2= new JLabel(strTemp[foo],JLabel.CENTER);
        neTitleJL2.setBounds(237,50,475,100);
        neTitleJL2.setFont(fuenteGrande);
        jcbSurveyDel= new JComboBox();
        jcbSurveyDel.setBounds(237, 250, 475, 40);
        jcbSurveyDel.setFont(fuenteGrande);
        //jcbSurvey.setModel(null);
        strTemp[0]="Aceptar";strTemp[1]="OK";strTemp[2]="";strTemp[3]="";
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
        JPanel cont3= new JPanel();
        cont3.setLayout(null);
        strTemp[0]="Revisar Datos de la Encuesta";strTemp[1]="Check survey's Info";strTemp[2]="";strTemp[3]="";
        cont3.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
        strTemp[0]="Seleccionar el Proyecto a revisar";strTemp[1]="Select projects to check";strTemp[2]="";strTemp[3]="";
        JLabel neTitleJL3= new JLabel(strTemp[foo],JLabel.CENTER);
        neTitleJL3.setBounds(237,50,475,100);
        neTitleJL3.setFont(fuenteGrande);
        jcbSel= new JComboBox();
        jcbSel.setBounds(237, 250, 475, 40);
        jcbSel.setFont(fuenteGrande);
        //jcbSurvey.setModel(null);
        strTemp[0]="Aceptar";strTemp[1]="OK";strTemp[2]="";strTemp[3]="";
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
        todo.setBorder(BorderFactory.createTitledBorder("Datos de Encuesta X"));
        //<editor-fold defaultstate="collapsed" desc="PanelGrafica">
        double max[]={6.73,5.98,6.66,7.54};
        double min[]={4.02,3.07,3.9,5.12};
        double prom[]={5.38,4.52,5.28,6.33};
        graf= new Grafica("1.jpg", max, min, prom);
        graf.setBounds(335, 20, graf.getWidth(), graf.getHeight());
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Inicializacion Panel Tabla Promedios">
        JPanel panelTabla2 = new JPanel();
        panelTabla2.setLayout(new FlowLayout(FlowLayout.LEFT));
	panelTabla2.setBorder(BorderFactory.createTitledBorder("Promedios"));
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
        JPanel panelTabla3 = new JPanel();
        panelTabla3.setLayout(new FlowLayout(FlowLayout.LEFT));
	panelTabla3.setBorder(BorderFactory.createTitledBorder("Promedios Encuesta X"));
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
        JPanel restric= new JPanel(new VerticalLayout(4));
        restric.setBounds(15, 270, 315, 225);
        restric.setBorder(BorderFactory.createTitledBorder("Restricciones"));
        jcbSexo= new JComboBox(setSexo());
        jcbEsc= new JComboBox(setEscolaridad());
        jcbExp= new JComboBox(setExperiancia());
        butRestric= new JButton("Agregar Cambios");
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
        panelCard.setBounds(230, 10, 850 , 500);
        panelCard.add(panelNE,"Nuevo");
        panelCard.add(panelEE,"Elimina");
        panelCard.add(panelSE,"Ver");
        panelCard.add(panelDatos,"Datos");
        setLayout(null);
        setSize(1,1);
        setSize(1100,550);
        add(panelTareas);
        add(panelCard);
        }
    //<editor-fold defaultstate="collapsed" desc="Metodo Settitles PromP">
    public void  setTitles(DefaultTableModel c){
			Object[] a = new Object[5];
				a[0]=" ";
				a[1]="Uso del Sistema";
				a[2]="Calidad Info";
                                a[3]="Calidad Inter";
                                a[4]="General";
			c.setColumnIdentifiers(a);
    }//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Metodo Settitles Promedios">
    public void  setTitles2(DefaultTableModel c){
			Object[] a = new Object[3];
				a[0]="No.Preg";
				a[1]="Promedio";
				a[2]="DesvMedi";
			c.setColumnIdentifiers(a);
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


        }

    //<editor-fold defaultstate="collapsed" desc="Inicializa Datos">
    public boolean inicializaDatos(String nameSur,String Atrib){
                limpiatabla(modeloPromedios);
                limpiatabla(modeloPromP);
                setTitles(modeloPromP);
                setTitles2(modeloPromedios);
                int a[][]=driver.rangos(driver.getIdProy(nameSur),Atrib);
                if(a==null){
                    strTemp[0]="No ahi datos que Mostrar";strTemp[1]="";strTemp[2]="";strTemp[3]="";
                    labTotalEnc.setText("Total de Encuestados: 0");
                    JOptionPane.showMessageDialog(null,strTemp[foo],"MSG",JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                containerStack.show(panelCard,"Datos");
                labTotalEnc.setText("Total de Encuestados: "+a.length);
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
                            o1[0]="promedio";
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
                strTemp[0]="No tienes Proyectos";strTemp[1]="You dont have any project";strTemp[2]="";strTemp[3]="";
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
            strTemp[0]="Falto Nombre";strTemp[1]="";strTemp[2]="";strTemp[3]="";
            JOptionPane.showMessageDialog(null,strTemp[foo],"MSG",JOptionPane.INFORMATION_MESSAGE);
            return 1;
        }
        if (descrip.getText().equals("")){
            descrip.requestFocus();
            strTemp[0]="falta descripcion";strTemp[1]="";strTemp[2]="";strTemp[3]="";
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
        inicializaDatos(jcbSel.getSelectedItem().toString(),atributos);
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
    private Object[] setEscolaridad(){
        Object[] sex=new Object[4];
        switch(foo){
            case 0 :sex[0]="Sin Estudios";sex[1]="Peparatoria";sex[2]="Superior";sex[3]="Sin Delimitar Escolaridad";break;
            case 1 :sex[0]="";sex[1]="";sex[2]="";break;
            case 2 :sex[0]="";sex[1]="";sex[2]="";break;
            case 3 :sex[0]="";sex[1]="";sex[2]="";sex[3]="";break;
            default :sex[0]="";sex[1]="";sex[2]="";break;
        }
        return sex;
    }
    private Object[] setExperiancia(){
        Object[] sex=new Object[4];
        switch(foo){
            case 0 :sex[0]="Poca";sex[1]="Regular";sex[2]="Mucha";sex[3]="Sin Delimitar Experiencia";break;
            case 1 :sex[0]="";sex[1]="";sex[2]="";sex[3]="";break;
            case 2 :sex[0]="";sex[1]="";sex[2]="";sex[3]="";break;
            case 3 :sex[0]="";sex[1]="";sex[2]="";sex[3]="";break;
            default :sex[0]="";sex[1]="";sex[2]="";sex[3]="";break;
        }
        return sex;
    }
    private Object[] setSexo(){
        Object[] sex=new Object[4];
        switch(foo){
            case 0 :sex[0]="Hombre";sex[1]="Mujer";sex[2]="Otros";sex[3]="Sin Delimitar Sexo";break;
            case 1 :sex[0]="Man";sex[1]="Woman";sex[2]="Others";break;
            case 2 :sex[0]="";sex[1]="";sex[2]="";break;
            default :sex[0]="";sex[1]="";sex[2]="";break;
        }
        return sex;
    }
    //</editor-fold>

}


