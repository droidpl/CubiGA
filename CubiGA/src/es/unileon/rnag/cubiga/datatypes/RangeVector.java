package es.unileon.rnag.cubiga.datatypes;

import es.unileon.rnag.cubiga.chromosome.Chromosome;
import es.unileon.rnag.cubiga.chromosome.RangeChromosome;
import es.unileon.rnag.cubiga.gen.Gen;
import es.unileon.rnag.cubiga.gen.RangeGen;

/**
 * Class that create a range vector, e.i. list of numbers
 * @author Adrian Casimiro Alvarez
 * @author Javier de Pedro López
 */
public class RangeVector extends GeneticType{
	
	/**
	 * Chromosome that is a list of int
	 */
	private Range[] ranges;
	
	/**
	 * Constructor of the class RangeVector that create a list from first to last of length elements
	 * @param ranges List of ranges of the genes of the chromosome
	 */
	public RangeVector(Range ... ranges){
		if (ranges.length == 0) throw new RuntimeException("There is no ranges on RangeVector");
		this.ranges = ranges;
	}

	@Override
	public Chromosome generateChromosome() {
		return new RangeChromosome(ranges, this);
	}

	@Override
	public Gen generateGen(int index) {
		return new RangeGen(ranges[index].generateNumber(), this);
	}
}
