package es.unileon.rnag.gen;

import es.unileon.rnag.datatypes.GeneticType;


public class ListGen extends Gen {

	private String value;
	
	public ListGen(String value, GeneticType type){
		this.value = value;
		this.geneticType = type;
	}
	
	@Override
	public void mutate() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getValue() {
		return value;
	}

}
