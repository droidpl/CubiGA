package es.unileon.rnag;

import es.unileon.rnag.chromosome.Chromosome;
import es.unileon.rnag.datatypes.GeneticType;
import es.unileon.rnag.operator.FitnessOperator;
import es.unileon.rnag.operator.GeneticStrategy;
import es.unileon.rnag.operator.StopOperator;

/**
 * Genetic algorithm that is used as an entry point for the library. Use its methods
 * to get your algorithm running.
 * @author Javier de Pedro Lopez
 * @author Adrian Casimiro Alvarez
 * @version 1.0
 */
public class GeneticAlgorithm {
	private GeneticStrategy geneticStrategy;
	private StopOperator stopOperator;
	private FitnessOperator fitnessOperator;
	private int populationSize;
	private Chromosome[] population;
	private GeneticType geneticType;
	private int generationIndex;
	private int numberOfGenerations;
	private boolean runned;
	
	/**
	 * Initializes the genetic algorithm.
	 * @param strategy the crossover, mutation and selection that will be used.
	 * @param fitness an interface that has the fitness function.
	 * @param stop an interface that has the stop varameter.
	 */
	public GeneticAlgorithm(GeneticStrategy strategy, FitnessOperator fitness, 
			StopOperator stop){
		if (strategy == null) throw new RuntimeException("Strategy must not be null");
		this.geneticStrategy = strategy;
		if (fitness == null) throw new RuntimeException("Fitness operator must not be null.");
		this.fitnessOperator = fitness;
		if (stop == null) throw new RuntimeException("Stop operator must not be null.");
		this.stopOperator = stop;
		this.runned = false;
		
	}
	
	/**
	 * Sorts population cheching its fitness values from major to minor.
	 */
	public void sortPopulation(){
		//TODO use sort to sort the population from major fitness to minor
	}
	
	/**
	 * Returns the population size.
	 * @return Population size.
	 */
	public int size(){
		return populationSize;
	}
	
	/**
	 * Sets the crossover probability.
	 * @param probability The crossover probability.
	 */
	public void setCrossoverProbability(double probability){
		//TODO
	}
	
	/**
	 * Returns the crossover probability.
	 * @return The crossover probability.
	 */
	public double getCrossoverProbability(){
		return 0;//TODO
	}
	
	/**
	 * Sets the mutation probability.
	 * @param probability The mutation probability.
	 */
	public void setMutationProbability(double probability){
		//TODO
	}
	
	/**
	 * Returns the mutation probability.
	 * @return The mutation probability.
	 */
	public double getMutationProbability(){
		return 0; //TODO
	}
	
	/**
	 * Executes the genetic algorithm iterating over population.
	 */
	public void evolve(){
		//TODO
		this.runned = true;
	}
	
	/**
	 * Returns the current population of this generation.
	 * @return The current population.
	 */
	public Chromosome[] getCurrentGeneration(){
		return this.population;
	}
	
	/**
	 * Returns the generation number in which the algorthm is beeing executed. It is
	 * smaller than numberOfGenerations.
	 * @return The number of the current generation.
	 */
	public int getCurrentGenerationNumber(){
		return this.generationIndex;
	}
	
	/**
	 * Returns assigned genetic type.
	 * @return The generic type.
	 */
	public GeneticType getGeneticType(){
		return this.geneticType;
	}
	
	/**
	 * Stablish the number of generations stablished.
	 * @param numberOfGenerations The number of generations tu stablish. It must be greater or equal than 1.
	 */
	public void setNumberOfGenerations(int numberOfGenerations){
		if (numberOfGenerations < 1) throw new RuntimeException("The minium number of generations must be 1. Assigned: " + numberOfGenerations);
		this.numberOfGenerations = numberOfGenerations;
	}
	
	/**
	 * Returns the number of generations that the algorithm has as initialized parameter.
	 * @return The number of generations.
	 */
	public int getNumberOfGenerations(){
		return this.numberOfGenerations;
	}
	
	/**
	 * Initializes the genetic algorithm.
	 * @param populationSize The size the population will have.
	 * @param type Data type of the genes and chromosomes inside the genetic algorithm.
	 * @param numberOfGenerations The number of generations that ill be executed.
	 */
	public void initialize(int populationSize, GeneticType type, int numberOfGenerations){
		if (this.runned) throw new RuntimeException("This genetic algorithm has been executed. Please create a new instance and run with new parameters.");
		this.populationSize = populationSize;
		this.geneticType = type;
		this.numberOfGenerations = numberOfGenerations;
	}
}
