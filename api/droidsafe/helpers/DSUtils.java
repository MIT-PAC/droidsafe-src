package droidsafe.helpers;

import droidsafe.annotations.DSC;
import android.content.Intent;
import android.net.Uri;
import droidsafe.annotations.*;

public class DSUtils {
	public final static String UNKNOWN_STRING = "";
	
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

		if (orig.getData() == null)
			result.setData(Uri.parse("UNKNOWN"));
		else 
			result.setData(orig.getData());
		
		//TODO: might need more here?
	}
}
