package java.lang;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class Thread implements Runnable {
	private Runnable target = null;
	@DSModeled(DSC.SPEC)
	public Thread() {
	}
	
	@DSModeled(DSC.SPEC)
	public Thread(Runnable runnable, String threadName) { 
		this.target = runnable;
	}

	@DSModeled(DSC.SPEC)
	public synchronized void start() {
		if (this.target != null) {
			this.target.run();
		}
	}

	@DSModeled(DSC.SPEC)
	public void run() {
		if (this.target != null) {
			this.target.run();
		}
	}

	@DSModeled(DSC.SPEC)
	public static Thread currentThread() {
		return new Thread();
	}
	
	@DSModeled(DSC.SPEC)
	public static void sleep(long time) throws InterruptedException {
        
    }
	
}
