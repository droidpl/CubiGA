package es.unileon.rnag.operator;

import es.unileon.rnag.GeneticAlgorithm;

/**
 * Conains all needed operations to stop the genetic algorithm.
 * @author Javier de Pedro Lopez
 * @author Adrian Casimiro Alvarez
 * @version 1.0
 */
public interface StopOperator {
	/**
	 * Stop condition that allows to stop the genetic algorithm.
	 * @param algorithm the current genetic algorithm.
	 * @return False if the algorithm must stop or true if it must continue.
	 */
	public boolean stopCondition(GeneticAlgorithm algorithm);
}
