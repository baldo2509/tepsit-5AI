package ballare_1;

public class Dancer implements Runnable{
	private Disco disco;
	final private long maxWait = 5000L; //5 secondi
	Dancer(Disco disco){
		this.disco=disco;
	}
	public void run() {
		while(true) {
			try {
				Thread.sleep((long)((double)maxWait*Math.random()));
			}catch(Exception E) {
				System.err.println(Thread.currentThread().getName()+" was interrupted!");
			}
			disco.enter();
			try {
				Thread.sleep((long)((double)maxWait*Math.random()));
			}catch(Exception E) {
				System.err.println(Thread.currentThread().getName()+" was interrupted!");
			}
			disco.exit();
		}
	}
}
