package es.unileon.rnag.datatypes;

import java.util.Random;

import es.unileon.rnag.chromosome.Chromosome;
import es.unileon.rnag.chromosome.ListChromosome;
import es.unileon.rnag.gen.Gen;
import es.unileon.rnag.gen.ListGen;

public class ListVector extends GeneticType{

	private String[] posibilities;
	
	public ListVector(String[] posibilities){
		this.posibilities = posibilities;
	}
	
	@Override
	public Chromosome generateChromosome() {
		return new ListChromosome(posibilities, this);
	}

	@Override
	public Gen getGen(int index) {
		Random random = new Random(posibilities.length);
		return new ListGen(posibilities[random.nextInt()], this);
	}

}
