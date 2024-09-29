package stato_thread;

public class Contatore implements Runnable {
	private int x=0;
	public int val=0;
	final private long sleepTime = 120L;
	Contatore(int n){
		x= (int)( (double) n * Math.random());
	}
	public void run(){
		for(val=0; val<=x; ++val) {
			try {
				Thread.sleep(sleepTime);
			} catch(Exception e) {
				System.err.println("Thread Interrotto!");
			}
		}
		return;
	}
}
