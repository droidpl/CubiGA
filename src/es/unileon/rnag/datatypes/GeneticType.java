package es.unileon.rnag.datatypes;

import es.unileon.rnag.chromosome.Chromosome;
import es.unileon.rnag.gen.Gen;

/**
 * Class that encapsulate all data types.
 * @author Adrian Casimiro Alvarez
 * @author Javier de Pedro Lopez
 */
public abstract class GeneticType {

	/**
	 * Generates a chromosome of the given data type.
	 * @return The chromosome generated.
	 */
	public abstract Chromosome generateChromosome();
	/**
	 * Generates a gen of the given type.
	 * @param index Sometimes the index generated is important such in Range. If it doesen't matter,
	 * use 0.
	 * @return The gen generated.
	 */
	public abstract Gen getGen(int index);
}
