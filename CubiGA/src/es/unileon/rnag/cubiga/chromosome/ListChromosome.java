package es.unileon.rnag.cubiga.chromosome;

import java.util.ArrayList;
import java.util.Iterator;

import es.unileon.rnag.cubiga.datatypes.GeneticType;
import es.unileon.rnag.cubiga.datatypes.List;
import es.unileon.rnag.cubiga.gen.Gen;
import es.unileon.rnag.cubiga.gen.ListGen;

/**
 * Chromosome that represent a list of string elements
 * @author Javier de Pedro Lopez
 * @author Adrian Casimiro Alvarez
 */
public class ListChromosome extends Chromosome {

	/**
	 * The chromosome composed of string possibilities given on ListVector
	 */
	private String[] chromosome;
	
	/**
	 * Constructor of the chromosome
	 * @param possibleValues List type with possible values for the chromosome
	 * @param type The genetic type
	 */
	public ListChromosome(List[] possibleValues, GeneticType type){
		this.geneticType = type;
		this.chromosome = new String[possibleValues.length];
		for (int i = 0; i < possibleValues.length; i++){
			this.chromosome[i] = possibleValues[i].getRandomPossibility();
		}
	}
	
	/**
	 * Performs a copy of the ListChromosome
	 * @param chromosome The chromosome copy
	 */
	public ListChromosome(ListChromosome chromosome){
		this.chromosome = new String[chromosome.length()];
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
		this.chromosome[index] = this.geneticType.generateGen(index).getValue();
	}

	@Override
	public Gen getGen(int index) {
		if (index > this.chromosome.length || index < 0) throw new RuntimeException("The index passed is out of bounds");
		return new ListGen(this.chromosome[index], this.geneticType);
	}

	@Override
	public void setGen(Gen gen, int index) {
		if (index > this.chromosome.length || index < 0) throw new RuntimeException("The index passed is out of bounds");
		//Cast to range type
		String listElement = gen.getValue();
		this.chromosome[index] = listElement;
	}
	
	@Override
	public Iterator<Gen> iterator() {
		ArrayList<Gen> genes = new ArrayList<Gen>();
		for (int i = 0; i < this.chromosome.length; i++) genes.add(new ListGen(this.chromosome[i], this.geneticType));
		return genes.iterator();
	}

	@Override
	public Gen[] getChromosomeSlice(int initIndex, int length) {
		if (initIndex + length > this.chromosome.length) throw new RuntimeException("Index to be retrieved for this chromosome is out of bounds");
		Gen[] genArray = new Gen[length];
		for (int i = initIndex; i < initIndex + length; i++){
			genArray[i - initIndex] = new ListGen(this.chromosome[i], this.geneticType);
		}
		return genArray;
	}

	@Override
	public void setChromosomeSlice(Gen[] chromosomeSlice, int initIndex) {
		if(initIndex + chromosomeSlice.length > chromosome.length) throw new RuntimeException("The selected slice does not fit in the position of the chromosome");
		for (int i = initIndex; i < initIndex + chromosomeSlice.length; i++){
			this.chromosome[i] = chromosomeSlice[i - initIndex].getValue();
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
		return new ListChromosome(this);
	}
}
