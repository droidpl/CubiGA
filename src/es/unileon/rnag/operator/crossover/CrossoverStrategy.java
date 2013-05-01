package es.unileon.rnag.operator.crossover;

public abstract class CrossoverStrategy implements CrossoverOperator{
	
	// ATTRIBUTES //
	private double crossoverProbability;
	
	
	// METHOD //
	public void setCrossoverProbability(double crossoverProbability){
		this.crossoverProbability = crossoverProbability;
	}
	
	public double getCrossoverProbability(){
		return this.crossoverProbability;
	}
	
	
	
	
}
