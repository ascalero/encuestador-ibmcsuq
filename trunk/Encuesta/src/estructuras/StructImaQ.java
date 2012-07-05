package estructuras;

import java.io.*;
import java.lang.*;
import java.util.*;

public class StructImaQ extends StructQuest implements Serializable{
private String []imaDir;
    
    public StructImaQ(String []preg,String []imDir) {
    super (preg);
    this.imaDir=imaDir;	
    }
    
    public String  [] getDir(){
    	return imaDir;
    }
}