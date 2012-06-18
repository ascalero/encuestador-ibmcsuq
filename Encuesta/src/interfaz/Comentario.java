/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import conex.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.WindowConstants;
import org.jdesktop.swingx.JXFrame;

/**
 *
 * @author Shadow
 */
public class Comentario extends JXFrame implements ActionListener{
    
    int foo;
    String strTemp[]= new String[4];
    String nomEnc;
    JLabel jlTxt;
    JTextArea jtaComentario;
    JButton jbOk,jbCancel;
    
    public Comentario(int lenguaje,String nomEnc){
        foo=lenguaje;
        this.nomEnc=nomEnc;
        this.setTitle(nomEnc);
        setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
        setLocation(10,0);
        setSize(535,340);
        setVisible (true);
        initComp();
    }
    
    public void initComp(){
        JPanel coment=new JPanel(new GridLayout(0, 1));
        coment.setBounds(10,10,500,250);
        strTemp[0]="Por ultimo deja un comentario del proyecto.";strTemp[1]="Finally the project leave a comment.";
        strTemp[2]="Schließlich wird das Projekt um einen Kommentar.";strTemp[3]="Enfin, le projet laisser un commentaire.";
        coment.setBorder(BorderFactory.createTitledBorder(strTemp[foo]));
        
        jtaComentario=new JTextArea(null, 10, 15 );
        coment.add( new JScrollPane( jtaComentario ) );
        
        JPanel botones=new JPanel(new GridLayout(0, 2));
        botones.setBounds(10, 265, 500, 30);
        strTemp[0]="Aceptar";strTemp[1]="Ok";strTemp[2]="Akzeptieren";strTemp[3]="Accepter";
        jbOk=new JButton(strTemp[foo]);
        jbOk.addActionListener(this);
        
        strTemp[0]="Cancelar";strTemp[1]="Cancel";strTemp[2]="Annullieren";strTemp[3]="Annuler";
        jbCancel=new JButton(strTemp[foo]);
        jbCancel.addActionListener(this);
        
        botones.add(jbOk);
        botones.add(jbCancel);
        
        setLayout(null);
        add(coment);        
        add(botones);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jbOk){
            OpBasicas op=new OpBasicas();
            LoginConx lc=new LoginConx();
            op.InsertCommit(jtaComentario.getText(),lc.getIdProy(nomEnc));
            IntroFrame a = new IntroFrame();
            this.dispose();
            
        }
        if(e.getSource()==jbCancel){
            IntroFrame a = new IntroFrame();
            this.dispose();
        }
    }
}
