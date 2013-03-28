package droidsafe.runtime;

import droidsafe.annotations.*;
import android.app.ContextImpl;

/**
 * This class will simulate the android runtime system by making any calls or creating 
 * any globals required.
 * 
 * 
 * @author mgordon
 *
 */
public class DroidSafeAndroidRuntime {

	@DSModeled
	/**
	 * This method will be called automatically by the droidsafe harness class before all
	 * application code.
	 * 	
	 * @param args
	 */
	public static void main() {
		
	}
	
	@DSModeled
	/**
	 * create any associated state and call init methods on an activity
	 * @param activity
	 */
	public static void launchActivity(android.app.Activity activity) {
		ContextImpl context = new ContextImpl();
		activity.attach(context);	
	}
	
	/* at some point these should be created
	void launchService(android.app.Activity)
	void launchContentProvider(android.app.Activity)
	void launchBroadCastReceiver(android.app.Activity)
	*/
}
