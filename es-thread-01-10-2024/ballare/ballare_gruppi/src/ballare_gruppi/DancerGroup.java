//MADE BY Alessandro Pasqualetti 5°AI, Sara Rossi 5°CI, Diego Ticciati 5°AI
package ballare_gruppi;

public class DancerGroup implements Runnable{
	private Disco disco;
	private int groupSize;
	final private long maxWait = 5000L; //5 secondi
	DancerGroup(Disco disco, int groupSize){
		this.disco=disco;
		this.groupSize=groupSize;
	}
	public void run() {
		while(true) {
			try {
				Thread.sleep((long)((double)maxWait*Math.random()));
			}catch(Exception E) {
				System.err.println(Thread.currentThread().getName()+" was interrupted!");
			}
			disco.enter(groupSize);
			try {
				Thread.sleep((long)((double)maxWait*Math.random()));
			}catch(Exception E) {
				System.err.println(Thread.currentThread().getName()+" was interrupted!");
			}
			disco.exit(groupSize);
		}
	}
}
