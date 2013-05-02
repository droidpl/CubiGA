package es.unileon.rnag.cubiga.operator.selection;

import es.unileon.rnag.cubiga.chromosome.Chromosome;

/**
 * Class that implements the roulette selection
 * @author Adrian Casimiro Alvarez
 * @author Javier de Pedro Lopez
 */
public class RouletteSelection extends SelectionStrategy{

	@Override
	public Chromosome[] doSelection(Chromosome[] previousGeneration) {
		//Get the total fitness
		double totalFitness = 0;
		for(int i = 0; i < previousGeneration.length; i++){
			totalFitness += previousGeneration[i].getFitness();
		}
		
		//Create the stadistic roulette assigning values
		double[] roulette = new double[previousGeneration.length];
		double sumProb = 0;
		for (int i = 0; i < roulette.length; i++){
			sumProb +=  previousGeneration[i].getFitness() / totalFitness;
			roulette[i] = sumProb;
		}
		
		Chromosome[] newGeneration = new Chromosome[previousGeneration.length];
		for(int i = 0; i < newGeneration.length; i++){
			double selection = Math.random();
			int j = 0;
			while (selection > roulette[j]) j++;
			newGeneration[i] = previousGeneration[j];
		}
		
		return newGeneration;
	}

}
