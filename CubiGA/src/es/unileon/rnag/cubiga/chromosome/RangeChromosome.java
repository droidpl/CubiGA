package es.unileon.rnag.cubiga.chromosome;

import java.util.ArrayList;
import java.util.Iterator;

import es.unileon.rnag.cubiga.datatypes.GeneticType;
import es.unileon.rnag.cubiga.datatypes.Range;
import es.unileon.rnag.cubiga.gen.Gen;
import es.unileon.rnag.cubiga.gen.RangeGen;

/**
 * Chromosome created with ranges. It does not save those ranges, only the numbers
 * between the given ranges
 * @author Adrian Casimiro Alvarez
 * @author Javier de Pedro Lopez
 */
public class RangeChromosome extends Chromosome {

	/**
	 * Chromosome that is a list of int
	 */
	private int[] chromosome;
	
	/**
	 * Constructor of the range chromosome
	 * @param ranges The values of the genes
	 * @param type The genetic type generator
	 */
	public RangeChromosome(Range[] ranges, GeneticType type){
		if(ranges.length == 0) throw new RuntimeException("The RangeChromosome generated has no values.");
		this.chromosome = new int[ranges.length];
		//Copy the ranges
		int i = 0;
		for (Range range : ranges) {
			this.chromosome[i] = range.generateNumber();
			i++;
		}
		this.geneticType = type;
	}
	
	/**
	 * Performs a copy of the RangeChromosome
	 * @param chromosome The chromosome copy
	 */
	public RangeChromosome(RangeChromosome chromosome){
		this.chromosome = new int[chromosome.length()];
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
		try{
			this.chromosome[index] = Integer.valueOf(this.geneticType.generateGen(index).getValue());
		}catch(NumberFormatException ex){
			throw new RuntimeException("One of the chromosomes in range vector belongs to another type. Only one type per algorithm is supported");
		}
	}
	
	@Override
	public Gen getGen(int index) {
		if (index > this.chromosome.length || index < 0) throw new RuntimeException("The index passed is out of bounds");
		return new RangeGen(this.chromosome[index], this.geneticType);
	}

	@Override
	public void setGen(Gen gen, int index) {
		if (index > this.chromosome.length || index < 0) throw new RuntimeException("The index passed is out of bounds");
		//Cast to range type
		try{
			int range = Integer.valueOf(gen.getValue());
			this.chromosome[index] = range;
		}catch(NumberFormatException ex){
			throw new RuntimeException("One of the chromosomes in range vector belongs to another type. Only one type per algorithm is supported");
		}
	}
	
	@Override
	public Iterator<Gen> iterator() {
		ArrayList<Gen> genes = new ArrayList<Gen>();
		for (int i = 0; i < this.chromosome.length; i++) genes.add(new RangeGen(this.chromosome[i], this.geneticType));
		return genes.iterator();
	}

	@Override
	public Gen[] getChromosomeSlice(int initIndex, int length) {
		if (initIndex + length > this.chromosome.length) throw new RuntimeException("Index to be retrieved for this chromosome is out of bounds");
		Gen[] genArray = new Gen[length];
		for (int i = initIndex; i < initIndex + length; i++){
			genArray[i - initIndex] = new RangeGen(this.chromosome[i], this.geneticType);
		}
		return genArray;
	}

	@Override
	public void setChromosomeSlice(Gen[] chromosomeSlice, int initIndex) {
		if(initIndex + chromosomeSlice.length > chromosome.length) throw new RuntimeException("The selected slice does not fit in the position of the chromosome");
		for (int i = initIndex; i < initIndex + chromosomeSlice.length; i++){
			try{
				this.chromosome[i] = Integer.valueOf(chromosomeSlice[i - initIndex].getValue());
			}catch(NumberFormatException ex){
				throw new RuntimeException("One of the chromosomes in range vector belongs to another type. Only one type per algorithm is supported");
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < this.chromosome.length; i++){
			builder.append(this.chromosome[i] + " ");
		}
		return builder.toString();
	}
	
	@Override
	public Chromosome copyChromosome(){
		return new RangeChromosome(this);
	}
}
