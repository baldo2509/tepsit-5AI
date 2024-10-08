package prod_consum_1;

public class Consumer implements Runnable {
	Buffer buffer;
	Consumer (Buffer buffer){
		this.buffer=buffer;
	}
	public void run() {
		int tempVal;
		int odd=0;
		int	even=0;
		int total=0;
		double pEven;
		double pOdd;
		while(true) {
			tempVal=buffer.take();
			total++;
			if(tempVal%2==0) {
				even++;
			}else {
				odd++;
			}
			pEven=((double)even/total)*100;
			pOdd=((double)odd/total)*100;
			System.out.printf("number: %d evens: %d odds: %d; percent evens: %3.2f percent odds %3.2f\n",tempVal, even, odd, pEven, pOdd);
		}
	}
}
