package es.unileon.rnag.cubiga.example1;

import es.unileon.rnag.cubiga.GeneticAlgorithm;
import es.unileon.rnag.cubiga.chromosome.Chromosome;
import es.unileon.rnag.cubiga.datatypes.GeneticType;
import es.unileon.rnag.cubiga.datatypes.Range;
import es.unileon.rnag.cubiga.datatypes.RangeVector;
import es.unileon.rnag.cubiga.operator.FitnessOperator;
import es.unileon.rnag.cubiga.operator.GeneticStrategy;
import es.unileon.rnag.cubiga.operator.StopOperator;
import es.unileon.rnag.cubiga.operator.crossover.CrossoverFactory.CrossoverType;
import es.unileon.rnag.cubiga.operator.selection.SelectionFactory.SelectionType;
import es.unileon.rnag.cubiga.oprerator.mutation.MutationFactory.MutationType;

/**
 * Range vector genetic algorithm example. It calculates the maximun of the function x + y^2
 * on the interval x = [2,10] two decimals y = [2,20] two decimals
 * @author Javier de Pedro Lopez
 * @author Adrian Casimiro Alvarez
 */
public class Example {

	/**
	 * Population size of the algorithm.
	 */
	private static final int POPULATION_SIZE = 200;
	/**
	 * The number of generations in the algorithm.
	 */
	private static final int NUMBER_OF_GENERATIONS = 200;
	/**
	 * The crossover probability.
	 */
	private static final double CROSSOVER_PROB = 0.5;
	/**
	 * The mutation probability.
	 */
	private static final double MUTATIONS_PROB = 0.02;
	/**
	 * The number of decimals.
	 */
	private static final int NUMBER_OF_DECIMALS = 2;
	
	/**
	 * Executes the genetic algorithm
	 * @param args External arguments
	 */
	public static void main(String[] args) {
		GeneticStrategy strategy = new GeneticStrategy(SelectionType.TOURNAMENT, CrossoverType.SINGLE_POINT, MutationType.RANDOM_MUTATION);
		Operators operators = new Operators();
		GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(strategy, operators, operators);
		//Initialize the algorithm
		int decimals = (int) Math.pow(10, NUMBER_OF_DECIMALS);
		GeneticType geneticType = new RangeVector(
					new Range(2 * decimals, 10 * decimals),
					new Range(2 * decimals, 20 * decimals)
				);
		geneticAlgorithm.initialize(POPULATION_SIZE, geneticType, NUMBER_OF_GENERATIONS, CROSSOVER_PROB, MUTATIONS_PROB);
		//Execute the algorithm
		geneticAlgorithm.evolve();
		//Printing results
		Chromosome fittest = geneticAlgorithm.getFittest();
		System.out.println("Best Chromosome found for x + y^2:");
		System.out.println("x = " + Double.parseDouble(fittest.getGen(0).getValue())/decimals);
		System.out.println("y = " + Double.parseDouble(fittest.getGen(1).getValue())/decimals);
		System.out.println("points = " + fittest.getFitness());
	}
	
	/**
	 * Operators that calculate the operations
	 * @author Javier de Pedro Lopez
	 * @author Adrian Casimiro Alvarez
	 */
	public static class Operators implements FitnessOperator, StopOperator {
		@Override
		public boolean mustContinue(GeneticAlgorithm algorithm) {
			return true;
		}
		
		@Override
		public double fitnessFunction(Chromosome chromosome, GeneticAlgorithm algorithm) {
			double decimals = (int) Math.pow(10, NUMBER_OF_DECIMALS);
			double x = Double.parseDouble(chromosome.getGen(0).getValue())/decimals;
			double y = Double.parseDouble(chromosome.getGen(1).getValue())/decimals;
			return x + Math.pow(y, 2);
		}
	}

}
