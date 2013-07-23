package droidsafe.runtime;

import java.util.Random;

import android.app.ContextImpl;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.IBinder;
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
		service.onCreate();
		Intent bindIntent = new Intent();
		service.onBind(bindIntent);
		service.onConfigurationChanged(new Configuration());
		service.onRebind(new Intent());
		service.onStart(new Intent(), 0);
		service.onStartCommand(new Intent(), 0, 0);
		service.onTaskRemoved(new Intent());
		service.onLowMemory();
		service.onTrimMemory(0);
		service.onUnbind(bindIntent);
		service.stopSelf(0);
		service.onDestroy();
	}
	
	public static void modelContentProvider(android.content.ContentProvider contentProvider) {
		contentProvider.onCreate();
		contentProvider.onConfigurationChanged(new Configuration());
		contentProvider.onLowMemory();
		contentProvider.onTrimMemory(0);
	}
	
	@DSModeled
	public static void modelBroadCastReceiver(BroadcastReceiver receiver) {
		receiver.onReceive(new ContextImpl(), new Intent());
	}
	
	@DSModeled(DSC.SPEC)
	public static void modelApplication(android.app.Application app) {
		while (true) {
			app.droidsafeOnCreate();
			app.droidsafeOnTerminate();
			app.droidsafeOnEverythingElse();
		}
		//code
	}
}
