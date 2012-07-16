
package interfaz;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class InterComentario extends JPanel implements ActionListener {
	JPanel plHeader,plTable,plBotones;
	JTextField tfNoPreg;
	JLabel lbPreg, lbTitulo;
	JButton btAnt, btSig;
	JTable tbRespuestas;
	String pregunta,proyecto;
	int noPregunta;
	DefaultTableModel modelo;
	

	
	public InterComentario() {
		setSize(1000,640);
		initComponents();
	}

	public void initComponents(){
		plTable= new JPanel();
		plHeader= new JPanel();
		plBotones= new JPanel();
		tfNoPreg= new JTextField("1 / 10",5);
		tfNoPreg.setHorizontalAlignment(JTextField.CENTER);
		lbPreg= new JLabel("¿XXXXXXX?");
		lbTitulo= new JLabel("PROYECTO 1");
		btAnt= new JButton("Anterior");
		btSig= new JButton("Siguiente");
		setLayout(null);
		
		plHeader.setBounds(15, 10, 980, 30);
		plHeader.add(lbTitulo);
		add(plHeader);
		
		plTable.setBounds(15,50,980,400);
		tbRespuestas= new JTable(modelo);
                tbRespuestas.setPreferredScrollableViewportSize(new Dimension(350, 300));
		    tbRespuestas.setAutoscrolls(true);
		    JScrollPane scroll = new JScrollPane(tbRespuestas);
		    scroll.setAutoscrolls(true);
		    plTable.add(scroll,BorderLayout.CENTER);
		
		add(plTable);
		
		GridBagConstraints gbc= new GridBagConstraints();
		plBotones.setBounds(15, 460, 980, 100);
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
