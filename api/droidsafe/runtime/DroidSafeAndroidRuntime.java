package droidsafe.runtime;

import droidsafe.annotations.*;
import android.app.ContextImpl;
import android.content.BroadcastReceiver;
import android.os.Bundle;

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
	 * 
	 * call any life cycle events for the activity
	 * 
	 * @param activity
	 */
	public static void modelActivity(android.app.Activity activity) {
		ContextImpl context = new ContextImpl();
		activity.attach(context);
		
		while (true) {
			Bundle b = new Bundle();
			//onsavedinstancestate(b)
			activity.performCreate(b);
		
			
			
			activity.droidsafeOnStop();
		}
		
		//code
	}
	
	
	public static void modelService(android.app.Service service) {
		
	}
	
	public static void modelContentProvider(android.content.ContentProvider contentProvider) {
		
	}
	
	public static void modelBroadCastReceiver(BroadcastReceiver receiver) {
		
	}
	
}
