package estructuras;

import java.io.*;
import java.lang.*;
import java.util.*;

public class StructQuestGrid extends StructQuest implements Serializable {
private String dir;
private int tipo;

    public StructQuestGrid(String [] preg) {
    	super(preg);
    }
    
    public StructQuestGrid(String [] preg,String dir){
    super(preg);
    this.dir=dir;	
    }
    
    public String getDir(){
    return dir;	
    }
}