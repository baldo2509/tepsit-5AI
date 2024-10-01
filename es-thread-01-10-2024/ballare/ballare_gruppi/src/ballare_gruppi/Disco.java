//MADE BY Alessandro Pasqualetti 5°AI, Sara Rossi 5°CI, Diego Ticciati 5°AI
package ballare_gruppi;

public class Disco {
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
