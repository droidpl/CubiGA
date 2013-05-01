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

		int i;
		double total = 0;
		for(i=0; i<previousGeneration.length; i++){
			total = total + previousGeneration[i].getFitness();
		}
		
		int[] roulette = new int[100];
		int actualPosition = 0;
		double probability;
		int totalCells;
		for(i=0; i<previousGeneration.length; i++){
			probability = previousGeneration[i].getFitness() / total;
			totalCells = (int) (probability * 100);
			for(int j=0; j<totalCells; j++){
				roulette[j+actualPosition] = i;
			}
			actualPosition = actualPosition + totalCells;
		}
		
		//If it was left empty positions (this would be almost impossible)
		for(int j = actualPosition; j<100;j++){
			roulette[j] =(int) (Math.random() * previousGeneration.length);	
		}
		
		Chromosome[] newChromosome = new Chromosome[previousGeneration.length];
		for(i=0; i<previousGeneration.length; i++){
			newChromosome[i] = previousGeneration[roulette[(int)(Math.random() * 100)]];
		}
		
		return newChromosome;
	}

}
