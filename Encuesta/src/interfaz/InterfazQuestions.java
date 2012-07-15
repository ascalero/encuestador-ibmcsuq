/**
 * @(#)InterfazQuestions.java
 *
 *
 * @author  VikMor
 * @version 1.00 2012/7/2
 */
package interfaz;
import estructuras.StructImaQ;
import estructuras.StructLikeIt;
import estructuras.StructQuest;
import estructuras.StructQuestGrid;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
//import java.io.*;

public class InterfazQuestions extends JFrame implements ActionListener{
private JPanel panelLabels, panelBotones,panelPreguntas,panelRespuestas;
private JTextField tfPreguntaEsp,tfPreguntaIng,tfPreguntaFran,tfPreguntaAlem,tfImagDir1,tfImagDir2,tfImagDir3,tfImagDir4,tfImagGrid;
private JLabel lbPregunta, lbRespuesta,lbEsp,lbIng,lbFran,lbAlem,lbImagDir,lbMaxMin;
private JButton btCapturar,btSiguiente,btExaminar;
private JComboBox combo;
final JFileChooser browser= new JFileChooser();
String [] pregunta= new String[4];
String [] dirImagenes= new String[4];
String [] min= new String[4];
String [] max= new String[4];
String imaDir;
int noPreg=0;
        
//<editor-fold defaultstate="collapsed" desc="Variables Menu">
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    JRadioButtonMenuItem rbMILang[];
    
    //</editor-fold>
    

    public InterfazQuestions() {
    	super("Crea Encuesta");
    	setSize(700,250);
    	initComponents();
    }
    
    public void initComponents(){
    	panelLabels= new JPanel();
       	panelPreguntas= new JPanel();
       	panelBotones= new JPanel();
    	panelRespuestas= new JPanel();
    	tfPreguntaEsp= new JTextField(80);
    	tfPreguntaIng= new JTextField(80);
    	tfPreguntaFran= new JTextField(80);
    	tfPreguntaAlem= new JTextField(80);
      	tfImagDir1= new JTextField(20);
    	tfImagDir2= new JTextField(20);
    	tfImagDir3= new JTextField(20);
    	tfImagDir4= new JTextField(20);
    	tfImagGrid= new JTextField(20);
    	tfImagDir1.setVisible(false);
    	tfImagDir2.setVisible(false);
    	tfImagDir3.setVisible(false);
    	tfImagDir4.setVisible(false);
    	tfImagGrid.setVisible(false);
    	max[0]="Totalmente de acuerdo";
    	max[1]="Strongly agree";
    	max[2]="Entirement D'accord";
    	max[3]="Trifft Uneingeschrnkt Zu";
    	min[0]="Totalmente en desacuerdo";
    	min[1]="Strongly desagree";
    	min[2]="Fortement en dsaccord";
    	min[3]="Trifft berhaupt nicht zu";
    	lbEsp= new JLabel("Español:");
    	lbIng= new JLabel("Ingles:");
    	lbFran= new JLabel("Frances:");
    	lbAlem= new JLabel("Aleman:");
    	lbPregunta= new JLabel("Ingresa tu pregunta:");
    	lbRespuesta= new JLabel("Elige Tipo de Respuesta");
    	lbImagDir= new JLabel("Ingresa la dirección de las imagenes");
       	lbImagDir.setVisible(false);
       	btCapturar= new JButton("Agregar");
       	btSiguiente= new JButton("Siguiente");
       	btExaminar=  new JButton("Examinar");
    	combo= new JComboBox();
    	combo.addItem("Opcion Multiple");
    	combo.addItem("Selección de Imágen");
    	combo.addItem("Respuesta Abierta");
    	combo.addItem("Imágen estática");
    	combo.addActionListener(this);
    	btExaminar.addActionListener(this);
    	panelLabels.setLayout(new BorderLayout());
    	panelLabels.add(lbPregunta,BorderLayout.CENTER);
    	panelLabels.add(lbRespuesta,BorderLayout.EAST);
    	panelRespuestas.setLayout(new GridLayout(7,1));
    	panelRespuestas.add(combo);
    	panelRespuestas.add( lbImagDir);
    	panelRespuestas.add(tfImagGrid);
    	panelRespuestas.add(tfImagDir1);
    	panelRespuestas.add(tfImagDir2);
    	panelRespuestas.add(tfImagDir3);
    	panelRespuestas.add(tfImagDir4);
    	getContentPane().setLayout(new BorderLayout());
    	getContentPane().add(panelLabels,BorderLayout.NORTH);
    	panelPreguntas.setLayout(new GridLayout(4,2,0,3));
    	panelPreguntas.add(lbEsp);
    	panelPreguntas.add(tfPreguntaEsp);
    	panelPreguntas.add(lbIng);
    	panelPreguntas.add(tfPreguntaIng);
    	panelPreguntas.add(lbFran);
    	panelPreguntas.add(tfPreguntaFran);
    	panelPreguntas.add(lbAlem);
    	panelPreguntas.add(tfPreguntaAlem);
    	getContentPane().add(panelPreguntas,BorderLayout.CENTER);
    	getContentPane().add(panelRespuestas,BorderLayout.EAST);
    	panelBotones.add(btCapturar);
    	panelBotones.add(btSiguiente);
    	panelBotones.add(btExaminar);
    	getContentPane().add(panelBotones,BorderLayout.SOUTH);
    	setVisible(true);
    	btCapturar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
    	if(e.getSource()==btExaminar){
			 JFileChooser chooser = new JFileChooser();
    		 FileFilter filter = new FileNameExtensionFilter("JPEG file", "jpg","jpge","gif","png","bmp");
		     chooser.setFileFilter(filter);
		     int returnVal = chooser.showOpenDialog(InterfazQuestions.this);
    			if (returnVal == JFileChooser.APPROVE_OPTION) {	
    	    				//	System.out.println("You chose to open this file: " +chooser.getSelectedFile().getName());
       				tfImagGrid.setText(chooser.getSelectedFile().getName());
    			}
    	}
    	if (e.getSource()==combo){
    		if(combo.getSelectedItem().toString().equalsIgnoreCase("Selección de Imágen")){
    			lbImagDir.setText("Ingresa la dirección de las imagenes");
    			lbImagDir.setVisible(true);
    		 	tfImagDir1.setVisible(true);
    		 	tfImagDir2.setVisible(true);
    		 	tfImagDir3.setVisible(true);
    		 	tfImagDir4.setVisible(true);
    		 	tfImagGrid.setVisible(false);
    		 	dirImagenes[0]=tfImagDir1.getText();
    		 	dirImagenes[1]=tfImagDir1.getText();
    		 	dirImagenes[2]=tfImagDir1.getText();
    		 	dirImagenes[3]=tfImagDir1.getText();
    		}
    		if(combo.getSelectedItem().toString().equalsIgnoreCase("Imágen estática")){
    			lbImagDir.setText("Ingresa la direccón de la imágen");
    			lbImagDir.setVisible(true);
    			tfImagGrid.setVisible(true);
    			tfImagDir1.setVisible(false);
    		 	tfImagDir2.setVisible(false);
    		 	tfImagDir3.setVisible(false);
    		 	tfImagDir4.setVisible(false);
    			imaDir=tfImagGrid.getText();
    		}
    		else if (combo.getSelectedItem().toString().equalsIgnoreCase("Opción Multiple") || combo.getSelectedItem().toString().equalsIgnoreCase("Respuesta Abierta")){
    			lbImagDir.setVisible(false);
    		 	tfImagDir1.setVisible(false);
    		 	tfImagDir2.setVisible(false);
    		 	tfImagDir3.setVisible(false);
    		 	tfImagDir4.setVisible(false);
    		 	tfImagGrid.setVisible(false);
    		}
    	}
    	
       if (e.getSource()==btCapturar){
    		 pregunta[0]=tfPreguntaEsp.getText();
    		 pregunta[1]=tfPreguntaIng.getText();
    		 pregunta[2]=tfPreguntaFran.getText();
    		 pregunta[3]=tfPreguntaAlem.getText();
    	
    		 if (combo.getSelectedItem().toString().equalsIgnoreCase("Opción Multiple")){
    		 	StructLikeIt question= new StructLikeIt(pregunta,max,min);
    		    System.out.println("Opción Multiple");
    		 }
    		 else if (combo.getSelectedItem().toString().equalsIgnoreCase("Selección de Imágen")){
    		 	StructImaQ question= new StructImaQ(pregunta,dirImagenes);  		 	 	
    		 }
    		 else if (combo.getSelectedItem().toString().equalsIgnoreCase("Respuesta Abierta")){
    		 	StructQuest question= new StructQuest(pregunta);
    		 }
    		 else if (combo.getSelectedItem().toString().equalsIgnoreCase("Imagen estática")){
    		   	StructQuestGrid question= new StructQuestGrid(pregunta,imaDir);
    		  }
   	   }
   	   if (e.getSource()==btSiguiente); 
    }
    
    public static void main (String[] args) {
    	InterfazQuestions encuesta= new InterfazQuestions();
    	encuesta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
    
    
}