package es.unileon.rnag.cubiga.operator.selection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import es.unileon.rnag.cubiga.chromosome.Chromosome;

/**
 * Class that implements the tournament selection
 * @author Adrian Casimiro Alvarez
 * @author Javier de Pedro Lopez
 */
public class TournamentSelection extends SelectionStrategy{
	private static final float PROPORTION_ELEMENTS_TO_COMPARE = 0.1f;
	
	@Override
	public Chromosome[] doSelection(Chromosome[] previousGeneration) {
		Chromosome[] newGeneration = new Chromosome[previousGeneration.length];
		//Select the number of participants on the tournament min = 2
		int tournamentParticipantsNumber = (int) (previousGeneration.length * PROPORTION_ELEMENTS_TO_COMPARE);
		if(tournamentParticipantsNumber < 2) tournamentParticipantsNumber = 2;
		Chromosome[] tournamentParticipants = new Chromosome[tournamentParticipantsNumber];
		int position;
		Random rand = new Random();
		for(int i = 0; i < newGeneration.length; i++){
			for(int j = 0; j < tournamentParticipants.length; j++){
				position = rand.nextInt(previousGeneration.length);
				tournamentParticipants[j] = previousGeneration[position];
			}
			//New generation element is the result of the fight on the tournament
			newGeneration[i] = fight(tournamentParticipants);
		}
		
		return newGeneration;
	}
	
	/**
	 * Method that do the tournament between some chromosomes
	 * @param tournamentParticipants The participants in the tournament
	 * @return The winner (the best chromosome)
	 */
	private Chromosome fight(Chromosome[] tournamentParticipants){
		Arrays.sort(tournamentParticipants,  Collections.reverseOrder());
		return tournamentParticipants[0];
	}

}
