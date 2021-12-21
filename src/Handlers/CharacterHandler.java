package Handlers;

/***
 * the objects of this class are created if there are characters
 * in the pattern match.
 *  
 */


public class CharacterHandler implements Handler{
	Handler nextChain;
	char currentCharacter;
	
	public CharacterHandler(char currentCharacter) {
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
		if(currentCharacter == input.charAt(index) && nextChain == null) {
			return index;
		}
		if(index+1 < input.length() && currentCharacter == input.charAt(index)) {
			if(nextChain==null) {
				return index;
			}
			else {
				int	res = nextChain.handle(index+1, input);
				if(res!=-1)
					return index;
			}
		}
		return -1;
	}

}
