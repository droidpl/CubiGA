package es.unileon.rnag.chromosome;

import java.util.Iterator;

import es.unileon.rnag.datatypes.GeneticType;
import es.unileon.rnag.gen.Gen;

/**
 * Chromosome class that express the chromosome structure.
 * @author Javier de Pedro Lopez
 * @author Adrian Casimiro Alvarez
 * @version 1.0
 */
public abstract class Chromosome {
	/**
	 * Fitness value of the chromosome.
	 */
	private double fitness;
	
	/**
	 * Genetic type that is able to generate new chromosomes and genes.
	 */
	protected GeneticType geneticType;
	
	/**
	 * Returns the fitness of the current chromosome.
	 * @return The fitness value.
	 */
	public double getFitness(){
		return this.fitness;
	}
	
	/**
	 * Sets the fitness value for the current chromosome.
	 * @param fitness The fitness to set.
	 */
	public void setFitness(double fitness){
		this.fitness = fitness;
	}
	
	/**
	 * Returns the genetic type that is able to generate new chromosomes and genes.
	 * @return The genetic type.
	 */
	public GeneticType getGeneticType(){
		return this.geneticType;
	}
	
	/**
	 * The lenght of this chromosomes, that is, the number of genes.
	 * @return the length of the chromosomes.
	 */
	public abstract int length();
	
	/**
	 * The gen that is present in an index.
	 * @param index The position of the gen.
	 * @return The gen on a position.
	 */
	public abstract Gen getGen(int index);
	
	/**
	 * Iterator that can iterate over all the genes of a chromosome.
	 * @return The iterator for the chromosome.
	 */
	public abstract Iterator<Gen> iterator();
}
