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
    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.482 -0400", hash_original_method = "10DBF11C8E724C226D878C7C01FAA245", hash_generated_method = "CB492EDE88143D0D0E8EAAE27A21E0FC")
    @DSModeled(DSC.SAFE)
     NotificationManager(Context context, Handler handler) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.483 -0400", hash_original_method = "8A4CA4E7E43847BF1836AE50422D1EC2", hash_generated_method = "36A12A5FD6BD91D75A276FEDD646136D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notify(int id, Notification notification) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(notification.dsTaint);
        notify(null, id, notification);
        // ---------- Original Method ----------
        //notify(null, id, notification);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.484 -0400", hash_original_method = "825D6C1D97F576BD7D887B295C793809", hash_generated_method = "1037757587C86FF927B3DF6624841F6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void notify(String tag, int id, Notification notification) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(tag);
        dsTaint.addTaint(notification.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.484 -0400", hash_original_method = "C3E2CA3977B6A0DFE40EA0B5D969CEEE", hash_generated_method = "E2124F2F57E983FE7B7D990FF4BA20CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void cancel(int id) {
        dsTaint.addTaint(id);
        cancel(null, id);
        // ---------- Original Method ----------
        //cancel(null, id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.485 -0400", hash_original_method = "40D57D78EF425D9AA1571205DDC7CF63", hash_generated_method = "61A7B2AD14A3191286D5E1B9A0DEE175")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void cancel(String tag, int id) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(tag);
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
        // ---------- Original Method ----------
        //INotificationManager service = getService();
        //String pkg = mContext.getPackageName();
        //if (localLOGV) Log.v(TAG, pkg + ": cancel(" + id + ")");
        //try {
            //service.cancelNotificationWithTag(pkg, tag, id);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.485 -0400", hash_original_method = "755B5F96474649FA97E86F2D74D1F0A8", hash_generated_method = "F9A4957A4E5B91562A58A76DED9F21D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    private static String TAG = "NotificationManager";
    private static boolean localLOGV = false;
    private static INotificationManager sService;
}

