package ballare_1;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner myIn = new Scanner(System.in);
		int n=0;
		//there needs to be at least one dancer/thread
		do {
		System.out.println("How many dancers(thread) are there?");
		n = myIn.nextInt();
		}while(n<=0);
		//make thread and object w/ runnable arrays
		Dancer[] Dancers = new Dancer[n];
		Thread[] Threads = new Thread[n];
		//make shared disco
		Disco copacabana = new Disco();
		//fill arrays
		for(int i=0; i<n; ++i) {
			Dancers[i] = new Dancer(copacabana);
			Threads[i] = new Thread(Dancers[i]);
		}
		//start threads
		for(Thread t : Threads) {
			t.start();
		}
		//until stopped:
		while(true) {
			try {
				Thread.sleep(1000); //wait one second
			}catch(Exception e) {
				System.err.println("Main thread interrupted!");
			}
			System.out.println("Number of people on the dancefloor:" + copacabana.getPeople());
		}
	}

}
