package es.unileon.rnag.oprerator.mutation;

public class MutationStrategy {
	
	// ATTRIBUTES //
	private double mutationProbability;
	
	
	// METHOD //
	public void setMutationProbability(double mutationProbability){
		this.mutationProbability = mutationProbability;
	}
	
	public double getMutationProbability(){
		return this.mutationProbability;
	}
}
