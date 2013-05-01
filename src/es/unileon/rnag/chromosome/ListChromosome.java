package es.unileon.rnag.chromosome;

import java.util.Iterator;

import es.unileon.rnag.datatypes.GeneticType;
import es.unileon.rnag.gen.Gen;
import es.unileon.rnag.gen.ListGen;

public class ListChromosome extends Chromosome {

	private String[] chromosome;
	
	public ListChromosome(String[] posibleValues, GeneticType type){
		//TODO generate the chromosome
		this.geneticType = type;
		
	}
	
	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Gen getGen(int index) {
		return new ListGen(chromosome[index], this.geneticType);
	}

	@Override
	public Iterator<Gen> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
