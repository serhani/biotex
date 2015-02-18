/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;
import BioTex.Execution;
import Object.CandidatTerm;
import BuildListToValidate.BuildFilterManyLists;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;


/**
 *
 * @author juanlossio
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    static ArrayList<CandidatTerm> list_candidat_terms_validated = new ArrayList<CandidatTerm>();
    
    public static void main(String[] args) {        
         
    	/*
    	 * Variables to find: the Pattern List, DataSetReference for Validation, and file where the Tagger Tool is installed
    	 */
    	String source_patterns = "/Volumes/MacintoshDocuments/EclipseWorkSpace/JarBioTex/patterns";
    	String source_dataset_reference = "/Volumes/MacintoshDocuments/EclipseWorkSpace/DataSetReference";
    	String source_tagger = "/Users/juanlossio/Documents/TreeTagger";
    	//String source_tagger = "/Users/juanlossio/Downloads/TreeTagger";
    	String source_stop_words = "/Volumes/MacintoshDocuments/EclipseWorkSpace/StopWords";
    	
    	
    	/*
    	 * Variable that saves the extracted terms
    	 */
    	String source_OUTPUT = "/Volumes/MacintoshDocuments"; //Mettre le dossier où vous voulez que les fichiers se sauvegardent
    	
    	
    	/*
    	 * File to be analized for the term extraction
    	 */
    	String file_to_be_analyzed = "/Volumes/MacintoshDocuments/TextDataBases/Z_SingleFile/Drug_Dexmethylphenidate.txt";
    	
    	/*
         * Language : english, french, spanish 
         * number_patrons : number of first pattern to take into account 
         * typeTerms : all (single word + multi words terms), multi (multi words terms) 
         * measure = 19 possible measures 
         * tool_Tagger il sera TreeTagger ou Stanford pour l'anglais
        */ 
    	//list_candidat_terms_validated = Execution.main_execution("french",200,"all","C_value",1/*single file 1 or a set of files 2*/,file_to_be_analized,"TreeTagger",
    	//		source_patterns,source_dataset_reference,source_tagger,source_OUTPUT);
    	
    	String type_of_terms = "multi"; // all    multi
        String language = "english"; // english french spanish
    	list_candidat_terms_validated = Execution.main_execution(
                language, //english french spanish
                200, // nombre de patrons
                type_of_terms, 
                "LIDF_value", // LIDF_value C_value TFIDF_A TFIDF_M TFIDF_S Okapi_A Okapi_M Okapi_S F-OCapi_A F-OCapi_M F-OCapi_S F-TFIDF-C_A F-TFIDF-C_M F-TFIDF-C_S
                1/*single file 1 or a set of files 2*/,
                file_to_be_analyzed,
                "TreeTagger",
                source_patterns,
                source_dataset_reference,
                source_tagger,
                source_OUTPUT
        );
    	
    	BuildFilterManyLists.createList(list_candidat_terms_validated,source_stop_words,source_OUTPUT,type_of_terms,language);
        System.out.println("Fin de l'exécution");
    }

}
