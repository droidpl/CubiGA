package es.unileon.rnag.cubiga.datatypes;

import java.util.Random;

import es.unileon.rnag.cubiga.chromosome.BitChromosome;
import es.unileon.rnag.cubiga.chromosome.Chromosome;
import es.unileon.rnag.cubiga.gen.BitGen;
import es.unileon.rnag.cubiga.gen.Gen;

/**
 * Class that create a bit vector, e.i. list of bits
 * @author Adrian Casimiro Alvarez
 * @author Javier de Pedro López
 */
public class BitVector extends GeneticType{
	
	/**
	 * The amount bits
	 */
	private int length;
	
	/**
	 * Constructor of the bit vector data type
	 * @param length The amount of bits that the chromosomes generated mus have
	 */
	public BitVector(int length){
		if (length < 1 ) throw new RuntimeException("The length of the BitVector data type must be greater than 0");
		this.length = length;
	}
	
	@Override
	public Chromosome generateChromosome() {
		return new BitChromosome(this.length, this);
	}

	@Override
	public Gen generateGen(int index) {
		Random random = new Random();
		return new BitGen(random.nextBoolean(), this);
	}
}
