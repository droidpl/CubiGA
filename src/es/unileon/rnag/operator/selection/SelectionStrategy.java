package es.unileon.rnag.operator.selection;

public class SelectionStrategy {
	
	// ATTRIBUTES //
	private double selectionProbability;
	
	
	// METHOD //
	public void setSelectionProbability(double selectionProbability){
		this.selectionProbability = selectionProbability;
	}
	
	public double getSelectionProbability(){
		return this.selectionProbability;
	}
}
