package es.unileon.rnag.cubiga.operator.crossover;

import es.unileon.rnag.cubiga.chromosome.Chromosome;

/**
 * Class that encapsulate the two chromosomes to pass to the crossover
 * @author Adrian Casimiro Alvarez
 * @author Javier de Pedro Lopez
 *
 */
public class CrossoverElement {
	/**
	 * First chromosome to operate with
	 */
	private Chromosome crossoverFirstOperator;
	/**
	 * Second chromosome to operate with
	 */
	private Chromosome crossoverSecondOperator;

	/**
	 * Constructor of the class CrossoverElement
	 * @param first One of the chromosome to operate with in the crossover
	 * @param second The other chromosome to operate with in the crossover
	 */
	public CrossoverElement(Chromosome first, Chromosome second){
		this.crossoverFirstOperator = first;
		this.crossoverSecondOperator = second;
	}
	
	/**
	 * Method that return the first chromosome to operate with
	 * @return The first chromosome
	 */
	public Chromosome getFirstChromosome(){
		return this.crossoverFirstOperator;
	}
	
	/**
	 * Method that return the second chromosome to operate with
	 * @return The second chromosome
	 */
	public Chromosome getSecondChromosome(){
		return this.crossoverSecondOperator;
	}
}
