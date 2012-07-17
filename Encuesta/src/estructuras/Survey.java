/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ascalero
 */
public class Survey implements Serializable,Cloneable{
    String folder;
    String Name;
    transient int actual=0;
    transient int actQuest[]=new int[4];
    ArrayList<Integer> SeqSurvey= new ArrayList<Integer>();
    ArrayList<StructQuest> StQ=new ArrayList<StructQuest>();
    ArrayList<StructImaQ> StIQ=new ArrayList<StructImaQ>();
    ArrayList<StructLikeIt> StLI = new ArrayList<StructLikeIt>();
    ArrayList<StructQuestGrid> StQG = new ArrayList<StructQuestGrid>();

    public Survey(String name) {
        this.Name = name;
        this.folder= "c:/enques/data/"+name;
        for(int a:actQuest){a=0;}
    }
    
    public int getNext(){
        return SeqSurvey.get(actual++);
    }
    public int getPrev(){ 
        if (actual==0) return -1;
        return SeqSurvey.get(actual--);
    }
    public int getActSize(){
    return SeqSurvey.size();
    }
    
    public StructQuest getNextStq(){
        int val=actQuest[0]++;
        System.out.println("netxstq val:"+val);
        return StQ.get(val);
    }
    public StructLikeIt getNextLI(){
        return StLI.get(actQuest[1]++);
    }
    public StructImaQ getNextStIQ(){
        return StIQ.get(actQuest[2]++);
    }
    public StructQuestGrid getNextQG(){
        return StQG.get(actQuest[3]++);
    }
    public StructQuest getPrevStq(){
        return StQ.get(actQuest[0]--);
    }
    public StructLikeIt getPrevLI(){
        return StLI.get(actQuest[1]--);
    }
    public StructImaQ getPrevStIQ(){
        return StIQ.get(actQuest[2]--);
    }
    public StructQuestGrid getPrevQG(){
        return StQG.get(actQuest[3]--);
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
        StQ.add(temp);
        SeqSurvey.add(0);
    }
    public void addStIQ(String [] quest,String [] ImadiR){
        StructImaQ temp= new StructImaQ(quest, ImadiR);
        StIQ.add(temp);
        SeqSurvey.add(2);
    }
    public void addStLI(String[]... preg){
        StructLikeIt temp;
        if (preg.length==1){
        temp = new StructLikeIt(preg[0]);
        }else{
         temp = new StructLikeIt(preg[0],preg[1],preg[2]);
        }
        StLI.add(temp);
        SeqSurvey.add(1);
    }
    
    public void addStQG (){
        SeqSurvey.add(2);
    }
    
    public boolean isEmpy(){
    return SeqSurvey.isEmpty();
    }
    public boolean islast(){
        if((actual)==SeqSurvey.size())return true;
        return false;
    }
    
    public void resetActuales(){
    actual=0;
    for(int i=0;i<actQuest.length;i++){
    actQuest[i]=0;
    }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    public Survey cloneSurvey(){
        try {
            return (Survey)clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Survey.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void printvalseq(){
    for (int a:SeqSurvey){
        System.out.print("valiter"+a);
    }
    }
    
    
}
