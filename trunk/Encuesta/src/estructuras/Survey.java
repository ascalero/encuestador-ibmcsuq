/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Ascalero
 */
public class Survey implements Serializable{
    String folder;
    String Name;
    transient int actual=0;
    transient int actQuest[]=new int[4];
    ArrayList<Integer> SeqSurvey= new ArrayList<Integer>();
    ArrayList<StructQuest> StQ=new ArrayList<StructQuest>();
    ArrayList<StructImaQ> StIQ=new ArrayList<StructImaQ>();
    ArrayList<StructLikeIt> StLI = new ArrayList<StructLikeIt>();
    ArrayList<StructQuestGrid> StQG = new ArrayList<StructQuestGrid>();

    public Survey(String folder, String Name) {
        this.folder = folder;
        this.Name = Name;
        for(int a:actQuest){a=0;}
    }
    
    
    
    public int getNext(){
        actual++;
        return SeqSurvey.get(actual-1);
    }
    public int getPrev(){ 
        if (actual==0) return -1;
        actual--;
        return SeqSurvey.get(actual+1);
    }
    public StructQuest getNextStq(){
        actQuest[0]++;
        return StQ.get(actQuest[0]-1);
    }
    public StructImaQ getNextStIQ(){
        actQuest[1]++;
        return StIQ.get(actQuest[1]-1);
    }
    public StructLikeIt getNextLI(){
        actQuest[2]++;
        return StLI.get(actQuest[2]-1);
    }
    public StructQuestGrid getNextQG(){
        actQuest[3]++;
        return StQG.get(actQuest[3]-1);
    }
    public StructQuest getPrevStq(){
        actQuest[0]--;
        return StQ.get(actQuest[0]+1);
    }
    public StructImaQ getPrevStIQ(){
        actQuest[1]--;
        return StIQ.get(actQuest[1]+1);}
    public StructLikeIt getPrevLI(){
        actQuest[2]--;
        return StLI.get(actQuest[2]+1);
    }
    public StructQuestGrid getPrevQG(){
        actQuest[3]--;
        return StQG.get(actQuest[3]+1);
    }

    public String getFolder() {
        return folder;
    }

    public String getName() {
        return Name;
    }
    
    
    
    //bloque adds
    public void addStQ(String[] quest){
        StructQuest temp= new StructQuest(quest);
        StQ.add(null);
        SeqSurvey.add(0);
    }
    public void addStIQ(String [] quest,String [] ImadiR){
        StructImaQ temp= new StructImaQ(quest, ImadiR);
        StIQ.add(temp);
        SeqSurvey.add(1);
    }
    public void addStLI(String[]... preg){
        StructLikeIt temp;
        if (preg.length==1){
        temp = new StructLikeIt(preg[0]);
        }else{
         temp = new StructLikeIt(preg[0],preg[1],preg[2]);
        }
        StLI.add(temp);
        SeqSurvey.add(2);
    }
    
    public void addStQG (){
     SeqSurvey.add(4);
    }
    
}
