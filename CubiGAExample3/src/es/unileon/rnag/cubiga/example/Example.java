package es.unileon.rnag.cubiga.example;

import es.unileon.rnag.cubiga.GeneticAlgorithm;
import es.unileon.rnag.cubiga.chromosome.Chromosome;
import es.unileon.rnag.cubiga.datatypes.List;
import es.unileon.rnag.cubiga.datatypes.ListVector;
import es.unileon.rnag.cubiga.operator.FitnessOperator;
import es.unileon.rnag.cubiga.operator.GeneticStrategy;
import es.unileon.rnag.cubiga.operator.StopOperator;
import es.unileon.rnag.cubiga.operator.crossover.CrossoverFactory.CrossoverType;
import es.unileon.rnag.cubiga.operator.selection.SelectionFactory.SelectionType;
import es.unileon.rnag.cubiga.oprerator.mutation.MutationFactory.MutationType;

/**
 * Example of the CubiGA with ListVector
 * @author Adrian Casimiro Alvarez
 * @author Javier de Pedro Lopez
 */
public class Example {
	private static final Double CROSSOVER_PROBABILITY = 0.7;
	private static final Double MUTATION_PROBABILITY = 0.05;
	private static final int POPULATION = 5;
	private static final int NUMBER_OF_GENERATIONS = 20;
	
	/**
	 * Executes the genetic algorithm
	 * @param args External arguments
	 */
	public static void main(String[] args) {
		GeneticStrategy geneticStrategy = new GeneticStrategy(SelectionType.ROULETTE, CrossoverType.TWO_POINT, MutationType.RANDOM_MUTATION);
		FitnessStop fitnessStop = new FitnessStop();
		GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(geneticStrategy, fitnessStop, fitnessStop);
		
		List[] list = new List[]
				{
					new List("red", "yellow", "green"),
					new List("light1", "light2", "light3", "light4", "light5", "light6"),
					new List("carsWaiting", "lorriesWaiting", "bikesWaiting")
				};
		ListVector listVector = new ListVector(list);
		//Initialize the ag
		geneticAlgorithm.initialize(POPULATION, listVector, NUMBER_OF_GENERATIONS, CROSSOVER_PROBABILITY, MUTATION_PROBABILITY);
		//Evolve
		geneticAlgorithm.evolve();
		//Print results
		System.out.println("Chromosome: " + geneticAlgorithm.getFittest() + " \nFitness: " + geneticAlgorithm.getFittest().getFitness());
	}
	
	/**
	 * Class that implements the fitness and the stop functions
	 * @author Adrian Casimiro Alvarez
	 * @author Javier de Pedro Lopez
	 */
	public static class FitnessStop implements FitnessOperator,StopOperator{
		
		@Override
		public boolean mustContinue(GeneticAlgorithm algorithm) {
			return true;
		}
	
		@Override
		public double fitnessFunction(Chromosome chromosome, GeneticAlgorithm algorithm) {
			String genColor = chromosome.getGen(0).getValue();
			String genLight = chromosome.getGen(1).getValue();
			String genVehicle = chromosome.getGen(2).getValue();
			double points = 0;
			if (genColor.equals("red")) points += 0;
			else if (genColor.equals("yellow")) points += 2.5;
			else if (genColor.equals("green")) points += 5;
			if (genLight.equals("light1")) points += 0.5;
			else if (genLight.equals("light2")) points += 1;
			else if (genLight.equals("light3")) points += 1.5;
			else if (genLight.equals("light4")) points += 2;
			else if (genLight.equals("light5")) points += 2.5;
			else if (genLight.equals("light6")) points += 3;
			if (genVehicle.equals("carsWaiting")) points += 2.5;
			else if(genVehicle.equals("lorriesWaiting")) points += 5;
			else if (genVehicle.equals("bikesWaiting")) points += 0;
			return points;
		}
	}
}
