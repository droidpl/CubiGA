package es.unileon.rnag.operator.crossover;

import es.unileon.rnag.chromosome.Chromosome;

/**
 * Class that make the Single Point chrossover
 * @author Adrian Casimiro Alvarez
 * @author Javier de Pedro Lopez
 */
public class SinglePoint extends CrossoverStrategy{

	@Override
	public CrossoverElement doCrossover(CrossoverElement crossoverElement) {
		Chromosome firstChromosome = crossoverElement.getFirstChromosome();
		Chromosome secondChromosome = crossoverElement.getSecondChromosome();
		
		
		
		return null;
	}

}
