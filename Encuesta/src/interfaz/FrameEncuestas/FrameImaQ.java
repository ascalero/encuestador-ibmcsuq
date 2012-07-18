/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.FrameEncuestas;

import conex.EnqLibConx;
import estructuras.*;
import interfaz.JPanelConFondo;
import interfaz.PanelMiembro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Shadow
 */
public class FrameImaQ extends javax.swing.JFrame implements ActionListener{

    private int foo;
    private String strTemp[]=new String[4];
    private String dirIma[];
    
    private Survey s;
    private RespEnq re;
    private StructImaQ strucImaQ;
    ArrayList <String> datoEnc;
    
    //<editor-fold defaultstate="collapsed" desc="Variables Menu">
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    JRadioButtonMenuItem rbMILang[];
    
    //</editor-fold>
    
    public FrameImaQ(int foo,Survey s,RespEnq re,ArrayList<String> datoEnc,StructImaQ forma){
        this.foo=foo;
        this.s=s;
        this.re=re;
        this.datoEnc=datoEnc;
        strucImaQ=forma;
        
        setTitle(s.getName());
        
        initComponents();
        menuCharger();
        setIdioma(foo);
        
        setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
        setLocation(10,20);
        setSize(410, 520);
        setVisible (true);
    }
    
    public void setIdioma(int foo){
        this.foo=foo;
        strTemp[0]="Pregunta"+s.getActual();strTemp[1]="Question"+s.getActual();strTemp[2]="Frage"+s.getActSize();strTemp[3]="Question"+s.getActSize();
        jlNumAsk.setText(strTemp[foo]);
        jlAsk.setText(strucImaQ.getQuest(foo));
        strTemp[0]="Siguiente";strTemp[1]="Next";strTemp[2]="Nächste";strTemp[3]="Prochain";
        jbNext.setText(strTemp[foo]);
        
        String ima[]=strucImaQ.getDir();
        jpIma1.setImagen(ima[0]);
        jpIma2.setImagen(ima[1]);
        jpIma3.setImagen(ima[2]);
        jpIma4.setImagen(ima[3]);
        
        //idioma en el menu
        strTemp[0]="Idioma";strTemp[1]="Language";strTemp[2]="Sprache";strTemp[3]="langue";
        menu.setText(strTemp[foo]);
        strTemp[0]="Selecciona tu idioma";strTemp[1]="Select your language";strTemp[2]="Wählen Sie Ihre Sprache";strTemp[3]="Choisissez votre langue";
        menuItem.setText(strTemp[foo]);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbGroup = new javax.swing.ButtonGroup();
        jlNumAsk = new javax.swing.JLabel();
        jlAsk = new javax.swing.JLabel();
        jpIma1 = new JPanelConFondo("../ima/cuadricula.png");
        jpIma2 = new JPanelConFondo("../ima/cuadricula.png");
        jpIma3 = new JPanelConFondo("../ima/cuadricula.png");
        jpIma4 = new JPanelConFondo("../ima/cuadricula.png");
        jbNext = new javax.swing.JButton();
        jrbIma1 = new javax.swing.JRadioButton();
        jrbIma2 = new javax.swing.JRadioButton();
        jrbIma3 = new javax.swing.JRadioButton();
        jrbIma4 = new javax.swing.JRadioButton();

        rbGroup.add(jrbIma1);
        rbGroup.add(jrbIma2);
        rbGroup.add(jrbIma3);
        rbGroup.add(jrbIma4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlNumAsk.setText("");
        getContentPane().add(jlNumAsk, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jlAsk.setText("");
        getContentPane().add(jlAsk, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        //new JpanelConFondo(dirIma[2]);

        javax.swing.GroupLayout jpIma3Layout = new javax.swing.GroupLayout(jpIma3);
        jpIma3.setLayout(jpIma3Layout);
        jpIma3Layout.setHorizontalGroup(
            jpIma3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        jpIma3Layout.setVerticalGroup(
            jpIma3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        getContentPane().add(jpIma3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 140, 140));

        //new JpanelConFondo(dirIma[1]);

        javax.swing.GroupLayout jpIma2Layout = new javax.swing.GroupLayout(jpIma2);
        jpIma2.setLayout(jpIma2Layout);
        jpIma2Layout.setHorizontalGroup(
            jpIma2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        jpIma2Layout.setVerticalGroup(
            jpIma2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        getContentPane().add(jpIma2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 140, 140));

        //new JpanelConFondo(dirIma[0]);

        javax.swing.GroupLayout jpIma1Layout = new javax.swing.GroupLayout(jpIma1);
        jpIma1.setLayout(jpIma1Layout);
        jpIma1Layout.setHorizontalGroup(
            jpIma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        jpIma1Layout.setVerticalGroup(
            jpIma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        getContentPane().add(jpIma1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 140, 140));

        //new JpanelConFondo(dirIma[3]);

        javax.swing.GroupLayout jpIma4Layout = new javax.swing.GroupLayout(jpIma4);
        jpIma4.setLayout(jpIma4Layout);
        jpIma4Layout.setHorizontalGroup(
            jpIma4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        jpIma4Layout.setVerticalGroup(
            jpIma4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        getContentPane().add(jpIma4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, -1, -1));

        jbNext.setText("");
        jbNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNextActionPerformed(evt);
            }
        });
        getContentPane().add(jbNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, -1, -1));

        jrbIma1.setText("1");
        getContentPane().add(jrbIma1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        jrbIma2.setText("2");
        getContentPane().add(jrbIma2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, -1, -1));

        jrbIma3.setText("3");
        getContentPane().add(jrbIma3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, -1, 20));

        jrbIma4.setText("4");
        getContentPane().add(jrbIma4, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 380, 80, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNextActionPerformed
        if(select()){
            re.setRLISI(opSelect(), 2);
            if(!s.islast()){
                switch(s.getNext()){
                    case 0:new FrameAskFree(foo,s,re,datoEnc,s.getNextStq());break;
                    case 1:new FrameLikeIt(foo,s,re,datoEnc,s.getNextLI());break;
                    case 2:new FrameImaQ(foo,s,re,datoEnc,s.getNextStIQ());break;
                    case 3:new FrameMouseTraking(foo,s,re,datoEnc,s.getNextQG());
                    default:break;
                }
            }
            else{
                EnqLibConx eLC=new EnqLibConx();
                eLC.setRes(re, datoEnc, s.getName());
                strTemp[0]="Gracias por Participar";strTemp[1]="Write your Answer";
                strTemp[2]="Schreiben Sie Ihre Antwort";strTemp[3]="Ecrivez votre réponse";
                JOptionPane.showMessageDialog(null,strTemp[foo]);
                new PanelMiembro(foo);
            }
            this.dispose();
        }else{
            strTemp[0]="Debes de Seleccionar una Opcion";strTemp[1]="You Must select a choise";
            strTemp[2]="Sie müssen eine Wahl";strTemp[3]="Vous devez sélectionner un choix";
            JOptionPane.showMessageDialog(null,strTemp[foo]);
        }
    }//GEN-LAST:event_jbNextActionPerformed

    public boolean select(){
        boolean b=false;
        if(jrbIma1.isSelected()){b=true;}
        if(jrbIma2.isSelected()){b=true;}
        if(jrbIma3.isSelected()){b=true;}
        if(jrbIma4.isSelected()){b=true;}
        return b;
    }
    
    public int opSelect(){
        int op=0;
        if(jrbIma1.isSelected()){op=1;}
        if(jrbIma2.isSelected()){op=2;}
        if(jrbIma3.isSelected()){op=3;}
        if(jrbIma4.isSelected()){op=4;}
        return op;
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
        rbMILang[i].addActionListener(this);//
    }
    this.setJMenuBar(menuBar);
        //this.add(menuBar);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbNext;
    private javax.swing.JLabel jlAsk;
    private javax.swing.JLabel jlNumAsk;
    private JPanelConFondo jpIma1;
    private JPanelConFondo jpIma2;
    private JPanelConFondo jpIma3;
    private JPanelConFondo jpIma4;
    private javax.swing.JRadioButton jrbIma1;
    private javax.swing.JRadioButton jrbIma2;
    private javax.swing.JRadioButton jrbIma3;
    private javax.swing.JRadioButton jrbIma4;
    private javax.swing.ButtonGroup rbGroup;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
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
}
