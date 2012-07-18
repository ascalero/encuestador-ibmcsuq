/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.FrameEncuestas;

import estructuras.*;
import interfaz.JPanelConFondo;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Shadow
 */
public class FrameImaQ extends javax.swing.JFrame {

    private int foo;
    private String strTemp[]=new String[4];
    private String dirIma[];
    
    private Survey s;
    private RespEnq re;
    
    public FrameImaQ(int foo,Survey s,RespEnq re){
        this.foo=foo;
        this.s=s;
        this.re=re;
        //dirIma=s.getNextStIQ().getDir();
        setTitle(s.getName());
        initComponents();
        
        setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
        setLocation(10,20);
        setSize(410, 500);
        setVisible (true);
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
        jpIma3 = new JPanelConFondo("../ima/cuadricula.png");
        jpIma2 = new JPanelConFondo("../ima/cuadricula.png");
        jpIma1 = new JPanelConFondo("../ima/cuadricula.png");
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

        jlNumAsk.setText("1");
        getContentPane().add(jlNumAsk, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jlAsk.setText(s.getNextStIQ().getQuest(foo));
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

        getContentPane().add(jpIma3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 140, 140));

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

        strTemp[0]="Siguiente";strTemp[1]="Next";strTemp[2]="Nächste";strTemp[3]="Prochain";
        jbNext.setText(strTemp[foo]);
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
            switch(s.getNext()){
                case 0:new FrameAskFree(0,s,re);break;
                case 1:new FrameLikeIt(0,s,re);break;
                case 2:new FrameImaQ(0,s,re);break;
                case 3:new FrameMouseTraking(0,s,re);
                default:break;
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbNext;
    private javax.swing.JLabel jlAsk;
    private javax.swing.JLabel jlNumAsk;
    private javax.swing.JPanel jpIma1;
    private javax.swing.JPanel jpIma2;
    private javax.swing.JPanel jpIma3;
    private javax.swing.JPanel jpIma4;
    private javax.swing.JRadioButton jrbIma1;
    private javax.swing.JRadioButton jrbIma2;
    private javax.swing.JRadioButton jrbIma3;
    private javax.swing.JRadioButton jrbIma4;
    private javax.swing.ButtonGroup rbGroup;
    // End of variables declaration//GEN-END:variables
}
