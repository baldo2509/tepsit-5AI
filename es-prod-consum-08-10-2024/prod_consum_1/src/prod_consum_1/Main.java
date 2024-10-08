package prod_consum_1;
public class Main {

	public static void main(String[] args) {
	//buffer arbitrarily limited to 10 elements 	
	final int limit = 10;

	Buffer buffer = new Buffer(limit);
	Producer producer = new Producer(buffer);
	Consumer consumer = new Consumer(buffer);
	Thread tProducer = new Thread(producer);
	Thread tConsumer = new Thread(consumer);
	tProducer.start();
	tConsumer.start();
	}

}
