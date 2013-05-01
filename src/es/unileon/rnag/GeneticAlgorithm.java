package es.unileon.rnag;

import java.util.Arrays;

import es.unileon.rnag.chromosome.Chromosome;
import es.unileon.rnag.datatypes.GeneticType;
import es.unileon.rnag.operator.FitnessOperator;
import es.unileon.rnag.operator.GeneticStrategy;
import es.unileon.rnag.operator.StopOperator;
import es.unileon.rnag.operator.crossover.CrossoverElement;

/**
 * Genetic algorithm that is used as an entry point for the library. Use its methods
 * to get your algorithm running
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
	private Chromosome fittest;
	private GeneticType geneticType;
	private int generationIndex;
	private int numberOfGenerations;
	private boolean runned;
	
	/**
	 * Initializes the genetic algorithm
	 * @param strategy the crossover, mutation and selection that will be used
	 * @param fitness an interface that has the fitness function
	 * @param stop an interface that has the stop parameter
	 */
	public GeneticAlgorithm(GeneticStrategy strategy, FitnessOperator fitness, 
			StopOperator stop){
		if (strategy == null) throw new RuntimeException("Strategy must not be null");
		this.geneticStrategy = strategy;
		if (fitness == null) throw new RuntimeException("Fitness operator must not be null.");
		this.fitnessOperator = fitness;
		if (stop == null) throw new RuntimeException("Stop operator must not be null.");
		this.stopOperator = stop;
		//Init some vars (really not needed)
		this.populationSize = 0;
		this.generationIndex = 0;
		this.numberOfGenerations = 0;
		//Has been executed
		this.runned = false;
	}
	
	/**
	 * Sorts population checking its fitness values from major to minor
	 */
	public void sortPopulation(){
		Arrays.sort(population);
	}
	
	/**
	 * Returns the population size
	 * @return Population size
	 */
	public int size(){
		return populationSize;
	}
	
	/**
	 * Sets the crossover probability
	 * @param probability The crossover probability
	 */
	public void setCrossoverProbability(double probability){
		if (probability < 0 || probability > 1) throw new RuntimeException("The crossover probability must be a number between 0 and 1");
		geneticStrategy.getCrossoverStrategy().setCrossoverProbability(probability);
	}
	
	/**
	 * Returns the crossover probability
	 * @return The crossover probability
	 */
	public double getCrossoverProbability(){
		return geneticStrategy.getCrossoverStrategy().getCrossoverProbability();
	}
	
	/**
	 * Sets the mutation probability
	 * @param probability The mutation probability
	 */
	public void setMutationProbability(double probability){
		if (probability < 0 || probability > 1) throw new RuntimeException("The mutation probability must be a number between 0 and 1");
		geneticStrategy.getMutationStrategy().setMutationProbability(probability);
	}
	
	/**
	 * Returns the mutation probability
	 * @return The mutation probability
	 */
	public double getMutationProbability(){
		return geneticStrategy.getMutationStrategy().getMutationProbability();
	}
	
	/**
	 * Executes the genetic algorithm iterating over population
	 */
	public void evolve(){
		if (this.populationSize < 1 || this.geneticType == null || this.numberOfGenerations < 1) throw new RuntimeException("Bad parameter initialization");
		this.population = new Chromosome[this.populationSize];
		//First generation initialization
		firstGenerationInitialization();
		//GA loop
		while (this.stopOperator.mustContinue(this) && this.generationIndex < this.numberOfGenerations){
			//Do selection
			this.population = this.geneticStrategy.doSelection(this.population);
			/*Loop
				calculate crossover
				calculate mutation
				calculate fitness
			end loop*/
			for (int i = 1; i < this.populationSize; i+=2){
				CrossoverElement crossElem = new CrossoverElement(this.population[i-1], this.population[i]);
				//Do crossover
				crossElem = this.geneticStrategy.doCrossover(crossElem);
				//Do mutation and save crossover elements
				this.population[i-1] = this.geneticStrategy.doMutation(crossElem.getFirstChromosome());
				this.population[i] = this.geneticStrategy.doMutation(crossElem.getSecondChromosome());
				//Calculate the new fitness
				assignFitness(this.population[i-1]);
				assignFitness(this.population[i]);
				/* If we use odd population size last element has no crossover and mutations, selection will cover
				 * this possible problem by selecting it */
			}
			sortPopulation();
			checkFittest();
			this.generationIndex++;
		}
		this.runned = true;
	}
	
	/**
	 * Returns the current population of this generation
	 * @return The current population
	 */
	public Chromosome[] getCurrentGeneration(){
		return this.population;
	}
	
	/**
	 * Returns the generation number in which the algorthm is beeing executed. It is
	 * smaller than numberOfGenerations
	 * @return The number of the current generation
	 */
	public int getCurrentGenerationNumber(){
		return this.generationIndex;
	}
	
	/**
	 * Returns assigned genetic type
	 * @return The generic type
	 */
	public GeneticType getGeneticType(){
		return this.geneticType;
	}
	
	/**
	 * Establish the number of generations established
	 * @param numberOfGenerations The number of generations to establish. It must be greater or equal than 1
	 */
	public void setNumberOfGenerations(int numberOfGenerations){
		if (numberOfGenerations < 1) throw new RuntimeException("The minium number of generations must be 1. Assigned: " + numberOfGenerations);
		this.numberOfGenerations = numberOfGenerations;
	}
	
	/**
	 * Returns the number of generations that the algorithm has as initialized parameter
	 * @return The number of generations
	 */
	public int getNumberOfGenerations(){
		return this.numberOfGenerations;
	}
	
	/**
	 * Returns the best chromosome in all generations.
	 * @return The best chromosome in all generations.
	 */
	public Chromosome getFittest() {
		return this.fittest;
	}
	
	/**
	 * Initializes the genetic algorithm
	 * @param populationSize The size the population will have
	 * @param type Data type of the genes and chromosomes inside the genetic algorithm
	 * @param numberOfGenerations The number of generations that ill be executed
	 */
	public void initialize(int populationSize, GeneticType type, int numberOfGenerations){
		if (this.runned) throw new RuntimeException("This genetic algorithm has been executed. Please create a new instance and run it with new parameters");
		if (populationSize < 1 || type == null || numberOfGenerations < 1) throw new RuntimeException("Bad parameter initialization");
		this.populationSize = populationSize;
		this.geneticType = type;
		this.numberOfGenerations = numberOfGenerations;
	}
	
	/**
	 * Initializes the first generation
	 */
	private void firstGenerationInitialization(){
		for (int i = 0; i < this.populationSize; i++){
			this.population[i] = this.geneticType.generateChromosome();
			//Calculate initial fitness
			assignFitness(this.population[i]);
		}
		sortPopulation();
		checkFittest();
		//Add first generation
		this.generationIndex = 1;
	}
	
	/**
	 * Calculates the fitness of a chromosome
	 * @param chromosome the chromosome
	 */
	private void assignFitness(Chromosome chromosome){
		chromosome.setFitness(this.fitnessOperator.fitnessFunction(chromosome, this));
	}
	
	/**
	 * Check the fittest element of the current generation.
	 */
	private void checkFittest(){
		if (fittest == null) fittest = this.population[0];
		else if (this.population[0].getFitness() > fittest.getFitness()) fittest = this.population[0];
	}
}
