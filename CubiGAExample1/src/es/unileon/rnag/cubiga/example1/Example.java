package es.unileon.rnag.cubiga.example1;

import es.unileon.rnag.cubiga.GeneticAlgorithm;
import es.unileon.rnag.cubiga.chromosome.Chromosome;
import es.unileon.rnag.cubiga.operator.FitnessOperator;
import es.unileon.rnag.cubiga.operator.GeneticStrategy;
import es.unileon.rnag.cubiga.operator.StopOperator;
import es.unileon.rnag.cubiga.operator.crossover.CrossoverFactory;
import es.unileon.rnag.cubiga.operator.crossover.CrossoverFactory.CrossoverType;
import es.unileon.rnag.cubiga.operator.selection.SelectionFactory;
import es.unileon.rnag.cubiga.operator.selection.SelectionFactory.SelectionType;
import es.unileon.rnag.cubiga.oprerator.mutation.MutationFactory.MutationType;

/**
 * Range vector genetic algorithm example
 * @author Javier de Pedro Lopez
 * @author Adrian Casimiro Alvarez
 */
public class Example {

	/**
	 * Executes the genetic algorithm
	 * @param args External algorithms
	 */
	public static void main(String[] args) {
		GeneticStrategy strategy = new GeneticStrategy(SelectionType.ROULETTE, CrossoverType.SINGLE_POINT, MutationType.RANDOM_MUTATION);
		Operators operators = new Operators();
		GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(strategy, operators, operators);
		//TODO complete example
	}
	
	public static class Operators implements FitnessOperator, StopOperator {
		@Override
		public boolean mustContinue(GeneticAlgorithm algorithm) {
			return true;
		}
	
		@Override
		public double fitnessFunction(Chromosome chromosome, GeneticAlgorithm algorithm) {
			return 0;
		}
	}

}
