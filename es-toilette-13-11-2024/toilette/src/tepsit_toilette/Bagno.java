package tepsit_toilette;
import java.util.concurrent.PriorityBlockingQueue;
public class Bagno implements Runnable{
	private 
	
	public void run() {
		Person currentPerson;
		while(true) {
			currentPerson=codaDonne.poll();
			if(currentPerson==null) {
				currentPerson=codaUomini.poll();
				if(currentPerson==null) {
					
				}
			}
		}
	}
}
