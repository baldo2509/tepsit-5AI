package ballare_multi;

public class Floor {
	private int people=0;
	
	public int getPeople() {
		return people;
	}
	//don't need synchronization as single threads do both operations and are
	//locked into doing either one or the other, in order; we can never have
	// enter->enter->exit or other "broken" sequences
	public void enter(int groupSize) {
		people+=groupSize;
	}
	
	public void exit(int groupSize) {
		people-=groupSize;
	}
}
