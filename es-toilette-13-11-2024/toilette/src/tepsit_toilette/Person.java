package tepsit_toilette;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;
public class Person{
	private char genere;
	private boolean inFila;
	//classe di libreria che implementa una coda con priorità thread safe
	//utilizzabile in un ambiente di tipo produttore/consumatore
	private fila fila;
	
	Person(){
		Random rand = new Random();
		if(rand.nextBoolean()) {
			genere='F';
		}else {
			genere='M';
		}
	}
	
	public void run() {
		while(true) {
			if(!inFila) {
				inFila=true;
				fila.put(this);
			}
		}
	}
	
}
