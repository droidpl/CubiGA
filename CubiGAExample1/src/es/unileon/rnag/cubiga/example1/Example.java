package es.unileon.rnag.cubiga.example1;

import es.unileon.rnag.cubiga.GeneticAlgorithm;
import es.unileon.rnag.cubiga.chromosome.Chromosome;
import es.unileon.rnag.cubiga.operator.FitnessOperator;
import es.unileon.rnag.cubiga.operator.GeneticStrategy;
import es.unileon.rnag.cubiga.operator.StopOperator;

/**
 * Range vector genetic algorithm example
 * @author Javier de Pedro Lopez
 * @author Adrian Casimiro Alvarez
 */
public class Example implements FitnessOperator, StopOperator{

	/**
	 * Executes the genetic algorithm
	 * @param args External algorithms
	 */
	public static void main(String[] args) {

	}

	@Override
	public boolean mustContinue(GeneticAlgorithm algorithm) {
		return true;
	}

	@Override
	public double fitnessFunction(Chromosome chromosome, GeneticAlgorithm algorithm) {
		// TODO Auto-generated method stub
		return 0;
	}

}
