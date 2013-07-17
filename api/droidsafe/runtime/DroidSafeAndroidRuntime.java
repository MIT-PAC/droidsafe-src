package droidsafe.runtime;

import java.util.Random;

import android.app.ContextImpl;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import droidsafe.annotations.*;


public class DroidSafeAndroidRuntime {
	public static boolean control = new Random().nextBoolean();
	public static int switchControl = new Random().nextInt();

	@DSModeled(DSC.SPEC)
	
	public static void main() {
		
	}
	
	
	@DSModeled(DSC.SPEC)
	public static void modelActivity(android.app.Activity activity) {
		ContextImpl context = new ContextImpl();
		
		while (true) {
			Bundle b = new Bundle();
			
			activity.performCreate(b, context);
		
			
			activity.droidsafeOnResume();
			activity.droidsafeOnStop();
			activity.droidsafeOnDestroy();
		}
		
		
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
