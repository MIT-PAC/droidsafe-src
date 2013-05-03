package java.lang;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSTaintObject;

public final class System {
	
	private static DSTaintObject taint = new DSTaintObject();
	
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
}

