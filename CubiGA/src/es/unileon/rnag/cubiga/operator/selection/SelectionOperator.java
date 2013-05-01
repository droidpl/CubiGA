package es.unileon.rnag.cubiga.operator.selection;

import es.unileon.rnag.cubiga.chromosome.Chromosome;

/**
 * Interface that contains the selection elemental operation
 * @author Javier de Pedro Lopez
 * @author Adrian Casimiro Alvarez
 * @version 1.0
 */
public interface SelectionOperator {
	/**
	 * Applies the selection operator to a given population
	 * @param previousGeneration Previous generations
	 * @return The new generation selected
	 */
	public Chromosome[] doSelection(Chromosome[] previousGeneration);
}
