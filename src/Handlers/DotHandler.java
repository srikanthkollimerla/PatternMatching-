package Handlers;
/***
 * the objects of this class are created if there is a wild character (.)
 * in the pattern match.
 *  
 */
public class DotHandler implements Handler{
	Handler nextChain;
	char currentCharacter;
	
	public DotHandler(char currentCharacter) {
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
		if(nextChain==null) {
			
			return index;
		}
		else {
			int res = nextChain.handle(index+1,input);
			if(res!=-1)
				return index;
		}
		return -1;
	}

	
}
