package estructuras;

import java.io.*;
import java.lang.*;
import java.util.*;

public class StructImaQ extends StructQuest implements Serializable,Cloneable{
private String []imaDir;
    
    public StructImaQ(String []preg,String []imDir) {
    super (preg);
    this.imaDir=imDir;	
    }
    
    public String  [] getDir(){
        return imaDir;
    }

    @Override
    public String getQuest(int idioma) {
        return super.getQuest(idioma);
    }
    
    
    
}