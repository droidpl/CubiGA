package es.unileon.rnag.cubiga.operator;

import es.unileon.rnag.cubiga.GeneticAlgorithm;
import es.unileon.rnag.cubiga.chromosome.Chromosome;

/**
 * Conains all needed operations to stop the genetic algorithm.
 * @author Javier de Pedro Lopez
 * @author Adrian Casimiro Alvarez
 * @version 1.0
 */
public interface FitnessOperator {
	/**
	 * Calculates a value that represents the fitness of a chromosome.
	 * @param chromosome the chromosome that must calculate the fitness.
	 * @param algorithm the current genetic algorithm.
	 * @return The calculated fitness value for a chromosome.
	 */
	public double fitnessFunction(Chromosome chromosome, GeneticAlgorithm algorithm);
}
