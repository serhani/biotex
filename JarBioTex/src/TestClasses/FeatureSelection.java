/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestClasses;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import BioTex.ExecutionFeatures;
import Object.CandidatTerm;


/**
 *
 * @author juanlossio
 */
public class FeatureSelection {

    /**
     * @param args the command line arguments
     */
    static ArrayList<CandidatTerm> list_candidat_terms_validated = new ArrayList<CandidatTerm>();
    
    //static String new_file = "/Volumes/MacintoshDocuments/Context/ContextMesh/1_ContextOneFileURL/";
    //static String file_snippets = "/Volumes/MacintoshDocuments/Context/Context_WSD/1_FilesTXT/";
    static String file_snippets = "/Volumes/MacintoshDocuments/University/WSI/Polysemique/2-TXT/";
    //static String file_matrix = "/Volumes/MacintoshDocuments/Context/ContextMesh/2_0_FeaturesSelectionURL/";
    static String file_features = "/Volumes/MacintoshDocuments/University/WSI/Polysemique/3-CandidateTerms";
    
    public static void main(String[] args) {        
    	try{
            File dir_in = new File(file_snippets);
            String[] text_files = dir_in.list();
            for(int y=0;y<text_files.length;y++){
            	list_candidat_terms_validated = new ArrayList<CandidatTerm>();
            //System.out.println("list_candidat_terms_validated : " + list_candidat_terms_validated.size());
                if(!text_files[y].equalsIgnoreCase(".DS_Store")) {
                	list_candidat_terms_validated = ExecutionFeatures.main_execution("english",200,"all","C_value",1,file_snippets + File.separator + text_files[y],"TreeTagger");  
                	show_list_terms(text_files[y]);
                }
                list_candidat_terms_validated = new ArrayList<CandidatTerm>();
            }
        }catch(Exception ex){
            System.err.println("Error Text: " + ex.toString() + " in R");
        }
    }
    
    private static void show_list_terms(String nom_file){
    	try{
            FileWriter frArchivoWrite = new FileWriter(file_features + File.separator + nom_file);
            BufferedWriter bw =  new BufferedWriter(frArchivoWrite);

            int compt = 0;
            for(int j=0;j<list_candidat_terms_validated.size();j++){
        		//System.out.println(list_candidat_terms_validated.get(i).getIsTrueTerm()+";"+list_candidat_terms_validated.get(i).getTerm());
        		//System.out.println(list_candidat_terms_validated.get(i).getTerm());
        		bw.write(list_candidat_terms_validated.get(j).getTerm()+";"+list_candidat_terms_validated.get(j).getIsTrueTerm());
        		if(list_candidat_terms_validated.get(j).getIsTrueTerm()==1){
        			compt++;
        		}
        		bw.newLine();
            }     
            bw.close();
            frArchivoWrite.close();
            System.out.println(nom_file + " : " + list_candidat_terms_validated.size() + "  " + compt);
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
