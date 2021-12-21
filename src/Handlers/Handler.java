package Handlers;

public interface Handler {
	public void setNextChain(Handler nextChain);
	public int handle(int index, String input);
	
}
