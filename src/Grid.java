
/**
 * Grid.java
 * Nitin Shyamkumar(github.com/nitinshyamk)
 * 12.29.13
 * 
 * public class Grid:
 * stores a two dimensional array of nodes for processing and
 * coordinating data. Intended to be self contained.
 */
import java.util.Random;
public class Grid {
	private int sizex;
	private int sizey;
	private Node grid[][];
	
	/**
	 * Constructor for Grid:
	 * takes only two arguments which determine the seize of the grid.
	 * @param width - width of the grid
	 * @param height - height of the grid
	 */
	public Grid(int width, int height){
		sizex = width;
		sizey = height;
		grid = new Node[sizex][sizey];
		for (int i = 0; i<sizex;i++){
			for (int j = 0; j<sizey; j++){
				grid[i][j] = new Node(false);
			}
		}
		randomInitialize();
		
	}
	
	/**Getter method used to return the node at a given point. 
	 * @param xpos
	 * @param ypos
	 * @return returns the Node object of the grid.
	 */
	public Node getNode(int xpos, int ypos){
		Node obj = grid[xpos][ypos];
		return obj;
	}
	
	public void processGrid(){
		for (int i=0; i<sizex; i++){
			for(int j = 0; j<sizey; j++){
				changeNodeState(i,j);
			}
		}
	}
	/**
	 * randomly selects a group of nodes and sets them to true
	 */
	public void randomInitialize(){
		Random rand = new Random();
		int initrange = sizex*sizey/5;
		int coordinates[][] = new int[initrange][2];
		for (int i = 0; i<initrange;i++){
			int n = rand.nextInt(sizex);
			coordinates[i][0] = n;
		}
		for (int j = 0; j<initrange;j++){
			int n = rand.nextInt(sizex);
			coordinates[j][1] = n;
		}
		for (int i = 0; i<initrange; i++){
			int xpos = coordinates[i][0];
			int ypos = coordinates[i][1];
			getNode(xpos,ypos).setState(true);
		}
	}
	
	public void findTrues(){
		for (int i=0;i<sizex;i++){
			for (int j=0; j<sizey;j++){
				if (getNode(i,j).getState()==true){
					System.out.print(i);
					System.out.print(", ");
					System.out.println(j);
				}
			}
		}
	}
	
	/**
	 * changes the state of the node at (xpos,ypos) based on its neighbors
	 * this looks at a node's four neighbors and then updates the node's state
	 * 
	 * @param xpos - x-coordinate
	 * @param ypos - y-coordinate
	 */
	private void changeNodeState(int xpos, int ypos){
		Node neighbors[] = findNeighbors(xpos, ypos);
		int accumulator = 0;
		for (int i = 0; i<4; i++){
			if (neighbors[i]!=null){
				if (neighbors[i].getState()) {accumulator++;}
			}
		}
		//Here is where the rules of the game are determined.
		if (accumulator <=1 || accumulator == 4){
			grid[xpos][ypos].setState(false);
		}
		else { grid[xpos][ypos].setState(true);}
	}
	
	/**
	 * returns a node's neighbors as an array of Node objects.
	 * @param xpos - x-coordinate of the node
	 * @param ypos - y-coordinate
	 * @return an array of the nodes as the neighbors (may contain null pointers)
	 */
	private Node[] findNeighbors(int xpos, int ypos){
		Node neighbors[] = new Node[4];
		addNeighbor(neighbors,0,xpos+1,ypos);
		addNeighbor(neighbors,1,xpos-1,ypos);
		addNeighbor(neighbors,2,xpos,ypos+1);
		addNeighbor(neighbors,3,xpos,ypos-1);
		return neighbors;
		
	}
	
	private void addNeighbor(Node array[], int index, int xpos, int ypos){
		//adds the node at xpos,ypos provided that the two are valid coordinates
		Node addNode;
		if (xpos<0 || xpos >=sizex){
			addNode = null;
		}
		else if (ypos<0||ypos>=sizey){
			addNode = null;
		}
		else{
			addNode = grid[xpos][ypos];
		}
		array[index] = addNode;
	}

}
