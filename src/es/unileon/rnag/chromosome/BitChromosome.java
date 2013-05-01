package es.unileon.rnag.chromosome;

import java.util.BitSet;
import java.util.Iterator;

import es.unileon.rnag.datatypes.GeneticType;
import es.unileon.rnag.gen.Gen;

public class BitChromosome extends Chromosome {

	/**
	 * Chromosome that is a set of bits.
	 */
	private BitSet chromosome;
	
	/**
	 * Constructor of the class BitChromosome.
	 * @param chromosomeLength The length of the chromosome.
	 * @param type The genetic type generator.
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Gen> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
