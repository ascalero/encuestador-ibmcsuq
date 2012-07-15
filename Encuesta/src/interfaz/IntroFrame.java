/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import interfaz.JPanelConFondo;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Ascalero
 */
public class IntroFrame extends JFrame implements ActionListener{
    
    private JPanelConFondo bannerJP;
    
    private JPanel textoJP;
    private JLabel marquee; 
    private Thread a;
    private JPanel flagsJP;
    private JButton flagBut[]=new JButton[4];
    ImageIcon band[] = new ImageIcon[4];
    
    
    public IntroFrame(){
        this.setTitle("Encuesta");
        setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
	setLocation(10,0);
	this.setResizable(false);
	setSize(640,480);
        setVisible (true);
        iniciaComponentes();
    }
    void iniciaComponentes(){
        bannerJP= new JPanelConFondo("../ima/encuesta.jpg");
	bannerJP.setBounds(0,0,640,170);
        
        textoJP = new JPanel();
        textoJP.setBounds(0,175,640,50);
        //textoJP.setBorder(BorderFactory.createTitledBorder("Language"));
        textoJP.setLayout(new GridLayout(0,1));
        marquee= new JLabel("",JLabel.CENTER);
        marquee.setFont(new Font("Arial",Font.BOLD,20));
        textoJP.add(marquee);
        
        flagsJP = new JPanel();
        flagsJP.setBounds(150,200,320,250);
        flagsJP.setBorder(BorderFactory.createTitledBorder("Language"));
        flagsJP.setLayout(new GridLayout(2,2));
        
        for(int i=0;i<4;i++){
        String temp="../ima/"+i+".png";
        band[i]= new ImageIcon(getClass().getResource(temp));
        flagBut[i]= new JButton(band[i]);
        flagBut[i].addActionListener(this);
        flagsJP.add(flagBut[i]);
        }
              
         
        
        setLayout(null);
        
        add(bannerJP);
        add(textoJP);
        add(flagsJP);
        
        launcher();
    }
    void launcher(){
        Runnable temp =new Runnable() {

            @Override
            public void run() {
                marqueeLaunch();
            }
        };
        a= new Thread(temp);
        a.start();
    }
    
    void marqueeLaunch(){
    while(true){
        
            String[] foo={"Selecciona tu idioma","Select your language","Wählen Sie Ihre Sprache","Choisissez votre langue"};
            for(int i=0;i<4;i++){
                marquee.setText(foo[i]);
                bannerJP.setImagen("../ima/encuesta.jpg");
            try {
                
                Thread.sleep(2000);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(IntroFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
    }
    }
    
    
    


    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<4;i++){
        if(e.getSource()==flagBut[i]){
            this.setVisible(false);
            PanelMiembro b= new PanelMiembro(i);
            this.dispose();
        }
        
        }
        
    }
    
}
