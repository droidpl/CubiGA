package es.unileon.rnag.cubiga.example;

import es.unileon.rnag.cubiga.GeneticAlgorithm;
import es.unileon.rnag.cubiga.chromosome.Chromosome;
import es.unileon.rnag.cubiga.datatypes.BitVector;
import es.unileon.rnag.cubiga.datatypes.GeneticType;
import es.unileon.rnag.cubiga.operator.FitnessOperator;
import es.unileon.rnag.cubiga.operator.GeneticStrategy;
import es.unileon.rnag.cubiga.operator.StopOperator;
import es.unileon.rnag.cubiga.operator.crossover.CrossoverFactory.CrossoverType;
import es.unileon.rnag.cubiga.operator.mutation.MutationFactory.MutationType;
import es.unileon.rnag.cubiga.operator.selection.SelectionFactory.SelectionType;

/**
 * Example of the CubiGA with BitVector
 * @author Adrian Casimiro Alvarez
 * @author Javier de Pedro Lopez
 */
public class Example {
	private static final Double CROSSOVER_PROBABILITY = 0.7;
	private static final Double MUTATION_PROBABILITY = 0.05;
	private static final int POPULATION = 300;
	private static final int NUMBER_OF_GENERATIONS = 80;
	
	/**
	 * Executes the genetic algorithm
	 * @param args External arguments
	 */
	public static void main(String[] args) {
		//Select the algorithm strategy
		GeneticStrategy geneticStrategy = new GeneticStrategy(SelectionType.TOURNAMENT, CrossoverType.TWO_POINT, MutationType.RANDOM);
		Operators operators = new Operators();
		//Create an instance of the GA
		GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(geneticStrategy, operators, operators);
		//Determine the data type
		GeneticType geneticType = new BitVector(300);
		//Initialize the GA
		geneticAlgorithm.initialize(POPULATION, geneticType, NUMBER_OF_GENERATIONS, CROSSOVER_PROBABILITY, MUTATION_PROBABILITY);
		//Evolve it
		geneticAlgorithm.evolve();
		//Print results
		System.out.println("Chromosome: " + geneticAlgorithm.getFittest());
		System.out.println("Fitness: " + geneticAlgorithm.getFittest().getFitness());
		System.out.println("Execution time = " + geneticAlgorithm.getExecutionTime());
	}
	
	/**
	 * Class that implements the fitness and the stop functions
	 * @author Adrian Casimiro Alvarez
	 * @author Javier de Pedro Lopez
	 */
	public static class Operators implements FitnessOperator, StopOperator{
		@Override
		public boolean mustContinue(GeneticAlgorithm algorithm) {
			//The algorithm stop if the fittest has all bits set to 1
			boolean result = false;
			Chromosome chromosome = algorithm.getFittest();
			for(int i = 0; i < chromosome.length(); i++){
				if(!Boolean.parseBoolean(chromosome.getGen(i).getValue())){
					result = true;
					break;
				}
			}
			return result;
		}
	
		@Override
		public double fitnessFunction(Chromosome chromosome,
				GeneticAlgorithm algorithm) {
			//The fittest has more bits to 1
			double result = 0;
			for(int i=0; i<chromosome.length(); i++){
				if(Integer.parseInt(chromosome.getGen(i).toString()) == 1){
					result++;
				}
			}
			return result;
		}
	}
}
