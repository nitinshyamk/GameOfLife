/**
 * Node.java
 * Nitin Shyamkumar(github.com/nitinshyamk)
 * 12.29.13
 * 
 * public class Node:
 * creates a symbol class for the boolean variable to store the state of a 
 * single cell. Intended to be a layer of abstraction as opposed to simply
 * storing boolean types in the grid.
 * Methods return the state - true --> alive, false --> not
 */
public class Node {
	
	private boolean state;
	
	public Node(boolean initstate){
		state = initstate;
	}
	
	public Node(){
		state = false;
	}	
	public boolean getState(){
		return state;
	}
	
	public void setState(boolean changestate){
		state = changestate;
	}
}
