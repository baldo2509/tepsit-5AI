package ballare_multi;

public class DancerGroup implements Runnable{
	private Floor[] disco;
	private int groupSize;
	final private long maxWait = 5000L; //5 secondi
	DancerGroup(Floor[] disco, int groupSize){
		this.disco=disco;
		this.groupSize=groupSize;
	}
	public void run() {
		//with these vars, lenght of array (which is out of array bounds)
		//represents being OUTSIDE 
		int currentFloor=disco.length;
		int nextFloor;
		while(true) {
			//wait
			try {
				Thread.sleep((long)((double)maxWait*Math.random()));
			}catch(Exception E) {
				System.err.println(Thread.currentThread().getName()+" was interrupted!");
			}
			//if we are outside
			if(currentFloor==disco.length) {
				//pick which floor to go to next, excluding the outside
				nextFloor=(int)((double)disco.length * Math.random());
				
			}
			//if we are already inside
			else {
				//pick which floor to go to next, including the outside
				nextFloor=(int)((double)(disco.length+1) * Math.random());
				//whatever the outcome, leave current floor
				disco[currentFloor].exit(groupSize);
			}
			
			//if we didnt pick to go outside, enter next floor
			if(nextFloor!=disco.length) {
				disco[nextFloor].enter(groupSize);
			}
			//update current position
			currentFloor=nextFloor;
				
		}
	}
}
