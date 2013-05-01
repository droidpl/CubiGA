package es.unileon.rnag.chromosome;

import java.util.Iterator;

import es.unileon.rnag.datatypes.GeneticType;
import es.unileon.rnag.datatypes.Range;
import es.unileon.rnag.gen.Gen;
import es.unileon.rnag.gen.RangeGen;

public class RangeChromosome extends Chromosome {

	/**
	 * Chromosome that is a list of int
	 */
	private int[] chromosome;
	
	/**
	 * Constructor of the range chromosome.
	 * @param values The values of the genes.
	 * @param type The genetic type generator.
	 */
	public RangeChromosome(Range[] ranges, GeneticType type){
		if(ranges.length == 0) throw new RuntimeException("The RangeChromosome generated has no values.");
		this.chromosome = new int[ranges.length];
		int i = 0;
		for (Range range : ranges) {
			this.chromosome[i] = range.generateNumber();
			i++;
		}
		this.geneticType = type;
	}
	
	@Override
	public int length() {
		return chromosome.length;
	}

	@Override
	public Gen getGen(int index) {
		return new RangeGen(chromosome[index], this.geneticType);
	}

	@Override
	public Iterator<Gen> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
