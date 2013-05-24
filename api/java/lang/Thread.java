package java.lang;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class Thread implements Runnable {
	private Runnable target = null;
	@DSModeled(DSC.SAFE)
	public Thread() {
	}
	
	@DSModeled(DSC.SAFE)
	public Thread(Runnable runnable, String threadName) { 
		this.target = runnable;
	}

	@DSModeled(DSC.SAFE)
	public synchronized void start() {
		if (this.target != null) {
			this.target.run();
		}
	}

	@DSModeled(DSC.SAFE)
	public void run() {
		if (this.target != null) {
			this.target.run();
		}
	}

	@DSModeled(DSC.SAFE)
	public static Thread currentThread() {
		return new Thread();
	}
	
	@DSModeled(DSC.SAFE)
	public static void sleep(long time) throws InterruptedException {
        
    }
	
}
