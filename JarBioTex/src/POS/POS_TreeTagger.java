/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS;

import java.io.*; 
import java.util.ArrayList;

/** 
 * POS TreeTagger. 
 * @author  Juan LOSSIO 
 */ 
public class POS_TreeTagger { 
	
	//Local Machine : 
	
    public static ArrayList<String> POS_TreeTagger(String file, String language, String source_tagger) {  
        ArrayList<String> al_POS= new ArrayList<String>();
        try{
			/////////////////////////////////////////////////////////
			///////////////////// C A M B I O S /////////////////////
			/////////////////////////////////////////////////////////
            //Local Machine : 
        	String cmd = source_tagger + File.separator + "cmd"+ File.separator +"tree-tagger-"+language;
        	//String cmd = "/Users/juanlossio/Downloads/TreeTagger/cmd/tree-tagger-"+language;
        	
            //Server Machine :
        	//String cmd = "tree-tagger-"+language;
        	
        	
            /*if(language.equalsIgnoreCase("french")){
                cmd = cmd + "-utf8";
            }*/
            //String cmd = "tree-tagger-"+language;
            
            String par = file;
            String[] cmd_parameters = new String[] {cmd,par};
       
            Runtime runtime = Runtime.getRuntime();
            final Process process = runtime.exec(cmd_parameters);

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            try{
                while((line = reader.readLine()) != null) {
                	if(line.indexOf("l'")>-1){
                		//System.out.println(line);
                	}
                    al_POS.add(line);
                }
            }finally {
                reader.close();
            }
        }catch (Exception e){
            System.err.println(e.toString());
        }
        return al_POS;
    }
    
    
    //Server Machine :
    /*
    public static ArrayList<String> POS_TreeTagger(String file, String language) {  
        ArrayList<String> al_POS= new ArrayList<String>();
        try{
            
           
        	String cmd = "tree-tagger-"+language;
            if(language.equalsIgnoreCase("french")){
            	 cmd = "/opt/TreeTagger/cmd/tree-tagger-french-utf8";
            }
            
            String command;
            command = cmd + " " + file;
            
            final Process process = Runtime.getRuntime().exec(command);

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            try{
                while((line = reader.readLine()) != null) {
                    al_POS.add(line);
                }
            }finally {
                reader.close();
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return al_POS;
    }*/
    
}