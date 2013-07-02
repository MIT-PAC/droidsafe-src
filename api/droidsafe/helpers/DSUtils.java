package droidsafe.helpers;

import android.content.Intent;
import android.net.Uri;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

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

                result.setData(orig.getData());
                //set the data field to the type field in the case there is no existing uri
                result.setData(Uri.parse(orig.getType()));
		
		//TODO: might need more here?
	}
}
