package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.os.Handler;
import android.os.IBinder;
import android.os.ServiceManager;
import android.util.Log;

public class NotificationManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.900 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.921 -0400", hash_original_method = "10DBF11C8E724C226D878C7C01FAA245", hash_generated_method = "6289F873941ED50FFDAC103DBA48290D")
      NotificationManager(Context context, Handler handler) {
        mContext = context;
        addTaint(handler.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.923 -0400", hash_original_method = "8A4CA4E7E43847BF1836AE50422D1EC2", hash_generated_method = "50B2FE1186CF8101034F9FCF8FC6A32F")
    public void notify(int id, Notification notification) {
        notify(null, id, notification);
        addTaint(id);
        addTaint(notification.getTaint());
        // ---------- Original Method ----------
        //notify(null, id, notification);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.951 -0400", hash_original_method = "825D6C1D97F576BD7D887B295C793809", hash_generated_method = "55932818FB8C8F9B84AF803EA0DBD73B")
    public void notify(String tag, int id, Notification notification) {
        int[] idOut;
        idOut = new int[1];
        INotificationManager service;
        service = getService();
        String pkg;
        pkg = mContext.getPackageName();
        try 
        {
            service.enqueueNotificationWithTag(pkg, tag, id, notification, idOut);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(tag.getTaint());
        addTaint(id);
        addTaint(notification.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.953 -0400", hash_original_method = "C3E2CA3977B6A0DFE40EA0B5D969CEEE", hash_generated_method = "E602EE1A45929109937348BE796AF928")
    public void cancel(int id) {
        cancel(null, id);
        addTaint(id);
        // ---------- Original Method ----------
        //cancel(null, id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.960 -0400", hash_original_method = "40D57D78EF425D9AA1571205DDC7CF63", hash_generated_method = "BAAAC1065C0647B05715A88D0E3E94E2")
    public void cancel(String tag, int id) {
        INotificationManager service;
        service = getService();
        String pkg;
        pkg = mContext.getPackageName();
        try 
        {
            service.cancelNotificationWithTag(pkg, tag, id);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(tag.getTaint());
        addTaint(id);
        // ---------- Original Method ----------
        //INotificationManager service = getService();
        //String pkg = mContext.getPackageName();
        //if (localLOGV) Log.v(TAG, pkg + ": cancel(" + id + ")");
        //try {
            //service.cancelNotificationWithTag(pkg, tag, id);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.980 -0400", hash_original_method = "755B5F96474649FA97E86F2D74D1F0A8", hash_generated_method = "F9A4957A4E5B91562A58A76DED9F21D1")
    public void cancelAll() {
        INotificationManager service;
        service = getService();
        String pkg;
        pkg = mContext.getPackageName();
        try 
        {
            service.cancelAllNotifications(pkg);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //INotificationManager service = getService();
        //String pkg = mContext.getPackageName();
        //if (localLOGV) Log.v(TAG, pkg + ": cancelAll()");
        //try {
            //service.cancelAllNotifications(pkg);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.980 -0400", hash_original_field = "C197B56EB13B668CA4D120F6F963B27C", hash_generated_field = "27F682BF44532AE8AD1AFBABEE87F231")

    private static String TAG = "NotificationManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.992 -0400", hash_original_field = "6225589B7095A2A8B4D13D7070C07695", hash_generated_field = "318E208AAF5321A27E7D01AA2760853C")

    private static boolean localLOGV = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.993 -0400", hash_original_field = "5B4BCAAF27A7649717520CAA43216111", hash_generated_field = "F81A4B790E53712C35BD5EDD5A7B2761")

    private static INotificationManager sService;
}

