package es.unileon.rnag.cubiga.gen;

import es.unileon.rnag.cubiga.datatypes.GeneticType;

/**
 * Gen that represents a string element of a list of string genes
 * @author Javier de Pedro Lopez
 * @author Adrian Casimiro Alvarez
 */
public class ListGen extends Gen {

	/**
	 * The value of the string gen
	 */
	private String value;
	
	/**
	 * Constructor of the list of genes
	 * @param value the value of the gen
	 * @param type The data type of the gen
	 */
	public ListGen(String value, GeneticType type){
		this.value = value;
		this.geneticType = type;
	}
	
	@Override
	public String getValue() {
		return value;
	}

}
