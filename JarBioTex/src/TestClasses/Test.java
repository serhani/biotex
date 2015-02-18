/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;
import BioTex.Execution;
import Object.CandidatTerm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;


/**
 *
 * @author juanlossio
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    static ArrayList<CandidatTerm> list_candidat_terms_validated = new ArrayList<CandidatTerm>();
    
    public static void main(String[] args) {        
        /*
         * Language : english, french 
         * number_patrons : number of first pattern to take into account 
         * typeTerms : all (single word + multi words terms), multi (multi words terms) 
         * measure = 19 possible measures 
         * tool_Tagger il sera TreeTagger ou Stanford pour l'anglais
        */  
        
        //Execution.main_execution("english",200,"multi","C_value",1,"/Volumes/MacintoshDocuments/TestStanford/DataBase/V01_File.txt","TreeTagger");
        //Execution.main_execution("english",200,"multi","Okapi_S",2,"/Volumes/MacintoshDocuments/TestStanford/DataBase/V01_ManyFiles.txt","TreeTagger");
    	//list_candidat_terms_validated = Execution.main_execution("french",200,"multi","F-TFIDF-C_M",2,"/Volumes/MacintoshDocuments/TextDataBases/Z_ManyFiles/PubfrFiles.txt","TreeTagger");
    	
    	//list_candidat_terms_validated = Execution.main_execution("french",200,"multi","C_value",1,"/Users/juanlossio/Desktop/SandraJerome/ReponsesCorrected.txt","TreeTagger");
    	
    	
    	
    	//list_candidat_terms_validated = Execution.main_execution("english",200,"multi","F-TFIDF-C_M",2,"/Volumes/MacintoshDocuments/TextDataBases/labtestonline_EN_200.txt","TreeTagger");
    	//list_candidat_terms_validated = Execution.main_execution("french",200,"all","F-TFIDF-C_M",2,"/Volumes/MacintoshDocuments/Context/ContextOneFile/1.txt","TreeTagger");
        //list_candidat_terms_validated = Execution.main_execution("english",200,"multi","C_value",1,
        //		"/Users/juanlossio/Desktop/Corpus_Clustering/GENIA_term_3.02/Experiments/GENIA_CorpusFor_BioTex_SingleDocument.txt","TreeTagger");
        //list_candidat_terms_validated = Execution.main_execution("english",200,"multi","F-TFIDF-C_M",2,"/Users/juanlossio/Desktop/Corpus_Clustering/GENIA_term_3.02/Experiments/GENIA_CorpusFor_BioTex_SetDocuments.txt","TreeTagger");
        //list_candidat_terms_validated = Execution.main_execution("english",200,"multi","C_value",1,"/usr/local/apache-tomcat-7.0.39/bin/validationEnglish.nose.dd.doc.csv","TreeTagger");
    	//show_list_terms();
    	//show_terms_notvalidated();
    	//show_terms_validated();
    	show_terms_after_processus();
    }
    
    private static String show_list_terms(){
        String html = "";
        int count = 0;
        System.out.println("EMPEZAMOS -------------------------------------");
        System.out.println(list_candidat_terms_validated.size());
        for(int i=0;i<list_candidat_terms_validated.size();i++){
        	if(list_candidat_terms_validated.get(i).getIsTrueTerm()==0){
        		//System.out.println(list_candidat_terms_validated.get(i).getIsTrueTerm()+";"+list_candidat_terms_validated.get(i).getTerm());
        		System.out.println(list_candidat_terms_validated.get(i).getTerm());
        		count++;
        	}
        	if(count > 2000){
        		break;
        	}
            //System.out.println(list_candidat_terms.get(i).getTerm()+"   "+list_candidat_terms.get(i).getImportance());
        }
        return html;
    }
    
    private static void show_terms_after_processus(){
        //String file = "/Users/juanlossio/Desktop/Ontologos/MultiTerms_Ontologos.csv";
        String file = "/Users/juanlossio/Desktop/SandraJerome/ReponsesCorrected.csv";
        try{
        	FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(int i=0;i<list_candidat_terms_validated.size();i++){
        		//bw.write(list_candidat_terms_validated.get(i).getTerm()+";"+list_candidat_terms_validated.get(i).getIsTrueTerm()
        		//		+";"+list_candidat_terms_validated.get(i).getImportance());
            	bw.write(list_candidat_terms_validated.get(i).getTerm()+";"+list_candidat_terms_validated.get(i).getIsTrueTerm());
                bw.newLine();
            }
            
            bw.close();
            fw.close();
        }catch(Exception ex){
        	System.out.println("Error : " + ex.toString());
        }
    }
    
    private static void show_terms_validated(){
        String file = "/Volumes/MacintoshDocuments/LabTestOnlineValidated_FR.txt";

        try{
        	FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(int i=0;i<list_candidat_terms_validated.size();i++){
            	if(list_candidat_terms_validated.get(i).getIsTrueTerm()==1){
            		bw.write(list_candidat_terms_validated.get(i).getTerm());
                    bw.newLine();
            	}
            }
            bw.close();
            fw.close();
        }catch(Exception ex){
        	System.out.println("Error : " + ex.toString());
        }
    }
    
    private static void show_terms_notvalidated(){
        String file = "/Volumes/MacintoshDocuments/LabTestOnline_EN.txt";
        
        int count = 0;
        try{
        	FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(int i=0;i<list_candidat_terms_validated.size();i++){
            	if(list_candidat_terms_validated.get(i).getIsTrueTerm()==0){
            		bw.write(list_candidat_terms_validated.get(i).getTerm());
                    bw.newLine();
            		count++;
            	}
            	if(count >= 8000){
            		break;
            	}
            }
            bw.close();
            fw.close();
        }catch(Exception ex){
        	System.out.println("Error : " + ex.toString());
        }
    }
    
    private static void show_terms(){
        String file = "/Volumes/MacintoshDocuments/Tests/EnglishMulti.xml";
        
        int count = 0;
        try{
        	FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("<?xml version='1.0' encoding='UTF-8'?>");
            bw.newLine();
            bw.write("<Terms>");
            bw.newLine();
                            
            while(count<1500 && count<list_candidat_terms_validated.size()){
                bw.write("<Term id="+(count+1)+">");
                bw.newLine();
                    bw.write("<name_term>"+ list_candidat_terms_validated.get(count).getTerm() +"</name_term>");
                    bw.newLine();
                    bw.write("<is_true_term>"+ list_candidat_terms_validated.get(count).getIsTrueTerm() +"</is_true_term>");
                    bw.newLine();
                bw.write("</Term>");
                bw.newLine();
                count++;
            }
            bw.write("</Terms>");
            bw.newLine();
            bw.close();
            fw.close();
        }catch(Exception ex){
        	System.out.println("Error : " + ex.toString());
        }
    }
}
