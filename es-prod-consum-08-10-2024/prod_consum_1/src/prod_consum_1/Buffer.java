package prod_consum_1;
import java.util.LinkedList;
import java.util.Queue;	
public class Buffer{
	Queue<Integer> queue;
	int limit;
	Buffer(int limit){
		this.queue= new LinkedList<>();
		this.limit=limit;
	}
	public synchronized void add(Integer val) {
		if(queue.size()==limit) {
			
			try {
			wait();
			//System.out.println("Wait called while adding");
			}catch(InterruptedException e) {
				System.err.println(Thread.currentThread().getName()+" interrupted!");
			}
		}
		queue.add(val);
		notifyAll();
	}
	public synchronized Integer take() {
		if(queue.isEmpty()) {
			try {
				wait();
				//System.out.println("Wait called while taking");
			}catch(InterruptedException e) {
				System.err.println(Thread.currentThread().getName()+" interrupted!");
			}
		}
			int n=queue.remove();
			notifyAll();
			return n;
	}
}
