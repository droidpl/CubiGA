package es.unileon.rnag.operator;

import es.unileon.rnag.chromosome.Chromosome;
import es.unileon.rnag.operator.crossover.CrossoverElement;
import es.unileon.rnag.operator.crossover.CrossoverOperator;
import es.unileon.rnag.operator.selection.SelectionOperator;
import es.unileon.rnag.oprerator.mutation.MutationOperator;

/**
 * Manages all the strategies inside the genetic algorithm
 * @author Javier de Pedro Lopez
 * @author Adrian Casimiro Alvarez
 * @version 1.0
 */
public class GeneticStrategy {
	private SelectionOperator selectionStrategy;
	private CrossoverOperator crossoverStrategy;
	private MutationOperator mutationStrategy;
	
	/**
	 * Creates a new instance of the strategy
	 * @param selectionOp The selection operator
	 * @param crossoverOp The crossover operator
	 * @param mutationOp The mutation operator
	 */
	public GeneticStrategy(SelectionOperator selectionOp, CrossoverOperator crossoverOp, MutationOperator mutationOp){
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
}
