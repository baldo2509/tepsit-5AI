package stato_thread;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		int t, n;
		boolean allThreadsDead=false;
		final long sleepDuration = 1500;
		//getting values
		Scanner myIn = new Scanner(System.in);
		System.out.print("inserisci t: ");
		t = myIn.nextInt();
		System.out.print("inserisci n: ");
		n = myIn.nextInt();
		//making thread array
		Thread[] vThread = new Thread[t];
		Contatore[] vContatore = new Contatore[t];
		//tried doing this w/ foreach but runnable objects
		//don't get assigned to threads?
		//anyway regular for loop works fine
		//creating runnable objects and assigning them to
		//threads
		for(int i=0; i<t; ++i) {
			vContatore[i] = new Contatore(n);
			vThread[i]= new Thread(vContatore[i]);
		}
		//starting threads
		for(Thread i : vThread) {
			i.start();
		}
		//polling loop
		//there's probably a better way to do the condition
		while(!allThreadsDead) {
			//assume all threads are dead
			allThreadsDead=true;
			//wait a bit
			try {
				Thread.sleep(sleepDuration);
			}catch(Exception e) {
				System.err.println("Thread Interrotto");
			}
			//check status of all threads
			for(int i=0; i<t; ++i){
				//for convenience
				String tString = vThread[i].getName() + 
				" (" + String.format("%05d", vThread[i].getId()) + "): ";
				if(vThread[i].isAlive()) { 
					System.out.println(tString+ "arrivato a " + vContatore[i].getVal() + ";");
					//if we are here, at least one thread is alive
					allThreadsDead=false;
				}else{
					System.out.println(tString+ "COMPLETATO;");
				}
			}
		}
		//probably unneccessary since join() calls isAlive() internally, but just to be safe:
		//wait until all threads are sure to be dead
		for(Thread i : vThread) {
			try {
				i.join();
			}catch(Exception e) {
				System.out.println("Thread Interrotto");
			}
		}	
		System.out.println("TUTTI THREAD COMPLETATI");
		myIn.close();
	}

}
