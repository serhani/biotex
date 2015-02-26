package Validation;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import Object.CandidatTerm;

public class Validation {
	public static ArrayList<CandidatTerm> Validate_All_Terms(String language, ArrayList<CandidatTerm> list_candidat_terms, String source_datasetreference)
	{
		HashMap<String, Integer> TermsReference = new HashMap<String, Integer>(); 
		ArrayList<CandidatTerm> list_candidat_terms_validated = new ArrayList<CandidatTerm>();
		ArrayList<String []> data = new ArrayList<String[] >();
		 String sep = new Character(';').toString();
		 String sep2 = new Character(',').toString();
        //String nameFile = currentDir + "/patterns/Patterns_"+language+"_"+ tool_POS +".csv";
        
		/////////////////////////////////////////////////////////
		///////////////////// C A M B I O S /////////////////////
		/////////////////////////////////////////////////////////
        //Local Machine : 
        String nameFile = source_datasetreference + File.separator + "Terms"+language+".csv";
        //String nameFile = "/Volumes/MacintoshDocuments/EclipseWorkSpace/DataSetReference/Terms"+language+".txt";
        
        //Server Machine :
        //String nameFile = "/home/juan/reference/Terms"+language+".txt";
        try
        {
            FileReader fr = new FileReader(nameFile);
            BufferedReader bf = new BufferedReader(fr);
            
            boolean eof = false;
            int cpt = 0;
            while (!eof) {
                String sLinea = bf.readLine();
                if (sLinea == null) {
                    eof = true;
                }
                else{
                	String[] ligne = sLinea.split(sep);
                    data.add(ligne);
                    TermsReference.put(ligne[0].toLowerCase().trim(),cpt); 
                    //la hashmap TermsReference contient le premier element du tableau "Term" comme key
                    //et un cpt comme value (ce cpt va nous etre tres utile en terme d'optimisation dans ce qui suit)
                
                }
                cpt++;
            }
            bf.close();
            fr.close();
        }catch(IOException e) {
            System.err.println("Error: " + e.toString());
        }
        catch(Exception ex) {
            System.err.println("Error: " + ex);
        }
      
        int count = 0;
		while(count<list_candidat_terms.size()){
			if(TermsReference.containsKey(list_candidat_terms.get(count).getTerm().trim())){
				list_candidat_terms.get(count).setIsTrueTerm(1);
				
				String uris = data.get(TermsReference.get(list_candidat_terms.get(count).getTerm().trim()))[1];// ici on recupere facilement les URIs a partir de la list data a l'aide du cpt stocké la la hashMap
				String sourceDico = data.get(TermsReference.get(list_candidat_terms.get(count).getTerm().trim()))[2];// pareil ici pour les sources
				
		        ArrayList<String> URIs = new ArrayList<String>(Arrays.asList(uris.split(sep2)));
				ArrayList<String> sourceDictionnary = new ArrayList<String>(Arrays.asList(sourceDico.split(sep2)));
				list_candidat_terms.get(count).setURIs(URIs);
				list_candidat_terms.get(count).setURIs(sourceDictionnary);
			}   
			list_candidat_terms_validated.add(list_candidat_terms.get(count));
			count++;
		}

        
        return list_candidat_terms_validated;
	}
	
	/*
	public static HashMap<String, Integer> loadTrueTerms(String language){
		
		HashMap<String, Integer> TermsReference = new HashMap<String, Integer>(); 
		
        //String nameFile = currentDir + "/patterns/Patterns_"+language+"_"+ tool_POS +".csv";
        
        //Local Machine : 
        String nameFile = "/Volumes/MacintoshDocuments/EclipseWorkSpace/DataSetReference/Terms"+language+".txt";
        
        //Server Machine :
        //String nameFile = "/home/juan/reference/Terms"+language+".txt";
        try
        {
            FileReader fr = new FileReader(nameFile);
            BufferedReader bf = new BufferedReader(fr);
            
            boolean eof = false;
            while (!eof) {
                String sLinea = bf.readLine();
                if (sLinea == null) {
                    eof = true;
                }
                else{
                    //if(Integer.parseInt(campos[1].trim())>=length_true_term) {
                        //System.out.println(campos[0].trim());
                    	TermsReference.put(sLinea.toLowerCase().trim(),1);
                    //}
                }
            }
            bf.close();
            fr.close();
        }catch(IOException e) {
            System.err.println("Error: " + e.toString());
        }
        catch(Exception ex) {
            System.err.println("Error: " + ex);
        }
        
        return TermsReference;
    }
	*/
	
	/*public static ArrayList<CandidatTerm> ValidateTerms(HashMap<String, Integer> TermsReference, ArrayList<CandidatTerm> list_candidat_terms){
        for(int i=0;i<list_candidat_terms.size();i++){
            if(TermsReference.containsKey(list_candidat_terms.get(i).getTerm())){
            	list_candidat_terms.get(i).setIsTrueTerm(1);
            }
        }
        return list_candidat_terms;
    }*/

}
