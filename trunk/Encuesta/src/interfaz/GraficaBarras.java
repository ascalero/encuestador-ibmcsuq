package interfaz;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 *
 * @author Shadow
 */
public class GraficaBarras extends JPanelConFondo{
    
    private DefaultCategoryDataset dataset;
    private String nameProy;
    
    public GraficaBarras(String nameProy) {
        this.nameProy=nameProy;
        dataset = new DefaultCategoryDataset();
    }
    public void setTittle(String tmp){
    nameProy=tmp;
    }
    
    public void setDatos(ArrayList<String> nameEnc,int[] answer,String name){
        if (nameEnc!=null){
            for(int i=0;i< nameEnc.size();i++){
                dataset.addValue(answer[i], name, nameEnc.get(i));
            }
            JFreeChart graficoBarras = ChartFactory.createBarChart( 
                nameProy,        //Nombre del Proyecto 
                "Usuarios",      //etiqueta Eje horizontal 
                "Opciones",      //etiqueta Eje vertical 
                dataset,                   //datos 
                PlotOrientation.VERTICAL,  //orientación 
                true,                      //incluir leyendas 
                true,                      //mostrar tooltips 
                true);
        
            this.setImagen(graficoBarras.createBufferedImage(640,480));
        }
    }
}

