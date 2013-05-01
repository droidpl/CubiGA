package es.unileon.rnag.cubiga.gen;

import es.unileon.rnag.cubiga.datatypes.GeneticType;

/**
 * Gen of a chromosome with the valie.
 * @author Javier de Pedro Lopez
 * @author Adrian Casimiro Alvarez
 * @version 1.0
 */
public abstract class Gen {
	/**
	 * Genetic type of this gen.
	 */
	protected GeneticType geneticType;

	/**
	 * Returns the value of this gen.
	 * @return A string containing this value.
	 */
	public abstract String getValue();
	
	/**
	 * Returns the type of this gen.
	 * @return The type of this gen.
	 */
	public GeneticType getGeneticType(){
		return this.geneticType;
	}
	
	@Override
	public String toString() {
		return getValue();
	}
}
