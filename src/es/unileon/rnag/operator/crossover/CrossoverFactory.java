package es.unileon.rnag.operator.crossover;

/**
 * Class that generate a CrossoverStrategy
 * @author Adrian Casimiro Alvarez
 * @author Javier de Pedro Lopez
 */
public class CrossoverFactory {
	/**
	 * Enumeration type that specify the CrossoverStrategy that can be created
	 * @author Adrian Casimiro Alvarez
	 * @author Javier de Pedro Lopez
	 */
	public enum CrossoverType{
		SINGLE_POINT,TWO_POINT
	}
	
	/**
	 * Method that generate the CrossoverStrategy
	 * @param selectionType Enumeration type that specify the CrossoverStrategy to be created
	 * @return
	 */
	public CrossoverStrategy makeCrossoverStrategy(CrossoverType crossoverType){
		CrossoverStrategy crossoverStrategy = null;
		switch (crossoverType) {
		case SINGLE_POINT:
			crossoverStrategy = new SinglePoint();
			break;

		case TWO_POINT:
			crossoverStrategy = new TwoPoint();
			break;
		default:
			throw new RuntimeException("The selected strategy does not exists");
		}

		return crossoverStrategy;
	}
}
