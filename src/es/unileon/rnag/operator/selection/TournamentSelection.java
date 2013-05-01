package es.unileon.rnag.operator.selection;

import java.util.Random;

import es.unileon.rnag.chromosome.Chromosome;

/**
 * Class that implements the tournament selection
 * @author Adrian Casimiro Alvarez
 * @author Javier de Pedro López
 */
public class TournamentSelection extends SelectionStrategy{
	private static final float PROPORTION_ELEMENTS_TO_COMPARE = 1/10;
	
	@Override
	public Chromosome[] doSelection(Chromosome[] previousGeneration) {
		Chromosome[] newGeneration = new Chromosome[previousGeneration.length];
		
		int tournamentParticipantsNumber = (int) (previousGeneration.length * PROPORTION_ELEMENTS_TO_COMPARE);
		if(tournamentParticipantsNumber < 2) tournamentParticipantsNumber = 2;
		Chromosome[] tournamentParticipants = new Chromosome[tournamentParticipantsNumber];
		int position;
		Random rand = new Random();
		for(int i=0; i<previousGeneration.length; i++){
			for(int j=0; j<tournamentParticipantsNumber; j++){
				position = rand.nextInt(previousGeneration.length);
				tournamentParticipants[j] = previousGeneration[position];
			}
			newGeneration[i] = this.fight(tournamentParticipants);
		}
		
		return newGeneration;
	}
	
	/**
	 * Method that do the tournament between some chromosomes
	 * @param tournamentParticipants The participants in the tournament
	 * @return The winner (the best chromosome)
	 */
	private Chromosome fight(Chromosome[] tournamentParticipants){
		Chromosome bestChromosome = tournamentParticipants[0];
		for(int i=1; i<tournamentParticipants.length; i++){
			if(bestChromosome.getFitness() < tournamentParticipants[i].getFitness()) bestChromosome = tournamentParticipants[i];
		}
		return bestChromosome;
	}

}
