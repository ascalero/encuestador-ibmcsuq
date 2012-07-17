/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.FrameEncuestas;

import estructuras.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jdesktop.swingx.JXFrame;

/**
 *
 * @author Shadow
 */
public class FrameComent extends JXFrame implements ActionListener{

    private int foo;
    private String strTemp[]=new String[4];
    
    //Manejo de Preguntas y Respuestas
    private Survey s;
    private RespEnq re;
    
    //Componentes de la interfaz
    private JTextArea jtaCom;
    private JButton jbtNext;
    private JPanel body;
    
    public FrameComent(int foo,Survey s,RespEnq re){
        this.foo=foo;
        this.s=s;
        this.re=re;
        
        //setTitle(s.getName());
        setTitle("Name Enc");
        initComp();
        
        setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
        setLocation(10,0);
        setSize(535,390);
        setVisible (true);
    }
    
    public void initComp(){
        body=new JPanel(new GridLayout(0,1));
        body.setBounds(10, 10, 500, 290);
        //body.setBorder(BorderFactory.createTitledBorder(s.getNextStq().getQuest(foo)));
        body.setBorder(BorderFactory.createTitledBorder("¿Pregunta?"));
        
        jtaCom=new JTextArea(null,10,15);
        body.add(new JScrollPane(jtaCom));
        
        JPanel jpButton=new JPanel();//(new GridLayout(0, 2));
        jpButton.setBounds(10, 300, 500, 30);
        strTemp[0]="Siguiente";strTemp[1]="Next";strTemp[2]="Nächste";strTemp[3]="Prochain";
        jbtNext=new JButton(strTemp[foo]);
        jbtNext.addActionListener(this);
        jpButton.add(jbtNext);
        
        setLayout(null);
        add(body);
        add(jpButton);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jbtNext){
            if(jtaCom.getText()!=null){
                re.setCom(jtaCom.getText());
            }
        }
    }
    
}
