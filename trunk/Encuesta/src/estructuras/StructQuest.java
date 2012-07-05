package  estructuras;

import java.lang.*;
import java.io.*;
import java.util.*;

public class StructQuest implements Serializable {
private String [] preguntas;
    
    public StructQuest(String [] preg) {
     preguntas=preg;
    	for(int i=0;i<preguntas.length;i++)
    		System.out.println("Las preguntas son: "+preguntas[i]);     //Solo para verificiar que el arreglo esta correto
    }
     public String getQuest (int idioma){
    	return preguntas[idioma];
    }
}