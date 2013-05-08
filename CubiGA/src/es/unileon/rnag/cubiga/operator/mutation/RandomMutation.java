package es.unileon.rnag.cubiga.operator.mutation;

import java.util.Random;

import es.unileon.rnag.cubiga.chromosome.Chromosome;

/**
 * Class that do a random mutation depending on the probability
 * @author Adrian Casimiro Alvarez
 * @author Javier de Pedro Lopez
 */
public class RandomMutation extends MutationStrategy{

	@Override
	public Chromosome doMutation(Chromosome chromosome) {
		Random rand = new Random();
		Double probability;
		for(int i=0; i<chromosome.length(); i++){
			 probability = rand.nextDouble();
			 if(probability < this.getMutationProbability()){
				 chromosome.mutateGen(i);
			 }
		}

		return chromosome;
	}

}
