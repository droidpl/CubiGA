package es.unileon.rnag.cubiga.operator.crossover;

/**
 * Interface that contains the crossover elemental operation
 * @author Javier de Pedro Lopez
 * @author Adrian Casimiro Alvarez
 * @version 1.0
 */
public interface CrossoverOperator {
	/**
	 * Applies the crossover operator to two given chromosome
	 * @param crossoverElement Structure that wraps the two chromosomes
	 * @return A crossed structure with two crossed chromosomes
	 */
	public CrossoverElement doCrossover(CrossoverElement crossoverElement);
}
