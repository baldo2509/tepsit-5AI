package ballare_limit;

public class Disco {
	private int people=0;
	private final int limit=161;
	
	public int getPeople() {
		return people;
	}
	//as we need to check the limit each time, we need to synchronize
	//the enter and exit methods
	public synchronized void enter(int groupSize) {
		//if your group can't fit, wait, and when someone leaves
		//try again, hoping that there is now enough room for you
		while(people+groupSize>limit) {
			try {
				wait();
			}
			catch(Exception e) {
				System.err.println("Thread Interrupted!");
			}
		}
		people+=groupSize;
	}
	
	public synchronized void exit(int groupSize) {
		//when leaving, tell waiting threads to try again
		people-=groupSize;
		notifyAll();
	}
}
