package es.unileon.rnag.cubiga.operator.selection;

import es.unileon.rnag.cubiga.chromosome.Chromosome;

/**
 * Abstract class that encapsulate all the selection strategies
 * @author Adrian Casimiro Álvarez
 * @author Javier de Pedro López
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
