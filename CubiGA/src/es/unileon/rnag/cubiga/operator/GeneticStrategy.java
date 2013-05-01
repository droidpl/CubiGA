package es.unileon.rnag.cubiga.operator;

import es.unileon.rnag.cubiga.chromosome.Chromosome;
import es.unileon.rnag.cubiga.operator.crossover.CrossoverElement;
import es.unileon.rnag.cubiga.operator.crossover.CrossoverStrategy;
import es.unileon.rnag.cubiga.operator.selection.SelectionStrategy;
import es.unileon.rnag.cubiga.oprerator.mutation.MutationStrategy;

/**
 * Manages all the strategies inside the genetic algorithm
 * @author Javier de Pedro Lopez
 * @author Adrian Casimiro Alvarez
 * @version 1.0
 */
public class GeneticStrategy {
	private SelectionStrategy selectionStrategy;
	private CrossoverStrategy crossoverStrategy;
	private MutationStrategy mutationStrategy;
	
	/**
	 * Creates a new instance of the strategy
	 * @param selectionOp The selection operator
	 * @param crossoverOp The crossover operator
	 * @param mutationOp The mutation operator
	 */
	public GeneticStrategy(SelectionStrategy selectionOp, CrossoverStrategy crossoverOp, MutationStrategy mutationOp){
		this.selectionStrategy = selectionOp;
		this.crossoverStrategy = crossoverOp;
		this.mutationStrategy = mutationOp;
	}
	
	/**
	 * Applies the selection operator to a given population
	 * @param population Population to select
	 * @return The new generation selected
	 */
	public Chromosome[] doSelection(Chromosome[] population){
		return selectionStrategy.doSelection(population);
	}
	
	/**
	 * Applies the crossover operator to two given chromosome
	 * @param crossoverElement Structure that wraps the two chromosomes
	 * @return A crossed structure with two crossed chromosomes
	 */
	public CrossoverElement doCrossover(CrossoverElement crossoverElement){
		return crossoverStrategy.doCrossover(crossoverElement);
	}
	
	/**
	 * Applies the mutation strategy to a given chromosome
	 * @param chromosome The chromosome we want to mutate
	 * @return The mutated chromosome
	 */
	public Chromosome doMutation(Chromosome chromosome){
		return mutationStrategy.doMutation(chromosome);
	}

	/**
	 * Returns the selection strategy
	 * @return The selection strategy
	 */
	public SelectionStrategy getSelectionStrategy() {
		return selectionStrategy;
	}
	
	/**
	 * Returns the crossover strategy
	 * @return The crossover strategy
	 */
	public CrossoverStrategy getCrossoverStrategy() {
		return crossoverStrategy;
	}

	/**
	 * Returns the mutation strategy
	 * @return The mutation strategy
	 */
	public MutationStrategy getMutationStrategy() {
		return mutationStrategy;
	}
}
