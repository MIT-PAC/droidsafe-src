package java.lang;

import java.io.PrintStream;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSTaintObject;

public final class System {
	
	private static DSTaintObject taint = new DSTaintObject();
	
	public static final PrintStream err = null;
	public static final PrintStream out = null;
	
	@DSModeled(DSC.SAFE)
	public static String getProperty(String key) {
		taint.addTaint(key);
		return new String();
	}
	
	@DSModeled(DSC.SAFE)
	public static String getProperty(String key, String def) {
		taint.addTaints(key, def);
		return new String();
		
	}
	
	@DSModeled(DSC.SAFE)
	public static long currentTimeMillis() {
		return 0;
	}
}

