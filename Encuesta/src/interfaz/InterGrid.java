
package interfaz;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class InterGrid extends JPanel implements ActionListener{
	JPanel plHeader, plGrafica, plBotones;
	JLabel lbTitulo, lbPreg;
	JTextField tfNoPreg;
	JButton btAnt,btSig;
	String proyecto, pregunta;
	int noPregunta;
	
	public InterGrid() {
		setSize(1000,640);
		initComponents();
	}
	public void initComponents(){
		plGrafica= new JPanel();
		plHeader= new JPanel();
		plBotones= new JPanel();
		tfNoPreg= new JTextField("1 / 10",5);
		tfNoPreg.setHorizontalAlignment(JTextField.CENTER);
		lbPreg= new JLabel("¿XXXXXXX?");
		lbTitulo= new JLabel("PROYECTO 1");
		btAnt= new JButton("Anterior");
		btSig= new JButton("Siguiente");
		setLayout(null);
		GridBagConstraints gbc= new GridBagConstraints();
		
		plHeader.setBounds(15, 10, 980, 30);
		plHeader.add(lbTitulo);
		add(plHeader);
		
		plGrafica.setBackground(Color.LIGHT_GRAY);
		plGrafica.setBounds(180,50,640,480);
		plGrafica.setLayout(new BorderLayout());
		add(plGrafica);
		
		
		plBotones.setBounds(15, 540, 980, 100);
		plBotones.setLayout(new GridBagLayout());
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.weightx=1;
		gbc.insets= new Insets(10,5,10,5);
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
	
	public void setPregunta(String pregunta){
		this.pregunta= pregunta;
	}
	
	public void setNumPreg(int num){
		noPregunta= num;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btAnt){
			
		}
		else if(e.getSource()==btSig){
			
		}	
	}
}
