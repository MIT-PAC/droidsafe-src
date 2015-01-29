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
	
	/**
	 * Use this method to translate one intent to another in a way that is
	 * dependent on the values resolved by attribute modeling.  This call is modeled 
	 * in the attribute modeling pass as well.
	 */
	@DSModeled(DSC.BAN)
	public static void translateIntent(Intent orig, Intent result) {
		result.setAction(orig.getAction());
		result.setType(orig.getType());
                result.setPackage(orig.getPackage());

                result.setData(orig.getData());
                //set the data field to the type field in the case there is no existing uri
                result.setData(Uri.parse(orig.getType()));
		
		//TODO: might need more here?
	}
}
