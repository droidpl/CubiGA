package es.unileon.rnag.operator.selection;

import es.unileon.rnag.chromosome.Chromosome;

/**
 * Class that encapsulate all the selectionStrategies
 * @author Adrian Casimiro �lvarez
 * @author Javier de Pedro L�pez
 *
 */
public abstract class SelectionStrategy implements SelectionOperator{
	
	// METHOD //
	/**
	 * Method that do the selection from a previous chromosome list (previous generation)
	 * @param previousGeneration The previous generation
	 * @return The new generation
	 */
	public abstract Chromosome[] doSelection(Chromosome[] previousGeneration);
}
