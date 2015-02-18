package TestClasses;

import BioTex.Execution;
import BuildListToValidate.*;
import Object.CandidatTerm;
import java.io.File;
import java.util.ArrayList;

public class Principal1 {
static ArrayList<CandidatTerm> list_candidat_terms_validated = new ArrayList<CandidatTerm>();
    
    public static void main(String[] args) {        
         
    	/*
    	 * Variables to find: the Pattern List, DataSetReference for Validation, and file where the Tagger Tool is installed
    	 */
    	String source_patterns = "/Volumes/MacintoshDocuments/EclipseWorkSpace/JarBioTex/patterns";
    	String source_dataset_reference = "/Volumes/MacintoshDocuments/EclipseWorkSpace/DataSetReference";
    	String source_tagger = "/Users/juanlossio/Downloads/TreeTagger";
    	String source_stop_words = "/Volumes/MacintoshDocuments/EclipseWorkSpace/StopWords/Stop-words-FR.txt";
    	
    	
    	/*
    	 * Variable that saves the extracted terms, folder that will contain the file for 1-gram, 2-gram, 3-gram and 4+ gram terms
    	 */
    	String source_source_OUTPUT = "/Volumes/MacintoshDocuments/University/WSI/NotPolysemique/3-CandidateTerms"; //Mettre le dossier où vous voulez que les fichiers se sauvegardent
    	String source_OUTPUT = ""; //Mettre le dossier où vous voulez que les fichiers se sauvegardent
    	
    	
    	/*
    	 * File to be analyzed for the term extraction
    	 */
    	String source_files_to_be_analyzed = "/Volumes/MacintoshDocuments/University/WSI/NotPolysemique/2-TXT";
    	String file_to_be_analyzed = "";
    	
    	/*
         * Language : english, french 
         * number_patrons : number of first pattern to take into account 
         * typeTerms : all (single word + multi words terms), multi (multi words terms) 
         * measure = 19 possible measures 
         * tool_Tagger il sera TreeTagger ou Stanford pour l'anglais
        */ 
    	//list_candidat_terms_validated = Execution.main_execution("french",200,"all","C_value",1/*single file 1 or a set of files 2*/,file_to_be_analized,"TreeTagger",
    	//		source_patterns,source_dataset_reference,source_tagger,source_OUTPUT);
    	
        try{
            File dir_in = new File(source_files_to_be_analyzed);
            String[] text_files = dir_in.list();
            for(int y=0;y<text_files.length;y++){
            	list_candidat_terms_validated = new ArrayList<>();
                if(!text_files[y].equalsIgnoreCase(".DS_Store")) {
                        System.out.println("------------------------"+text_files[y]+"------------------------");
                    
                        file_to_be_analyzed = source_files_to_be_analyzed + File.separator + text_files[y];
                        source_OUTPUT = source_source_OUTPUT + File.separator + text_files[y];
                        
                	list_candidat_terms_validated = Execution.main_execution("english",200,"all","C_value",1/*single file 1 or a set of files 2*/,file_to_be_analyzed,"TreeTagger",
    			source_patterns,source_dataset_reference,source_tagger,source_OUTPUT);
                        
                        FilterSingleList.createList(list_candidat_terms_validated,source_stop_words,source_OUTPUT,"all");
                }
                
            }
        }catch(Exception ex){
            System.err.println("Error Text: " + ex.toString());
        }
    }
}
