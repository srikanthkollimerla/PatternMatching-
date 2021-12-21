package Handlers;

import Handlers.Handler;

/***
 * the objects of this class are created if there is a wild character (*)
 * in the pattern match.
 *  
 */

public class StarHandler implements Handler{
	Handler nextChain;
	char currentCharacter;
	
	public StarHandler(char currentCharacter) {
		this.currentCharacter = currentCharacter;
	}
	
	
	@Override
	public void setNextChain(Handler nextChain) {
		this.nextChain = nextChain;
	}
	
	/***
	 * @param index: indicates the current position in the iteration of the string.
	 * @param input: target string
	 */
	
	
	@Override
	public int handle(int index, String input) {
		int currentIndex = index;
		if(nextChain == null) {
			return index;
		}
		index++;
		while(index  < input.length()) {
			int res = nextChain.handle(index,input);	
				if(res != -1)
					return currentIndex;
			index++;
			if(index == input.length())
				return -1;
		}
		return -1;
	}

}
