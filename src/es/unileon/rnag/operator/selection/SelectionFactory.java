package es.unileon.rnag.operator.selection;

/**
 * Class that generate a SelectionStrategy
 * @author Adrian Casimiro Alvarez
 * @author Javier de Pedro Lopez
 */
public class SelectionFactory {
	/**
	 * Enumeration type that specify the SelectionStrategies that can be created
	 * @author Adrian Casimiro Alvarez
	 * @author Javier de Pedro López
	 */
	public enum SelectionType{
		TOURNAMENT,ROULETTE
	}
	
	/**
	 * Method that generate the SelectionStrategy
	 * @param selectionType Enumeration type that specify the SelectionStrategy to be created
	 * @return The strategy
	 */
	public SelectionStrategy makeSelectionStrategy(SelectionType selectionType){
		SelectionStrategy selectionStrategy = null;
		switch (selectionType) {
		case TOURNAMENT:
			selectionStrategy = new TournamentSelection();
			break;

		case ROULETTE:
			selectionStrategy = new RouletteSelection();
			break;
		default:
			throw new RuntimeException("The selected strategy does not exists");
		}

		return selectionStrategy;
	}
}
