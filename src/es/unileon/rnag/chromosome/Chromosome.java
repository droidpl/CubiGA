package es.unileon.rnag.chromosome;

import java.util.Iterator;

import es.unileon.rnag.datatypes.GeneticType;
import es.unileon.rnag.gen.Gen;

/**
 * Chromosome class that express the chromosome structure
 * @author Javier de Pedro Lopez
 * @author Adrian Casimiro Alvarez
 * @version 1.0
 */
public abstract class Chromosome {
	/**
	 * Fitness value of the chromosome
	 */
	private double fitness;
	
	/**
	 * Genetic type that is able to generate new chromosomes and genes
	 */
	protected GeneticType geneticType;
	
	/**
	 * Returns the fitness of the current chromosome
	 * @return The fitness value.
	 */
	public double getFitness(){
		return this.fitness;
	}
	
	/**
	 * Sets the fitness value for the current chromosome
	 * @param fitness The fitness to set.
	 */
	public void setFitness(double fitness){
		this.fitness = fitness;
	}
	
	/**
	 * Returns the genetic type that is able to generate new chromosomes and genes
	 * @return The genetic type
	 */
	public GeneticType getGeneticType(){
		return this.geneticType;
	}
	
	/**
	 * The lenght of this chromosomes, that is, the number of genes
	 * @return the length of the chromosomes
	 */
	public abstract int length();
	
	/**
	 * Mutates the value of the given gen
	 * @param index The index of the gen that will be mutated.
	 */
	public abstract void mutateGen(int index);
	
	/**
	 * The gen that is present in an index
	 * @param index The position of the gen
	 * @return The gen on a position
	 */
	public abstract Gen getGen(int index);
	
	/**
	 * Adds a new gen to a given position
	 * @param gen The gent that will be added
	 * @param index The position of the gen. Must be in range
	 */
	public abstract void setGen(Gen gen, int index);
	
	/**
	 * Iterator that can iterate over all the genes of a chromosome
	 * @return The iterator for the chromosome
	 */
	public abstract Iterator<Gen> iterator();
	
	/**
	 * Returns a slice of the given chromosome
	 * @param initIndex initial index
	 * @param length end index
	 * @return A slice with the elements form initIndex and endIndex
	 */
	public abstract Gen[] getChromosomeSlice(int initIndex, int length);
	
	/**
	 * Adds a slice to the chromosome on a given index
	 * @param chromosomeSlice The chromosome slice
	 * @param initIndex the initial index
	 */
	public abstract void setChromosomeSlice(Gen[] chromosomeSlice, int initIndex);
}
