package droidsafe.helpers;

import android.content.Intent;
import android.net.Uri;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class DSUtils {
	public final static String UNKNOWN_STRING = "";
	public final static int UNKNOWN_INT = 0;
	public final static short UNKNOWN_SHORT = 0;
	public final static byte UNKNOWN_BYTE = 0;
	public final static long UNKNOWN_LONG = 0;
	public final static float UNKNOWN_FLOAT = 0;
	public final static double UNKNOWN_DOUBLE = 0;
	public static final boolean UNKNOWN_BOOLEAN = false;
	public static final char UNKNOWN_CHAR = 0;
	
	
	@DSModeled(DSC.BAN)
	public static void translateIntent(Intent orig, Intent result) {
		result.setAction(orig.getAction());
		result.setType(orig.getType());
    result.setPackage(orig.getPackage());

		if (orig.getData() == null)
			result.setData(Uri.parse("UNKNOWN"));
		else 
			result.setData(orig.getData());
		
		
	}
}
