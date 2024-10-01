package ballare_multi;

public class DancerGroup implements Runnable{
	private Floor disco;
	private int groupSize;
	final private long maxWait = 5000L; //5 secondi
	DancerGroup(Floor disco, int groupSize){
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
