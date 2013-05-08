package es.unileon.rnag.cubiga.operator.mutation;

import es.unileon.rnag.cubiga.chromosome.Chromosome;

/**
 * Interface that contains the mutation elemental operation.
 * @author Javier de Pedro Lopez
 * @author Adrian Casimiro Alvarez
 * @version 1.0
 */
public interface MutationOperator {
	/**
	 * Applies the mutation strategy to a given chromosome.
	 * @param chromosome The chromosome we want to mutate.
	 * @return The mutated chromosome.
	 */
	public Chromosome doMutation(Chromosome chromosome);
}
