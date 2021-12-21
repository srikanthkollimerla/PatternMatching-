package main;
import Handlers.*;

/**
 * 
 * @author Srikanth Kollimerla
 * Red Id: 825852359
 * Assignment - 4 
 *
 */


public class Match {
	
	String pattern;
	
	public Match(String pattern) {
		this.pattern = pattern;
	}
	
	/**
	 * this method helps to create different objects based on if the
	 * given character is alphabet or wild characters.
	 * Then the first character in the pattern and the target string
	 * are passed to head for pattern matching.
	 */

	public int findFirstIn(String inputString) {
		Handler head;
		Handler previous;
		Handler current;
		char[] input = new char[pattern.length()];
		input = pattern.toCharArray();
		
		head = new HeadHandler(input[0]);
		previous = head;

		for(int i=0; i< input.length; i++) {
			if(input[i] == '.') {
				current = new DotHandler(input[i]);
				previous.setNextChain(current);
				previous = current;
			}
			else if(input[i] == '*') {
				current = new StarHandler(input[i]);
				previous.setNextChain(current);
				previous = current;
			}
			else {
				current = new CharacterHandler(input[i]);
				previous.setNextChain(current);
				previous = current;
			}
		}
		
		return head.handle(0, inputString);
	}
		
}
