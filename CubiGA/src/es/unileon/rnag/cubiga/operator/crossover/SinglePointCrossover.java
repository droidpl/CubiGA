package es.unileon.rnag.cubiga.operator.crossover;

import java.util.Random;

import es.unileon.rnag.cubiga.chromosome.Chromosome;
import es.unileon.rnag.cubiga.gen.Gen;

/**
 * Class that make the Single Point chrossover
 * @author Adrian Casimiro Alvarez
 * @author Javier de Pedro Lopez
 */
public class SinglePointCrossover extends CrossoverStrategy{

	@Override
	public CrossoverElement doCrossover(CrossoverElement crossoverElement) {
		Random ran = new Random();
		double probability = ran.nextDouble();
		
		if(probability < getCrossoverProbability()){
			Chromosome firstChromosome = crossoverElement.getFirstChromosome();
			Chromosome secondChromosome = crossoverElement.getSecondChromosome();
			
			int length = firstChromosome.length();
			
			int position = ran.nextInt(length);
			
			Gen[] sliceFirstChromosome = firstChromosome.getChromosomeSlice(0, position);
			Gen[] sliceSecondChromosome = secondChromosome.getChromosomeSlice(0, position);
			
			firstChromosome.setChromosomeSlice(sliceSecondChromosome, 0);
			secondChromosome.setChromosomeSlice(sliceFirstChromosome, 0);
			
			CrossoverElement result = new CrossoverElement(firstChromosome, secondChromosome);
		
			return result;
		}
		else{
			return crossoverElement;
		}
	}

}
