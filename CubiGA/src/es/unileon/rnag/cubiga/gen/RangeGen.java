package es.unileon.rnag.cubiga.gen;

import es.unileon.rnag.cubiga.datatypes.GeneticType;

/**
 * The representation of the range gen data type.
 * @author Javier de Pedro Lopez
 * @author Adrian Casimiro Alvarez
 * @version 1.0
 */
public class RangeGen extends Gen {

	/**
	 * The value of the range gen.
	 */
	private int value;
	
	/**
	 * Constructor of the range gen.
	 * @param value The value that will be present on the gen.
	 * @param type The genetic type generator.
	 */
	public RangeGen(int value, GeneticType type){
		this.value = value;
		this.geneticType = type;
	}

	@Override
	public String getValue() {
		return Integer.toString(value);
	}

}
