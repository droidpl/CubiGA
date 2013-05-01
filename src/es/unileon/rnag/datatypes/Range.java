package es.unileon.rnag.datatypes;

/**
 * Class that generate the random numbers in an expecific range
 * @author Adrian Casimiro Alvarez
 * @author Javier de Pedro Lopez
 */
public class Range {
	public int first;
	public int last;
	
	/**
	 * Constructor of the class range that recive the first and the last number of the range
	 * @param first First value of the range.
	 * @param last Last value of the range.
	 */
	public Range(int first, int last){
		if(first > last){
			throw new RuntimeException("The range is not well defined");
		}
		this.first = first;
		this.last = last;
	}
	
	/**
	 * Method that return a number in the specified range
	 * @return the number in the range
	 */
	public int generateNumber(){
		return this.first + (int)(Math.random() * ((this.last - this.first) + 1));
	}
}
