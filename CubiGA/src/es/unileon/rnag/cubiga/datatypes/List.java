package es.unileon.rnag.cubiga.datatypes;

import java.util.Random;

/**
 * The list of string possibilities of a ListVector
 * @see ListVector
 * @author Javier de Pedro Lopez
 * @author Adrian Casimiro Alvarez
 */
public class List {
	
	/**
	 * The possibilities of the ListVector chromosome type
	 */
	private String[] possibilities;
	
	/**
	 * Constructor of the list
	 * @param possibilities Given possibilities
	 */
	public List(String... possibilities){
		this.possibilities = possibilities;
	}
	
	/**
	 * Allows to retrieve a random element from the passed list
	 * @return Random string for the given list.
	 */
	public String getRandomPossibility(){
		Random rand = new Random();
		return possibilities[rand.nextInt(possibilities.length)];
	}
}
