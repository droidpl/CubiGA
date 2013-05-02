package es.unileon.rnag.cubiga.chromosome;

import java.util.ArrayList;
import java.util.Iterator;

import es.unileon.rnag.cubiga.datatypes.GeneticType;
import es.unileon.rnag.cubiga.gen.BitGen;
import es.unileon.rnag.cubiga.gen.Gen;

/**
 * Chromosome composed of bits.
 * @author Javier de Pedro Lopez
 * @author Adrian Casimiro Alvarez
 */
public class BitChromosome extends Chromosome {

	/**
	 * Chromosome that is a set of bits
	 */
	private boolean[] chromosome;
	
	/**
	 * Constructor of the class BitChromosome
	 * @param chromosomeLength The length of the chromosome
	 * @param type The genetic type generator
	 */
	public BitChromosome(int chromosomeLength, GeneticType type){
		if (chromosomeLength < 1) throw new RuntimeException("BitChromosome must have a longitude greater than 0.");
		boolean[] bitSet = new boolean[chromosomeLength];
		for (int i = 0; i < chromosomeLength; i++) {
			boolean bit = Math.random() > 0.5; //If random > 0.5 the bit is 1 in other case is 0
			bitSet[i] = bit;
		}
		this.chromosome = bitSet;
		this.geneticType = type;
	}
	
	/**
	 * Performs a copy of the BitChromosome
	 * @param chromosome The chromosome copy
	 */
	public BitChromosome(BitChromosome chromosome){
		this.chromosome = new boolean[chromosome.length()];
		this.geneticType = chromosome.getGeneticType();
		setFitness(chromosome.getFitness());
		setChromosomeSlice(chromosome.getChromosomeSlice(0, chromosome.length()), 0);
	}
	
	@Override
	public int length() {
		return this.chromosome.length;
	}
	
	@Override
	public void mutateGen(int index) {
		if (index > this.chromosome.length || index < 0) throw new RuntimeException("The index passed is out of bounds");
		this.chromosome[index] = Boolean.valueOf(this.geneticType.generateGen(index).getValue());
	}

	@Override
	public Gen getGen(int index) {
		if (index > this.chromosome.length || index < 0) throw new RuntimeException("The index passed is out of bounds");
		return new BitGen(this.chromosome[index], this.geneticType);
	}

	@Override
	public void setGen(Gen gen, int index) {
		if (index > this.chromosome.length || index < 0) throw new RuntimeException("The index passed is out of bounds");
		//Cast to range type
		boolean bit = Boolean.valueOf(gen.getValue());
		this.chromosome[index] = bit;
	}
	
	@Override
	public Iterator<Gen> iterator() {
		ArrayList<Gen> genes = new ArrayList<Gen>();
		for (int i = 0; i < this.chromosome.length; i++) genes.add(new BitGen(this.chromosome[i], this.geneticType));
		return genes.iterator();
	}

	@Override
	public Gen[] getChromosomeSlice(int initIndex, int length) {
		if (initIndex + length > this.chromosome.length) throw new RuntimeException("Index to be retrieved for this chromosome is out of bounds");
		Gen[] genArray = new Gen[length];
		for (int i = initIndex; i < initIndex + length; i++){
			genArray[i - initIndex] = new BitGen(this.chromosome[i], this.geneticType);
		}
		return genArray;
	}

	@Override
	public void setChromosomeSlice(Gen[] chromosomeSlice, int initIndex) {
		if(initIndex + chromosomeSlice.length > chromosome.length) throw new RuntimeException("The selected slice does not fit in the position of the chromosome");
		for (int i = initIndex; i < initIndex + chromosomeSlice.length; i++){
			this.chromosome[i] = Boolean.valueOf(chromosomeSlice[i - initIndex].getValue());
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < this.chromosome.length; i++){
			builder.append(this.chromosome[i]? "1" : "0");
		}
		return builder.toString();
	}
	
	@Override
	public Chromosome copyChromosome(){
		return new BitChromosome(this);
	}
}
