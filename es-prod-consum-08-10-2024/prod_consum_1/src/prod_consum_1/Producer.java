package prod_consum_1;

public class Producer implements Runnable{
	Buffer buffer;
	int maxValue=1024;
	long maxWait=1000;
	long minwait=100;
	Producer(Buffer buffer){
		this.buffer=buffer;
	}
	
	public void run() {
		while(true) {
			int tempVal=(int)((double)maxValue * Math.random());;
			long tempWait=(long)(maxWait*Math.random());
			if(tempWait<100) {
				tempWait=100;
			}
			buffer.add(tempVal);
			try {
				Thread.sleep(tempWait);
			}catch(InterruptedException e) {
				System.err.println(Thread.currentThread().getName()+" interrupted while sleeping!");
			}
		}
	}
}
