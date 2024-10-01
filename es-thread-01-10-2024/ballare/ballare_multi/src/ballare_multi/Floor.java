package ballare_multi;

public class Floor {
	private int people=0;
	
	public int getPeople() {
		return people;
	}
	//don't need synchronization as each thread can only enter a new floor
	//if it is not currently on any floor or by first exiting the floor
	//it is currently in; we can only assume this if the same thread calls both 
	//methods, as happens here 
	public void enter(int groupSize) {
		people+=groupSize;
	}
	
	public void exit(int groupSize) {
		people-=groupSize;
	}
}
