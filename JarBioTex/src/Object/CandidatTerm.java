/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;
import java.util.ArrayList;
/**
 *
 * @author juanlossio
 */
public class CandidatTerm {
    private String term;
    private double importance;
    private int isTrueTerm; 
    private ArrayList<String> sourceDictionnary; // liste des sources du term
    private ArrayList<String> URIs; // liste des URIs referencant le term

    public CandidatTerm(String term, double importance) {
        setTerm(term);
        setImportance(importance);
        
    }

    /**
     * @return the term
     */
    
    public String getTerm() {
        return term;
    }

    /**
     * @param term the term to set
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     * @return the importance
     */
    public double getImportance() {
        return importance;
    }

    /**
     * @param importance the importance to set
     */
    public void setImportance(double importance) {
        this.importance = importance;
    }

    /**
     * @param isTrueTerm the isTrueTerm to set
     */
    public void setIsTrueTerm(boolean isTrueTerm) {
        this.setIsTrueTerm(isTrueTerm);
    }

    /**
     * @return the isTrueTerm
     */
    public int getIsTrueTerm() {
        return isTrueTerm;
    }

    /**
     * @param isTrueTerm the isTrueTerm to set
     */
    public void setIsTrueTerm(int isTrueTerm) {
        this.isTrueTerm = isTrueTerm;
    }

	public ArrayList<String> getSourceDictionnary() {
		return sourceDictionnary;
	}

	public void setSourceDictionnary(ArrayList<String> sourceDictionnary) {
		this.sourceDictionnary = sourceDictionnary;
	}

	public ArrayList<String> getURIs() {
		return URIs;
	}

	public void setURIs(ArrayList<String> uRIs) {
		URIs = uRIs;
	}

  
