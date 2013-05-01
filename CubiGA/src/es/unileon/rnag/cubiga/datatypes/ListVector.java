package es.unileon.rnag.cubiga.datatypes;

import es.unileon.rnag.cubiga.chromosome.Chromosome;
import es.unileon.rnag.cubiga.chromosome.ListChromosome;
import es.unileon.rnag.cubiga.gen.Gen;
import es.unileon.rnag.cubiga.gen.ListGen;

/**
 * Class that encapsulates genes with list type
 * @author Adrian Casimiro Alvarez
 * @author Javier de Pedro Lopez
 */
public class ListVector extends GeneticType{

	/**
	 * String chain posibilities of this type
	 */
	private List[] posibilities;
	
	/**
	 * Constructor of the list vector posibilities
	 * @param posibilities The posibilities on this gen
	 */
	public ListVector(List[] posibilities){
		if (posibilities.length == 0) throw new RuntimeException("There are no posibilities on the passed ListVector");
		this.posibilities = posibilities;
	}
	
	@Override
	public Chromosome generateChromosome() {
		return new ListChromosome(posibilities, this);
	}

	@Override
	public Gen generateGen(int index) {
		return new ListGen(posibilities[index].getRandomPossibility(), this);
	}

}
