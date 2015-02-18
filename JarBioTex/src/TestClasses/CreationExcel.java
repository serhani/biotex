/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;
import BioTex.Execution;
import CommonResources.MathFonctions;
import Object.CandidatTerm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


/**
 *
 * @author juanlossio
 */
public class CreationExcel {

    /**
     * @param args the command line arguments
     */
	static HashMap<String, Integer> Terms = new HashMap<String, Integer>(); 
    static ArrayList<CandidatTerm> list_candidat_terms_validated = new ArrayList<CandidatTerm>();
    
    static String language = "english"; // english  french
    static String[] measures={"TFIDF_M","TFIDF_S","TFIDF_A",
    							"Okapi_M","Okapi_S","Okapi_A",
    							"F-OCapi_M","F-OCapi_S","F-OCapi_A",
    							"F-TFIDF-C_M","F-TFIDF-C_S","F-TFIDF-C_A"};
    static String type_term = "multi";  //
    static String sourceSingle = "/Volumes/MacintoshDocuments/TextDataBases/Z_SingleFile/DRUG_EN.txt";
    static String sourceMany = "/Volumes/MacintoshDocuments/TextDataBases/Z_ManyFiles/DRUG_EN.txt";
    
    //static String sourceOUT = "/Volumes/MacintoshDocuments/TextDataBases/ResultDRUG/" + language + "/" + type_term + "/";  //
    static String sourceOUT = "/Volumes/MacintoshDocuments/TextDataBases/ResultDRUG/" + type_term + "/";  //

    public static void main(String[] args) {        
        /*
         * Language : english, french 
         * number_patrons : number of first pattern to take into account 
         * typeTerms : all (single word + multi words terms), multi (multi words terms) 
         * measure = 19 possible measures 
         * tool_Tagger il sera TreeTagger ou Stanford pour l'anglais
        */  
    	//list_candidat_terms_validated = Execution.main_execution(language,200,type_term,"C_value",1,sourceSingle,"TreeTagger");
    	createFile("C_value.txt");
    	//merge();
    	
    	for(int i=0;i<measures.length;i++){
    		list_candidat_terms_validated = new ArrayList<CandidatTerm>();
    		//list_candidat_terms_validated = Execution.main_execution(language,200,type_term,measures[i],2,sourceMany,"TreeTagger");
        	createFile(measures[i]+".txt");
    		//merge();
    	}
        //show_list_terms();
    }
    
    private static void merge(){
        int count = 0;
        for(int i=0;i<list_candidat_terms_validated.size();i++){
        	if(list_candidat_terms_validated.get(i).getIsTrueTerm()==0){
        		Terms.put(list_candidat_terms_validated.get(i).getTerm(), list_candidat_terms_validated.get(i).getIsTrueTerm());
        		count++;
        	}
        	if(count == 40){
        		break;
        	}
        }
    }
    
    private static void show_list_terms(){
    	for( Iterator<String> it = Terms.keySet().iterator(); it.hasNext();) {
            String key = (String)it.next();
            System.out.println(key);
        }
    }
    
    private static void createFile(String measure){
    	try{
            FileWriter frArchivoWrite = new FileWriter(sourceOUT+"/"+measure);
            BufferedWriter bw =  new BufferedWriter(frArchivoWrite);
            
            for(int i=0;i<900;i++){
            	bw.write(list_candidat_terms_validated.get(i).getTerm().trim());
            	bw.newLine();
            }
            
            bw.close();
            frArchivoWrite.close();
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    
}
