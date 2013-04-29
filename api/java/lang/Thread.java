package java.lang;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class Thread implements Runnable {
	@DSModeled(DSC.SAFE)
	public Thread() {
	}

	@DSModeled(DSC.SAFE)
	public synchronized void start() {
	}

	@DSModeled(DSC.SAFE)
	public void run() {
	}

	@DSModeled(DSC.SAFE)
	public static Thread currentThread() {
		return new Thread();
	}
}
