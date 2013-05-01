package es.unileon.rnag.chromosome;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;

import es.unileon.rnag.datatypes.GeneticType;
import es.unileon.rnag.gen.BitGen;
import es.unileon.rnag.gen.Gen;

/**
 * Chromosome composed of bits.
 * @author Javier de Pedro Lopez
 * @author Adrian Casimiro Alvarez
 */
public class BitChromosome extends Chromosome {

	/**
	 * Chromosome that is a set of bits
	 */
	private BitSet chromosome;
	
	/**
	 * Constructor of the class BitChromosome
	 * @param chromosomeLength The length of the chromosome
	 * @param type The genetic type generator
	 */
	public BitChromosome(int chromosomeLength, GeneticType type){
		if (chromosomeLength < 1) throw new RuntimeException("BitChromosome must have a longitude greater than 0.");
		BitSet bitSet = new BitSet(chromosomeLength);
		for (int i = 0; i < chromosomeLength; i++) {
			boolean bit = Math.random() > 0.5; //If random > 0.5 the bit is 1 in other case is 0
			bitSet.set(i, bit);
		}
		this.chromosome = bitSet;
		this.geneticType = type;
	}
	
	@Override
	public int length() {
		return this.chromosome.length();
	}

	@Override
	public Gen getGen(int index) {
		if (index > this.chromosome.length() || index < 0) throw new RuntimeException("The index passed is out of bounds");
		return new BitGen(this.chromosome.get(index), this.geneticType);
	}

	@Override
	public void setGen(Gen gen, int index) {
		if (index > this.chromosome.length() || index < 0) throw new RuntimeException("The index passed is out of bounds");
		//Cast to range type
		boolean bit = Boolean.valueOf(gen.getValue());
		this.chromosome.set(index, bit);
	}
	
	@Override
	public Iterator<Gen> iterator() {
		ArrayList<Gen> genes = new ArrayList<Gen>();
		for (int i = 0; i < this.chromosome.length(); i++) genes.add(new BitGen(this.chromosome.get(i), this.geneticType));
		return genes.iterator();
	}

	@Override
	public Gen[] getChromosomeSlice(int initIndex, int length) {
		if (initIndex + length < this.chromosome.length()) throw new RuntimeException("Index to be retrieved for this chromosome is out of bounds");
		Gen[] genArray = new Gen[length];
		for (int i = initIndex; i < initIndex + length; i++){
			genArray[i - initIndex] = new BitGen(this.chromosome.get(i), this.geneticType);
		}
		return genArray;
	}

	@Override
	public void setChromosomeSlice(Gen[] chromosomeSlice, int initIndex) {
		for (int i = initIndex; i < chromosomeSlice.length; i++){
			this.chromosome.set(i, Boolean.valueOf(chromosomeSlice[i - initIndex].getValue()));
		}
	}
}
