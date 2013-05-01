package es.unileon.rnag.cubiga.example;

import es.unileon.rnag.cubiga.GeneticAlgorithm;
import es.unileon.rnag.cubiga.chromosome.Chromosome;
import es.unileon.rnag.cubiga.datatypes.BitVector;
import es.unileon.rnag.cubiga.operator.FitnessOperator;
import es.unileon.rnag.cubiga.operator.GeneticStrategy;
import es.unileon.rnag.cubiga.operator.StopOperator;
import es.unileon.rnag.cubiga.operator.crossover.CrossoverFactory.CrossoverType;
import es.unileon.rnag.cubiga.operator.selection.SelectionFactory.SelectionType;
import es.unileon.rnag.cubiga.oprerator.mutation.MutationFactory.MutationType;

/**
 * Example of the CubiGA with BitVector
 * @author Adrian Casimiro Alvarez
 * @author Javier de Pedro Lopez
 */
public class Example {
	private static final Double CROSSOVER_PROBABILITY = 0.7;
	private static final Double MUTATION_PROBABILITY = 0.05;
	private static final int POPULATION = 10;
	private static final int NUMBER_OF_GENERATIONS = 100;
	
	/**
	 * Executes the genetic algorithm
	 * @param args External arguments
	 */
	public static void main(String[] args) {
		GeneticStrategy geneticStrategy = new GeneticStrategy(SelectionType.TOURNAMENT, CrossoverType.TWO_POINT, MutationType.RANDOM_MUTATION);
		FitnessStop fitnessStop = new FitnessStop();
		GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(geneticStrategy, fitnessStop, fitnessStop);
		
		BitVector bitVector = new BitVector(100000);
		
		geneticAlgorithm.initialize(POPULATION, bitVector, NUMBER_OF_GENERATIONS, CROSSOVER_PROBABILITY, MUTATION_PROBABILITY);
		
		geneticAlgorithm.evolve();
		
		System.out.println(geneticAlgorithm.getFittest() + " // With probability: " + geneticAlgorithm.getFittest().getFitness());
	}
	
	/**
	 * Class that implements the fitness and the stop functions
	 * @author Adrian Casimiro Alvarez
	 * @author Javier de Pedro Lopez
	 */
	public static class FitnessStop implements FitnessOperator,StopOperator{
		@Override
		public boolean mustContinue(GeneticAlgorithm algorithm) {
			//The algorithm stop if the fittest has all bits to 1
			boolean result = false;
			Chromosome chromosoma = algorithm.getFittest();
			for(int i=0; i<chromosoma.length(); i++){
				if(Integer.parseInt(chromosoma.getGen(i).getValue()) == 0){
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
			Chromosome chromosoma = algorithm.getFittest();
			for(int i=0; i<chromosoma.length(); i++){
				if(Integer.parseInt(chromosoma.getGen(i).getValue()) == 1){
					result++;
				}
			}
			return result;
		}
	}
}
