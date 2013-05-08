package es.unileon.rnag.cubiga.operator;

import es.unileon.rnag.cubiga.chromosome.Chromosome;
import es.unileon.rnag.cubiga.operator.crossover.CrossoverElement;
import es.unileon.rnag.cubiga.operator.crossover.CrossoverFactory;
import es.unileon.rnag.cubiga.operator.crossover.CrossoverFactory.CrossoverType;
import es.unileon.rnag.cubiga.operator.crossover.CrossoverStrategy;
import es.unileon.rnag.cubiga.operator.mutation.MutationFactory;
import es.unileon.rnag.cubiga.operator.mutation.MutationStrategy;
import es.unileon.rnag.cubiga.operator.mutation.MutationFactory.MutationType;
import es.unileon.rnag.cubiga.operator.selection.SelectionFactory;
import es.unileon.rnag.cubiga.operator.selection.SelectionFactory.SelectionType;
import es.unileon.rnag.cubiga.operator.selection.SelectionStrategy;

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
	 * @param selectionStrategy The selection operator
	 * @param crossoverStrategy The crossover operator
	 * @param mutationStrategy The mutation operator
	 */
	public GeneticStrategy(SelectionStrategy selectionStrategy, CrossoverStrategy crossoverStrategy, MutationStrategy mutationStrategy){
		this.selectionStrategy = selectionStrategy;
		this.crossoverStrategy = crossoverStrategy;
		this.mutationStrategy = mutationStrategy;
	}
	
	/**
	 * Simple constructor of the Genetic Strategy
	 * @param selectionType The selection strategy type
	 * @param crossoverType The crossover strategy type
	 * @param mutationType The mutation strategy type
	 */
	public GeneticStrategy(SelectionType selectionType, CrossoverType crossoverType, MutationType mutationType){
		this(
				SelectionFactory.makeSelectionStrategy(selectionType),
				CrossoverFactory.makeCrossoverStrategy(crossoverType),
				MutationFactory.makeMutationStrategy(mutationType)
			);
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
