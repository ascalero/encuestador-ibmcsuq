package estructuras;

import java.io.*;
import java.lang.*;
import java.util.*;

public class StructLikeIt extends StructQuest implements Serializable ,Cloneable{
private String []min;
private String []max;


    public StructLikeIt(String [] preg) {
    	super(preg);    	
     }
    public StructLikeIt(String [] preg,String [] max,String [] min) {
    	super(preg);
       	this.max=max;
    	this.min=min;
    }
    public String getmin(int idioma){
    	return min[idioma];
    }
    public String getmax(int idioma){
    	return max[idioma];
    }

    @Override
    public String getQuest(int idioma) {
        return super.getQuest(idioma);
    }
    
      
}