package android.app;

// Droidsafe Imports
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class NotificationManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.334 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.334 -0400", hash_original_method = "10DBF11C8E724C226D878C7C01FAA245", hash_generated_method = "8D0CAA0ED39B22FA8AE891F19E8043CF")
      NotificationManager(Context context, Handler handler) {
        addTaint(handler.getTaint());
        mContext = context;
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    static public INotificationManager getService() {
        if (sService != null) {
            return sService;
        }
        IBinder b = ServiceManager.getService("notification");
        sService = INotificationManager.Stub.asInterface(b);
        return sService;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.335 -0400", hash_original_method = "8A4CA4E7E43847BF1836AE50422D1EC2", hash_generated_method = "B5EB3785A6B07D3B04F28EB3962791A4")
    public void notify(int id, Notification notification) {
        addTaint(notification.getTaint());
        addTaint(id);
        notify(null, id, notification);
        // ---------- Original Method ----------
        //notify(null, id, notification);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.335 -0400", hash_original_method = "825D6C1D97F576BD7D887B295C793809", hash_generated_method = "C88EA1342B5E0E53060379DE912D9337")
    public void notify(String tag, int id, Notification notification) {
        addTaint(notification.getTaint());
        addTaint(id);
        addTaint(tag.getTaint());
        int[] idOut = new int[1];
        INotificationManager service = getService();
        String pkg = mContext.getPackageName();
        if(localLOGV){ }        try 
        {
            service.enqueueNotificationWithTag(pkg, tag, id, notification, idOut);
            if(id != idOut[0])            
            {
            } //End block
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //int[] idOut = new int[1];
        //INotificationManager service = getService();
        //String pkg = mContext.getPackageName();
        //if (localLOGV) Log.v(TAG, pkg + ": notify(" + id + ", " + notification + ")");
        //try {
            //service.enqueueNotificationWithTag(pkg, tag, id, notification, idOut);
            //if (id != idOut[0]) {
                //Log.w(TAG, "notify: id corrupted: sent " + id + ", got back " + idOut[0]);
            //}
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.336 -0400", hash_original_method = "C3E2CA3977B6A0DFE40EA0B5D969CEEE", hash_generated_method = "B4FE8F0698D984ABEB6334817C99606F")
    public void cancel(int id) {
        addTaint(id);
        cancel(null, id);
        // ---------- Original Method ----------
        //cancel(null, id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.336 -0400", hash_original_method = "40D57D78EF425D9AA1571205DDC7CF63", hash_generated_method = "1142C3278F2A4331F28F90D0F7CA7D7E")
    public void cancel(String tag, int id) {
        addTaint(id);
        addTaint(tag.getTaint());
        INotificationManager service = getService();
        String pkg = mContext.getPackageName();
        if(localLOGV){ }        try 
        {
            service.cancelNotificationWithTag(pkg, tag, id);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //INotificationManager service = getService();
        //String pkg = mContext.getPackageName();
        //if (localLOGV) Log.v(TAG, pkg + ": cancel(" + id + ")");
        //try {
            //service.cancelNotificationWithTag(pkg, tag, id);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.337 -0400", hash_original_method = "755B5F96474649FA97E86F2D74D1F0A8", hash_generated_method = "BC97B9420B51E2C81E74AEF4EDEAF77B")
    public void cancelAll() {
        INotificationManager service = getService();
        String pkg = mContext.getPackageName();
        if(localLOGV){ }        try 
        {
            service.cancelAllNotifications(pkg);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //INotificationManager service = getService();
        //String pkg = mContext.getPackageName();
        //if (localLOGV) Log.v(TAG, pkg + ": cancelAll()");
        //try {
            //service.cancelAllNotifications(pkg);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.337 -0400", hash_original_field = "C197B56EB13B668CA4D120F6F963B27C", hash_generated_field = "27F682BF44532AE8AD1AFBABEE87F231")

    private static String TAG = "NotificationManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.337 -0400", hash_original_field = "6225589B7095A2A8B4D13D7070C07695", hash_generated_field = "318E208AAF5321A27E7D01AA2760853C")

    private static boolean localLOGV = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:55.338 -0400", hash_original_field = "5B4BCAAF27A7649717520CAA43216111", hash_generated_field = "F81A4B790E53712C35BD5EDD5A7B2761")

    private static INotificationManager sService;
}

