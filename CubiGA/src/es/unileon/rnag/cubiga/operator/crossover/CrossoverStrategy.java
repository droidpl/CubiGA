package es.unileon.rnag.cubiga.operator.crossover;

/**
 * Abstract class that need to be extended to create a new crossover strategy
 * @author Adrian Casimiro Alvarez
 * @author Javier de Pedro Lopez
 */
public abstract class CrossoverStrategy implements CrossoverOperator{
	
	/**
	 * Attribute that indicate the probability to do the crossover
	 */
	private double crossoverProbability;
	
	/**
	 * Method that change the probability to do the crossover
	 * @param crossoverProbability The new crossover probability
	 */
	public void setCrossoverProbability(double crossoverProbability){
		this.crossoverProbability = crossoverProbability;
	}
	
	/**
	 * Method that obtain the crossover probability
	 * @return The probability to do the crossover
	 */
	public double getCrossoverProbability(){
		return this.crossoverProbability;
	}
	
	/**
	 * Applies the crossover operator to two given chromosome.
	 * @param crossoverElement Structure that wraps the two chromosomes.
	 * @return A crossed structure with two crossed chromosomes.
	 */
	public abstract CrossoverElement doCrossover(CrossoverElement crossoverElement);
	
}
