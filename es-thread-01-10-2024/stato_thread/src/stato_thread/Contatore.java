package stato_thread;

public class Contatore implements Runnable {
	private int x=0;
	private int val=0;
	final private long sleepTime = 120L;
	Contatore(int n){
		x= (int)( (double) n * Math.random());
	}
	public int getVal(){
		return val;
	};
	public void run(){
		for(val=0; val<=x; ++val) {
			try {
				Thread.sleep((long) ((double) sleepTime * Math.random()));
			} catch(Exception e) {
				System.err.println("Thread Interrotto!");
			}
		}
		return;
	}
}
