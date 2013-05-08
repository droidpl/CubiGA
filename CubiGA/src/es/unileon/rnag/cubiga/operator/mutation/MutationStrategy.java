package es.unileon.rnag.cubiga.operator.mutation;

import es.unileon.rnag.cubiga.chromosome.Chromosome;

/**
 * Abstract class that encapsulate all the mutation strategies
 * @author Adrian Casimiro Alvarez
 * @author Javier de Pedro Lopez
 *
 */
public abstract class MutationStrategy implements MutationOperator{

	/**
	 * Attribute that indicate the probability to do the mutation
	 */
	private double mutationProbability;
	

	/**
	 * Method that change the probability to do the mutation
	 * @param mutationProbability The new mutation probability
	 */
	public void setMutationProbability(double mutationProbability){
		this.mutationProbability = mutationProbability;
	}
	
	/**
	 * Method that obtain the mutation probability
	 * @return The probability to do the mutation
	 */
	public double getMutationProbability(){
		return this.mutationProbability;
	}
	
	/**
	 * Applies the mutation strategy to a given chromosome.
	 * @param chromosome The chromosome we want to mutate.
	 * @return The mutated chromosome.
	 */
	public abstract Chromosome doMutation(Chromosome chromosome);
}
