package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.util.*;


public class InterImagenes extends JPanel implements ActionListener {
	JPanel plHeader,plConta,plBotones,plImages;
	JLabel lbTitulo,lbPreg,lbNoPreg,lbCont1,lbCont2,lbCont3,lbCont4;
	JButton btAnt,btSig;
	JTextField tfNoPreg;
	JPanelConFondo plImag1,plImag2,plImag3,plImag4;
	String pregunta,proyecto;
	int numPreg,cont1, cont2,cont3,cont4,idioma;
	ArrayList<String> preguntas= new ArrayList<String>(); 
	
	public InterImagenes(){
		setSize(1000,640);
		InitComponents();
		
	}
	
	public void InitComponents(){
		plHeader= new JPanel();
		plConta= new JPanel();
		plBotones= new JPanel();
		plImages= new JPanel();
		lbCont1= new JLabel("1");
		lbCont1.setBackground(Color.PINK);
		lbCont2= new JLabel("2");
		lbCont3= new JLabel("3");
		lbCont4= new JLabel("4");
		plImag1= new JPanelConFondo("../ima/ima1.jpg");
		plImag2= new JPanelConFondo("../ima/ima2.jpg");
		plImag3= new JPanelConFondo("../ima/ima3.jpg");
		plImag4= new JPanelConFondo("../ima/ima4.jpg");
		btAnt= new JButton("Anterior");
		btSig= new JButton("Siguiente");
		lbTitulo= new JLabel("Proyecto \" Encuesta 1\"");
		lbPreg= new JLabel("Pregunta:¿xxxxxxx?");
		tfNoPreg= new JTextField("1 / 9",5);
		tfNoPreg.setHorizontalAlignment(JTextField.CENTER);
		tfNoPreg.setEditable(false);
		setLayout(null);
		
	//	plHeader.setBackground(Color.BLUE);
		plHeader.setBounds(15, 10, 980, 30);
		plHeader.add(lbTitulo);
		add(plHeader);
		
	//	plImages.setBackground(Color.GREEN);
		plImages.setBounds(15, 50, 980, 300);
		plImages.setLayout(new GridLayout(1, 4, 5, 0));
		plImages.add(plImag1);
		plImages.add(plImag2);
		plImages.add(plImag3);
		plImages.add(plImag4);
		add(plImages);

	//	plConta.setBackground(Color.cyan);
		plConta.setBounds(15, 360, 980, 50);
	    plConta.setLayout(new GridBagLayout());
	    GridBagConstraints gbc= new GridBagConstraints();
	    gbc.gridx=0;
	    gbc.gridy=0;
	    gbc.weightx=.25;
	    plConta.add(lbCont1,gbc);
	    gbc.gridx=1;
	    gbc.gridy=0;
	    gbc.weightx=.25;
	    plConta.add(lbCont2,gbc);
		gbc.gridx=2;
		gbc.gridy=0;
		gbc.weightx=.25;
		plConta.add(lbCont3,gbc);
		gbc.gridx=3;
		gbc.gridy=0;
		gbc.weightx=.25;
		plConta.add(lbCont4,gbc);
		add(plConta);
		
		plBotones.setBounds(15, 420, 980, 100);
	//	plBotones.setBackground(Color.YELLOW);
		plBotones.setLayout(new GridBagLayout());
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.weightx=1;
		gbc.insets= new Insets(15,5,15,5);
		plBotones.add(lbPreg,gbc);
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.gridheight=2;
		gbc.weightx=.25;
		gbc.fill= GridBagConstraints.VERTICAL;
		plBotones.add(btAnt,gbc);
		gbc.gridx=1;
		gbc.gridy=2;
		gbc.gridheight=1;
		gbc.weightx=.30;
		gbc.fill= GridBagConstraints.VERTICAL;
		plBotones.add(tfNoPreg,gbc);
		gbc.gridx=2;
		gbc.gridy=2;
		gbc.gridheight=2;
		gbc.weightx=.35;
		gbc.fill= GridBagConstraints.VERTICAL;
		gbc.anchor= GridBagConstraints.CENTER;
		plBotones.add(btSig,gbc);
		add(plBotones);
		setVisible(true);
		
		
	}
	
	public void setProyecto(String nombreProyecto){
		proyecto= nombreProyecto;
	}
	
	public void setPreguntas(ArrayList<String> preg){
		preguntas= preg;
	}
	
	public void setNumPreg(int num){
		numPreg= num;
	}
	
	public void setIdioma(int foo){
						
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btAnt){
			
		}
		else if(e.getSource()==btSig){
			
		}
		
	}

}
