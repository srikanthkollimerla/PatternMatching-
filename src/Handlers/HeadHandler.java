package Handlers;

public class HeadHandler implements Handler{
	Handler nextChain;
	char currentCharacter;
	
	public HeadHandler(char currentCharacter) {
		this.currentCharacter = currentCharacter;
	}
	
	@Override
	public void setNextChain(Handler nextChain) {
		this.nextChain = nextChain;
	}

	/*
	 * The head object will try all occurrences of characters in the string
	 *  until a match is found and returns the index
	 *  or returns -1 indicating that the pattern is not in the string. 
	 */
	@Override
	public int handle(int index, String input) {
		int result = -1;
		if(currentCharacter == '*' || currentCharacter == '.') {
			result = nextChain.handle(0, input);		
		}
		else {
			for(int i=0;i<input.length();i++) {
				if(currentCharacter == input.charAt(i)) {
					result = nextChain.handle(i, input);
					if(result != -1)    
						return result;
				}
			}
		}
		return result;
	}
}
