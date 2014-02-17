package droidsafe.runtime;

import java.util.Random;

//Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.DSUtils;
import android.app.ContextImpl;
import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.IBinder;
import android.app.Application;
import android.app.Dialog;
import android.app.admin.DeviceAdminReceiver;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.view.MotionEvent;
import com.google.android.maps.MapActivity;

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
    private static Application mApplication;
    
    /**
     * This method will be called automatically by the droidsafe harness class before all
     * application code.
     * 	
     * @param args
     */
    public static void main() {

    }

    /**
     * create any associated state and call init methods on an activity
     * 
     * call any life cycle events for the activity
     * 
     * @param activity
     */
    
    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public static void modelActivity(android.app.Activity activity) {
        ContextImpl context = new ContextImpl();

        if (mApplication != null)
            activity.setApplication(mApplication);

        Bundle b = new Bundle();
        activity.performCreate(b, context);

        activity.onAttachedToWindow();
        activity.onWindowFocusChanged(true);

        // Call all public methods with no params
        activity.onBackPressed();
        activity.onContentChanged();
        activity.onCreateDescription();
        activity.onLowMemory();
        activity.onRetainNonConfigurationInstance();
        activity.onSearchRequested();
        activity.onUserInteraction();

        //TODO: DOES THIS MAKE SENSE? 
        //We should not change method's visiblity
        /*
        activity.onCreateDialog(0);
        activity.onCreateDialog(0, new Bundle());
        activity.onPrepareDialog(0, new Dialog(context));
        */
        
        /*
        //TODO: WHAT ABOUT A REAL MENU?  We moved to Activity's droidsafeOnOtherHook
        activity.onCreateOptionsMenu(null);
        activity.onPrepareOptionsMenu(null);
        activity.onCreateContextMenu(null, null, null);
        activity.onOptionsItemSelected(null);
        activity.onContextItemSelected(null);
        activity.dispatchTouchEvent(new MotionEvent());

        //activity.droidsafeOnKeyEvents();
        */
        activity.onConfigurationChanged(new Configuration());
        activity.droidsafeOnSavedInstanceState(new Bundle());
        
        activity.droidsafeOnResume();
        activity.droidsafeOnPause();
        
        ////////////////
        //Callback hooks specific for SubActivity classes
        //All subclass of Activity should implment this in the model
        //so that their callback will be called
        //Map, listview, expandblelist, etc...
        activity.droidsafeSubActivityCallbackHook();

        activity.droidsafeOnStop();

        activity.droidsafeOnRestart();
      
        activity.droidsafeOnDestroy();

        Bundle state = new Bundle();
        activity.droidsafePerformRestoreInstanceState(state);
        
        activity.onDetachedFromWindow();
        //Calls for MapActivity from mapping library
    }
    
    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public static void modelService(android.app.Service service) {
        if (mApplication != null)
            service.setApplication(mApplication);

        service.onCreate();
        for (IntentFilter filter : service.__ds__intentFilters) {
            for (Intent intent : DSUtils.getIntentFromFilter(filter)) {
                service.onBind(intent);
                service.onRebind(intent);
                service.onStart(intent, DSUtils.FAKE_INT);
                service.onTaskRemoved(intent);
                service.onStartCommand(intent, DSUtils.FAKE_INT, DSUtils.FAKE_INT);
                service.onUnbind(intent);
                if (service instanceof IntentService) {
                    ((IntentService) service).__ds__onHandleIntent(intent);
                }
            }
        }
        service.droidsafeOnSubServiceHook();
        service.onConfigurationChanged(new Configuration());
        service.onLowMemory();
        service.onTrimMemory(0);
        service.stopSelf(0);
        service.onDestroy();
    }
    
    //NOTE: active commands (query, delete, ..) are called to try to 
    //invoke provider code.  Real access happens in the Client code
    //and we need to conntect the Android ContentProviderClient with this.....
    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public static void modelContentProvider(android.content.ContentProvider contentProvider) {
        contentProvider.onCreate();
        contentProvider.onConfigurationChanged(new Configuration());
        contentProvider.onLowMemory();
        contentProvider.onTrimMemory(0);
        // Its not clear if we could figure out some of the value for these parameters
        contentProvider.query(null, null, null, null, null);
        contentProvider.insert(null, null);
        contentProvider.update(null, null, null, null);
        contentProvider.delete(null, null, null);
        contentProvider.getType(null);
    }

    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public static void modelBroadCastReceiver(BroadcastReceiver receiver) {        
        if (mApplication != null) {
            receiver.setApplication(mApplication);
            // callback receiver
            if (receiver instanceof android.app.admin.DeviceAdminReceiver) {
                DeviceAdminReceiver ar = (DeviceAdminReceiver) receiver;
                Intent appIntent = mApplication.droidsafeGetIntent();
                Context appContext = mApplication.getApplicationContext();
                ar.onDisableRequested(appContext, appIntent);
                ar.onDisabled(appContext, appIntent);
                ar.onEnabled(appContext, appIntent);
                ar.onPasswordChanged(appContext, appIntent);
                ar.onPasswordExpiring(appContext, appIntent);
                ar.onPasswordFailed(appContext, appIntent);
                ar.onPasswordSucceeded(appContext, appIntent);
            }

            if (receiver instanceof android.appwidget.AppWidgetProvider) {
                AppWidgetProvider aw = (AppWidgetProvider)receiver;
                Intent appIntent = mApplication.droidsafeGetIntent();
                Context appContext = mApplication.getApplicationContext();
                aw.onReceive(appContext, appIntent);
                aw.onEnabled(appContext);
                aw.onDisabled(appContext);
                int[] appWidgetIds = new int[1];
                appWidgetIds[0] = DSUtils.FAKE_INT;
                aw.onUpdate(appContext, AppWidgetManager.getInstance(appContext), appWidgetIds);
                aw.onDeleted(appContext, appWidgetIds);
            }
        }
    }
    
    public static void modelApplication(android.app.Application app) {
        mApplication = app;

        app.droidsafeOnCreate();
        app.droidsafeOnTerminate();
        app.droidsafeOnEverythingElse();
    }
}
