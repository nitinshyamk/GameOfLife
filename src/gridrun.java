
public class gridrun {

	public static void main(String[] args) {
		Grid testgrid = new Grid(20,20);
		testgrid.findTrues();
		System.out.println("First processing");
		testgrid.processGrid();
		testgrid.findTrues();
		System.out.println("second processing");
		testgrid.processGrid();
		testgrid.findTrues();
		System.out.println("third processing");
		testgrid.processGrid();
		testgrid.findTrues();
		System.out.println("fourth processing");
		testgrid.processGrid();
		testgrid.findTrues();
		System.out.println("fifth processing");
		testgrid.processGrid();
		testgrid.findTrues();
		System.out.println(testgrid.getNode(10,10).getState());
		System.out.println("Appears to be working");
	}

}
