//MADE BY Alessandro Pasqualetti 5°AI, Sara Rossi 5°CI, Diego Ticciati 5°AI
package ballare_multi;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner myIn = new Scanner(System.in);
		int n=0;
		int maxGroup=0;
		int tempGroup; //helper for calculating random group size
		final int nFloors=4; //could also be input by user and would work fine
		//there needs to be at least one dancer/thread
		do {
			System.out.println("How many groups of dancers (threads) are there?");
			n = myIn.nextInt();
		}while(n<=0);
		//get max size of groups (at least 1)
		do {
			System.out.println("How big can these groups get?");
			maxGroup = myIn.nextInt();
		}while(maxGroup<=0);
		//make thread and object w/ runnable arrays
		DancerGroup[] Dancers = new DancerGroup[n];
		Thread[] Threads = new Thread[n];
		//make shared disco
		Floor[] copacabana = new Floor[nFloors];
		//fill disco array
		for(int i=0; i<nFloors; ++i) {
			copacabana[i]=new Floor();
		}
		//fill dancer arrays
		for(int i=0; i<n; ++i) {
			tempGroup= (int)((double)maxGroup*Math.random());
			tempGroup= tempGroup<1 ? 1 : tempGroup;
			Dancers[i] = new DancerGroup(copacabana,tempGroup);
			Threads[i] = new Thread(Dancers[i]);
		}
		//start threads
		for(Thread t : Threads) {
			t.start();
		}
		//until stopped:
		while(true) {
			try {
				Thread.sleep(500); //wait 500 ms
			}catch(Exception e) {
				System.err.println("Main thread interrupted!");
			}
			System.out.println("=====================================");
			for(int i=0; i<nFloors; ++i) {
				System.out.println("People in floor "+ (i+1) +": " + copacabana[i].getPeople());
			}
			
		}
	}

}
