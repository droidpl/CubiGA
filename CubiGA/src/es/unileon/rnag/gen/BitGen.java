package es.unileon.rnag.gen;

import es.unileon.rnag.datatypes.GeneticType;

/**
 * The bit gen representation.
 * @author Javier de Pedro Lopez
 * @author Adrian Casimiro Alvarez
 */
public class BitGen extends Gen {
	
	/**
	 * Boolean value of the bit gen. Active = 1 = true and inactive = 0 = false
	 */
	private boolean value;
	
	/**
	 * Constructor of the bit gen.
	 * @param value True for 1 and false for 0.
	 * @param type The genetic type generator.
	 */
	public BitGen(boolean value, GeneticType type){
		this.value = value;
		this.geneticType = type;
	}
	
	@Override
	public String getValue() {
		String genValue = this.value ?  "1" : "0";
		return genValue;
	}

}
