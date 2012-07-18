/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import estructuras.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Ascalero
 */
public class JPMuestraOpenResp extends javax.swing.JPanel implements ActionListener{

    /**
     * Creates new form JPMuestraOpenResp
     */
    
    private Respuestas infoResp;
    private Survey sur;
    private String strTemp[]= new String[4];
    int foo;
    private int actQuest[];
    ArrayList<StructQuest> StQ=new ArrayList<StructQuest>();
    ArrayList<StructImaQ> StIQ=new ArrayList<StructImaQ>();
    ArrayList<StructLikeIt> StLI = new ArrayList<StructLikeIt>();
    ArrayList<StructQuestGrid> StQG = new ArrayList<StructQuestGrid>();

    public JPMuestraOpenResp(int idioma) {
        foo=idioma;
        actQuest=new int[4];
        initComponents();
        
    }
    public void setValues(Respuestas a,Survey b){
        infoResp=a;
        sur=b;
    }
    
    public void inicializavalores(){
        StQ= sur.getStQ();
        StLI= sur.getStLI();
        StIQ= sur.getStIQ();
        StQG= sur.getStQG();
        actQuest[0]=0;
        actQuest[1]=0;
        actQuest[2]=0;
        actQuest[3]=0;
        setIdioma(foo);
    }
    public void setIdioma(int var){
        foo=var;
        jlTitulo.setText(sur.getName());
        //Tabbed panel Open Question
        jlTiOR.setText(StQ.get(actQuest[0]).getQuest(foo));
        jtMTOPCont.setText((actQuest[0]+1)+"/"+StQ.size());
        //Botones anterior y siguiente
        strTemp[0]="Siguiente";strTemp[1]="Next";strTemp[2]="Nächste";strTemp[3]="Prochain";
        jbImaSelNext.setText(strTemp[foo]);
        jbLINext.setText(strTemp[foo]);
        jbMTNext.setText(strTemp[foo]);
        jbORNext.setText(strTemp[foo]);
        strTemp[0]="Anterior";strTemp[1]="Previous";strTemp[2]="Vorherige";strTemp[3]="précédent";
        jbImaSelAnt.setText(strTemp[foo]);
        jbLIAnt.setText(strTemp[foo]);
        jbMTAnt.setText(strTemp[foo]);
        jbORAnt.setText(strTemp[foo]);
        //tabbed panel Likeit
        jtfLiCont.setText((actQuest[1]+1)+"/"+StLI.size());
        jlTitBarras.setText(StLI.get(actQuest[1]).getQuest(foo));
        //Tabbedpanel Imaquestion
        
        jtfImaSELCont.setText((actQuest[2]+1)+"/"+StIQ.size());
        jlTitImaSel.setText(StIQ.get(actQuest[2]).getQuest(foo));
        setTPimaQ(); 
        
        
        //Tabbed Panel Mousetraking
        jtMTiCont.setText((actQuest[3]+1)+"/"+StQG.size());
        jlTiMT1.setText(StQG.get(actQuest[3]).getQuest(foo));
        
        
        
    }
    public void setTPimaQ(){
    int temvar[]= new int[4];
        for(int a:infoResp.getSelIma(actQuest[2])){
            switch(a){
                case 1: jTFCima1.setText(""+(++temvar[0]));break;
                case 2: jTFCima2.setText(""+(++temvar[1]));break;
                case 3: jTFCima3.setText(""+(++temvar[2]));break;
                case 4: jTFCima4.setText(""+(++temvar[3]));break;
            }
        }
        String direc[]=StIQ.get(actQuest[2]).getDir();
        jPIma1.setImagen(direc[0]);
        jPIma2.setImagen(direc[1]);
        jPima3.setImagen(direc[2]);
        jpIma4.setImagen(direc[3]);
    }
    
    public void nextORQ(){
        //if(actQuest[0]==0){return;}
        actQuest[0]++;
        if(actQuest[0]==StQ.size()){actQuest[0]--;return;}
        jtMTOPCont.setText((actQuest[0]+1)+"/"+StQ.size());
        jlTiOR.setText(StQ.get(actQuest[0]).getQuest(foo));
        
    }
    public void prevORQ(){
        if(actQuest[0]==0){return;}
        actQuest[0]--;
        jtMTOPCont.setText((actQuest[0]+1)+"/"+StQ.size());
        jlTiOR.setText(StQ.get(actQuest[0]).getQuest(foo));
        
    }
    
    public void nextQLI(){
        //if(actQuest[0]==0){return;}
        actQuest[1]++;
        if(actQuest[1]==StQ.size()){actQuest[1]--;return;}
        jtfLiCont.setText((actQuest[1]+1)+"/"+StLI.size());
        jlTitBarras.setText(StLI.get(actQuest[1]).getQuest(foo));
        
    }
    public void prevQLI(){
        if(actQuest[1]==0){return;}
        actQuest[1]--;
        jtfLiCont.setText((actQuest[1]+1)+"/"+StLI.size());
        jlTitBarras.setText(StLI.get(actQuest[1]).getQuest(foo));
        
    }
    public void nextImaQ(){
        //if(actQuest[0]==0){return;}
        actQuest[2]++;
        if(actQuest[2]==StIQ.size()){actQuest[2]--;return;}
        jtfImaSELCont.setText((actQuest[2]+1)+"/"+StIQ.size());
        jlTitImaSel.setText(StIQ.get(actQuest[2]).getQuest(foo));
        setTPimaQ(); 
    }
    public void prevImaQ(){
        if(actQuest[2]==0){return;}
        actQuest[2]--;
        jtfImaSELCont.setText((actQuest[2]+1)+"/"+StIQ.size());
        jlTitImaSel.setText(StIQ.get(actQuest[2]).getQuest(foo));
        setTPimaQ(); 
    }
    
    public void nextQG(){
        //if(actQuest[0]==0){return;}
        actQuest[3]++;
        if(actQuest[3]==StIQ.size()){actQuest[2]--;return;}
        jtMTiCont.setText((actQuest[3]+1)+"/"+StQG.size());
        jlTiMT1.setText(StQG.get(actQuest[3]).getQuest(foo));
        
    }
    public void prevQG(){
        if(actQuest[3]==0){return;}
        actQuest[3]--;
        jtMTiCont.setText((actQuest[3]+1)+"/"+StQG.size());
        jlTiMT1.setText(StQG.get(actQuest[3]).getQuest(foo));
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitulo = new javax.swing.JLabel();
        jTPPadre = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPGbarra = new javax.swing.JPanel();
        jlTitBarras = new org.jdesktop.swingx.JXLabel();
        jbLIAnt = new javax.swing.JButton();
        jtfLiCont = new javax.swing.JTextField();
        jbLINext = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jlTiMT1 = new org.jdesktop.swingx.JXLabel();
        jPRMT = new javax.swing.JPanel();
        jbMTAnt = new javax.swing.JButton();
        jtMTiCont = new javax.swing.JTextField();
        jbMTNext = new javax.swing.JButton();
        jpOAns = new javax.swing.JPanel();
        jlTitImaSel = new org.jdesktop.swingx.JXLabel();
        jPImaSel = new javax.swing.JPanel();
        jTFCima1 = new javax.swing.JTextField();
        jPIma1 = new JPanelConFondo("../ima/cuadricula.png");
        jPIma2 = new JPanelConFondo("../ima/cuadricula.png");
        jTFCima2 = new javax.swing.JTextField();
        jPima3 = new JPanelConFondo("../ima/cuadricula.png");
        jTFCima3 = new javax.swing.JTextField();
        jpIma4 = new JPanelConFondo("../ima/cuadricula.png");
        jTFCima4 = new javax.swing.JTextField();
        jbImaSelAnt = new javax.swing.JButton();
        jtfImaSELCont = new javax.swing.JTextField();
        jbImaSelNext = new javax.swing.JButton();
        jPOR = new javax.swing.JPanel();
        jlTiOR = new org.jdesktop.swingx.JXLabel();
        jPORTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbORAnt = new javax.swing.JButton();
        jtMTOPCont = new javax.swing.JTextField();
        jbORNext = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(980, 640));

        jlTitulo.setBackground(new java.awt.Color(192, 192, 192));
        jlTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo.setText("jLabel1");
        jlTitulo.setOpaque(true);

        jPGbarra.setPreferredSize(new java.awt.Dimension(640, 480));

        javax.swing.GroupLayout jPGbarraLayout = new javax.swing.GroupLayout(jPGbarra);
        jPGbarra.setLayout(jPGbarraLayout);
        jPGbarraLayout.setHorizontalGroup(
            jPGbarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        jPGbarraLayout.setVerticalGroup(
            jPGbarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        jlTitBarras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitBarras.setText("jXLabel1");
        jlTitBarras.setLineWrap(true);
        jlTitBarras.setTextAlignment(org.jdesktop.swingx.JXLabel.TextAlignment.CENTER);

        jbLIAnt.addActionListener(this);
        jbLIAnt.setText("jButton1");

        jtfLiCont.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfLiCont.setText("jTextField1");

        jbLINext.addActionListener(this);
        jbLINext.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlTitBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfLiCont)
                            .addComponent(jbLIAnt, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(jbLINext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPGbarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPGbarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlTitBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbLIAnt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtfLiCont, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbLINext, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jTPPadre.addTab("Like it Respuestas", jPanel1);

        jlTiMT1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTiMT1.setText("jXLabel1");
        jlTiMT1.setLineWrap(true);
        jlTiMT1.setTextAlignment(org.jdesktop.swingx.JXLabel.TextAlignment.CENTER);

        jPRMT.setPreferredSize(new java.awt.Dimension(640, 480));

        javax.swing.GroupLayout jPRMTLayout = new javax.swing.GroupLayout(jPRMT);
        jPRMT.setLayout(jPRMTLayout);
        jPRMTLayout.setHorizontalGroup(
            jPRMTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        jPRMTLayout.setVerticalGroup(
            jPRMTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        jbMTAnt.addActionListener(this);
        jbMTAnt.setText("jButton1");

        jtMTiCont.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtMTiCont.setText("jTextField1");

        jbMTNext.addActionListener(this);
        jbMTNext.setText("jButton1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlTiMT1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtMTiCont)
                            .addComponent(jbMTAnt, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(jbMTNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPRMT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPRMT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlTiMT1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbMTAnt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtMTiCont, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbMTNext, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jTPPadre.addTab("Mouse Tracking", jPanel2);

        jlTitImaSel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitImaSel.setText("jXLabel1");
        jlTitImaSel.setLineWrap(true);
        jlTitImaSel.setTextAlignment(org.jdesktop.swingx.JXLabel.TextAlignment.CENTER);

        jPImaSel.setPreferredSize(new java.awt.Dimension(640, 480));

        jTFCima1.setColumns(10);
        jTFCima1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTFCima1.setText("0");
        jTFCima1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFCima1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPIma1Layout = new javax.swing.GroupLayout(jPIma1);
        jPIma1.setLayout(jPIma1Layout);
        jPIma1Layout.setHorizontalGroup(
            jPIma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPIma1Layout.setVerticalGroup(
            jPIma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPIma2Layout = new javax.swing.GroupLayout(jPIma2);
        jPIma2.setLayout(jPIma2Layout);
        jPIma2Layout.setHorizontalGroup(
            jPIma2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPIma2Layout.setVerticalGroup(
            jPIma2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jTFCima2.setColumns(10);
        jTFCima2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTFCima2.setText("0");
        jTFCima2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFCima2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPima3Layout = new javax.swing.GroupLayout(jPima3);
        jPima3.setLayout(jPima3Layout);
        jPima3Layout.setHorizontalGroup(
            jPima3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPima3Layout.setVerticalGroup(
            jPima3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jTFCima3.setColumns(10);
        jTFCima3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTFCima3.setText("0");
        jTFCima3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFCima3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpIma4Layout = new javax.swing.GroupLayout(jpIma4);
        jpIma4.setLayout(jpIma4Layout);
        jpIma4Layout.setHorizontalGroup(
            jpIma4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jpIma4Layout.setVerticalGroup(
            jpIma4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jTFCima4.setColumns(10);
        jTFCima4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTFCima4.setText("0");
        jTFCima4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFCima4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPImaSelLayout = new javax.swing.GroupLayout(jPImaSel);
        jPImaSel.setLayout(jPImaSelLayout);
        jPImaSelLayout.setHorizontalGroup(
            jPImaSelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPImaSelLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPImaSelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPIma1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPima3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPImaSelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPImaSelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFCima1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFCima3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(jPImaSelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPIma2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpIma4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPImaSelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPImaSelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFCima2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFCima4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(72, 72, 72))
        );
        jPImaSelLayout.setVerticalGroup(
            jPImaSelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPImaSelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPImaSelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPImaSelLayout.createSequentialGroup()
                        .addComponent(jPIma2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTFCima2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpIma4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTFCima4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPImaSelLayout.createSequentialGroup()
                        .addComponent(jPIma1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTFCima1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPima3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTFCima3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jbImaSelAnt.addActionListener(this);
        jbImaSelAnt.setText("jButton1");

        jtfImaSELCont.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfImaSELCont.setText("jTextField1");

        jbImaSelNext.addActionListener(this);
        jbImaSelNext.setText("jButton1");

        javax.swing.GroupLayout jpOAnsLayout = new javax.swing.GroupLayout(jpOAns);
        jpOAns.setLayout(jpOAnsLayout);
        jpOAnsLayout.setHorizontalGroup(
            jpOAnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOAnsLayout.createSequentialGroup()
                .addGroup(jpOAnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpOAnsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlTitImaSel, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpOAnsLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jpOAnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfImaSELCont)
                            .addComponent(jbImaSelAnt, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(jbImaSelNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPImaSel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jpOAnsLayout.setVerticalGroup(
            jpOAnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOAnsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpOAnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpOAnsLayout.createSequentialGroup()
                        .addComponent(jlTitImaSel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbImaSelAnt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtfImaSELCont, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbImaSelNext, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPImaSel, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jTPPadre.addTab("Imagen Seleccionada", jpOAns);

        jlTiOR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTiOR.setText("jXLabel1");
        jlTiOR.setLineWrap(true);
        jlTiOR.setTextAlignment(org.jdesktop.swingx.JXLabel.TextAlignment.CENTER);

        jPORTabla.setPreferredSize(new java.awt.Dimension(640, 480));
        jPORTabla.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setViewportView(jTable1);

        jPORTabla.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jbORAnt.addActionListener(this);
        jbORAnt.setText("<-");

        jtMTOPCont.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtMTOPCont.setText("#/#");

        jbORNext.addActionListener(this);
        jbORNext.setText("->");

        javax.swing.GroupLayout jPORLayout = new javax.swing.GroupLayout(jPOR);
        jPOR.setLayout(jPORLayout);
        jPORLayout.setHorizontalGroup(
            jPORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPORLayout.createSequentialGroup()
                .addGroup(jPORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPORLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlTiOR, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPORLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtMTOPCont)
                            .addComponent(jbORAnt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbORNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPORTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPORLayout.setVerticalGroup(
            jPORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPORLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPORLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPORTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPORLayout.createSequentialGroup()
                        .addComponent(jlTiOR, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbORAnt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtMTOPCont, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbORNext, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jTPPadre.addTab("Respuestas Libres", jPOR);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTPPadre)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jlTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTPPadre))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTFCima1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFCima1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFCima1ActionPerformed

    private void jTFCima2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFCima2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFCima2ActionPerformed

    private void jTFCima3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFCima3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFCima3ActionPerformed

    private void jTFCima4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFCima4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFCima4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPGbarra;
    /*
    private javax.swing.JPanel jPIma1;
    */private JPanelConFondo jPIma1;
    /*
    private javax.swing.JPanel jPIma2;
    */private JPanelConFondo jPIma2;
    private javax.swing.JPanel jPImaSel;
    private javax.swing.JPanel jPOR;
    private javax.swing.JPanel jPORTabla;
    private javax.swing.JPanel jPRMT;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    /*
    private javax.swing.JPanel jPima3;
    */private JPanelConFondo jPima3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFCima1;
    private javax.swing.JTextField jTFCima2;
    private javax.swing.JTextField jTFCima3;
    private javax.swing.JTextField jTFCima4;
    private javax.swing.JTabbedPane jTPPadre;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbImaSelAnt;
    private javax.swing.JButton jbImaSelNext;
    private javax.swing.JButton jbLIAnt;
    private javax.swing.JButton jbLINext;
    private javax.swing.JButton jbMTAnt;
    private javax.swing.JButton jbMTNext;
    private javax.swing.JButton jbORAnt;
    private javax.swing.JButton jbORNext;
    private org.jdesktop.swingx.JXLabel jlTiMT1;
    private org.jdesktop.swingx.JXLabel jlTiOR;
    private org.jdesktop.swingx.JXLabel jlTitBarras;
    private org.jdesktop.swingx.JXLabel jlTitImaSel;
    private javax.swing.JLabel jlTitulo;
    /*
    private javax.swing.JPanel jpIma4;
    */private JPanelConFondo jpIma4;
    private javax.swing.JPanel jpOAns;
    private javax.swing.JTextField jtMTOPCont;
    private javax.swing.JTextField jtMTiCont;
    private javax.swing.JTextField jtfImaSELCont;
    private javax.swing.JTextField jtfLiCont;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jbORNext) nextORQ();
        if(e.getSource()==jbORAnt) prevORQ();
    }
}
