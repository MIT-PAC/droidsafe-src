package droidsafe.runtime;

import java.util.Random;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;

import com.sun.corba.se.impl.corba.ContextImpl;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

/**
 * This class will simulate the android runtime system by making any calls or creating 
 * any globals required.
 * 
 * 
 * @author mgordon
 *
 */
public class DroidSafeAndroidRuntime {
	public static boolean control = new Random().nextBoolean();
	public static int switchControl = new Random().nextInt();

	@DSModeled(DSC.SPEC)
	/**
	 * This method will be called automatically by the droidsafe harness class before all
	 * application code.
	 * 	
	 * @param args
	 */
	public static void main() {
		
	}
	
	@DSModeled(DSC.SPEC)
	/**
	 * create any associated state and call init methods on an activity
	 * 
	 * call any life cycle events for the activity
	 * 
	 * @param activity
	 */
	public static void modelActivity(android.app.Activity activity) {
		ContextImpl context = new ContextImpl();
		
		while (true) {
			Bundle b = new Bundle();
			//onsavedinstancestate(b)
			activity.performCreate(b, context);
		
			
			activity.droidsafeOnResume();
			activity.droidsafeOnStop();
			activity.droidsafeOnDestroy();
		}
		
		//code
	}
	

	
	public static void modelService(android.app.Service service) {

	}
	
	public static void modelContentProvider(android.content.ContentProvider contentProvider) {
		
	}
	
	@DSModeled(DSC.SPEC)
	public static void modelBroadCastReceiver(BroadcastReceiver receiver) {
		receiver.onReceive(new ContextImpl(), new Intent());
	}
	
}
