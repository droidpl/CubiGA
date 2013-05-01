package es.unileon.rnag.gen;

import es.unileon.rnag.datatypes.GeneticType;

public class BitGen extends Gen {
	
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
	public void mutate() {
		value = !value;
	}

	@Override
	public String getValue() {
		String genValue = this.value ?  "1" : "0";
		return genValue;
	}

}
