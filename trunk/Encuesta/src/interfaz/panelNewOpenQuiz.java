/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import estructuras.Survey;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Ascalero
 */
public class panelNewOpenQuiz extends javax.swing.JPanel implements ActionListener {

    /**
     * Creates new form NewJPanel
     */

    // Variables declaration - do not modify
    private int foo;
    private DefaultListModel<String> modeloLista;
    private String strtmp[]= new String[4];
    private Survey structura;
    private javax.swing.JPanel JpanelSTQ1;
    private javax.swing.ButtonGroup butG1;
    private javax.swing.ButtonGroup butG2;
    private javax.swing.JButton jBANE;
    private javax.swing.JButton jBIQima1;
    private javax.swing.JButton jBIQima2;
    private javax.swing.JButton jBIQima3;
    private javax.swing.JButton jBIQima4;
    private javax.swing.JButton jBaddQGrid;
    private javax.swing.JLabel jLNoPreg;
    private javax.swing.JLabel jLTitQL;
    private javax.swing.JLabel jLTypePre;
    private javax.swing.JList jListPregs;
    private javax.swing.JPanel jPGridQ;
    private javax.swing.JRadioButton jRBBlanco;
    private javax.swing.JRadioButton jRBLibre;
    private javax.swing.JRadioButton jRBLikeIt;
    private javax.swing.JRadioButton jRBMalla;
    private javax.swing.JRadioButton jRBPregLibre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAddIQ;
    private javax.swing.JButton jbaddNQ;
    private javax.swing.JComboBox jcbTyprepreg;
    private javax.swing.JLabel jlInsGrid;
    private javax.swing.JLabel jlPregAle;
    private javax.swing.JLabel jlPregENG;
    private javax.swing.JLabel jlPregEsp;
    private javax.swing.JLabel jlPregFra;
    private javax.swing.JLabel jlTitCIQ;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JLabel jldirIQ1;
    private javax.swing.JLabel jldirIQ2;
    private javax.swing.JLabel jldirIQ3;
    private javax.swing.JLabel jldirIQ4;
    private javax.swing.JLabel jltittlepreg;
    private javax.swing.JPanel jpImaQ;
    private javax.swing.JTextField jtfpreg1;
    private javax.swing.JTextField jtfpreg2;
    private javax.swing.JTextField jtfpreg3;
    private javax.swing.JTextField jtfpreg4;
    private org.jdesktop.swingx.JXPanel paneltipo;
    private CardLayout cLtypePreg;
    // End of variables declaration



    public panelNewOpenQuiz(int foobar) {
        foo=foobar;
        structura= new Survey("nuevo");
        initComponents();
        setIdioma(foo);
    }
    
    public void setSruct(Survey xyz){
        structura=xyz;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Inicializacion de componentes">
    private void initComponents() {
        cLtypePreg=new CardLayout();
        
        butG1 = new javax.swing.ButtonGroup();
        butG2 = new javax.swing.ButtonGroup();
        jlTitulo = new javax.swing.JLabel();
        jLNoPreg = new javax.swing.JLabel();
        jlPregEsp = new javax.swing.JLabel();
        jlPregENG = new javax.swing.JLabel();
        jlPregAle = new javax.swing.JLabel();
        jlPregFra = new javax.swing.JLabel();
        jtfpreg1 = new javax.swing.JTextField();
        jtfpreg2 = new javax.swing.JTextField();
        jtfpreg3 = new javax.swing.JTextField();
        jtfpreg4 = new javax.swing.JTextField();
        jcbTyprepreg = new javax.swing.JComboBox();
        jcbTyprepreg.addActionListener(this);
        jLTypePre = new javax.swing.JLabel();
        paneltipo = new org.jdesktop.swingx.JXPanel();
        jpImaQ = new javax.swing.JPanel();
        jBIQima1 = new javax.swing.JButton();
        jBIQima2 = new javax.swing.JButton();
        jBIQima3 = new javax.swing.JButton();
        jBIQima4 = new javax.swing.JButton();
        jldirIQ1 = new javax.swing.JLabel();
        jldirIQ2 = new javax.swing.JLabel();
        jldirIQ3 = new javax.swing.JLabel();
        jldirIQ4 = new javax.swing.JLabel();
        jlTitCIQ = new javax.swing.JLabel();
        jbAddIQ = new javax.swing.JButton();
        JpanelSTQ1 = new javax.swing.JPanel();
        jbaddNQ = new javax.swing.JButton();
        jRBLikeIt = new javax.swing.JRadioButton();
        jRBPregLibre = new javax.swing.JRadioButton();
        jLTitQL = new javax.swing.JLabel();
        jPGridQ = new javax.swing.JPanel();
        jRBBlanco = new javax.swing.JRadioButton();
        jRBMalla = new javax.swing.JRadioButton();
        jRBLibre = new javax.swing.JRadioButton();
        jlInsGrid = new javax.swing.JLabel();
        jBaddQGrid = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListPregs = new javax.swing.JList();
        jltittlepreg = new javax.swing.JLabel();
        jBANE = new javax.swing.JButton();

        setAutoscrolls(true);

        jlTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo.setText("Titulo");
        jlTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlTitulo.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        jLNoPreg.setText("Pregunta 1");

        jlPregEsp.setText("jLabel3");

        jlPregENG.setText("jLabel4");

        jlPregAle.setText("jLabel5");

        jlPregFra.setText("jLabel6");

        jtfpreg1.setText("");

        jtfpreg2.setText("");

        jtfpreg3.setText("");

        jtfpreg4.setText("");

        

        jLTypePre.setText("jLabel7");

        paneltipo.setBorder(javax.swing.BorderFactory.createTitledBorder("Text"));
        paneltipo.setLayout(cLtypePreg);

        jBIQima1.setText("jButton1");
        jBIQima1.addActionListener(this);

        jBIQima2.setText("jButton2");
        jBIQima1.addActionListener(this);
        jBIQima3.setText("jButton3");
        jBIQima1.addActionListener(this);
        jBIQima4.setText("jButton4");
        jBIQima1.addActionListener(this);
        jldirIQ1.setText("...");

        jldirIQ2.setText("...");

        jldirIQ3.setText("...");

        jldirIQ4.setText("...");

        jlTitCIQ.setText("jLabel6");

        jbAddIQ.setText("jButton5");
        jbAddIQ.addActionListener(this);

        javax.swing.GroupLayout jpImaQLayout = new javax.swing.GroupLayout(jpImaQ);
        jpImaQ.setLayout(jpImaQLayout);
        jpImaQLayout.setHorizontalGroup(
            jpImaQLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpImaQLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpImaQLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpImaQLayout.createSequentialGroup()
                        .addGroup(jpImaQLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpImaQLayout.createSequentialGroup()
                                .addComponent(jBIQima2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jldirIQ2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jpImaQLayout.createSequentialGroup()
                                .addComponent(jBIQima3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jldirIQ3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jpImaQLayout.createSequentialGroup()
                                .addComponent(jBIQima1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jldirIQ1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpImaQLayout.createSequentialGroup()
                                .addComponent(jBIQima4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpImaQLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbAddIQ)
                                    .addComponent(jldirIQ4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpImaQLayout.createSequentialGroup()
                        .addGap(0, 39, Short.MAX_VALUE)
                        .addComponent(jlTitCIQ, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(232, 232, 232))))
        );
        jpImaQLayout.setVerticalGroup(
            jpImaQLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpImaQLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitCIQ, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpImaQLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBIQima1)
                    .addComponent(jldirIQ1))
                .addGap(18, 18, 18)
                .addGroup(jpImaQLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBIQima2)
                    .addComponent(jldirIQ2))
                .addGap(18, 18, 18)
                .addGroup(jpImaQLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBIQima3)
                    .addComponent(jldirIQ3))
                .addGap(18, 18, 18)
                .addGroup(jpImaQLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBIQima4)
                    .addComponent(jldirIQ4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbAddIQ)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        

        paneltipo.add(jpImaQ, "imaQ");

        jbaddNQ.setText("Agregar");
        jbaddNQ.addActionListener(this);

        jRBLikeIt.setText("jRadioButton1");

        jRBPregLibre.setText("jRadioButton2");
        butG1.add(jRBLikeIt);
        butG1.add(jRBPregLibre);

        jLTitQL.setText("jLabel121");

        javax.swing.GroupLayout JpanelSTQ1Layout = new javax.swing.GroupLayout(JpanelSTQ1);
        JpanelSTQ1.setLayout(JpanelSTQ1Layout);
        JpanelSTQ1Layout.setHorizontalGroup(
            JpanelSTQ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelSTQ1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(JpanelSTQ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBPregLibre)
                    .addComponent(jRBLikeIt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(jbaddNQ, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
            .addGroup(JpanelSTQ1Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLTitQL, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        JpanelSTQ1Layout.setVerticalGroup(
            JpanelSTQ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelSTQ1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLTitQL, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(JpanelSTQ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JpanelSTQ1Layout.createSequentialGroup()
                        .addComponent(jRBLikeIt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBPregLibre))
                    .addComponent(jbaddNQ, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(143, Short.MAX_VALUE))
        );

        paneltipo.add(JpanelSTQ1, "QorLI");

        jRBBlanco.setText("jRadioButton1");

        jRBMalla.setText("jRadioButton2");

        jRBLibre.setText("jRadioButton3");

        jlInsGrid.setText("jLabel1");

        jBaddQGrid.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPGridQ);
        jPGridQ.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRBBlanco)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRBMalla)
                                    .addComponent(jRBLibre))
                                .addGap(67, 67, 67)
                                .addComponent(jBaddQGrid, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jlInsGrid, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jlInsGrid)
                .addGap(18, 18, 18)
                .addComponent(jRBBlanco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRBMalla)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRBLibre))
                    .addComponent(jBaddQGrid, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        paneltipo.add(jPGridQ, "grid");
        modeloLista= new DefaultListModel<String>();
        jListPregs.setModel(modeloLista);
        jScrollPane1.setViewportView(jListPregs);

        jltittlepreg.setText("jLabel3");

        jBANE.setText("jButton1");
        jBANE.addActionListener(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLTypePre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcbTyprepreg, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jlPregENG)
                                            .addComponent(jlPregEsp)
                                            .addComponent(jlPregAle)
                                            .addComponent(jlPregFra))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jtfpreg1)
                                            .addComponent(jtfpreg2)
                                            .addComponent(jtfpreg3)
                                            .addComponent(jtfpreg4, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(paneltipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLNoPreg))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jltittlepreg, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBANE, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                        .addGap(0, 68, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLNoPreg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlPregEsp)
                            .addComponent(jtfpreg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jltittlepreg)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlPregENG)
                            .addComponent(jtfpreg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlPregAle)
                            .addComponent(jtfpreg3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlPregFra)
                            .addComponent(jtfpreg4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbTyprepreg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLTypePre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(paneltipo, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBANE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        
        butG2.add(jRBLibre);
        butG2.add(jRBBlanco);
        butG2.add(jRBMalla);
    }// </editor-fold>
    
    public String[] getDirtion(){
    return null;
    }
    
    public String[] getStringQuest(){
    String[] beta= new String[4];
        strtmp[0]="Falta Traduccion";strtmp[1]="Missing Translation";strtmp[2]="fehlende Übersetzung";strtmp[3]="Traduction manquante";
        if (jtfpreg1.getText().equals("")){jtfpreg1.requestFocus();
            JOptionPane.showMessageDialog(null,strtmp[foo],"MSG",JOptionPane.INFORMATION_MESSAGE);
            return null;}
        beta[0]=jtfpreg1.getText();
        if (jtfpreg2.getText().equals("")){jtfpreg2.requestFocus();
            JOptionPane.showMessageDialog(null,strtmp[foo],"MSG",JOptionPane.INFORMATION_MESSAGE);
            return null;}
        beta[1]=jtfpreg2.getText();
        if (jtfpreg3.getText().equals("")){jtfpreg3.requestFocus();
            JOptionPane.showMessageDialog(null,strtmp[foo],"MSG",JOptionPane.INFORMATION_MESSAGE);
            return null;}
        beta[2]=jtfpreg3.getText();
        if (jtfpreg4.getText().equals("")){jtfpreg4.requestFocus();
            JOptionPane.showMessageDialog(null,strtmp[foo],"MSG",JOptionPane.INFORMATION_MESSAGE);
            return null;}
        beta[3]=jtfpreg4.getText();
        return beta;
    }
    
    public void setIdioma(int foobar){
        foo=foobar;
        strtmp[0]="Proyecto: "+structura.getName();strtmp[1]="Project: "+structura.getName();strtmp[2]="Projekt: "+structura.getName();strtmp[3]="projet: "+structura.getName(); 
        jlTitulo.setText(strtmp[foo]);
        strtmp[0]="Pregunta: "+(structura.getActSize()+1);strtmp[1]="Question: "+(structura.getActSize()+1);strtmp[2]="Frage: "+(structura.getActSize()+1);strtmp[3]="question: "+(structura.getActSize()+1); 
        jLNoPreg.setText(strtmp[foo]);
        strtmp[0]="Español";strtmp[1]="Spanish";strtmp[2]="Spanisch";strtmp[3]="Espagnol"; 
        jlPregEsp.setText(strtmp[foo]);
        strtmp[0]="Ingles";strtmp[1]="English";strtmp[2]="Englisch";strtmp[3]="Anglais"; 
        jlPregENG.setText(strtmp[foo]);
        strtmp[0]="Aleman";strtmp[1]="Detush";strtmp[2]="Deutsch";strtmp[3]="Allemand"; 
        jlPregAle.setText(strtmp[foo]);
        strtmp[0]="Frances";strtmp[1]="French";strtmp[2]="Französisch";strtmp[3]="Français"; 
        jlPregFra.setText(strtmp[foo]);
        strtmp[0]="Selecciona Tipo Pregunta";strtmp[1]="Select type of question";strtmp[2]="Wählen Sie die Art von Frage";strtmp[3]="Sélectionnez le type de question"; 
        jLTypePre.setText(strtmp[foo]);
        if(jcbTyprepreg.getSelectedIndex()!=-1){
            int a= jcbTyprepreg.getSelectedIndex();
            setTypePreg(jcbTyprepreg);
            jcbTyprepreg.setSelectedIndex(a);
        }else setTypePreg(jcbTyprepreg);
        strtmp[0]="Selecciona Libre o LikeIT";strtmp[1]="Select Free or Like IT";strtmp[2]="ählen frei oder wie es";strtmp[3]="Sélectionnez libre ou comme il";
        jLTitQL.setText(strtmp[foo]);
        strtmp[0]="Respuesta libre";strtmp[1]="Free answer";strtmp[2]="frei";strtmp[3]="Libre";
        jRBPregLibre.setText(strtmp[foo]);
        strtmp[0]="Like It";strtmp[1]="Like It";strtmp[2]="wie es";strtmp[3]="comme il";
        jRBLikeIt.setText(strtmp[foo]);
        strtmp[0]="Agrega las 4 imagenes";strtmp[1]="Add the 4 images";strtmp[2]="Fügen Sie die 4 Bilder";strtmp[3]="Ajouter les 4 images";
        jlTitCIQ.setText(strtmp[foo]);
        strtmp[0]="Buscar";strtmp[1]="Search";strtmp[2]="suchen";strtmp[3]="Rechercher";
        jBIQima1.setText(strtmp[foo]);
        jBIQima2.setText(strtmp[foo]);
        jBIQima3.setText(strtmp[foo]);
        jBIQima4.setText(strtmp[foo]);
        strtmp[0]="Agregar";strtmp[1]="ADD NEW";strtmp[2]="hinzufügen neuer";strtmp[3]="ajouter de nouveaux";
        jbAddIQ.setText(strtmp[foo]);
        jBaddQGrid.setText(strtmp[foo]);
        jbaddNQ.setText(strtmp[foo]);
        strtmp[0]="Selecciona el fondo para traking";
        strtmp[1]="Select a backgroud for tracking";
        strtmp[2]="Wählen Sie ein Hintergrundbild für die Verfolgung von";
        strtmp[3]="Sélectionnez un arrière-plan pour le suivi";
        jlInsGrid.setText(strtmp[foo]);
        strtmp[0]="En blanco";strtmp[1]="Blank";strtmp[2]="leer";strtmp[3]="vide";
        jRBBlanco.setText(strtmp[foo]);
        strtmp[0]="Malla";strtmp[1]="Grid";strtmp[2]="leer";strtmp[3]="grille";
        jRBMalla.setText(strtmp[foo]);
        strtmp[0]="Imagen";strtmp[1]="Image";strtmp[2]="Image";strtmp[3]="Image";
        jRBLibre.setText(strtmp[foo]);
        strtmp[0]="Guardar Encuesta";strtmp[1]="Save Survey";strtmp[2]="Speichern Umfrage";strtmp[3]="Enregistrer Enquête";
        jBANE.setText(strtmp[foo]);
        strtmp[0]="Lista";strtmp[1]="List";strtmp[2]="Liste";strtmp[3]="List";
        jltittlepreg.setText(strtmp[foo]);
        UpdateList(structura.cloneSurvey());
        
    }
    
    public void  UpdateList(Survey a){
        limpiaList(modeloLista);
        
        a.printvalseq();
        if(a.isEmpy())return;
        
        a.resetActuales();
        
        do{
        
            int val=a.getNext();
        
            switch (val){
                case 0:
                    modeloLista.addElement(a.getNextStq().getQuest(foo));
                    break;
                case 1:
                    modeloLista.addElement(a.getNextLI().getQuest(foo));
                    break;
                case 2:
                    modeloLista.addElement(a.getNextStIQ().getQuest(foo));
                    break;
                case 3:
                    modeloLista.addElement(a.getNextQG().getQuest(foo));
                    break;
            }
        }while(!a.islast());
        
        
    }
    
    
    private void setBorderFactory(int type){
        String val[]= new String[3];
        switch(foo){
            case 0 :val[0]="Libre o LikeIt";val[1]="Selecciona Imagen";val[2]="MouseTraking";break;
            case 1 :val[0]="Free or Like IT";val[1]="Select Image";val[2]="MouseTraking";break;
            case 2 :val[0]="frei oder wie es";val[1]="Wählen Sie das Bild";val[2]="MouseTraking";break;
            case 3 :val[0]="libre ou comme il";val[1]="Cliquez sur l'image";val[2]="MouseTraking";break;
            default :val[0]="";val[1]="";val[2]="";break;
        }
    paneltipo.setBorder(BorderFactory.createTitledBorder(val[type]));
    }
    
    
    private void setTypePreg(JComboBox jcb){
        eraseDataJcb(jcb);
        Object[] val=new Object[3];
        
        switch(foo){
            case 0 :val[0]="Libre o LikeIt";val[1]="Selecciona Imagen";val[2]="MouseTraking";break;
            case 1 :val[0]="Free or Like IT";val[1]="Select Image";val[2]="MouseTraking";break;
            case 2 :val[0]="libre ou comme il";val[1]="Wählen Sie das Bild";val[2]="MouseTraking";break;
            case 3 :val[0]="frei oder wie es";val[1]="Cliquez sur l'image";val[2]="MouseTraking";break;
            default :val[0]="";val[1]="";val[2]="";break;
            
        }
        for(Object a:val){
            jcb.addItem(a);
        }
    }
    public void limpiaCampos(){
        jtfpreg1.setText("");
        jtfpreg2.setText("");
        jtfpreg3.setText("");
        jtfpreg4.setText("");
        jldirIQ1.setText("...");
        jldirIQ2.setText("...");
        jldirIQ3.setText("...");
        jldirIQ4.setText("...");
        
    }
    
    public void limpiaList(DefaultListModel<String> a){
    a.removeAllElements();
    }
    public void addToList(String var){
    modeloLista.addElement(var);
    }
    public void limpiapanel(){
        setIdioma(foo);
        limpiaCampos();
        limpiaList(modeloLista);
    }
    private void eraseDataJcb(JComboBox d){
        d.removeAllItems();
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jbaddNQ){
            String quest[];
            if(getStringQuest()==null) return;
            quest=getStringQuest();
            if(jRBPregLibre.isSelected()){
                structura.addStQ(quest);
                UpdateList(structura.cloneSurvey());
                limpiaCampos();
            }
            if(jRBLikeIt.isSelected()){
                structura.addStLI(quest);
                UpdateList(structura.cloneSurvey());
                limpiaCampos();
            }
        }
        if(e.getSource()==jbAddIQ){
            
        }
        
        try{
        if (e.getSource()==jcbTyprepreg){
            int val=jcbTyprepreg.getSelectedIndex();
            setBorderFactory(val);
            switch(val){
                case 0:
                    
                    cLtypePreg.show(paneltipo, "QorLI");
                    break;
                case 1:
                    cLtypePreg.show(paneltipo, "imaQ");
                    break;
                case 2:
                    cLtypePreg.show(paneltipo, "grid");
                    break;
                    
            }
        }
        }catch(ArrayIndexOutOfBoundsException aib){};
    }
}
